package ss17_binary_file.bai_tap.crud_binary_file.view;

import ss17_binary_file.bai_tap.crud_binary_file.controller.ProductController;

public class viewProduct {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.displayProduct();
    }
}
