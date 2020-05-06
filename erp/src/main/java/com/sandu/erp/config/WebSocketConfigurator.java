package com.sandu.erp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 15:17
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/25 15:17     xiaobing          v1.0.0           Created
 */
@ConditionalOnWebApplication
@Configuration
public class WebSocketConfigurator {


    @Bean
    public CustomSpringConfigurator customSpringConfigurator() {
        return new CustomSpringConfigurator(); // This is just to get context
    }
}
