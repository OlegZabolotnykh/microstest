package ru.webrise.microstest.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import ru.webrise.microstest.dto.SubscriptionDto;
import ru.webrise.microstest.entity.Subscription;
import ru.webrise.microstest.repo.SubscriptionRepository;
import ru.webrise.microstest.util.SubscriptionMapper;

import java.util.List;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, SubscriptionMapper subscriptionMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionMapper = subscriptionMapper;
    }

    @Override
    public List<SubscriptionDto> getAllSubscriptions() {
        return subscriptionRepository.findAll().stream()
                .map(subscriptionMapper::toDto)
                .toList();
    }

    @Override
    public SubscriptionDto getSubscriptionById(Long id) {
        return subscriptionMapper.toDto(subscriptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Subscription with id=%s not found.", id))));
    }

    @Override
    public SubscriptionDto addNewSubscription(SubscriptionDto subscriptionDto) {
        return subscriptionMapper.toDto(subscriptionRepository.save(subscriptionMapper.fromDto(subscriptionDto)));
    }

    @Override
    public Subscription updateSubscription(Long id, Subscription subscription) {
        subscription.setId(id);
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public List<SubscriptionDto> getTop3Popular() {
        return subscriptionRepository.findTop3Popular().stream()
                .map(subscriptionMapper::toDto)
                .toList();
    }
}
