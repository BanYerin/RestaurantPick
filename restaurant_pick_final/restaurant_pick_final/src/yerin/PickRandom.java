/*
 만든이: 2017038023 반예린
 해당 소스파일 정보: -음식점 랜덤 뽑기 화면(GUI, 이벤트처리)
 			  -데이터 베이스 이용한 랜덤 뽑기 기능 -> 전체 음식점 정보 레코드들 중 장소,음식종류,가격대에 대한 설정값에 해당하는 레코드들을 추출한 후, 그 레코드들중 랜덤으로 한개의 레코드를 추출하여 결과객체에 넣어줌			
최종 수정일: 18/11/21
 */

package yerin;

import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import yunjae.*; //정윤재 패키지
import nayeong.*; //배나영 패키지

//**랜덤 뽑기 화면 구현, 뽑기 기능 구현된 클래스**
public class PickRandom extends JFrame{
	Connection conn;
	Statement stmt=null;
	static ResultSet randomResult=null; //랜덤으로 뽑힌 결과객체. 필드는 캡슐화는것이 안전하므로 다른 클래스에서 이 필드의 값을 얻는것은 메소드를 이용하도록 했음.
	
	/*
	//장소설정 체크 여부 변수.테스트를 위해 임시로 설정했음, 실제로는 장소설정 파트에서 설정값 받아써야함.
	boolean locMiddle=true; //중문 체크 여부
	boolean locFront=true; //정문 체크 여부
	boolean locBack=false; //후문 체크 여부
	boolean locWest=false; //서문 체크 여부
	
	//음식종류 설정 체크여부 변수. 테스트를 위해 임시로 설정했음, 실제로는 음식종류설정 파트에서 설정값 받아써야함.
	boolean foodChinese=true; //중식 체크 여부
	boolean foodWestern=false; //양식 체크 여부
	boolean foodKorean=true; //한식 체크 여부
	boolean foodFast=true; //패스트푸드 체크 여부
	boolean foodJapanese=false; //일식 체크 여부
	
	//음식 가격 설정 변수. 테스트를 위해 임시로 설정했음, 실제로는 가격설정 파트에서 설정값 받아써야함.
	int setMinPrice=1000; //최저가격 설정값
	int setMaxPrice=30000; //최고가격 설정값
	*/
	

	
	//**생성자. 초기에 필요한 준비작업 수행**
	public PickRandom(){
		//**데이터베이스 연결 작업** @@임시로 샘플DB 연결한것이므로 차후 만든 DB로 URL 다시 연결 해줘야함@@
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurant_info?allowMultiQueries=true&useSSL=false&serverTimezone=Asia/Seoul", "javaProject", "java123123123"); //JDBC 연결
					System.out.println("DB 연결 완료");
					stmt = conn.createStatement();
		 	} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		 	} catch (SQLException e) {
			System.out.println("DB 연결 에러");
		}
		 
		 
		 //**GUI화면 준비 작업**
		 setTitle("랜덤뽑기");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Container c=getContentPane();
		 c.setLayout(null);
		 
		 //"음식점 랜덤 뽑기" 문자열 레이블
		 JLabel textLab1=new JLabel("음식점 랜덤 뽑기");
		 textLab1.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		 textLab1.setSize(280, 100);
		 textLab1.setLocation(120, 5);
		 
		 //이미지 레이블
		 ImageIcon img1=new ImageIcon("image/밥먹는고양이.gif");
		 JLabel imageLab1=new JLabel(img1);
		 imageLab1.setSize(400, 400);
		 imageLab1.setLocation(35, 70);
		 
		//뒤로 버튼 생성 및 설정
		JButton backBtn=new JButton("뒤로");
		backBtn.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		backBtn.setSize(70, 40);
		backBtn.setLocation(20, 20);
		backBtn.addActionListener(new MyActionListener()); //액션이벤트 리스너 연결
		 
		//설정 버튼 생성 및 설정
		JButton settingBtn=new JButton("설정");
		settingBtn.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 15));
		settingBtn.setSize(70, 40);
		settingBtn.setLocation(390, 20);
		settingBtn.addActionListener(new MyActionListener()); //액션이벤트 리스너 연결

		 //랜덤뽑기 버튼 생성 및 설정
		 JButton RandomBtn=new JButton("뽑기");
		 RandomBtn.setBackground(Color.CYAN);
		 RandomBtn.setFont(new Font("궁서체", Font.BOLD | Font.ITALIC, 30));
		 RandomBtn.setSize(100, 50);
		 RandomBtn.setLocation(188, 511);
		 RandomBtn.addActionListener(new MyActionListener()); //액션이벤트 리스너 연결
			
		 //컨텐트팬에 컴포넌트 부착
		 c.add(textLab1);
		 c.add(imageLab1);
		 c.add(backBtn);
		 c.add(settingBtn);
		 c.add(RandomBtn);
		 
		 //프레임 설정
		 c.setBackground(Color.ORANGE);
		 setSize(500, 700);
		 setVisible(true);
	}
	
	
	//**랜덤뽑기 기능 메소드로써, 설정값에 해당하도록 필터링 후 필터링된 레코드들중 랜덤으로 한 레코드를 추출하여 결과객체에 넣음** @@아직 미완성@@
	void pickRandom() {
		//----------------------------------------------------------------------------
		
		//장소설정 체크 여부 변수. 장소설정 파트에서 받아온 설정값으로 초기화
		boolean locMiddle=Place.locMiddle; //중문 체크 여부
		boolean locFront=Place.locFront; //정문 체크 여부
		boolean locBack=Place.locBack; //후문 체크 여부
		boolean locWest=Place.locWest; //서문 체크 여부
		
		//음식종류 설정 체크여부 변수. 음식종류설정 파트에서 받아온 설정값으로 초기화
		boolean foodChinese=FoodChoice.foodChinese; //중식 체크 여부
		boolean foodWestern=FoodChoice.foodWestern; //양식 체크 여부
		boolean foodKorean=FoodChoice.foodKorean; //한식 체크 여부
		boolean foodFast=FoodChoice.foodFast; //패스트푸드 체크 여부
		boolean foodJapanese=FoodChoice.foodJapanese; //일식 체크 여부
		
		//음식 가격 설정 변수. 음식가격설정 파트에서 받아온 설정값으로 초기화
		int setMinPrice=PriceSetUp.min; //최저가격 설정값
		int setMaxPrice=PriceSetUp.max; //최고가격 설정값
		
		
		
		System.out.println("*뽑기화면에서 음식종류 불리안값 확인용*");
		if(FoodChoice.foodChinese==true)
			System.out.println("중식 true");
		else
			System.out.println("중식 false");
		
		if(FoodChoice.foodWestern==true)
			System.out.println("양식 true");
		else
			System.out.println("양식 false");
		
		if(FoodChoice.foodKorean==true)
			System.out.println("한식 true");
		else
			System.out.println("한식 false");
		
		if(FoodChoice.foodFast==true)
			System.out.println("패스트 true");
		else
			System.out.println("패스트 false");
		
		if(FoodChoice.foodJapanese==true)
			System.out.println("일식 true");
		else
			System.out.println("일식 false");
		
		System.out.println("*뽑기화면에서 장소 불리안값 확인용*");
		if(Place.locMiddle==true)
			System.out.println("중문 true");
		else
			System.out.println("중문 false");
		
		if(Place.locFront==true)
			System.out.println("정문 true");
		else
			System.out.println("정문 false");
		
		if(Place.locBack==true)
			System.out.println("후문 true");
		else
			System.out.println("후문 false");
		
		if(Place.locWest==true)
			System.out.println("서문 true");
		else
			System.out.println("서문 false");
		
		
		System.out.println("*뽑기화면에서 가격범위 확인용*\n min: "+PriceSetUp.min+" max: "+PriceSetUp.max);
		
		//-------------------------------------------------------------------------------
		
		try {
			ResultSet rs=null; //초기화
			
			stmt.executeUpdate("delete from res1_1"); //뽑기를 새로 할때마다 기존에 res1_1에 들어있던 레코드들을 삭제하여 비워줌
			stmt.executeUpdate("delete from res1_2"); //뽑기를 새로 할때마다 기존에 res1_2에 들어있던 레코드들을 삭제하여 비워줌
			stmt.executeUpdate("delete from res1_3"); //뽑기를 새로 할때마다 기존에 res1_3에 들어있던 레코드들을 삭제하여 비워줌
			
			//**위치 설정대로 해당하는 레코드들을  res1으로부터 추출하여 res1_1에 추가함: res1테이블에서 위치설정대로 필터링된 레코드들만 res1_1테이블에 넣어짐**
			//중문이 체크된 상태면 "중문"에 해당하는 음식점 정보 레코드들을 res1으로부터 추출하여 res1_1에 추가함
			if(locMiddle==true) {
				stmt.executeUpdate("insert into res1_1 select * from res1 where location='중문'");
			}
			//정문이 체크된 상태면 "정문"에 해당하는 음식점 정보 레코드들을 res1으로부터 추출하여 res1_1에 추가함
			if(locFront==true) {
				stmt.executeUpdate("insert into res1_1 select * from res1 where location='정문'");
			}
			//후문이 체크된 상태면 "후문"에 해당하는 음식점 정보 레코드들을 res1으로부터 추출하여 res1_1에 추가함
			if(locBack==true) {
				stmt.executeUpdate("insert into res1_1 select * from res1 where location='후문'");
			}
			//서문이 체크된 상태면 "서문"에 해당하는 음식점 정보 레코드들을 res1으로부터 추출하여 res1_1에 추가함
			if(locWest==true) {
				stmt.executeUpdate("insert into res1_1 select * from res1 where location='서문'");
			}
			
			
			//**음식종류 설정대로 해당하는 레코드들을  res1_1으로부터 추출하여 res1_2에 추가함: res1_1테이블에서 음식종류 설정대로 필터링된 레코드들만 res1_2테이블에 넣어짐**
			//중식 체크된 상태면 "중식"에 해당하는 음식점 정보 레코드들을 res1_1으로부터 추출하여 res1_2에 추가함
			if(foodChinese==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='중식'");
			}
			//양식 체크된 상태면 "양식"에 해당하는 음식점 정보 레코드들을 res1_1으로부터 추출하여 res1_2에 추가함
			if(foodWestern==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='양식'");
			}
			//한식 체크된 상태면 "한식"에 해당하는 음식점 정보 레코드들을 res1_1으로부터 추출하여 res1_2에 추가함
			if(foodKorean==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='한식'");
			}
			//패스트푸드 체크된 상태면 "양식"에 해당하는 음식점 정보 레코드들을 res1_1으로부터 추출하여 res1_2에 추가함
			if(foodFast==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='패스트푸드'");
			}
			//일식 체크된 상태면 "양식"에 해당하는 음식점 정보 레코드들을 res1_1으로부터 추출하여 res1_2에 추가함
			if(foodJapanese==true) {
				stmt.executeUpdate("insert into res1_2 select * from res1_1 where foodType='일식'");
			}
			
			
			//**가격범위 설정대로 해당하는 레코드들을  res1_2으로부터 추출하여 res1_3에 추가함: res1_2테이블에서 가격범위 설정대로 필터링된 레코드들만 res1_3테이블에 넣어짐**
			//(음식의 최저가격 >= 최저가격 설정값) && (음식의 최고가격 <= 최고가격 설정값)에 해당하는 음식점 정보 레코드들을 res1_2로부터 추출하여 res1_3에 추가함
			stmt.executeUpdate("insert into res1_3 select * from res1_2 where (minPrice>=" + setMinPrice +")" + " and (maxPrice<=" + setMaxPrice + ")");
			
			
			//**모든 필터링을 거친 레코드들만 들어있는 res1_3로부터 랜덤으로 한개의 레코드를 추출하여 결과객체에 넣음**
			rs=stmt.executeQuery("select * from res1_3 order by rand() limit 1;");
			
			
			//**설정값 범위 내에 해당하는 레코드 유무 여부를 알기 위해 뽑기결과에 대한 레코드 개수를 알아냄, 레코드 개수가 0이 아니면 어떤 레코드가 추출되었는지 확인함**
			//랜덤뽑기 결과에 대한 레코드의 개수를 알아냄. 설정값 범위 내에 해당하는 레코드가 없으면 numOfRow=0, 있으면 numOfRow=1임.
			ResultSetMetaData md=rs.getMetaData(); //결과객체로 부터 메타데이터를 얻음
			rs.last(); //행의 맨 마지막으로 이동
			int numOfRow=rs.getRow(); //행의개수(레코드의 개수)를 알아내어 numOfRow에 넣음
			rs.beforeFirst(); //다시 행의 처음으로 이동
			
			if(numOfRow==0) {//설정값 범위 내에 해당하는 레코드가 없어서 랜덤뽑기 결과에 대한 레코드가 존재하지 않는 경우(row의 개수가 0인 경우)
				//확인용 알림문구 출력, rs에  null값 넣음
				System.out.println("설정값 범위 내에 해당하는 레코드가 존재하지 않음 -> 설정값에 해당하는 음식점이 존재하지 않습니다. 설정값 변경후 다시 뽑기 하세요");
				rs=null;
			}else if(numOfRow>0) {//설정값 범위 내에 해당하는 레코드가 있어서 랜덤뽑기 결과에 대한 레코드가 존재하는 경우(row의 개수가 1이상인 경우)
				//확인용 알림문구 출력, 해당 레코드에 존재하는 음식메뉴들중 한개의 메뉴를 랜덤으로 뽑아 randomMenuResult에 넣음
				while(rs.next()) {
					//추출된 레코드에 존재하는 음식점 정보(음식메뉴 정보 제외) 확인용 문구 출력
					System.out.println("랜덤결과 추출된 음식점 정보 레코드: " + rs.getString("name") + " " + rs.getString("location") + " " + rs.getString("foodType") + " " + rs.getString("mapURL") + " " + rs.getString("minPrice") + " " + rs.getString("maxPrice"));
				}
				rs.beforeFirst(); //다시 행의 처음으로 이동
				randomResult=rs; //모든 필터링을 거친 레코드들만 모인 테이블에서, 랜덤으로 추출된 최종 레코드가 들은 rs객체의 레퍼런스를 대입. 만약 해당하는 레코드가 없으면 null값임.
			}
		}
		catch(SQLException e){
			System.out.println("SQL 실행 에러");
		}
		
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
			//설정 버튼을 누르면 설정화면으로 넘어감
			if(sourceBtn.getText().equals("설정")) {
				System.out.println("설정버튼 이벤트 동작"); //버튼 눌렀을때 해당하는 이벤트가 동작하는지 여부 확인하기위한 확인용 출력코드
				
				//설정 화면으로 넘어감
				new nayeong.SetUp();
				setVisible(false);

			}
			//뽑기 버튼을 누르면 랜덤뽑기 기능 수행 후 결과를 반환받아 randomResult에 저장하고, 뽑기 결과 화면으로 넘어감
			if(sourceBtn.getText().equals("뽑기")) {	
				System.out.println("뽑기버튼 이벤트 동작"); //버튼 눌렀을때 해당하는 이벤트가 동작하는지 여부 확인하기위한 확인용 출력코드
				
				pickRandom(); //랜덤뽑기 결과 리턴받아옴

				//뽑기 결과 화면으로 넘어감
				new nayeong.StoreSetUp();
				setVisible(false);
			}
		}
	}
	
	//**랜덤뽑기 결과 객체를 이용할 수 있도록 리턴하여 해주는 메소드로, 다른 모든 클래스에서 접근 가능**
	public static ResultSet getRandomResult() {
		//사용자가 설정한 설정값 범위에 해당하는 레코드가 있으면 랜덤뽑기 결과 객체는 null이 아니고, 만약 사용자의 설정값 범위에 해당하는 레코드가 없을경우 랜덤뽑기 결과 객체는 null.
		return randomResult;
	}
	

	
	
}
