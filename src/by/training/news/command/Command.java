package by.training.news.command;

import by.training.news.domains.request.IRequest;
import by.training.news.domains.response.IResponse;

public interface Command {
	IResponse execute(IRequest request);

}
