package com.hst.board.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hst.board.common.Response;
import com.hst.board.constans.Const;
import com.hst.board.service.BoardService;
import com.hst.board.vo.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {
    @Autowired
    BoardService service;

    @PostMapping(value="/board/list")
    @ResponseBody
    public Map<String, Object> selectBoards(@RequestBody Map<String, Object> param) {
        Map<String, Object> res = new HashMap<String, Object>();
        
        try{
            res.put("totalCnt", service.selectBoardsCnt(param));
            res.put("list", service.selectBoards(param));
        }catch(Exception e) {
            System.out.println(e.toString());
            res = new HashMap<String, Object>();
            res.put("totalCnt", 0);
            res.put("list", new ArrayList<BoardVo>());
        }
        return res;
    }

    @PostMapping(value="/board/add")
    @ResponseBody
    public Response addBoard(@RequestBody Map<String, Object> param) {
        Response res = new Response();
        
        try{
            service.addBoard(param);
            res.setResCode(Const.RESPONSE_SUCCESS);
        }catch(Exception e) {
            res.setResCode(Const.RESPONSE_FAIL);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @GetMapping(value="/board/{boardId}")
    @ResponseBody
    public Response selectOne(@PathVariable Long boardId) {
        Response res = new Response();
        
        try{
            res.setData(service.selectOne(boardId));
            res.setResCode(Const.RESPONSE_SUCCESS);
        }catch(Exception e) {
            res.setResCode(Const.RESPONSE_FAIL);
            res.setMsg(e.getMessage());
        }
        return res;
    }
    
    
}