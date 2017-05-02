package ua.com.garage.model;

import javax.persistence.*;

/**
 * Created by Raketa on 25.12.2016.
 */
@Entity
public class Dish {
    // 60. простые row property
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private DishCategory category;
    @Column(name = "price")
    private float price;
    @Column(name = "weight")
    private float weight;

    // 93. Equals и hashCode без id

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;

        Dish dish = (Dish) o;

        if (Float.compare(dish.price, price) != 0) return false;
        if (Float.compare(dish.weight, weight) != 0) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        return category == dish.category;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
