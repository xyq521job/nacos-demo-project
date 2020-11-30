package com.example.xyq.ndp.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.xyq.ndp.entity.TDataDict;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 数据字典表 Mapper 接口
 * </p>
 *
 * @author xingyinqiang
 * @since 2020-11-26
 */
@Repository
public interface TDataDictMapper extends BaseMapper<TDataDict> {

    List<TDataDict> queryDataDictPagination();
}
