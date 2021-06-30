package com.trkj.projects.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.trkj.projects.anntation.Log;
import com.trkj.projects.mybatis.entity.Journal;
import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.service.JournalService;
import com.trkj.projects.service.SysUserService;
import com.trkj.projects.util.JacksonUtil;
import com.trkj.projects.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private JournalService journalService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private static String username;
    //.service.SysUserService.findByNames
    @Pointcut("execution(public * com.trkj.projects.controller.SysUserController.getChildrens(..))")
    public void webLog(){
        // this.
    }
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        String xx=JSONObject.toJSONString(joinPoint.getArgs());
        Object[] str = joinPoint.getArgs();
        System.out.println("xxxx::"+xx);
        int index=xx.indexOf("userName");
        int index2=xx.indexOf('"'+","+'"'+"userPass");
        String cha=xx.substring(index+11,index2);
        username = cha;
    }
    @Pointcut("execution(public * com.trkj.projects.controller.SysUserController.queryByPhoneandCode(..))")
    public void webLog1(){
        // this.
    }
    @Before("webLog1()")
    public void doBefore1(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        String xx=JSONObject.toJSONString(joinPoint.getArgs());
        Object[] str = joinPoint.getArgs();
        SysUser sysUser=this.sysUserService.findByPhone(str[0].toString());
        username = sysUser.getUserName();
        System.out.println("Before:sys:"+sysUser.toString());
        userId = sysUser.getUserId();
    }

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.trkj.projects.anntation.Log)")
    public void logPoinCut() {

    }
    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) throws UnknownHostException {
        System.out.println("进入切面:::::::::::::::::::::::");
        //保存日志
        Journal journal = new Journal();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作
        Log myLog = method.getAnnotation(Log.class);
        if (myLog != null) {
            String value = myLog.value();
            journal.setParamsname(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        journal.setFunctions(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params=null;
        try {
            params = JacksonUtil.obj2json(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        journal.setParamslength(params.length()+"");
        //获取操作时间
        journal.setCreateDate(new Date());


        journal.setUserName(username);
        journal.setUserId(userId);
        //获取用户ip地址
        String ip= InetAddress.getLocalHost().getHostAddress();
//         request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//      request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        journal.setAddressip(ip);
        //调用service保存SysLog实体类到数据库
        //journalService.insert(journal);
<<<<<<< HEAD
=======
        System.out.println("userid"+userId);
        journalService.insert(journal);
>>>>>>> ef460b4a47dc95733da782600bc231f279cdb049
    }

}