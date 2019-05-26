package com.vistorCount.database.Dao;

import com.vistorCount.entity.VisitorData;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;
import org.skife.jdbi.v2.sqlobject.stringtemplate.UseStringTemplate3StatementLocator;


@UseStringTemplate3StatementLocator()
public interface VisitorDao extends Transactional<VisitorDao>{

    @SqlUpdate("Insert into visitors (`ip_address`,`visit_time`) Values (:ipAddress,:visitTime)")
    void insertVehicleRepairData(@BindBean VisitorData visitorData);

    @SqlQuery("SELECT COUNT(*) FROM visitors;")
    Integer getTotalVisitorCount();

    @SqlQuery("SELECT id FROM visitors WHERE `ip_address`=:ipAddress;")
    Integer getCurrentVisitorRank(@Bind("ipAddress") String ipAddress);

    @SqlQuery("SELECT COUNT(*) FROM visitors WHERE `ip_address`=:ipAddress;")
    Integer getCurrentVisitorCount(@Bind("ipAddress") String ipAddress);



}
