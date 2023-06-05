package com.pthienquan1.productservice.controller;

import com.pthienquan1.productservice.dto.ProductRequest;
import com.pthienquan1.productservice.dto.ProductResponse;
import com.pthienquan1.productservice.model.Product;
import com.pthienquan1.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by quan0
 * Date 6/4/2023 - 4:16 PM
 * Description: ...
 */
@RestController
@RequestMapping("api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
