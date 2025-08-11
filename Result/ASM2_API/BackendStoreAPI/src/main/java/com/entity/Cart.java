package com.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cart")
@IdClass(CartPK.class)
@NoArgsConstructor
public class Cart {

    @Id
    @Column(name = "UserId", nullable = false)
    private Long userId;

    @Id
    @Column(name = "ProductId", nullable = false)
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", insertable = false, updatable = false)
    private Product product;

    private int quantity;
}
