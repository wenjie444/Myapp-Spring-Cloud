package com.elas.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.elas.test.JsonTest.MAPPINGS_TYPE;


public class ElasTest {
    private RestHighLevelClient restHighLevelClient;
    @Test
    void test(){
        System.out.println(restHighLevelClient);
    }
    @Test
    void test01() throws IOException {
        CreateIndexRequest wenjie = new CreateIndexRequest("wenjie");
        wenjie.source(MAPPINGS_TYPE, XContentType.JSON);
        restHighLevelClient.indices().create(wenjie, RequestOptions.DEFAULT);
    }
    @BeforeEach
    void setUp(){
        this.restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://112.74.125.228:9200")
        ));
    }
    @AfterEach
    void Stop() throws IOException {
        this.restHighLevelClient.close();
    }
}
