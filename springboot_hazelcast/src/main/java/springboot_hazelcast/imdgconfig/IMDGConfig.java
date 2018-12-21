package springboot_hazelcast.imdgconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;


/**
 * <h1>IMDGConfig</h1>
 * <p>
 * This class will provide singleton cache instance for connecting to all the
 * IMDG Servers/Clusters
 * 
  </p>
 ** @version 0.1
 * @since 20 May,2017
 * */
@Configuration
@ConfigurationProperties
public class IMDGConfig {


	@Value("${imdg.file.path:#{null}}")
	private String IMDG_XML_FILE_PATH;

	/**
	 * Hazel-cast Instance member variable
	 */
	@Autowired
	HazelcastInstance hazelcastInstance;


	/**
	 * This method returns singleton IMDG instance by reading the configuration
	 * information from Hazel-cast XML file
	 * 
	 * 
	 * @return hazelcastInstance singleton IMDG instance
	 * 
	 */
	@Bean
	public HazelcastInstance getInstance(){

		try {
			/**
			 * If the IMDG instance is instantiated/called by the application
			 * for the first time it will create new instance and if it is
			 * called again by the application for the IMDG Instance it will
			 * return same instance as it is singleton object
			 */
			if (hazelcastInstance == null) {
				/**
				 * This ClasspathXmlConfig will load the hazel-cast
				 * configuration from the XML file and initialize the
				 * configuration object
				 */
				Config config = new FileSystemXmlConfig(IMDG_XML_FILE_PATH);
				hazelcastInstance = Hazelcast.newHazelcastInstance(config);
			}
		} catch (Exception exception) {
			
				exception.printStackTrace();
			
		}
		return hazelcastInstance;

	}

}