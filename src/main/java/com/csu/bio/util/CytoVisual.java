package com.csu.bio.util;

import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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

}
