/*
 * ������ : �質��
 * ���, ���ݴ�, ���� ������ �����ϴ� ȭ������ �̵��ϴ� ���� ��ư 
 */

package nayeong;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import yerin.*; //�ݿ��� ��Ű��
import yunjae.*; //������ ��Ű��

public class SetUp extends JFrame {

	public SetUp() {
		setTitle("���� �޴� ȭ�� ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Container �ʱ�ȭ
		Container c=getContentPane(); 
		c.setLayout(null);
		c.setBackground(Color.ORANGE);
		
		// ���� ���� 
		JLabel title=new JLabel("����");
		title.setBounds(183,10,158,80);
		title.setFont(new Font("�޸տ�����", Font.BOLD | Font.ITALIC, 50));
		c.add(title);
		
		// �ڷ� ��ư
		JButton bBack=new JButton("�ڷ�");
		bBack.setLocation(20,20);
		bBack.setSize(70, 40);
		bBack.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		c.add(bBack);
		bBack.addActionListener(new SetUpListener());
		
		// ���, ���ݴ�, ��������, Etc ��ư
		JButton place=new JButton("���");
		place.setLocation(175, 150);
		place.setSize(150,80);
		place.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		c.add(place);
		place.addActionListener(new SetUpListener());
		
		JButton price=new JButton("���ݴ�");
		price.setLocation(175, 300);
		price.setSize(150,80);
		price.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		c.add(price);
		price.addActionListener(new SetUpListener());
		
		JButton type=new JButton("���� ����");
		type.setLocation(175, 450);
		type.setSize(150,80);
		type.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		c.add(type);
		type.addActionListener(new SetUpListener());
		
		
		
		// ȭ�� ������ 
		setSize(500,700);
		setVisible(true);
		
		
	}
	
	class SetUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// ��� ��ư�� �������Ŀ� ���� �ٸ� �̺�Ʈ 
			JButton b=(JButton) e.getSource();
			if(b.getText().equals("�ڷ�")) {
				System.out.println("�ڷ� ���� �̺�Ʈ");
				new yerin.PickRandom();
				setVisible(false);

			}
			if(b.getText().equals("���")) {
				System.out.println("��� �̺�Ʈ");
				new yunjae.Place();
				setVisible(false);
			}
				
			if(b.getText().equals("���ݴ�")) {
				System.out.println("���ݴ� �̺�Ʈ");
				new nayeong.PriceSetUp();
				setVisible(false);
			}
			if(b.getText().equals("���� ����")) {
				System.out.println("�������� �̺�Ʈ");
				new yunjae.FoodChoice();
				setVisible(false);
			}
			
		}
	}
}

