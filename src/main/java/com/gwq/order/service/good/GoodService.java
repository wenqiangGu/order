package com.gwq.order.service.good;


import com.gwq.order.pojo.GoodList;
import com.gwq.order.pojo.MasterTable;
import com.gwq.order.pojo.Tabledetails;

import java.util.List;

public interface GoodService {
    List<GoodList> getGoodList();

    GoodList getGoodListByGoodNum(String goodnum);


}
