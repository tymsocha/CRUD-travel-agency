package com.kodilla.travelagency.emailservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean send(final Mail mail) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        try {
            javaMailSender.send(createMailMessage(mail));
            log.info("Email has been sent to: " + mail.getMailTo());
            return true;
        } catch (MailException e) {
            log.error("Failed to process email sending: ", e.getMessage(), e);
            return false;
        }
    }

    private SimpleMailMessage createMailMessage(final Mail mail) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        if (mail.getToCC() != null) {
            mailMessage.setCc(mail.getToCC());
        }
        return mailMessage;
    }
}
