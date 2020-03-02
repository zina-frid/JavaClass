package com.company;

import java.util.HashMap;
import java.util.Map;

public class PriceCurrent {
    private final Map<Integer, Product> priceCurrent = new HashMap<>();

    public Product getProductByCode(int code) {
        return priceCurrent.get(code);
    }


    /**
     * Добавление нового товара
     * Возвращает true, если товар успешно добавлен.
     * В ином случае возвращает false
     */

    public boolean addProduct(int code, Product product) {
        if (priceCurrent.containsKey(code)) {
            return false;
        }
        priceCurrent.put(code, product);
        return true;
    }

    /**
     * Изменение цены товара
     * Возвращает true, если цена товара успешно изменена.
     * В ином случае возвращает false
     */

    public boolean changePrice(int code, Price newPrice) {
        if (priceCurrent.containsKey(code)) {
            priceCurrent.get(code).setPrice(newPrice);
            return true;
        }
        return false;
    }

    /**
     * Изменение имени товара
     * Возвращает true, если имя товара успешно изменена.
     * В ином случае возвращает false
     */

    public boolean changeName(int code, String newName) {
        if (priceCurrent.containsKey(code)) {
            priceCurrent.get(code).setName(newName);
            return true;
        }
        return false;
    }

    /**
     * Удаление товара
     * Возвращает true, если товар успешно удален.
     * В ином случае возвращает false
     */

    public boolean removeProduct(int code) {
        return priceCurrent.remove(code) != null;
    }

    /**
     * Возврат конечной стоимости товара по его коду и количеству экземпляров
     */

    public Price finalCost(int code, int amount) {
        int rubles = priceCurrent.get(code).getPrice().getRubles() * amount +
                priceCurrent.get(code).getPrice().getPennies() * amount / 100;
        int pennies =  priceCurrent.get(code).getPrice().getPennies() * amount % 100;
        return new Price(rubles, pennies);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        {
            for (Integer code : priceCurrent.keySet()) {
                builder.append("Code: ").append(code).
                        append(" Name: ").append(priceCurrent.get(code).getName()).
                        append(" Price: ").append(priceCurrent.get(code).getPrice()).append("\n");
            }
            return builder.toString();
        }
    }


    @Override
    public int hashCode() {
        return priceCurrent.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof PriceCurrent) {
            PriceCurrent other = (PriceCurrent) obj;
            return priceCurrent.equals(other.priceCurrent);
        }
        return false;
    }


}