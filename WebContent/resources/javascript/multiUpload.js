var express = require('express');
var app = express();
var axios = require('axios');
/* ... 중략 ... */
app.post('/payments/cancel', async (req, res, next) => {
    try {
        /* 액세스 토큰(access token) 발급 */
        const getToken = await axios({
            url: "https://api.iamport.kr/users/getToken",
            method: "post", // POST method
            headers: {
                "Content-Type": "application/json"
            },
            data: {
                imp_key: "imp_apikey", // [아임포트 관리자] REST API키
                imp_secret: "ekKoeW8RyKuT0zgaZsUtXXTLQ4AhPFW3ZGseDA6bkA5lamv9OqDMnxyeB9wqOsuO9W3Mx9YSJ4dTqJ3f" // [아임포트 관리자] REST API Secret
            }
        });
        const { access_token } = getToken.data.response; // 엑세스 토큰

    } catch (error) {
        res.status(400).send(error);
    }
});