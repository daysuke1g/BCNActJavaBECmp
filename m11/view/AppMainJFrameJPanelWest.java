package m11.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;

public class AppMainJFrameJPanelWest extends JPanel {
	AppMainJFrame     mAppMainJFrame;
    String[] mMenuOperaciones = null;
    
    JTree jTreeMenu;
    JScrollPane jScrollPane1 ;
	/**
	 * Create the panel.
	 */
	public AppMainJFrameJPanelWest() 
	{
		setBorder(null);
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//jScrollPane1.setViewportView(jTreeMenu);
		
		jScrollPane1.setViewportBorder(null);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		jTreeMenu = new JTree();
		jTreeMenu.setBorder(null);
		jScrollPane1.setColumnHeaderView(jTreeMenu);
		setLayout(groupLayout);

		
		
		//----------------------------
		
	}

	public void setJFrameParent(AppMainJFrame pParent) { mAppMainJFrame = pParent; }
	
	public void setMenu(String[] menuOperaciones) { mMenuOperaciones = menuOperaciones; }
	
    public void postInit() 
    { initComponentsMan();
    } 
    
    
    private void initComponentsMan()
    {
      DefaultTreeModel dtm = (DefaultTreeModel) jTreeMenu.getModel();
      DefaultMutableTreeNode dmtRoot = (DefaultMutableTreeNode) dtm.getRoot();
      dmtRoot.removeAllChildren();
      dmtRoot.setUserObject(mMenuOperaciones[0]);
      for(int dIdx=1;dIdx<mMenuOperaciones.length;dIdx++)  
      { // dtm.insertNodeInto(new DefaultMutableTreeNode(szOp), dmtRoot, dmtRoot.getChildCount());
        dmtRoot.add(new DefaultMutableTreeNode(mMenuOperaciones[dIdx]));
      }
      dtm.reload(dmtRoot);      
      
      
      jTreeMenu.addMouseListener(new MouseAdapter() 
      { @Override
        public void mouseClicked(MouseEvent me) 
        { processClickOnJTree(me);
        }
      });
    }
    
    private void processClickOnJTree(MouseEvent me)
    { String opcion = "";
            
      TreePath tp = jTreeMenu.getPathForLocation(me.getX(), me.getY());
      if (tp != null) opcion = tp.toString();
      if((opcion!=null)&&(me.getClickCount()==2))
      { mAppMainJFrame.procesaOperacion(opcion);
      }
    }
}
