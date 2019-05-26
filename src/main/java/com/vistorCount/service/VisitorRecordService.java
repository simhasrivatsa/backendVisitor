package com.vistorCount.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.vistorCount.database.Manager.DataManager;
import com.vistorCount.entity.VisitorData;
import com.vistorCount.response.UniqueVisitorCountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class VisitorRecordService {
    @Autowired
    private DataManager dataManager;

    public UniqueVisitorCountResponse getUniqueVisitorCount(String ipAddress)
    {
           System.out.println(ipAddress);
           Integer totalVisitorCount = dataManager.getTotalVisitorCount();
           Integer currentVisitorRank = dataManager.getCurrentVisitorRank(ipAddress);
           UniqueVisitorCountResponse uniqueVisitorCountResponse = new UniqueVisitorCountResponse();
           uniqueVisitorCountResponse.setCount(totalVisitorCount);
           uniqueVisitorCountResponse.setVisiterNumber(currentVisitorRank);
           uniqueVisitorCountResponse.setTimeOfResult(new Timestamp(System.currentTimeMillis()));
           return uniqueVisitorCountResponse;

    }




    public void AddVisitorCount(String ipAddress){

        Boolean userAlreadyVisited = dataManager.hasUserVisited(ipAddress);
        if(!userAlreadyVisited){
            VisitorData visitorData = new VisitorData();
            visitorData.setIpAddress(ipAddress);
            dataManager.addVisitorInfo(visitorData);

        }

    }



}
