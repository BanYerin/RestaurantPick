//���α׷� ���۽� �����̱� or ����� ������ �޴� -2015041014 ������
package yunjae;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame { //�޴��Լ� ->MAIN.java���� �θ�	
	
	private JPanel contentPane;
	
public Menu() {
		setTitle("���� �޴�"); //Jframe �̸�
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����� ���μ������� ����
		setSize(500,700); //������ ������ ����

		contentPane = new JPanel(); //�г� ����
		contentPane.setBackground(Color.ORANGE); //������ ������ ����
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //�׵θ� ����
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton HowToUse = new JButton(""); //�����  ��ư
		HowToUse.addMouseListener(new MouseAdapter() { //����� ���콺 �׼�
			@Override
			public void mouseEntered(MouseEvent arg0) { //���콺 ���ٴ�ÿ� �ٲ�� ������
				HowToUse.setIcon(new ImageIcon("image/�����.jpg"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) { //���콺 ���� �ٲ�� ������
				HowToUse.setIcon(new ImageIcon("image/���������.jpg"));
			}
		});
		HowToUse.setIcon(new ImageIcon("image/���������.jpg")); //����� ����Ʈ ������
		HowToUse.setBorderPainted(false); //�׵θ� ����ǥ��
		HowToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //����� ������ Ŭ����
				new yerin.Instruction();  //����� ���������� �Ѿ
				System.out.println("�������� ���"); //������ �糪 Ȯ�� ��¹�
				dispose(); //����� ������ ���ý� ���� �ִ� �޴� ������ ������
			}
		});
		HowToUse.setBounds(151, 408, 172, 166); //��ǥ���� 
		contentPane.add(HowToUse);
		
		JButton Random = new JButton(""); //�����̱� ��ư
		Random.addMouseListener(new MouseAdapter() { //���콺 �׼�
			@Override
			public void mouseEntered(MouseEvent arg0) { //���콺 ���ٴ�ÿ� ��Ÿ������ ������
				Random.setIcon(new ImageIcon("image/BOX.jpg"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) { //���콺 ���ÿ� ��Ÿ������ ������
				Random.setIcon(new ImageIcon("image/BOX�帰.jpg"));
			}
		});
		Random.setIcon(new ImageIcon("image/BOX�帰.jpg")); //����Ʈ ������
		Random.setBorderPainted(false); //�׵θ� ����
		Random.setBounds(151, 143, 172, 188);
		Random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) { //�����̱� ������ Ŭ����
				new yerin.PickRandom(); //�����̱� ������ â���� �Ѿ
				dispose(); //�����̱� ������â ���ý�, �����ִ� ������ ������
			}
		});
		contentPane.add(Random);
		
		JLabel Topic = new JLabel("���� �� ����?"); //���߰� (�޴� ����)
		Topic.setForeground(Color.BLACK); //�۾� ���������� ����
		Topic.setFont(new Font("�޸տ�����", Font.BOLD | Font.ITALIC, 50)); //��Ʈ�� �۾�ũ�� ����
		Topic.setHorizontalAlignment(SwingConstants.CENTER); //��� ����
		Topic.setBounds(40, 41, 412, 60);  //��ǥ����
		contentPane.add(Topic); //�гο� �߰�
		
		JLabel Pick = new JLabel("������ �����̱�"); //���߰� (�����̱�)
		Pick.setHorizontalAlignment(SwingConstants.CENTER);
		Pick.setForeground(Color.BLACK);
		Pick.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 25));
		Pick.setBounds(40, 341, 412, 60);
		contentPane.add(Pick);
		
		JLabel How_to_use = new JLabel("��� ���"); //���߰�(�����)
		How_to_use.setHorizontalAlignment(SwingConstants.CENTER);
		How_to_use.setForeground(Color.BLACK);
		How_to_use.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 25));
		How_to_use.setBounds(29, 584, 412, 60);
		contentPane.add(How_to_use);
		
		setVisible(true);
	}
}
