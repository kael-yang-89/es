package com.yang.study.es.mapper;

import com.yang.study.es.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * package:com.yang.study.es.mapper
 * author:yang
 * date: 2019/10/13  18:26
 * param: ${PARAM}
 * return:${RETURN}
 * Description:只要继承ElasticsearchRepository就具有常用的增删减查功能了，可以新增一些其他需要用到的查询
 */

public interface UserRepository extends ElasticsearchRepository<User,String> {
   /* //按userName like查询
    List<User> findByUserNameLike(String userName);

    //按role的name属性查询
    List<User> findByRolesName(String name);

    //按role的name属性查询 两种方式都可以
    List<User> findByRoles_Name(String name);*/
}
