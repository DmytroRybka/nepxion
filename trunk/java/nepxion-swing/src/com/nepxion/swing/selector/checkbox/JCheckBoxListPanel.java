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

import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.ListModel;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.renderer.list.ListCheckBoxCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class JCheckBoxListPanel
	extends JBasicScrollPane
{
	public static final byte SELECT_ALL = 0;
	public static final byte SELECT_NONE = 1;
	public static final byte SELECT_REVERSE = 2;
	
	private JList selectionList;
	
	private List selectedElementNodes;
	private List selectedUserObjects;
	
	public JCheckBoxListPanel()
	{
		this(null);
	}
	
	public JCheckBoxListPanel(List allElementNodes)
	{
		if (allElementNodes == null)
		{
			selectionList = new JList();
		}
		else
		{
			selectionList = new JList(CollectionUtil.parseVector(allElementNodes));
		}
		selectionList.setCellRenderer(new ListCheckBoxCellRenderer(selectionList, 22));
		
		getViewport().add(selectionList);
	}
	
	public void adaptListFacade(byte selectType)
	{
		ListModel listModel = selectionList.getModel();
		for (int i = 0; i < listModel.getSize(); i++)
		{
			IElementNode elementNode = (IElementNode) listModel.getElementAt(i);
			switch (selectType)
			{
				case SELECT_ALL:
					elementNode.setSelected(true);
					break;
				case SELECT_NONE:
					elementNode.setSelected(false);
					break;
				case SELECT_REVERSE:
					elementNode.setSelected(!elementNode.isSelected());
					break;
			}
		}
		
		updateSelection();
	}
	
	private void adaptSelection()
	{
		selectedElementNodes = new ArrayList();
		selectedUserObjects = new ArrayList();
		ListModel listModel = selectionList.getModel();
		for (int i = 0; i < listModel.getSize(); i++)
		{
			IElementNode elementNode = (IElementNode) listModel.getElementAt(i);
			if (elementNode.isSelected())
			{
				selectedElementNodes.add(elementNode);
				selectedUserObjects.add(elementNode.getUserObject());
			}
		}
	}
	
	public JList getList()
	{
		return selectionList;
	}
	
	public List getAllElementNodes()
	{
		List allElementNodes = new ArrayList();
		ListModel listModel = selectionList.getModel();
		for (int i = 0; i < listModel.getSize(); i++)
		{
			Object elementNode = listModel.getElementAt(i);
			allElementNodes.add(elementNode);
		}
		
		return allElementNodes;
	}
	
	public void setAllElementNodes(List allElementNodes)
	{
		selectionList.setListData(CollectionUtil.parseVector(allElementNodes));	
	}
	
	public List getSelectedElementNodes()
	{
		adaptSelection();
		
		return selectedElementNodes;
	}
	
	public List getSelectedUserObjects()
	{
		adaptSelection();
		
		return selectedUserObjects;
	}
	
	public void updateSelection()
	{
		selectionList.repaint();
	}
}