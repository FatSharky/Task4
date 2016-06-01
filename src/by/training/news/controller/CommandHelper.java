package by.training.news.controller;

import java.util.HashMap;
import java.util.Map;

import by.training.news.command.FindNewCommand;
import by.training.news.command.GetBlogCommand;
import by.training.news.command.ICommand;
import by.training.news.command.SaveNewNewCommand;

public class CommandHelper {
	private Map<CommandName, ICommand> commands = new HashMap<CommandName, ICommand>(); 
	
	 
	 	CommandHelper() { 
	 		commands.put(CommandName.SAVE_NEW_NEWS, new SaveNewNewCommand()); 
	 		commands.put(CommandName.FIND_NEWS, new FindNewCommand()); 
	 		commands.put(CommandName.GET_CATALOG, new GetBlogCommand()); 
	 	} 
	 
	 
	 	public ICommand getCommand(String name) { 
	 		System.out.println("CommandHelper getCommand"); 
			CommandName commandName = CommandName.valueOf(name); 
			ICommand command = commands.get(commandName); 
	 
	 
	 		return command; 
	 
	 
	 	} 


}
