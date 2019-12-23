/*
 * ������ : �質��
 * �������� ���� ������ �����ͼ� ������ִ� ȭ��
 */

package nayeong;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

import yerin.*; //�ݿ��� ��Ű��
import yunjae.*; //������ ��Ű��

public class StoreSetUp extends JFrame{
	
	ResultSet randomResult=null;
	
	public StoreSetUp() {
		setTitle("������ �̱� ��� ȭ��");
		
		// ȭ�� �ʱ�ȭ 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.ORANGE);
		
		// ������ �̱� ȭ�� ����
		JLabel title=new JLabel("������ �̱� ���");
		title.setBounds(109,10,269,80);
		title.setFont(new Font("�޸տ�����", Font.BOLD, 30));
		c.add(title);
		
		// ���� ��ư 
		JButton bSetup=new JButton("����");
		bSetup.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		bSetup.setLocation(390, 20);
		bSetup.setSize(70, 40);
		bSetup.addActionListener(new StoreSetUpListener());
		c.add(bSetup);
		
		// �ٽ� �̱� ��ư
		JButton again=new JButton("�ٽ� �̱�");
		again.setLocation(20,540);
		again.setSize(440, 70);
		again.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 20));
		c.add(again);
		again.addActionListener(new StoreSetUpListener());
		
		// ���� ȭ�鿡�� ������ �޾ƿ��� ��ü
		randomResult=PickRandom.getRandomResult();
		
		// ������ ��� �����ϴ� �Ĵ��� ���� ���
		if(randomResult!=null) {
			try {
				
				//����� ���ڵ忡 �����ϴ� ������ ���� ���޹��� Ȯ�ο� ����
					System.out.println("�̱� �����ü ���������� ���� ����");
				
				// PickRandom ���������� ������ �޾ƿ� �������� ���� �Ĵ� �̸��� url ���
				while(randomResult.next()) {
					JLabel nameLabel=new JLabel(randomResult.getString("name"));
					nameLabel.setBounds(35,440,500,40);
					nameLabel.setFont(new Font("", Font.BOLD, 25));
					
					JLabel jlabel=new JLabel("���� url : "+randomResult.getString("mapURL"));	
					jlabel.setBounds(35,490,500,20);
					jlabel.setFont(new Font("", Font.ITALIC, 20));
					ImageIcon image =new ImageIcon("image/foodResultGif.gif");
					JLabel imageLab=new JLabel(image);
					imageLab.setBounds(100, 80, 300, 320);
					c.add(jlabel);
					c.add(nameLabel);
					c.add(imageLab);
				}
				
			} catch(Exception e) {
				System.out.println("Error!!!");
			}
		} else {
			// ������ ��� �����ϴ� �Ĵ��� ���� ���
			JLabel jlabel=new JLabel("�ش��ϴ� �Ĵ��� �����");
			jlabel.setBounds(70,460,500,30);
			jlabel.setFont(new Font("", Font.BOLD, 30));
			ImageIcon image =new ImageIcon("image/crying.png");
			JLabel imageLab=new JLabel(image);
			imageLab.setBounds(100, 100, 300, 300);
			c.add(jlabel);
			c.add(imageLab);
		}
		
		// ȭ�� ������
		setSize(500,700);
		setVisible(true);
	}
	

	
	class StoreSetUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton b=(JButton) e.getSource();
			if(b.getText().equals("�ٽ� �̱�")) {
				System.out.println("Ȩ ȭ������ �̵��ϴ� �̺�Ʈ");
				new yunjae.Menu();
				setVisible(false);
			}
			if(b.getText().equals("����")) {
				System.out.println("���� ȭ������ �̵��ϴ� �̺�Ʈ");
				new nayeong.SetUp();
				setVisible(false);
			}
		}
		
	}
	
	
}

	
