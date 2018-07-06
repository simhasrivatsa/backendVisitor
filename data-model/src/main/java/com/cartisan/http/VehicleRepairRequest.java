package com.cartisan.http;

import com.cartisan.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

public class VehicleRepairRequest extends BaseEntity{
    @NotNull
    private String name;
    @NotNull
    private String phoneNo;
    @NotNull
    private String emailId;
    private String description;
    private List<String> vehiclePictures;

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    private String vehicleModel;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getVehiclePictures() {
        return vehiclePictures;
    }

    public void setVehiclePictures(List<String> vehiclePictures) {
        this.vehiclePictures = vehiclePictures;
    }


}
