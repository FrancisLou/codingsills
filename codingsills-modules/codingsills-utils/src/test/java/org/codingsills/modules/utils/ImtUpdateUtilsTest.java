package org.codingsills.modules.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 类功能描述
 * ImtUpdateUtilsTest.java
 *
 * @date 2016年4月6日
 * 
 * @author Saber
 */
public class ImtUpdateUtilsTest {
    
    @Test
    public void testImtUpdate(){

            List<String> list = new ArrayList<String>();
            list.add("GatewayRouteCfgMngDao.java");
            list.add("GatewayRouteManageDao.java");
            list.add("GatewayRouteCfgDto.java");
            list.add("GatewayRouteCfgQuery.java");
            list.add("GatewayRouteMngDto.java");
            list.add("GatewayRouteMngQuery.java");
            list.add("GatewayRouteCfgMngService.java");
            list.add("GatewayRouteManageService.java");
            list.add("GatewayRouteCfgMngController.java");
            list.add("GatewayRouteManageController.java");
            list.add("addGatewayRouteCfg.jsp");
            list.add("gatewayRouteCfgMng.jsp");
            list.add("gatewayRouteMng.jsp");
            list.add("modGatewayRoute.jsp");
            list.add("modGatewayRouteCfg.jsp");
            list.add("gateway-route-config.xls");
            list.add("dao.xml");
            list.add("dispatcher-servlet.xml");
            list.add("service.xml");
            //生成增量包
            ImtUpdateKit.createFinalDirectory(list, "E:\\fuiou\\富友项目\\富友网络业务操作管理平台(WBP)\\WBP待上线\\网关路由初始new");

    }
}
