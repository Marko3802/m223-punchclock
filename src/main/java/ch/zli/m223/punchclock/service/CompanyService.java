package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Company;
import ch.zli.m223.punchclock.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(Company Company) {
        return companyRepository.saveAndFlush(Company);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }
    
    public Company updateCompany(Company company, Long id) {
        companyRepository.deleteById(id);
        company.setId(id);
        return companyRepository.save(company);
    }

    public void findById(Long id){
        companyRepository.findById(id);
    }
}
