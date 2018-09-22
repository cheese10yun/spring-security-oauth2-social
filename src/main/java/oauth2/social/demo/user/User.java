package oauth2.social.demo.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import oauth2.social.demo.social.userconnection.UserConnection;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id", nullable = false, updatable = false, unique = true)
    private UserConnection social;

    @Builder
    private User(String email, String nickname, UserConnection social) {
        this.email = email;
        this.nickname = nickname;
        this.social = social;
    }

    public static User signUp(UserConnection userConnection) {

        return User.builder()
                .email(userConnection.getEmail())
                .nickname(userConnection.getDisplayName())
                .social(userConnection)
                .build();

    }


}