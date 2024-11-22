package com.core.qualifier;

import org.springframework.stereotype.Component;

@Component("cocacola")
public class CocaCola implements ColdDrink{
    @Override
    public void drink() {
        System.out.println("Drinking CocaCola");
    }
}
