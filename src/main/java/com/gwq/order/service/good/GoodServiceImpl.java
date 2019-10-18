package com.gwq.order.service.good;

import com.gwq.order.dao.good.GoodMapper;
import com.gwq.order.pojo.GoodList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService{

    @Resource
    private GoodMapper goodMapper;

    //获取到当前商品列表
    @Override
    public List<GoodList> getGoodList() {
        return goodMapper.getGoodList();
    }

    //获取到当前选中商品对象
    @Override
    public GoodList getGoodListByGoodNum(String goodnum) {
        return goodMapper.getGoodListByGoodNum(goodnum);
    }


}
