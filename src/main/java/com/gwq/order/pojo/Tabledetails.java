package com.gwq.order.pojo;

import lombok.Data;

@Data
public class Tabledetails {

  private Integer id;
  private String ordernum;
  private String goodnum;
  private String goodname;
  private double price;
  private Integer num;

  private Integer originalnum;

}
