package by.training.news.domains.request;

import by.training.news.controller.CommandName;

public class ReqGetBlog implements IRequest {
	private String title;

	@Override
	public CommandName getCommadType() {
		return CommandName.GET_CATALOG;
	}

	@Override
	public void setTitle(String string) {
		this.title = string;

	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setParams(Object param) {
		System.out.println("RequestGetCatalog setParams");
		return;

	}

}
