package app.users;

import app.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(@RequestParam("size") Long size, @RequestParam("page") Long page, @RequestParam("text") String text) {
        return userService.findAll(size, page, text);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User save(@RequestBody User entity, CustomUserDetails userDetails) {
        return userService.save(entity, userDetails);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Object findOneById(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @RequestMapping(value = "/findByLogin", method = RequestMethod.POST)
    public User findByLogin(@RequestBody UserDto field) {
        return userService.findByLogin(field.getValue());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/currentUser")
    public User currentUser(Principal principal) {
        return userService.currentUser(principal);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        return userService.save(user);
    }
}
