package loginsocialapi.controller;


import loginsocialapi.entity.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {

    ArrayList productos = new ArrayList(){{
        add(new Producto("product1", 10));
        add(new Producto("product2", 20));
        add(new Producto("product3", 30));
        add(new Producto("product4", 40));
    }};

    @GetMapping("/lista")
    public ResponseEntity<List<Producto>> lista(){
        return new ResponseEntity(productos, HttpStatus.OK);
    }
}
