package com.vkapustynskyi.dentist.os.core.user.entity;

import com.vkapustynskyi.dentist.os.core.entity.IdHolder;
import com.vkapustynskyi.dentist.os.core.user.entity.authority.Authority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public class MyUserDetails extends IdHolder implements UserDetails {

    @OneToOne(fetch = FetchType.EAGER)
    private MyUser user;

    private String password;

    private Boolean isAccountExpired;

    private Boolean isAccountLocked;

    private Boolean isCredentialsExpired;

    private Boolean isEnabled;

    @ManyToMany
    @JoinTable(
            name = "lms_user_details_lms_user_authorities",
            joinColumns = {@JoinColumn(name = "lms_user_details")},
            inverseJoinColumns = {@JoinColumn(name = "lms_authority")},
            foreignKey = @ForeignKey(name = "lms_user_details_lms_user_authorities_details_fk"),
            inverseForeignKey = @ForeignKey(name = "lms_user_details_lms_user_authorities_authority_fk")
    )
    private List<Authority> authorities;

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.isAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isAccountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isCredentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
}
