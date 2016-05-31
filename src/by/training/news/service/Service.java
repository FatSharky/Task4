package by.training.news.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import by.training.news.domains.News;
import by.training.news.domains.criteria.ICriteria;

public class Service implements IService {

	@Override
	public void saveNewNews(String[][] news) throws ServiceExceprion {
		System.out.println("NewsServiceImpl saveNewNews");
		News newses = new News();
		if (news.length == 6) {
			String current = news[0][0];
			Pattern pattern = Pattern.compile("^[a-zA-Z_0-9-]+$");
			Matcher match = pattern.matcher(current);
			if (match.matches()) {
				newses.setNewsName(current);
			} else {
				throw new ServiceExceprion("wrong input data");
			}
			current = news[1][0];
			pattern = Pattern.compile("^[a-zA-Z_0-9-]+$");
			match = pattern.matcher(current);
			if (match.matches()) {
				newses.setAuthors(current);
			} else {
				throw new ServiceExceprion("wrong input data");
			}
			current = news[2][0];
			pattern = Pattern.compile("^[0-9]{4}[-][0-9]{2}[-][0-9]{2}$");
			match = pattern.matcher(current);
			if (match.matches()) {
				newses.setDateOfIssue(current);
			} else {
				throw new ServiceExceprion("wrong input data");
			}
			newses.setNewsBody(news[3][0]);
			String category = n[4][0];
			pattern = Pattern.compile("^[a-zA-Z_0-9-]+$");
			match = pattern.matcher(category);
			if (!match.matches()) {
				throw new ServiceExceprion("wrong input data");
			}
			String subcategory = news[5][0];
			match = pattern.matcher(subcategory);
			if (!m.matches()) {
				throw new ServiceExceprion("wrong input data");
			}
			DAOFactory factory = DAOFactory.getInstance();
			INewsDAO newDAO = factory.getNewsDAO();
			try {
				newDAO.saveNewNews(news, category, subcategory);
			} catch (DAOException e) {
				throw new ServiceException("error occurred while writing new news", e);
			}
		} else {
			throw new ServiceException("wrong input data");
		}

	}

	@Override
	public News findNews(ICriteria criteria) throws ServiceExceprion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalog getCatalog() throws ServiceExceprion {
		// TODO Auto-generated method stub
		return null;
	}

}
