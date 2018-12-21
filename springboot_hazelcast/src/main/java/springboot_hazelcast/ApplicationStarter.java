package springboot_hazelcast;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import springboot_hazelcast.imdgconfig.IMDGConfig;

//@ComponentScan({ "springboot_hazelcast.mapstore.*", "springboot_hazelcast.controller.*",
//		"springboot_hazelcast.imdgconfig.*", "springboot_hazelcast.wrapper.*", "springboot_hazelcast.*" })
@EnableConfigurationProperties
@SpringBootApplication(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
public class ApplicationStarter implements CommandLineRunner {
	@Autowired
	IMDGConfig imdgConfig;
//	static {
//		System.setProperty("spring.config.location",
//				"file:D://MYAPPLICATIONS//Practice_On_SpringBoot//springboot_hazelcast//src//main//resources//properties.yml");
//	}

	public static void main(String[] args) {
//		SpringApplication.run(ApplicationStarter.class, args);
		new SpringApplicationBuilder(ApplicationStarter.class).properties("spring.config.name=application,,properties")
				.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		HazelcastInstance instance = imdgConfig.getInstance();
		IMap<Object, Object> map = instance.getMap("Employees");

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("eid", "124");
		m.put("name", "knr");
		m.put("dep", "development");
		map.put("empdata", m);
		System.out.println(map.get("empdata"));
		System.out.println("successfully retrived");

//		instance.shutdown();
	}
}