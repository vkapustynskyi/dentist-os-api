package com.vkapustynskyi.dentist.os.core.tenant;

import com.vkapustynskyi.dentist.os.core.entity.IdHolder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TenantConfig extends IdHolder {

    @Column(unique = true, nullable = false)
    private String name;

}
