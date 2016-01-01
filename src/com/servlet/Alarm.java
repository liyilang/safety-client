package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.common.JsonTemplate;
import com.filter.ServletFilter;
import com.service.Service;
import com.service.impl.AlarmService;
import com.service.impl.FenceService;
import com.util.TokenGenerator;

public class Alarm extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Alarm() {
		super();
	}

	/**
	 * The doDelete method of the servlet. <br>
	 *
	 * This method is called when a HTTP delete request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Put your code here
		if (TokenGenerator.isTokenValid()) {
			Service service=new AlarmService();
			int status=service.service();
			JSONObject ret=new JsonTemplate(status).getTemplate();
			response.getWriter().println(ret);
		
		}else {
			JSONObject ret=new JsonTemplate(994).getTemplate();
			response.getWriter().println(ret);
		}
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
		if (TokenGenerator.isTokenValid()) {
			Service service=new AlarmService();
			int status=service.service();
			JSONObject fenceId=(JSONObject) ServletFilter.threadLocalRequest.get().getAttribute("alarmId");
			JSONObject ret=new JsonTemplate(status,fenceId).getTemplate();
			response.getWriter().println(ret);
		
		}else {
			JSONObject ret=new JsonTemplate(994).getTemplate();
			response.getWriter().println(ret);
		}
		
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
		if (TokenGenerator.isTokenValid()) {
			Service service=new AlarmService();
			int status=service.service();
			JSONObject ret=new JsonTemplate(status).getTemplate();
			response.getWriter().println(ret);
		
		}else {
			JSONObject ret=new JsonTemplate(994).getTemplate();
			response.getWriter().println(ret);
		}
	}

}
