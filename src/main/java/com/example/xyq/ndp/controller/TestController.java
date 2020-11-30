package com.example.xyq.ndp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: TestController <br>
 * date: 2020/11/25 16:15 <br>
 * author: xingyinqiang <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/test")
@RefreshScope
@Slf4j
public class TestController {

    //@Value("${service.name}")
    public String serviceName;

    @RequestMapping("/test")
    public String test(){
        log.info("aaaaaaaaaa=={}",serviceName);
        return serviceName;
    }
}
