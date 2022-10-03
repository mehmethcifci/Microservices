package org.mehmet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    LOGIN_ERROR(1000, "Username or password is wrong", INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_REQUIRED_PASSWORD(1001, "Inavalid password type, please enter valid password", INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_USERNAME_ERROR(1002, "Please valid an username",INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_USERNAME_DUPLICATE(1003, "Already this username is taken",INTERNAL_SERVER_ERROR),

    INVALID_TOKEN(2002,"Invalid token", INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
