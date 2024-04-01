package com.longyan.service.impl;

import com.longyan.mapper.RankMapper;
import com.longyan.pojo.Rank;
import com.longyan.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper rankMapper;

    @Override
    public List<Rank> getRank(Integer attribute, Integer type) {
        List<Rank> rank = rankMapper.getRank(attribute, type);
        return rank;
    }
}
