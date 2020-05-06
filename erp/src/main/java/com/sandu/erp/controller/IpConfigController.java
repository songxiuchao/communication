package com.sandu.erp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sandu.erp.constant.PageConstant;
import com.sandu.erp.constant.Result;
import com.sandu.erp.service.IpConfigService;
import com.sandu.erp.vo.IpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/27 10:59
 * @Description Modification History: Ip测试类
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/27 10:59     xiaobing          v1.0.0           Created
 */
@RestController
@RequestMapping("/ipconfig")
public class IpConfigController {

    @Autowired
    private IpConfigService ipConfigService;

    @RequestMapping("/saveIp")
    public Result saveIp(@RequestBody IpConfig ipConfig){
        ipConfigService.saveIp(ipConfig);
        return Result.success("新增成功");
    }

    @RequestMapping("/deleteIp")
    public Result deleteIp(@RequestParam String id){
        ipConfigService.deleteIp(id);
        return Result.success("删除成功");
    }

    @RequestMapping("/getByIp")
    public Result getByIp(@RequestParam(required = false) String ip,
                          @RequestParam(required = false) Integer pageNum,
                          @RequestParam(required = false) Integer pageSize){

        if (pageNum == null) {
            pageNum = PageConstant.PAGENUM;
        }
        if (pageSize == null) {
            // 每页查询数据条数的值统一放在那里
            pageSize = PageConstant.PAGESIZE;
        }

        PageHelper.startPage(pageNum, pageSize);
        PageInfo<IpConfig> pageInfo = new PageInfo<>(ipConfigService.getByIp(ip));

        return Result.success("查询成功", pageInfo);
    }

    @RequestMapping("/updateById")
    public Result updateById(@RequestBody IpConfig ipConfig){
        ipConfigService.updateById(ipConfig);
       return Result.success("更新成功");

    }

}
