package com.hst.board.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVo {
    private int boardId;
    private String title;
    private String content;
    private Date insertDate;
}
