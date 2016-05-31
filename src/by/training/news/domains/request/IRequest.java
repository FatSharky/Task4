package by.training.news.domains.request;

import by.training.news.controller.CommandName;

public interface IRequest {

	CommandName getCommadType();

	void setTitle(String string);

	String getTitle();

	void setParams(Object param);

}
