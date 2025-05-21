package ru.webrise.microstest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SubscriptionDto {
    private Long id;

    private String webServiceName;

    private String webServiceUrl;

    private String webServiceUserId;
}
