package com.oocl.dataprovider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by weiro on 2018/1/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExternalFile {

  Format format();

  String value();

  Class clazz();

  boolean isArray() default false;

  public enum Format {
    CSV,
    XML,
    JSON,
    XLS;
  }
}
