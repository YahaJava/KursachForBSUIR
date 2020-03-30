package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("sss").password("{noop}123").roles("USER");
        }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*.anyRequest().authenticated()*/
                .antMatchers("/director/*").access("hasRole('ROLE_USER')")
                .antMatchers("/actor/*").access("hasRole('ROLE_USER')")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();

        http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            if (authException != null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.sendRedirect(request.getServletContext().getContextPath()+"/login");
            }
        });
    }
}
