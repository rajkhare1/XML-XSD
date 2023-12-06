package com.rajkhare.xmlparsers.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.rajkhare.xmlparsers.dom.dto.Address;
import com.rajkhare.xmlparsers.dom.dto.DriversLicense;

public class DomParserDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"));

		DriversLicense driverLicense = new DriversLicense();
		
		NodeList numberList = document.getElementsByTagName("Number");
		Node numberItem = numberList.item(0);
		driverLicense.setNumber(Long.parseLong(numberItem.getTextContent()));
		
		NodeList firstNameList = document.getElementsByTagName("FirstName");
		Node firstNameItem = firstNameList.item(0);
		driverLicense.setFirstName(firstNameItem.getTextContent());
		
		NodeList lastNameList = document.getElementsByTagName("LastName");
		Node lastNameItem = lastNameList.item(0);
		driverLicense.setLastName(lastNameItem.getTextContent());
		
		Element documentElement = document.getDocumentElement();
		driverLicense.setStatus(documentElement.getAttribute("status"));
		
		NodeList addressList = document.getElementsByTagName("Address");
		Node addressItem = addressList.item(0);
		NodeList addressChildList = addressItem.getChildNodes();
		
		Address address =  new Address();
		
		for(int i=0; i<addressChildList.getLength(); i++) {
			Node item = addressChildList.item(i);
			
			if(item instanceof Element) {
				
				switch(item.getNodeName()) {
				case "street":
					address.setStreet(item.getTextContent());
					break;
				case "city":
					address.setCity(item.getTextContent());
					break;
				case "state":
					address.setState(item.getTextContent());
					break;
				case "country":
					address.setCountry(item.getTextContent());
					break;
				case "zipcode":
					address.setZipcode(item.getTextContent());
					break;
				}
				
			}
			
		}
		
		driverLicense.setAddress(address);
		
	}

}
