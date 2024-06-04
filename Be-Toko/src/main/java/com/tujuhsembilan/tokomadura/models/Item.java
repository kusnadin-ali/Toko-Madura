package com.tujuhsembilan.tokomadura.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "items_id")
    private Long itemsId;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @Column(name = "items_code")
    private String itemsCode;

    @Column(name = "items_name")
    private String itemsName;

    @Column(name = "last_re_stock")
    private Date lastReStock;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private BigDecimal stock;
}
