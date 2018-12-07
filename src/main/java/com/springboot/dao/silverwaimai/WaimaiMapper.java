package com.springboot.dao.silverwaimai;

import com.springboot.entity.silverwaimai.Waimai;

public interface WaimaiMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Waimai record);

    int insertSelective(Waimai record);

    Waimai selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Waimai record);

    int updateByPrimaryKey(Waimai record);
}