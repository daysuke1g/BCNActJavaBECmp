package m11.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;

public class AppMainJFrameJPanelCenter extends JPanel {
	private JTable jTable1;
    private JScrollPane jScrollPane1 ;
	
	

	/**
	 * Create the panel.
	 */
	public AppMainJFrameJPanelCenter() {
		setBorder(null);
		
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setViewportBorder(null);
		
		jTable1 = new JTable();
		jTable1.setBorder(null);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jScrollPane1.setViewportView(jTable1);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

		
		
		//----------------------------------------------------------------
		initJTable(new String [] { " ", " " } , 
                new Object [][] { { null, null }, { null, null } });    		
	}
	
	
    public void initJTable(String[] pHeaders,Object [][] pData)
    {  jTable1.setModel(new javax.swing.table.DefaultTableModel(pData,pHeaders));     
       
       int dWidth = jTable1.getSize().width;
       jTable1.getColumnModel().getColumn(0).setPreferredWidth((int)(dWidth*0.25));
       jTable1.getColumnModel().getColumn(1).setPreferredWidth((int)(dWidth*0.75));
    
    }
}
