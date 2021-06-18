package com.trkj.projects.aspect;

import com.trkj.projects.anntation.Log;
import com.trkj.projects.mybatis.entity.Journal;
import com.trkj.projects.service.JournalService;
import com.trkj.projects.util.JacksonUtil;
import com.trkj.projects.util.JwtTokenUtil;



import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.trkj.projects.anntation.Log)")
    public void logPoinCut() {
    }
    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) throws UnknownHostException {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.
                        getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
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
            journal.setParamsname(value); //保存获取的操作
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
        //获取用户名
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof SysUser) {
//                SysUser u = (SysUser) principal;
//                operationlog.setOperator(u.getUserName());
//            }
//        }
        System.out.println("LogAspect::"+session.getAttribute("username"));
        journal.setUserName((String) session.getAttribute("username"));

        //获取用户ip地址
        String ip= InetAddress.getLocalHost().getHostAddress();
//      request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        journal.setAddressip(ip);
        System.out.println("sssssssss:"+journal.getFunctions());
        System.out.println("sssssssss:"+journal.getAddressip());
        System.out.println("sssssssss:"+journal.getParamslength());
        System.out.println("sssssssss:"+journal.getParamsname());
        System.out.println("sssssssss:"+journal.getUserName());
        //调用service保存SysLog实体类到数据库
        journalService.insert(journal);
    }

}