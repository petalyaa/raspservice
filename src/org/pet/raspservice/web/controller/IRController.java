package org.pet.raspservice.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pet.raspservice.RaspService;

public class IRController implements RaspService {

	@Override
	public void handleGet(HttpServletRequest request, HttpServletResponse response) {
		System.err.println("Get inside ir controller");
	}

	@Override
	public void handlePost(HttpServletRequest request, HttpServletResponse response) {
		System.err.println("Post inside ir controller");
	}

}
