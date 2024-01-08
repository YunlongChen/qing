package cn.chenyunlong.qing.config.security.password;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {

    private final UserDetailsService userDetailsService;

    @Override
    public void init(HttpSecurity http) throws Exception {
        // any method that adds another configurer
        // must be done in the init method
        http.csrf().disable();
        http.formLogin();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        myFilter.setFlag(flag);
        http.addFilterBefore(new PasswordLoginFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}