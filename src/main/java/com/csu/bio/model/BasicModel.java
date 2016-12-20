package com.csu.bio.model;

import java.io.Serializable;

/**
 * 
 * @author kayzhao
 *
 */
public abstract class BasicModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int Id;

	public abstract int getId();

	public abstract void setId(int id);

}
