import java.awt.*;

public class MyExitButton extends Button{
  MyExitButton(String label) { 
    super(label); 
  } 
  public boolean action(@SuppressWarnings("deprecation") Event e, Object  what) { 
      System.out.println("event: " + e);
      System.out.println("What: " + what);
    System.exit(0); 
    return true; 
  } 
}
