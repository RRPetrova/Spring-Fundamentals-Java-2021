package com.example.mobilele.config;

import com.example.mobilele.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MobileleSecurityConfig extends WebSecurityConfigurerAdapter {

    public final PasswordEncoder passwordEncoder;
    public final UserDetailsServiceImpl userDetailsServiceImpl;

    public MobileleSecurityConfig(PasswordEncoder passwordEncoder,
                                  UserDetailsServiceImpl userDetailsServiceImpl) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsServiceImpl)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               //to static rscs
               .antMatchers("/js/**", "/css/**", "/img/**").permitAll()
               //index, users login and register
               .antMatchers("/", "/users/login", "/users/register", "/offers/all", "/brands/all").permitAll()
               //need authentication to see other pages
               .antMatchers("/**").authenticated()
                    .and()
               //config login with HTML form
               .formLogin()
               .loginPage("/users/login")
               .usernameParameter("username")
               .passwordParameter("password")
               .defaultSuccessUrl("/")
               .failureForwardUrl("/users/login-error")
                    .and()
               .logout()
               .logoutUrl("/users/logout")
               .invalidateHttpSession(true)
               .deleteCookies("JSESSIONID");
    }
}
