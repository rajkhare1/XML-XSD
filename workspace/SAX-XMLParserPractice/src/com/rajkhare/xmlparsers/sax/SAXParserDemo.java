package com.rajkhare.xmlparsers.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXParserDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		
		SAXHandler saxHandler = new SAXHandler();
		saxParser.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"), saxHandler);
		
		System.out.println(saxHandler.getDriversLicense().getFirstName());
		System.out.println(saxHandler.getDriversLicense().getLastName());
		System.out.println(saxHandler.getDriversLicense().getNumber());
		
	}

}
