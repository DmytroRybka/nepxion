package com.nepxion.swing.searcher.ip.local;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textfield.JIPAddressTextField;

public class JIPPanel
	extends JPanel
{
	private JIPAddressTextField textField;
	
	private JIPTable table;
	
	public JIPPanel()
	{
		table = new JIPTable();
		
		setLayout(new BorderLayout());
		add(new ToolBar(), BorderLayout.NORTH);
		add(new JBasicScrollPane(table), BorderLayout.CENTER);
	}
	
	public class ToolBar
		extends JPanel
	{
		public ToolBar()
		{
			setLayout(new ToolBarLayout());
			setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
			
			textField = new JIPAddressTextField();
			DimensionManager.setDimension(textField, new Dimension(180, 23));
			
			JBasicButton searchButton = new JBasicButton(IPController.getSearchAction(JIPPanel.this));
			JBasicButton clearButton = new JBasicButton(IPController.getClearAction(table));
			
			add(new JLabel(SwingLocale.getString("ip")));
			add(textField);
			
			add(searchButton);
			add(clearButton);
			
			add(Box.createHorizontalGlue());
			
			ButtonManager.updateUI(this);
		}
	}
	
	public JIPTable getAddressTable()
	{
		return table;
	}
	
	public String getIP()
	{
		return textField.getText();
	}
	
	public void setIP(String ip)
	{
		textField.setText(ip);
	}
}