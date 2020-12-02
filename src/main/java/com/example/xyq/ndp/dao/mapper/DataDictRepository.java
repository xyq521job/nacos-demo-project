package com.example.xyq.ndp.dao.mapper;

import com.example.xyq.ndp.entity.TDataDict;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * description: DataDictRepository <br>
 * date: 2020/12/1 14:20 <br>
 * author: xingyinqiang <br>
 * version: 1.0 <br>
 */
@Component
public interface DataDictRepository extends ElasticsearchRepository<TDataDict, Long> {
}
