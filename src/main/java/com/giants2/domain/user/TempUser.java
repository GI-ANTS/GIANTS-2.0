package com.giants2.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TempUser {

    @Id
    private String email;
    private String certKey;

}
