package by.training.news.domains.response;

import by.training.news.controller.CommandName;

public class ResSaveNewNews implements IResponse {
	private boolean status;
	private String message;

	@Override
	public CommandName getCommandType() {
		return CommandName.SAVE_NEW_NEWS;

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

}
