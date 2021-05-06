package com.stackroute.SoulmateRESTservice.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoggerController {
    @GetMapping("/messages")
    public String getMessage(){
        log.info("This is Info msg");
        log.debug("This is debug msg");
        log.trace("This is trace msg");
        log.warn("This is warn msg");
        log.error("This is error msg");
        return "messages";
    }
}
