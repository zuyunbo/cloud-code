package com.cloud.datacontrol.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SimpleBatchHandlerTest {

    @Autowired
    private SimpleBatchHandler simpleBatchHandler;

    @GetMapping
    public void test() {
        simpleBatchHandler.startHandle();
    }
}
