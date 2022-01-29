package com.patika.bootcamp.patikabootcamp.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {

    GENERIC_EXCEPTION(1, "Bilinmeyen bir sorun oluştur"),

    MOVIE_DATA_NOT_FOUND(1001, "Film bulunamadı"),
    ACTOR_DATA_NOT_FOUND(1002, "Oyuncu bulunamadı"),
    RATE_DATA_NOT_FOUND(1003, "Puanlama bulunamadı"),

    COLLECTION_SIZE_EXCEPTION(2001, "Liste boyutları uyuşmuyor");

    private final Integer code;
    private final String message;
}
