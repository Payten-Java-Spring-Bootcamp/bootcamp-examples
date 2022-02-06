package com.patika.bootcamp.patikabootcamp.adapter.api.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentValidationResponse {

    private String mail;
    private PaymentState paymentState;

}
