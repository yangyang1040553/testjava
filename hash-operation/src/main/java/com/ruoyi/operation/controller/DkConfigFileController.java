package com.ruoyi.operation.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.LogUtils;
import com.ruoyi.common.utils.OSSUplodFile;
import com.ruoyi.common.utils.TCloudUplodFile;
import com.ruoyi.operation.domain.DkOssList;
import com.ruoyi.operation.mapper.DkOssListMapper;
import com.ruoyi.operation.service.IDkOssListService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.operation.domain.DkConfigFile;
import com.ruoyi.operation.service.IDkConfigFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 对抗配置文件Controller
 *
 * @author xxk
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/hash-operation/dkFile")
public class DkConfigFileController extends BaseController {
    @Autowired
    private IDkConfigFileService dkConfigFileService;

    @Autowired
    private DkOssListMapper dkOssListMapper;

    /**
     * 查询对抗配置文件列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkFile:list')")
    @GetMapping("/list")
    public TableDataInfo list(DkConfigFile dkConfigFile) {
        startPage();
        List<DkConfigFile> list = dkConfigFileService.selectDkConfigFileList(dkConfigFile);
        return getDataTable(list);
    }

    /**
     * 导出对抗配置文件列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkFile:export')")
    @Log(title = "对抗配置文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DkConfigFile dkConfigFile) {
        startOrderBy();
        List<DkConfigFile> list = dkConfigFileService.selectDkConfigFileList(dkConfigFile);
        ExcelUtil<DkConfigFile> util = new ExcelUtil<DkConfigFile>(DkConfigFile.class);
        util.exportExcel(response, list, "对抗配置文件数据");
    }

    /**
     * 获取对抗配置文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkFile:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(dkConfigFileService.selectDkConfigFileById(id));
    }

    /**
     * 新增对抗配置文件
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkFile:add')")
    @Log(title = "对抗配置文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DkConfigFile dkConfigFile) {

        int i = dkConfigFileService.insertDkConfigFile(dkConfigFile);

        return getAjaxResult(dkConfigFile, i);
    }

    /**
     * 修改对抗配置文件
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkFile:edit')")
    @Log(title = "对抗配置文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DkConfigFile dkConfigFile) {
        int i = dkConfigFileService.updateDkConfigFile(dkConfigFile);

        return getAjaxResult(dkConfigFile, i);
    }

    private AjaxResult getAjaxResult(@RequestBody DkConfigFile dkConfigFile, int i) {
        logger.info("对抗文件上传成功 开始上传远程存储 save = {}", i > 0);
        if (i > 0) {
            String upOssList = dkConfigFile.getUpOssList();
            String[] split = upOssList.split(",");

            String str = "";
            for (String s : split) {
                str = str + "'" + s + "',";
            }
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }

            logger.info("获取文件列表 str = {}", str);

            List<DkOssList> dkOssLists = dkOssListMapper.selectDKOSSbyName(str);
            LogUtils.getBlock(dkOssLists);
            for (DkOssList dkOssList : dkOssLists) {
                logger.info("上传远程文件的配置 = {}", JSON.toJSONString(dkOssList));
                try {
                    File file = new File(RuoYiConfig.getUploadPath(), System.currentTimeMillis() + ".json");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(dkConfigFile.getJson().getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.flush();
                    fileOutputStream.close();

                    Integer ossType = dkOssList.getOssType().intValue();
                    if (ossType == 1) {
                        logger.info("阿里云上传...");
                        // 阿里上传
                        OSSUplodFile.uploadFile(file,
                                dkOssList.getAccessId(),
                                dkOssList.getAccessKey(),
                                dkOssList.getUploadAddr(),
                                dkOssList.getBucketName());
                    } else if (ossType == 2) {
                        logger.info("腾讯云上传...");
                        //腾讯上传
                        TCloudUplodFile.uploadFile(file,
                                dkOssList.getAccessId(),
                                dkOssList.getAccessKey(),
                                dkOssList.getUploadAddr(),
                                dkOssList.getBucketName());
                    }

                } catch (IOException e) {
                    logger.error("oss上传异常", e);
                    return AjaxResult.error("OSS上传异常 桶名称：" + dkOssList.getBucketName());
                }
            }

        }
        return success("修改文件成功，上传OSS文件成功");
    }

    /**
     * 删除对抗配置文件
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkFile:remove')")
    @Log(title = "对抗配置文件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(dkConfigFileService.deleteDkConfigFileByIds(ids));
    }
}
