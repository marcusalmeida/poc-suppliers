package com.example.suppliers.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String salesOrder;
    private String sku;


    public Order() {
    }

    public Order(String salesOrder, String sku) {
        this.salesOrder = salesOrder;
        this.sku = sku;
    }

    public Order(long id, String salesOrder, String sku) {
        this.id = id;
        this.salesOrder = salesOrder;
        this.sku = sku;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSalesOrder() {
        return this.salesOrder;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Order id(long id) {
        setId(id);
        return this;
    }

    public Order salesOrder(String salesOrder) {
        setSalesOrder(salesOrder);
        return this;
    }

    public Order sku(String sku) {
        setSku(sku);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id && Objects.equals(salesOrder, order.salesOrder) && Objects.equals(sku, order.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salesOrder, sku);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", salesOrder='" + getSalesOrder() + "'" +
            ", sku='" + getSku() + "'" +
            "}";
    }

}


