package ru.webrise.microstest.controller.rest;

import org.springframework.web.bind.annotation.*;
import ru.webrise.microstest.entity.Subscription;
import ru.webrise.microstest.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("api/v1/subscriptions")
public class SubscriptionRestController {

    private final SubscriptionService subscriptionService;

    public SubscriptionRestController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("{id}")
    public Subscription getSubscription(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @PostMapping
    public Subscription addNewSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addNewSubscription(subscription);
    }

    @DeleteMapping("{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

}
