package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Hier wird die Schnittstelle für die Company Entry sichergestellt
@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries(@RequestHeader(name = "Authorization") String token) {
        ApplicationUser user = ApplicationUser.parseToken(token);
        return entryService.findAllByApplicationUserId(user.getId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry,
                             @RequestHeader(name = "Authorization") String token) {
        ApplicationUser user = ApplicationUser.parseToken(token);
        entry.setApplicationUser(user);
        return entryService.createEntry(entry);
    }

    //Schnittstelle für delete entries/id
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntry(@PathVariable Long id){
        entryService.deleteEntry(id);
    }

    //Schnittstelle für delete entries/id
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Entry updateEntry(@Valid @RequestBody Entry entry, @PathVariable Long id){
        return entryService.updateEntry(entry);
    }
}
