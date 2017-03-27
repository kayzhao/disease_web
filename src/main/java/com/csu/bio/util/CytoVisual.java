package com.csu.bio.util;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

	public static String Net2Json(Map<String, Object> map) throws Exception {
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
		// primary key
		JSONObject key_node = new JSONObject();
		JSONObject key_data = new JSONObject();
		key_data.put("id", primary_key);
		key_data.put("name", primary_key);
		key_data.put("weight", 20);
		key_data.put("faveShape", "ellipse");
		key_data.put("faveColor", getRandomColor(0));
		key_node.put("data", key_data);
		nodes.add(key_node);

		for (int i = 0; i < keys.size(); i++) {
			if ("disease_id".equals(keys.get(i))) {
				continue;
			}
			if (!t_json.containsKey(keys.get(i)))
				continue;
			List<String> ids = (List<String>) t_json.get(keys.get(i));
			if (ids == null || ids.size() == 0)
				continue;

			String color = getRandomColor(i);
			String shape = CytoShape.getShapeByID((i + 1) % CytoShape.values().length);
			int weight = ids.size();
			for (String id : ids) {
				// node
				JSONObject node_c = new JSONObject();
				JSONObject data_c = new JSONObject();
				data_c.put("id", id);
				data_c.put("name", id);
				data_c.put("weight", weight);
				data_c.put("faveShape", shape);
				data_c.put("faveColor", color);
				node_c.put("data", data_c);
				nodes.add(node_c);

				// edge
				JSONObject edge = new JSONObject();
				JSONObject data_e = new JSONObject();
				data_e.put("source", primary_key);
				data_e.put("target", id);
				data_e.put("label", keys.get(i));
				data_e.put("faveColor", color);
				data_e.put("strength", weight);
				edge.put("data", data_e);
				edges.add(edge);
			}
		}

		// add nodes and edges
		cydatas.put("nodes", nodes);
		cydatas.put("edges", edges);
		return cydatas;
	}

	public static <T> JSONObject Bean2JSONCompound(T obj) throws Exception {
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
				JSONObject key_node = new JSONObject();
				JSONObject key_data = new JSONObject();
				key_data.put("id", primary_key);
				key_data.put("name", primary_key);
				key_node.put("data", key_data);
				nodes.add(key_node);
				continue;
			}
			if (!t_json.containsKey(keys.get(i)))
				continue;
			List<String> ids = (List<String>) t_json.get(keys.get(i));
			if (ids == null || ids.size() == 0)
				continue;
			// compound
			JSONObject node_c = new JSONObject();
			JSONObject data_c = new JSONObject();
			data_c.put("id", keys.get(i));
			data_c.put("name", keys.get(i));
			data_c.put("weight", ids.size() * 10);
			data_c.put("faveShape", CytoShape.getShapeByID((i + 1) % CytoShape.values().length));
			String color = getRandomColor(i + 1);
			data_c.put("faveColor", color);
			node_c.put("data", data_c);
			nodes.add(node_c);

			// nodes of compound
			for (String id : ids) {
				node_ids.add(id);
				JSONObject node = new JSONObject();
				JSONObject data = new JSONObject();
				data.put("id", id);
				data.put("name", id);
				data.put("parent", keys.get(i));
				node.put("data", data);
				nodes.add(node);
			}

			// edge
			JSONObject edge = new JSONObject();
			JSONObject data_e = new JSONObject();
			data_e.put("source", primary_key);
			data_e.put("target", keys.get(i));
			data_e.put("label", keys.get(i));
			data_e.put("faveColor", color);
			data_e.put("strength", ids.size() * 10);
			edge.put("data", data_e);
			edges.add(edge);
		}

		List<String> node_list = new ArrayList<>(node_ids);
		for (String n : node_list) {
			JSONObject node = new JSONObject();
			JSONObject data = new JSONObject();
			data.put("id", n);
			data.put("name", n);
			data.put("group", "nodes");
			node.put("data", data);
			nodes.add(node);
		}

		// add nodes and edges
		cydatas.put("nodes", nodes);
		cydatas.put("edges", edges);
		return cydatas;
	}

	public static String getRandomColor(int i) {
		Random rand = new Random();
		String[] colors = { "#E5E4E2", "#1569c7", "#6593c7", "#e0ffff", "#848b79", "#728c00", "#254117", "#ffffc2",
				"#ffebcd", "#ffcba4", "#ff0000", "c04000", "#7d0552", "#faafbe" };
		float r = rand.nextFloat();
		float g = rand.nextFloat() / 2f;
		float b = rand.nextFloat() / 2f;
		Color randomColor = new Color(r, g, b).brighter();
		// return String.format("#%06x", randomColor.getRGB() & 0x00FFFFFF);
		return colors[i % colors.length];
	}

	public enum CytoShape {
		RECTANGLE(1, "rectangle"), ROUNDRECTANGLE(2, "roundrectangle"), ELLIPSE(3, "ellipse"), TRIANGLE(4,
				"triangle"), PENTAGON(5, "pentagon"), HEXAGON(6, "hexagon"), OCTAGON(7, "octagon"), STAR(8,
						"star"), DIAMOND(9, "diamond"), VEE(10,
								"vee"), RHOMBOID(11, "rhomboid"), POLYGON(12, "polygon"), HEPTAGON(13, "heptagon");

		private Integer type;

		private String desc;

		private CytoShape(Integer type, String desc) {
			this.type = type;
			this.desc = desc;
		}

		public Integer getType() {
			return type;
		}

		public String getDesc() {
			return desc;
		}

		public static String getShapeByID(Integer type) {
			String desc = null;
			for (CytoShape i : CytoShape.values()) {
				if (i.type == type) {
					desc = i.desc;
					break;
				}
			}
			return desc;
		}
	}
}
