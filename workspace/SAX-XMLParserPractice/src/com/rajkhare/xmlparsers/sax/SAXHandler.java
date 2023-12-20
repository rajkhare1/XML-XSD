package com.rajkhare.xmlparsers.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.rajkhare.xmlparsers.sax.dto.DriversLicense;

public class SAXHandler extends DefaultHandler{

	private DriversLicense driversLicense;
	private String content;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equals("DriversLicense"))
			setDriversLicense(new DriversLicense());
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (qName) {
		case "Number":
			getDriversLicense().setNumber(Long.parseLong(content));
			break;
		case "FirstName":
			getDriversLicense().setFirstName(content);
		case "LastName":
			getDriversLicense().setLastName(content);
		default:
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		content = String.copyValueOf(ch, start, length).trim();
	}

	public DriversLicense getDriversLicense() {
		return driversLicense;
	}

	public void setDriversLicense(DriversLicense driversLicense) {
		this.driversLicense = driversLicense;
	}
	
	


}
