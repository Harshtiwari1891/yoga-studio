package com.app.studio.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This is the entity class for Yoga Class
 *
 * @author jCalles
 */
@Entity
@Table(name = "YOGA_CLASS")
public class YogaClass {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String location;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "yogaClass")
    private Set<Section> setOfSections;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<YogaClass> setOfPrerequisites;

    public YogaClass() {
        this.setOfSections = new HashSet<Section>();
        this.setOfPrerequisites = new HashSet<YogaClass>();
    }

    public void addPrerequisite(YogaClass yogaClass) {
        this.setOfPrerequisites.add(yogaClass);
    }

    public Set<YogaClass> getSetOfPrerequisites() {
        return setOfPrerequisites;
    }

    public void addSection(Section section) {
        this.setOfSections.add(section);
    }

    public Set<Section> getSetOfSections() {
        return setOfSections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "YogaClass{" + "id=" + id + ", name=" + name + ", price=" + price + ", location=" + location + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 97 * hash + (this.location != null ? this.location.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final YogaClass other = (YogaClass) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if ((this.location == null) ? (other.location != null) : !this.location.equals(other.location)) {
            return false;
        }
        return true;
    }

}
