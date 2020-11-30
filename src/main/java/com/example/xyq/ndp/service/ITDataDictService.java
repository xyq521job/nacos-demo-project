package com.example.xyq.ndp.service;

import com.example.xyq.ndp.entity.TDataDict;
import com.github.pagehelper.PageInfo;


/**
 * <p>
 * 数据字典表 服务类
 * </p>
 *
 * @author xingyinqiang
 * @since 2020-11-26
 */
public interface ITDataDictService{

    /**
     * 分页查询数据
     * @return
     */
    PageInfo<TDataDict> queryDataDictPagination();
}
