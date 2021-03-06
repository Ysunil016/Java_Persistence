package com.ElasticSearch.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElasticSearch.Model.Log;
import com.ElasticSearch.Repository.LogRepository;

@RestController
@RequestMapping("/logs")
public class LogsResource {

	@Autowired
	private LogRepository logRepository;

	@GetMapping("/all")
	public Iterable<Log> getAllLogs() {
		return logRepository.findAll();
	}

	@GetMapping("/getByServiceName/{serviceName}")
	public Iterable<Log> getLogsByServiceName(@PathVariable("serviceName") String serviceName) {
		return logRepository.findByServiceName(serviceName);
	}

	@GetMapping("/getByServiceName/{serviceName}/{pageNumber}/{pageSize}")
	public Iterable<Log> getLogsByServiceNamePagination(@PathVariable("serviceName") String serviceName,
			@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize) {
		return logRepository.findByServiceName(serviceName, PageRequest.of(pageNumber, pageSize));
	}

	@PostMapping("/add")
	public Log addLog(@RequestBody Log log) {
		return logRepository.save(log);
	}

}
