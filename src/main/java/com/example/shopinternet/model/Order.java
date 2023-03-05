package com.example.shopinternet.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @NotBlank
    @Column(name = "detail", nullable = false)
    private String detail;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank
    @Column(name = "registered_time", nullable = false)
    private Date registeredTime;

    @NotBlank
    @Column(name = "amount_detail", nullable = false)
    private Integer amountDetail;

    @NotBlank
    @Column(name = "total_sum", nullable = false)
    private Double totalSum;

    @NotBlank
    @Column(name = "address", nullable = false)
    private String address;

    public Order(){}

    public Order(String detail, User user, Date registeredTime, Integer amountDetail, Double totalSum, String address) {
        this.detail = detail;
        this.user = user;
        this.registeredTime = registeredTime;
        this.amountDetail = amountDetail;
        this.totalSum = totalSum;
        this.address = address;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public Integer getAmountDetail() {
        return amountDetail;
    }

    public void setAmountDetail(Integer amountDetail) {
        this.amountDetail = amountDetail;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
