/**
 *
 */
$(document).ready(function () {
    $(".deleteOrder").click(function () {
        var deleteBut = $(this);
        if (confirm("确定要删除吗?")) {
            $.ajax({
                url: "deleteOrder",
                type: "get",
                data: {ordernum: deleteBut.attr("ordernum")},
                dataType: "json",
                success: function (data) {
                    if (data.result == "success") {
                        deleteBut.parents("tr").remove();
                        alert("删除成功!");
                    } else {
                        alert("删除失败!");
                    }
                }
            });
        }
    });
});