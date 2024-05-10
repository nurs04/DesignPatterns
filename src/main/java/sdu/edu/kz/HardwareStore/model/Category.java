package sdu.edu.kz.HardwareStore.model;

import java.util.Set;

public class Category {

    private Long id;
    private String name;

//    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
