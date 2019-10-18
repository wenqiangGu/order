package com.gwq.order.dao.master;

import com.gwq.order.pojo.MasterTable;
import com.gwq.order.pojo.Tabledetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasterTableMapper {

    /**
     * 获取到订单列表
     * @return
     */
    List<MasterTable> getMasterList(@Param("name") String name,
                                    @Param("goodnum") String goodnum,
                                    @Param("pageIndex") Integer pageIndex,
                                    @Param("pageSize") Integer pageSize);


    /**
     * 获取当前列表数据量
     * @param name
     * @param goodnum
     * @return
     */
    int getMasterListCount(@Param("name") String name,
                           @Param("goodnum") String goodnum);

    /**
     * 向数据库中插入订单
     * @param masterTable
     * @return
     */
    int addMaster(MasterTable masterTable);
    int addTabledetails(Tabledetails tabledetails);

    /**
     * 删除订单
     * @param ordernum
     * @return
     */
    int deleteMaster(String ordernum);
    int deleteTabledetails(String ordernum);

    /**
     * 进入修改订单之前获取到的mastertable数据对象
     * @param ordernum
     * @return
     */
    MasterTable getMasterTableByOrdernum(String ordernum);

    /**
     * 修改订单
     * @param masterTable
     * @return
     */
    int updateMaster(MasterTable masterTable);
    int updateTabledetails(Tabledetails tabledetails);
}
