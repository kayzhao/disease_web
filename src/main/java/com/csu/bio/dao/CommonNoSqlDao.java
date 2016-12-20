package com.csu.bio.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;

public abstract interface CommonNoSqlDao {
	public abstract <T> void insert(T paramT);

	public abstract <T> T findById(Object paramObject, Class<T> paramClass);

	public abstract <T> List<T> findList(Class<T> paramClass,
			SimpleCriteriaEntry... paramVarArgs);

	public abstract <T> List<T> findListByQuery(Class<T> paramClass,
			Query paramQuery);

	public abstract <T> Long findCount(Class<T> paramClass,
			SimpleCriteriaEntry... paramVarArgs);

	public abstract <T> void removeById(Object paramObject, Class<T> paramClass);

	public abstract <T> void remove(Class<T> paramClass);

	public abstract <T> void updateFirst(List<SimpleUpdateEntry> paramList,
			List<SimpleCriteriaEntry> paramList1, Class<T> paramClass);

	public static class SimpleCriteriaEntry {
		private String key;
		private Object value;
		private Operation operation;

		public String getKey() {
			return this.key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getValue() {
			return this.value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Operation getOperation() {
			return this.operation;
		}

		public void setOperation(Operation operation) {
			this.operation = operation;
		}

		public Criteria toCriteria() {
			if ((this.key == null) || (this.value == null)) {
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

		public static enum Operation {
			eq(Integer.valueOf(1), "=");

			private Integer type;
			private String desc;

			private Operation(Integer type, String desc) {
				this.type = type;
				this.desc = desc;
			}

			public Integer getType() {
				return this.type;
			}

			public String getDesc() {
				return this.desc;
			}

		}

	}

	public static class SimpleUpdateEntry {
		private String key;
		private Object value;
		private Operation operation;

		public String getKey() {
			return this.key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getValue() {
			return this.value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Operation getOperation() {
			return this.operation;
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

		public static enum Operation {
			SET(Integer.valueOf(1), "set"), INC(Integer.valueOf(2), "inc");

			private Integer type;
			private String desc;

			private Operation(Integer type, String desc) {
				this.type = type;
				this.desc = desc;
			}

			public Integer getType() {
				return this.type;
			}

			public String getDesc() {
				return this.desc;
			}
		}
	}
}
