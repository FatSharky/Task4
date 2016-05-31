package by.training.news.domains.response;

import by.training.news.controller.CommandName;

public interface IResponse {

	CommandName getCommandType();

	void setStatus(boolean status);

	void setMessage(String message);

	boolean isCommandExecuted();

	String getMessage();

}
