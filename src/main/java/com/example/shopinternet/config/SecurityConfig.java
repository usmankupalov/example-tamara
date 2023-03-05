package com.example.shopinternet.config;

import com.example.shopinternet.security.AuthEntryPointJwt;
import com.example.shopinternet.security.JwtFilter;
import com.example.shopinternet.service.model.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthEntryPointJwt authEntryPointJwt;

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                        .exceptionHandling().authenticationEntryPoint(authEntryPointJwt)
                        .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()


                .mvcMatchers("/v1.0/login", "/v1.0/users", "/v1.0/admins").permitAll()
                .mvcMatchers("/v1.0/models").permitAll()


                .mvcMatchers("/v1.0/cars").permitAll()
                .mvcMatchers("/v1.0/cars/{carsId}").permitAll()

                .mvcMatchers("/v1.0/carModels").permitAll()
                .mvcMatchers("/v1.0/carModels/{carModelsId}").permitAll()

                .mvcMatchers("/v1.0/generations").permitAll()
                .mvcMatchers("/v1.0/generations/{generationsId}").permitAll()

                .mvcMatchers("/v1.0/bodies").permitAll()
                .mvcMatchers("/v1.0/bodies/{bodiesId}").permitAll()

                .mvcMatchers("/v1.0/engines").permitAll()
                .mvcMatchers("/v1.0/engines/{enginesId}").permitAll()

                .mvcMatchers("/v1.0/details").permitAll()
                .mvcMatchers("/v1.0/search/details").permitAll()
                .mvcMatchers("/v1.0/details/{detailsId}").permitAll()
                .mvcMatchers("/v1.0/details/{enginesId}").permitAll()

                .mvcMatchers("/v1.0/catalogs").permitAll()
                .mvcMatchers("/v1.0/catalogs/{catalogsId}").permitAll()
                .mvcMatchers("/v1.0/hitProducts").permitAll()
                .mvcMatchers("/v1.0/hitProducts/{hitProductsId}").permitAll()
                .mvcMatchers("/v1.0/hitProducts/{catalogsId}").permitAll()

                .mvcMatchers("/v1.0/cars/{carId}/carModels").permitAll()
                .mvcMatchers("/v1.0/cars/carModels/{carModelId}/generations", "/v1.0/cars/carModels/generations/{generationId}/bodies").permitAll()
                .mvcMatchers("/v1.0/cars/carModels/generations/bodies/{bodyId}/engines", "/v1.0/cars/carModels/generations/bodies/engines/{engineId}/details").permitAll()

                .mvcMatchers("/v1.0/images/{imageName}").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
