package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    /*@Modifying
    @Query("update Company c set c.headquarter = ?1, c.name = ?2 where u.id = ?3")
    void updateCompanyJPQL(String headquarter, String name, Long id);*/
}
