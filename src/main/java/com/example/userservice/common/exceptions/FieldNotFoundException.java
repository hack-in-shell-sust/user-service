package com.example.userservice.common.exceptions;


import com.example.userservice.common.enums.ResponseMessage;

public class FieldNotFoundException extends CustomRootException {
    private static final String MESSAGE_CODE = "RT410";

    public FieldNotFoundException(ResponseMessage message) {
        super(MESSAGE_CODE, message.getResponseMessage());
    }

    public FieldNotFoundException(String messageKey) {
        super(MESSAGE_CODE, messageKey);
    }

}
