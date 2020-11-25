package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    private EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.saveAndFlush(entry);
    }

    public List<Entry> findAllByApplicationUserId(long id) {
        return entryRepository.getEntriesByApplicationUserId(id);
    }

    public void deleteEntry(Long id){
        entryRepository.deleteById(id);
    }

    public Entry updateEntry(Entry entry){
        return entryRepository.save(entry);
    }
}
