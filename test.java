(... 생략 ...)
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;
(... 생략 ...)
@Service
public class UserService {

    (... 생략 ...)

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.finByusername(username);
    if(siteUser.isPresent()){
        return siteUser.get();
    }else{
        throw new DataNotFoundException("siteUser not found");
    }
}
