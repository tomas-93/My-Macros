package com.mymacros.web.filter;

import com.mymacros.database.entity.UserEntity;
import org.apache.logging.log4j.ThreadContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

/**
 * Created by Tomas on 01/08/2016.
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
        String id = UUID.randomUUID().toString();
        ThreadContext.put("id", id);
        Principal  principal = UserEntity.getPrincipal(((HttpServletRequest)servletRequest).getSession(false));

        if (principal!=null)
            ThreadContext.put("userName", principal.getName());
        try
        {
            ((HttpServletResponse)servletResponse).setHeader("X-Request-Id", id);
            filterChain.doFilter(servletRequest, servletResponse);

        }finally
        {
            ThreadContext.clearAll();
        }
    }

    @Override
    public void destroy()
    {

    }
}
