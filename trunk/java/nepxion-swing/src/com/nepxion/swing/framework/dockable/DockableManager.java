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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

import com.nepxion.swing.framework.JFrameWorkWindow;
import com.nepxion.swing.fullscreen.FullScreenRegister;
import com.nepxion.swing.fullscreen.FullScreenSupport;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicCheckBoxMenuItem;

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
	
	
	public static JDockableView getDockableView(JFrameWorkWindow frameWorkWindow, String title)
	{
		if (frameWorkWindow == null)
		{
			return null;
		}
		
		JDockableHierarchy dockableHierarchy = (JDockableHierarchy) frameWorkWindow.getHierarchy();
		
		return getDockableView(dockableHierarchy, title);
	}
	
	public static JDockableView getDockableView(JDockableHierarchy dockableHierarchy, String title)
	{
		if (dockableHierarchy == null)
		{
			return null;
		}
		
		JDockableContainer dockableContainer = dockableHierarchy.getDockableContainer();
		Component component = dockableContainer.getContentPane();
		
		if (component instanceof JDockable)
		{
			JDockable dockable = (JDockable) component;
			
			return DockableManager.getDockableView(dockable, title);
		}
		
		return null;
	}
	
	public static JBasicMenu getToggleMenu(final JDockableHierarchy hierarchy)
	{
		JBasicMenu toggleMenu = new JBasicMenu(SwingLocale.getString("view"), SwingLocale.getString("view") + "(V)");
		toggleMenu.setMnemonic('V');
		
		final JBasicCheckBoxMenuItem toolBarToggleMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("toolbar"), SwingLocale.getString("toolbar"), true);
		toolBarToggleMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComponent toolBar = hierarchy.getToolBar();
				toolBar.setVisible(!toolBar.isVisible());
			}
		}
		);
		toggleMenu.add(toolBarToggleMenuItem);
		
		final JBasicCheckBoxMenuItem statusBarToggleMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("statusbar"), SwingLocale.getString("statusbar"), true);
		statusBarToggleMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComponent statusBar = hierarchy.getStatusBar();
				statusBar.setVisible(!statusBar.isVisible());
			}
		}
		);
		toggleMenu.add(statusBarToggleMenuItem);
		
		toggleMenu.addSeparator();
		
		List dockableViews = hierarchy.getDockableViews();
		for (Iterator iterator = dockableViews.iterator(); iterator.hasNext();)
		{
			final JDockableView dockableView = (JDockableView) iterator.next();
			final JBasicCheckBoxMenuItem dockableViewToggleMenuItem = new JBasicCheckBoxMenuItem(dockableView.getTitle(), dockableView.getTitle(), true);
			dockableView.registerForeignButton(dockableViewToggleMenuItem);
			dockableViewToggleMenuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dockableView.setVisible(!dockableView.isVisible());
				}
			}
			);
			toggleMenu.add(dockableViewToggleMenuItem);
		}
		
		toggleMenu.addSeparator();
		
		JBasicCheckBoxMenuItem screenToggleMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("fullscreen"), SwingLocale.getString("fullscreen"));
		// JBasicMenuItem screenToggleMenuItem = new JBasicMenuItem(FullScreenConstants.TEXT_MAXIMIZE, FullScreenConstants.ICON_MAXIMIZE, FullScreenConstants.TEXT_MAXIMIZE);
		KeyStrokeManager.registerButton(screenToggleMenuItem, KeyEvent.VK_F12, 'F');
		toggleMenu.add(screenToggleMenuItem);
		
		FullScreenSupport fullScreenSupport = new FullScreenSupport(hierarchy);
		FullScreenRegister fullScreenRegister = new FullScreenRegister(fullScreenSupport);
		fullScreenRegister.register(hierarchy.getMenuBar());
		fullScreenRegister.register(hierarchy.getToolBar());
		fullScreenRegister.register(screenToggleMenuItem);
		
		return toggleMenu;
	}	
}