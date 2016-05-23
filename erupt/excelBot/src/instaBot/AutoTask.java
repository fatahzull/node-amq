package instaBot;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class AutoTask {
	int    mStatus = 0;
	Robot  mBot;
	String mTask;
	
	public AutoTask(Robot bot) {
		mBot = bot;	
	}	

	public void click() {
		//>
		mBot.mousePress(InputEvent.BUTTON1_MASK);
		mBot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	   public void rclick() {
	        //>
	        mBot.mousePress(InputEvent.BUTTON3_MASK);
	        mBot.mouseRelease(InputEvent.BUTTON3_MASK);
	    }
	public void type(String str) {
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
        paste();
	}
	public void copy() throws UnsupportedFlavorException, IOException, InterruptedException  {		
       mBot.keyPress(KeyEvent.VK_CONTROL);
       mBot.keyPress(KeyEvent.VK_C);
       Thread.sleep(500);
       mBot.keyRelease(KeyEvent.VK_CONTROL);
       mBot.keyRelease(KeyEvent.VK_C);
	    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	    String newStr = (String) clpbrd.getData(DataFlavor.stringFlavor);
	    System.out.println(newStr);
        StringSelection stringSelection = new StringSelection(newStr.replace("\"", "").trim().toUpperCase());
        clpbrd.setContents(stringSelection, stringSelection);
	}
    public void copyStr(String str) {
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }
	public void enter() throws AWTException {
        mBot.keyPress(KeyEvent.VK_ENTER);
        mBot.keyRelease(KeyEvent.VK_ENTER);
	}

	public Color  getColor(String str) {
		System.out.println("Getting color at " + str);
         String[] coor = str.split(",");
	      Color cl = mBot.getPixelColor(Integer.valueOf(coor[0].trim()), 
	                                                       Integer.valueOf(coor[1].trim()));
	      return cl;
	}
	
   public void keyDown() {
       System.out.println("key down");
       mBot.keyPress(KeyEvent.VK_DOWN);
       mBot.keyRelease(KeyEvent.VK_DOWN);
   }
   
   public void selectAll() {
       System.out.println("selectAll");
       mBot.keyPress(KeyEvent.VK_CONTROL);
       mBot.keyPress(KeyEvent.VK_A);
       mBot.keyRelease(KeyEvent.VK_CONTROL);
       mBot.keyRelease(KeyEvent.VK_A);
   }
	   
	public void move(String str) {
		System.out.println("Move " + str);
		String[] coor = str.split(",");
		mBot.mouseMove(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
	}
	
	public void moveAndClick(String str) throws InterruptedException {
		System.out.println("MoveClicking "+ str);
		String[] coor = str.split(",");
		mBot.mouseMove(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
		Thread.sleep(200);
		mBot.mousePress(InputEvent.BUTTON1_MASK);
		mBot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public void paste() {
		System.out.println("Paste");
		mBot.keyPress(KeyEvent.VK_CONTROL);
		mBot.keyPress(KeyEvent.VK_V);
		mBot.keyRelease(KeyEvent.VK_CONTROL);
		mBot.keyRelease(KeyEvent.VK_V);
	}
	
	public void press() {
		//*
		System.out.println("*");
		mBot.mousePress(InputEvent.BUTTON1_MASK);
	}
	
	public void release() {
		//^
		System.out.println("^");
		mBot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	   public void saveAs() throws NumberFormatException, InterruptedException {
	       mBot.keyPress(KeyEvent.VK_SHIFT);
	       mBot.keyPress(KeyEvent.VK_CONTROL);
	       mBot.keyPress(KeyEvent.VK_S);
	       Thread.sleep(500);
	       mBot.keyRelease(KeyEvent.VK_SHIFT);
	       mBot.keyRelease(KeyEvent.VK_CONTROL);
           mBot.keyRelease(KeyEvent.VK_S);
	    }
	public void sleep(String str) throws NumberFormatException, InterruptedException {
		System.out.println("Sleeping " + str + "ms");
		Thread.sleep(Integer.parseInt(str));
	}
    public String  getColorStr(String x, String y) throws AWTException {

        Color cl = mBot.getPixelColor(Integer.valueOf(x), 
                                                         Integer.valueOf(y));
        String color = Integer.toHexString(cl.getRed()) + 
                                Integer.toHexString(cl.getGreen()) +
                                Integer.toHexString(cl.getBlue()) ;
        return color;
     }
}
