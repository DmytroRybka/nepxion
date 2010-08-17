package com.nepxion.demo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;

import com.nepxion.demo.common.DemoToggleContentPanel;
import com.nepxion.swing.framework.dockable.FrameWorkManager;
import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.framework.dockable.JFrameWorkHierarchy;
import com.nepxion.swing.framework.dockable.JFrameWorkStatusBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menubar.JBasicMenuBar;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class DemoHierarchy
	extends JFrameWorkHierarchy
{
    public final static String EXPLORER_TITLE = "Explorer";
    public final static String CONTENT_PANE_TITLE = "ContentPane";
    
    public DemoHierarchy()
    {
        initContentPane();
        initMenuBar();
        initToolBar();
        initStatusBar();
    }
    
    private void initContentPane()
    {
    	JDockableView explorerView = new JDockableView(EXPLORER_TITLE, IconFactory.getSwingIcon("explorer.png"), DemoOutlookBar.getInstance());
		JDockableView contentPaneView = new JDockableView(CONTENT_PANE_TITLE, IconFactory.getSwingIcon("content_pane.png"), DemoToggleContentPanel.getInstance());
		
		JDockable dockable = new JDockable();
		dockable.setOrientation(JDockable.HORIZONTAL_SPLIT);
		dockable.add(explorerView, JDockable.FLEXIBLE);
		dockable.add(contentPaneView, JDockable.VARY);
        
        dockable.setDividerLocation(0, 170);
                                
        getDockableContainer().setContentPane(dockable);
    }

    private void initMenuBar()
    {
        JBasicMenuBar menuBar = getMenuBar();
        
        JBasicMenu menu = FrameWorkManager.getToggleMenu(this);
        ((JMenuItem) menu.getMenuComponent(1)).doClick();
        menuBar.add(menu);
        
        JBasicMenu helpMenu = new JBasicMenu("����", "����(H)");
        helpMenu.setMnemonic('H');
        menuBar.add(helpMenu);

        JBasicMenuItem aboutMenuItem = new JBasicMenuItem(DemoHierarchyController.getAboutAction());
        KeyStrokeManager.registerButton(aboutMenuItem, KeyEvent.VK_F1, 'U');      
        helpMenu.add(aboutMenuItem);
    }

    private void initToolBar()
    {
        JBasicToolBar toolBar = getToolBar();
    }

    private void initStatusBar()
    {
        JFrameWorkStatusBar statusBar = getStatusBar();
    }
}