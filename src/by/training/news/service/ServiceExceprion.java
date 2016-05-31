package by.training.news.service;

public class ServiceExceprion extends Exception{
	public ServiceExceprion(String message){
		super(message);
	}

	public ServiceExceprion(String message, Exception e) {
		super(message, e);
	}
}
