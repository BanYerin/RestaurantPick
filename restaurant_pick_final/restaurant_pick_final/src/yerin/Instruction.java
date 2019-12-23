/*
 만든이: 2017038023 반예린
 해당 소스파일 정보: -사용방법 설명 화면(GUI, 이벤트처리) -> 프로그램에 대한 정보 및 사용방법 출력
 */

package yerin;

import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import yunjae.*; //정윤재 패키지
import nayeong.*; //배나영 패키지

//**사옹방법 설명화면 구현 클래스**
public class Instruction extends JFrame {
	
	//**생성자. 초기에 필요한 준비작업 수행**
	public Instruction() {
		//**GUI화면 준비 작업**
		setTitle("사용방법");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Container c=getContentPane();
		 c.setLayout(null);
		 
		 //"사용방법" 문자열 레이블
		 JLabel textLab1=new JLabel("사용 방법");
		 textLab1.setFont(new Font("휴먼엑스포", Font.BOLD | Font.ITALIC, 50));
		 textLab1.setSize(257, 50);
		 textLab1.setLocation(132, 20);
		 
		//뒤로 버튼 생성 및 설정
		JButton backBtn=new JButton("뒤로");
		
		backBtn.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		backBtn.setSize(70, 40);
		backBtn.setLocation(20, 20);
		backBtn.addActionListener(new MyActionListener()); //액션이벤트 리스너 연결
		
		//사용방법 설명 텍스트창 생성 및 설정
		JTextArea InstructionText=new JTextArea(14, 40); //사용방법 텍스트창 생성
		JScrollPane Instscroll=new JScrollPane(InstructionText); //사용방법 텍스트창을 스크롤바 판에 붙임
		
		//빈 텍스트창에 사용방법 설명 추가
		InstructionText.append("1. 메인화면의 \"음식점 랜덤 뽑기\"버튼을 누르면 \n음식점 랜덤 뽑기 화면으로 넘어갑니다.\n\n"
				+ "2. \"설정\"버튼을 누르면 랜덤으로 뽑을 음식점의 장소, 음식의 가격대, 음식종류\n 등을 설정할 수 있습니다. 장소설정과 음식종류 설정은 중복선택이 가능하고, \n초기의 기본 설정값 범위가 \"전체\"이며, 제외하고 싶은 것을 누르면 \n설정값 범위에서 제외됩니다.\n\n"
				+ "3. \"뽑기\"버튼을 누르면 설정된 범위 내에서 랜덤으로 음식점을 뽑아서 \n해당 음식점의 지도URL과 함께 결과를 출력해줍니다.\n\n"
				+ "4. 뽑힌 음식점이 마음에 들지 않으면 \"다시 뽑기\"를 클릭하여 음식점을 \n다시 뽑을 수 있습니다.\n\n\n\n"
				+ "※참고: 사용자가 설정한 설정값(음식점 장소, 음식 가격대, 음식종류)에 \n해당하는 음식점이 존재하지 않을 경우, 뽑기결과 화면에 \n'설정값에 해당하는 음식점이 존재하지 않음'을 알리는 문구가 출력됩니다.\n이런 경우, 설정값들을 적절히 재조정 해주시고 다시 뽑아주세요!\n\n\n\n\n"
				+ "\t~~~ 즐거운 식사 시간 되세요 (> ω <) ~~~");
		InstructionText.setEditable(false); //사용방법 설명 창의 내용을 사용자가 수정할 수 없도록 설정
		Instscroll.setSize(400, 500);
		Instscroll.setLocation(50, 100);
		
		
		 //컨텐트팬에 컴포넌트 부착
		 c.add(textLab1);
		 c.add(backBtn);
		 c.add(Instscroll);
		 
		 //프레임 설정
		 c.setBackground(Color.ORANGE);
		 setSize(500, 700);
		 setVisible(true);
	}

	
	//**각각의 버튼이 클릭되면 해당하는 기능을 수행하는 Action리스너**
		private class MyActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JButton sourceBtn=(JButton)e.getSource();
				
				//뒤로 버튼을 누르면 이전화면인 메인화면으로 넘어감
				if(sourceBtn.getText().equals("뒤로")) {	
					System.out.println("뒤로버튼 이벤트 동작"); //버튼 눌렀을때 해당하는 이벤트가 동작하는지 여부 확인하기위한 확인용 출력코드
					
					//메인 화면으로 넘어감
					new yunjae.Menu();
					setVisible(false);
				}
			}
		}
		
		

}
