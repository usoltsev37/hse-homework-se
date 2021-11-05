package ru.hse.soundmapping.model;

import com.stfalcon.chatkit.commons.models.IUser;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class User implements Serializable {
    private String userMail;

    private String name;

    private String avatarUrl;
}
