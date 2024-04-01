package com.longyan.service;

import com.longyan.pojo.Rank;

import java.util.List;

public interface RankService {

    /**
     * @param attribute 排名类型：世界排名1,奥运积分排名2,总决赛积分3,世界青年排名4
     * @param type      排名种类：男单6,女单7,男双8,女双9,混双10
     * @return 排名的列表
     */
    List<Rank> getRank(Integer attribute, Integer type);
}
