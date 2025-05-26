package ru.webrise.microstest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.webrise.microstest.dto.SubscriptionDto;
import ru.webrise.microstest.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("api/v1/subscriptions")
@AllArgsConstructor
@Slf4j
public class SubscriptionRestController {

    private final SubscriptionService subscriptionService;

    @GetMapping
    public List<SubscriptionDto> getAllSubscriptions() {
        log.debug("Get all subscriptions");
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("{id}")
    public SubscriptionDto getSubscription(@PathVariable Long id) {
        log.debug("Get subscription by id={}", id);
        return subscriptionService.getSubscriptionById(id);
    }

    @PostMapping
    public SubscriptionDto addNewSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        log.debug("Add new subscription subscriptionDto={}", subscriptionDto);
        return subscriptionService.addNewSubscription(subscriptionDto);
    }

    @DeleteMapping("{id}")
    public void deleteSubscription(@PathVariable Long id) {
        log.debug("Delete subscription by id={}", id);
        subscriptionService.deleteSubscription(id);
    }

    @GetMapping("top")
    public List<SubscriptionDto> getTop3Popular() {
        log.debug("Get top-3 subscriptions");
        return subscriptionService.getTop3Popular();
    }
}
