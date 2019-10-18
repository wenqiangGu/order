package com.gwq.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MasterTable {

  private Integer id;
  private String ordernum;
  private Integer state;
  private Integer paystate;
  private double totalsum;
  private String name;
  private String address;
  private String phone;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createtime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updatetime;

  //当前订单详情对象
  private GoodList goodList;

  //订单详情对象
  private Tabledetails tabledetails;

}
