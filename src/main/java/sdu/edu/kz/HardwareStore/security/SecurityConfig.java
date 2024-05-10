package sdu.edu.kz.HardwareStore.security;

import sdu.edu.kz.HardwareStore.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true, securedEnabled = true)
public class SecurityConfig {

    @Autowired
    private UserServiceImpl userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);


        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());

        http.exceptionHandling().accessDeniedPage("/forbidden");
        http.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll();


        http.formLogin()
                .loginPage("/")
                .loginProcessingUrl("/auth")

                .usernameParameter("user_email")
                .passwordParameter("user_password")
                .defaultSuccessUrl("/shopMainPage")
                .failureUrl("/auth?error");

        http.logout()
                .logoutSuccessUrl("/")
                .logoutUrl("/signOut");

        http.csrf().disable();

        return http.build();
    }
}