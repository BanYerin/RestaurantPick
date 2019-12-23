/*
 ������: 2017038023 �ݿ���
 �ش� �ҽ����� ����: -����� ���� ȭ��(GUI, �̺�Ʈó��) -> ���α׷��� ���� ���� �� ����� ���
 */

package yerin;

import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import yunjae.*; //������ ��Ű��
import nayeong.*; //�質�� ��Ű��

//**��˹�� ����ȭ�� ���� Ŭ����**
public class Instruction extends JFrame {
	
	//**������. �ʱ⿡ �ʿ��� �غ��۾� ����**
	public Instruction() {
		//**GUIȭ�� �غ� �۾�**
		setTitle("�����");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Container c=getContentPane();
		 c.setLayout(null);
		 
		 //"�����" ���ڿ� ���̺�
		 JLabel textLab1=new JLabel("��� ���");
		 textLab1.setFont(new Font("�޸տ�����", Font.BOLD | Font.ITALIC, 50));
		 textLab1.setSize(257, 50);
		 textLab1.setLocation(132, 20);
		 
		//�ڷ� ��ư ���� �� ����
		JButton backBtn=new JButton("�ڷ�");
		
		backBtn.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		backBtn.setSize(70, 40);
		backBtn.setLocation(20, 20);
		backBtn.addActionListener(new MyActionListener()); //�׼��̺�Ʈ ������ ����
		
		//����� ���� �ؽ�Ʈâ ���� �� ����
		JTextArea InstructionText=new JTextArea(14, 40); //����� �ؽ�Ʈâ ����
		JScrollPane Instscroll=new JScrollPane(InstructionText); //����� �ؽ�Ʈâ�� ��ũ�ѹ� �ǿ� ����
		
		//�� �ؽ�Ʈâ�� ����� ���� �߰�
		InstructionText.append("1. ����ȭ���� \"������ ���� �̱�\"��ư�� ������ \n������ ���� �̱� ȭ������ �Ѿ�ϴ�.\n\n"
				+ "2. \"����\"��ư�� ������ �������� ���� �������� ���, ������ ���ݴ�, ��������\n ���� ������ �� �ֽ��ϴ�. ��Ҽ����� �������� ������ �ߺ������� �����ϰ�, \n�ʱ��� �⺻ ������ ������ \"��ü\"�̸�, �����ϰ� ���� ���� ������ \n������ �������� ���ܵ˴ϴ�.\n\n"
				+ "3. \"�̱�\"��ư�� ������ ������ ���� ������ �������� �������� �̾Ƽ� \n�ش� �������� ����URL�� �Բ� ����� ������ݴϴ�.\n\n"
				+ "4. ���� �������� ������ ���� ������ \"�ٽ� �̱�\"�� Ŭ���Ͽ� �������� \n�ٽ� ���� �� �ֽ��ϴ�.\n\n\n\n"
				+ "������: ����ڰ� ������ ������(������ ���, ���� ���ݴ�, ��������)�� \n�ش��ϴ� �������� �������� ���� ���, �̱��� ȭ�鿡 \n'�������� �ش��ϴ� �������� �������� ����'�� �˸��� ������ ��µ˴ϴ�.\n�̷� ���, ���������� ������ ������ ���ֽð� �ٽ� �̾��ּ���!\n\n\n\n\n"
				+ "\t~~~ ��ſ� �Ļ� �ð� �Ǽ��� (> �� <) ~~~");
		InstructionText.setEditable(false); //����� ���� â�� ������ ����ڰ� ������ �� ������ ����
		Instscroll.setSize(400, 500);
		Instscroll.setLocation(50, 100);
		
		
		 //����Ʈ�ҿ� ������Ʈ ����
		 c.add(textLab1);
		 c.add(backBtn);
		 c.add(Instscroll);
		 
		 //������ ����
		 c.setBackground(Color.ORANGE);
		 setSize(500, 700);
		 setVisible(true);
	}

	
	//**������ ��ư�� Ŭ���Ǹ� �ش��ϴ� ����� �����ϴ� Action������**
		private class MyActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JButton sourceBtn=(JButton)e.getSource();
				
				//�ڷ� ��ư�� ������ ����ȭ���� ����ȭ������ �Ѿ
				if(sourceBtn.getText().equals("�ڷ�")) {	
					System.out.println("�ڷι�ư �̺�Ʈ ����"); //��ư �������� �ش��ϴ� �̺�Ʈ�� �����ϴ��� ���� Ȯ���ϱ����� Ȯ�ο� ����ڵ�
					
					//���� ȭ������ �Ѿ
					new yunjae.Menu();
					setVisible(false);
				}
			}
		}
		
		

}
