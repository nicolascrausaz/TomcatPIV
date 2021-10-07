package com.piv.pivauth;

import java.security.cert.X509Certificate;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import javax.security.auth.x500.X500Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class AuthController {
	String projectUrl = "https://localhost:8443/piv-main/userpage/%s";

	@GetMapping(value = "/")
	public void auth(HttpServletResponse response) throws InvalidNameException {
		System.out.println("WE ARE CHECKING SMART CARDS");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		X509Certificate[] certs = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
		X509Certificate clientCert = certs[0];
		X500Principal subjectDN = clientCert.getSubjectX500Principal();
		LdapName ln = new LdapName(subjectDN.toString());
		System.out.println(subjectDN.toString());
		String username = "";
		for (Rdn rdn : ln.getRdns()) {
			if (rdn.getType().equalsIgnoreCase("CN")) {
				username = (String) rdn.getValue();
				break;
			}
		}
		response.setHeader("Location", String.format(projectUrl, username));
		response.setStatus(302);
	}
}
