package com.javamaster.entity;


public class Electronic {

    private Long id;

    private String nameModel;
    private String nameCompany;
    private Double cost;

    public Electronic(String nameModel, String nameCompany, Double cost) {
        this.nameModel = nameModel;
        this.nameCompany = nameCompany;
        this.cost = cost;
    }

    public Electronic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "id=" + id +
                ", nameModel='" + nameModel + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", cost=" + cost +
                '}';
    }
}
