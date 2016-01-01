package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.common.JsonTemplate;
import com.filter.ServletFilter;
import com.service.Service;
import com.service.impl.AlarmService;
import com.service.impl.PwdService;
import com.util.TokenGenerator;

public class PwdChange extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PwdChange() {
		super();
	}

	/**
	 * The doPut method of the servlet. <br>
	 *
	 * This method is called when a HTTP put request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Put your code here
		Service service=new PwdService();
		int status=service.service();
		JSONObject ret=new JsonTemplate(status).getTemplate(); 
		response.getWriter().println(ret);
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	

}
