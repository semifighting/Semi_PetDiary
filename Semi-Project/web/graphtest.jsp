<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="resources/javascript/Chart.js"></script>
    <script type="text/javascript">
        $(function () {
            var context = $("#myChart")[0].getContext('2d');
            var myChart = new Chart(context, {
                type : 'line',
                data : {
                    labels: ['봄', '여름', '가을', '겨울'],
                    datasets: [{
                        label: 'chicken',
                        lineTension : 0,
                        data: [7, 9, 6, 8],
                        backgroundColor : "rgba(153, 255, 51, 0.4)"
                    }, {
                        label: ['pizza'],
                        data: [5, 7, 5, 4],
                        backgroundColor: "rgba(255, 153, 0, 0.4)"
                    }]
                }
            });
        });

    </script>
</head>
<body>
<div style="width: 500px">
    <canvas id="myChart"></canvas>
</div>
</body>
</html>
