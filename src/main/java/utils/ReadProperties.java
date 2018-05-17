package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {


	public  String getSaucelabs(String key) {
		String value = null;

		key = key.trim();
		Properties prop = loadProperties("Saucelabs");

		value = prop.getProperty(key);

		return value;
	}

	public  String getProperty(String key) {
		String value = " ";

		key = key.trim();
		Properties prop = loadProperties("testRun");

		value = prop.getProperty(key);

		if (value == null) {

			String testEnv = prop.getProperty("testEnv");

			prop = loadProperties(testEnv);

			value = prop.getProperty(key);
		}

		return value;
	}

	public  Properties loadProperties(String propFileName) {
		Properties prop = new Properties();

		String filePath = ".\\src\\main\\resources\\properties\\" + propFileName.trim() + ".properties";

		try {

			File file = new File(filePath);

			FileInputStream fileInputStream = new FileInputStream(file);
			prop.load(fileInputStream);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return prop;
	}

}
