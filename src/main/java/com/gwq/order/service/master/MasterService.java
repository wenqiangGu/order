package com.gwq.order.service.master;


import com.gwq.order.pojo.MasterTable;
import com.gwq.order.pojo.Tabledetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasterService {

    /**
     * 向数据库中插入订单
     * @param masterTable
     * @return
     */
    boolean addMaster(MasterTable masterTable,Tabledetails tabledetails,
                      Integer stock,String goodnum) throws Exception;

    /**
     * 获取到订单列表
     * @return
     */
    List<MasterTable> getMasterList(String name,String goodnum,
                                    Integer pageIndex,Integer pageSize);

    /**
     * 获取当前列表数据量
     * @param name
     * @param goodnum
     * @return
     */
    int getMasterListCount(String name,String goodnum);

    /**
     * 删除订单数据
     * @param ordernum
     * @return
     */
    boolean deleteOrder(String ordernum) throws Exception;

    /**
     * 进入修改订单之前获取到的mastertable数据对象
     * @param ordernum
     * @return
     */
    MasterTable getMasterTableByOrdernum(String ordernum);

    //修改订单
    public boolean updateOrder(MasterTable masterTable,Tabledetails tabledetails,
                               Integer stock,String goodnum) throws Exception;
}
