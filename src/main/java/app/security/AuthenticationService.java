package app.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationService {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object authenticated(CustomUserDetails userDetails) {
        Map<String, Object> response = new HashMap<>();
        response.put("login", userDetails.getUsername());
        return response;
    }

}
