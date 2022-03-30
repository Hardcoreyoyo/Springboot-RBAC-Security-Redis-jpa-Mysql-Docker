package ShopAppJwt.config;

import ShopAppJwt.model.Member.SecurityUserDetails;
import ShopAppJwt.service.JWT.JwtTokenUtil;
import ShopAppJwt.service.Security.SecurityUserDetailsService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityJWTFilter extends OncePerRequestFilter {

    @Autowired
    SecurityUserDetailsService securityUserDetailsService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader(jwtTokenUtil.getHeader());

        if (jwtToken != null) {
            String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            if (username != null) {
                SecurityUserDetails userDetails = securityUserDetailsService.loadUserByUsername(username);

                if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken
                            = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}