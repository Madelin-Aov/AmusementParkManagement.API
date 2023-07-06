package com.apm.API.security;

import com.apm.API.entities.Employee;
import com.apm.API.entities.User;
import com.apm.API.enums.EmployeeRole;
import com.apm.API.repositories.EmployeeRepository;
import com.apm.API.repositories.UserRepository;
import com.apm.API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userSerivce;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userSerivce).passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        if (userRepository.findByUserName("admin") == null) {
            User user = new User("admin", "admin");
            userRepository.save(user);

            Employee employee = new Employee();
            employee.setName("ADMIN");
            employee.setMail("admin@gmail.com");
            employee.setType(EmployeeRole.ADMIN);
            employee.setUser(user);
            employeeRepository.save(employee);
        }
        
        if (userRepository.findByUserName("game") == null) {
            User user = new User("game", "game");
            userRepository.save(user);

            Employee employee = new Employee();
            employee.setName("GAME");
            employee.setMail("game@gmail.com");
            employee.setType(EmployeeRole.GAME);
            employee.setUser(user);
            employeeRepository.save(employee);
        }

        http.cors().and().authorizeRequests()
                .antMatchers("/employee/**", "/buyer/create", "/buyer/edit"
                        , "/buyer/delete", "/user/**")
                .hasRole("ADMIN")
                .antMatchers("/game/create","/game/edit","/game/delete",
                        "/sale/**", "/ticket/**")
                .hasRole("GAME")
                .antMatchers("/report/**","/buyer/getAll","/game/getAll")
                .hasAnyRole("GAME","ADMIN")
                .antMatchers("/login/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // Permite todas las solicitudes desde cualquier origen
        configuration.addAllowedMethod("*"); // Permite todos los métodos HTTP
        configuration.addAllowedHeader("*"); // Permite todos los encabezados
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
