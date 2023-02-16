package com.codegym.casemodule4.global;

import com.codegym.casemodule4.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart=new ArrayList<Product>();
    }
}
