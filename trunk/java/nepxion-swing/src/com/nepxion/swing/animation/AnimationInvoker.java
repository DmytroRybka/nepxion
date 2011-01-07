package com.nepxion.swing.animation;

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

public class AnimationInvoker
	implements ActionListener
{
	private Component component;
	
	// ������ʱ��
	private Timer timer;
	
	// ����ȫ��չ��ʱ��С
	private Dimension dimension;
	
	// �Ƿ�������
	private boolean isHorizontalExtending = true;
	
	// �Ƿ�ֱ����
	private boolean isVerticalExtending = true;
	
	// ����ˢ��ʱ����
	private int frameInterval = 1;
	
	// ����֡��
	private int frames = 20;
	
	// ��ǰ����֡
	private int frameIndex;
	
	public static void show(Component component)
	{
		show(component, true, true);
	}
	
	public static void show(Component component, int frameInterval, int frames)
	{
		show(component, frameInterval, frames, true, true);
	}
	
	public static void show(Component component, boolean isHorizontalExtending, boolean isVerticalExtending)
	{
		show(component, 1, 20, isHorizontalExtending, isVerticalExtending);
	}
	
	/**
	 * ���ô˾�̬������ʾ���ڣ����Գ��ֶ���Ч�� ����ʾ�Ĵ������κμ̳���Component�Ĵ��ڣ�������ʾģ̬�ĶԻ���
	 */
	public static void show(Component component, int frameInterval, int frames, boolean isHorizontalExtending, boolean isVerticalExtending)
	{
		if (component.isVisible())
		{
			return;
		}
		
		new AnimationInvoker(component, frameInterval, frames, isHorizontalExtending, isVerticalExtending).invoke();
	}
	
	// ˽�й��캯����������ֱ�ӷ���
	private AnimationInvoker(Component component, int frameInterval, int frames, boolean isHorizontalExtending, boolean isVerticalExtending)
	{
		// ��ʼ��
		this.component = component;
		this.frameInterval = frameInterval;
		this.frames = frames;
		this.isHorizontalExtending = isHorizontalExtending;
		this.isVerticalExtending = isVerticalExtending;
		
		dimension = component.getSize();
		timer = new Timer(this.frameInterval, this);
		frameIndex = 0;
		component.setSize(0, 0);
	}
	
	// ���������
	private void invoke()
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
		component.setSize(isHorizontalExtending ? dimension.width * frameIndex / frames : dimension.width, isVerticalExtending ? dimension.height * frameIndex / frames : dimension.height);
		
		if (frameIndex == frames)
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