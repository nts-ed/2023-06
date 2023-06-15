<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
社員ID
<br/>
氏名
<br>
所属部門
<br>

<form method="toroku">
<br>
<label for="meeting">日付：</label><input id="meeting" type="date" value="0000:00:00"/>
<br/>
<br>
<label for="meeting">出勤時間：</label><input id="meeting" type="time" value="00:00"/>
<br/>
<br>
<label for="meeting">退勤時間：</label><input id="meeting" type="time" value="00:00"/>
<br/>
<br>
<label for="meeting">休み時間：</label><input id="meeting" type="time" value="00:00"/>
<br/>
<br>
状態：
     <select>
         <option>0．出勤</option>
         <option>1．欠勤</option>
         <option>2．休み</option>
         <option>3．有給</option>
      </select>
<br/>
<br>

 作業内容: <textarea  maxlength="200" style="height:100px;width:300px;"></textarea>
 
<div class="sav" style="text-align:center" >
<input type="button" id = "btn1" value="登録" onclick="javascript:location.href='要跳转的url';">
<input type="button" id = "btn2" value="閉じる" onclick="javascript:location.href='要跳转的url';">
</div>
  </form>
</body>
</html>