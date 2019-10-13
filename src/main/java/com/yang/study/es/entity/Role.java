package com.yang.study.es.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * package:com.yang.study.es.entity
 * author:yang
 * date: 2019/10/13  18:22
 * param: ${PARAM}
 * return:${RETURN}
 * Description:${TODO}
 */
@Document(indexName = "test-role",type = "role",replicas = 1,shards = 5)
public class Role {

    @Id
    private String id;

    @Field(type= FieldType.keyword)
    private String name;

    @Field(type=FieldType.Date)
    private Date createTime;

    @Field(searchAnalyzer="ik_smart",analyzer="ik_smart",type=FieldType.text)
    private String description;

    public Role() {}

    public Role(String name,String description,Date createTime) {
        this.name = name;
        this.description = description;
        this.createTime = createTime;
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


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
}
