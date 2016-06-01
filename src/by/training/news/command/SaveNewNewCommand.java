package by.training.news.command;

import by.training.news.domains.request.IRequest;
import by.training.news.domains.request.ReqSaveNewNews;
import by.training.news.domains.response.IResponse;
import by.training.news.domains.response.ResSaveNewNews;
import by.training.news.service.IService;
import by.training.news.service.ServiceExceprion;
import by.training.news.service.ServiceFactory;

public class SaveNewNewCommand implements ICommand {

	@Override
	public IResponse execute(IRequest request) {

		System.out.println("SaveNewNewsCommand execute");
		ReqSaveNewNews req = (ReqSaveNewNews) request;
		IResponse response = new ResSaveNewNews();
		if (req.isStatus()) {
			ServiceFactory factory = ServiceFactory.getInstance();
			IService service = factory.getNewsService();
			try {
				service.saveNewNews(req.getParams());
				response.setStatus(true);
				response.setMessage("everything is ok with " + request.getTitle());
			} catch (ServiceExceprion e) {
				// logging
				response.setStatus(false);
				response.setMessage("something went wrong with " + request.getTitle());
				System.out.println("Error");
			}
		} else {
			response.setStatus(false);
			response.setMessage("something went wrong with " + request.getTitle());
		}
		return response;
	}

}
