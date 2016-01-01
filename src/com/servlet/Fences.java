package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.common.JsonTemplate;
import com.filter.ServletFilter;
import com.service.Service;
import com.service.impl.EntitiesService;
import com.service.impl.FencesService;
import com.util.TokenGenerator;

public class Fences extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Fences() {
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
			Service service=new FencesService();
			int status=service.service(); 
			JSONArray jsonArray=(JSONArray) ServletFilter.threadLocalRequest.get().getAttribute("fences");
			
			if (jsonArray!=null) {
				JSONObject ret=new JsonTemplate(status,jsonArray).getTemplate();
				
				response.getWriter().println(ret);
			}else {
				JSONObject ret=new JsonTemplate(status).getTemplate(); 
				response.getWriter().println(ret);
			}

		}else {
			JSONObject ret=new JsonTemplate(994).getTemplate();
			response.getWriter().println(ret);
		}
	}


}
