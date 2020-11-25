package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> getEntriesByApplicationUserId(@Param("id") long id);
}
