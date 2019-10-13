package com.yang.study.es.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

/**
 * package:com.yang.study.es.entity
 * author:yang
 * date: 2019/10/13  18:14
 * param: ${PARAM}
 * return:${RETURN}
 * Description:声明 USER实体，注意有一个1对多关系的roles
 */
@Document(indexName = "test-user",type = "user",replicas = 1,shards = 5)
public class User {

    @Id
    private String id;
    @Field(type = FieldType.keyword)
    private String name;
    @Field(type = FieldType.Integer)
    private Integer age;
    @Field(type = FieldType.Date)
    private Date birthday;
    /**
     * 声明分词器为ik_smart (注意 es要安装ik分词器插件)
     */
    @Field(searchAnalyzer = "ik_smart",analyzer = "ik_smart",type = FieldType.text)
    private String description;
    /**
     * 1对多在spring-data-elasticsearch 统一为nested类型
     **/
    @Field(type = FieldType.Nested,includeInParent = true)
    private List<Role> roles;

    public User(){}

    public User(String id, String name, Integer age, Date birthday, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
