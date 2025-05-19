package ru.webrise.microstest.service;

import ru.webrise.microstest.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> getAllSubscriptions();

    Subscription getSubscriptionById(Long id);

    Subscription addNewSubscription(Subscription subscription);

    Subscription updateSubscription(Long id, Subscription subscription);

    void deleteSubscription(Long id);
}
