package com.cortoon.controller;

import com.cortoon.entity.Classify;
import com.cortoon.service.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private ClassifyService classifyService;

    @GetMapping("/select")
    public List<Classify> allFind(){
        return classifyService.Get();
    }
}
