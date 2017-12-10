package com.java7book.securewebapp.login;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;
import javax.security.auth.login.Configuration;

public class SecureConfiguration extends Configuration {
	private Path rootPath;
	public SecureConfiguration(Path rootPath) {
		this.rootPath = rootPath;
	}

	public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
		Map<String, String> properties = new HashMap<String, String>();
		Path path = rootPath.resolve("WEB-INF/classes/user.properties");
		properties.put("properties.file.path", path.toAbsolutePath().toString());
		AppConfigurationEntry entry = new AppConfigurationEntry("com.java7book.securewebapp.login.PropertiesFileBasedLoginModule", LoginModuleControlFlag.REQUIRED, properties);
		return new AppConfigurationEntry[] { entry };
	}
}
