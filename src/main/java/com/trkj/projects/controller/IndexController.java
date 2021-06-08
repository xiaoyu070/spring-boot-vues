package com.trkj.projects.controller;

import com.trkj.projects.exception.CustomError;
import com.trkj.projects.exception.CustomErrorType;
import com.trkj.projects.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {
    //@Autowired
    //private DeptService deptService;
    /*@PostMapping("/dept")
    public AjaxResponse addDept(@RequestBody @Valid DeptVo detpVo){
        log.info("开始插入数据");
        JpaDept jpaDept=new JpaDept();
        BeanUtils.copyProperties(detpVo,jpaDept);
        deptService.addJpaDept(jpaDept);
        MyDept myDept=new MyDept();
        BeanUtils.copyProperties(detpVo,myDept);
        myDept.setDeptno(myDept.getDeptno()+1);
        deptService.addMyDept(myDept);
        List<Object> list=new ArrayList<>();
        list.add(jpaDept);
        list.add(myDept);
        AjaxResponse response=AjaxResponse.success(list);
        return response;
    }*/


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResponse toError1(Exception ex){
        log.info("+++"+ex);
        ex.printStackTrace();
        CustomError error=new CustomError(CustomErrorType.SYSTEM_ERROR,ex.getMessage());
        AjaxResponse ajaxResponse=AjaxResponse.error(error);
        return ajaxResponse;
    }
}
