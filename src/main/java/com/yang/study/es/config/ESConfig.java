package com.yang.study.es.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * package:com.yang.study.es.config
 * author:yang
 * date: 2019/10/13  17:46
 * param: ${PARAM}
 * return:${RETURN}
 * Description:${TODO}
 */
@Configuration
public class ESConfig {
    private static final Logger LOG=LoggerFactory.getLogger(ESConfig.class);
    @Value("${esHost}")
    private String esHost;
    @Value("${esPort}")
    private int esPort;
    @Value("${esClusterName}")
    private String esClusterName;

    private TransportClient client;


    @PostConstruct
    public void init() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", esClusterName)
                .put("client.transport.sniff", true).build();
        client=new PreBuiltTransportClient(settings);
        String[] hosts = esHost.trim().split(",");
        for(String host:hosts){
            client.addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(host),esPort));
        }
    }

    @Bean
    public Client client(){
        return client;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(){
        return new ElasticsearchTemplate(client);
    }

    public void destory(){
        LOG.info("关闭es Client");
        if(client!=null){
            client.close();
        }
    }

}
