/*
 * 만든이 : 배나영
 * 랜덤으로 뽑은 내용을 가져와서 출력해주는 화면
 */

package nayeong;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

import yerin.*; //반예린 패키지
import yunjae.*; //정윤재 패키지

public class StoreSetUp extends JFrame{
	
	ResultSet randomResult=null;
	
	public StoreSetUp() {
		setTitle("음식점 뽑기 결과 화면");
		
		// 화면 초기화 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.ORANGE);
		
		// 음식점 뽑기 화면 제목
		JLabel title=new JLabel("음식점 뽑기 결과");
		title.setBounds(109,10,269,80);
		title.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		c.add(title);
		
		// 설정 버튼 
		JButton bSetup=new JButton("설정");
		bSetup.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		bSetup.setLocation(390, 20);
		bSetup.setSize(70, 40);
		bSetup.addActionListener(new StoreSetUpListener());
		c.add(bSetup);
		
		// 다시 뽑기 버튼
		JButton again=new JButton("다시 뽑기");
		again.setLocation(20,540);
		again.setSize(440, 70);
		again.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 20));
		c.add(again);
		again.addActionListener(new StoreSetUpListener());
		
		// 랜덤 화면에서 정보를 받아오는 객체
		randomResult=PickRandom.getRandomResult();
		
		// 조건을 모두 충족하는 식당이 있을 경우
		if(randomResult!=null) {
			try {
				
				//추출된 레코드에 존재하는 음식점 정보 전달받은 확인용 문구
					System.out.println("뽑기 결과객체 정상적으로 전달 받음");
				
				// PickRandom 페이지에서 정보를 받아와 랜덤으로 뽑힌 식당 이름과 url 출력
				while(randomResult.next()) {
					JLabel nameLabel=new JLabel(randomResult.getString("name"));
					nameLabel.setBounds(35,440,500,40);
					nameLabel.setFont(new Font("", Font.BOLD, 25));
					
					JLabel jlabel=new JLabel("지도 url : "+randomResult.getString("mapURL"));	
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
			// 조건을 모두 충족하는 식당이 없을 경우
			JLabel jlabel=new JLabel("해당하는 식당이 없어요");
			jlabel.setBounds(70,460,500,30);
			jlabel.setFont(new Font("", Font.BOLD, 30));
			ImageIcon image =new ImageIcon("image/crying.png");
			JLabel imageLab=new JLabel(image);
			imageLab.setBounds(100, 100, 300, 300);
			c.add(jlabel);
			c.add(imageLab);
		}
		
		// 화면 사이즈
		setSize(500,700);
		setVisible(true);
	}
	

	
	class StoreSetUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton b=(JButton) e.getSource();
			if(b.getText().equals("다시 뽑기")) {
				System.out.println("홈 화면으로 이동하는 이벤트");
				new yunjae.Menu();
				setVisible(false);
			}
			if(b.getText().equals("설정")) {
				System.out.println("설정 화면으로 이동하는 이벤트");
				new nayeong.SetUp();
				setVisible(false);
			}
		}
		
	}
	
	
}

	
