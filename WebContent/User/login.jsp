<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    <%
    String scheme = request.getScheme();
	String serverName = request.getServerName();
  	String contextpath= request.getContextPath();
    int port=request.getLocalPort();
    String baseURL=scheme+"://"+serverName+":"+port+contextpath;
    request.setAttribute("baseURL", baseURL);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta content="网盘" name="keywords"/>
<meta content="刘霞的百度网盘,坚持就是胜利" name="description"/>
<title>百度网盘  享你所想</title>
<link href="${baseURL}/statics/images/favicon.ico" rel="shortcut icon" type="images/x-icon"/>
<link href="${baseURL}/statics/css/login.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${baseURL}/Jquery/jquery-2.2.2.js"></script>
<script type="text/javascript" src="${baseURL}/statics/js/login.js"></script>
</head>
<body>
<div id="login-container">

<div class='header-container'>
<div class='login-header'> 
<div class='logo'>
<a class='yun-logo' href="">百度网盘</a>
</div>
<span class='login-title'>
<a class='b-no-ln' href="">严打违规软件和盗版侵权传播</a>
<a class='b-no-ln' href="">百度首页</a>
<a class='b-no-ln' href="">客户端下载</a>
<a class='b-no-ln' href="">官方贴吧</a>
<a class='b-no-ln' href="http://weibo.com/u/2995816565">官方微博</a>
<a class='b-no-ln' href="">问题反馈</a>
</span>
</div>
</div>

<div class='content-container'>
<div class='content-container-banner'>
<div class="all-index-banner">
<div class="index-body-content">
<p><span class="left-quote"></span><span>安全存储</span></p>
<p><span>生活井井有条</span><span class="right-quote"></span></p>
</div>
</div>

<div class="all-index-banner-hidden">
<div class="index-body-content">
<p><span class="left-quote"></span><span>在线预览</span></p>
<p><span>文件即开即看</span><span class="right-quote"></span></p>
</div>
</div>

<div class="all-index-banner-hidden">
<div class="index-body-content">
<p><span class="left-quote"></span><span>多端并用</span></p>
<p><span>数据随身携带</span><span class="right-quote"></span></p>
</div>
</div>

<div class="all-index-banner-hidden">
<div class="index-body-content">
<p><span class="left-quote"></span><span>好友分享</span></p>
<p><span>共度幸福时光</span><span class="right-quote"></span></p>
</div>
</div>
</div>
<div class="yunpanbutton">
<ul class="btn_ul">
<li class="btn_li"><a id="0" href="#"></a></li>
<li class="btn_li"><a id="1" href="#"></a></li>
<li class="btn_li"><a id="2" href="#"></a></li>
<li class="btn_li"><a id="3" href="#"></a></li>
</ul>
</div>

<div id='login-middle'>
<div class='login-head'>
账号密码登录
</div>
<div class='login-content'>
<form action="login" method="post">
<s:token></s:token>
<%-- <input type="hidden" id="hidden" value="${token}" /> --%>
<p class="login_p_error"><span id="login_erroe"></span></p>
<input type="hidden" id="taken_login"/>
<p class='login_p'>
<input type="text" name="username" id="username" placeholder="手机/邮箱/用户名"/>
</p>
<p class='login_p'>
<input type="password" name="password" id="password" placeholder="密码"/>
</p>
<p>
<input type="checkbox" checked="checked" name="savePass" id="savePass"/>下次自动登录
</p><p>
<input id="submit" type="submit" name="submit" value="登录">
</p>
</form>
<a href="loginByqq">请使用你的QQ账号登陆</a>
</div>
</div>
</div>


</div>
</body>
</html>