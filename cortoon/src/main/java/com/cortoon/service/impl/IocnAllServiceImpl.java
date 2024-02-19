package com.cortoon.service.impl;

import com.cortoon.entity.IocnAll;
import com.cortoon.mapper.IocnAllMapper;
import com.cortoon.service.IocnAllService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IocnAllServiceImpl implements IocnAllService {
    @Resource
    private IocnAllMapper iocnAllMapper;

    @Override
    public List<IocnAll> selectfindGet() {
        return iocnAllMapper.selectAll();
    }
}
