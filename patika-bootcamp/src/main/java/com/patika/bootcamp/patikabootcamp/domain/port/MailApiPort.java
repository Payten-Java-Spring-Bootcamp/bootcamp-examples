package com.patika.bootcamp.patikabootcamp.domain.port;

public interface MailApiPort {

    void sendActivationMail(String mail, String message);
}
