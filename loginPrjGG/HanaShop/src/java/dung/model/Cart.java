/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.model;

import dung.dtos.FoodDto;
import java.util.HashMap;

/**
 *
 * @author Haima
 */
public class Cart {

    private HashMap<String, FoodDto> items;

    public HashMap<String, FoodDto> getItems() {
        return items;
    }

    public void setItems(HashMap<String, FoodDto> items) {
        this.items = items;
    }

    public Cart() {
        items = new HashMap<>();
    }

    public void AddtoCart(FoodDto dto) throws Exception {
        String key = String.valueOf(dto.getFoodID());
        if (items == null) {
            items = new HashMap<>();
        }
        if (this.items.containsKey(key)) {
            int oldQuantity = ((FoodDto) this.items.get(key)).getQuantity();
            ((FoodDto) this.items.get(key)).setQuantity(oldQuantity + 1);
        } else {

            this.items.put(String.valueOf(dto.getFoodID()), dto);
        }
    }

    public float getTotal() throws Exception {
        float result = 0;
        for (FoodDto dto : this.items.values()) {
            result += (dto.getPrice()) * dto.getQuantity();

        }
        return result;
    }


    public void removeCart(String id) throws Exception {
        if (items.containsKey(id)) {
            items.remove(id);
        }
    }

    public void updateCart(String id, int quantity) throws Exception {
        if (items.containsKey(id)) {
            items.get(id).setQuantity(quantity);
        }
    }

    public void clear() {
        items.clear();
    }
}
