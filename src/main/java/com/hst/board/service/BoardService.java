package com.hst.board.service;

import java.util.List;
import java.util.Map;

import com.hst.board.dao.BoardDao;
import com.hst.board.vo.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;

    public List<BoardVo> selectBoards(Map<String, Object> param) throws Exception {
        return boardDao.selectBoards(param);
    }

    public int selectBoardsCnt(Map<String, Object> param) throws Exception {
        return boardDao.selectBoardsCnt(param);
    }

    public int addBoard(Map<String, Object> param) throws Exception {
        return boardDao.addBoard(param);
    }
}