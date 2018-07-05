package com.cartisan.repository;

import com.cartisan.http.ImageStoreRequest;
import com.cartisan.util.Util;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryImageRepository {

    Cloudinary cloudinary = Singleton.getCloudinary();

    public String store(ImageStoreRequest imageStoreRequest) throws IOException
    {
        Map config = ObjectUtils.asMap(
                "cloud_name", "didoktzam",
                "api_key", "723453832247966",
                "api_secret", "99AqS5p8PcYyZ_sRnR0lIcyCBeg");

        Map uploadResult= cloudinary.uploader().upload(Util.convertMultipartToFile(imageStoreRequest.getImageFile()), config);

        return Util.convertObjectToString(uploadResult.get("secure_url"));

    }


}
