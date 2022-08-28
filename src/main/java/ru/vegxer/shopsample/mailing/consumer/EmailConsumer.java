package ru.vegxer.shopsample.mailing.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.vegxer.shopsample.mailing.bean.EmailActivationMessage;
import ru.vegxer.shopsample.mailing.service.EmailService;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class EmailConsumer {
    private final EmailService emailService;
    private static final ObjectMapper mapper = new ObjectMapper();

    @JmsListener(destination = "${app.artemis.topic}")
    public void sendEmail(String message) throws MessagingException, IOException {
        emailService.sendMessage(
            mapper.readValue(message, EmailActivationMessage.class)
        );
    }
}
