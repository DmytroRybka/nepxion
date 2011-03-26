package com.nepxion.swing.tween;

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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Tweener
	implements ActionListener
{		
	private Timer timer; // ������ʱ��
	private int frameInterval = 1; // ����ˢ��ʱ����
	private int frameCount = 20; // ����֡��
	private int frameIndex; // ��ǰ����֡

	private boolean isHorizontalTweening = true; // �Ƿ�������
	private boolean isVerticalTweening = true; // �Ƿ�ֱ����
	
	private Component component;
	private Dimension dimension; // ����ȫ��չ��ʱ��С
	
	public static void tween(Component component)
	{
		tween(component, true, true);
	}
	
	public static void tween(Component component, int frameInterval, int frameCount)
	{
		tween(component, frameInterval, frameCount, true, true);
	}
	
	public static void tween(Component component, boolean isHorizontalTweening, boolean isVerticalTweening)
	{
		tween(component, 1, 20, isHorizontalTweening, isVerticalTweening);
	}
	
	/**
	 * ���ô˾�̬������ʾ���ڣ����Գ��ֶ���Ч��������ʾ�Ĵ������κμ̳���Component�Ĵ��ڣ�������ʾģ̬�ĶԻ���
	 */
	public static void tween(Component component, int frameInterval, int frameCount, boolean isHorizontalTweening, boolean isVerticalTweening)
	{
		if (component.isVisible())
		{
			return;
		}
		
		Tweener tweener = new Tweener(component, frameInterval, frameCount, isHorizontalTweening, isVerticalTweening);
		tweener.tween();
	}
	
	private Tweener(Component component, int frameInterval, int frameCount, boolean isHorizontalTweening, boolean isVerticalTweening)
	{
		this.component = component;
		this.frameInterval = frameInterval;
		this.frameCount = frameCount;
		this.isHorizontalTweening = isHorizontalTweening;
		this.isVerticalTweening = isVerticalTweening;
		
		dimension = component.getSize();
		component.setSize(0, 0);
		
		timer = new Timer(this.frameInterval, this);
		frameIndex = 0;
	}
	
	// ���������
	private void tween()
	{
		if (!component.isVisible())
		{
			timer.start();
			component.setVisible(true);
		}
	}
	
	// ������һ֡������
	public void actionPerformed(ActionEvent e)
	{
		// ��������õ�ǰ֡�ߴ�
		component.setSize(isHorizontalTweening ? dimension.width * frameIndex / frameCount : dimension.width, isVerticalTweening ? dimension.height * frameIndex / frameCount : dimension.height);
		
		if (frameIndex == frameCount)
		{
			// ���һ֡��ֹͣʱ�ӣ��ͷ���Դ
			timer.stop();
			timer = null;
			component = null;
			dimension = null;
		}
		else
		{
			// ǰ��һ֡
			frameIndex++;
		}
	}
}