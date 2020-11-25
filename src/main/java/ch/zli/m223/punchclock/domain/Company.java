package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String headquarter;

    @ManyToMany
    @JoinTable(
        name = "user_company",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "company_id"))
    Set<ApplicationUser> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(String headquarter) {
        this.headquarter = headquarter;
    }

    public Set<ApplicationUser> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<ApplicationUser> employees) {
        this.employees = employees;
    }
}
