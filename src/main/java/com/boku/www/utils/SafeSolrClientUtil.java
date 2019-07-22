package com.boku.www.utils;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.*;


public class SafeSolrClientUtil {

    /**
     * 批量添加数据-安全验证
     * @param user 用户
     * @param password 密码
     * @param client 连接对象
     * @param beans 数据bean集合
     * @param collection 连接内核
     * @return
     * @throws SolrServerException
     * @throws IOException
     */
    public static UpdateResponse addBeans(String user, String password, SolrClient client, Collection<?> beans, String collection) throws SolrServerException, IOException {
        DocumentObjectBinder binder = client.getBinder();
        ArrayList<SolrInputDocument> docs = new ArrayList(beans.size());
        Iterator var6 = beans.iterator();
        while(var6.hasNext()) {
            Object bean = var6.next();
            docs.add(binder.toSolrInputDocument(bean));
        }
        UpdateRequest req = new UpdateRequest();
        req.setBasicAuthCredentials(user,password);
        req.add(docs);
        req.setCommitWithin(-1);
        return req.process(client, collection);
    }

    /**
     * 查询
     * @param user 用户
     * @param password 密码
     * @param client 连接对象
     * @param params 查询串
     * @param collection 连接内核
     *
     * @throws Exception
     */
    public static QueryResponse query(String user, String password, SolrClient client, SolrParams params, String collection) throws Exception{
        QueryRequest req = new QueryRequest(params);
        req.setMethod(SolrRequest.METHOD.POST);
        req.setBasicAuthCredentials(user,password);
        return req.process(client,collection);
    }

    /**
     * 提交数据-安全验证
     * @param user 用户
     * @param password 密码
     * @param client 连接对象
     * @param collection 连接内核
     * @return
     * @throws SolrServerException
     * @throws IOException
     */
    public static UpdateResponse commit(String user,String password,SolrClient client,String collection) throws SolrServerException, IOException {
        UpdateRequest req = new UpdateRequest();
        req.setBasicAuthCredentials(user,password);
        return req.setAction(AbstractUpdateRequest.ACTION.COMMIT, true, true).process(client, collection);
    }

    /**
     *  回滚数据-安全验证
     * @param user 用户
     * @param password 密码
     * @param client 连接对象
     * @param collection 连接内核
     * @return
     */
    public static UpdateResponse rollback(String user, String password, SolrClient client, String collection) throws IOException, SolrServerException {
        UpdateRequest req = new UpdateRequest();
        req.setBasicAuthCredentials(user,password);
        return req.rollback().process(client, collection);
    }

    /**
     *  索引优化-安全验证
     * @param user 用户
     * @param password 密码
     * @param client 连接对象
     * @param collection 连接内核
     * @return
     * @throws SolrServerException
     * @throws IOException
     */
    public static UpdateResponse optimize(String user, String password, SolrClient client, String collection) throws SolrServerException, IOException {
        UpdateRequest req = new UpdateRequest();
        req.setBasicAuthCredentials(user,password);
        return req.setAction(AbstractUpdateRequest.ACTION.OPTIMIZE, true, true, 1).process(client, collection);
    }
}
