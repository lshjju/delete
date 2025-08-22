(... 생략 ...)
import jakarta.persistence.ManyToOne;
import com.mysite.sbb.user.SiteUser;
(... 생략 ...)
public class Question {
    (... 생략 ...)

    @ManyToOne
    private SiteUser author;
}
