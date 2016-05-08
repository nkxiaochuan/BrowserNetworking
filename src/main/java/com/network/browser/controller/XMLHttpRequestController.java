/**
 * 
 */
package com.network.browser.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Andy
 *
 */
@Controller
@RequestMapping(value="/v1/xhr")
public class XMLHttpRequestController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ResponseBody
	public String hello(HttpServletRequest request, HttpServletResponse response){
		//A wildcard '*' cannot be used in the 'Access-Control-Allow-Origin' header when the credentials flag is true. 
		//Origin 'http://localhost:8080' is therefore not allowed access.
		response.addHeader("Access-Control-Allow-Origin", "*");
	//	response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		
		// Credentials flag is 'true', but the 'Access-Control-Allow-Credentials' header is ''. 
		//It must be 'true' to allow credentials. Origin 'http://localhost:8080' is therefore not allowed access.
		response.addHeader("Access-Control-Allow-Credentials", "true");
		return "hello, world";
	}
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request, HttpServletResponse response){
		System.out.println();
		return "ok";
	}
	
	@RequestMapping(value="/stream", method=RequestMethod.GET)
	@ResponseBody
	public String stream(HttpServletRequest request, HttpServletResponse response){
		System.out.println();
		return "ok";
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/poll", method=RequestMethod.GET)
	@ResponseBody
	public String poll(HttpServletRequest request, HttpServletResponse response){
		System.out.println("start---");
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end.");
		return "ok";
	}
}
