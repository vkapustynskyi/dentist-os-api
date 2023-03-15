package com.vkapustynskyi.dentist.os.core.user.embeddable;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class FullName {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String patronymic;

}
