package by.bsuir.lab2.console;

import javax.xml.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import java.awt.Dialog;
import java.io.*;

public class ConsoleOutput {

	public static void main(String[] args) {
		try {
			FileWriter fileWriter = new FileWriter("test.txt");
			XMLStreamWriter xmlWriter =  XMLOutputFactory.newFactory().createXMLStreamWriter(fileWriter);
			xmlWriter.writeStartDocument("1.2");
			xmlWriter.writeCharacters("\n");
			xmlWriter.writeStartElement("ha");
			xmlWriter.writeAttribute("s", "value");
			xmlWriter.writeEndElement();
			xmlWriter.writeEndDocument();
			//fileWriter.append('f');
			xmlWriter.flush();
			xmlWriter.close();
			
		} catch (Exception e) {
			
		}
		
	}
}
