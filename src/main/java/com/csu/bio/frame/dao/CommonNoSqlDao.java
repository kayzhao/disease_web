package com.csu.bio.frame.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * 
 */
public interface CommonNoSqlDao {
	/**
	 * 保存对象
	 * 
	 * @param t
	 *            对象
	 */
	public <T> void insert(T t);

	/**
	 * 根据主键查找
	 * 
	 * @param id
	 *            主键
	 * @param clz
	 *            类型
	 * @return
	 */
	public <T> T findById(Object id, Class<T> clz);

	/**
	 * 查找列表
	 * 
	 * @param clz
	 *            类型
	 * @param entries
	 *            条件
	 * @return
	 */
	public <T> T findOne(Class<T> clz, SimpleCriteriaEntry... entries);

	/**
	 * 查找列表
	 * 
	 * @param clz
	 *            类型
	 * @param entries
	 *            条件
	 * @return
	 */
	public <T> List<T> findList(Class<T> clz, SimpleCriteriaEntry... entries);

	/**
	 * 
	 * findListByQuery:根据query进行查找,比findList方法更广泛. <br/>
	 * 
	 * @param clz
	 * @param query
	 * @return
	 */
	public <T> List<T> findListByQuery(Class<T> clz, Query query);

	/**
	 * 查询文档总数
	 * 
	 * @param clz
	 *            类型
	 * @param entries
	 *            条件
	 * @return
	 */
	public <T> Long findCount(Class<T> clz, SimpleCriteriaEntry... entries);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 *            主键
	 * @param clz
	 *            类型
	 */
	public <T> void removeById(Object id, Class<T> clz);

	/**
	 * 根据运行状态删除
	 * 
	 * @param id
	 * @param clz
	 */
	public <T> void removeByState(Object id, Class<T> clz);

	/**
	 * 更新第一条文档
	 * 
	 * @param uentries
	 *            更新条件
	 * @param centries
	 *            查询条件
	 * @param clz
	 *            类型
	 */
	public <T> void updateFirst(List<SimpleUpdateEntry> uentries, List<SimpleCriteriaEntry> centries, Class<T> clz);

	public static class SimpleCriteriaEntry {
		private String key;

		private Object value;

		private Operation operation;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Operation getOperation() {
			return operation;
		}

		public void setOperation(Operation operation) {
			this.operation = operation;
		}

		public Criteria toCriteria() {
			if (this.key == null || this.value == null) {
				throw new NullPointerException("key or value is null");
			}

			if (this.operation == null) {
				this.operation = Operation.eq;
			}
			Criteria criteria = null;
			if (this.operation == Operation.eq) {
				criteria = new Criteria().and(this.key).is(this.value);
			}

			if (criteria == null) {
				throw new NullPointerException("criteria is null");
			}

			return criteria;
		}

		public static SimpleCriteriaEntry createEqEntry(String key, Object value) {
			SimpleCriteriaEntry entry = new SimpleCriteriaEntry();
			entry.setKey(key);
			entry.setValue(value);
			entry.setOperation(Operation.eq);

			return entry;
		}

		public enum Operation {
			/** 相等操作 */
			eq(1, "="),;

			private Integer type;

			private String desc;

			private Operation(Integer type, String desc) {
				this.type = type;
				this.desc = desc;
			}

			public Integer getType() {
				return type;
			}

			public String getDesc() {
				return desc;
			}
		}
	}

	public static class SimpleUpdateEntry {
		private String key;

		private Object value;

		private Operation operation;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Operation getOperation() {
			return operation;
		}

		public void setOperation(Operation operation) {
			this.operation = operation;
		}

		public static SimpleUpdateEntry createSetEntry(String key, Object value) {
			SimpleUpdateEntry entry = new SimpleUpdateEntry();
			entry.setKey(key);
			entry.setValue(value);
			entry.setOperation(Operation.SET);

			return entry;
		}

		public static SimpleUpdateEntry createIncEntry(String key, Object value) {
			SimpleUpdateEntry entry = new SimpleUpdateEntry();
			entry.setKey(key);
			entry.setValue(value);
			entry.setOperation(Operation.INC);

			return entry;
		}

		public enum Operation {
			/** 设置操作 */
			SET(1, "set"),

			/** 增值操作 */
			INC(2, "inc");

			private Integer type;

			private String desc;

			private Operation(Integer type, String desc) {
				this.type = type;
				this.desc = desc;
			}

			public Integer getType() {
				return type;
			}

			public String getDesc() {
				return desc;
			}
		}
	}
}
