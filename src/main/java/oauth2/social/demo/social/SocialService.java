package oauth2.social.demo.social;


import lombok.AllArgsConstructor;
import oauth2.social.demo.social.userconnection.UserConnection;
import oauth2.social.demo.user.User;
import oauth2.social.demo.user.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@AllArgsConstructor
public class SocialService {

    private final UserService userService;

    public UsernamePasswordAuthenticationToken doSomething(UserConnection userConnection) {

        if (userService.isExistUser(userConnection)) {
            // 로그인 처리
            final User user = userService.findBySocial(userConnection);
            return setAuthenticationToken(user);
        } else {
            final User user = userService.signUp(userConnection);
            return setAuthenticationToken(user);

        }
    }


    private UsernamePasswordAuthenticationToken setAuthenticationToken(Object user) {
        return new UsernamePasswordAuthenticationToken(user, null, getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

}
