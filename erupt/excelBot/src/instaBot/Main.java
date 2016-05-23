package instaBot;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.TableRowSorter;
public class Main {
	public static void main(String[] args) {
		Map<String, String> action = new HashMap<String, String>();
		action.put("!", "sleep");
		action.put("mv", "move");
		action.put("mc", "moveAndClick");
		action.put("#", "getColor");
		action.put(">", "click");
        action.put("<", "rclick");
		action.put("*", "press");
		action.put("^", "release");
		action.put("copy", "copy");
        action.put("copyStr", "copyStr");
		action.put("paste", "paste");
		action.put("down", "keyDown");
        action.put("enter", "enter");
        action.put("saveAs", "saveAs");
        action.put("selectAll", "selectAll");
        action.put("<>", "runCode");
        action.put("type", "type");
        
        String cfgFile  = args[0];
        String email = args[1];
        String name = args[2];
        String username = args[3];
		try {
			Robot bot = new Robot();
			AutoTask task = new AutoTask(bot);
			Class<?> cls = task.getClass();

                ArrayList<String> command ;
		        command = new ConfigFile().readFile(cfgFile);
    			for (int i=0 ; i<command.size(); i++) {
    					String line = command.get(i);
    					String[] macro = line.split("-");
    					if (macro[0].equals("<>")) {
    	                       String methodName = macro[1];
    	                        switch (methodName)
    	                        {
    	                        case "checkColor" :
    	                            String[] prop = macro[2].split(",");
    	                            while(!task.getColorStr(prop[0], prop[1]).equals(prop[2])) {
    	                                Thread.sleep(1000);
    	                            }
    	                            continue;
                                case "checkColorConfirm" :
                                    String[] props = macro[2].split(",");
                                    System.out.println(task.getColorStr(props[0],props[1]));
                                    if (!task.getColorStr(props[0], props[1]).equals(props[2])){
                                        Thread.sleep(2000);
                                        System.out.println("color xde!");
                                        System.exit(0);
                                    }
                                    else
                                        continue;
    	                        case "pasteEmail" :
    	                            task.copyStr(email);
    	                            task.paste();
    	                            continue;

                                case "pasteName" :
                                    task.copyStr(name);
                                    task.paste();
                                    continue;

                                case "pasteUserName" :
                                    task.copyStr(username);
                                    task.paste();
                                    continue;
    	                        }
    	                        continue;
                        }
    					if (macro[0].equals("#")) {
    					    //check if user exist
    					    Color cl = task.getColor(macro[1]);
    					    System.out.println("RED " + cl.getRed());
    					    if (cl.getRed()> 244) {
    					        /* Contact don't have Whatsapp, break command operation, 
    					        proceed with other contacts*/
    					        task.moveAndClick("34,184");
    					        break;
    					    } else {
    					        /* Found contact, proceed command*/
    					        continue;
    					    }
    					}else {
        					if (line.split("-").length > 1) {
        						Method mtd = cls.getMethod(action.get(macro[0]), String.class);
        						mtd.invoke(task, macro[1]);
        					} else {
        						Method mtd = cls.getMethod(action.get(macro[0]));
        						mtd.invoke(task);
        					}
    					}
    				}		    
			System.out.println("sendAck");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
