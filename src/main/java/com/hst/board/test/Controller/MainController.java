package com.hst.board.test.Controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class MainController {
    
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
    
    
}