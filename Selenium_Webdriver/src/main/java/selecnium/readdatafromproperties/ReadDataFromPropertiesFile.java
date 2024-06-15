package selecnium.readdatafromproperties;

import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\application.properties");
		properties.load(fileInputStream);

		String url = properties.getProperty("url");
		String email = properties.getProperty("email");
		String pwd = properties.getProperty("password");
		String orderid = properties.getProperty("orderid");
		String customerid = properties.getProperty("customerid");

		System.out.println(url + "" + email + "" + pwd + "" + orderid + "" + customerid);

		Set<Object> keys = properties.keySet();
		System.out.println("Using Set for keys" + keys);

		Collection<Object> value = properties.values();
		System.out.println("Using Collection for values " + value);
		fileInputStream.close();

	}

}
