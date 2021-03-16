package com.hst.board.service;

import java.util.List;

import com.hst.board.dao.BoardDao;
import com.hst.board.vo.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;

    public List<BoardVo> selectBoards() throws Exception {
        return boardDao.selectBoards();
    }
}
