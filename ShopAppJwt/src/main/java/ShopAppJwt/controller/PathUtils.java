package ShopAppJwt.controller;

import lombok.Data;

@Data
public class PathUtils {

    public static final String[] PERMIT_All_URI = {
            "/auth",
            "/refresh",
            "/oauth",
            "/callback",
            "/signup",
            "/email",
            "/email/confirm",
            "/user/reset/*",
            "/admin/query/all/**"
    };// 此變數直接進 HttpSecurity 所以 URL: /query/{test}/{test2} 要用 /query/**

    public static final String[] LOGGED_IN_NOT_ALLOW = {
            "/auth",
            "/signup",
            "/oauth",
            "/email",
            "/email/confirm/**",
            "/user/reset/**"
    }; // 此變數 是進 filter 不要用 /* or /**   (springframework.util.PathMatcher api 可解決語法不一致)

//    public static final String[] PERMIT_RES_LIST = {
//            "/swagger-ui/swagger-resources/**",
//            "/swagger-resources/**",
//            "/webjars/**",
//            "/swagger-ui/**",
//            "/v2/api-docs",
//            "/v3/api-docs",
//    };

}
