package com.nepxion.swing.framework.dockable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DockableManager
{
	public static JDockableTabbedPane getDockableTabbedPane(JDockableContainer dockableContainer, String title, String tabbedPaneName)
	{
		List tabbedPanes = getDockableTabbedPanes(dockableContainer, title);
		if (tabbedPanes == null)
		{
			return null;
		}
		for (Iterator iterator = tabbedPanes.iterator(); iterator.hasNext();)
		{
			JDockableTabbedPane tabbedPane = (JDockableTabbedPane) iterator.next();
			if (tabbedPane.getName().equals(tabbedPaneName))
			{
				return tabbedPane;
			}
		}
		return null;
	}
	
	// �������DockableTabbedPane���󣬸÷���ֻ����DockableSplitPane������DockableTabbedPane��
	// ��DockableTabbedPane����ȫ��ģʽʱ����ֱ�ӷ�����DockableView����ͨ��DockableViewȥ��ȡDockableTabbedPane��
	// ����ͨ��DockableSplitPaneȥ��ȡ
	public static List getDockableTabbedPanes(JDockableContainer dockableContainer, String title)
	{
		JDockableView dockableView = getDockableView(dockableContainer, title);
		if (dockableView == null)
		{
			return null;
		}
		Component content = dockableView.getContentPane();
		if (content instanceof JDockableSplitPane)
		{
			JDockableSplitPane dockableSplitPane = (JDockableSplitPane) content;
			return dockableSplitPane.getTabbedPanes();
		}
		else if (content instanceof JDockableTabbedPane)
		{
			List tabbedPanes = new ArrayList();
			tabbedPanes.add(content);
			return tabbedPanes;
		}
		else
		{
			return null;
		}
	}
	
	// ����JDockableView Title���ָ��JDockableContainer�е�JDockableView����
	public static JDockableView getDockableView(JDockableContainer dockableContainer, String title)
	{
		Component component = dockableContainer.getContentPane();
		if (component instanceof JDockable) // ���״̬�£�Dockable���Ϊ��
		{
			JDockable dockable = (JDockable) component;
			return DockableManager.getDockableView(dockable, title);
		}
		else if (component instanceof JDockableView)
		{
			JDockableView dockableView = (JDockableView) component;
			if (dockableView.getTitle().equals(title))
			{
				return dockableView;
			}
		}
		return null;
	}
	
	// ����JDockableView Title���ָ��JDockable�е�JDockableView����
	public static JDockableView getDockableView(JDockable dockable, String title)
	{
		for (int i = 0; i < dockable.getPaneCount(); i++)
		{
			Component component = dockable.getPaneAt(i);
			if (component instanceof JDockableView)
			{
				JDockableView dockableView = (JDockableView) component;
				if (dockableView.getTitle().equals(title))
				{
					return dockableView;
				}
			}
			else if (component instanceof JDockable)
			{
				JDockable childDockable = (JDockable) component;
				JDockableView dockableView = getDockableView(childDockable, title);
				if (dockableView != null)
				{
					return dockableView;
				}
				else
				{
					continue;
				}
			}
		}
		return null;
	}
	
	public static List getDockableViews(JDockableContainer dockableContainer)
	{
		List dockableViews = new ArrayList();
		Component component = dockableContainer.getContentPane();
		if (component instanceof JDockable) // ���״̬�£�Dockable���Ϊ��
		{
			JDockable dockable = (JDockable) component;
			DockableManager.getDockableViews(dockable, dockableViews);
		}
		else if (component instanceof JDockableView)
		{
			JDockableView dockableView = (JDockableView) component;
			dockableViews.add(dockableView);
		}
		return dockableViews;
	}
	
	// ���ݻ��ָ��JDockable�е����е�JDockableView�����Ƕ�׶���
	public static List getDockableViews(JDockable dockable)
	{
		List dockableViews = new ArrayList();
		getDockableViews(dockable, dockableViews);
		return dockableViews;
	}
	
	// ���ݻ��ָ��JDockable�е����е�JDockableView�����Ƕ�׶���
	public static void getDockableViews(JDockable dockable, List dockableViews)
	{
		for (int i = 0; i < dockable.getPaneCount(); i++)
		{
			Component component = dockable.getPaneAt(i);
			if (component instanceof JDockableView)
			{
				JDockableView dockableView = (JDockableView) component;
				dockableViews.add(dockableView);
			}
			else if (component instanceof JDockable)
			{
				JDockable childDockable = (JDockable) component;
				getDockableViews(childDockable, dockableViews);
			}
		}
	}
	
	// ���DockableView�ĸ��ص����һ��Dockable�ָ���
	public static JDockable getDockable(Component dockableView)
	{
		Container container = dockableView.getParent();
		if (container == null)
		{
			return null;
		}
		
		if (container instanceof JDockable)
		{
			return (JDockable) container;
		}
		else
		{
			return getDockable(container);
		}
	}
	
	// ���DockableView�Ķ���DockableContainer����
	public static JDockableContainer getDockableContainer(Component dockableView)
	{
		Container container = dockableView.getParent();
		if (container == null)
		{
			return null;
		}
		
		if (container instanceof JDockableContainer)
		{
			return (JDockableContainer) container;
		}
		else
		{
			return getDockableContainer(container);
		}
	}
}