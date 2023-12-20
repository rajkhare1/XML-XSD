package com.rajkhare.xmlparsers.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.rajkhare.xmlparsers.stax.dto.DriversLicense;

public class StaxParserDemo {

	public static void main(String[] args) throws XMLStreamException {

		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader xmlStreamReader = factory
				.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"));

		DriversLicense driversLicense = null;
		String content = null;
		while (xmlStreamReader.hasNext()) {
			int event = xmlStreamReader.next();
			switch (event) {
			case XMLStreamConstants.START_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("DriversLicense")) {
					System.out.println(xmlStreamReader.getAttributeValue(0));
					driversLicense = new DriversLicense();
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				content = xmlStreamReader.getText().trim();
				break;

			case XMLStreamConstants.END_ELEMENT:
				switch (xmlStreamReader.getLocalName()) {
				case "Number":
					driversLicense.setNumber(Long.parseLong(content));
					break;
				case "FirstName":
					driversLicense.setFirstName(content);
					break;
				case "LastName":
					driversLicense.setLastName(content);
					break;
				
				}
			}

		}
		
		System.out.println(driversLicense.getNumber());
		System.out.println(driversLicense.getFirstName());
		System.out.println(driversLicense.getLastName());

	}

}
