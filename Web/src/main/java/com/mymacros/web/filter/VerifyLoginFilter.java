package com.mymacros.web.filter;

import com.mymacros.repository.dao.entity.UserEntity;
import com.mymacros.web.config.RootContextConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by Tomas on 26/07/2016.
 */
public class VerifyLoginFilter implements Filter
{
     @Override
     public void init(FilterConfig filterConfig) throws ServletException
     {

     }

     @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
     {
         HttpSession session = ((HttpServletRequest)servletRequest).getSession(false);
         final Principal principal = UserEntity.getPrincipal(session);
         if(principal == null)
         {
             ((HttpServletResponse)servletResponse).sendRedirect(
                     ((HttpServletRequest) servletRequest).getContextPath() + "/login/form"
             );
         }
         else
         {
             filterChain.doFilter(
                     new HttpServletRequestWrapper((HttpServletRequest)servletRequest)
                     {
                         @Override
                         public Principal getUserPrincipal() {
                             return principal;
                         }
                     },
                     servletResponse
             );
         }
     }

     @Override
     public void destroy()
     {

     }
}
