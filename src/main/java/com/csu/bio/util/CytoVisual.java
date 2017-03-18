package com.csu.bio.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.csu.bio.object.model.UMLSREL;

public class CytoVisual {

	/**
	 * 将网络数据封装成JSON格式数据以便Cytoscape可视化
	 * 
	 * @param datasets
	 *            即一条条边组成的网络集合
	 * @return 封装成JSON格式的数据
	 */
	public static String encapsulateNet2Json(List<String> datasets) {

		HashSet<String> proteinNodes = new HashSet<>();
		JSONArray edges = new JSONArray();
		for (String eachData : datasets) {
			String[] dataset = eachData.split("\\t|\\s");
			// 获取所有的蛋白质节点
			proteinNodes.add(dataset[0]);
			proteinNodes.add(dataset[1]);
			// JSON封装边数据
			JSONObject edge = new JSONObject();
			JSONObject data = new JSONObject();
			data.put("source", dataset[0]);
			data.put("target", dataset[1]);
			if (dataset.length == 3) {
				data.put("label", dataset[2]);
			}
			edge.put("data", data);
			edges.add(edge);
		}
		// JSON封装节点数据
		JSONArray nodes = new JSONArray();
		for (String proteinNode : proteinNodes) {
			JSONObject node = new JSONObject();
			JSONObject data = new JSONObject();
			data.put("id", proteinNode);
			data.put("name", proteinNode);
			node.put("data", data);
			nodes.add(node);
		}
		// Cytoscape.js的JSON格式数据
		JSONObject cydatas = new JSONObject();
		cydatas.put("nodes", nodes);
		cydatas.put("edges", edges);
		System.out.println(cydatas.toString());

		return cydatas.toString();
	}

	public static String RELNet2Json(Map<String, Object> map) throws Exception {
		JSONObject cydatas = new JSONObject();
		for (String key : map.keySet()) {
			JSONObject json = Bean2JSON(map.get(key));
			// cydatas.putAll(json);
			for (String json_key : json.keySet()) {
				Object array = json.get(json_key);
				if (cydatas.containsKey(json_key)) {
					((JSONArray) array).addAll((Collection<? extends Object>) cydatas.get(json_key));
				}
				cydatas.put(json_key, array);
			}
		}
		System.out.println(cydatas.toString());
		return cydatas.toString();
	}

	public static String RELNet2Json(List<UMLSREL> datasets) throws Exception {
		JSONObject cydatas = new JSONObject();
		for (UMLSREL rel : datasets) {
			JSONObject object = Bean2JSON(rel);
			for (String key : object.keySet()) {
				cydatas.put(key, object.get(key));
			}
		}
		System.out.println(cydatas.toString());
		return cydatas.toString();
	}

	public static <T> JSONObject Bean2JSON(T obj) throws Exception {
		JSONObject cydatas = new JSONObject();
		JSONArray nodes = new JSONArray();
		JSONArray edges = new JSONArray();
		JSONObject t_json = (JSONObject) JSON.toJSON(obj);
		// convert to cytoscape json
		List<String> keys = new ArrayList<>(t_json.keySet());
		String primary_key = (String) t_json.get("disease_id");

		Set<String> node_ids = new HashSet<>();
		for (int i = 0; i < keys.size(); i++) {
			if ("disease_id".equals(keys.get(i))) {
				node_ids.add(primary_key);
				continue;
			}
			if (t_json.get(keys.get(i)) == null)
				continue;
			List<String> ids = (List<String>) t_json.get(keys.get(i));
			for (String id : ids) {
				node_ids.add(id);
				// edge
				JSONObject edge = new JSONObject();
				JSONObject data = new JSONObject();
				data.put("source", primary_key);
				data.put("target", id);
				data.put("label", keys.get(i));
				edge.put("data", data);
				edges.add(edge);
			}
		}

		List<String> node_list = new ArrayList<>(node_ids);
		for (String n : node_list) {
			JSONObject node = new JSONObject();
			JSONObject data = new JSONObject();
			data.put("id", n);
			data.put("name", n);
			node.put("data", data);
			nodes.add(node);
		}

		// add nodes and edges
		cydatas.put("nodes", nodes);
		cydatas.put("edges", edges);
		return cydatas;
	}
}
