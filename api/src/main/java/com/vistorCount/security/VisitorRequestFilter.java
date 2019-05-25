package com.vistorCount.security;

import com.vistorCount.service.VisitorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VisitorRequestFilter extends GenericFilterBean {

    @Autowired
    private VisitorRecordService visitorRecordService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = httpRequest.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        if(!(httpRequest.getRequestURI().startsWith("/api/"))){
            visitorRecordService.AddVisitorCount(remoteAddr);
        }

        chain.doFilter(httpRequest, httpResponse);

    }
}
