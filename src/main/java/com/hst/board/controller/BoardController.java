package com.hst.board.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hst.board.service.BoardService;
import com.hst.board.vo.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {
    @Autowired
    BoardService service;

    @GetMapping(value="/")
    public String Main() {
        return "ㅎㅇ";
    }

    @PostMapping(value="path")
    @ResponseBody
    public Map<String, Object> postMethodName() {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("id", 1);
        res.put("name", "홍승택");
        return res;
    }

    @PostMapping(value="/board/list")
    @ResponseBody
    public List<BoardVo> selectBoards() {

        try{
            return service.selectBoards(); 
        }catch(Exception e) {
            System.out.println(e.toString());
            return new ArrayList<BoardVo>();
        }
    }
    
    
}