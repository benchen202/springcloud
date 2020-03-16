package org.ben.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Value("${spring.application.name}")
    private String instanceName;
	
	@RequestMapping(value = "/{path}")
    public String path(@PathVariable String path, HttpServletRequest request) {
		System.out.println(path);
		return "hello,"+path; 
	}
}
