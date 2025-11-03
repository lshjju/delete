(... 생략 ...)
import com.mysite.sbb.user.SiteUser;
(... 생략 ...)
public class Answer {
    (... 생략 ...)

    @ManyToOne
    private SiteUser author;
}
