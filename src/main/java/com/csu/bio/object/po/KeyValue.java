
package com.csu.bio.object.po;

/**
 * 
 */
public class KeyValue {

	public String key;

	/**
	 * 
	 * 需要注意的是:
	 * 
	 * value 如果默认为null的则是依赖上文的参数(即依赖上步的输入)
	 * 
	 * value 如果不为null的则是可以自定义值的输入参数
	 * 
	 */
	public String value;

	/***
	 * 
	 * tag标记上下文参数 属性值参数 结束参数
	 */
	public String tag;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
