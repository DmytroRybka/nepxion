package com.nepxion.swing.style.button.lite;

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

import com.nepxion.swing.style.button.IButtonStyle;

public interface ILiteButtonStyle
	extends IButtonStyle
{
	public Color getRolloverBackground(); // ��������������ʱ�򣬰�ť�ı���ɫ
	
	public Color getRolloverBorderColor(); // ��������������ʱ�򣬰�ť�ı߽�ɫ
	
	public Color getSelectionBackground(); // ��갴�»��߰�ť��ѡȡ��ʱ�򣬰�ť�ı���ɫ
	
	public Color getSelectionBorderColor(); // ��갴�»��߰�ť��ѡȡ��ʱ�򣬰�ť�ı߽�ɫ
	
	public Color getCheckColor(); // ��ѡ����ɫ��ֻ������CheckBox��RadioButton
	
	public Color getFocusColor(); // ��������ɫ��ֻ������CheckBox��RadioButton
}