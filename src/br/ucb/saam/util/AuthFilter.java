package br.ucb.saam.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter{



	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;
		boolean auth = rq.getSession().getAttribute("usuario") != null;
		
		if(!auth && !rq.getRequestURI().toString().contains("principal.xhtml")){
			rp.sendRedirect(rq.getContextPath()+"/principal.xhtml");
		}else{
			try{
				chain.doFilter(request, response);
			}catch(Exception e){
				System.out.print(e);
			}
			
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {		
	}
	
	@Override
	public void destroy() {
	}

}
