<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charser=UTF-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	*{ margin: 0; padding: 0; }
	 
	.chat_wrap .header { font-size: 18px; font-weight: 700; padding: 15px 0; background: salmon; color: white; text-align: center; } 
	
	.chat_wrap .chat { padding-bottom: 80px; }
	.chat_wrap .chat ul { width: 100%; list-style: none; }
	.chat_wrap .chat ul li { width: 100%; }
	.chat_wrap .chat ul li.left { text-align: left; }
	.chat_wrap .chat ul li.right { text-align: right; }
	 
	.chat_wrap .chat ul li > div { font-size: 13px; }
	.chat_wrap .chat ul li > div.sender { margin: 10px 20px 0 20px; font-weight: bold; }
	.chat_wrap .chat ul li > div.message { display: inline-block; word-break:break-all; margin: 5px 20px; max-width: 75%; border: 1px solid #888; padding: 10px; border-radius: 5px; background-color: #FCFCFC; color: #555; text-align: left; }
	 
	.chat_wrap .input-div { position: fixed; bottom: 0; width: 100%; background-color: #FFF; text-align: center; border-top: 1px solid salmon; }
	.chat_wrap .input-div > textarea { width: 100%; height: 60px; border: none; padding: 10px; }
	 
	.form { display: none; }


</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	var Chat = (function(){
	    var myName = " ";
	 
	    // init 함수
	    function init() {
	        // enter 키 이벤트
	        $(document).on('keydown', 'div.input-div textarea', function(e){
	            if(e.keyCode == 13 && !e.shiftKey) {
	                e.preventDefault();
	                var message = $(this).val();
	 
	                // 메시지 전송
	                sendMessage(message);
	                // 입력창 clear
	                clearTextarea();
	            }
	        });
	    }
	 
	    // 메세지 태그 생성
	    function createMessageTag(LR_className, senderName, message) {
	        // 형식 가져오기
	        var chatLi = $('div.chat.form ul li').clone();
	 
	        // 값 채우기
	        chatLi.addClass(LR_className);
	        chatLi.find('.sender span').text(senderName);
	        chatLi.find('.message span').text(message);
	 
	        return chatLi;
	    }
	 
	    // 메세지 전송
	    function sendMessage(message) {
	        var data = {
	            "senderName"    : " ",
	            "message"        : message
	        };
	        
	        request(data);
	        
	        $.ajax({
	        	type:"POST",
	        	url: "../chatbot.do?command=dialog&message="+encodeURIComponent(message),
	        	dataType: "json",
	        	success : function(data){
	        		response(data);
	        		
	        	}
	        	,
	        	error : function(){
	        		alert("error");
	        	}
	        
	        }); 
	    }
	    
		// 발신
	    function request(data) {
	      	var LR = (data.senderName != myName)? "left" : "right";
	        appendMessageTag("right", data.senderName, data.message);
	        $('div.chat').scrollTop($('div.chat')[0].scrollHeight);
	    }
		
	 	// 수신
		function response(data) {
			var LR = (data.senderName != myName)? "left" : "right";
			appendMessageTag("left", data.senderName, data.message);
		}
		
	    // 메세지 태그 append
	    function appendMessageTag(LR_className, senderName, message) {
	        var chatLi = createMessageTag(LR_className, senderName, message);
	        $('div.chat:not(.form) ul').append(chatLi);
	        
	        $("html, body").animate({ scrollTop: $(document).height() }, 500);
	    }
	 
	 
	    // 메세지 입력박스 내용 지우기
	    function clearTextarea() {
	        $('div.input-div textarea').val('');
	    }
	 
	    return {
	        'init': init
	    };
	})();
	 
	$(function(){
	    Chat.init();
	});

</script>
</head>
<body>

	<div class="chat_wrap">
		<div class="header">
			CHATBOT
		</div>
		 <div class="chat">
        <ul>
            <!-- 동적 생성 -->
        </ul>
    </div>
    <div class="input-div">
        <textarea placeholder="메세지 입력 후 엔터를 눌러주세요." style="resize: none;"></textarea>
    </div>
 	<br/>
 	<br/>
    <div class="chat form">
        <ul>
            <li>
                <div class="sender">
                    <span></span>
                </div>
                <div class="message">
                    <span></span>
                </div>
            </li>
        </ul>
    </div>
	</div>

</body>
</html>