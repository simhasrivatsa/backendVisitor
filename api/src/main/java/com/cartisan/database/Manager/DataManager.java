package com.cartisan.database.Manager;


import com.cartisan.database.Dao.VehicleDao;
import com.cartisan.entity.VehicleRepairData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataManager {

    @Autowired
    private VehicleDao vehicleDao;

    public void addVehicle(VehicleRepairData vehicleRepairData)
    {
        vehicleDao.insertVehicleRepairData(vehicleRepairData);
    }

}
