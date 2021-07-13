package m11.view;

public class AppGui00 
{
  public static void main (String[] args)
  { AppGui00 oAppTestGui00 = new AppGui00();
    oAppTestGui00.runApp();
  }

  public void runApp() 
  { AppMainJFrame oAppMainJFrame = new AppMainJFrame();
    java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					oAppMainJFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});    
  }     
  


}
