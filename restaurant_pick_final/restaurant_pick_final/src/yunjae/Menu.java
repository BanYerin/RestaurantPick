//프로그램 시작시 랜덤뽑기 or 사용방법 나오는 메뉴 -2015041014 정윤재
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

public class Menu extends JFrame { //메뉴함수 ->MAIN.java에서 부름	
	
	private JPanel contentPane;
	
public Menu() {
		setTitle("메인 메뉴"); //Jframe 이름
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 프로세스까지 닫음
		setSize(500,700); //프레임 사이즈 설정

		contentPane = new JPanel(); //패널 설정
		contentPane.setBackground(Color.ORANGE); //오렌지 색으로 설정
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //테두리 설정
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton HowToUse = new JButton(""); //사용방법  버튼
		HowToUse.addMouseListener(new MouseAdapter() { //사용방법 마우스 액션
			@Override
			public void mouseEntered(MouseEvent arg0) { //마우스 갖다댈시에 바뀌는 아이콘
				HowToUse.setIcon(new ImageIcon("image/사용방법.jpg"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) { //마우스 떼면 바뀌는 아이콘
				HowToUse.setIcon(new ImageIcon("image/사용방법투명.jpg"));
			}
		});
		HowToUse.setIcon(new ImageIcon("image/사용방법투명.jpg")); //사용방법 디폴트 아이콘
		HowToUse.setBorderPainted(false); //테두리 투명표시
		HowToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //사용방법 아이콘 클릭시
				new yerin.Instruction();  //사용방법 프레임으로 넘어감
				System.out.println("음식종류 출력"); //실행이 됬나 확인 출력문
				dispose(); //사용방법 프레임 나올시 전에 있던 메뉴 프레임 없어짐
			}
		});
		HowToUse.setBounds(151, 408, 172, 166); //좌표설정 
		contentPane.add(HowToUse);
		
		JButton Random = new JButton(""); //랜덤뽑기 버튼
		Random.addMouseListener(new MouseAdapter() { //마우스 액션
			@Override
			public void mouseEntered(MouseEvent arg0) { //마우스 갖다댈시에 나타내지는 아이콘
				Random.setIcon(new ImageIcon("image/BOX.jpg"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) { //마우스 뗄시에 나타나지는 아이콘
				Random.setIcon(new ImageIcon("image/BOX흐린.jpg"));
			}
		});
		Random.setIcon(new ImageIcon("image/BOX흐린.jpg")); //디폴트 아이콘
		Random.setBorderPainted(false); //테두리 투명
		Random.setBounds(151, 143, 172, 188);
		Random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) { //랜덤뽑기 아이콘 클릭시
				new yerin.PickRandom(); //랜덤뽑기 프레임 창으로 넘어감
				dispose(); //랜덤뽑기 프레임창 나올시, 전에있던 프레임 없어짐
			}
		});
		contentPane.add(Random);
		
		JLabel Topic = new JLabel("오늘 뭐 먹지?"); //라벨추가 (메뉴 제목)
		Topic.setForeground(Color.BLACK); //글씨 검정색으로 설정
		Topic.setFont(new Font("휴먼엑스포", Font.BOLD | Font.ITALIC, 50)); //폰트와 글씨크기 설정
		Topic.setHorizontalAlignment(SwingConstants.CENTER); //가운데 설정
		Topic.setBounds(40, 41, 412, 60);  //좌표설정
		contentPane.add(Topic); //패널에 추가
		
		JLabel Pick = new JLabel("음식점 랜덤뽑기"); //라벨추가 (랜덤뽑기)
		Pick.setHorizontalAlignment(SwingConstants.CENTER);
		Pick.setForeground(Color.BLACK);
		Pick.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 25));
		Pick.setBounds(40, 341, 412, 60);
		contentPane.add(Pick);
		
		JLabel How_to_use = new JLabel("사용 방법"); //라벨추가(사용방법)
		How_to_use.setHorizontalAlignment(SwingConstants.CENTER);
		How_to_use.setForeground(Color.BLACK);
		How_to_use.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 25));
		How_to_use.setBounds(29, 584, 412, 60);
		contentPane.add(How_to_use);
		
		setVisible(true);
	}
}
