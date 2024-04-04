package org.dstu.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Chair {
    private int id;
    private String material;
    private String country;
    private String manufacturer;
    private String color;
    private String upholstery;
    private int transcriptNum;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "material")
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "upholstery")
    public String getUpholstery() {
        return upholstery;
    }

    public void setUpholstery(String upholstery) {
        this.upholstery = upholstery;
    }

    @Basic
    @Column(name = "transcript_num")
    public int getTranscriptNum() {
        return transcriptNum;
    }

    public void setTranscriptNum(int transcriptNum) {
        this.transcriptNum = transcriptNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return id == chair.id && transcriptNum == chair.transcriptNum && Objects.equals(material, chair.material) && Objects.equals(country, chair.country) && Objects.equals(manufacturer, chair.manufacturer) && Objects.equals(color, chair.color) && Objects.equals(upholstery, chair.upholstery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, material, country, manufacturer, color, upholstery, transcriptNum);
    }
}
