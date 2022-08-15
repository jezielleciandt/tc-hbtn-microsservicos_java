package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Integer id) {
        return list.stream().filter(product -> product.getId().equals(id)).findAny().get();
    }

    public void addProduct(Product s) {
        if(s == null){
            throw new IllegalArgumentException("Produto inválido");
        }
        list.add(s);
    }

    public void updateProduct(Product s) {
        Product produtoFiltrado = list.stream().filter(product -> product.getId().equals(s.getId())).findAny().get();
        produtoFiltrado.setCode(s.getCode());
        produtoFiltrado.setName(s.getName());
        produtoFiltrado.setDescription(s.getDescription());
        produtoFiltrado.setPrice(s.getPrice());
        produtoFiltrado.setStatus(s.isStatus());
    }

    public void removeProduct(Product s) {
        if (list.contains(s)) {
            list.remove(s);
        } else {
            throw new IllegalArgumentException("Produto inválido");
        }
    }

    public void addList(List<Product> listOfProducts) {
        if(listOfProducts.size() != 0){
            list.addAll(listOfProducts);
        }
    }
}
