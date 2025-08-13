package com.dto;

import java.time.LocalDateTime;

public interface UserDTO {
    public Long getUserId();
    public String getUsername();
    public String getEmail();
    public String getRoleName();
    public boolean isActive();
}
