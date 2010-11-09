package com.nepxion.swing.style.framework;

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

import javax.swing.border.Border;

public interface IStyle
{
	public Color getGradientColor(); // ���俪ʼ����ɫ
	
	public Color getSelectionGradientColor(); // ѡ�н��俪ʼ����ɫ
	
	
	public Color getForeground(); // ǰ��ɫ����ǩ������ɫ
	
	public Color getSelectionForeground(); // ѡ��ǰ��ɫ����ǩ������ɫ
	
	
	public Color getBackground(); // ����ɫ�������������ɫ
	
	public Color getSelectionBackground(); // ѡ�б���ɫ�������������ɫ
	
	
	public Color getTabbedPaneGradientColor(); // ѡ����俪ʼ����ɫ
	
	public Color getTabbedPaneBackground(); // ѡ������������ɫ, ����ɫ
	
	
	public Color getTabbedPaneForeground(); // ѡ�ǰ��ɫ����ǩ������ɫ
	
	public Color getTabbedPaneSelectionForeground(); // ѡ��ѡ�ǰ��ɫ����ǩ������ɫ
	
	
	public Border getBorder(); // ��ܱ߽�
	
	public Border getHeaderBorder(); // ���ͷ���߽�
	
	public Border getLabelBorder(); // ��ܱ������߽�
}