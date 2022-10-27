package shoponlineapi.dto;

import lombok.Data;
import shoponlineapi.enlity.Category;

import java.util.Date;

@Data
public class ProductDTO {
    private Integer id;
    private String image;
    private String name;
    private Date dateIn;
    private double price;
    private String manufacturer;
    private String guaranteeTime;
    private String discount;
    private Integer quantity;
    private String specification;
    private String description;

    private Category category;
    private Boolean isDeleted;
}
