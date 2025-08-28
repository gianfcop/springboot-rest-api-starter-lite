/*
 * Spring Boot API Starter Kit
 * Copyright (c) 2025 Gianfranco Coppola. All rights reserved.
 * Commercial use permitted. Redistribution prohibited.
 */
package com.starterkit.api.controller;

import com.starterkit.api.entity.Category;
import com.starterkit.api.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Tag(name = "Categories", description = "Create and read operations for categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(
        summary = "Create a new category",
        description = "Creates a category with a name",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Category details",
            required = true,
            content = @Content(schema = @Schema(implementation = Category.class))
        ),
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Category successfully created",
                content = @Content(schema = @Schema(implementation = Category.class))
            )
        }
    )
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> createCategory(@RequestBody Category request) {
        Category category = categoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @Operation(
        summary = "Get all categories",
        description = "Retrieves a list of all categories",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Successful retrieval",
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = Category.class)))
            )
        }
    )
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
