package by.training.news.dao;

import by.training.news.domains.Blog;
import by.training.news.domains.News;

public interface INewsDAO {
	void saveNewNews(News news, String category, String subcategory) throws DAOException;

	Blog getBlog() throws DAOException;

}
