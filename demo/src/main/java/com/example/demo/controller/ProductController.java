package com.example.demo.controller;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.Iterator;

@Controller
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/getProductByCategoryID/{categoryID}", method = RequestMethod.GET)
    public String getProductList(ModelMap modelMap, @PathVariable String categoryID) {
        Iterable<Product> products = productRepository.findByCategoryID(categoryID);
        modelMap.addAttribute("products", products);
        return "product";
    }

    @RequestMapping(value = "/deleteProduct/{productID}", method = RequestMethod.POST)
    public String deleteProduct(ModelMap modelMap, @PathVariable String productID) {
        try{
            productRepository.deleteById(productID);
            return "redirect:/main";
        }catch (Exception ex){
            modelMap.addAttribute("error", ex.toString());
            return "product";
        }
    }

    @RequestMapping(value = "/changeInforProduct/{productID}", method = RequestMethod.GET)
    public String changeInforProduct(ModelMap modelMap, @PathVariable String productID) {
        Iterable<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("product", productRepository.findById(productID).get());
        return "updateProduct";
    }

    @RequestMapping(value = "/updateProduct/{productID}", method = RequestMethod.POST)
    public String updateProduct(ModelMap modelMap,
                                @Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult,
                                @PathVariable String productID) {
        if(bindingResult.hasErrors()){
            modelMap.addAttribute("categories", categoryRepository.findAll());
            return "updateProduct";
        }
        try{
            if(productRepository.findById(product.getProductID()).isPresent()) {
                Product foundProduct = productRepository.findById(product.getProductID()).get();
                if(!product.getProductName().trim().isEmpty()) {
                    foundProduct.setProductName(product.getProductName());
                }
                if(!product.getCategoryID().isEmpty()) {
                    foundProduct.setCategoryID(product.getCategoryID());
                }
                if(product.getProductPrice() > 0) {
                    foundProduct.setProductPrice(product.getProductPrice());
                }
                if(product.getProductNumbers() > 0) {
                    foundProduct.setProductNumbers(product.getProductNumbers());
                }
                productRepository.save(foundProduct);
            }
        }catch (Exception ex) {
            modelMap.addAttribute("error", ex.toString());
            return "updateProduct";
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
    public String insertProduct(ModelMap modelMap) {
        Iterable<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("product", new Product());
        modelMap.addAttribute("categories", categories);
        return "insertProduct";
    }

    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public String insertProduct(ModelMap modelMap,
                                @Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult) {

        if(bindingResult.hasErrors() == true) {
            modelMap.addAttribute("categories", categoryRepository.findAll());
            return "insertProduct";
        }
        try{
            productRepository.save(product);
            return "redirect:/products/getProductByCategoryID/" + product.getCategoryID();
        }catch (Exception ex) {
            modelMap.addAttribute("categories", categoryRepository.findAll());
            modelMap.addAttribute("error", ex.toString());
            return "insertProduct";
        }
    }

    @RequestMapping(value = "/detailProduct/{productID}", method = RequestMethod.GET)
    public String getDetailProduct(ModelMap modelMap, @PathVariable String productID) {
        modelMap.addAttribute("product", productRepository.findById(productID).get());
        return "detailProduct";
    }
}
