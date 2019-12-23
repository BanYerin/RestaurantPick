//��� ������ -2015041014 ������
package yunjae;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class Place extends JFrame {

	private JPanel contentPane;
	
	public static boolean locMiddle=true; //�߹� üũ ����
	public static boolean locFront=true; //���� üũ ����
	public static boolean locBack=true; //�Ĺ� üũ ����
	public static boolean locWest=true; //���� üũ ����
	
	JCheckBox ���� = new JCheckBox(""); //���� üũ�ڽ�
	JCheckBox �߹� = new JCheckBox(""); //�߹� üũ�ڽ�
	JCheckBox ���� = new JCheckBox(""); //���� üũ�ڽ�
	JCheckBox �Ĺ� = new JCheckBox(""); //�Ĺ� üũ�ڽ� 
	private final JLabel Thing = new JLabel("");
	private final JLabel ����ǥ�� = new JLabel("");
	private final JLabel ����ǥ�� = new JLabel("");
	private final JLabel �Ĺ�ǥ�� = new JLabel("");
	private final JLabel �߹�ǥ�� = new JLabel("");
	
	public Place() {
		
		setTitle("��� ����"); //������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����� ���μ������� ����
		setSize(500,700); //������ �������
		
		contentPane = new JPanel(); //�г� ����
		contentPane.setBackground(Color.ORANGE); //�г� ���� �������� ����
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //�׵θ�����
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BackButton = new JButton("�ڷ�"); //�ڷι�ư ����
		BackButton.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		BackButton.setSize(70,40); //������ ����
		BackButton.setLocation(20,20); //��ġ ����
		contentPane.add(BackButton); //�гο� �߰�
		
		
		BackButton.addActionListener(new ActionListener() { //�ڷΰ��� ��ư ������
			public void actionPerformed(ActionEvent Arg0) {
				new nayeong.SetUp(); //����ȭ������ ���ư�
				dispose(); //�����ִ� ������ ����
			}
		});
		
		�߹�ǥ��.setIcon(new ImageIcon("image/�߹�.jpg"));//�߹�ǥ�� ������ �߰�
		�߹�ǥ��.setBounds(15, 569, 70, 70);
		contentPane.add(�߹�ǥ��);
		
		�Ĺ�ǥ��.setIcon(new ImageIcon("image/�Ĺ�.jpg")); //�Ĺ�ǥ�� ������ �߰�
		�Ĺ�ǥ��.setBounds(30, 76, 70, 70);
		contentPane.add(�Ĺ�ǥ��);
		
		
		����ǥ��.setIcon(new ImageIcon("image/����.jpg")); //����ǥ�� ������ �߰�
		����ǥ��.setBounds(385, 139, 70, 70);
		contentPane.add(����ǥ��);
		
		
		����ǥ��.setIcon(new ImageIcon("image/����.jpg")); //����ǥ�� ������ �߰�
		����ǥ��.setBounds(404, 569, 70, 70);
		contentPane.add(����ǥ��);
		
		MyItemListener listener = new MyItemListener(); //ItemListener ���
		
		����.setBackground(Color.ORANGE);
		����.setBounds(335, 162, 28, 23); //���� üũ�ڽ� ũ�⼳��
		����.addItemListener(listener); //üũ�ڽ��� ������ ������ ��� 
		if(locWest==true) {
			����.setSelected(true); //���õ�ä�� ����
		}else
		{
			����.setSelected(false); //�������� ��ä�� ����
		}
		contentPane.add(����); //�гο� �߰�
		
		�߹�.setBackground(Color.ORANGE);
		�߹�.setBounds(15, 637, 63, 23); //�߹� üũ�ڽ� ũ�⼳��
		�߹�.addItemListener(listener); //üũ�ڽ��� ������ ������ ���
		if(locMiddle==true) {
			�߹�.setSelected(true); //���õ�ä�� ����
		}else
		{
			�߹�.setSelected(false); //�������� ��ä�� ����
		}
		
		����.setFont(new Font("����", Font.PLAIN, 30));
		����.setBackground(Color.ORANGE);
		����.setBounds(382, 616, 28, 23); //���� üũ�ڽ� ũ�⼳��
		����.addItemListener(listener); //üũ�ڽ��� ������ ������ ���
		if(locFront==true) {
			����.setSelected(true); //���õ�ä�� ����
		}else
		{
			����.setSelected(false); //�������� ��ä�� ����
		}		
		contentPane.add(�߹�); //�гο� �߰�
		
		�Ĺ�.setBackground(Color.ORANGE);
		�Ĺ�.setBounds(28, 152, 28, 23); //�Ĺ� üũ�ڽ� ũ�⼳��
		�Ĺ�.addItemListener(listener); //üũ�ڽ��� ������ ������ ���
		contentPane.add(�Ĺ�); //�гο� �߰�
		if(locBack==true) {
			�Ĺ�.setSelected(true); //���õ�ä�� ����
		}else
		{
			�Ĺ�.setSelected(false); //�������� ��ä�� ����
		}
		
		JLabel PlaceSetting = new JLabel("��� ����"); //�� ���� & ���� �߰�
		PlaceSetting.setHorizontalAlignment(SwingConstants.CENTER); //��� ����
		PlaceSetting.setForeground(Color.BLACK); //�۾� ���� ����
		PlaceSetting.setFont(new Font("�޸տ�����", Font.BOLD | Font.ITALIC, 50)); //��Ʈ & �۾�ũ�� ����
		PlaceSetting.setBounds(43, 21, 412, 60); //ũ�� ����
		contentPane.add(PlaceSetting); //�гο� �߰�
		contentPane.add(����); //�гο� �߰�
		
		JLabel Maps = new JLabel(""); //�� �� �߰�
		Maps.setIcon(new ImageIcon("image/map1.jpg"));//�� ������ �߰�
		Maps.setBounds(-41, 98, 515, 562); //�� ũ�⼳�� 
		contentPane.add(Maps); //�гο� �߰�
		
		Thing.setIcon(new ImageIcon("image/location.jpg"));
		Thing.setBounds(416, 20, 70, 68);
		
		contentPane.add(Thing);
		
		setVisible(true);
		
	}
	class MyItemListener implements ItemListener{ 
		public void itemStateChanged(ItemEvent e) {//üũ�ڽ��� ���� ���°� ���ϸ� ������ü���� ȣ���
			if(e.getStateChange()==ItemEvent.DESELECTED) { //Ŭ���Ͽ� üũ ���� �� ���
				if(e.getItem()==����) { //���� üũ�ڽ�
					locFront = false; 
					System.out.println("���� ���� ����");
				}
				if(e.getItem()==����) { //���� üũ�ڽ�
					locWest = false;
					System.out.println("���� ���� ����");
				}
				if(e.getItem()==�Ĺ�) { //�Ĺ� üũ�ڽ�
					locBack= false;
					System.out.println("�Ĺ� ���� ����");
				}
				if(e.getItem()==�߹�) { //�߹� üũ�ڽ�
					locMiddle = false;
					System.out.println("�߹� ���� ����");
				}
			}
			else { //�ٽ� Ŭ���Ͽ� üũ �� ���
				if(e.getItem()==����) { //���� üũ�ڽ�
					locFront = true; 
					System.out.println("���� ����");
				}
				if(e.getItem()==����) { //���� üũ�ڽ�
					locWest = true;
					System.out.println("���� ����");
				}
				if(e.getItem()==�Ĺ�) { //�Ĺ� üũ�ڽ�
					locBack= true;
					System.out.println("�Ĺ� ����");
				}
				if(e.getItem()==�߹�) { //�߹� üũ�ڽ�
					locMiddle = true;
					System.out.println("�߹� ����");
				}
			}
		}
		
	}
}
