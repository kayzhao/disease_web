package com.csu.bio.util;

/**
 *
 * @author  kayzhao
 * @version 2016年12月21日
 */

import java.io.IOException;
import java.util.Properties;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
	private static Properties constants = new Properties();

	public static String getProperty(String key) {
		return constants.getProperty(key);
	}

	protected void loadProperties(Properties props) throws IOException {
		super.loadProperties(props);
		constants = props;
	}
}