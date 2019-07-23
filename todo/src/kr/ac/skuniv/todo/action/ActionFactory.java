package kr.ac.skuniv.todo.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;


public class ActionFactory {
	private static ActionFactory actionFactory;
	HashMap<String, Action> actionMap;
	Properties prop;
	
	private ActionFactory() {
		InputStream in = null;
		prop = null;
		try {
			actionMap = new HashMap<>();
			in = this.getClass().getResourceAsStream("/todoURL.properties");
			prop = new Properties();
			prop.load(in);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ActionFactory getInstance() {
		if(actionFactory==null) {
			actionFactory = new ActionFactory();
		}
		return actionFactory;
	}
	
	public Action getAction(String path) {
		Action action = actionMap.get(path);
		if( action == null ) {
			String className = prop.getProperty(path).trim();
			try {
				Class<?> c = Class.forName(className);
				Object obj = c.newInstance();
				if (obj instanceof Action) {
					action = (Action) obj;
					actionMap.put(path, action);
				} else {
					throw new ClassCastException();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return action;
	}
	
	public static void main(String[] args) {
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.getAction("/todoview.sku");
		if (action != null) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}
	
}
