package com.hst.board.dao;

import java.util.List;
import java.util.Map;

import com.hst.board.vo.BoardVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDao {
    List<BoardVo> selectBoards(Map<String, Object> param) throws Exception;
    int selectBoardsCnt(Map<String, Object> param) throws Exception;
    int addBoard(Map<String, Object> param) throws Exception;
    BoardVo selectOne(Long boardId) throws Exception;
    int delBoard(Map<String, Object> param) throws Exception;
    int modBoard(Map<String, Object> param) throws Exception;
}
