package ru.vegxer.shopsample.mailing.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import ru.vegxer.shopsample.mailing.bean.EmailActivationMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class EmailService {
    private final static String EMAIL_TEMPLATE_PATH = "/templates/email.html";

    private final JavaMailSender mailSender;

    public void sendMessage(final EmailActivationMessage activationMessage) throws MessagingException, IOException {
        val mimeMessage = mailSender.createMimeMessage();
        val helper = new MimeMessageHelper(mimeMessage, "utf-8");
        try (val is = getClass().getResourceAsStream(EMAIL_TEMPLATE_PATH)) {
            helper.setText(String.format(
                new String(is.readAllBytes(), StandardCharsets.UTF_8),
                activationMessage.getActivationLink()), true);
        }
        helper.setTo(activationMessage.getEmail());
        helper.setSubject("Подтверждение email shop-sample.vegxer.ru");
        mailSender.send(mimeMessage);
    }
}
