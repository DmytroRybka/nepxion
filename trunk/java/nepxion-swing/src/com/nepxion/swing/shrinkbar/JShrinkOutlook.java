package com.nepxion.swing.shrinkbar;

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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.TexturePaint;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.nepxion.swing.gradient.JTexturePainter;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.style.texture.shrink.IOutlookTextureStyle;

public class JShrinkOutlook
	extends JPanel
{
	private JShrinkOutlookBar shrinkOutlookBar;
	
	private JLabel handlerLabel;
	private JLabel titleLabel;
	private JLabel iconLabel;
	
	private JBasicScrollPane scrollPane;
	
	private Icon icon;
	private Icon selectedIcon;
	private boolean selected = false;
	
	private IOutlookTextureStyle outlookTextureStyle;
	
	public JShrinkOutlook(JShrinkOutlookBar shrinkOutlookBar)
	{
		this.shrinkOutlookBar = shrinkOutlookBar;
		this.outlookTextureStyle = shrinkOutlookBar.getOutlookTextureStyle();
		
		initComponents();
	}
	
	private void initComponents()
	{
		ShrinkOutlookListener shrinkOutlookListener = new ShrinkOutlookListener(this);
		
		handlerLabel = new JLabel();
		handlerLabel.setIcon(outlookTextureStyle.getHandlerImageIcon());
		handlerLabel.setVerticalAlignment(SwingConstants.CENTER);
		handlerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 16));
		handlerLabel.addMouseListener(shrinkOutlookListener);
		
		titleLabel = new JLabel();
		titleLabel.setForeground(outlookTextureStyle.getForeground());
		titleLabel.setVerticalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
		titleLabel.addMouseListener(shrinkOutlookListener);
		
		iconLabel = new JLabel();
		iconLabel.setVerticalAlignment(SwingConstants.CENTER);
		iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 0));
		iconLabel.addMouseListener(shrinkOutlookListener);
		
		scrollPane = new JBasicScrollPane();
		scrollPane.setMinimumSize(new Dimension(0, 0));
		scrollPane.setBorder(new Border()
		{
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
			{
				g.setColor(outlookTextureStyle.getScrollBorderColor());
				g.drawLine(0, height, x, height);
			}
			
			public Insets getBorderInsets(Component c)
			{
				return new Insets(0, 0, 1, 0);
			}
			
			public boolean isBorderOpaque()
			{
				return true;
			}
		}
		);
		
		setLayout(new BorderLayout());
		add(handlerLabel, BorderLayout.EAST);
		add(iconLabel, BorderLayout.WEST);
		add(titleLabel, BorderLayout.CENTER);
	}
	
	public JShrinkOutlookBar getShrinkOutlookPane()
	{
		return shrinkOutlookBar;
	}
	
	public JComponent getContentPane()
	{
		return scrollPane;
	}
	
	public String getTitle()
	{
		return titleLabel.getText();
	}
	
	public void setTitle(String title)
	{
		titleLabel.setText(title);
		titleLabel.setToolTipText(title);
		iconLabel.setToolTipText(title);
		handlerLabel.setToolTipText(title);
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean selected)
	{
		if (this.selected == selected)
		{
			return;
		}
		
		if (!this.selected)
		{
			shrinkOutlookBar.closeAllOutlooks();
		}
		
		this.selected = selected;
		
		if (selected)
		{
			handlerLabel.setIcon(outlookTextureStyle.getSelectionHandlerImageIcon());
			titleLabel.setForeground(outlookTextureStyle.getSelectionForeground());
		}
		else
		{
			handlerLabel.setIcon(outlookTextureStyle.getHandlerImageIcon());
			titleLabel.setForeground(outlookTextureStyle.getForeground());
		}
		
		JComponent component = getContentPane();
		
		shrinkOutlookBar.updateLayoutConstraint(component, selected);
		shrinkOutlookBar.setFillContentPaneVisible(!selected);
		shrinkOutlookBar.revalidate();
	}
	
	protected void toggleSelection()
	{
		boolean selected = isSelected();
		
		setSelected(!selected);
	}
	
	protected void toggleShrink(boolean shrinked)
	{
		if (shrinked)
		{
			handlerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 22));
		}
		else
		{
			handlerLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 16));
		}
	}
	
	public Icon getIcon()
	{
		return icon;
	}
	
	public void setIcon(Icon icon)
	{
		this.icon = icon;
		
		if (selectedIcon == null)
		{
			selectedIcon = icon;
		}
		if (selected)
		{
			iconLabel.setIcon(selectedIcon);
		}
		else
		{
			iconLabel.setIcon(icon);
		}
	}
	
	public Icon getSelectedIcon()
	{
		return selectedIcon;
	}
	
	public void setSelectedIcon(Icon selectedIcon)
	{
		this.selectedIcon = selectedIcon;
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(super.getPreferredSize().width, outlookTextureStyle.getHeight());
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		int width = getWidth();
		int height = getHeight();
		
		if (selected)
		{
			ImageIcon selectionBackgroundImageIcon = outlookTextureStyle.getSelectionBackgroundImageIcon();
			TexturePaint selectionBackgroundTexturePainter = JTexturePainter.getCacheTexturePaint(selectionBackgroundImageIcon.getImage());
			g2d.setPaint(selectionBackgroundTexturePainter);
			
			if (selectedIcon != null)
			{
				iconLabel.setIcon(selectedIcon);
			}
			else
			{
				iconLabel.setIcon(icon);
			}
		}
		else
		{
			ImageIcon backgroundImageIcon = outlookTextureStyle.getBackgroundImageIcon();
			TexturePaint backgroundTexturePainter = JTexturePainter.getCacheTexturePaint(backgroundImageIcon.getImage());
			g2d.setPaint(backgroundTexturePainter);
			
			iconLabel.setIcon(icon);
		}
		
		g2d.fillRect(0, 0, width, height);
		
		/*if (selected)
		{
			ImageIcon selectionBackgroundLeftImageIcon = outlookTextureStyle.getSelectionBackgroundLeftImageIcon();
			ImageIcon selectionBackgroundRightImageIcon = outlookTextureStyle.getSelectionBackgroundRightImageIcon();
			
			g2d.drawImage(selectionBackgroundLeftImageIcon.getImage(), 0, 0, null);
			g2d.drawImage(selectionBackgroundRightImageIcon.getImage(), width - selectionBackgroundRightImageIcon.getImage().getWidth(null), 0, null);
		}*/
	}
}