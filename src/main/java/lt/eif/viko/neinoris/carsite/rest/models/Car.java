package lt.eif.viko.neinoris.carsite.rest.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private int year;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private String trim;

    /*@Column
    private String vehicle_type;
    @Column
    private String weight;
    @Column
    private String body_class;
    @Column
    private String plant_country;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }
/*
    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBody_class() {
        return body_class;
    }

    public void setBody_class(String body_class) {
        this.body_class = body_class;
    }

    public String getPlant_country() {
        return plant_country;
    }

    public void setPlant_country(String plant_country) {
        this.plant_country = plant_country;
    }
    */

}
