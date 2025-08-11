package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InboundUserDTO implements UserDTO{
    private String userId;
    private String username;
    private String email;
    private String passwordHash;
    private String roleName;
    private boolean active;
}
