package com.csu.bio.service.data;

import org.springframework.data.mongodb.core.mapping.Document;

public interface DataService {

	public <T> T getDataByID(String id, Class<T> clz);

	public Document getDataByID(String id);
}
