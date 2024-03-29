package com.nepxion.swing.tree.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.tree.TreeNode;

public interface IToggleAdapter
{
	/**
	 * �ĳ� toggle
	 * @param oldSelectionTreeNode
	 * @param newSelectionTreeNode
	 */
	public void invoke(TreeNode oldSelectionTreeNode, TreeNode newSelectionTreeNode);
}