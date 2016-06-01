package by.training.news.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import by.training.news.controller.CommandName;
import by.training.news.domains.criteria.CriteriaAuthorDate;
import by.training.news.domains.criteria.CriteriaNameAuthor;
import by.training.news.domains.criteria.CriteriaNameDate;
import by.training.news.domains.request.IRequest;
import by.training.news.domains.request.ReqFindNews;
import by.training.news.domains.request.ReqGetBlog;
import by.training.news.domains.request.ReqSaveNewNews;
import by.training.news.domains.response.IResponse;
import by.training.news.domains.response.ResFindNews;
import by.training.news.domains.response.ResGetBlog;
import by.training.news.domains.response.ResSaveNewNews;

public class View {
	public IRequest start() throws NumberFormatException, IOException {
		IRequest req = null;
		System.out.println("Select an action:\n1-show catalog\n2-find news\n3-add new news");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		switch (Integer.parseInt(in.readLine())) {
		case 1: {
			req = doUserAction(CommandName.GET_CATALOG, null);
		}
			break;
		case 2: {
			System.out.println(
					"Select search criterion:\n1-news name and date of issue;\n2-author and date of issue\n3-news name and author;");
			switch (Integer.parseInt(in.readLine())) {
			case 1: {
				System.out.println("Enter news name");
				String name = in.readLine();
				System.out.println("Enter date of issue");
				String date = in.readLine();
				CriteriaNameDate cr = new CriteriaNameDate();
				cr.setDate(date);
				cr.setName(name);
				req = doUserAction(CommandName.FIND_NEWS, cr);
			}
				break;
			case 2: {
				System.out.println("Enter author");
				String author = in.readLine();
				System.out.println("Enter date of issue");
				String date = in.readLine();
				CriteriaAuthorDate cr = new CriteriaAuthorDate();
				cr.setDate(date);
				cr.setAuthor(author);
				req = doUserAction(CommandName.FIND_NEWS, cr);
			}
				break;
			case 3: {
				System.out.println("Enter news name");
				String name = in.readLine();
				System.out.println("Enter author");
				String author = in.readLine();
				CriteriaNameAuthor cr = new CriteriaNameAuthor();
				cr.setName(name);
				cr.setAuthor(author);
				req = doUserAction(CommandName.FIND_NEWS, cr);
			}
				break;
			}
		}
			break;
		case 3: {
			System.out.println("Enter news name");
			String name = (in.readLine());
			System.out.println("Enter authors (seperator - ;)");
			String providers = (in.readLine());
			System.out.println("Enter data of issue");
			String dateOfIssue = (in.readLine());
			System.out.println("Enter news body");
			String body = (in.readLine());
			System.out.println("Enter news category name");
			String categoryN = in.readLine();
			System.out.println("Enter news subcategory name");
			String subcategoryN = in.readLine();
			List<String> authors = new ArrayList<String>();
			int begin = providers.indexOf(';');
			while (begin > 0) {
				authors.add(providers.substring(0, begin).trim());
				providers = providers.substring(begin + 1);
				begin = providers.indexOf(';');
			}
			String[] str = new String[authors.size()];
			str = authors.toArray(str);
			String[][] s = { { name }, str, { dateOfIssue }, { body }, { subcategoryN }, { categoryN } };
			req = doUserAction(CommandName.SAVE_NEW_NEWS, s);
		}
			break;
		}

		return req;
	}

	public IRequest doUserAction(CommandName c, Object params) {
		System.out.println("View doUserAction");
		IRequest request = null;
		switch (c) {
		case SAVE_NEW_NEWS: {
			request = new ReqSaveNewNews();
			request.setParams(params);
			request.setTitle("save new news");
		}
			break;
		case FIND_NEWS: {
			request = new ReqFindNews();
			request.setParams(params);
			request.setTitle("find news");
		}
			break;
		case GET_CATALOG: {
			request = new ReqGetBlog();
			request.setParams(params);
			request.setTitle("get Blog");
		}
			break;
		}
		return request;
	}

	public void printAnswer(IResponse response) {
		System.out.println("View printAnswer");
		switch (response.getCommandType()) {
		case SAVE_NEW_NEWS: {
			ResSaveNewNews resp = (ResSaveNewNews) response;
			System.out.println(resp.getMessage());
		}
			break;
		case FIND_NEWS: {
			ResFindNews resp = (ResFindNews) response;
			System.out.println(resp.getMessage());
			System.out.println(resp.getNews().toString());
		}
			break;
		case GET_CATALOG: {
			ResGetBlog resp = (ResGetBlog) response;
			System.out.println(resp.getMessage());
			System.out.println(resp.getBlog().toString());
		}
			break;
		}
	}

}
