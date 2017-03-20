package com.jd.risktest.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class LoginIntercepter implements HandlerInterceptor {

    private List<String> excludedUrls;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {

        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.contains(url)) {
                return true;
            }
        }
        String loginPageUrl = "/Login";
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher(loginPageUrl).forward(request, arg1);
            return false;
        }
        return true;
    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

}
