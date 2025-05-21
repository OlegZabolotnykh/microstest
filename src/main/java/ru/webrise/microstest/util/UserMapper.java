package ru.webrise.microstest.util;

import org.springframework.stereotype.Component;
import ru.webrise.microstest.dto.UserDto;
import ru.webrise.microstest.entity.Subscription;
import ru.webrise.microstest.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(), user.getUsername(), user.getName(), user.getLastname(), user.getEmail(),
                user.getSubscriptions().stream().map(Subscription::getId).toList());
    }

    public User fromDto(UserDto userDto) {
        Set<Subscription> subscriptionSet = userDto.getSubscriptionIds().stream()
                .map((id) -> new Subscription(id, null, null, null))
                .collect(Collectors.toSet());
        return new User(null, userDto.getUsername(), userDto.getName(), userDto.getLastname(), userDto.getEmail(),
                subscriptionSet);
    }
}
