package by.training.news.command;

import by.training.news.domains.request.IRequest;
import by.training.news.domains.response.IResponse;

public interface ICommand {
	IResponse execute(IRequest request);

}
