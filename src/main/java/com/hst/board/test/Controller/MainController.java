package com.hst.board.test.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MainController {
    
    @GetMapping(value="/")
    public String Main() {
        return "ㅎㅇ";
    }
    
}