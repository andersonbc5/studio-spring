package com.backdevanderson.studiojoice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {

    private LocalDateTime timestamp;
    private Integer status;
    private String erro;
    private String msg;
    private String path;

}
