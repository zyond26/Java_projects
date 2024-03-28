import java.awt.*; 

public class Example extends Frame {
  TextArea txt; 
  public static void main(String arg[]) { 
    new Example("Event Handling"); 
  } 

  Example(String m) { 
    super("Example: "+m); 
    setSize(340,280) ; 
    Panel p = new Panel(); 
    p.setLayout(new BorderLayout()); 
    p.add("North", txt = new TextArea()); 
    p.add("West", new Checkbox("Save config")); 
    p.add("East", new Checkbox("Ignore colors"));
    

    Panel subPanel = new Panel();
    subPanel.setLayout(new GridLayout(4, 4));
    
    for(int i=0;i<10;i++){
        subPanel.add("South", new Button("" + i));
    }
    
    subPanel.add(new Button("Clear")); 
    subPanel.add("South", new Button("+"));
    subPanel.add("South", new Button("-"));
    subPanel.add("South", new Button("*"));
    subPanel.add("South", new Button("/"));
    subPanel.add("South", new Button("="));
    p.add("South", subPanel); 
    add(p); 
    setVisible(true); 
  } 
  @SuppressWarnings("deprecation")
  public boolean action(Event e, Object target) { 
      System.out.println("This is the actions");
    if (e.target instanceof Button) { 
      txt.setText(""); 
      return true; 
    } else if (e.target instanceof Checkbox) { 
      Checkbox x = (Checkbox) e.target; 
      txt.appendText(x.getLabel()+ 
                     (x.getState() ? " is on\n" : " is off\n")); 
      return true; 
    } 
    return(super.action(e, target)); 
  } 
  @SuppressWarnings("deprecation")
public boolean handleEvent(Event evt) { 
    if (evt.id == Event.WINDOW_DESTROY) 
      System.exit(0) ; 
    return(super.handleEvent(evt)); 
  } 
}
