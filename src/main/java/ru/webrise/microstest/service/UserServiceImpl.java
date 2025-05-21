package ru.webrise.microstest.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.webrise.microstest.dto.UserDto;
import ru.webrise.microstest.entity.Subscription;
import ru.webrise.microstest.entity.User;
import ru.webrise.microstest.repo.SubscriptionRepository;
import ru.webrise.microstest.repo.UserRepository;
import ru.webrise.microstest.util.UserMapper;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final SubscriptionRepository subscriptionRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, SubscriptionRepository subscriptionRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("User with id=%s doesnt exists", id))
        ));
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        return userMapper.toDto(userRepository.save(userMapper.fromDto(userDto)));
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userMapper.fromDto(userDto);
        user.setId(id);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteSubscription(Long userId, Long subscriptionId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id %s not found".formatted(userId)));
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new EntityNotFoundException("Subscription with id = %s not found".formatted(subscriptionId)));
        user.getSubscriptions().remove(subscription);
        System.out.println(user);
    }

    @Override
    public Set<Subscription> getUserSubscriptions(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id = %s not found".formatted(id)))
                .getSubscriptions();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }
}
