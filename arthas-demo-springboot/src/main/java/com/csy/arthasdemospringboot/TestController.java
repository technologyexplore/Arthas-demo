package com.csy.arthasdemospringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * test
 * 2019/6/5 17:37
 *
 * @author caishiyu
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @RequestMapping("hello")
    public String hello(@RequestParam String name) {
        log.info("调用hello,{}", name);
        return "hello " + name + "!";
    }

    @RequestMapping("add")
    public String add(@RequestParam int a, @RequestParam int b) {
        log.info("调用add,{},{}", a, b);
        return a + b + "";
    }
}
