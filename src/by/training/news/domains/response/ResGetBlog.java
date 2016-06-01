package by.training.news.domains.response;


import by.training.news.controller.CommandName;
import by.training.news.domains.Blog;

public class ResGetBlog implements IResponse {
	private boolean status;
	private String message;
	private Blog blog;

	@Override
	public CommandName getCommandType() {
		return CommandName.GET_CATALOG;
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

	public boolean isStatus() {
		return status;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
