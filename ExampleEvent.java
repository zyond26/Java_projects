import java.awt.*; 
class ExampleEvent extends Frame { 
  ExampleEvent(String m) { 
    super("ExampleButton: "+m); 
    setSize(340,280) ; 
    Panel p = new Panel(); 
    p.setLayout(new BorderLayout()); 
    p.add("North", new TextArea()); 
    p.add("West", new Checkbox("Save config")); 
    p.add("East", new Checkbox("Ignore colors")); 
    Panel q = new Panel(); 
    q.add(new MyExitButton("Exit")); // Đây là class chúng ta vừa thiết lập
    p.add("South", q); 
    add(p); 
    setVisible(true); 
  } 
  public static void main(String arg[]) { 
    new ExampleEvent("Event"); 
  } 
} 
