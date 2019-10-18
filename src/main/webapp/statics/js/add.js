


var goodnum = null;//选择商品下拉框-当前商品编号
var price = null;//商品单价
var num = null;//购买数量
var totalsum = null;//总金额
var goodname = null;//隐藏域保存商品名称

/**
 * 提示信息显示
 * element:显示提示信息的元素（font）
 * css：提示样式
 * tipString:提示信息
 * status：true/false --验证是否通过
 */
function validateTip(element,css,tipString,status){
    element.css(css);
    element.html(tipString);

    element.prev().attr("validateStatus",status);
}

$(document).ready(function () {
    goodnum = $("#goodnum");
    price = $("#price");
    num = $("#num");
    totalsum = $("#totalsum");
    goodname = $("#goodname");

    goodnum.change(doprice);
    function doprice() {
        $.ajax({
            url:"/getGood",
            type:"get",
            data:{goodnum:goodnum.val()},
            dataType:"json",
            success:function (data) {
                price.val(data.unitprice);
                num.next().html("当前商品库存:"+data.stock+"件!");
                goodname.val(data.name);
            }
        })
    }

    /*计算总金额*/
    num.blur(dosum);
    function dosum() {
        $.ajax({
            url:"/countSum",
            type: "get",
            data: {price:price.val(),num:num.val()},
            dataType: "text",
            success:function (data) {
                totalsum.val(data);
            }
        })
    }

});