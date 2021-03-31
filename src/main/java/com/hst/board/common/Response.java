package com.hst.board.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Response {
    private int resCode;
    private String msg;
    private Object data;
}
