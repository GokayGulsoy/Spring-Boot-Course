package com.springbootproject.productmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.productmanagementsystem.model.ProductCategory;
import com.springbootproject.productmanagementsystem.service.ProductCategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/productcategories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService categoryService;

    @Operation(summary = "Get all product categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched all the product categories", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductCategory.class)) })
    })
    @Tag(name = "get product categories", description = "get all product categories")
    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllCategories() {

        return categoryService.getAllCategories();
    }

    @Operation(summary = "Get product category with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched product category with given id", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductCategory.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid product category id is supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product category with given id not found", content = @Content)
    })
    @Tag(name = "get product category", description = "get product category with given id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getCategory(@PathVariable Long id) {

        return categoryService.getCategory(id);
    }

    @Operation(summary = "Create product category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create product category with given RequestBody", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductCategory.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid RequestBody is supplied", content = @Content),
            @ApiResponse(responseCode = "409", description = "Product category with given name already exists", content = @Content)
    })
    @Tag(name = "create product category", description = "create product category matching with RequestBody")
    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Product category to update", required = true,
        content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = ProductCategory.class),
        examples = @ExampleObject(value = "{ \"name\": \"Category Name\" }")))
        @RequestBody ProductCategory category) {

        return categoryService.createProductCategory(category);
    }

    @Operation(summary = "Update name of product category with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update product category with given id", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductCategory.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid product category id or Request body is supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product category with given id not found", content = @Content)
    })
    @Tag(name = "update product category", description = "update product category with given id")
    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateCategory(@PathVariable Long id,
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Product category to update", required = true,
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = ProductCategory.class),
      examples = @ExampleObject(value = "{ \"name\": \"Category Name\" }")))        
    @RequestBody ProductCategory category) {
        
        return categoryService.updateCategory(id, category);
    }

    @Operation(summary = "Delete product category with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted product category with given id", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductCategory.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid product category id is supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product category with given id not found", content = @Content)
    })
    @Tag(name = "delete product category", description = "delete product category with given id")
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductCategory> deleteCategory(@PathVariable Long id) {

        return categoryService.deleteCategory(id);
    }

}
