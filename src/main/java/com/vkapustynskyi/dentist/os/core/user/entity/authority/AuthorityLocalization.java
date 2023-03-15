package com.vkapustynskyi.dentist.os.core.user.entity.authority;

import com.vkapustynskyi.dentist.os.core.localization.EntityLocalization;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AuthorityLocalization extends EntityLocalization {

    @NotBlank
    private String displayName;

    @NotNull
    @ManyToOne
    private Authority authority;

}
