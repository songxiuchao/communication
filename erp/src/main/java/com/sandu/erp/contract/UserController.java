package com.sandu.erp.contract;

import com.sandu.common.response.ReturnValueLoader;
import com.sandu.erp.contract.pojo.po.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户 控制层
 *
 * @author xiaobing
 * @version v1.0.0
 * @date 2020-03-02
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020-03-02             xiaobing          v1.0.0           Created
*/
@Api(tags = "用户")
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 功能描述: 新增用户
     *
     * @param: saveDto 新增需要的参数
     * @auther: xiaobing
     * @date: 2020-03-02
     * @return:
    */
    @PutMapping
    @ApiOperation(value = "新增用户")
    @ApiResponses({@ApiResponse(code = 0, response = int.class, message = "获取数据成功")})
    public ReturnValueLoader put(@Valid @RequestBody User saveDto) {

    Long id  = userService.put(saveDto);
    return new ReturnValueLoader();
    }

    /**
     * 功能描述: 查看用户
     *
     * @param:
     * @auther: xiaobing
     * @date: 2020-03-02
     * @return:
    */
    @ApiOperation(value = "查看用户")
    @ApiResponses({@ApiResponse(code = 0, response = User.class, message = "获取数据成功")})
    @GetMapping
    public ReturnValueLoader detail(@RequestParam Long id) {
    User user = userService.detail(id);
    return new ReturnValueLoader(user);
    }



    /**
    * 功能描述: 提交新增的用户
    *
    * @param:
    * @auther: xiaobing
    * @date: 2020-03-02
    * @return: returnValueLoader
    */
    @ApiOperation(value = "新增用户提交")
    @ApiResponses({
    @ApiResponse(code = 0, response = ReturnValueLoader.class, message = "提交成功"),
    })
    @PostMapping("/submit")
    public ReturnValueLoader submit(@Valid @RequestBody User saveDto) {

    int submitCount = this.userService.submit(saveDto);
    return ReturnValueLoader.validatorCount(submitCount);
    }


    /**
    * 功能描述: 用户移除
    *
    * @param:
    * @auther: xiaobing
    * @date: 2020-03-02
    * @return:
    */
    @ApiOperation(value = "用户删除", notes = "删除使用")
    @ApiResponses({
    @ApiResponse(code = 0, response = ReturnValueLoader.class, message = "success"),
    })
    @DeleteMapping
    public ReturnValueLoader delete(@RequestParam @ApiParam("用户ID") Long id) {

    int deleteCount = this.userService.delete(id);
    return ReturnValueLoader.validatorCount(deleteCount);
    }


}
