package com.first.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebController {
	@RequestBody("welcome")
	public String welcome() {
		return welcome.html;
		}

}
