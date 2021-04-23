function pet(num) {
    var url = "../pet_servlet";
    $.ajax({
        url: url + "?command=pet_Paging&count=" + num,
        type: "POST",
        dataType: "json",
        success: function (data) {
            $.each(data, function (key, value) {
                var dloc = "location.href='../pet_servlet?command=pet_delete&pet_no=" + value.pet_no + "'";
                var uloc = "window.open('../pet_servlet?command=pet_update_form&pet_no=" + value.pet_no + "', 'update', 'left=50, top=50, width=700, height=700')";
                $("#petImg").attr("src", value.pet_path);
                $("#petName").empty().append("이름 " + value.pet_name);
                $("#petSpecies").empty().append("종 " + value.pet_species);
                $("#petBreed").empty().append("품종 " + value.pet_breed);
                $("#petBirthday").empty().append("태어난 날 " + value.pet_birthday.substring(0, 10));
                $("#petGender").empty().append("성별 " + value.pet_gender);
                $("#petVaccination").empty().append("예방 접종 예정일 " + value.pet_vaccination.substring(0, 10));
                $("#petDel").attr("onclick", dloc);
                $("#petUp").attr("onclick", uloc);
            });
        },
        error: function (request, status, error) {
            alert("code:" + request.status + "<br>" + "message:" + request.responseText + "<br>" + "error:" + error);
        }
    })
};