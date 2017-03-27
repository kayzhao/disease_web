package com.csu.bio.service.network;

import java.util.List;
import java.util.Map;

import com.csu.bio.object.model.UMLSREL;

public interface NetworkService {
	public <T> Map<String, Object> getRelationshipData(List<String> ids, Class<T> clz);

	public UMLSREL getUMLSRELData(String id);
}
