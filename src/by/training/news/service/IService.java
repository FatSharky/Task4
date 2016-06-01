package by.training.news.service;

import by.training.news.domains.Blog;
import by.training.news.domains.News;
import by.training.news.domains.criteria.ICriteria;

public interface IService {
	void saveNewNews(String[][] news) throws ServiceExceprion;

	News findNews(ICriteria criteria) throws ServiceExceprion;

	Blog getBlog() throws ServiceExceprion;
}
