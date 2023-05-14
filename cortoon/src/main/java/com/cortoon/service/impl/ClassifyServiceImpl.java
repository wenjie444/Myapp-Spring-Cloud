package com.cortoon.service.impl;

import com.cortoon.entity.Classify;
import com.cortoon.mapper.ClassifyMapper;
import com.cortoon.service.ClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    public ClassifyMapper classifyMapper;
    @Override
    public List<Classify> Get() {
        return classifyMapper.select();
    }
}
