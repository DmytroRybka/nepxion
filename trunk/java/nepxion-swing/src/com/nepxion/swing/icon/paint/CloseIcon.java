package com.nepxion.swing.icon.paint;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.UIManager;

public class CloseIcon
	implements Icon
{
	private Rectangle rectangle = new Rectangle(0, 0, 16, 16);
	
	private boolean isPressed = false;
	private boolean isDrawBorder = true;
	private boolean isDrawCenter = true;
	
	public CloseIcon()
	{
		this(true, true);
	}
	
	public CloseIcon(boolean isDrawBorder, boolean isDrawCenter)
	{
		this.isDrawBorder = isDrawBorder;
		this.isDrawCenter = isDrawCenter;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		rectangle.x = x;
		rectangle.y = y;
		Color color = g.getColor();
		
		// draw border
		if (isDrawBorder)
		{
			if (isPressed)
			{
				// g.setColor(UIManager.getColor("TabbedPane.shadow"));
				g.setColor(new Color(148, 145, 140));
				g.drawLine(x, y, x, y + rectangle.height);
				g.drawLine(x, y, x + rectangle.width, y);
				
				// g.setColor(UIManager.getColor("TabbedPane.highlight"));
				g.setColor(Color.white);
				g.drawLine(x, y + rectangle.height, x + rectangle.width, y + rectangle.height);
				g.drawLine(x + rectangle.width, y, x + rectangle.width, y + rectangle.height);
			}
			else
			{
				// g.setColor(UIManager.getColor("TabbedPane.highlight"));
				g.setColor(Color.white);
				g.drawLine(x, y, x, y + rectangle.height);
				g.drawLine(x, y, x + rectangle.width, y);
				
				// g.setColor(UIManager.getColor("TabbedPane.shadow"));
				g.setColor(new Color(148, 145, 140));
				g.drawLine(x, y + rectangle.height, x + rectangle.width, y + rectangle.height);
				g.drawLine(x + rectangle.width, y, x + rectangle.width, y + rectangle.height);
			}
		}
		
		g.setColor(UIManager.getColor("TabbedPane.foreground"));
		// draw X
		// left top
		g.drawRect(x + 4, y + 4, 1, 1);
		g.drawRect(x + 5, y + 5, 1, 1);
		g.drawRect(x + 5, y + 9, 1, 1);
		g.drawRect(x + 4, y + 10, 1, 1);
		// center
		if (isDrawCenter)
		{
			g.drawRect(x + 6, y + 6, 1, 1);
			g.drawRect(x + 8, y + 6, 1, 1);
			g.drawRect(x + 6, y + 8, 1, 1);
			g.drawRect(x + 8, y + 8, 1, 1);
		}
		// right top
		g.drawRect(x + 10, y + 4, 1, 1);
		g.drawRect(x + 9, y + 5, 1, 1);
		// right bottom
		g.drawRect(x + 9, y + 9, 1, 1);
		g.drawRect(x + 10, y + 10, 1, 1);
		g.setColor(color);
	}
	
	private void drawRec(Graphics g, int x, int y)
	{
		g.drawRect(x, y, 1, 1);
	}
	
	public Rectangle getBounds()
	{
		return rectangle;
	}
	
	public void setBounds(Rectangle rectangle)
	{
		this.rectangle = rectangle;
	}
	
	public int getIconWidth()
	{
		return rectangle.width;
	}
	
	public int getIconHeight()
	{
		return rectangle.height;
	}
	
	public boolean isPressed()
	{
		return isPressed;
	}
	
	public void setPressed(boolean pressed)
	{
		this.isPressed = pressed;
	}
	
	public boolean isDrawBorder()
	{
		return isDrawBorder;
	}
	
	public void setDrawBorder(boolean isDrawBorder)
	{
		this.isDrawBorder = isDrawBorder;
	}
	
	public boolean isDrawCenter()
	{
		return isDrawCenter;
	}
	
	public void setDrawCenter(boolean isDrawCenter)
	{
		this.isDrawCenter = isDrawCenter;
	}
}