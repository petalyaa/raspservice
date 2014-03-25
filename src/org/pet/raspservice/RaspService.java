package org.pet.raspservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RaspService {
	
	public void handleGet(HttpServletRequest request, HttpServletResponse response);
	
	public void handlePost(HttpServletRequest request, HttpServletResponse response);
	
}
