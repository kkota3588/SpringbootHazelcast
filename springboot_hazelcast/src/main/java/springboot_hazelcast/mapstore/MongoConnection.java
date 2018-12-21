package springboot_hazelcast.mapstore;

import static com.mongodb.MongoClientOptions.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;

/**
 * <h1>DefaultNoSQLMapStore</h1>
 * <p>
 * This DefaultNoSQLMapStore class will be called by the IMDG internally when
 * any specific operations like get, loadAll, put, etc are performed on the
 * distributed map. It is also responsible for interacting with the persistent
 * data store and perform load/store/delete operations.
 * </p>
 * 
 * @version 0.1
 * @since 20 May,2017
 */

@Configuration
@ConfigurationProperties
public class MongoConnection {

	private static final String MONGO_DB_URL = "mongodb://";
	private static final String MONGO_CONNECTION_SUCCESS = "Mongo Connection Created Successfully";
	private static final boolean MONGO_SSL = true;
	private static final Logger log = LoggerFactory.getLogger(MongoConnection.class);

	@Value("${mongodb.url:#{null}}")
	private String MONGO_URL;

	/**
	 * Method that returns the Mongo Object
	 * 
	 * @return Mongo object returns the mongoclient object
	 * @throws Exception
	 */
	@Bean(name = "mongoclient")
	public Mongo mongo() throws Exception {
//		MongoClientOptions.Builder options = builder().sslEnabled(MONGO_SSL)
//				.sslInvalidHostNameAllowed(true);
		MongoClientURI connectionString = new MongoClientURI(MONGO_DB_URL + MONGO_URL);
		MongoClient mongoClient = new MongoClient(connectionString);
		log.debug(MONGO_CONNECTION_SUCCESS);
		return mongoClient;
	}

	/*
	 * @Bean(name = "codecRegistry") public CodecRegistry registry() { return
	 * CodecRegistries.fromRegistries( CodecRegistries.fromProviders(new
	 * ClassCodecProvider()), MongoClient.getDefaultCodecRegistry()); }
	 */
	/**
	 * Method that return the MongoTemplate
	 * 
	 * @return MongoTemplate object
	 * @throws Exception
	 */
	/*
	 * @Bean(name = "mongotemplate") public MongoTemplate mongoTemplate() throws
	 * Exception { return new MongoTemplate(mongo(), MONGO_DB_NAME); }
	 */

	/*
	 * private static class ClassCodec implements Codec<Class> {
	 * 
	 * @Override public Class decode(BsonReader reader, DecoderContext
	 * decoderContext) { try { return Class.forName(reader.readString()); } catch
	 * (ClassNotFoundException e) { throw new
	 * MongoException("Couldn't read value as class type", e); } }
	 * 
	 * @Override public void encode(BsonWriter writer, Class value, EncoderContext
	 * encoderContext) { writer.writeString(value.getName()); }
	 * 
	 * @Override public Class<Class> getEncoderClass() { return Class.class; } }
	 * 
	 * private static class ClassCodecProvider implements CodecProvider {
	 * 
	 * @Override public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
	 * if (clazz == Class.class) { return (Codec<T>) new ClassCodec(); } return
	 * null; } }
	 */

}