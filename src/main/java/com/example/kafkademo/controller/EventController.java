package com.example.kafkademo.controller;

import com.example.kafkademo.service.KafkaMsgPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    KafkaMsgPublisher publisher;

    @GetMapping("/publish/{msg}")
    void publishMsg(@PathVariable String msg) {
        try {
            System.out.println("@@@"+msg);
            publisher.sendMsgToTopic(msg);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
