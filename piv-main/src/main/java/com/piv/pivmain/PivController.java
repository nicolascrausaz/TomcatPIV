package com.piv.pivmain;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PivController {
	//Uncomment the line below if you have a registered domain
	//String authUrl = "https://www.nicocrausaz.com:8443/piv-auth/";
	String authUrl = "https://localhost:8443/piv-auth/";

	@GetMapping({"/","/user"})
	public String user() {
		return "userlogin";
	}

	@GetMapping("/userlogin")
	public String formLogin(String username, String password) {
		return "redirect:/userpage/" + username;
	}

	@GetMapping("userpage/{username}")
	public String userPage(@PathVariable String username, Model model) {
		model.addAttribute(username);
		return "user";
	}

	@GetMapping("/redirect")
	public void method(HttpServletResponse httpServletResponse) {
		httpServletResponse.setHeader("Location", authUrl);
		httpServletResponse.setStatus(302);
	}
}
