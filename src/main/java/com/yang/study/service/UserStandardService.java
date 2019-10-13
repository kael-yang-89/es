package com.yang.study.service;

import com.yang.study.es.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * package:com.yang.study.service
 * author:yang
 * date: 2019/10/13  18:32
 * param: ${PARAM}
 * return:${RETURN}
 * Description:${TODO}
 */
public class UserStandardService  {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
}
