/*
 * 만든이 : 배나영
 * JSlider를 이용하여 최저, 최고 가격을 설정하는 화면 
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

import yerin.*; //반예린 패키지
import yunjae.*; //정윤재 패키지

public class PriceSetUp extends JFrame {
	// 가격 정보를 설정하는 화면 
	
	public static int min=0 ,max=100000; // 최소 가격, 최대 가격을 저장할 변수
	JSlider minslider; // 최소 Slider
	JSlider maxslider; // 최대 Slider
	
	public PriceSetUp() {
		
		// 가격대 설정 화면 초기화 
		setTitle("가격대 설정 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		
		// 화면 배경색
		c.setBackground(Color.ORANGE);
		
		// 가격대 설정 제목 
		JLabel title=new JLabel("가격대 설정");
		title.setBounds(102,10,300,80);
		title.setFont(new Font("휴먼엑스포", Font.BOLD | Font.ITALIC, 50));
		c.add(title);
		
		// 뒤로 버튼 생성
		JButton bBack=new JButton("뒤로");
		bBack.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		bBack.setLocation(20,20);
		bBack.setSize(70, 40);
		c.add(bBack);
		bBack.addActionListener(new PriceSetUpListener());
		
		JLabel minTitle=new JLabel("최소 가격");
		minTitle.setBounds(80,590,400,80);
		minTitle.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 20));
		c.add(minTitle);
		
		// 최소값 JSlider
		minslider=new JSlider(JSlider.VERTICAL,0,100000,min);
		minslider.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 12));
		minslider.setLocation(50, 90);
		minslider.setPaintLabels(true);
		minslider.setPaintTicks(true);
		minslider.setMinorTickSpacing(2000);
		minslider.setMajorTickSpacing(10000);
		minslider.setSize(150, 520);
		minslider.setForeground(Color.BLUE);
		minslider.addChangeListener(new MyChangeListener());
		
		JLabel maxTitle=new JLabel("최대 가격");
		maxTitle.setBounds(325,590,400,80);
		maxTitle.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 20));
		c.add(maxTitle);
		
		// 최대값 JSlider
		maxslider=new JSlider(JSlider.VERTICAL,0,100000,max);
		maxslider.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 12));
		maxslider.setLocation(300, 90);
		maxslider.setPaintLabels(true);
		maxslider.setPaintTicks(true);
		maxslider.setMinorTickSpacing(2000);
		maxslider.setMajorTickSpacing(10000);
		maxslider.setSize(150, 520);
		maxslider.setForeground(Color.RED);
		maxslider.addChangeListener(new MyChangeListener());
		
		// Container에 올려주기
		c.add(minslider);
		c.add(maxslider);
		
		// Container 사이즈 
		setSize(500,700);
		setVisible(true);
		
	}
	
	class MyChangeListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// 슬라이더 값 가져오기
			min=minslider.getValue();
			max=maxslider.getValue();
			
			// 최소값, 최댓값 제대로 받았는지 확인 
			System.out.println("최소값 : "+min);
			System.out.println("최댓값 : "+max);
		}
		
	}

	
	class PriceSetUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b=(JButton) e.getSource();
			if(b.getText().equals("뒤로")) {
				System.out.println("뒤로 가는 이벤트");
				new nayeong.SetUp();
				setVisible(false);
			}
			
		}
		
	}
	
}


