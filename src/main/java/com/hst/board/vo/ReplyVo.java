package com.hst.board.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyVo {
    private int replyId;
    private int boardId;
    private String content;
    private Date insertDate;
}
