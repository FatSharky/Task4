package by.training.news.service;

public class ServiceFactory {
	private static final ServiceFactory factory = new ServiceFactory();
	private IService newsService = new Service();

	public static ServiceFactory getInstance() {
		return factory;
	}
	public IService getNewsService() {
		System.out.println("ServiceFactory getNewsService");
		return newsService;
	}
}

