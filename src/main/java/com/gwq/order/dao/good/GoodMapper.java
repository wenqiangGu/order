package com.gwq.order.dao.good;

import com.gwq.order.pojo.GoodList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodMapper {

    /**
     * 获取到当前商品列表
     * @return
     */
    List<GoodList> getGoodList();

    /**
     * 通过商品编号获得商品对象
     * @param goodNum
     * @return
     */
    GoodList getGoodListByGoodNum(String goodNum);

    /**
     * 下单之后去更改商品库存
     * @param stock
     * @return
     */
    int updateGoodStock(@Param("stock") Integer stock,
                        @Param("goodnum") String goodnum);
}
