package com.sandu.erp.uploadFile;

import com.sandu.common.response.ReturnValueLoader;
import com.sandu.common.util.UploadFileUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件
 *
 * @author xiaobing
 * @version v1.0.0
 * @date 2020/02/29_21:37
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/02/29_21:37     xiaobing           v1.0.0              Created
 */

@Api(tags = "上传文件")
@RestController
@RequestMapping("upload")
public class UploadFileController {

    @Value("${sandu.upload.filepath}")
    private String filePath;

    /**
     * 上传文件
     *
     * @param file 上传的文件信息
     */
    @ApiOperation(value = "上传文件", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(),
    })
    @ApiResponses({
            @ApiResponse(code = 0, response = String.class, message = "上传成功"),
    })
    @PostMapping
    public ReturnValueLoader list(@ApiParam(value = "文件信息", required = true) @RequestParam("file") MultipartFile file) {

        String fileName = UploadFileUtil.uploadFile(file, filePath);

        return new ReturnValueLoader(fileName);
    }

}
