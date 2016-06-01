package by.training.news.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import by.training.news.domains.Blog;

public class NewsMarshaller {

	public void marshal(Blog list, String file) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Blog.class);
		Marshaller m = context.createMarshaller();
		m.marshal(list, new FileOutputStream(file));
	}

}
