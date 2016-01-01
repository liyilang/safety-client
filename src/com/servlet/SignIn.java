package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.common.JsonTemplate;
import com.service.Service;
import com.service.impl.SignInService;
import com.util.MD5Util;
import com.util.TokenGenerator;

public class SignIn extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SignIn() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			password=MD5Util.generatePassword(password);
			String phone=request.getParameter("phone");
			String entityId=request.getParameter("entityId");
			Service service=new SignInService( userName, password, phone, entityId);
			int statusCode=service.service();
			if (statusCode==0) {
				String token=TokenGenerator.setToken();
				try {
					JSONObject ret=new JsonTemplate(0, new JSONObject().put("token",token)).getTemplate();
					response.getWriter().println(ret);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				JSONObject ret=new JsonTemplate(statusCode).getTemplate();
				response.getWriter().println(ret);
			}
			
		
	}

}
