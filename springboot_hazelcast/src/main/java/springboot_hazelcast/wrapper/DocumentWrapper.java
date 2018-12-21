package springboot_hazelcast.wrapper;

import javax.persistence.Id;

/**
 * <h1>DocumentWrapper</h1>
 * <p>
 * This class is a wrapper object for the documents that are stored inside the
 * mongo database. Document id is stored as the unique id for the document
 * stored inside the database and this object will used as a wrapper for all the
 * objects stored in the documents.
 * </p>
 * 
 * @version 0.1
 * @since 20 May,2017
 * */
public class DocumentWrapper {

	@Id
	private String id;

	private Class<?> classType;
	// private String _id;
	private String objectJsonString;

	/**
	 * Default constructor
	 */
	public DocumentWrapper() {
	}

	/**
	 * Parameterized constructor for initializing Document Wrapper Object
	 * 
	 * @param _id
	 *            String object
	 * 
	 * @param object
	 *            wrapper object
	 * 
	 */
	public DocumentWrapper(String _id, String objectJsonString,
			Class<?> classType) {
		// this._id = _id;
		this.id = _id;
		this.objectJsonString = objectJsonString;
		this.classType = classType;
	}

	/**
	 * @return object wrapper object
	 */
	public String getObjectJsonString() {
		return objectJsonString;
	}

	public void setObjectJsonString(String objectJsonString) {
		this.objectJsonString = objectJsonString;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class<?> getClassType() {
		return classType;
	}

	public void setClassType(Class<?> classType) {
		this.classType = classType;
	}

}
