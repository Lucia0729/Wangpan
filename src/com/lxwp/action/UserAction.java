package com.lxwp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.lxwp.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.PageFans;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.PageFansBean;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.javabeans.weibo.Company;
import com.qq.connect.oauth.Oauth;
/**
 * 用户类
 */
public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private UserService userService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public void setUserService(UserService userService){
		this.userService=userService;
	}
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	/**
	 * login by Lucia
	 * @return
	 */
	public String login(){
		boolean flag=userService.login(username,password);
		if(!flag) return INPUT;
		return SUCCESS;
	}
	
	public void qqlogin() throws Exception{
		System.out.println("进入qq登录");
		
		 try {
	            response.sendRedirect(new Oauth().getAuthorizeURL(request));
	        } catch (QQConnectException e) {
	            e.printStackTrace();
	        }
		
	}
	public void afterlogin() throws IOException{
		System.out.println("qq登录之后");
		  response.setContentType("text/html; charset=utf-8");
		  PrintWriter out = response.getWriter();

	    
		 try {
	            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);

	            String accessToken   = null,
	                   openID        = null;
	            long tokenExpireIn = 0L;
	            if (accessTokenObj.getAccessToken().equals("")) {
//	                我们的网站被CSRF攻击了或者用户取消了授权
//	                做一些数据统计工作
	                System.out.print("没有获取到响应参数");
	            } else {
	                accessToken = accessTokenObj.getAccessToken();
	                tokenExpireIn = accessTokenObj.getExpireIn();

	                request.getSession().setAttribute("demo_access_token", accessToken);
	                request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));

	                // 利用获取到的accessToken 去获取当前用的openid -------- start
	                OpenID openIDObj =  new OpenID(accessToken);
	                openID = openIDObj.getUserOpenID();

	                out.println("欢迎你，代号为 " + openID + " 的用户!");
	                request.getSession().setAttribute("demo_openid", openID);
	             System.out.println("欢迎你，代号为 " + openID + " 的用户!");
	            }
	        } catch (QQConnectException e) {
	        }
	   
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
}
