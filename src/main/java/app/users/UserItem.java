package app.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserItem {

    private String login;
    private String fullName;
    private String password;
    private String role;
    private Long organization;
}
