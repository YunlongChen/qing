package chenyunlong.zhangli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Stan
 */
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
public class SangliServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SangliServiceProviderApplication.class, args);
    }

}