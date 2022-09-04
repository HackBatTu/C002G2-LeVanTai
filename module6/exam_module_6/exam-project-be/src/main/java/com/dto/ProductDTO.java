package com.dto;

import com.model.Employee;
import com.model.Order;
import com.model.Product;
import com.model.ProductType;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
public class ProductDTO implements Validator {

    private Integer id;

    @NotEmpty(message = "vui lòng điền thông tin")
    private String codeProduct;

    @NotBlank(message = "vui lòng điền thông tin")
    private String name;

    @NotBlank(message = "vui lòng điền thông tin")
    private Double unitPrice;

    @NotBlank(message = "vui lòng điền thông tin")
    @Pattern(regexp = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$",
            message = "Vui lòng nhập đúng định dạng yyyy/MM/dd")
    @Column(columnDefinition = "date")
    private Date dateCheckIn;

    private Boolean statusProduct;

    private String country;

    private Boolean statusDrink;

    private Boolean statusFood;

    private String author;

    private String bookType;

    private Date dateIn;

    private ProductType productType;

    private Employee employee;

    private List<Product> productList;

    private List<Order> orderList;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        List<Product> products = this.getProductList();
        if(!products.isEmpty()){
            for (Product product: products){
                if(product.getCodeProduct().equals(productDTO.getCodeProduct())){
                    errors.rejectValue("codeProduct", "", "codeProductExists");
                    break;
                }
            }
        }
    }
}
