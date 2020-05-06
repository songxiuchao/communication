package com.sandu.erp;

import com.sandu.erp.config.Properties;
import com.sandu.erp.config.WebSocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * erp 启动类
 * @author xiaobing
 * @date 2020-02-29 18:00
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2020-02-29 18:00     xiaobing          v1.0.0           Created
 *
 */
@SpringBootApplication
@MapperScan("com.sandu.erp.dao")
@EnableConfigurationProperties(Properties.class)
public class ErpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ErpApplication.class, args);
        WebSocketServer.setApplicationContext(run);
    }

}
