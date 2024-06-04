package com.tujuhsembilan.tokomadura.dto.users;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest implements Serializable {
    private static final long serialVersionUID = -671672639954420L;

    private String email;

    private String password;

    private String rePassword;
}
