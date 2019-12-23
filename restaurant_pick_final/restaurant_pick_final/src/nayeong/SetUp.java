/*
 * 만든이 : 배나영
 * 장소, 가격대, 음식 종류를 설정하는 화면으로 이동하는 설정 버튼 
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

import yerin.*; //반예린 패키지
import yunjae.*; //정윤재 패키지

public class SetUp extends JFrame {

	public SetUp() {
		setTitle("설정 메뉴 화면 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Container 초기화
		Container c=getContentPane(); 
		c.setLayout(null);
		c.setBackground(Color.ORANGE);
		
		// 설정 제목 
		JLabel title=new JLabel("설정");
		title.setBounds(183,10,158,80);
		title.setFont(new Font("휴먼엑스포", Font.BOLD | Font.ITALIC, 50));
		c.add(title);
		
		// 뒤로 버튼
		JButton bBack=new JButton("뒤로");
		bBack.setLocation(20,20);
		bBack.setSize(70, 40);
		bBack.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		c.add(bBack);
		bBack.addActionListener(new SetUpListener());
		
		// 장소, 가격대, 음식종류, Etc 버튼
		JButton place=new JButton("장소");
		place.setLocation(175, 150);
		place.setSize(150,80);
		place.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		c.add(place);
		place.addActionListener(new SetUpListener());
		
		JButton price=new JButton("가격대");
		price.setLocation(175, 300);
		price.setSize(150,80);
		price.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		c.add(price);
		price.addActionListener(new SetUpListener());
		
		JButton type=new JButton("음식 종류");
		type.setLocation(175, 450);
		type.setSize(150,80);
		type.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		c.add(type);
		type.addActionListener(new SetUpListener());
		
		
		
		// 화면 사이즈 
		setSize(500,700);
		setVisible(true);
		
		
	}
	
	class SetUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// 어느 버튼이 눌리느냐에 따라 다른 이벤트 
			JButton b=(JButton) e.getSource();
			if(b.getText().equals("뒤로")) {
				System.out.println("뒤로 가는 이벤트");
				new yerin.PickRandom();
				setVisible(false);

			}
			if(b.getText().equals("장소")) {
				System.out.println("장소 이벤트");
				new yunjae.Place();
				setVisible(false);
			}
				
			if(b.getText().equals("가격대")) {
				System.out.println("가격대 이벤트");
				new nayeong.PriceSetUp();
				setVisible(false);
			}
			if(b.getText().equals("음식 종류")) {
				System.out.println("음식종류 이벤트");
				new yunjae.FoodChoice();
				setVisible(false);
			}
			
		}
	}
}

