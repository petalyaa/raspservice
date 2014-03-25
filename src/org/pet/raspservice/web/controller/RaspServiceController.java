package org.pet.raspservice.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pet.raspservice.RaspService;

import com.google.gson.JsonObject;

public class RaspServiceController extends HttpServlet {

	private static final long serialVersionUID = 3062606416659605089L;
	
	private static final String REQUEST_CLASS = "class";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clazz = request.getParameter(REQUEST_CLASS);
		System.err.println("Request class[GET] : " + clazz);
		RaspService service = parseRequestService(clazz);
		if(service != null) 
			service.handleGet(request, response);
		else
			printErrorMessage(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clazz = request.getParameter(REQUEST_CLASS);
		System.err.println("Request class[POST] : " + clazz);
		RaspService service = parseRequestService(clazz);
		if(service != null) 
			service.handleGet(request, response);
		else
			printErrorMessage(request, response);
	}
	
	private void printErrorMessage(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("application/json");
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("status", false);
			jsonObj.addProperty("errorMsg", "Invalid class service requested : " + request.getParameter(REQUEST_CLASS));
			String jsonStr = jsonObj.toString();
			PrintWriter writer = response.getWriter();
			response.setContentLength(jsonStr.length());
			writer.write(jsonStr);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private RaspService parseRequestService(String clazzStr) {
		RaspService service = null;
		try {
			Class<?> clazz = Class.forName(clazzStr);
			service = (RaspService) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return service;
	}
	
	

}
