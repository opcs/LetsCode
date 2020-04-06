package com.op.validator.data;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlReader implements Reader{
 public static final String path=	"C:\\Users\\opcs\\git\\LetsCode\\src\\com\\op\\data\\resources\\records.xml";
 private static XmlReader reader = new XmlReader();


	private static Records readTxnRecordsFromXml(String path) throws JAXBException {
		File file = new File(path);
		JAXBContext jaxbContext = JAXBContext.newInstance(Records.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Records records = (Records) jaxbUnmarshaller.unmarshal(file);
		return records;
	}

	@Override
	public Records readTxnDetails(String path) {
		try {
			return readTxnRecordsFromXml(path);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Reader getReader() {
		return reader;
	}

}
