package com.ElasticSearch.QueryBuilder;

import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import com.ElasticSearch.Model.Log;
import com.ElasticSearch.Repository.LogElasticRepository;

public class ElasticQueryBuilder implements LogElasticRepository {

	@Autowired
	private ElasticsearchTemplate elasticTemplate;

	public List<Log> findByPattern(String pattern) {

		BoolQueryBuilder query = QueryBuilders.boolQuery().should(QueryBuilders.queryStringQuery("*" + pattern + "*")
				.lenient(true).field("logMessage").field("logService"));

		NativeSearchQuery queryBuilder = new NativeSearchQueryBuilder().withQuery(query).build();

		return elasticTemplate.queryForList(queryBuilder, Log.class);
	}

	public List<Log> findInFieldByMatch(String pattern, String field) {

		BoolQueryBuilder query = QueryBuilders.boolQuery().should(QueryBuilders.matchQuery(field, pattern));

		NativeSearchQuery queryBuilder = new NativeSearchQueryBuilder().withQuery(query).build();

		return elasticTemplate.queryForList(queryBuilder, Log.class);
	}

}
