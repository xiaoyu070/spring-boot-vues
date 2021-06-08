package com.trkj.projects.util;



import com.trkj.projects.exception.CustomError;
import com.trkj.projects.exception.CustomErrorType;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BeanTools extends BeanUtils {
    public static void copyList(List sourceList, List targetList,Class targetClass) {
        if ((!Objects.isNull(sourceList)) && (!Objects.isNull(targetList))) {
            sourceList.forEach(item -> {
                try {
                    Object data = targetClass.newInstance();
                    BeanUtils.copyProperties(item, data);
                    targetList.add(data);
                } catch (InstantiationException e) {
                    throw new CustomError(CustomErrorType.OTHER_ERROR,"实例化对象出错！");
                } catch (IllegalAccessException e) {
                    throw new CustomError(CustomErrorType.OTHER_ERROR,"没有权限访问对象私有属性或方法！");
                }
            });
        }
    }
}
