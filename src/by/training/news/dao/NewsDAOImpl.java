package by.training.news.dao;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import by.training.news.domains.Category;
import by.training.news.domains.News;
import by.training.news.domains.SubCategory;

public class NewsDAOImpl implements INewsDAO{

	@Override
	public void saveNewNews(News news, String category, String subcategory) throws DAOException {
		System.out.println("NewsDAOImpl saveNewNews");
		Catalog list = getCatalog();
		Category cat = list.getCategoryByName(category);
		SubCategory subcat= category.getSubcategoryByName(subcat);
		
	}

	@Override
	public Catalog getCatalog() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
