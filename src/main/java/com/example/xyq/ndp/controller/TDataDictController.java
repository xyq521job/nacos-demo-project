package com.example.xyq.ndp.controller;


import com.example.xyq.ndp.entity.TDataDict;
import com.example.xyq.ndp.service.ITDataDictService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据字典表 前端控制器
 * </p>
 *
 * @author xingyinqiang
 * @since 2020-11-26
 */
@Slf4j
@RestController
@RequestMapping("/dataDict")
public class TDataDictController{

    @Autowired
    @Qualifier(value = "dataDictService")
    private ITDataDictService dataDictService;

    @ApiOperation(value = "分页查询数据字典", notes = "分页查询数据字典",
            httpMethod = "POST", produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/getPageList")
    @ResponseBody
    public PageInfo<TDataDict> getPageList(){

        return dataDictService.queryDataDictPagination();
    }
}
