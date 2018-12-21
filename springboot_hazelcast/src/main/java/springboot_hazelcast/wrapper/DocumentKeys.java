package springboot_hazelcast.wrapper;

import org.springframework.data.annotation.Id;


/**
 * <h1>DocumentKeys</h1>
 * <p>
 * This class is a used to hold the keys from the MongoDB which will be used by the LoadALLKeys method in map store for loading all the 
 * keys in the cache
 * </p>
 *  
 * @version 0.1
 * @since 1 August,2017
 * */
public class DocumentKeys {

	
	@Id
	private String key;

	/**
	 * @return key
	 *    object
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key 
	 *      string object
	 *    
	 */
	public void setKey(String key) {
		this.key = key;
	}

}
