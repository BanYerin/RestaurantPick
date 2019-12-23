//���ļ��� ������ -2015041014 ������
package yunjae;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FoodChoice extends JFrame {
	private JPanel contentPane;
	
	public static boolean foodChinese=true; //�߽� üũ ����
	public static boolean foodWestern=true; //��� üũ ����
	public static boolean foodKorean=true; //�ѽ� üũ ����
	public static boolean foodFast=true; //�н�ƮǪ�� üũ ����
	public static boolean foodJapanese=true; //�Ͻ� üũ ����
	
	JCheckBox �ѽ� = new JCheckBox(""); //�ѽ� üũ�ڽ�
	JCheckBox �Ͻ� = new JCheckBox(""); //�Ͻ� üũ�ڽ�
	JCheckBox ��� = new JCheckBox(""); //��� üũ�ڽ�
	JCheckBox �߽� = new JCheckBox(""); //�߽� üũ�ڽ�
	JCheckBox �н�Ʈ = new JCheckBox(""); //�н�ƮǪ�� üũ�ڽ�
	
public FoodChoice() {
		setTitle("�޴� ����"); //������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����� ���μ������� ����
		setSize(500,700); //������ 500x700
		contentPane = new JPanel(); //�г� ����
		contentPane.setBackground(Color.ORANGE); //������ �������� ����
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //�׵θ� ����
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JButton BackButton = new JButton("�ڷ�"); //�ڷΰ��� ��ư
		BackButton.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		BackButton.setSize(70,40); //��ư ������ ����
		BackButton.setLocation(20,20); //��ǥ����
		contentPane.add(BackButton); //�гο� �߰�
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //�ڷΰ��� ��ư ������ ��� ���������� �Ѿ(����)
				new nayeong.SetUp(); //�ٽ� ���� ȭ������ �Ѿ
				System.out.println("��Ҽ��� ���"); //�����糪 ��¹�
				dispose(); //��� ���������� �Ѿ�� ���ļ��� ������ ����
			}
		}); 
		
		JLabel FoodKindSetting = new JLabel("�������� ����"); //���߰�(�������� ���� ����)
		FoodKindSetting.setHorizontalAlignment(SwingConstants.CENTER); //��� ����
		FoodKindSetting.setForeground(Color.BLACK); //�۾� ���������� ����
		FoodKindSetting.setFont(new Font("�޸տ�����", Font.BOLD | Font.ITALIC, 50)); //��Ʈ�� �۾�ũ�� ����
		FoodKindSetting.setBounds(62, 20, 412, 60); //��ǥ����
		contentPane.add(FoodKindSetting); //�гο� �߰�
		
		JLabel �ѽ��̹��� =new JLabel(""); //�ѽ� �� �߰�
		�ѽ��̹���.setIcon(new ImageIcon("image/�ѽ�.jpg")); //�ѽ� �̹��� �߰�
		�ѽ��̹���.setBounds(30, 90, 187, 162); //��ǥ����
		contentPane.add(�ѽ��̹���); //�гο� �߰�
		
		JLabel �Ͻ��̹��� = new JLabel(""); //�Ͻ� �� �߰�
		�Ͻ��̹���.setIcon(new ImageIcon("image/japan.jpg"));//�Ͻ� �̹��� �߰�
		�Ͻ��̹���.setBounds(282, 90, 187, 162); //��ǥ����
		contentPane.add(�Ͻ��̹���); //�гο� �߰�
		
		JLabel ����̹��� = new JLabel(""); //��� �� �߰�
		����̹���.setIcon(new ImageIcon("image/���.jpg"));//��� �̹��� �߰� 
		����̹���.setBounds(30, 296, 187, 162); //��ǥ����
		contentPane.add(����̹���); //�гο� �߰�
		
		JLabel �߽��̹��� = new JLabel(""); //�߽� �� �߰�
		�߽��̹���.setIcon(new ImageIcon("image/china.jpg"));//�߽� �̹��� �߰�
		�߽��̹���.setBounds(282, 296, 187, 162); //��ǥ����
		contentPane.add(�߽��̹���); //�гο� �߰�
		
		JLabel �н�ƮǪ�� = new JLabel(""); //�н�ƮǪ�� �� �߰�
		�н�ƮǪ��.setIcon(new ImageIcon("image/FastFood.jpg"));//�н�ƮǪ�� �̹��� �߰�
		�н�ƮǪ��.setBounds(44, 491, 187, 162); //��ǥ����
		contentPane.add(�н�ƮǪ��); //�гο� �߰�
		
		MyItemListener listener = new MyItemListener(); //ItemListener ���
		�ѽ�.setHorizontalAlignment(SwingConstants.CENTER); //��� ����
		�ѽ�.setFont(new Font("����", Font.PLAIN, 12)); //�۾�ü ����
		�ѽ�.setBackground(Color.ORANGE); //������
		�ѽ�.setBounds(48, 247, 42, 30); //�ѽ� ��ǥ����
		contentPane.add(�ѽ�);
		�ѽ�.addItemListener(listener);//üũ�ڽ��� Item������ ���
		if(foodKorean==true) { //boolean üũ
			�ѽ�.setSelected(true); //���õ�ä�� ����
		}else
		{
			�ѽ�.setSelected(false); //�������� ��ä�� ����
		}
			
		�Ͻ�.setHorizontalAlignment(SwingConstants.CENTER);
		�Ͻ�.setBackground(Color.ORANGE);
		�Ͻ�.setBounds(292, 247, 42, 30); //�Ͻ� ��ǥ����
		contentPane.add(�Ͻ�);
		�Ͻ�.addItemListener(listener);//üũ�ڽ��� Item������ ���
		if(foodJapanese==true) {
			�Ͻ�.setSelected(true); //���õ�ä�� ����
		}else
		{
			�Ͻ�.setSelected(false); //�������� ��ä�� ����
		}
		
		���.setHorizontalAlignment(SwingConstants.CENTER);
		���.setBackground(Color.ORANGE);
		���.setBounds(48, 455, 42, 30); //��� ��ǥ����
		contentPane.add(���);
		���.addItemListener(listener);//üũ�ڽ��� Item������ ���
		if(foodWestern==true) {
			���.setSelected(true); //���õ�ä�� ����
		}else
		{
			���.setSelected(false); //�������� ��ä�� ����
		}
		
		�߽�.setHorizontalAlignment(SwingConstants.CENTER);
		�߽�.setBackground(Color.ORANGE);
		�߽�.setBounds(292, 455, 42, 30); //�߽� ��ǥ����
		contentPane.add(�߽�);
		�߽�.addItemListener(listener);//üũ�ڽ��� Item������ ���
		if(foodChinese==true) {
			�߽�.setSelected(true); //���õ�ä�� ����
		}else
		{
			�߽�.setSelected(false); //�������� ��ä�� ����
		}
		
		�н�Ʈ.setHorizontalAlignment(SwingConstants.CENTER);
		�н�Ʈ.setBackground(Color.ORANGE);
		�н�Ʈ.setBounds(228, 603, 42, 30); //�н�ƮǪ�� ��ǥ����
		contentPane.add(�н�Ʈ);
		�н�Ʈ.addItemListener(listener); //üũ�ڽ��� Item������ ���
		if(foodFast==true) {
			�н�Ʈ.setSelected(true); //���õ�ä�� ����
		}else
		{
			�н�Ʈ.setSelected(false); //�������� ��ä�� ����
		}
		
		JLabel KF = new JLabel("�ѽ�"); //�̹����� ���� �ؽ�Ʈ
		KF.setHorizontalAlignment(SwingConstants.CENTER);
		KF.setFont(new Font("�ü�ü", Font.PLAIN, 23));
		KF.setBounds(87, 247, 95, 24);
		contentPane.add(KF);
		
		JLabel JF = new JLabel("�Ͻ�");//�̹����� ���� �ؽ�Ʈ
		JF.setHorizontalAlignment(SwingConstants.CENTER);
		JF.setFont(new Font("�ü�ü", Font.PLAIN, 23));
		JF.setBounds(315, 247, 95, 24);
		contentPane.add(JF);
		
		JLabel WF = new JLabel("���");//�̹����� ���� �ؽ�Ʈ
		WF.setHorizontalAlignment(SwingConstants.CENTER);
		WF.setFont(new Font("�ü�ü", Font.PLAIN, 23));
		WF.setBounds(87, 455, 95, 24);
		contentPane.add(WF);
		
		JLabel CF = new JLabel("�߽�");//�̹����� ���� �ؽ�Ʈ
		CF.setHorizontalAlignment(SwingConstants.CENTER);
		CF.setFont(new Font("�ü�ü", Font.PLAIN, 23));
		CF.setBounds(315, 455, 95, 24);
		contentPane.add(CF);
		
		JLabel FF = new JLabel("�н�ƮǪ��");//�̹����� ���� �ؽ�Ʈ
		FF.setHorizontalAlignment(SwingConstants.CENTER);
		FF.setFont(new Font("�ü�ü", Font.PLAIN, 23));
		FF.setBounds(262, 603, 138, 24);
		contentPane.add(FF);
		
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener{
		
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.DESELECTED) {//Ŭ���Ͽ� üũ ���� ���  
			if(e.getItem()==�ѽ�) { //�ѽ� üũ�ڽ� ���ý�
				foodKorean = false; //�ѽ� üũ�ȵ�
				System.out.println("�ѽ� ���� ����"); //�Ǵ��� Ȯ��
			}
			if(e.getItem()==�Ͻ�) { //�Ͻ� üũ�ڽ� ���ý�
				foodJapanese = false;
				System.out.println("�Ͻ� ���� ����"); //�Ǵ��� Ȯ��
			}
			if(e.getItem()==�н�Ʈ) {
				foodFast = false;
				System.out.println("�н�ƮǪ�� ���� ����");
			}
			if(e.getItem()==�߽�) {
				foodChinese = false;
				System.out.println("�߽� ���� ����");
			}
			if(e.getItem()==���) {
				foodWestern = false;
				System.out.println("��� ���� ����");
			}
			
		}
		else { //�ٽ� Ŭ���Ͽ� üũ �ִ°��
			if(e.getItem()==�ѽ�) { //�ѽ� üũ�ڽ� ���ý�
				foodKorean = true;
				System.out.println("�ѽ� ����"); //�Ǵ��� Ȯ��
			}
			if(e.getItem()==�Ͻ�) { //�Ͻ� üũ�ڽ� ���ý�
				foodJapanese = true;
				System.out.println("�Ͻ� ����"); //�Ǵ��� Ȯ��
			}
			if(e.getItem()==�н�Ʈ) {
				foodFast = true;
				System.out.println("�н�ƮǪ�� ����");
			}
			if(e.getItem()==�߽�) {
				foodChinese = true;
				System.out.println("�߽� ����");
			}
			if(e.getItem()==���) {
				foodWestern = true;
				System.out.println("��� ����");
			}
		}
		
	}
	}
}
	


