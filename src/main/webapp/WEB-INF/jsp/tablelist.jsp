<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>订单管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/show.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/mine.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/tablelist.js"></script>
</head>


${result}
<%session.removeAttribute("result"); %>

<body>
<div id="box">

    <div id="right_width" class="right_show">
        <div class="right_wrap">
            <div class="show_title"><p>订单管理</p></div>
            <Div class="right_box">
                <div class="right_topBar">
                    <ul>
                        <li>
                            <form action="${pageContext.request.contextPath }/toTableList.html">
                                <p>
                                    按购买人:
                                    <input type="text" name="name" value="${name }">
                                    按购买商品:
                                    <select name="goodnum">
                                        <option value="0">请选择</option>
                                        <c:forEach items="${goodLists }" var="good">
                                            <option
                                                    <c:if test="${good.goodnum == goodnum}">selected="selected"</c:if>
                                                    value="${good.goodnum }">${good.name}</option>
                                        </c:forEach>
                                    </select>
                                    <input type="submit" value="搜索">
                                </p>
                                <input type="hidden" name="pageIndex" value="1">
                            </form>
                        </li>
                        <li><a href="${pageContext.request.contextPath }/toAddHtml.html">下单</a></li>
                    </ul>
                </div>

                <div class="content_box">
                    <div class="content_all">
                        <table width="95%" border="1" cellpadding="0" cellspacing="1" bgcolor="#999999">
                            <tr>
                                <td align="center" valign="middle" bgcolor="#d1d1d1">ID</td>
                                <td align="center" valign="middle" bgcolor="#d1d1d1">订单号</td>
                                <td align="center" valign="middle" bgcolor="#d1d1d1">购买商品</td>
                                <td align="center" valign="middle" bgcolor="#d1d1d1">购买数量</td>
                                <td align="center" valign="middle" bgcolor="#d1d1d1">商品总价</td>
                                <td align="center" valign="middle" bgcolor="#d1d1d1">购买人</td>
                                <td height="35" align="center" valign="middle" bgcolor="#d1d1d1">地址</td>
                                <td height="35" align="center" valign="middle" bgcolor="#d1d1d1">电话</td>
                                <td height="35" align="center" valign="middle" bgcolor="#d1d1d1">订单状态</td>
                                <td height="35" align="center" valign="middle" bgcolor="#d1d1d1">下单时间</td>
                                <td height="35" align="center" valign="middle" bgcolor="#d1d1d1">操作</td>
                            </tr>
                            <c:forEach items="${masterTableList }" var="order" varStatus="status">
                                <tr
                                        <c:if test="${status.count%2 == 0 }">bgcolor="#aqua"</c:if> >
                                    <td align="center" valign="middle" bgcolor="#FFFFFF"
                                        class="Pleft">${order.id }</td>
                                    <td align="center" valign="middle" bgcolor="#FFFFFF"
                                        class="Pleft">${order.ordernum }</td>
                                    <td align="center" valign="middle" bgcolor="#FFFFFF"
                                        class="Pleft">${order.tabledetails.goodname }</td>
                                    <td align="center" valign="middle" bgcolor="#FFFFFF"
                                        class="Pleft">${order.tabledetails.num }</td>
                                    <td align="center" valign="middle" bgcolor="#FFFFFF"
                                        class="Pleft">${order.totalsum}&nbsp;</td>
                                    <td align="center" valign="middle" bgcolor="#FFFFFF"
                                        class="Pleft">${order.name}&nbsp;</td>
                                    <td align="center" valign="middle" bgcolor="#FFFFFF" class="Pleft">
                                        &nbsp;${order.address }</td>
                                    <td height="35" align="center" valign="middle" bgcolor="#FFFFFF"
                                        class="Pleft">${order.phone }</td>
                                    <td height="35" align="center" valign="middle"
                                        bgcolor="#FFFFFF">
                                        <c:if test="${order.state == 0}">未发货</c:if>
                                        <c:if test="${order.state == 1}">已发货</c:if>
                                    </td>
                                    <td height="35" align="center" valign="middle"
                                        bgcolor="#FFFFFF"><fmt:formatDate value="${order.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td height="35" align="center" valign="middle" bgcolor="#FFFFFF">
                                        <a href="javascript:;" ordernum=${order.ordernum } class="deleteOrder">删除</a>|
                                        <a href="${pageContext.request.contextPath }/toUpdatePage.html?ordernum=${order.ordernum }"
                                           class="modifyUser">编辑</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div class="page">
                            <ul>
                                <c:import url="common/rollpage.jsp">
                                    <c:param name="totalCount" value="${totalCount}"/>
                                    <c:param name="currentPageNo" value="${currentPageNo}"/>
                                    <c:param name="totalPageCount" value="${totalPageCount}"/>
                                </c:import>
                            </ul>

                        </div>

                    </div>
                    <div class="clear"></div>
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