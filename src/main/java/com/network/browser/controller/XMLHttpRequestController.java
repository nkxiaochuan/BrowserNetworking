/**
 * 
 */
package com.network.browser.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Andy
 *
 */
@Controller
@RequestMapping(value="/v1/xhr")
public class XMLHttpRequestController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
	//	response.addHeader("Access-Control-Allow-Origin", "https://github.com/");
		return "index";
	}
	@RequestMapping(value="/cors/", method=RequestMethod.GET)
	public String CORS(){
		return "cors";
	}
	@RequestMapping("/download")
	public String download(){
		return "download";
	}
	@RequestMapping("/upload")
	public void upload(){
		
	}
	@RequestMapping("/monitor")
	public void monitor(){
		
	}
	@RequestMapping("/streaming")
	public void streaming(){
		
	}

	@RequestMapping("/polling")
	public void polling(){
		
	}
	@RequestMapping("/longpolling")
	public void longPolling(){
		
	}
}
