package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.domain.Company;
import ch.zli.m223.punchclock.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Hier wird die Schnittstelle für die Company Entity sichergestellt
@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies() {
        return companyService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany(@Valid @RequestBody Company company) {
        return companyService.createCompany(company);
    }

    //Schnittstelle für delete companies/id
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }

    //Schnittstelle für put companies/id
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company updateCompany(@Valid @RequestBody Company company, @PathVariable Long id){
        return companyService.updateCompany(company, id);
    }
}
