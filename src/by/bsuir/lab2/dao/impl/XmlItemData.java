package by.bsuir.lab2.dao.impl;

import by.bsuir.lab2.dao.*;
import by.bsuir.lab2.bean.*;
import by.bsuir.lab2.dao.interf.*;

import java.io.FileWriter;
import java.util.*;
import javax.xml.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;

public final class XmlItemData implements ItemData {
	
	public XmlItemData(String fileName){
		this.fileName = fileName;
		try {
			fileWriter = new FileWriter(fileName);
			xmlWriter =  XMLOutputFactory.newFactory().createXMLStreamWriter(fileWriter);
		} catch (Exception e) {
			
		}
	}
	
	//public void close() {
	//	xmlWriter.close();
	//}
	
	public void writeData(ITransferData data) {
		startWriteDocument();
		writeXmlElement(data);
		endWriteDocument();
	}
	
	
	public void writeData(ITransferData[] data) {
		startWriteDocument();
		for(ITransferData dataItem: data) {
			writeXmlElement(dataItem);
		}
		endWriteDocument();
	}
	
	
	private void startWriteDocument() {
		try {
			xmlWriter.writeStartDocument("1.0.0");
			xmlWriter.writeCharacters("\n");
		} catch (Exception e) {
			
		}
	}
	
	
	private void endWriteDocument() {
		try {
			xmlWriter.writeEndDocument();
			xmlWriter.flush();
		} catch (Exception e) {
			
		}
	}
	
	
	private void writeXmlElement(ITransferData data) {
		Map<String, Object> dataProperties = data.getMapOfProperties();
		Set<String> propertyNames =  dataProperties.keySet();
		for (String property: propertyNames) {
			try {
				xmlWriter.writeStartElement(property);
				xmlWriter.writeAttribute("value", dataProperties.get(property).toString());
				xmlWriter.writeEndElement();
				xmlWriter.writeCharacters("\n");
			} catch (Exception e) {
				String messString = e.getMessage();
				messString += "a";
			}
		}
	}
	
	
	//public ITransferData readData() {
		
	//}
	
	private String fileName;
	private static XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
	private FileWriter fileWriter;
	private XMLStreamWriter xmlWriter;
}
