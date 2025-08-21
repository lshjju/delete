(... 생략 ...)
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
(... 생략 ...)

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    (... 생략 ...)

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    
    
        return authenticationConfiguration.getAuthenticationManager();
    }
}
