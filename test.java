(... 생략 ...)
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
(... 생략 ...)

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    (... 생략 ...)
}
