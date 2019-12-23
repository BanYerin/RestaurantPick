//장소 프레임 -2015041014 정윤재
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
	
	public static boolean locMiddle=true; //중문 체크 여부
	public static boolean locFront=true; //정문 체크 여부
	public static boolean locBack=true; //후문 체크 여부
	public static boolean locWest=true; //서문 체크 여부
	
	JCheckBox 정문 = new JCheckBox(""); //정문 체크박스
	JCheckBox 중문 = new JCheckBox(""); //중문 체크박스
	JCheckBox 서문 = new JCheckBox(""); //서문 체크박스
	JCheckBox 후문 = new JCheckBox(""); //후문 체크박스 
	private final JLabel Thing = new JLabel("");
	private final JLabel 정문표시 = new JLabel("");
	private final JLabel 서문표시 = new JLabel("");
	private final JLabel 후문표시 = new JLabel("");
	private final JLabel 중문표시 = new JLabel("");
	
	public Place() {
		
		setTitle("장소 선택"); //프레임 제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 프로세스까지 닫음
		setSize(500,700); //프레임 사이즈설정
		
		contentPane = new JPanel(); //패널 생성
		contentPane.setBackground(Color.ORANGE); //패널 색상 오렌지로 결정
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //테두리설정
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BackButton = new JButton("뒤로"); //뒤로버튼 생성
		BackButton.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		BackButton.setSize(70,40); //사이즈 설정
		BackButton.setLocation(20,20); //위치 설정
		contentPane.add(BackButton); //패널에 추가
		
		
		BackButton.addActionListener(new ActionListener() { //뒤로가기 버튼 누를시
			public void actionPerformed(ActionEvent Arg0) {
				new nayeong.SetUp(); //설정화면으로 돌아감
				dispose(); //전에있던 프레임 삭제
			}
		});
		
		중문표시.setIcon(new ImageIcon("image/중문.jpg"));//중문표시 아이콘 추가
		중문표시.setBounds(15, 569, 70, 70);
		contentPane.add(중문표시);
		
		후문표시.setIcon(new ImageIcon("image/후문.jpg")); //후문표시 아이콘 추가
		후문표시.setBounds(30, 76, 70, 70);
		contentPane.add(후문표시);
		
		
		서문표시.setIcon(new ImageIcon("image/서문.jpg")); //서문표시 아이콘 추가
		서문표시.setBounds(385, 139, 70, 70);
		contentPane.add(서문표시);
		
		
		정문표시.setIcon(new ImageIcon("image/정문.jpg")); //정문표시 아이콘 추가
		정문표시.setBounds(404, 569, 70, 70);
		contentPane.add(정문표시);
		
		MyItemListener listener = new MyItemListener(); //ItemListener 등록
		
		서문.setBackground(Color.ORANGE);
		서문.setBounds(335, 162, 28, 23); //서문 체크박스 크기설정
		서문.addItemListener(listener); //체크박스에 아이템 리스너 등록 
		if(locWest==true) {
			서문.setSelected(true); //선택된채로 설정
		}else
		{
			서문.setSelected(false); //선택해제 된채로 설정
		}
		contentPane.add(서문); //패널에 추가
		
		중문.setBackground(Color.ORANGE);
		중문.setBounds(15, 637, 63, 23); //중문 체크박스 크기설정
		중문.addItemListener(listener); //체크박스에 아이템 리스너 등록
		if(locMiddle==true) {
			중문.setSelected(true); //선택된채로 설정
		}else
		{
			중문.setSelected(false); //선택해제 된채로 설정
		}
		
		정문.setFont(new Font("굴림", Font.PLAIN, 30));
		정문.setBackground(Color.ORANGE);
		정문.setBounds(382, 616, 28, 23); //정문 체크박스 크기설정
		정문.addItemListener(listener); //체크박스에 아이템 리스너 등록
		if(locFront==true) {
			정문.setSelected(true); //선택된채로 설정
		}else
		{
			정문.setSelected(false); //선택해제 된채로 설정
		}		
		contentPane.add(중문); //패널에 추가
		
		후문.setBackground(Color.ORANGE);
		후문.setBounds(28, 152, 28, 23); //후문 체크박스 크기설정
		후문.addItemListener(listener); //체크박스에 아이템 리스너 등록
		contentPane.add(후문); //패널에 추가
		if(locBack==true) {
			후문.setSelected(true); //선택된채로 설정
		}else
		{
			후문.setSelected(false); //선택해제 된채로 설정
		}
		
		JLabel PlaceSetting = new JLabel("장소 설정"); //라벨 생성 & 제목 추가
		PlaceSetting.setHorizontalAlignment(SwingConstants.CENTER); //가운데 설정
		PlaceSetting.setForeground(Color.BLACK); //글씨 색상 결정
		PlaceSetting.setFont(new Font("휴먼엑스포", Font.BOLD | Font.ITALIC, 50)); //폰트 & 글씨크기 설정
		PlaceSetting.setBounds(43, 21, 412, 60); //크기 설정
		contentPane.add(PlaceSetting); //패널에 추가
		contentPane.add(정문); //패널에 추가
		
		JLabel Maps = new JLabel(""); //맵 라벨 추가
		Maps.setIcon(new ImageIcon("image/map1.jpg"));//맵 아이콘 추가
		Maps.setBounds(-41, 98, 515, 562); //맵 크기설정 
		contentPane.add(Maps); //패널에 추가
		
		Thing.setIcon(new ImageIcon("image/location.jpg"));
		Thing.setBounds(416, 20, 70, 68);
		
		contentPane.add(Thing);
		
		setVisible(true);
		
	}
	class MyItemListener implements ItemListener{ 
		public void itemStateChanged(ItemEvent e) {//체크박스의 선택 상태가 변하면 아이템체인지 호출됨
			if(e.getStateChange()==ItemEvent.DESELECTED) { //클릭하여 체크 해제 할 경우
				if(e.getItem()==정문) { //정문 체크박스
					locFront = false; 
					System.out.println("정문 선택 해제");
				}
				if(e.getItem()==서문) { //서문 체크박스
					locWest = false;
					System.out.println("서문 선택 해제");
				}
				if(e.getItem()==후문) { //후문 체크박스
					locBack= false;
					System.out.println("후문 선택 해제");
				}
				if(e.getItem()==중문) { //중문 체크박스
					locMiddle = false;
					System.out.println("중문 선택 해제");
				}
			}
			else { //다시 클릭하여 체크 할 경우
				if(e.getItem()==정문) { //정문 체크박스
					locFront = true; 
					System.out.println("정문 선택");
				}
				if(e.getItem()==서문) { //서문 체크박스
					locWest = true;
					System.out.println("서문 선택");
				}
				if(e.getItem()==후문) { //후문 체크박스
					locBack= true;
					System.out.println("후문 선택");
				}
				if(e.getItem()==중문) { //중문 체크박스
					locMiddle = true;
					System.out.println("중문 선택");
				}
			}
		}
		
	}
}
