package demo.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import demo.springframework.examplebeans.FakeDataSource;
import demo.springframework.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySources({
//	    @PropertySource("classpath:datasource.properties"),
//        @PropertySource("classpath:jms.properties") })
// @PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
public class PropertyConfig {

//	@Autowired
//	Environment env;

	@Value("${donne.username}")
	String user;
	@Value("${donne.password}")
	String password;
	@Value("${donne.dburl}")
	String url;

	@Value("${donne.jms.username}")
	String jmsUser;
	@Value("${donne.jms.password}")
	String jmsPassword;
	@Value("${donne.jms.dburl}")
	String jmsUrl;

	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(user);
		fakeDataSource.setPasword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}

	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker jmsBroker = new FakeJmsBroker();
		jmsBroker.setUsername(jmsUser);
		jmsBroker.setPassword(jmsPassword);
		jmsBroker.setUrl(jmsUrl);
		return jmsBroker;
	}

	// reading the file/scan for property files
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}

}
