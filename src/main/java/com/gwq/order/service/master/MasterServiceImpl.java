package com.gwq.order.service.master;


import com.gwq.order.dao.good.GoodMapper;
import com.gwq.order.dao.master.MasterTableMapper;
import com.gwq.order.pojo.MasterTable;
import com.gwq.order.pojo.Tabledetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MasterServiceImpl implements MasterService{

    @Resource
    private MasterTableMapper masterTableMapper;

    @Resource
    private GoodMapper goodMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addMaster(MasterTable masterTable,Tabledetails tabledetails,
                             Integer stock,String goodnum) throws Exception {
        int num1 = masterTableMapper.addTabledetails(tabledetails);
        int num2 = masterTableMapper.addMaster(masterTable);
        int num3 = goodMapper.updateGoodStock(stock,goodnum);
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            throw new Exception("插入数据失败!");
        }
        return true;
//        throw new Exception("插入数据失败!");
    }

    @Override
    public List<MasterTable> getMasterList(String name, String goodnum, Integer pageIndex, Integer pageSize) {
        pageIndex = (pageIndex-1)*pageSize;
        return masterTableMapper.getMasterList(name,goodnum,pageIndex,pageSize);
    }

    @Override
    public int getMasterListCount(String name, String goodnum) {
        return masterTableMapper.getMasterListCount(name,goodnum);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOrder(String ordernum) throws Exception {
        int num1 = masterTableMapper.deleteMaster(ordernum);
        int num2 = masterTableMapper.deleteTabledetails(ordernum);

        if (num1 == 0 || num2 == 0) {
            throw new Exception("删除错误!数据回滚!");
        }
        return true;
    }

    @Override
    public MasterTable getMasterTableByOrdernum(String ordernum) {
        return masterTableMapper.getMasterTableByOrdernum(ordernum);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOrder(MasterTable masterTable, Tabledetails tabledetails,
                               Integer stock,String goodnum) throws Exception {


        int num1 = masterTableMapper.updateMaster(masterTable);
        int num2 = masterTableMapper.updateTabledetails(tabledetails);
        int num3 = goodMapper.updateGoodStock(stock,goodnum);

        if (num1 == 0 || num2 == 0 || num3 == 0) {
            throw new Exception("更改错误!");
        }
        return true;
    }


}
