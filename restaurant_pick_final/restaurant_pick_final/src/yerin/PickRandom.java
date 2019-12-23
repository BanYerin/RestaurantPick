/*
 ������: 2017038023 �ݿ���
 �ش� �ҽ����� ����: -������ ���� �̱� ȭ��(GUI, �̺�Ʈó��)
 			  -������ ���̽� �̿��� ���� �̱� ��� -> ��ü ������ ���� ���ڵ�� �� ���,��������,���ݴ뿡 ���� �������� �ش��ϴ� ���ڵ���� ������ ��, �� ���ڵ���� �������� �Ѱ��� ���ڵ带 �����Ͽ� �����ü�� �־���			
���� ������: 18/11/21
 */

package yerin;

import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import yunjae.*; //������ ��Ű��
import nayeong.*; //�質�� ��Ű��

//**���� �̱� ȭ�� ����, �̱� ��� ������ Ŭ����**
public class PickRandom extends JFrame{
	Connection conn;
	Statement stmt=null;
	static ResultSet randomResult=null; //�������� ���� �����ü. �ʵ�� ĸ��ȭ�°��� �����ϹǷ� �ٸ� Ŭ�������� �� �ʵ��� ���� ��°��� �޼ҵ带 �̿��ϵ��� ����.
	
	/*
	//��Ҽ��� üũ ���� ����.�׽�Ʈ�� ���� �ӽ÷� ��������, �����δ� ��Ҽ��� ��Ʈ���� ������ �޾ƽ����.
	boolean locMiddle=true; //�߹� üũ ����
	boolean locFront=true; //���� üũ ����
	boolean locBack=false; //�Ĺ� üũ ����
	boolean locWest=false; //���� üũ ����
	
	//�������� ���� üũ���� ����. �׽�Ʈ�� ���� �ӽ÷� ��������, �����δ� ������������ ��Ʈ���� ������ �޾ƽ����.
	boolean foodChinese=true; //�߽� üũ ����
	boolean foodWestern=false; //��� üũ ����
	boolean foodKorean=true; //�ѽ� üũ ����
	boolean foodFast=true; //�н�ƮǪ�� üũ ����
	boolean foodJapanese=false; //�Ͻ� üũ ����
	
	//���� ���� ���� ����. �׽�Ʈ�� ���� �ӽ÷� ��������, �����δ� ���ݼ��� ��Ʈ���� ������ �޾ƽ����.
	int setMinPrice=1000; //�������� ������
	int setMaxPrice=30000; //�ְ��� ������
	*/
	

	
	//**������. �ʱ⿡ �ʿ��� �غ��۾� ����**
	public PickRandom(){
		//**�����ͺ��̽� ���� �۾�** @@�ӽ÷� ����DB �����Ѱ��̹Ƿ� ���� ���� DB�� URL �ٽ� ���� �������@@
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //MySQL ����̹� �ε�
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurant_info?allowMultiQueries=true&useSSL=false&serverTimezone=Asia/Seoul", "javaProject", "java123123123"); //JDBC ����
					System.out.println("DB ���� �Ϸ�");
					stmt = conn.createStatement();
		 	} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		 	} catch (SQLException e) {
			System.out.println("DB ���� ����");
		}
		 
		 
		 //**GUIȭ�� �غ� �۾�**
		 setTitle("�����̱�");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Container c=getContentPane();
		 c.setLayout(null);
		 
		 //"������ ���� �̱�" ���ڿ� ���̺�
		 JLabel textLab1=new JLabel("������ ���� �̱�");
		 textLab1.setFont(new Font("�޸տ�����", Font.BOLD, 30));
		 textLab1.setSize(280, 100);
		 textLab1.setLocation(120, 5);
		 
		 //�̹��� ���̺�
		 ImageIcon img1=new ImageIcon("image/��Դ°����.gif");
		 JLabel imageLab1=new JLabel(img1);
		 imageLab1.setSize(400, 400);
		 imageLab1.setLocation(35, 70);
		 
		//�ڷ� ��ư ���� �� ����
		JButton backBtn=new JButton("�ڷ�");
		backBtn.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		backBtn.setSize(70, 40);
		backBtn.setLocation(20, 20);
		backBtn.addActionListener(new MyActionListener()); //�׼��̺�Ʈ ������ ����
		 
		//���� ��ư ���� �� ����
		JButton settingBtn=new JButton("����");
		settingBtn.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 15));
		settingBtn.setSize(70, 40);
		settingBtn.setLocation(390, 20);
		settingBtn.addActionListener(new MyActionListener()); //�׼��̺�Ʈ ������ ����

		 //�����̱� ��ư ���� �� ����
		 JButton RandomBtn=new JButton("�̱�");
		 RandomBtn.setBackground(Color.CYAN);
		 RandomBtn.setFont(new Font("�ü�ü", Font.BOLD | Font.ITALIC, 30));
		 RandomBtn.setSize(100, 50);
		 RandomBtn.setLocation(188, 511);
		 RandomBtn.addActionListener(new MyActionListener()); //�׼��̺�Ʈ ������ ����
			
		 //����Ʈ�ҿ� ������Ʈ ����
		 c.add(textLab1);
		 c.add(imageLab1);
		 c.add(backBtn);
		 c.add(settingBtn);
		 c.add(RandomBtn);
		 
		 //������ ����
		 c.setBackground(Color.ORANGE);
		 setSize(500, 700);
		 setVisible(true);
	}
	
	
	//**�����̱� ��� �޼ҵ�ν�, �������� �ش��ϵ��� ���͸� �� ���͸��� ���ڵ���� �������� �� ���ڵ带 �����Ͽ� �����ü�� ����** @@���� �̿ϼ�@@
	void pickRandom() {
		//----------------------------------------------------------------------------
		
		//��Ҽ��� üũ ���� ����. ��Ҽ��� ��Ʈ���� �޾ƿ� ���������� �ʱ�ȭ
		boolean locMiddle=Place.locMiddle; //�߹� üũ ����
		boolean locFront=Place.locFront; //���� üũ ����
		boolean locBack=Place.locBack; //�Ĺ� üũ ����
		boolean locWest=Place.locWest; //���� üũ ����
		
		//�������� ���� üũ���� ����. ������������ ��Ʈ���� �޾ƿ� ���������� �ʱ�ȭ
		boolean foodChinese=FoodChoice.foodChinese; //�߽� üũ ����
		boolean foodWestern=FoodChoice.foodWestern; //��� üũ ����
		boolean foodKorean=FoodChoice.foodKorean; //�ѽ� üũ ����
		boolean foodFast=FoodChoice.foodFast; //�н�ƮǪ�� üũ ����
		boolean foodJapanese=FoodChoice.foodJapanese; //�Ͻ� üũ ����
		
		//���� ���� ���� ����. ���İ��ݼ��� ��Ʈ���� �޾ƿ� ���������� �ʱ�ȭ
		int setMinPrice=PriceSetUp.min; //�������� ������
		int setMaxPrice=PriceSetUp.max; //�ְ��� ������
		
		
		
		System.out.println("*�̱�ȭ�鿡�� �������� �Ҹ��Ȱ� Ȯ�ο�*");
		if(FoodChoice.foodChinese==true)
			System.out.println("�߽� true");
		else
			System.out.println("�߽� false");
		
		if(FoodChoice.foodWestern==true)
			System.out.println("��� true");
		else
			System.out.println("��� false");
		
		if(FoodChoice.foodKorean==true)
			System.out.println("�ѽ� true");
		else
			System.out.println("�ѽ� false");
		
		if(FoodChoice.foodFast==true)
			System.out.println("�н�Ʈ true");
		else
			System.out.println("�н�Ʈ false");
		
		if(FoodChoice.foodJapanese==true)
			System.out.println("�Ͻ� true");
		else
			System.out.println("�Ͻ� false");
		
		System.out.println("*�̱�ȭ�鿡�� ��� �Ҹ��Ȱ� Ȯ�ο�*");
		if(Place.locMiddle==true)
			System.out.println("�߹� true");
		else
			System.out.println("�߹� false");
		
		if(Place.locFront==true)
			System.out.println("���� true");
		else
			System.out.println("���� false");
		
		if(Place.locBack==true)
			System.out.println("�Ĺ� true");
		else
			System.out.println("�Ĺ� false");
		
		if(Place.locWest==true)
			System.out.println("���� true");
		else
			System.out.println("���� false");
		
		
		System.out.println("*�̱�ȭ�鿡�� ���ݹ��� Ȯ�ο�*\n min: "+PriceSetUp.min+" max: "+PriceSetUp.max);
		
		//-------------------------------------------------------------------------------
		
		try {
			ResultSet rs=null; //�ʱ�ȭ
			
			stmt.executeUpdate("delete from res1_1"); //�̱⸦ ���� �Ҷ����� ������ res1_1�� ����ִ� ���ڵ���� �����Ͽ� �����
			stmt.executeUpdate("delete from res1_2"); //�̱⸦ ���� �Ҷ����� ������ res1_2�� ����ִ� ���ڵ���� �����Ͽ� �����
			stmt.executeUpdate("delete from res1_3"); //�̱⸦ ���� �Ҷ����� ������ res1_3�� ����ִ� ���ڵ���� �����Ͽ� �����
			
			//**��ġ ������� �ش��ϴ� ���ڵ����  res1���κ��� �����Ͽ� res1_1�� �߰���: res1���̺��� ��ġ������� ���͸��� ���ڵ�鸸 res1_1���̺� �־���**
			//�߹��� üũ�� ���¸� "�߹�"�� �ش��ϴ� ������ ���� ���ڵ���� res1���κ��� �����Ͽ� res1_1�� �߰���
			if(locMiddle==true) {
				stmt.executeUpdate("insert into res1_1 select * from res1 where location='�߹�'");
			}
			//������ üũ�� ���¸� "����"�� �ش��ϴ� ������ ���� ���ڵ���� res1���κ��� �����Ͽ� res1_1�� �߰���
			if(locFront==true) {
				stmt.executeUpdate("insert into res1_1 select * from res1 where location='����'");
			}
			//�Ĺ��� üũ�� ���¸� "�Ĺ�"�� �ش��ϴ� ������ ���� ���ڵ���� res1���κ��� �����Ͽ� res1_1�� �߰���
			if(locBack==true) {
				stmt.executeUpdate("insert into res1_1 select * from res1 where location='�Ĺ�'");
			}
			//������ üũ�� ���¸� "����"�� �ش��ϴ� ������ ���� ���ڵ���� res1���κ��� �����Ͽ� res1_1�� �߰���
			if(locWest==true) {
				stmt.executeUpdate("insert into res1_1 select * from res1 where location='����'");
			}
			
			
			//**�������� ������� �ش��ϴ� ���ڵ����  res1_1���κ��� �����Ͽ� res1_2�� �߰���: res1_1���̺��� �������� ������� ���͸��� ���ڵ�鸸 res1_2���̺� �־���**
			//�߽� üũ�� ���¸� "�߽�"�� �ش��ϴ� ������ ���� ���ڵ���� res1_1���κ��� �����Ͽ� res1_2�� �߰���
			if(foodChinese==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='�߽�'");
			}
			//��� üũ�� ���¸� "���"�� �ش��ϴ� ������ ���� ���ڵ���� res1_1���κ��� �����Ͽ� res1_2�� �߰���
			if(foodWestern==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='���'");
			}
			//�ѽ� üũ�� ���¸� "�ѽ�"�� �ش��ϴ� ������ ���� ���ڵ���� res1_1���κ��� �����Ͽ� res1_2�� �߰���
			if(foodKorean==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='�ѽ�'");
			}
			//�н�ƮǪ�� üũ�� ���¸� "���"�� �ش��ϴ� ������ ���� ���ڵ���� res1_1���κ��� �����Ͽ� res1_2�� �߰���
			if(foodFast==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='�н�ƮǪ��'");
			}
			//�Ͻ� üũ�� ���¸� "���"�� �ش��ϴ� ������ ���� ���ڵ���� res1_1���κ��� �����Ͽ� res1_2�� �߰���
			if(foodJapanese==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='�Ͻ�'");
			}
			
			
			//**���ݹ��� ������� �ش��ϴ� ���ڵ����  res1_2���κ��� �����Ͽ� res1_3�� �߰���: res1_2���̺��� ���ݹ��� ������� ���͸��� ���ڵ�鸸 res1_3���̺� �־���**
			//(������ �������� >= �������� ������) && (������ �ְ��� <= �ְ��� ������)�� �ش��ϴ� ������ ���� ���ڵ���� res1_2�κ��� �����Ͽ� res1_3�� �߰���
			stmt.executeUpdate("insert into res1_3 select * from res1_2 where (minPrice>=" + setMinPrice +")" + " and (maxPrice<=" + setMaxPrice + ")");
			
			
			//**��� ���͸��� ��ģ ���ڵ�鸸 ����ִ� res1_3�κ��� �������� �Ѱ��� ���ڵ带 �����Ͽ� �����ü�� ����**
			rs=stmt.executeQuery("select * from res1_3 order by rand() limit 1;");
			
			
			//**������ ���� ���� �ش��ϴ� ���ڵ� ���� ���θ� �˱� ���� �̱����� ���� ���ڵ� ������ �˾Ƴ�, ���ڵ� ������ 0�� �ƴϸ� � ���ڵ尡 ����Ǿ����� Ȯ����**
			//�����̱� ����� ���� ���ڵ��� ������ �˾Ƴ�. ������ ���� ���� �ش��ϴ� ���ڵ尡 ������ numOfRow=0, ������ numOfRow=1��.
			ResultSetMetaData md=rs.getMetaData(); //�����ü�� ���� ��Ÿ�����͸� ����
			rs.last(); //���� �� ���������� �̵�
			int numOfRow=rs.getRow(); //���ǰ���(���ڵ��� ����)�� �˾Ƴ��� numOfRow�� ����
			rs.beforeFirst(); //�ٽ� ���� ó������ �̵�
			
			if(numOfRow==0) {//������ ���� ���� �ش��ϴ� ���ڵ尡 ��� �����̱� ����� ���� ���ڵ尡 �������� �ʴ� ���(row�� ������ 0�� ���)
				//Ȯ�ο� �˸����� ���, rs��  null�� ����
				System.out.println("������ ���� ���� �ش��ϴ� ���ڵ尡 �������� ���� -> �������� �ش��ϴ� �������� �������� �ʽ��ϴ�. ������ ������ �ٽ� �̱� �ϼ���");
				rs=null;
			}else if(numOfRow>0) {//������ ���� ���� �ش��ϴ� ���ڵ尡 �־ �����̱� ����� ���� ���ڵ尡 �����ϴ� ���(row�� ������ 1�̻��� ���)
				//Ȯ�ο� �˸����� ���, �ش� ���ڵ忡 �����ϴ� ���ĸ޴����� �Ѱ��� �޴��� �������� �̾� randomMenuResult�� ����
				while(rs.next()) {
					//����� ���ڵ忡 �����ϴ� ������ ����(���ĸ޴� ���� ����) Ȯ�ο� ���� ���
					System.out.println("������� ����� ������ ���� ���ڵ�: " + rs.getString("name") + " " + rs.getString("location") + " " + rs.getString("foodType") + " " + rs.getString("mapURL") + " " + rs.getString("minPrice") + " " + rs.getString("maxPrice"));
				}
				rs.beforeFirst(); //�ٽ� ���� ó������ �̵�
				randomResult=rs; //��� ���͸��� ��ģ ���ڵ�鸸 ���� ���̺���, �������� ����� ���� ���ڵ尡 ���� rs��ü�� ���۷����� ����. ���� �ش��ϴ� ���ڵ尡 ������ null����.
			}
		}
		catch(SQLException e){
			System.out.println("SQL ���� ����");
		}
		
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
			//���� ��ư�� ������ ����ȭ������ �Ѿ
			if(sourceBtn.getText().equals("����")) {
				System.out.println("������ư �̺�Ʈ ����"); //��ư �������� �ش��ϴ� �̺�Ʈ�� �����ϴ��� ���� Ȯ���ϱ����� Ȯ�ο� ����ڵ�
				
				//���� ȭ������ �Ѿ
				new nayeong.SetUp();
				setVisible(false);

			}
			//�̱� ��ư�� ������ �����̱� ��� ���� �� ����� ��ȯ�޾� randomResult�� �����ϰ�, �̱� ��� ȭ������ �Ѿ
			if(sourceBtn.getText().equals("�̱�")) {	
				System.out.println("�̱��ư �̺�Ʈ ����"); //��ư �������� �ش��ϴ� �̺�Ʈ�� �����ϴ��� ���� Ȯ���ϱ����� Ȯ�ο� ����ڵ�
				
				pickRandom(); //�����̱� ��� ���Ϲ޾ƿ�

				//�̱� ��� ȭ������ �Ѿ
				new nayeong.StoreSetUp();
				setVisible(false);
			}
		}
	}
	
	//**�����̱� ��� ��ü�� �̿��� �� �ֵ��� �����Ͽ� ���ִ� �޼ҵ��, �ٸ� ��� Ŭ�������� ���� ����**
	public static ResultSet getRandomResult() {
		//����ڰ� ������ ������ ������ �ش��ϴ� ���ڵ尡 ������ �����̱� ��� ��ü�� null�� �ƴϰ�, ���� ������� ������ ������ �ش��ϴ� ���ڵ尡 ������� �����̱� ��� ��ü�� null.
		return randomResult;
	}
	

	
	
}
