package com.imooc.esapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.esapi.pojo.User;
import com.imooc.esapi.utils.ESconst;
import org.elasticsearch.action.admin.indices.create.CreateIndexAction;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class EsApiApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    RestHighLevelClient client;

    // 测试索引的创建
    @Test
    void testCreateIndex() throws IOException {
        // 1. 创建索引请求, PUT aw_index
        CreateIndexRequest request = new CreateIndexRequest("aw_index");
        // 2. 客户端执行创建请求 IndicesClient, 请求后获得响应 createIndexResponse
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);

        System.out.println(createIndexResponse);

    }

    // 测试获取索引
    @Test
    void testExistsIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("aw_index");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);

    }

    // 测试删除索引
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("aw_index");
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete);
    }

    // 测试添加文档
    @Test
    void testAddDocument() throws IOException {
        // 创建对象
        User user = new User("aw", 12);
        // 创建请求
        IndexRequest request = new IndexRequest("aw_index");
        // 规则 PUT /aw_index/_doc/1
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));

        // 将我们的数据放入请求 json
        // 将User对象序列化成Json字符串
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);
        request.source(json, XContentType.JSON);

        // 客户端发送请求, 获取响应的结果
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status());


    }

    // 测试获取文档, 仅判断文档是否存在
    @Test
    void testIsExist() throws IOException {
        GetRequest request = new GetRequest("aw_index", "1");
        // 不获取返回的 _source 的上下文了
        request.fetchSourceContext(new FetchSourceContext(false));

        boolean exists = client.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);

    }

    // 获取文档的信息
    @Test
    void testGetDocument() throws IOException {
        GetRequest request = new GetRequest("aw_index", "1");
        // 不获取返回的 _source 的上下文了
        //request.fetchSourceContext(new FetchSourceContext(false));

        //boolean exists = client.exists(request, RequestOptions.DEFAULT);
        GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
        System.out.println(getResponse); // 返回文档的所有信息, 和使用GET 命令是一样的
        System.out.println(getResponse.getSourceAsString()); // 打印文档的内容

    }

    // 更新文档的信息
    @Test
    void testUpdateDocu() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("aw_index", "1");
        updateRequest.timeout("1s");

        User user = new User("aa", 12);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);

        updateRequest.doc(s, XContentType.JSON);

        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);

        System.out.println(updateResponse.toString());
        System.out.println(updateResponse.status());


    }

    // 删除文档记录
    @Test
    void testDeleteRequest() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("aw_index", "1");
        deleteRequest.timeout("1s");

        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status());
        System.out.println(deleteResponse.toString());

    }

    // 批量插入数据
    @Test
    void testBulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        ArrayList<User> userlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userlist.add(new User("aw" + i, i * 3));
        }
        ObjectMapper mapper = new ObjectMapper();

        // 批处理请求
        for (int i = 0; i < userlist.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("aw_index")
                            // 如果不指定id，则会生成随机id
                            .id("" + (i + 1))
                            .source(mapper.writeValueAsString(userlist.get(i)), XContentType.JSON)
            );
        }

        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.toString());
        System.out.println(bulkResponse.status());
    }

    // 搜索
    // SearchRequest 搜索请求
    // 构建Builder
    // SearchSourceBuilder 条件构造
    // HighlightBuilder 构建高亮
    // TermQueryBuilder 精确查询
    // MatchAllQueryBuilder
    // xxx QueryBuilder 实现刚才看到的所有命令

    @Test
    void testSearch() throws IOException {

        //

        ObjectMapper mapper = new ObjectMapper();

        // 常量应该在其它地方预先定义
        // SearchRequest request1 = new SearchRequest(ESconst.ES_INDEX);
        SearchRequest request = new SearchRequest("aw_index");

        // 构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // 查询条件， 我们可以使用 QueryBuilders 工具来实现
        // QueryBuilders.matchAllQuery() 匹配所有
        //MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("username", "aw7");
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(request, RequestOptions.DEFAULT);

        System.out.println(mapper.writeValueAsString(searchResponse.getHits()));
        System.out.println("=====================");
        System.out.println(mapper.writeValueAsString(searchResponse));
        System.out.println("========================");
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }


    }


}
