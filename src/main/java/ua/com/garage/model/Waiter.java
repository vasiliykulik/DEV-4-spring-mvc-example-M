package ua.com.garage.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Vasiliy Kylik on 06.05.2017.
 */
@Entity
/*table не нужно - выберем тип наследования single table*/

public class Waiter extends Employee {

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "employee_id")
  @Fetch(FetchMode.SELECT)
  private List<Order> orders;

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }



    @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Waiter {\n");
    sb.append("   id = ").append(getId()).append("\n");
    sb.append("   name = ").append(getName()).append("\n");
    sb.append("   surname = ").append(getSurname()).append("\n");
    sb.append("   orders = {\n");
    orders.forEach(order -> sb.append("      ").append(order).append("\n"));
    sb.append("   }\n");
    sb.append("}\n");
    return sb.toString();
  }
}
