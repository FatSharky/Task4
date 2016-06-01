package by.training.news.dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import by.training.news.domains.Blog;

public class NewsUnMarshaller {
	private Blog newsList;

	public void unmarsh(String filePath) throws JAXBException {
		File file = new File(filePath);
		JAXBContext jaxb = JAXBContext.newInstance(Blog.class);
		Unmarshaller unmarsh = jaxb.createUnmarshaller();
		newsList = (Blog) unmarsh.unmarshal(file);
	}

	public Blog getNewsList() {
		return newsList;
	}

	public void setNewsList(Blog newsList) {
		this.newsList = newsList;
	}

}
