package by.training.news.start;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import by.training.news.controller.Controller;
import by.training.news.domains.request.IRequest;
import by.training.news.domains.response.IResponse;
import by.training.news.view.View;

public class Show {
	public static void main(String[] args) throws JAXBException, IOException { 
		 		Controller controller = new Controller(); 
		 		View view = new View(); 
		 
		 
	 		IRequest request = view.start(); 
		 		System.out.println("Main"); 
		 		IResponse response = controller.doAction(request); 
		 		view.printAnswer(response); 
		 	} 


}
