package com.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Long productId;

    @Column(name = "ProductName", nullable = false, length = 100)
    private String productName;

    @Column(name = "Price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "StockQuantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "ImageUrl", nullable = false, length = 500)
    private String imageUrl;

    @Column(name = "IsActive", nullable = false)
    private boolean active;

    @Column(name = "ProductDescription", nullable = false, length = 1024)
    private String productDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId")
    private Category category;

    @Lob
    @Column(name = "Specifications", nullable = false)
    private String specifications;

    @Column(name = "CreationDate", nullable = false)
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
    }
}
