package com.patika.bootcamp.patikabootcamp.adapter.api;

import com.patika.bootcamp.patikabootcamp.domain.port.MailPort;
import org.springframework.stereotype.Service;

@Service
public class MailAdapter implements MailPort {

    @Override
    public void sendActivationMail(String mail, String message) {

    }
}
