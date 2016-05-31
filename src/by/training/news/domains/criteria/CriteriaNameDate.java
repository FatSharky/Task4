package by.training.news.domains.criteria;

public class CriteriaNameDate implements ICriteria {
	private String name;
	private String date;

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.NAME_DATE;
	}

	@Override
	public String[] getParams() {
		String[] s = {this.name,this.date};
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

}
