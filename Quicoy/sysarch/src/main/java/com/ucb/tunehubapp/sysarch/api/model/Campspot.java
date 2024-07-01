package com.ucb.tunehubapp.sysarch.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "campspot")
public class Campspot {



    @Id


    private String aCampName;

    private String bLocation;

    private String cAmenities;

    private String dActivities;

    private String eAccomodation;

    private String fAccessibilities;

    private String gNetwork;

    private String hTransportation;

    public Campspot(String aCampName, String bLocation, String cAmenities, String dActivities, String eAccomodation, String fAccessibilities, String gNetwork, String hTransportation) {
        this.aCampName = aCampName;
        this.bLocation = bLocation;
        this.cAmenities = cAmenities;
        this.dActivities = dActivities;
        this.eAccomodation = eAccomodation;
        this.fAccessibilities = fAccessibilities;
        this.gNetwork = gNetwork;
        this.hTransportation = hTransportation;
    }

    public Campspot() {
    }

    public String getaCampName() {
        return aCampName;
    }

    public void setaCampName(String aCampName) {
        this.aCampName = aCampName;
    }

    public String getbLocation() {
        return bLocation;
    }

    public void setbLocation(String bLocation) {
        this.bLocation = bLocation;
    }

    public String getcAmenities() {
        return cAmenities;
    }

    public void setcAmenities(String cAmenities) {
        this.cAmenities = cAmenities;
    }

    public String getdActivities() {
        return dActivities;
    }

    public void setdActivities(String dActivities) {
        this.dActivities = dActivities;
    }

    public String geteAccomodation() {
        return eAccomodation;
    }

    public void seteAccomodation(String eAccomodation) {
        this.eAccomodation = eAccomodation;
    }

    public String getfAccessibilities() {
        return fAccessibilities;
    }

    public void setfAccessibilities(String fAccessibilities) {
        this.fAccessibilities = fAccessibilities;
    }

    public String getgNetwork() {
        return gNetwork;
    }

    public void setgNetwork(String gNetwork) {
        this.gNetwork = gNetwork;
    }

    public String gethTransportation() {
        return hTransportation;
    }

    public void sethTransportation(String hTransportation) {
        this.hTransportation = hTransportation;
    }

    @Override
    public String toString() {
        return "Campspot{" +
                "aCampName='" + aCampName + '\'' +
                ", bLocation='" + bLocation + '\'' +
                ", cAmenities='" + cAmenities + '\'' +
                ", dActivities='" + dActivities + '\'' +
                ", eAccomodation='" + eAccomodation + '\'' +
                ", fAccessibilities='" + fAccessibilities + '\'' +
                ", gNetwork='" + gNetwork + '\'' +
                ", hTransportation='" + hTransportation + '\'' +
                '}';
    }
}

