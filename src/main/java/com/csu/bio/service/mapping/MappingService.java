package com.csu.bio.service.mapping;

import java.util.List;
import java.util.Map;

public interface MappingService {
	public Map<String, Object> getMappingData(List<String> ids, String type);
}
