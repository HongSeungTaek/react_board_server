package com.hst.board.dao;

import java.util.List;

import com.hst.board.vo.BoardVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDao {
    List<BoardVo> selectBoards() throws Exception;
}
