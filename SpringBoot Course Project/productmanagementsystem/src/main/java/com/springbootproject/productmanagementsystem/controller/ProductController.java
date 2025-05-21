package com.springbootproject.productmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springbootproject.productmanagementsystem.model.Product;
import com.springbootproject.productmanagementsystem.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched all the products", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) })
    })
    @Tag(name = "get products", description = "get all products")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        
        return productService.getAllProducts();
    }

    @Operation(summary = "Get product with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched product with given id", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid product id is supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product with given id not found", content = @Content)
    })
    @Tag(name = "get product", description = "get product with given id")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {

        return productService.getProduct(id);
    }

    @Operation(summary = "Update product with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated product with given id", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid product id or RequestBody is supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product with given id or category with given categoryId not found", content = @Content)
    })
    @Tag(name = "update product", description = "update product with given id")
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, 
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Product to update", required = true,
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Product.class),
            examples = @ExampleObject(value = "{ \"name\": \"Product Name\", \"price\": \"Product Price\" }")))
            @RequestBody Product product,
            @RequestParam Long categoryId) {

        return productService.updateProduct(id, product, categoryId);
    }

    @Operation(summary = "Create product belonging to given category id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created product with given categoryId", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid categoryId or RequestBody is supplied", content = @Content),
            @ApiResponse(responseCode = "409", description = "Product with given name already exists", content = @Content)
    })
    @Tag(name = "create product", description = "create product belonging to category given by categoryId")
    @PostMapping
    public ResponseEntity<Product> createProduct(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Product to create", required = true,
        content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = Product.class),
        examples = @ExampleObject(value = "{ \"name\": \"Product Name\", \"price\": \"Product Price\" }")))
        @RequestBody Product product, @RequestParam Long categoryId) {
        
            return productService.createProduct(categoryId, product);
    }

    @Operation(summary = "Delete product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted product", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid product id is supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product with given id does not exist", content = @Content)
    })
    @Tag(name = "delete product", description = "delete product with given id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {

        return productService.deleteProduct(id);
    }

}
