package com.cartisan.service;

import com.cartisan.database.Manager.DataManager;
import com.cartisan.entity.VehicleRepairData;
import com.cartisan.http.VehicleRepairRequest;
import com.cartisan.response.ApiSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cartisan.util.Util;


@Service
public class VehicleService {
    @Autowired
    private DataManager dataManager;

    public ApiSuccessResponse vehicleRepairRequest(VehicleRepairRequest vehicleRepairRequest)
    {

        VehicleRepairData vehicleRepairData = new VehicleRepairData();
        vehicleRepairData.setEnquiryId(Util.generateEnquiryId(vehicleRepairRequest.getName()));
        vehicleRepairData.setDescription(vehicleRepairRequest.getDescription());
        vehicleRepairData.setName(vehicleRepairRequest.getName());
        vehicleRepairData.setEmailId(vehicleRepairRequest.getEmailId());
        vehicleRepairData.setVehiclePictures(vehicleRepairRequest.getVehiclePictures());
        vehicleRepairData.setPhoneNo(vehicleRepairRequest.getPhoneNo());
        vehicleRepairData.setVehicleModel(vehicleRepairRequest.getVehicleModel());
        dataManager.addVehicle(vehicleRepairData);
        return new ApiSuccessResponse("ok");

    }
}
