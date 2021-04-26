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
    public Map<String, Object> selectBoardList(@RequestBody Map<String, Object> param) {
        Map<String, Object> res = new HashMap<String, Object>();
        
        try{
            res.put("totalCnt", service.selectBoardsCnt(param));
            res.put("list", service.selectBoardList(param));
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
            BoardVo vo = service.selectOne(boardId);
            if(vo != null) {
                vo.setReplyList(service.selectReplyList(boardId));
            } 
            res.setData(vo);
            res.setResCode(Const.RESPONSE_SUCCESS);
        }catch(Exception e) {
            res.setResCode(Const.RESPONSE_FAIL);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @PostMapping(value="/board/del")
    @ResponseBody
    public Response delBoard(@RequestBody Map<String, Object> param) {
        Response res = new Response();
        
        try{
            service.delBoard(param);
            res.setResCode(Const.RESPONSE_SUCCESS);
        }catch(Exception e) {
            res.setResCode(Const.RESPONSE_FAIL);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @PostMapping(value="/board/mod")
    @ResponseBody
    public Response modBoard(@RequestBody Map<String, Object> param) {
        Response res = new Response();
        
        try{
            service.modBoard(param);
            res.setResCode(Const.RESPONSE_SUCCESS);
        }catch(Exception e) {
            res.setResCode(Const.RESPONSE_FAIL);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @PostMapping(value="/reply/add")
    @ResponseBody
    public Response addReply(@RequestBody Map<String, Object> param) {
        Response res = new Response();
        
        try{
            service.addReply(param);
            res.setResCode(Const.RESPONSE_SUCCESS);
        }catch(Exception e) {
            res.setResCode(Const.RESPONSE_FAIL);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @PostMapping(value="/reply/mod")
    @ResponseBody
    public Response modReply(@RequestBody Map<String, Object> param) {
        Response res = new Response();
        
        try{
            service.modReply(param);
            res.setResCode(Const.RESPONSE_SUCCESS);
        }catch(Exception e) {
            res.setResCode(Const.RESPONSE_FAIL);
            res.setMsg(e.getMessage());
        }
        return res;
    }

    @PostMapping(value="/reply/del")
    @ResponseBody
    public Response delReply(@RequestBody Map<String, Object> param) {
        Response res = new Response();
        
        try{
            service.delReply(param);
            res.setResCode(Const.RESPONSE_SUCCESS);
        }catch(Exception e) {
            res.setResCode(Const.RESPONSE_FAIL);
            res.setMsg(e.getMessage());
        }
        return res;
    }
    
    
}