package com.cartisan.service;

import com.cartisan.entity.UserAlbumEntity;
import com.cartisan.exception.ApiServiceException;
import com.cartisan.exception.ServiceExceptionCodes;
import com.cartisan.http.ImageStoreRequest;
import com.cartisan.repository.CloudinaryImageRepository;
import com.cartisan.response.UserAlbumEntityResponse;
import com.cartisan.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;




@Service
public class ImageManagementService {

    @Autowired
    private CloudinaryImageRepository cloudinaryImageRepository;

    public UserAlbumEntityResponse uploadImage(MultipartFile imageFile)
    {

        UserAlbumEntity albumEntity = null;
        String imageServingLocation = null;
        String fileName =null;
        if (imageFile != null) {
            try {
                long size = imageFile.getSize();
                fileName = imageFile.getOriginalFilename();
                String imageType = Util.getFileExtension(fileName);
                ImageStoreRequest storeRequest = new ImageStoreRequest(fileName, imageFile, size);
                imageServingLocation = cloudinaryImageRepository.store(storeRequest);
                albumEntity = new UserAlbumEntity(Util.generateImageId(fileName), fileName, imageType, size,
                        imageServingLocation);
                return new UserAlbumEntityResponse(albumEntity);
            }catch (Exception ex) {
                throw new ApiServiceException(ServiceExceptionCodes.ERROR_SYSTEM_ERROR);
            }

        }
        else
            throw new ApiServiceException(ServiceExceptionCodes.INVALID_REQUEST);
    }
    }

