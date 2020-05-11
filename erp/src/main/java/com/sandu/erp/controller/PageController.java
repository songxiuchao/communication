package com.sandu.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 9:19
 * @Description Modification History: 跳转到页面 这个是前台页面类
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
