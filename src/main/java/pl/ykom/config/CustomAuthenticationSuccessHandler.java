/*
package pl.ykom.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        String userName = "";
        HttpSession session = request.getSession();
        Collection<GrantedAuthority> authorities = null;
        if(authentication.getPrincipal() instanceof Principal ) {
            userName = ((Principal)authentication.getPrincipal()).getName();
            session.setAttribute("role", "none");
        }else {
            User userSpringSecu = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            session.setAttribute("role", String.valueOf( userSpringSecu.getAuthorities()));
            session.setAttribute( "connectedUser" , managerFactory.getUserManager().findByUserName( userSpringSecu.getUsername() ) );
        }
        response.sendRedirect("/public/showAtlas" );

    }
}
*/
