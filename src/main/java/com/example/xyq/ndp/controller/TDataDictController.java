package com.example.xyq.ndp.controller;


import com.example.xyq.ndp.dao.mapper.DataDictRepository;
import com.example.xyq.ndp.dao.mapper.TDataDictMapper;
import com.example.xyq.ndp.entity.TDataDict;
import com.example.xyq.ndp.service.ITDataDictService;
import com.example.xyq.ndp.vo.BaseResponse;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private TDataDictMapper dataDictMapper;

    @Autowired
    private DataDictRepository dataDictRepository;

    @ApiOperation(value = "分页查询数据字典", notes = "分页查询数据字典",
            httpMethod = "POST", produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/getPageList")
    @ResponseBody
    public PageInfo<TDataDict> getPageList(){

        return dataDictService.queryDataDictPagination();
    }


    @PostMapping("save")
    @ResponseBody
    public BaseResponse save(@RequestBody TDataDict dataDict){
        int count = dataDictMapper.insert(dataDict);
        dataDict = dataDictRepository.save(dataDict);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(dataDict);
        return baseResponse;
    }


    /**
     * @param title   搜索标题
     * @param pageable page = 第几页参数, value = 每页显示条数
     */
    @GetMapping("elasticSearch")
    public BaseResponse<List<TDataDict>> search(String title, @PageableDefault(page = 1, value = 10)
            Pageable pageable){
        //按标题进行搜索
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("remark", title);

        //如果实体和数据的名称对应就会自动封装，pageable分页参数
        Iterable<TDataDict> listIt =  dataDictRepository.search(queryBuilder,pageable);

        //Iterable转list
        List<TDataDict> list= Lists.newArrayList(listIt);
        Map<String,Object> resultMap =new HashMap<>();
        resultMap.put("result",list);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(list);
        return baseResponse;
    }

}
