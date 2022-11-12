package by.bsuir.lab2.bean;

import java.util.*;

public class MapTransferData implements ITransferData{
	
	public MapTransferData() {
	}

	/**
	 * 
	 * @param propertyName - name of the property
	 * @param data - value of the corresponding property
	 */
	@Override
	public void addProperty(String propertyName, Object data) {
		mPropertyMap.put(propertyName, data);
	}
	
	@Override
	public void removeProperty(String propertyName) throws IllegalArgumentException{
		if (!mPropertyMap.containsKey(propertyName)) {
			throw new IllegalArgumentException("There is no property " + propertyName);
		}
		mPropertyMap.remove(propertyName);
	}
	
	
	/**
	 * Combine properties of transfer data
	 * @param data
	 */
	public void addProperties(ITransferData data) {
		Map<String, Object> transferData = data.getMapOfProperties();
		mPropertyMap.putAll(transferData);
	}
	
	
	/**
	 * 
	 * @param propertyName - name of the property
	 * @return object of property
	 */
	@Override
	public Object getProperty(String propertyName) throws IllegalArgumentException{
		Object properyData = mPropertyMap.get(propertyName);
		if( properyData == null) {
			throw new IllegalArgumentException("No such property");
		}
		return properyData;
	}
	
	
	/**
	 * Get all registered properties of object
	 * @return
	 */
	@Override
	public Map<String, Object> getMapOfProperties(){
		return mPropertyMap;
	}
	
	
	private HashMap<String, Object> mPropertyMap = new HashMap<String, Object>();
}
