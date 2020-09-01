package yte.intern.spring.application.usecases.manageevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.spring.application.usecases.manageevent.entity.Event;

import javax.transaction.Transactional;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByEventName(String eventName);

    @Transactional
    void deleteByEventName(String eventName);
}
