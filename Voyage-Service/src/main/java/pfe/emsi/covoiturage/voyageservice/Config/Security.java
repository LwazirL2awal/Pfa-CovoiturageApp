package pfe.emsi.covoiturage.voyageservice.Config;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.crypto.spec.SecretKeySpec;


@Configuration
public class Security implements ApplicationContextAware {


    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity security) throws Exception {

        security
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin( login -> login.disable())
                .authorizeHttpRequests(
                        auth ->
                                auth
//                                        .requestMatchers("/h2-console/*","/api/*").permitAll()
                                        .requestMatchers("/verification","/api/auth/signup","/api/auth/login","/api/auth/valid","/h2-console/*","/verify","/api","/h2-console","/api/region/get","/api/crop/get","/api/crop/get/**").permitAll()
                                       .anyRequest().authenticated()
                                        // .anyRequest().permitAll()
                )
                .headers(AbstractHttpConfigurer::disable);
        return security.build();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
