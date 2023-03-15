package com.vkapustynskyi.dentist.os.core.localization;

import com.vkapustynskyi.dentist.os.core.entity.IdHolder;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityLocalization extends IdHolder {

    @NotNull
    private String locale;

}
