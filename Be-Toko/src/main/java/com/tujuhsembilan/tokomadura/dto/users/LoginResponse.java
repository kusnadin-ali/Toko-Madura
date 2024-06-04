package com.tujuhsembilan.tokomadura.dto.users;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse implements Serializable {
    private static final long serialVersionUID = -586587785432735L;

    private String token;

    private String role;

    private String email;

    private Long userId;
}
