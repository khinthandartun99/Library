package com.example.myapp.Model;

import java.io.Serializable;

public class CategoriesData implements Serializable {

    private String categoriesName;
    private String quantity;

    public CategoriesData(String categoriesName,String quantity) {
        this.categoriesName = categoriesName;
        this.quantity=quantity;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public String getQuantity() {
        return quantity;
    }


}
