package com.spiringfundamentos.platzi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerTest {
    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("hola desde el controller, todo va bein",HttpStatus.OK);
    }
}
