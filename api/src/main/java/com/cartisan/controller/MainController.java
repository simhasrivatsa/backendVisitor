package com.cartisan.controller;


import com.cartisan.http.VehicleRepairRequest;
import com.cartisan.response.ApiSuccessResponse;
import com.cartisan.response.UserAlbumEntityResponse;
import com.cartisan.service.ImageManagementService;
import com.cartisan.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/cartisan/main/")

public class MainController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    private ImageManagementService imageManagementService;

    @CrossOrigin
    @RequestMapping(value = "vehicle/repair", method = RequestMethod.POST)
    public ApiSuccessResponse vehicleRepairRequestHandler(@RequestBody VehicleRepairRequest vehicleRepairRequest) {

        return vehicleService.vehicleRepairRequest(vehicleRepairRequest);
    }

    @CrossOrigin
    @RequestMapping(value = "image", method = RequestMethod.POST)
    public UserAlbumEntityResponse uploadVehicleImage(@RequestParam("image") MultipartFile imageFile) throws IOException, URISyntaxException {
        return imageManagementService.uploadImage(imageFile);
    }
}
