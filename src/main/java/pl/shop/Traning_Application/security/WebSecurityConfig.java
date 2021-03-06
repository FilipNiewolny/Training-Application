package pl.shop.Traning_Application.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MyAuthenticationSuccessHandler();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/**" , "/login" , "/register",
                        "/authentication-success","/successful-registration")
                        .permitAll();

        http.authorizeRequests()
                .antMatchers("/admin", "/list","/add")
                .access("hasRole('ADMIN')");

        http.authorizeRequests()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/failed-login")
                .successHandler(myAuthenticationSuccessHandler())
                .and()
                .logout()
//                .logoutUrl("/success-logout")
                .deleteCookies("username")
                .invalidateHttpSession(false)
                .logoutSuccessUrl("/success-logout");

    }


}

