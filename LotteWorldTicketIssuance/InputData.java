package LotteWorldTicketIssuance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputData {
	
	// Scanner & SimpleDateFormat
	// 공통적으로 사용되기 때문에 필드에 선언하고 함수 내에서는 지워주었습니다.
	Scanner sc = new Scanner(System.in);
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	// 이용권 및 권종 선택
	public int choice;
	public int ticket;
	
	// 주민등록번호와 만나이 계산
	public String jumin;   
	public String today;  
	public int thisYear;
	public int thisMonth;
	public int thisDay;
	public int juminYear;
	public int juminMonth;
	public int juminDay;
	public int manAge;
	
	// 티켓 개수
	public int ticketCount;
	
	// 우대 사항
	public int special;
	
	// 추가 발권 여부
	public int continuingTicket;
	
	 

	
	
	
	
void choiceTicket() {
		
		// while문 안에 있는 내용이 성립하면 do를 실행합니다.
		// 1,2가 아니면 계속 do 안에 있는 코드가 돌도록 하여 예외처리를 하였습니다.
		do {
			System.out.print("\n==========================================\n\n");
			System.out.print("구매하실 이용권을 선택해주세요.\n1. 종합이용권(롯데월드 + 민속박물관)\n2. 파크이용권(롯데월드)\n");
			choice = sc.nextInt();
			System.out.print("\n==========================================\n\n");
		} while (!(choice == 1 || choice == 2));

		do {
			System.out.print("\n권종을 선택해주세요.\n1. 1DAY\n2. AFTER4(오후4시 입장)\n");
			ticket = sc.nextInt();
			System.out.print("\n==========================================\n\n");
		} while (!(ticket == 1 || ticket == 2));

	}


void jumin_manAge() {
    
    
    // SimpleDateForma은 날짜 및 시간의 출력 서식을 지정할 때 사용합니다.
    System.out.println("'-'를 포함한 주민등록번호를 입력하세요.");
    String jumin = sc.next(); 
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    String today = format.format(new Date());
    System.out.println("오늘 날짜 확인 : " + today);
    
    // substring을 활용해 현재 연월일을 구분하였습니다.
    // String => int로 형변환
    int thisYear = Integer.parseInt(today.substring(0, 4));
    int thisMonth = Integer.parseInt(today.substring(4, 6));
    int thisDay = Integer.parseInt(today.substring(6, 8));

    // 주민등록상의 연월일 구분
    // String => int로 형변환
    // 숫자 계산을 위해 int로 형변환 하였습니다.
    int juminYear = Integer.parseInt(jumin.substring(0,2));
    int juminMonth = Integer.parseInt(jumin.substring(2,4));
    int juminDay = Integer.parseInt(jumin.substring(4,6));


    /*8번째 자리가 0또는 9의 경우, 1800년대생 출생
      1또는 2의 경우 1900년대생 출생
      3또는 4의 경우 2000년대생 출생*/
    
    // ex) 주민등록번호 111111-1111111 
    //                     1        위치를 반환하기위해 charAt(7)을 사용
    if(jumin.charAt(7) == '0' || jumin.charAt(7) == '9') {
       juminYear = 1800 + juminYear;
    } else if(jumin.charAt(7) == '1' || jumin.charAt(7) == '2') {
       juminYear = 1900 + juminYear;
    } else if(jumin.charAt(7) == '3' || jumin.charAt(7) == '4') {
       juminYear = 2000 + juminYear;
    }
    
    /* 만 나이
     * 현재 연도 - 태어난 해
     */
    manAge = thisYear - juminYear;
    
    /* 생년월일의 "월"이 지났는가?
     * 생년월일의 "일"이 지났는가?
     */
    
    if(juminMonth > thisMonth) {   // 주민번호의 월이 현재 날짜의 월보다 높으면 생일이 지났기 때문에
       manAge = manAge-1;         // 만 나이 계산법 적용 
       System.out.println("만 나이 계산 결과 : " + manAge);
    }else if(juminMonth == thisMonth) {   // 주민번호의 월과 현재날짜의 월이 같을 경우
       if(juminDay > thisDay) {          // 주민번호의 일자가 더 높으면 
          manAge = manAge-1;           // 만 나이 계산법 적용
          System.out.println("만 나이 계산 결과 : " + manAge--);
    }else {
       System.out.println("만 나이 계산 결과 : " + manAge);
    }
    
 }else {
    System.out.println("만 나이 계산 결과 : " + manAge);
 }
  
}


void ticketOrderCount() {
    
    do {
       System.out.print("\n몇 개를 주문하시겠습니까? (최대 10개)\n");
       ticketCount = sc.nextInt();
       System.out.print("\n==========================================\n\n");
    } while(!(ticketCount >= 1 || ticketCount < 11));
 }

void PreferentialTreatment() {
    
    do {
       System.out.print("우대사항을 선택하세요.\n1. 없음(나이 우대는 자동처리)\n2. 장애인 우대\n3. 국가유공자 우대\n4. 휴가장병 우대\n5. 임산부 우대\n6. 다둥이 행복카드 우대\n");
       special = sc.nextInt();
       System.out.print("\n==========================================\n\n");
    } while(!(special == 1 || special == 2 || special ==3 || special == 4 || special == 5 || special == 6));      
 }


void additionalTicket() {

    do {
       System.out.print("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료\n");
       continuingTicket = sc.nextInt();
       System.out.print("\n==========================================\n\n");
    } while(!(continuingTicket == 1|| continuingTicket == 2));

 }
}


