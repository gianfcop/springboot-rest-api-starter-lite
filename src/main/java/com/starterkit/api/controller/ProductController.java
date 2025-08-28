/*
 * Spring Boot API Starter Kit
 * Copyright (c) 2025 Gianfranco Coppola. All rights reserved.
 * Commercial use permitted. Redistribution prohibited.
 */
package com.starterkit.api.controller;

import com.starterkit.api.entity.Product;
import com.starterkit.api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "CRUD operations for products")
public class ProductController {

    private final ProductService productService;

    @Operation(
        summary = "Create a new product",
        description = "Creates a product with a name and category",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Product details",
            required = true,
            content = @Content(schema = @Schema(implementation = Product.class))
        ),
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Product successfully created",
                content = @Content(schema = @Schema(implementation = Product.class))
            )
        }
    )
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@RequestBody Product productRequest) {

        Product product = productService.createProduct(productRequest);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }


    @Operation(
        summary = "Get all products",
        description = "Retrieves a list of all products",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Successful retrieval",
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = Product.class)))
            )
        }
    )
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


    @Operation(
        summary = "Update an existing product",
        description = "Updates the details of an existing product by ID",
        parameters = {
            @Parameter(
                name = "id",
                description = "ID of the product to update",
                required = true,
                in = ParameterIn.PATH,
                example = "1"
            )
        },
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Updated product details",
            required = true,
            content = @Content(schema = @Schema(implementation = Product.class))
        ),
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Product updated successfully",
                content = @Content(schema = @Schema(implementation = Product.class))
            )
        }
    )
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product request) {
        
        Product product = productService.updateProduct(id, request);
        
        return ResponseEntity.ok(product);
    }

    @Operation(
        summary = "Delete a product",
        description = "Deletes a product by ID",
        parameters = {
            @Parameter(
                name = "id",
                description = "ID of the product to delete",
                required = true,
                in = ParameterIn.PATH,
                example = "1"
            )
        },
        responses = {
            @ApiResponse(
                responseCode = "204",
                description = "Product deleted successfully"
            )
        }
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        
        productService.deleteProduct(id);
        
        return ResponseEntity.noContent().build();
    }

}