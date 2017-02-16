package com.csu.bio.service.mapping;

import java.util.List;
import java.util.Map;

import com.csu.bio.object.model.DisMap;

public interface MappingService {

	public Map<String, DisMap> getMappingData(List<String> ids, String type);
}
