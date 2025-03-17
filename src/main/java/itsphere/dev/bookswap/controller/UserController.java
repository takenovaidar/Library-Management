package itsphere.dev.bookswap.controller;

import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.dto.UserRequest;
import itsphere.dev.bookswap.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update/{email}")
    public User updateUser(@PathVariable String email, @RequestBody UserRequest request) {
        return userService.updateUserByEmail(email, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

}
