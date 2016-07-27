package com.mymacros.web.filter;

import com.mymacros.web.config.RootContextConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tomas on 26/07/2016.
 */
public class LoginFilter implements Filter
{
     @Override
     public void init(FilterConfig filterConfig) throws ServletException
     {

     }

     @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
     {
          try
          {
               RootContextConfig.message.info("DoFilter verificado session");
               HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
               session.getAttribute("id");
               filterChain.doFilter(servletRequest, servletResponse);
          } catch (Exception e)
          {
               ((HttpServletResponse) servletResponse).sendRedirect("/login/form");
          }
     }

     @Override
     public void destroy()
     {

     }
}
