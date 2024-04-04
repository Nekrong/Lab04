package org.dstu.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Office {
    private int id;
    private String name;
    private boolean whole;
    private Set<Desk> staff = new LinkedHashSet<>();

    @Basic
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "whole")
    public boolean isWhole() {
        return whole;
    }

    public void setWhole(boolean whole) {
        this.whole = whole;
    }

    @OneToMany(mappedBy = "office")
    public Set<Desk> getStaff() {
        return staff;
    }

    public void setStaff(Set<Desk> staff) {
        this.staff = staff;
    }
}
