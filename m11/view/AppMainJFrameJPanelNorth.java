package m11.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class AppMainJFrameJPanelNorth extends JPanel {
    String mHeaderLabel;
    private JTextField jtfHeaderLabel;
    
    
	/**
	 * Create the panel.
	 */
	public AppMainJFrameJPanelNorth() {
		setBorder(null);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		jtfHeaderLabel = new JTextField();
		jtfHeaderLabel.setBorder(null);
		jtfHeaderLabel.setEditable(false);
		jtfHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jtfHeaderLabel.setBackground(UIManager.getColor("Button.background"));
		jtfHeaderLabel.setFont(new Font("Arial", Font.BOLD, 18));
		add(jtfHeaderLabel);
		jtfHeaderLabel.setColumns(10);

		
		
		
		initComponentsMan();
	}

	 private void initComponentsMan()
	 { jtfHeaderLabel.setText(mHeaderLabel);
	        
	 }
	    
	 protected void setLabelText(String pStr)
	 { mHeaderLabel = pStr;
	   jtfHeaderLabel.setText(mHeaderLabel);        
	   jtfHeaderLabel.setColumns(pStr.length());
	 }
	    
	    
	    
	
}
