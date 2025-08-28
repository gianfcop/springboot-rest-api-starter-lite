/*
 * Spring Boot API Starter Kit
 * Copyright (c) 2025 Gianfranco Coppola. All rights reserved.
 * Commercial use permitted. Redistribution prohibited.
 */

package com.starterkit.api.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.starterkit.api.entity.Category;
import com.starterkit.api.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    @Transactional
    public Category createCategory(Category category) {
        // Check if category already exists
        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category already exists: " + category.getName());
        }

        return categoryRepository.save(category);
    }

    
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
