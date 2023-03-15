package com.vkapustynskyi.dentist.os.core.user.entity.authority;

import com.vkapustynskyi.dentist.os.core.entity.IdHolder;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
public class Authority extends IdHolder implements GrantedAuthority {

    @NotNull
    private String name;

    private String iconUrl;

    @Override
    public String getAuthority() {
        return this.name;
    }

}
