package com.patika;

import java.util.Date;
import lombok.*;

@Getter
@Setter
public abstract class User {
    private String username;
    private String password;
    private String email;
    private Date lastLogin;

    // Getters and setters
}
