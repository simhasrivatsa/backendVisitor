package com.vistorCount.database.Manager;


import com.vistorCount.database.Dao.VisitorDao;
import com.vistorCount.entity.VisitorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataManager {

    @Autowired
    private VisitorDao visitorDao;

    public void addVisitorInfo(VisitorData visitorData)
    {
        visitorDao.insertVehicleRepairData(visitorData);
    }

    public Integer getTotalVisitorCount(){
       return visitorDao.getTotalVisitorCount();
    }

    public Integer getCurrentVisitorRank(String ipAddress){
        return visitorDao.getCurrentVisitorRank(ipAddress);
    }


    public Boolean hasUserVisited(String ipAddress){
        return visitorDao.getCurrentVisitorCount(ipAddress)>0;
    }

}
