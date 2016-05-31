package by.training.news.domains.response;

import by.training.news.controller.CommandName;
import by.training.news.domains.News;

public class ResFindNews implements IResponse {
	private boolean status;
	private String message;
	private News news;

	@Override
	public CommandName getCommandType() {
		return CommandName.FIND_NEWS;
	}

	@Override
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;

	}

	@Override
	public boolean isCommandExecuted() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public boolean isStatus() {
		return status;
	}

}
