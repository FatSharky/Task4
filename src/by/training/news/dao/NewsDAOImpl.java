package by.training.news.dao;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import by.training.news.domains.Blog;
import by.training.news.domains.Category;
import by.training.news.domains.News;
import by.training.news.domains.SubCategory;

public class NewsDAOImpl implements INewsDAO {

	@Override
	public void saveNewNews(News news, String category, String subcategory) throws DAOException {
		System.out.println("NewsDAOImpl saveNewNews");
		Blog list = getBlog();
		Category cat = list.getCategoryByName(category);
		SubCategory subcat = cat.getSubcategoryByName(subcategory);
		subcat.addNews(news);
		cat.addSubcategory(subcat);
		list.addCategory(cat);
		NewsMarshaller m = new NewsMarshaller();
		try {
			try {
				m.marshal(list, "src/by/training/news/source/news.xml");
			} catch (FileNotFoundException e) {
				throw new DAOException("file not found", e);
			}
		} catch (JAXBException e) {
			throw new DAOException("error occurred while writing new news", e);
		}

	}

	@Override
	public Blog getBlog() throws DAOException {
		System.out.println("NewsDAOImpl getBlog");
		NewsUnMarshaller unm = new NewsUnMarshaller();
		try {
			unm.unmarsh("src/main/resources/News.xml");
		} catch (JAXBException e) {
			throw new DAOException("file not found", e);
		}
		Blog newsList = unm.getNewsList();
		return newsList;

	}

}
