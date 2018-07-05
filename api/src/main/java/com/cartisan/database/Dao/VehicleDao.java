package com.cartisan.database.Dao;

import com.cartisan.entity.VehicleRepairData;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;

@UseStringTemplate3StatementLocator()
public interface VehicleDao extends Transactional<VehicleDao>{

    @SqlUpdate("Insert into repairs (`name`,`phone_no`,`email_id`,`description`,`enquiry_id`,`vehicle_pictures`) Values (:name,:phoneNo,:emailId,:description,:enquiryId,:vehiclePictures)")
    void insertVehicleRepairData(@BindBean VehicleRepairData vehicleRepairData);
}
