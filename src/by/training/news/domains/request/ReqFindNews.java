package by.training.news.domains.request;

import by.training.news.controller.CommandName;
import by.training.news.domains.criteria.ICriteria;

public class ReqFindNews implements IRequest {
	private ICriteria criteria;
	private String title;

	@Override
	public CommandName getCommadType() {
		return CommandName.FIND_NEWS;
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
		this.setCriteria((ICriteria) param);

	}

	public ICriteria getParams() {
		return criteria;
	}

	public ICriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(ICriteria criteria) {
		this.criteria = criteria;
	}

}
