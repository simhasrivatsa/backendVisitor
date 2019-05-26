package com.vistorCount.controller;


import com.vistorCount.response.UniqueVisitorCountResponse;
import com.vistorCount.service.VisitorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/visitors/")

public class MainController {

    @Autowired
    private VisitorRecordService visitorRecordService;


    @CrossOrigin
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public UniqueVisitorCountResponse getVisitorCount(HttpServletRequest request) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return visitorRecordService.getUniqueVisitorCount(remoteAddr);
    }


}
