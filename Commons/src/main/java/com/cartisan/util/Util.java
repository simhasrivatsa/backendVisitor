package com.cartisan.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


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


    public static boolean isCollectionNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static String getFileExtension(String name) {
        if (isNullOrEmpty(name))
            return null;
        String[] fileNameSplit = name.split("\\.");

        return fileNameSplit[fileNameSplit.length - 1];
    }

    public static String generateEnquiryId(String name)
    {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String formattedNow = simpleDateFormat.format(now);
        String enquiryId = "EID" + formattedNow + (new StringBuilder(name.replaceAll("\\s+","").toUpperCase())).reverse();
        return enquiryId;
    }

    public static String generateImageId(String fileName)
    {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String formattedNow = simpleDateFormat.format(now);
        String imageId = "IID" + formattedNow + (new StringBuilder(fileName.replaceAll("\\s+","").toUpperCase())).reverse();
        return imageId;

    }

    public static <T> T convertStringToObject(String objectStr, TypeReference<T> t) {
        if (isNullOrEmpty(objectStr))
            return null;
        try {
            return  (T) objectMapper.readValue(objectStr.getBytes(), t);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

    }

    public static File convertMultipartToFile(MultipartFile file) throws IOException
    {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }


}
