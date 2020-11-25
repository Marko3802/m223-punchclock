package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
