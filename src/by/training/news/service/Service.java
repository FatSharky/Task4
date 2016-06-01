package by.training.news.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import by.training.news.dao.DAOException;
import by.training.news.dao.DAOFactory;
import by.training.news.dao.INewsDAO;
import by.training.news.domains.Blog;
import by.training.news.domains.Category;
import by.training.news.domains.News;
import by.training.news.domains.SubCategory;
import by.training.news.domains.criteria.CriteriaAuthorDate;
import by.training.news.domains.criteria.CriteriaNameAuthor;
import by.training.news.domains.criteria.CriteriaNameDate;
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
			String category = news[4][0];
			pattern = Pattern.compile("^[a-zA-Z_0-9-]+$");
			match = pattern.matcher(category);
			if (!match.matches()) {
				throw new ServiceExceprion("wrong input data");
			}
			String subcategory = news[5][0];
			match = pattern.matcher(subcategory);
			if (!match.matches()) {
				throw new ServiceExceprion("wrong input data");
			}
			DAOFactory factory = DAOFactory.getInstance();
			INewsDAO newDAO = factory.getNewsDAO();
			try {
				newDAO.saveNewNews(newses, category, subcategory);
			} catch (DAOException e) {
				throw new ServiceExceprion("error occurred while writing new news", e);
			}
		} else {
			throw new ServiceExceprion("wrong input data");
		}

	}

	@Override
	public News findNews(ICriteria criteria) throws ServiceExceprion {
		System.out.println("NewsServiceImpl findNews");
		List<News> allNews = new ArrayList<News>();
		List<Category> allCategories = getBlog().getCategories();
		int len = allCategories.size();
		for (int i = 0; i < len; i++) {
			List<SubCategory> allSubcategories = allCategories.get(i).getSubCategori();
			int len2 = allSubcategories.size();
			for (int j = 0; j < len2; j++) {
				allNews.addAll(allSubcategories.get(j).getNews());
			}
		}
		switch (criteria.getCriteriaType()) {
		case AUTHOR_DATE: {
			CriteriaAuthorDate cr = (CriteriaAuthorDate) criteria;
			String[] s = cr.getParams();
			for (News n : allNews) {
				if (s[0].equals(n.getAuthors())) {
					if (s[1].equals(n.getDateOfIssue())) {
						return n;
					}
				}
			}
		}
			break;
		case NAME_DATE: {
			CriteriaNameDate cr = (CriteriaNameDate) criteria;
			String[] s = cr.getParams();
			for (News n : allNews) {
				if (s[0].equals(n.getNewsName())) {
					if (s[1].equals(n.getDateOfIssue())) {
						return n;
					}
				}
			}
		}
			break;
		case NAME_AUTHOR: {
			CriteriaNameAuthor cr = (CriteriaNameAuthor) criteria;
			String[] s = cr.getParams();
			for (News n : allNews) {
				if (s[0].equals(n.getNewsName())) {
					if (s[2].equals(n.getAuthors())) {
						return n;
					}
				}
			}
		}
			break;
		}
		return null;

	}

	@Override
	public Blog getBlog() throws ServiceExceprion {
		System.out.println("NewsServiceImpl getCatalog");
		DAOFactory factory = DAOFactory.getInstance();
		INewsDAO newDAO = factory.getNewsDAO();
		try {
			return newDAO.getBlog();
		} catch (DAOException e) {
			throw new ServiceExceprion("error occurred while reading file", e);
		}
	}

}
