package ru.vegxer.shopsample.mailing.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class EmailConsumer {

    @JmsListener(destination = "${app.artemis.topic}")
    public void sendEmail(Message message) {
        System.out.println("DKLFSDUIGHUIOSEGJIEDGKIMJEGMSRGJK:JDGL:");
    }
}
