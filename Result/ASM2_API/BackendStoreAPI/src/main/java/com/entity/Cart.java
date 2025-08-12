package com.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Cart",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"UserId", "ProductId"})
        })
public class Cart {

    @EmbeddedId
    private CartPK id;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    // Convenience accessors
    public User getUser() {
        return id != null ? id.getUser() : null;
    }

    public Product getProduct() {
        return id != null ? id.getProduct() : null;
    }

    public void setUser(User user) {
        if (id == null) id = new CartPK();
        id.setUser(user);
        if (user != null) {
            user.getCarts().add(this);
        }
    }

    public void setProduct(Product product) {
        if (id == null) id = new CartPK();
        id.setProduct(product);
        if (product != null) {
            product.getCarts().add(this);
        }
    }
}
