package by.training.news.dao;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import by.training.news.domains.News;

public interface INewsDAO {
	void saveNewNews(News news, String category, String subcategory) throws DAOException;

	Catalog getCatalog() throws DAOException;

}
