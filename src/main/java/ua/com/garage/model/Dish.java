package ua.com.garage.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Raketa on 25.12.2016.
 */
@Entity
public class Dish {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private Long id;
  @Column(name = "name")

  private String name;
  @Column(name = "category")

  @Enumerated(EnumType.STRING)
  private DishCategory category;

  @Column(name = "price")
  private Float price;

  @Column(name = "weight")
  private Float weight;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Dish)) return false;

    Dish dish = (Dish) o;

    if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
    if (category != dish.category) return false;
    if (price != null ? !price.equals(dish.price) : dish.price != null) return false;
    return weight != null ? weight.equals(dish.weight) : dish.weight == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (category != null ? category.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (weight != null ? weight.hashCode() : 0);
    return result;
  }
}
