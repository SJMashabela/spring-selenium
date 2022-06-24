package com.selspring.kelvin.annotation;

import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TakeScreenshot {
}
