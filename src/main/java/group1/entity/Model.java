/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.entity;

/**
 *
 * @author numpa
 */
public class Model {

    String year;
    Double profit;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Model() {
    }

    public Model(String year, Double profit) {
        this.year = year;
        this.profit = profit;
    }

}
