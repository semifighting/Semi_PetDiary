$(function () {
    $("#left").click(function () {
        var url = "pet.do";
        $.ajax({
            url:url + "?command=pagingDiary",
            type:"POST",
            dataType:"json",
            success: function (data) {
                
            },
            error:function(request,status,error){
                alert("code:" + request.status + "<br>" + "message:" + request.responseText + "<br>" + "error:" + error);
            }
        })
    });
});