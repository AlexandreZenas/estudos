package alexandre.zenas.estudos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private FilterAuthentication filterAuthentication;
    private UserAuthenticationService userAuthenticationService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register").permitAll()
                        .anyRequest().permitAll()
                ).addFilterBefore(
                        filterAuthentication,
                        UsernamePasswordAuthenticationFilter.class
                )
//                .logout(logout -> logout
//                        .logoutUrl("/sair")
//                        .logoutSuccessUrl("/login?logout")
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .usernameParameter("email")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/home")
//                        .failureForwardUrl("/login")
//                )
        ;
        return http.build();
    }

   // @Bean
   //    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
   //        return http.getSharedObject(AuthenticationManagerBuilder.class)
   //                .userDetailsService(userAuthenticationService)
   //                .passwordEncoder(this.passwordEncoder())
   //                .and().build();
   //    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
