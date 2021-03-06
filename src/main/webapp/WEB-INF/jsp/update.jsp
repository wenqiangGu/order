<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>下单页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/show.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/mine.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/add.js"></script>
    <script type="text/javascript" src="/statics/js/adddate.js"></script>
    <style>
        label {
            float: left;
            width: 10em;
            margin-right: 1em;
            text-align: right;
        }

        .form_div {
            width: 80%;
            display: inline-block;
        }

        .form-group {
            margin-bottom: 10px;
        }

        .form-control {
            margin: 0;
            width: 50%;
            display: inline-block;
        }

        .right_box {
            padding: 5px 0;
        }

        .ibox-content .control-label {
            width: 13%;

        }

    </style>
</head>
<body>
<div id="box">

    <div id="right_width" class="right_show">
        <div class="right_wrap">
            <div class="show_title"><p>修改订单</p></div>
            <Div class="right_box">
                <div class="right_topBar">

                </div>
                <div class="ibox-content">
                    <form action="${pageContext.request.contextPath }/doUpdate.html"
                          class="form-horizontal" method="post">
                        <div style="width: 70%;overflow: hidden;float: left;">
                            <div class="form-group" style="margin-left: 0;">
                                <label class="control-label" style="font-size: 18px">订单编号：</label>
                                <div class="form_div" style="padding-left: 0; font-size: 18px">
                                    <input class="form-control" style="font-size: 18px" type="text" data-val="true"
                                           placeholder="" name="ordernum" value="${masterTable.ordernum}" id="ordernum" readonly>
                                    <span></span>

                                </div>
                            </div>

                            <div class="form-group" style="margin-left: 0;">
                                <label class="control-label" style="font-size: 18px">请选择商品：</label>
                                <div class="form_div" style="padding-left: 0;">
                                    <select class="select2_demo_1 form-control" style="font-size: 18px" name="goodnum" id="goodnum">
                                        <option value="-1">请选择</option>
                                        <c:forEach items="${goodList}" var="good">
                                            <option
                                                    <c:if test="${masterTable.tabledetails.goodnum == good.goodnum}">selected="selected"</c:if>
                                                    value="${good.goodnum }">${good.name }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group" style="margin-left: 0;">
                                <label class="control-label" style="font-size: 18px">商品单价：</label>
                                <div class="form_div" style="padding-left: 0; font-size: 18px">
                                    <input class="form-control" type="text" style="font-size: 18px" data-val="true"
                                           placeholder="" name="price" value="${masterTable.tabledetails.price}" id="price" readonly>
                                    <span></span>
                                </div>
                            </div>

                            <div class="form-group" style="margin-left: 0;">
                                <label class="control-label" style="font-size: 18px">购买数量：</label>
                                <div class="form_div" style="padding-left: 0; font-size: 18px">
                                    <input class="form-control" type="text" style="font-size: 18px" data-val="true"
                                           placeholder="" name="num" value="${masterTable.tabledetails.num}" id="num">
                                    <span style="color: red"></span>
                                </div>
                            </div>

                            <div class="form-group" style="margin-left: 0;">
                                <label class="control-label" style="font-size: 18px">买家姓名：</label>
                                <div class="form_div" style="padding-left: 0; font-size: 18px">
                                    <input class="form-control" type="text" style="font-size: 18px" data-val="true"
                                           placeholder="" name="name" value="${masterTable.name}" id="name">
                                    <span></span>
                                </div>
                            </div>

                            <div class="form-group" style="margin-left: 0;">
                                <label class="control-label" style="font-size: 18px">买家电话：</label>
                                <div class="form_div" style="padding-left: 0; font-size: 18px">
                                    <input class="form-control" type="text" style="font-size: 18px" data-val="true"
                                           placeholder="" name="phone" value="${masterTable.phone}" id="phone">
                                    <span></span>
                                </div>
                            </div>

                            <div class="form-group" style="margin-left: 0;">
                                <label class="control-label" style="font-size: 18px">买家地址：</label>
                                <div class="form_div" style="padding-left: 0; font-size: 18px">
                                    <input class="form-control" type="text" style="font-size: 18px" data-val="true"
                                           placeholder="" name="address" value="${masterTable.address}" id="address">
                                    <span></span>
                                </div>
                            </div>

                            <div class="form-group" style="margin-left: 0;">
                                <label class="control-label" style="font-size: 18px">总金额：</label>
                                <div class="form_div" style="padding-left: 0; font-size: 18px">
                                    <input class="form-control" type="text" style="font-size: 18px" data-val="true"
                                           placeholder="" name="totalsum" value="${masterTable.totalsum}" id="totalsum" readonly>
                                    <span></span>
                                </div>
                            </div>

                            <div class="form-group" style="margin-left: 0;">
                                <label class="control-label" style="font-size: 18px">订单状态：</label>
                                <div class="form_div" style="padding-left: 0; font-size: 18px">
                                    <select class="select2_demo_1 form-control" style="font-size: 18px" name="state" id="state">
                                        <option
                                                <c:if test="${masterTable.state == 0 }">selected="selected"</c:if>
                                                value="0">未发货
                                        </option>
                                        <option
                                                <c:if test="${masterTable.state == 1 }">selected="selected"</c:if>
                                                value="1">已发货
                                        </option>
                                    </select>
                                </div>
                            </div>

                            <input type="hidden" name="goodname" id="goodname" value="${masterTable.tabledetails.goodname}">
                            <input type="hidden" name="originalnum" id="originalnum" value="${masterTable.tabledetails.num}">
                            <input type="hidden" name="id" value="${masterTable.id}">

                            <input style="width: 100px; font-size: large " type="submit" value="提交" onclick="return tijiao()">&nbsp;&nbsp;

                        </div>


                    </form>

                </div>
            </Div>
        </div>
        <div class="clear"></div>
    </div>


    <div id="left_nav" class="left_menu">
        <div class="back">

        </div>
        <div class="menu_list">

        </div>
    </div>


</div>
</body>
</html>