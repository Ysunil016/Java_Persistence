package com.ElasticSearch.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.ElasticSearch.Model.Log;

@EnableElasticsearchRepositories
public interface LogRepository extends ElasticsearchRepository<Log, Long> {

	List<Log> findByServiceName(String serviceName);

	List<Log> findByServiceName(String serviceName, Pageable page);

}
