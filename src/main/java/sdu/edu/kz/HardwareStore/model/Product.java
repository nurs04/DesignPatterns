package sdu.edu.kz.HardwareStore.model;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;


}
