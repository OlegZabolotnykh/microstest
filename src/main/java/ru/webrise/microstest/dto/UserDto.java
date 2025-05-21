package ru.webrise.microstest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class UserDto {
    private Long id;

    private String username;

    private String name;

    private String lastname;

    private String email;

    private List<Long> subscriptionIds;

}
