package com.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartPK implements Serializable {

    private Long user;
    private Long product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartPK)) return false;
        CartPK that = (CartPK) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, product);
    }
}
