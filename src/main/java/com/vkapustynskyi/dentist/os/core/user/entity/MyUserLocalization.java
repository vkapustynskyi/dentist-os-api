package com.vkapustynskyi.dentist.os.core.user.entity;

import com.vkapustynskyi.dentist.os.core.localization.EntityLocalization;
import com.vkapustynskyi.dentist.os.core.user.embeddable.FullName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "lms_user_localization_first_name_idx", columnList = "first_name"),
        @Index(name = "lms_user_localization_last_name_idx", columnList = "last_name"),
        @Index(name = "lms_user_localization_patronymic_idx", columnList = "patronymic"),
        @Index(name = "lms_user_localization_lms_user_idx", columnList = "user_id")
})
public class MyUserLocalization extends EntityLocalization {

    @Embedded
    @AttributeOverride(name = "firstName", column = @Column(name = "first_name"))
    @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    @AttributeOverride(name = "patronymic", column = @Column(name = "patronymic"))
    private FullName fullName;

    @NotNull
    @ManyToOne
    private MyUser user;

}
