package com.ElasticSearch.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "Con_Logs", type = "Forum", shards = 1)
public class Log {

	@Id
	private long logId;
	private String loggingService;
	private String logMessage;
	private String logTimestamp;

	public Log(String loggingService, String logMessage, String logTimestamp) {
		this.logId = System.nanoTime();
		this.loggingService = loggingService;
		this.logMessage = logMessage;
		this.logTimestamp = logTimestamp;
	}

	public Log() {
	}

	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public String getLoggingService() {
		return loggingService;
	}

	public void setLoggingService(String loggingService) {
		this.loggingService = loggingService;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public String getLogTimestamp() {
		return logTimestamp;
	}

	public void setLogTimestamp(String logTimestamp) {
		this.logTimestamp = logTimestamp;
	}

}
