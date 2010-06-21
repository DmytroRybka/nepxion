package com.nepxion.demo.component.splash;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.splash.JSplashDialog;

public class DemoSplashDialog
	extends JSplashDialog
{	
	public DemoSplashDialog()
	{
        super(IconFactory.getSwingIcon("splash.png"));
    }
}