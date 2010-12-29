package com.nepxion.swing.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.MouseEvent;

import javax.swing.table.TableModel;
import javax.swing.tree.TreeSelectionModel;

public interface ITable
{
	public static final int SINGLE_TREE_SELECTION = TreeSelectionModel.SINGLE_TREE_SELECTION;
	public static final int CONTIGUOUS_TREE_SELECTION = TreeSelectionModel.CONTIGUOUS_TREE_SELECTION;
	public static final int DISCONTIGUOUS_TREE_SELECTION = TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION;
	
	public TableModel getModel();
	
	public void setModel(TableModel tableModel);
	
	public int getSelectionMode();
	
	public void setSelectionMode(int mode);
	
	public void executeSelection(int selectedRow);
	
	public void executeClicked(int selectedRow, MouseEvent e);
	
	public void executeClicked(int selectedRow);
	
	public void executeDoubleClicked(int selectedRow);
	
	public void executePopupMenu(int selectedRow, int x, int y);
	
	public void executePopupMenu(int x, int y);
}