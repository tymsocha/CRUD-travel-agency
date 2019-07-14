package com.kodilla.travelagency.scheduler;

import com.kodilla.travelagency.business.trip.dao.TripDAO;
import com.kodilla.travelagency.configuration.AdminConfig;
import com.kodilla.travelagency.emailservice.Mail;
import com.kodilla.travelagency.emailservice.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TripReminderScheduler {
    @Autowired
    private MailService mailService;

    @Autowired
    private TripDAO tripDAO;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(fixedDelay = 100000000)
    public void sendInformationEmail() {
        /*long size = .count();
        mailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: " + size + checkIfOneOrMoreTasks(size),
                "")
        );**/
    }

    private String checkIfOneOrMoreTasks(long size) {
        if (size == 1) return " task";
        else return " tasks";
    }
}
