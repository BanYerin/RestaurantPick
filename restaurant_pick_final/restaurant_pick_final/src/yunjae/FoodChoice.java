//음식선택 프레임 -2015041014 정윤재
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
	
	public static boolean foodChinese=true; //중식 체크 여부
	public static boolean foodWestern=true; //양식 체크 여부
	public static boolean foodKorean=true; //한식 체크 여부
	public static boolean foodFast=true; //패스트푸드 체크 여부
	public static boolean foodJapanese=true; //일식 체크 여부
	
	JCheckBox 한식 = new JCheckBox(""); //한식 체크박스
	JCheckBox 일식 = new JCheckBox(""); //일식 체크박스
	JCheckBox 양식 = new JCheckBox(""); //양식 체크박스
	JCheckBox 중식 = new JCheckBox(""); //중식 체크박스
	JCheckBox 패스트 = new JCheckBox(""); //패스트푸드 체크박스
	
public FoodChoice() {
		setTitle("메뉴 선택"); //프레임 제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 프로세스까지 닫음
		setSize(500,700); //사이즈 500x700
		contentPane = new JPanel(); //패널 샐성
		contentPane.setBackground(Color.ORANGE); //오렌지 색상으로 결정
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //테두리 설정
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JButton BackButton = new JButton("뒤로"); //뒤로가기 버튼
		BackButton.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		BackButton.setSize(70,40); //버튼 사이즈 설정
		BackButton.setLocation(20,20); //좌표설정
		contentPane.add(BackButton); //패널에 추가
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //뒤로가기 버튼 누를시 장소 프레임으로 넘어감(예시)
				new nayeong.SetUp(); //다시 설정 화면으로 넘어감
				System.out.println("장소설정 출력"); //실행됬나 출력문
				dispose(); //장소 프레임으로 넘어갈시 음식선택 프레임 종료
			}
		}); 
		
		JLabel FoodKindSetting = new JLabel("음식종류 설정"); //라벨추가(음식종료 설정 제목)
		FoodKindSetting.setHorizontalAlignment(SwingConstants.CENTER); //가운데 설정
		FoodKindSetting.setForeground(Color.BLACK); //글씨 검정색으로 설정
		FoodKindSetting.setFont(new Font("휴먼엑스포", Font.BOLD | Font.ITALIC, 50)); //폰트와 글씨크기 설정
		FoodKindSetting.setBounds(62, 20, 412, 60); //좌표설정
		contentPane.add(FoodKindSetting); //패널에 추가
		
		JLabel 한식이미지 =new JLabel(""); //한식 라벨 추가
		한식이미지.setIcon(new ImageIcon("image/한식.jpg")); //한식 이미지 추가
		한식이미지.setBounds(30, 90, 187, 162); //좌표설정
		contentPane.add(한식이미지); //패널에 추가
		
		JLabel 일식이미지 = new JLabel(""); //일식 라벨 추가
		일식이미지.setIcon(new ImageIcon("image/japan.jpg"));//일식 이미지 추가
		일식이미지.setBounds(282, 90, 187, 162); //좌표설정
		contentPane.add(일식이미지); //패널에 추가
		
		JLabel 양식이미지 = new JLabel(""); //양식 라벨 추가
		양식이미지.setIcon(new ImageIcon("image/양식.jpg"));//양식 이미지 추가 
		양식이미지.setBounds(30, 296, 187, 162); //좌표설정
		contentPane.add(양식이미지); //패널에 추가
		
		JLabel 중식이미지 = new JLabel(""); //중식 라벨 추가
		중식이미지.setIcon(new ImageIcon("image/china.jpg"));//중식 이미지 추가
		중식이미지.setBounds(282, 296, 187, 162); //좌표설정
		contentPane.add(중식이미지); //패널에 추가
		
		JLabel 패스트푸드 = new JLabel(""); //패스트푸드 라벨 추가
		패스트푸드.setIcon(new ImageIcon("image/FastFood.jpg"));//패스트푸드 이미지 추가
		패스트푸드.setBounds(44, 491, 187, 162); //좌표설정
		contentPane.add(패스트푸드); //패널에 추가
		
		MyItemListener listener = new MyItemListener(); //ItemListener 등록
		한식.setHorizontalAlignment(SwingConstants.CENTER); //가운데 설정
		한식.setFont(new Font("굴림", Font.PLAIN, 12)); //글씨체 설정
		한식.setBackground(Color.ORANGE); //색깔설정
		한식.setBounds(48, 247, 42, 30); //한식 좌표설정
		contentPane.add(한식);
		한식.addItemListener(listener);//체크박스에 Item리스너 등록
		if(foodKorean==true) { //boolean 체크
			한식.setSelected(true); //선택된채로 설정
		}else
		{
			한식.setSelected(false); //선택해제 된채로 설정
		}
			
		일식.setHorizontalAlignment(SwingConstants.CENTER);
		일식.setBackground(Color.ORANGE);
		일식.setBounds(292, 247, 42, 30); //일식 좌표설정
		contentPane.add(일식);
		일식.addItemListener(listener);//체크박스에 Item리스너 등록
		if(foodJapanese==true) {
			일식.setSelected(true); //선택된채로 설정
		}else
		{
			일식.setSelected(false); //선택해제 된채로 설정
		}
		
		양식.setHorizontalAlignment(SwingConstants.CENTER);
		양식.setBackground(Color.ORANGE);
		양식.setBounds(48, 455, 42, 30); //양식 좌표설정
		contentPane.add(양식);
		양식.addItemListener(listener);//체크박스에 Item리스너 등록
		if(foodWestern==true) {
			양식.setSelected(true); //선택된채로 설정
		}else
		{
			양식.setSelected(false); //선택해제 된채로 설정
		}
		
		중식.setHorizontalAlignment(SwingConstants.CENTER);
		중식.setBackground(Color.ORANGE);
		중식.setBounds(292, 455, 42, 30); //중식 좌표설정
		contentPane.add(중식);
		중식.addItemListener(listener);//체크박스에 Item리스너 등록
		if(foodChinese==true) {
			중식.setSelected(true); //선택된채로 설정
		}else
		{
			중식.setSelected(false); //선택해제 된채로 설정
		}
		
		패스트.setHorizontalAlignment(SwingConstants.CENTER);
		패스트.setBackground(Color.ORANGE);
		패스트.setBounds(228, 603, 42, 30); //패스트푸드 좌표설정
		contentPane.add(패스트);
		패스트.addItemListener(listener); //체크박스에 Item리스너 등록
		if(foodFast==true) {
			패스트.setSelected(true); //선택된채로 설정
		}else
		{
			패스트.setSelected(false); //선택해제 된채로 설정
		}
		
		JLabel KF = new JLabel("한식"); //이미지에 대한 텍스트
		KF.setHorizontalAlignment(SwingConstants.CENTER);
		KF.setFont(new Font("궁서체", Font.PLAIN, 23));
		KF.setBounds(87, 247, 95, 24);
		contentPane.add(KF);
		
		JLabel JF = new JLabel("일식");//이미지에 대한 텍스트
		JF.setHorizontalAlignment(SwingConstants.CENTER);
		JF.setFont(new Font("궁서체", Font.PLAIN, 23));
		JF.setBounds(315, 247, 95, 24);
		contentPane.add(JF);
		
		JLabel WF = new JLabel("양식");//이미지에 대한 텍스트
		WF.setHorizontalAlignment(SwingConstants.CENTER);
		WF.setFont(new Font("궁서체", Font.PLAIN, 23));
		WF.setBounds(87, 455, 95, 24);
		contentPane.add(WF);
		
		JLabel CF = new JLabel("중식");//이미지에 대한 텍스트
		CF.setHorizontalAlignment(SwingConstants.CENTER);
		CF.setFont(new Font("궁서체", Font.PLAIN, 23));
		CF.setBounds(315, 455, 95, 24);
		contentPane.add(CF);
		
		JLabel FF = new JLabel("패스트푸드");//이미지에 대한 텍스트
		FF.setHorizontalAlignment(SwingConstants.CENTER);
		FF.setFont(new Font("궁서체", Font.PLAIN, 23));
		FF.setBounds(262, 603, 138, 24);
		contentPane.add(FF);
		
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener{
		
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.DESELECTED) {//클릭하여 체크 뺴는 경우  
			if(e.getItem()==한식) { //한식 체크박스 선택시
				foodKorean = false; //한식 체크안됨
				System.out.println("한식 선택 해제"); //되는지 확인
			}
			if(e.getItem()==일식) { //일식 체크박스 선택시
				foodJapanese = false;
				System.out.println("일식 선택 해제"); //되는지 확인
			}
			if(e.getItem()==패스트) {
				foodFast = false;
				System.out.println("패스트푸드 선택 해제");
			}
			if(e.getItem()==중식) {
				foodChinese = false;
				System.out.println("중식 선택 해제");
			}
			if(e.getItem()==양식) {
				foodWestern = false;
				System.out.println("양식 선택 해제");
			}
			
		}
		else { //다시 클릭하여 체크 넣는경우
			if(e.getItem()==한식) { //한식 체크박스 선택시
				foodKorean = true;
				System.out.println("한식 선택"); //되는지 확인
			}
			if(e.getItem()==일식) { //일식 체크박스 선택시
				foodJapanese = true;
				System.out.println("일식 선택"); //되는지 확인
			}
			if(e.getItem()==패스트) {
				foodFast = true;
				System.out.println("패스트푸드 선택");
			}
			if(e.getItem()==중식) {
				foodChinese = true;
				System.out.println("중식 선택");
			}
			if(e.getItem()==양식) {
				foodWestern = true;
				System.out.println("양식 선택");
			}
		}
		
	}
	}
}
	


