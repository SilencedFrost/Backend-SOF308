package com.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Long userId;

    @Column(name = "Username", nullable = false, length = 32, unique = true)
    private String username;

    @Column(name = "Email", nullable = false, length = 254, unique = true)
    private String email;

    @Column(name = "PasswordHash", nullable = false, length = 64)
    private String passwordHash;

    @Column(name = "CreationDate", nullable = false)
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleId", nullable = false)
    private Role role;

    @Column(name = "IsActive", nullable = false)
    private boolean isActive;

    @Column(name = "LastLoginDate")
    private LocalDateTime lastLoginDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public void setRole(Role role) {
        this.role = role;
        if (role != null && !role.getUsers().contains(this)) {
            role.getUsers().add(this);
        }
    }
}
