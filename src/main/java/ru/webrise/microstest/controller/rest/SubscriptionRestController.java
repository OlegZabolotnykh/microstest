package ru.webrise.microstest.controller.rest;

import org.springframework.web.bind.annotation.*;
import ru.webrise.microstest.dto.SubscriptionDto;
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
    public List<SubscriptionDto> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("{id}")
    public SubscriptionDto getSubscription(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @PostMapping
    public SubscriptionDto addNewSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        return subscriptionService.addNewSubscription(subscriptionDto);
    }

    @DeleteMapping("{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

    @GetMapping("top")
    public List<SubscriptionDto> getTop3Popular() {
        return subscriptionService.getTop3Popular();
    }
}
