package by.training.news.domains.response;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import by.training.news.controller.CommandName;

public class ResGetCatalog implements IResponse {
	private boolean status;
	private String message;
	private Catalog catalog;

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

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public boolean isStatus() {
		return status;
	}

}
