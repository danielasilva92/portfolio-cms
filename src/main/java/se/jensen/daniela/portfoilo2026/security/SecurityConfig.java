package se.jensen.daniela.portfoilo2026.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${ADMIN_USERNAME}")
    private String adminUsername;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/login", "/login.html",
                                "/css/**", "/js/**", "/images/**", "/*.jpg", "/*.png", "/*.webp", "/*.svg"
                        ).permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/projects/**").permitAll()

                        .requestMatchers("/admin", "/admin.html").authenticated()
                        .requestMatchers("/api/**").authenticated()

                        .requestMatchers("/h2/**").permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/admin?login=success", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/?logout=true")
                        .permitAll()
                );

        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));
        return http.build();
    }

    @Bean
    UserDetailsService users() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username(adminUsername)
                .password(adminPassword)
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
}
