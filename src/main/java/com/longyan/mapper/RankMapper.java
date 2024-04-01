package com.longyan.mapper;

import com.longyan.pojo.Rank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RankMapper {

    @Select("select * from ranking where attribute=#{attribute} and type=#{type};")
    List<Rank> getRank(Integer attribute, Integer type);
}
