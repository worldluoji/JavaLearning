package com.jvm.demo.gcdemo1.controllers;

import com.jvm.demo.gcdemo1.models.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

@Slf4j
@RestController
public class GcTestController {
    private static final int CLEAR_LIMIT = 200000;
    private Queue<Greeting> objCache = new LinkedBlockingDeque<>();
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting() {
        log.info("greeting greeting greeting");
        Greeting greeting = new Greeting("Hello World!!!");;
        if (objCache.size() > CLEAR_LIMIT) {
            objCache.clear();
        } else {
            objCache.add(greeting);
        }
        return greeting;
    }
}
