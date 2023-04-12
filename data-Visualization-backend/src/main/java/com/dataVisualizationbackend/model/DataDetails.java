package com.dataVisualizationbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
//@Entity
//@Table(name = "Data_Info")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class DataDetails {
//    @Id
//    private long Id;
//    private long end_year;
//    private double cityLongitude;
//    private double cityLatitude;
//    private int intensity;
//    private String sector;
//    private String topic;
//    private String insight;
//    private String swot;
//    private String url;
//    private String region;
//    private long start_year;
//    private int impact;
//    private Date added;
//    private Date published;
//    private String city;
//    private String country;
//    private int relevance;
//    private String pestle;
//    private String source;
//    private String title;
//    private int likelihood;
//
//}

@Entity
@Table(name = "Data_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDetails {
    @Id
    private long id;
    private Long end_year;
    private Double cityLongitude;
    private Double cityLatitude;
    private Integer intensity;
    private String sector;
    private String topic;
    private String insight;
    private String swot;
    private String url;
    private String region;
    private Long start_year;
    private Integer impact;
    private Date added;
    private Date published;
    private String city;
    private String country;
    private Integer relevance;
    private String pestle;
    private String source;
    private String title;
    private Integer likelihood;


    public void setCityLatitude(Double cityLatitude) {
        if (cityLatitude == null) {
            this.cityLatitude = 0.0; // or any other default value you prefer
        } else {
            this.cityLatitude = cityLatitude;
        }
    }

    public void setCityLongitude(Double cityLongitude) {
        if(cityLongitude ==null)this.cityLongitude=0.0;
        else
        this.cityLongitude = cityLongitude;
    }
}
