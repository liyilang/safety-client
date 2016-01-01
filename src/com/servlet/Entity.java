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
import com.service.impl.EntityService;
import com.service.impl.FenceService;
import com.util.PathSegment;
import com.util.TokenGenerator;

public class Entity extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Entity() {
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
			Service service=new EntityService();
			int status=service.service();
			if (status==0) {
				if (PathSegment.pathSegments[4].equals("entity_status")) {
					JSONObject battery=(JSONObject) ServletFilter.threadLocalRequest.get().getAttribute("battery");
					JSONObject ret=new JsonTemplate(status,battery).getTemplate();
					response.getWriter().println(ret);
				}else if (PathSegment.pathSegments[4].equals("location")) {
					
				}else if (PathSegment.pathSegments[4].equals("locations")) {
					JSONArray locations=(JSONArray) ServletFilter.threadLocalRequest.get().getAttribute("locations");
					JSONObject ret=new JsonTemplate(status,locations).getTemplate();
					response.getWriter().println(ret);
				}
				
			} else {
				JSONObject ret=new JsonTemplate(status).getTemplate();
				response.getWriter().println(ret);
			}
			
		
		
		}else {
			JSONObject ret=new JsonTemplate(994).getTemplate();
			response.getWriter().println(ret);
		}
	}

	

}
