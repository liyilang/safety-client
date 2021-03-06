package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.common.JsonTemplate;
import com.service.impl.LogoutService;
import com.util.TokenGenerator;

public class Logout extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Logout() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (TokenGenerator.isTokenValid()) {
			new LogoutService().service();
			JSONObject ret=new JsonTemplate(0).getTemplate();
			response.getWriter().println(ret);
		
		}else {
			JSONObject ret=new JsonTemplate(994).getTemplate();
			response.getWriter().println(ret);
		}
		
	}

}
