package by.training.news.command;

import by.training.news.domains.request.IRequest;
import by.training.news.domains.request.ReqFindNews;
import by.training.news.domains.response.IResponse;
import by.training.news.domains.response.ResFindNews;
import by.training.news.service.IService;
import by.training.news.service.ServiceExceprion;
import by.training.news.service.ServiceFactory;

public class FindNewCommand implements ICommand{

	@Override
	public IResponse execute(IRequest request) {
		System.out.println("FindNewsComman exucete");
		System.out.println("FindNewsCommand execute"); 
		 		ReqFindNews req = (ReqFindNews) request; 
		 		ResFindNews response = new ResFindNews(); 
		 		ServiceFactory factory = ServiceFactory.getInstance(); 
		 		IService service = factory.getNewsService(); 
		 		try{ 
		 			response.setNews(service.findNews(req.getParams())); 
	 			response.setStatus(true); 
		 			response.setMessage("everything is ok with request "+req.getTitle()); 
		 		}catch(ServiceExceprion e){ 
		 			response.setStatus(false); 
		 			response.setMessage("something went wrong with request "+req.getTitle()); 
		 		} 
		 		return response; 
		 	} 

}
