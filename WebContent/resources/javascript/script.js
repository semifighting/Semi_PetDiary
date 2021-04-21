$(function () {
    $(".smallPic").click(function () {
        $("#bigPic").html("<img style='height: 300px'  src=" + $(this).attr("src") + ">");
        $("img").css("border", "none");
        $(this).css("border", "2px solid black");
    });
});


$(function () {
    $("#start_date").on("input", function () {
        $("#end_date").attr("disabled", false);
    });
});

$(function () {
    $("#end_date").on("input", function () {
       var end = new Date(this.value);
       var start = new Date($("#start_date").val());
        if (end.getTime() < start.getTime()) {
            alert("날짜 설정이 잘못되었습니다!");
            this.value = null;
        } else {
            $("#necessity").focus();
        }
    })
});

$(function () {
    $(".iselectPic").on("click", function () {
        var src = this.getAttribute("src");
        alert(src);
        location.href = "pet/pet_insert.jsp?src=../" + src;
    });
});

$(function () {
    $(".uselectPic").on("click", function () {
        var src = this.getAttribute("src")
        location.href = "pet/pet_update.jsp?src=../" + src;
    });
});