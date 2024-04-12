package com.longyan.controller;

import com.longyan.pojo.Rank;
import com.longyan.pojo.Result;
import com.longyan.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranks")
public class RankController {

    @Autowired
    private RankService rankService;

    @GetMapping("/{attribute}/{type}")
    public Result<List<Rank>> getRank(@PathVariable Integer attribute, @PathVariable Integer type) {
        List<Rank> rank = rankService.getRank(attribute, type);
        return Result.success(rank);
    }
}
