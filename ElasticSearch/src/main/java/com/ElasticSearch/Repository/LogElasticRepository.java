package com.ElasticSearch.Repository;

import java.util.List;

import com.ElasticSearch.Model.Log;

public interface LogElasticRepository {

	List<Log> findByPattern(String pattern);

	List<Log> findInFieldByMatch(String field, String pattern);

}
