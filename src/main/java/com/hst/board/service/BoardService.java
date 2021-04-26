package com.hst.board.service;

import java.util.List;
import java.util.Map;

import com.hst.board.dao.BoardDao;
import com.hst.board.vo.BoardVo;
import com.hst.board.vo.ReplyVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;

    public List<BoardVo> selectBoardList(Map<String, Object> param) throws Exception {
        return boardDao.selectBoardList(param);
    }

    public int selectBoardsCnt(Map<String, Object> param) throws Exception {
        return boardDao.selectBoardsCnt(param);
    }

    public int addBoard(Map<String, Object> param) throws Exception {
        return boardDao.addBoard(param);
    }

    public BoardVo selectOne(Long boardId) throws Exception {
        return boardDao.selectOne(boardId);
    }

    public int delBoard(Map<String, Object> param) throws Exception {
        return boardDao.delBoard(param);
    }

    public int modBoard(Map<String, Object> param) throws Exception {
        return boardDao.modBoard(param);
    }

    public List<ReplyVo> selectReplyList(Long boardId) throws Exception {
        return boardDao.selectReplyList(boardId);
    }

    public int addReply(Map<String, Object> param) throws Exception {
        return boardDao.addReply(param);
    }

    public int modReply(Map<String, Object> param) throws Exception {
        return boardDao.modReply(param);
    }

    public int delReply(Map<String, Object> param) throws Exception {
        return boardDao.delReply(param);
    }
}