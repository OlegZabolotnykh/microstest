package ru.webrise.microstest.service;

import ru.webrise.microstest.dto.SubscriptionDto;
import ru.webrise.microstest.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<SubscriptionDto> getAllSubscriptions();

    SubscriptionDto getSubscriptionById(Long id);

    SubscriptionDto addNewSubscription(SubscriptionDto subscriptionDto);

    Subscription updateSubscription(Long id, Subscription subscription);

    void deleteSubscription(Long id);

    List<SubscriptionDto> getTop3Popular();
}
