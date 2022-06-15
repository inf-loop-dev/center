package com.inf_loop_dev.center.config.auth;

import com.inf_loop_dev.center.domain.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
//        super.onAuthenticationSuccess(request, response, authentication);
        System.out.println("successhandler");
//        System.out.println(((DefaultOAuth2User) authentication.getPrincipal()).getAttributes().get("name"));


        getRedirectStrategy().sendRedirect(request, response, "http://localhost:3000/google/callback?test=123&test2=333");

    }
}
