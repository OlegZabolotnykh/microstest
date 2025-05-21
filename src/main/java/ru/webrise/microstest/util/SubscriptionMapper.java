package ru.webrise.microstest.util;

import org.springframework.stereotype.Component;
import ru.webrise.microstest.dto.SubscriptionDto;
import ru.webrise.microstest.entity.Subscription;

@Component
public class SubscriptionMapper {
    public SubscriptionDto toDto(Subscription subscription) {
        return new SubscriptionDto(
                subscription.getId(),
                subscription.getWebServiceName(),
                subscription.getWebServiceUrl(),
                subscription.getWebServiceUserId());
    }

    public Subscription fromDto(SubscriptionDto subDto) {
        return new Subscription(
                subDto.getId(),
                subDto.getWebServiceName(),
                subDto.getWebServiceUrl(),
                subDto.getWebServiceUserId());
    }
}
