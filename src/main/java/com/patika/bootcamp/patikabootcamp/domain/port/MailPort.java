package com.patika.bootcamp.patikabootcamp.domain.port;

public interface MailPort {

    void sendActivationMail(String mail, String message);
}
