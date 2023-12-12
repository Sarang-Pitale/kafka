package com.example.kafkademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMsgPublisher {
    @Autowired
    private KafkaTemplate<String,String> template;
public void sendMsgToTopic(String msg){
    template.send("payment",msg).whenComplete((result,ex)->{
        if(ex==null){
            System.out.println("offset"+result.getRecordMetadata().offset());
        }
        else{
            System.out.println("Exception"+ex);
        }
    });
}
}
