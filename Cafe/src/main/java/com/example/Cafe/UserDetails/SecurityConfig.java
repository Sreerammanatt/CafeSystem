package com.example.Cafe.UserDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    CustomUserDetailsService userService;


    @Bean
    public  static PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();

    }


    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http) throws Exception{
        http.csrf(c->c.disable())
                .authorizeHttpRequests(request->request.requestMatchers(
                        "/admin-page"
                ).permitAll().requestMatchers("user-page").permitAll()
                        .requestMatchers("/registration","/css/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form->form.loginPage("/login").loginProcessingUrl("/login")
                        .defaultSuccessUrl("/").permitAll())
                .logout(form->form.invalidateHttpSession(true).clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/login"))
                        .logoutSuccessUrl("/logout?logout").permitAll());
        return http.build();


    }
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    }
//