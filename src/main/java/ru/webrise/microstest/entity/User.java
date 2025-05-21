package ru.webrise.microstest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    private String name;

    private String lastname;

    private String email;

    @ManyToMany
    @JoinTable(
            name = "users_subscriptions",
            joinColumns = @JoinColumn(name = "fk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_subscription")
    )
    private Set<Subscription> subscriptions;

}
