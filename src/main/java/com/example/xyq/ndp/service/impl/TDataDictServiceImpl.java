package com.example.xyq.ndp.service.impl;

import com.example.xyq.ndp.dao.mapper.TDataDictMapper;
import com.example.xyq.ndp.entity.TDataDict;
import com.example.xyq.ndp.service.ITDataDictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典表 服务实现类
 * </p>
 *
 * @author xingyinqiang
 * @since 2020-11-26
 */
@Service("dataDictService")
public class TDataDictServiceImpl implements ITDataDictService {

    @Resource
    private TDataDictMapper dataDictMapper;

    @Override
    public PageInfo<TDataDict> queryDataDictPagination() {
        PageHelper.startPage(1,10);
        List<TDataDict> dataDicts = dataDictMapper.queryDataDictPagination();
        PageInfo<TDataDict> pageInfo = new PageInfo<TDataDict>(dataDicts);
        return pageInfo;
    }
}
