package com.javaniuniu.pojo;


public class Employee {
    private String city;
    private Integer sales;
    private String name;


    public Employee() {
    }

    public Employee(String city, Integer sales, String name) {
        this.city = city;
        this.sales = sales;
        this.name = name;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "city='" + city + '\'' +
                ", sales=" + sales +
                ", name='" + name + '\'' +
                '}';
    }

}
