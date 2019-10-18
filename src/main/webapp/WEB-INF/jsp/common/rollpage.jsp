<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<p>
    <c:if test="${currentPageNo>1 }">
        <a href="javascript:;" onclick="fenye(document.forms[0],1)">首页</a>
        <a href="javascript:;" onclick="fenye(document.forms[0],${currentPageNo-1})">上一页</a>
    </c:if>
    <c:if test="${currentPageNo<totalPageCount }">
        <a href="javascript:;" onclick="fenye(document.forms[0],${currentPageNo+1})">下一页</a>
        <a href="javascript:;" onclick="fenye(document.forms[0],${totalPageCount})">末页</a>
    </c:if>
    <span>第${currentPageNo}页/共${totalPageCount}页&nbsp;&nbsp;共${totalCount}条</span>
    <%-- <c:if test="${currentPageNo>1 }">
        <a href="inHome.html?pageIndex=1">首页</a>
        <a href="inHome.html?pageIndex=${currentPageNo-1 }">上一页</a>
    </c:if>
    <c:if test="${currentPageNo<totalPageCount }">
        <a href="inHome.html?pageIndex=${currentPageNo+1 }">下一页</a>
        <a href="inHome.html?pageIndex=${totalPageCount }">尾页</a>
    </c:if> --%>
</p>
</body>
<script type="text/javascript">
    function fenye(frm, pageIndex) {
        frm.pageIndex.value = pageIndex;
        frm.submit();
    }
</script>
</html>