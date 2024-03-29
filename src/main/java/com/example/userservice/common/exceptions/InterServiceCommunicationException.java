package com.example.userservice.common.exceptions;


import com.example.userservice.common.enums.ResponseMessage;

public class InterServiceCommunicationException extends CustomRootException {
    private static final String MESSAGE_CODE = "ERPS503";

    public InterServiceCommunicationException(ResponseMessage message) {
        super(MESSAGE_CODE, message.getResponseMessage());
    }

    public InterServiceCommunicationException(String messageKey) {
        super(MESSAGE_CODE, messageKey);
    }
}
