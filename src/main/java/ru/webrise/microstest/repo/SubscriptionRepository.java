package ru.webrise.microstest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.webrise.microstest.entity.Subscription;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query(value = """
            select s.id, s.web_service_name, s.web_service_url, s.web_service_user_id, count(fk_user) as cnt, fk_subscription
            from public.subscriptions s 
                join users_subscriptions us 
            on s.id=us.fk_subscription
            group by s.id, s.web_service_name, s.web_service_url, s.web_service_user_id, us.fk_subscription
            order by cnt desc
            limit 3;
            """,
            nativeQuery = true)
    List<Subscription> findTop3Popular();


    @Query(value = "DELETE from users_subscriptions WHERE fk_subscription = :id", nativeQuery = true)
    @Modifying
    void deleteFromSubscribersBySubscriptionId(@Param("id")Long id);
}
