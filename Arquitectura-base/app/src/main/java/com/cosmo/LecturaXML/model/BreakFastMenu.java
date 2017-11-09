package com.cosmo.LecturaXML.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.security.KeyStore;
import java.util.ArrayList;

/**
 * Created by Superadmin1 on 08/11/2017.
 */

@Root(name = "breakfast_menu")
public class BreakFastMenu {

    @ElementList(entry = "food", inline = true)
    ArrayList<Food> foodArrayList;

    public ArrayList<Food> getFoodArrayList() {
        return foodArrayList;
    }

    public void setFoodArrayList(ArrayList<Food> foodArrayList) {
        this.foodArrayList = foodArrayList;
    }
}
