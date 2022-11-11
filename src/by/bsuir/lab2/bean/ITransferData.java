package by.bsuir.lab2.bean;

import java.util.*;

/**
 * 
 * @author nikmi
 *Used to represent properties of different objects
 */
public interface ITransferData {
	/**
	 * 
	 * @param propertyName - name of the property
	 * @param data - value of the corresponding property
	 */
	public void addProperty(String propertyName, Object data);
	
	
	/**
	 * Combine properties of transfer data
	 * @param data
	 */
	public void addProperties(ITransferData data);
	
	
	/**
	 * 
	 * @param propertyName - name of the property
	 * @return object of property
	 */
	public Object getProperty(String propertyName) throws IllegalArgumentException;
	
	
	/**
	 * Get all registered properties of object
	 * @return
	 */
	public Map<String, Object> getMapOfProperties();
}
