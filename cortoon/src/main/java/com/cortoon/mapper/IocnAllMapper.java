package com.cortoon.mapper;

import com.cortoon.entity.IocnAll;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IocnAllMapper {
    List<IocnAll> selectAll();
}
