package com.vistorCount.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Util {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
    }

    public static <T> String convertObjectToString(T obj) {

        String response = null;
        try {
            if (obj == null)
                return null;

            response = objectMapper.writeValueAsString(obj);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return response;
    }



    public static String generateRecordId(String ipAddress)
    {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String formattedNow = simpleDateFormat.format(now);
        String recordId = "RID" + formattedNow + ipAddress;
        return recordId;
    }



    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }


}
