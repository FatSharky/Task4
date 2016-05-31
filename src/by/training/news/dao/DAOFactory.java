package by.training.news.dao;

public class DAOFactory {
	private static final DAOFactory factory = new DAOFactory();
	private INewsDAO newsDAO = new NewsDAOImpl();

	public INewsDAO getNewsDAO() {
		System.out.println("DAOFactory getNewsDAO");
		return newsDAO;
	}

	public static DAOFactory getInstance() {
		return factory;
	}
}
