package com.tujuhsembilan.tokomadura.dto.users;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto implements Serializable {
    private static final long serialVersionUID = -744828998007707L;

    private String email;
    private String name;
    private Integer role;
    private Long userId;
    
}
