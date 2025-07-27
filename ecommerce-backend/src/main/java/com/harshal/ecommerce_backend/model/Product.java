package com.harshal.ecommerce_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Add auto-generation
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    private String brand;

    @Column(nullable = false)
    private BigDecimal price;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @Column(nullable = false, columnDefinition = "boolean default true") // Fix null issue
    private boolean productAvailable = true; // Set default value

    private String category;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int stockQuantity = 0; // Set default value

    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;
}