package com.example.xyq.ndp.consumerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * description: TestController <br>
 * date: 2020/11/27 16:48 <br>
 * author: xingyinqiang <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("test/{string}")
    public String test(@PathVariable String string) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8080/dataDict/getPageList", null,String.class);
    }
}
