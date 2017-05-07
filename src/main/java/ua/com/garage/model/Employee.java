package ua.com.garage.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Raketa on 22.12.2016.
 */
// 1. создадим модельный класс
// 5. Объясним Hibernate Анотируем - что это сущность (любому JPA framework)
@Entity
// 6. Объясним Hibernate на какую табличку мапится класс (можем не указать Hibernate сам попробует найти)
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee {
    // 7. Укажем что будет Id (можем не указать Hibernate сам попробует найти - после рефакторинг БД - все может сломаться)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    // 8. Смаппим поле (Рефакторинг кода происходит чаще чем БД)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    // 9. Вот здесь поля не совпадают и маппинг нам нужен обязательно
    @Column(name = "phone_number")
    private String phoneNumber;
    // 2. создадим enum
    // 10. Position - это enum  - и нам нужно объяснить Hibernate (используем Enumerated,
    // и укажем EnumType. есть две опции ORDINAL - порядковый номер Enum (нумерация с 0), второй вариант STRING
    // имя instance enum. Использовать String - что бы проблем не было с рефакторингом, например всунете ENUM всередину,
    // чисто для читаемости кода. Цифра - непрезентабельны. И скорее всего bottle neck будет вдругом вместе)
    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    // 41. добавим - X - Enumerated - уже есть
    private Position position;
    @Column(name = "salary")
    private Float salary;
    // 3. создадим sql таблицу
    // 4. Как же нам теперь смапить поля на табличку - есть несколько способов -
    // посмотрим как сделать Аннотациями( можна делять в xml)
    // 11. Вот в принципе и весь mapping, это mapping row type (по сути примитивов, простых объектов (embedded - String)
    // те которые грубоговоря находятся в отношении КОМПОЗИЦИИ с нашим объектов)
// 27. set get toString


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
            return false;
        if (position != employee.position) return false;
        return salary != null ? salary.equals(employee.salary) : employee.salary == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }
}
