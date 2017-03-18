package com.csu.bio.service.network;

import java.util.List;
import java.util.Map;

import com.csu.bio.object.model.UMLSREL;

public interface NetworkService {
	public Map<String, Object> getRelationshipData(List<String> ids);

	public UMLSREL getUMLSRELData(String id);
}
