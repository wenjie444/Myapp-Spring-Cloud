package com.cortoon.controller;

import com.cortoon.entity.IocnAll;
import com.cortoon.service.IocnAllService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/iconAll")
public class IocnAllController {
    @Resource
    private IocnAllService iocnAllService;
    @GetMapping("/selectFindAll")
    public List<IocnAll> selectAllFind(){
        return iocnAllService.selectfindGet();
    }
}
