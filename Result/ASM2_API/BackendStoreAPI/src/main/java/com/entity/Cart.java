package com.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cart", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"UserId", "ProductId"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CartPK.class)
public class Cart {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    public void setUser(User user) {
        this.user = user;
        if (user != null && !user.getCarts().contains(this)) {
            user.getCarts().add(this);
        }
    }

    public void setProduct(Product product) {
        this.product = product;
        if (product != null && !product.getCarts().contains(this)) {
            product.getCarts().add(this);
        }
    }
}
