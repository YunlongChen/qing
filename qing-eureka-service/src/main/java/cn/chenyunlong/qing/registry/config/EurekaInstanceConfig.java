/*
 * Copyright (c) 2019-2023  YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 */

package cn.chenyunlong.qing.registry.config;

import com.netflix.appinfo.*;
import com.netflix.eureka.EurekaServerContext;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.beans.factory.InitializingBean;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class EurekaInstanceConfig implements InitializingBean {

    private final EurekaServerContext eurekaServerContext;
    private final PeerAwareInstanceRegistry instanceRegistry;

    public EurekaInstanceConfig(EurekaServerContext eurekaServerContext, PeerAwareInstanceRegistry instanceRegistry) {
        this.eurekaServerContext = eurekaServerContext;
        this.instanceRegistry = instanceRegistry;
    }

    @Override
    public void afterPropertiesSet() {

        ApplicationInfoManager applicationInfoManager = eurekaServerContext.getApplicationInfoManager();
        InstanceInfo managerInfo = applicationInfoManager.getInfo();
        System.out.println(managerInfo.getInstanceId());

        MyDataCenterInfo dataCenterInfo = new MyDataCenterInfo(DataCenterInfo.Name.MyOwn);

        URI uri = URI.create("http://localhost:9001");
        Map<String, String> metaData = new HashMap<>();
        metaData.put("management.context-path", uri.getPath());
        metaData.put("schoolId", "metadata");
        LeaseInfo.Builder builder = LeaseInfo.Builder.newBuilder();
        LeaseInfo leaseInfo = builder.build();

        InstanceInfo instanceInfo = InstanceInfo.Builder
                .newBuilder()
                .setInstanceId("zhangli-8080-service:8080")
                .setAppName("zhagnli-8080-service")
                .setAppNameForDeser("zhagnli-8080-service")
                .setIPAddr(uri.getHost())
                .setMetadata(metaData)
                .setPort(uri.getPort())
                .setHostName(uri.getHost())
                .setHomePageUrl("/", uri.toString())
                .setHealthCheckUrlsForDeser("/", uri.toString())
                .setHealthCheckUrls("/", uri.toString(), "/")
                .setDataCenterInfo(dataCenterInfo)
                .setStatusPageUrl(uri.toString(), uri.toString())
                .setLeaseInfo(leaseInfo)
                .build();
        instanceInfo.setStatus(InstanceInfo.InstanceStatus.UP);
        instanceRegistry.register(instanceInfo, false);
    }
}
