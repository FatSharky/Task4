package by.training.news.service;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import by.training.news.domains.News;
import by.training.news.domains.criteria.ICriteria;

public interface IService {
	void saveNewNews(String[][] news)throws ServiceExceprion;
	News findNews(ICriteria criteria) throws ServiceExceprion;
	Catalog getCatalog() throws ServiceExceprion;
}
