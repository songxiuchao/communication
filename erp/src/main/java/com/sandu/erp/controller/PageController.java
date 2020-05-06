package com.sandu.erp.controller;

import com.sandu.erp.util.HttpClientHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 9:19
 * @Description Modification History: 跳转到页面
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/25 9:19     xiaobing          v1.0.0           Created
 */
@Controller
public class PageController {

    @RequestMapping("/official")
    public String official() {
        return "official";
    }

}
