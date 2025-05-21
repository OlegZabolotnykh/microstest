package ru.webrise.microstest.service;

import ru.webrise.microstest.dto.UserDto;
import ru.webrise.microstest.entity.Subscription;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto addUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    void deleteSubscription(Long userId, Long subscriptionId);

    Set<Subscription> getUserSubscriptions(Long id);
}
