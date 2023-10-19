package controller;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private Integer proId;
    private String proName;
    private Double proPrice;
    private Integer proQty;
    private LocalDate importedPro;
    public Product(Integer proId,String proName,Double proPrice,Integer proQty,LocalDate importedPro){
        this.proId = proId;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proQty = proQty;
        this.importedPro = importedPro;
    }
    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public LocalDate getImportedPro() {
        return importedPro;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public Integer getProQty() {
        return proQty;
    }

    public void setProQty(Integer proQty) {
        this.proQty = proQty;
    }

    public void setImportedPro(LocalDate importedPro) {
        this.importedPro = importedPro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(proId, product.proId) && Objects.equals(proName, product.proName) && Objects.equals(proPrice, product.proPrice) && Objects.equals(proQty, product.proQty) && Objects.equals(importedPro, product.importedPro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proId, proName, proPrice, proQty, importedPro);
    }

    @Override
    public String toString() {
        return "Product{" +
                "proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", proQty=" + proQty +
                ", importedPro=" + importedPro +
                '}';
    }

}
