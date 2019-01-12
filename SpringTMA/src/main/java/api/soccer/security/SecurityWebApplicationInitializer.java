package api.soccer.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Automatically register the springSecurityFilterChain Filter for every URL in your application
 * Add a ContextLoaderListener that loads the WebSecurityConfig.
 */
public class SecurityWebApplicationInitializer  extends AbstractSecurityWebApplicationInitializer {

   
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//
//                .authorizeRequests()
//                .antMatchers("/resources/**", "/signup", "/about").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login") //The updated configuration specifies the location of the log in page.
//                .permitAll()
//                .and()
//                .httpBasic();
//        // logout
////        http
////                .logout()
////                .logoutUrl("/my/logout")
////                .logoutSuccessUrl("/my/index")
////                .logoutSuccessHandler(logoutSuccessHandle)
////                .invalidateHttpSession(true)
////                .addLogoutHandler(logoutHandler)
////                .deleteCookies(cookieNamesToClear)
////                .and();
//
//    }
}
