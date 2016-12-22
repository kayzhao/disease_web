package com.csu.bio.util;

/**
 *
 * @author kayzhao
 * @version 2016年12月22日
 */
public class UMLSProps {
	private String host;
	private String port;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return host + "|" + port;

	}
}
