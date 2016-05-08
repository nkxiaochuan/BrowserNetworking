/**
 * 
 */
package com.network.browser.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
	public void stream(HttpServletRequest request, HttpServletResponse response){
		try {
			PrintWriter out = response.getWriter();
			for (int i = 0; i < 100; i++){
				Thread.sleep(1000);
				out.write("this is the message "+ i);
				out.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("end");
	}
	
}
