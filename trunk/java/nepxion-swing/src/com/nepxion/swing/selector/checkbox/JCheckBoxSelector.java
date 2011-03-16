package com.nepxion.swing.selector.checkbox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonFocusListener;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.locale.SwingLocale;

public class JCheckBoxSelector
	extends JBasicDialog
{
	private JCheckBoxPanel checkBoxPanel;
	
	private List allElementNodes;
	
	private boolean isConfirmed;
	
	public JCheckBoxSelector(Frame owner, String title)
	{
		this(owner, title, new Dimension(350, 320));
	}
	
	public JCheckBoxSelector(Dialog owner, String title)
	{
		this(owner, title, new Dimension(350, 320));
	}
	
	public JCheckBoxSelector(Frame owner, String title, Dimension dimension)
	{
		this(owner, title, dimension, null);
	}
	
	public JCheckBoxSelector(Dialog owner, String title, Dimension dimension)
	{
		this(owner, title, dimension, null);
	}
	
	public JCheckBoxSelector(Frame owner, String title, List allElementNodes)
	{
		this(owner, title, new Dimension(350, 320), allElementNodes);
	}
	
	public JCheckBoxSelector(Dialog owner, String title, List allElementNodes)
	{
		this(owner, title, new Dimension(350, 320), allElementNodes);
	}
	
	public JCheckBoxSelector(Frame owner, String title, Dimension dimension, List allElementNodes)
	{
		super(owner, title, dimension, true, false, true);
		
		this.allElementNodes = allElementNodes;
		
		initComponents();
	}
	
	public JCheckBoxSelector(Dialog owner, String title, Dimension dimension, List allElementNodes)
	{
		super(owner, title, dimension, true, false, true);
		
		this.allElementNodes = allElementNodes;
		
		initComponents();
	}
	
	private void initComponents()
	{
		checkBoxPanel = new JCheckBoxPanel(allElementNodes);
		
		JClassicButton selectAllButton = new JClassicButton(SwingLocale.getString("select_all"), IconFactory.getSwingIcon("stereo/redo_16.png"), SwingLocale.getString("select_all"));
		selectAllButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				checkBoxPanel.adaptListFacade(JCheckBoxPanel.SELECT_ALL);
			}
		}
		);
		
		JClassicButton selectReverseButton = new JClassicButton(SwingLocale.getString("select_reverse"), IconFactory.getSwingIcon("stereo/undo_16.png"), SwingLocale.getString("select_reverse"));
		selectReverseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				checkBoxPanel.adaptListFacade(JCheckBoxPanel.SELECT_REVERSE);
			}
		}
		);
		
		final JClassicButton confirmButton = new JClassicButton(SwingLocale.getString("yes"), IconFactory.getSwingIcon("stereo/confirm_16.png"), SwingLocale.getString("yes"));
		ActionListener confirmActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				isConfirmed = true;
			}
		};
		confirmButton.addFocusListener(new ButtonFocusListener(this));
		confirmButton.addActionListener(confirmActionListener);
		KeyStrokeManager.registerButtonToEnterKey(confirmButton, confirmActionListener);
		
		final JClassicButton cancelButton = new JClassicButton(SwingLocale.getString("no"), IconFactory.getSwingIcon("stereo/cancel_16.png"), SwingLocale.getString("no"));
		ActionListener cancelActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				isConfirmed = false;
			}
		};
		cancelButton.addFocusListener(new ButtonFocusListener(this));
		cancelButton.addActionListener(cancelActionListener);
		KeyStrokeManager.registerButtonToEscapeKey(cancelButton, cancelActionListener);
		
		double[][] size = 
		{
			{TableLayout.PREFERRED, 5, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, 5, TableLayout.PREFERRED}, 
			{TableLayout.FILL, 5, 30}
		};
		JPanel panel = new JPanel();
		panel.setLayout(new TableLayout(size));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(checkBoxPanel, "0, 0, 6, 0");
		panel.add(selectAllButton, "0, 2");
		panel.add(selectReverseButton, "2, 2");
		panel.add(confirmButton, "4, 2");
		panel.add(cancelButton, "6, 2");
		
		Container container = getContentPane();
		container.add(panel);
	}
	
	public JCheckBoxPanel getCheckBoxPanel()
	{
		return checkBoxPanel;
	}
	
	public JList getCheckBoxList()
	{
		return checkBoxPanel.getList();
	}
	
	public List getSelections()
	{
		return checkBoxPanel.getSelections();
	}
	
	public List getSelectedUserObjects()
	{
		return checkBoxPanel.getSelectedUserObjects();
	}
	
	public boolean isConfirmed()
	{
		return isConfirmed;
	}
}