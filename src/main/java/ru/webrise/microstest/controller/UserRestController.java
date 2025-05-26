package ru.webrise.microstest.controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.webrise.microstest.dto.UserDto;
import ru.webrise.microstest.entity.Subscription;
import ru.webrise.microstest.service.UserServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
@Slf4j
public class UserRestController {
    private final UserServiceImpl userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        log.debug("Get all users");
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable Long id) {
        log.debug("Get user by id={}", id);
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        log.debug("Add user. userDto={}", userDto);
        return userService.addUser(userDto);
    }

    @PutMapping("{id}")
    @Transactional
    public UserDto updateUser(@PathVariable Long id,
                              @RequestBody UserDto userDto) {
        log.debug("Update user. id={}, userDto={}", id, userDto);
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        log.debug("Delete user by id. id={}", id);
        userService.deleteUser(id);
    }

    @GetMapping("{id}/subscriptions")
    public Set<Subscription> getUserSubscriptions(@PathVariable Long id) {
        log.debug("Get user subscriptions. User id={}", id);
        return userService.getUserSubscriptions(id);
    }

    @DeleteMapping("{id}/subscriptions/{sub_id}")
    public void deleteUserSubscription(@PathVariable Long id, @PathVariable Long sub_id) {
        log.debug("Delete user subscription. User id={}, Subscription sub_id={}", id, sub_id);
        userService.deleteSubscription(id, sub_id);
    }
}
