package com.javaniuniu.pojo;

public class Foo {
    private String name;
    private String type;
    private Double typeValue;
    private Integer count;

    public Foo() {}
    public Foo(String name, String type, Double typeValue, Integer count) {
        this.name = name;
        this.type = type;
        this.typeValue = typeValue;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(Double typeValue) {
        this.typeValue = typeValue;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", typeValue=" + typeValue +
                ", count=" + count +
                '}';
    }
}