package ru.webrise.microstest.controller.rest;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.webrise.microstest.dto.UserDto;
import ru.webrise.microstest.entity.Subscription;
import ru.webrise.microstest.service.UserServiceImpl;
import ru.webrise.microstest.util.UserMapper;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/users")
public class UserRestController {
    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    public UserRestController(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PutMapping("{id}")
    @Transactional
    public UserDto updateUser(@PathVariable Long id,
                           @RequestBody UserDto userDto) {

        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("{id}/subscriptions")
    public Set<Subscription> getUserSubscriptions(@PathVariable Long id) {
        return userService.getUserSubscriptions(id);
    }

    @DeleteMapping("{id}/subscriptions/{sub_id}")
    public void deleteUserSubscription(@PathVariable Long id, @PathVariable Long sub_id) {
        userService.deleteSubscription(id, sub_id);
    }

}
