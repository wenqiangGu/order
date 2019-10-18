package com.gwq.order.controller;

import com.gwq.order.pojo.GoodList;
import com.gwq.order.pojo.MasterTable;
import com.gwq.order.pojo.Tabledetails;
import com.gwq.order.service.good.GoodService;
import com.gwq.order.service.master.MasterService;
import com.gwq.order.tool.Constants;
import com.gwq.order.tool.PageSupport;
import org.apache.commons.lang3.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BaseController {

    private Logger logger = Logger.getLogger(BaseController.class);

    @Resource
    private GoodService goodService;

    @Resource
    private MasterService masterService;

    //进入下单页面
    @RequestMapping(value = "/toAddHtml.html",method = RequestMethod.GET)
    public String toAddHtml(Model model){
        List<GoodList> goodList = goodService.getGoodList();

        //利用当前时间生成随机订单号
        Date date = new Date();
        String now = new SimpleDateFormat("yyyyMMdd").format(date);
        String ordernum = now+ RandomUtils.nextInt(0,1000);

        model.addAttribute("ordernum",ordernum);
        model.addAttribute("goodList",goodList);
        return "add";
    }

    //ajax获取当前商品信息
    @RequestMapping(value = "/getGood",method = RequestMethod.GET)
    @ResponseBody
    public GoodList getGood(String goodnum){
        return goodService.getGoodListByGoodNum(goodnum);
    }

    //ajax获取计算总金额
    @RequestMapping(value = "/countSum",method = RequestMethod.GET)
    @ResponseBody
    public Double countSum(Double price, Integer num){
        return price*num;
    }

    //处理添加订单页面
    @RequestMapping(value = "/doAddOrder.html",method = RequestMethod.POST)
    public String doAddOrder(MasterTable masterTable, Tabledetails tabledetails,
                             HttpSession session) throws Exception {
        System.out.println(masterTable);
        System.out.println(tabledetails);

        masterTable.setState(0);
        masterTable.setPaystate(0);
        masterTable.setCreatetime(new Date());

        GoodList goodList = goodService.getGoodListByGoodNum(tabledetails.getGoodnum());
        Integer stock = goodList.getStock()-tabledetails.getNum();
        String goodnum = tabledetails.getGoodnum();

        boolean flag = masterService.addMaster(masterTable,tabledetails,stock,goodnum);

        if (flag){
            session.setAttribute("result", "<script type=\"text/javascript\">window.onload=function(){alert(\"录入成功!\")}</script>");
            return "redirect:/toTableList.html";
        }else {
            session.setAttribute("result", "<script type=\"text/javascript\">window.onload=function(){alert(\"录入失败!\")}</script>");
            return "add";
        }
    }

    //进入订单列表页面
    @RequestMapping(value = "/toTableList.html")
    public String toTableList(String name,String goodnum,
                              Integer pageIndex,
                              Model model){


        //设置页面容量
        Integer pageSize = Constants.pageSize;
        logger.info(">>>>>>>>>>>页面容量为" + pageSize);

        //设置当前页码
        Integer currentPageNo = 1;
        if (pageIndex != null) {
            currentPageNo = pageIndex;
        }

        //获取到订单列表
        List<MasterTable> masterTableList = masterService.getMasterList(name,goodnum,currentPageNo,pageSize);

        //获取到商品列表
        List<GoodList> goodLists = goodService.getGoodList();


        //获取用户表总数据量
        Integer totalCount = masterService.getMasterListCount(name,goodnum);

        System.out.println(totalCount);
        //给分页工具设置属性
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        logger.info(">>>>>>>>>>>获取到的总数据量:" + totalCount);
        logger.info(">>>>>>>>>>>获取到的页面容量:" + pageSize);

        //获取总页数
        Integer totalPageCount = pages.getTotalPageCount();

        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }

        //向页面model中存放信息
        model.addAttribute("masterTableList", masterTableList);
        model.addAttribute("goodLists", goodLists);
        model.addAttribute("name", name);
        model.addAttribute("goodnum", goodnum);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPageNo", currentPageNo);
        model.addAttribute("totalCount", totalCount);

        return "tablelist";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOrder",method = RequestMethod.GET)
    public Map<String,String> deleteOrder(String ordernum) throws Exception {
        boolean flag = masterService.deleteOrder(ordernum);
        Map<String,String> map = new HashMap<String, String>();
        if (flag) {
            map.put("result","success");
        }else {
            map.put("result","fail");
        }
        return map;
    }

    //进入修改订单页面
    @RequestMapping(value = "/toUpdatePage.html",method = RequestMethod.GET)
    public String toUpdatePage(String ordernum,
                               Model model){
        MasterTable masterTable = masterService.getMasterTableByOrdernum(ordernum);

        List<GoodList> goodList = goodService.getGoodList();

        model.addAttribute("masterTable",masterTable);
        model.addAttribute("goodList",goodList);

        return "update";
    }

    //处理修改订单的处理器
    @RequestMapping(value = "/doUpdate.html")
    public String doUpdate(MasterTable masterTable,Tabledetails tabledetails,
                           HttpSession session) throws Exception {

        System.out.println(masterTable);
        System.out.println(tabledetails);
        masterTable.setUpdatetime(new Date());

        GoodList goodList = goodService.getGoodListByGoodNum(tabledetails.getGoodnum());
        System.out.println("***********"+goodList.getStock()+"\t"+
                tabledetails.getOriginalnum()+"\t"+
                tabledetails.getNum());

        Integer stock = goodList.getStock()+tabledetails.getOriginalnum()-tabledetails.getNum();
        String goodnum = tabledetails.getGoodnum();

        boolean flag = masterService.updateOrder(masterTable,tabledetails,stock,goodnum);

        if (flag){
            session.setAttribute("result", "<script type=\"text/javascript\">window.onload=function(){alert(\"修改成功!\")}</script>");
            return "redirect:/toTableList.html";
        }else {
            session.setAttribute("result", "<script type=\"text/javascript\">window.onload=function(){alert(\"修改失败!\")}</script>");
            return "update";
        }

    }

}
