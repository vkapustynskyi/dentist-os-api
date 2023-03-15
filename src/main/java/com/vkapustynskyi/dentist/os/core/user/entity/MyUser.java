package com.vkapustynskyi.dentist.os.core.user.entity;

import com.vkapustynskyi.dentist.os.core.entity.IdHolder;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class MyUser extends IdHolder {

    @NotNull
    private String email;

    @OneToMany(mappedBy = "user")
    private List<MyUserLocalization> localizations;

    @OneToOne(mappedBy = "user")
    private MyUserDetails userDetails;

}
