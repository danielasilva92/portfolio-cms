package se.jensen.daniela.portfoilo2026.security;

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

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // enklast för SPA/JS-anrop från admin.html
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // öppna sidor & assets
                        .requestMatchers("/", "/index.html", "/login", "/login.html",
                                "/css/**", "/js/**", "/images/**", "/*.jpg", "/*.png", "/*.webp", "/*.svg"
                        ).permitAll()

                        // API: GET är öppet (portfolio kan läsa)
                        .requestMatchers(HttpMethod.GET, "/api/projects/**").permitAll()

                        // Admin och alla ändringar kräver inlogg
                        .requestMatchers("/admin", "/admin.html").authenticated()
                        .requestMatchers("/api/**").authenticated()

                        // h2 (valfritt)
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

        // H2 console behöver frame support
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

    @Bean
    UserDetailsService users() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("DanielaSilva")
                .password("Esmeralda123!!")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
}
