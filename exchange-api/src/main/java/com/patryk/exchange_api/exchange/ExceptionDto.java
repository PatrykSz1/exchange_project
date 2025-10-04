package com.patryk.exchange_api.exchange;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class ExceptionDto {

    private final String timeStamp;
    private final int status;
    private final String message;
    private final String error;
    private final String path;
}
