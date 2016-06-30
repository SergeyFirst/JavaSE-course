package com.company.entitys;

import java.lang.annotation.*;
import java.util.HashMap;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface DBAnnotation {
    String tableName() default "";
    String colomnName() default "";
    String getter() default "";
    String setter() default "";
    boolean isLinkedTable() default false;
}
