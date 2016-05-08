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
@RequestMapping(value="/v1/sse")
public class SSEController {

	
	@RequestMapping(value="/stream", method=RequestMethod.GET)
	@ResponseBody
	public String stream(HttpServletRequest request, HttpServletResponse response){
		System.out.println();
		return "ok";
	}
	
}
