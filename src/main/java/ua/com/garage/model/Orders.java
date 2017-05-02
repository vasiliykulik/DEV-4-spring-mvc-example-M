package ua.com.garage.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
@Entity
@Table(name = "orders")
public class Orders {
    // 61. более сложный

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    // 62. Появляется связь с другой Entity, перое слово относится к нашей сущности
    // Много ордеров к одному Employee. В таблицу заносим employee_id
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee waiter;


    // 63. КОНФИгурируем таблицу Смапить Entity на таблицы
// 131. Ошибка была в конфигурации
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dish_to_order",
            joinColumns = @JoinColumn(name = "order_id"), // наш id
            inverseJoinColumns = @JoinColumn(name = "dish_id") // id того объекта с которым мы связыываемся
    )
    private List<Dish> dishes;


    @Column(name  ="table_number")
    private int tableNumber;

    @Column(name = "order_date")
    private Date orderDate;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", waiter=" + waiter +
                ", dishes=" + dishes +
                ", tableNumber=" + tableNumber +
                ", orderDate=" + orderDate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
