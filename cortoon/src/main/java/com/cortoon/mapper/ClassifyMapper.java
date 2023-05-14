package com.cortoon.mapper;

import com.cortoon.entity.Classify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassifyMapper {
    List<Classify> select();
}
