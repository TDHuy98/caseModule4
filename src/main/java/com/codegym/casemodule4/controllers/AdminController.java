package com.codegym.casemodule4.controllers;

import com.codegym.casemodule4.dto.ProductDTO;
import com.codegym.casemodule4.entities.Category;
import com.codegym.casemodule4.entities.Product;
import com.codegym.casemodule4.repositories.CategoryRepository;
import com.codegym.casemodule4.services.CategoryService;
import com.codegym.casemodule4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {


    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String category(ModelMap model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCategoriesAdd(ModelMap model) {

            model.addAttribute("category", new Category());
            return "categoriesAdd";

    }

    @PostMapping("/admin/categories/add")
    public String postCategoriesAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCartegory(@PathVariable Integer id) {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable Integer id, ModelMap model) throws DataAccessException {
        try {
            Optional<Category> category = categoryService.getCategoryById(id);
            if (category.isPresent()) {
                model.addAttribute("category", category.get());
                return "categoriesAdd";
            } else return "404";

        } catch (DataAccessException  exception) {
            String messages = "Category đã tồn tại";
            model.addAttribute("messages", messages);
            Optional<Category> category = categoryService.getCategoryById(id);
            if (category.isPresent()) {
                model.addAttribute("category", category.get());
                return "categoriesAdd";
            } else return "404";
        }

    }


    //Product

    @GetMapping("/admin/products")
    public String getAllProduct(ModelMap model) {
        model.addAttribute("products", productService.getProductsList());
        return "products";
    }

    //thêm product
    @GetMapping("/admin/products/add")
    public String getProductsAdd(ModelMap model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.getCategoryList());
        return "productsAdd";
    }


    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/admin/products/add")
    public String postProductAdd(@ModelAttribute("productDTO") ProductDTO productDTO,
                                 @RequestParam("productImage") MultipartFile file,
                                 @RequestParam("img") String img) throws IOException {
        Product product = new Product();
        product.setId(product.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = img;
        }
        product.setImage(imageUUID);
        productService.createProduct(product);

        return "redirect:/admin/products";
    }

    //Xóa product


    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

//Cập nhật product
    @GetMapping("/admin/products/update/{id}")
    public String updateProduct(@PathVariable Long id, ModelMap model) {
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setImage(product.getImage());

        model.addAttribute("productDTO", productDTO);
        model.addAttribute("categories", categoryService.getCategoryList());
        return "productsAdd";

    }

}
