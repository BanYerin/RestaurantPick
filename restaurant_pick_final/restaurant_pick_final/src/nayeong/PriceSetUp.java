/*
 * ������ : �質��
 * JSlider�� �̿��Ͽ� ����, �ְ� ������ �����ϴ� ȭ�� 
 */

package nayeong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import yerin.*; //�ݿ��� ��Ű��
import yunjae.*; //������ ��Ű��

public class PriceSetUp extends JFrame {
	// ���� ������ �����ϴ� ȭ�� 
	
	public static int min=0 ,max=100000; // �ּ� ����, �ִ� ������ ������ ����
	JSlider minslider; // �ּ� Slider
	JSlider maxslider; // �ִ� Slider
	
	public PriceSetUp() {
		
		// ���ݴ� ���� ȭ�� �ʱ�ȭ 
		setTitle("���ݴ� ���� ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		
		// ȭ�� ����
		c.setBackground(Color.ORANGE);
		
		// ���ݴ� ���� ���� 
		JLabel title=new JLabel("���ݴ� ����");
		title.setBounds(102,10,300,80);
		title.setFont(new Font("�޸տ�����", Font.BOLD | Font.ITALIC, 50));
		c.add(title);
		
		// �ڷ� ��ư ����
		JButton bBack=new JButton("�ڷ�");
		bBack.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		bBack.setLocation(20,20);
		bBack.setSize(70, 40);
		c.add(bBack);
		bBack.addActionListener(new PriceSetUpListener());
		
		JLabel minTitle=new JLabel("�ּ� ����");
		minTitle.setBounds(80,590,400,80);
		minTitle.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 20));
		c.add(minTitle);
		
		// �ּҰ� JSlider
		minslider=new JSlider(JSlider.VERTICAL,0,100000,min);
		minslider.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 12));
		minslider.setLocation(50, 90);
		minslider.setPaintLabels(true);
		minslider.setPaintTicks(true);
		minslider.setMinorTickSpacing(2000);
		minslider.setMajorTickSpacing(10000);
		minslider.setSize(150, 520);
		minslider.setForeground(Color.BLUE);
		minslider.addChangeListener(new MyChangeListener());
		
		JLabel maxTitle=new JLabel("�ִ� ����");
		maxTitle.setBounds(325,590,400,80);
		maxTitle.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 20));
		c.add(maxTitle);
		
		// �ִ밪 JSlider
		maxslider=new JSlider(JSlider.VERTICAL,0,100000,max);
		maxslider.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 12));
		maxslider.setLocation(300, 90);
		maxslider.setPaintLabels(true);
		maxslider.setPaintTicks(true);
		maxslider.setMinorTickSpacing(2000);
		maxslider.setMajorTickSpacing(10000);
		maxslider.setSize(150, 520);
		maxslider.setForeground(Color.RED);
		maxslider.addChangeListener(new MyChangeListener());
		
		// Container�� �÷��ֱ�
		c.add(minslider);
		c.add(maxslider);
		
		// Container ������ 
		setSize(500,700);
		setVisible(true);
		
	}
	
	class MyChangeListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// �����̴� �� ��������
			min=minslider.getValue();
			max=maxslider.getValue();
			
			// �ּҰ�, �ִ� ����� �޾Ҵ��� Ȯ�� 
			System.out.println("�ּҰ� : "+min);
			System.out.println("�ִ� : "+max);
		}
		
	}

	
	class PriceSetUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b=(JButton) e.getSource();
			if(b.getText().equals("�ڷ�")) {
				System.out.println("�ڷ� ���� �̺�Ʈ");
				new nayeong.SetUp();
				setVisible(false);
			}
			
		}
		
	}
	
}


