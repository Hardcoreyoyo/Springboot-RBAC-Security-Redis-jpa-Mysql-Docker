package ShopAppJwt.config;

import ShopAppJwt.globalException.SecurityAccessDeniedException;
import ShopAppJwt.globalException.SecurityAnonymousAccessDeniedException;
import ShopAppJwt.service.Security.SecurityService;
import ShopAppJwt.service.Security.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static ShopAppJwt.controller.PathUtils.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SecurityService securityService;

    @Autowired
    SecurityJWTFilter securityJWTFilter;

    @Autowired
    SecurityUserDetailsService securityUserDetailsService;

    @Autowired
    SecurityAccessDeniedException securityAccessDeniedException;

    @Autowired
    SecurityLoggedInNotAllowFilter securityLoggedInNotAllowFilter;

    @Autowired
    SecurityAnonymousAccessDeniedException securityAnonymousAccessDeniedException;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors();
        http.csrf().disable();
        // 使用 jwt 情況下 csrf 可考慮不使用

        http
            .addFilterBefore(securityJWTFilter, UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(securityLoggedInNotAllowFilter, SecurityJWTFilter.class)
            .authorizeRequests()
            .antMatchers(PERMIT_All_URI).permitAll();

        http
            .authorizeRequests()
            .anyRequest()
            .access("@UrlAccessService.hasPermission(request,authentication)");

        http
            .exceptionHandling()
            .accessDeniedHandler(securityAccessDeniedException) // 情境: user 已經登入但嘗試訪問無權的頁面
            .authenticationEntryPoint(securityAnonymousAccessDeniedException); // 情境: Anonymous 嘗試訪問無權的頁面

        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers(PathUtils.PERMIT_RES_LIST);
//    }   //開放靜態資源路徑

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(securityUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
