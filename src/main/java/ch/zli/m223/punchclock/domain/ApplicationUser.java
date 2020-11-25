package ch.zli.m223.punchclock.domain;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "applicationUser")
    @JsonIgnoreProperties(value = "applicationUser")
    private List<Entry> entries;

    @ManyToMany(mappedBy = "employees")
    Set<Company> companiesWorkingIn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public Set<Company> getCompaniesWorkingIn() {
        return companiesWorkingIn;
    }

    public void setCompaniesWorkingIn(Set<Company> companiesWorkingIn) {
        this.companiesWorkingIn = companiesWorkingIn;
    }

    public static ApplicationUser parseToken(String token) {
        DecodedJWT claim = JWT.decode(token.replace("Bearer", ""));
        ApplicationUser user = new ApplicationUser();
        user.setId(claim.getClaim("id").asLong());
        user.setUsername(claim.getSubject());
        return user;
    }
}
