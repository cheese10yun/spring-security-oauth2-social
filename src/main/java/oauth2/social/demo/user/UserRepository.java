package oauth2.social.demo.user;


import oauth2.social.demo.social.userconnection.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySocial(UserConnection userConnection);

}
