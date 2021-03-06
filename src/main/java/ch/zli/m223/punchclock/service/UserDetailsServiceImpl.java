package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Company;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }

    public ApplicationUser createApplicationUser(ApplicationUser ApplicationUser) {
        return applicationUserRepository.saveAndFlush(ApplicationUser);
    }

    public List<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }

    public void deleteApplicationUser(Long id){
        applicationUserRepository.deleteById(id);
    }

    public void updateApplicationUser(ApplicationUser ApplicationUser){
        applicationUserRepository.save(ApplicationUser);
    }
    public ApplicationUser updateUser(ApplicationUser applicationUser, Long id) {
        applicationUserRepository.deleteById(id);
        applicationUser.setId(id);
        return applicationUserRepository.save(applicationUser);
    }
}
