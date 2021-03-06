package com.patika.bootcamp.patikabootcamp.adapter.api.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentState {
    WAITING(false),
    REJECTED(false),
    APPROVED(true);

    private final boolean result;
}
