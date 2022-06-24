package com.selspring.kelvin.aop;

import com.selspring.kelvin.annotation.Window;
import com.selspring.kelvin.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    @Before("@target(window) && within(com.selspring..*)")
    public void before(Window window){
        this.switchService.switchByTitle(window.value());
    }
    @After("@target(window) && within(com.selspring..*)")
    public void after(Window window){
        this.switchService.switchByIndex(0);
    }
}
