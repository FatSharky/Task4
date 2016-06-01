package by.training.news.command;

import by.training.news.domains.request.IRequest;
import by.training.news.domains.response.IResponse;
import by.training.news.domains.response.ResGetBlog;
import by.training.news.service.IService;
import by.training.news.service.ServiceExceprion;
import by.training.news.service.ServiceFactory;

public class GetBlogCommand implements ICommand {

	@Override
	public IResponse execute(IRequest request) {
		System.out.println("GetCatalogCommand execute");
		ResGetBlog response = new ResGetBlog();
		ServiceFactory factory = ServiceFactory.getInstance();
		IService service = factory.getNewsService();
		try {
			response.setStatus(true);
			response.setBlog(service.getBlog());
			response.setMessage("everything is ok with request " + request.getTitle());
		} catch (ServiceExceprion e) {
			response.setStatus(false);
			response.setMessage("something went wrong with request " + request.getTitle());
		}
		return response;
	}

}
