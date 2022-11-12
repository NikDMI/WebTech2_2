package by.bsuir.lab2.dao.impl;

import by.bsuir.lab2.dao.*;
import java.util.*;
import by.bsuir.lab2.bean.*;
import by.bsuir.lab2.dao.interf.*;
import by.bsuir.lab2.dao.exception.*;

import java.io.FileWriter;
import java.lang.constant.Constable;
import java.util.*;
import javax.xml.*;
import javax.xml.stream.*;
import java.io.*;

public final class XmlItemData implements ItemData {
	
	public XmlItemData(String fileName){
		this.fileName = fileName;
	}
	
	
	public void writeData(ITransferData data) throws DaoException {
		startWriteDocument();
		writeXmlElement(data);
		endWriteDocument();
	}
	
	
	public void writeData(ITransferData[] data) throws DaoException {
		startWriteDocument();
		for(ITransferData dataItem: data) {
			writeXmlElement(dataItem);
		}
		endWriteDocument();
	}
	
	
	
	public ArrayList<ITransferData> readData() throws DaoException {
		ArrayList<ITransferData> propertyList = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(fileName);
			XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileReader);
			int currentState = xmlStreamReader.next();
			while (currentState != XMLStreamReader.END_DOCUMENT) {
				if (currentState == XMLStreamReader.START_ELEMENT) {
					ITransferData propertyData = readNextTransferData(xmlStreamReader);
					propertyList.add(propertyData);
				}
				currentState = xmlStreamReader.next();
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return propertyList;
	}
	
	
	private void startWriteDocument() throws DaoException {
		try {
			fileWriter = new FileWriter(fileName);
			xmlWriter =  xmlOutputFactory.createXMLStreamWriter(fileWriter);
			xmlWriter.writeStartDocument("1.0");
			xmlWriter.writeCharacters("\n");
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	
	private void endWriteDocument() throws DaoException {
		try {
			xmlWriter.writeEndDocument();
			xmlWriter.flush();
			xmlWriter.close();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	
	private void writeXmlElement(ITransferData data) throws DaoException {
		Map<String, Object> dataProperties = data.getMapOfProperties();
		Set<String> propertyNames =  dataProperties.keySet();
		try {	//Write header of transfer data
			xmlWriter.writeStartElement(OUTER_TAG);
			xmlWriter.writeCharacters("\n");
		} catch (Exception  e) {
			throw new DaoException(e);
		}
		for (String property: propertyNames) {
			try {
				xmlWriter.writeCharacters("  ");
				xmlWriter.writeStartElement(property);
				xmlWriter.writeAttribute("value", dataProperties.get(property).toString());
				xmlWriter.writeEndElement();
				xmlWriter.writeCharacters("\n");
			} catch (Exception e) {
				String messString = e.getMessage();
				messString += "a";
			}
		}
		try {	//Write footer of transfer data
			xmlWriter.writeEndElement();
		} catch (Exception  e) {
			throw new DaoException(e);
		}
	}
	
	
	private ITransferData readNextTransferData(XMLStreamReader xmlStreamReader) throws DaoException {
		int currentState = 0;
		ITransferData propertyData = new MapTransferData();
		do {
			try {
				currentState = xmlStreamReader.next();
				switch (currentState) {
				case XMLStreamReader.START_ELEMENT:
					propertyData.addProperty(xmlStreamReader.getAttributeLocalName(0),
							xmlStreamReader.getAttributeValue(0));
					while (currentState != XMLStreamReader.END_ELEMENT) {
						currentState = xmlStreamReader.next();
					}
					currentState = xmlStreamReader.next();
					break;
				}
					
			} catch (Exception e) {
				throw new DaoException(e);
			}
		} while (currentState != XMLStreamReader.END_ELEMENT);
		return propertyData;
	}
	
	
	
	private String fileName;
	private static XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
	private static XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();;
	private FileWriter fileWriter;
	private XMLStreamWriter xmlWriter;
	private final String OUTER_TAG = "TransferDataElement";
}
