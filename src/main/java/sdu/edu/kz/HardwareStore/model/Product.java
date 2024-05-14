package sdu.edu.kz.HardwareStore.model;

import lombok.Getter;
import lombok.Setter;

public class Product {
    @Getter
    private Long id;
    private String name;
    @Getter
    private Double price;
    @Setter
    @Getter
    private int stock;
    private String description;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;


}
