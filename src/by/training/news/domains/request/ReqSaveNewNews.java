package by.training.news.domains.request;

import by.training.news.controller.CommandName;

public class ReqSaveNewNews implements IRequest {
	private String categoryName;
	private String subcategoryName;
	private String title;
	private String name;
	private String author;
	private String dateOfIssue;
	private String body;
	private boolean status;

	@Override
	public CommandName getCommadType() {
		return CommandName.SAVE_NEW_NEWS;
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
		String[][] news = (String[][]) param;
		if (news.length == 6) {
			this.name = news[0][0];
			this.author = news[1][0];
			this.dateOfIssue = news[2][0];
			this.body = news[3][0];
			this.subcategoryName = news[4][0];
			this.categoryName = news[5][0];
			this.status = true;
		} else {
			status = false;
		}
	}

	public String[][] getParams() {
		String[][] s = { { name }, { author }, { dateOfIssue }, { body }, { subcategoryName }, { categoryName } };
		return s;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
