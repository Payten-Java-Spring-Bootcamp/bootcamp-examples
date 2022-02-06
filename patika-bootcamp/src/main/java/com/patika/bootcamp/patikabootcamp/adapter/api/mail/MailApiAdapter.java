package com.patika.bootcamp.patikabootcamp.adapter.api.mail;

import com.patika.bootcamp.patikabootcamp.domain.port.MailApiPort;
import org.springframework.stereotype.Service;

@Service
public class MailApiAdapter implements MailApiPort {

    @Override
    public void sendActivationMail(String mail, String message) {

    }
}
