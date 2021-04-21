$(function () {
    $(".pet1").click(function () {
        var url = "../pet.do";
        $.ajax({
            url: url + "?command=pet_Paging&count=3",
            type:"POST",
            dataType:"json",
            success: function (data) {
                $.each(data, function (key, value) {
                    var dloc = "location.href='../pet.do?command=pet_delete&pet_no=" + value.pet_no + "'";
                    var uloc = "window.open('../pet.do?command=pet_update_form&pet_no='" + value.pet_no + "', 'update', 'left=50, top=50, width=700, height=700')";
                    $("#petImg").attr("src", value.pet_path);
                    $("#petName").empty().append(value.pet_name);
                    $("#petSpecies").empty().append(value.pet_species);
                    $("#petBreed").empty().append(value.pet_breed);
                    $("#petBirthday").empty().append(value.pet_birthday);
                    $("#petGender").empty().append(value.pet_gender);
                    $("#petVaccination").empty().append(value.pet_vaccination);
                    $("#petDel").attr("onclick", dloc);
                    $("#petUp").attr("onclick", uloc);
                });
            },
            error:function(request,status,error){
                alert("code:" + request.status + "<br>" + "message:" + request.responseText + "<br>" + "error:" + error);
            }
        })
    });
});