package com.ElasticSearch.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentProperty;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mapping.context.MappingContext;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.ElasticSearch.Repository")
public class ElasticConfiguration {

	@Bean
	public Client elasticsearchClient() throws UnknownHostException {
		Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
		TransportClient client = new PreBuiltTransportClient(settings);
		client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
		return client;
	}

	@Bean(name = {"elasticsearchOperations", "elasticsearchTemplate"})
	public ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException
	    return new ElasticsearchTemplate(elasticsearchClient(), entityMapper());
	  }

	// use the ElasticsearchEntityMapper
	@Bean
	@Override
	public EntityMapper entityMapper() {
		ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper((MappingContext<? extends ElasticsearchPersistentEntity<?>, ElasticsearchPersistentProperty>) elasticsearchClient(),
				new DefaultConversionService());
		entityMapper.setConversions(elasticsearchCustomConversions());
		return entityMapper;
	}

}
