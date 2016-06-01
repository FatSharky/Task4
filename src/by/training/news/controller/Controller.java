package by.training.news.controller;

import by.training.news.command.ICommand;
import by.training.news.domains.request.IRequest;
import by.training.news.domains.response.IResponse;

public class Controller {
	CommandHelper helper = new CommandHelper();

	public IResponse doAction(IRequest request) {
		System.out.println("Controller doAction");
		ICommand command = helper.getCommand(request.getCommadType().name());
		IResponse response = command.execute(request);
		return response;
	}
}
