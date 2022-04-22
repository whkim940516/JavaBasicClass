package LotteWorldTicketIssuance;

import java.util.Scanner;

public class OutputData {
	
	Scanner sc = new Scanner(System.in);
	
	// Loop
	public int [][] ticketTable = new int[15][10];
	public int orderCount;
	
	// 아래 함수들에 사용되는 변수들을 가져오기 위해 객체를 생성하였습니다.
	InputData input = new InputData();
	CalculateData calculate = new CalculateData();

	public int total;
	
	
	
	
	


void ticketTableLoop() {
   
// 2차원 배열과 반복문을 활용하여 index가 증가하면서 경우에 따라서 필요한 문구가 나오도록 하였습니다.
 for(int index = 0; index < orderCount; index++) {
    switch(ticketTable[index][0]) {
    
       case 1 :
          System.out.printf("%-12s", "종합이용권");
          break;
          
       case 2 :
          System.out.printf("%-12s", "파크이용권");
          break;
       }
    
    
    switch(ticketTable[index][1]) {
         case 1 :
            System.out.printf("%-12s", "1 DAY");
            break;
         case 2:
            System.out.printf("%-12s", "AFTER 4");
            break;
         }
   
   switch(ticketTable[index][2]) {
       case 0 :
            System.out.printf("%-12s", "  유아");
            break;
       case 1 :
            System.out.printf("%-12s", "  어린이");
            break;
       case 2 :
            System.out.printf("%-12s", "  청소년");
            break;
       case 3 :
            System.out.printf("%-12s", "  어른");
            break;
       case 4 :
            System.out.printf("%-12s", "  노인");
            break;
      }
   
   System.out.printf("%5d 장", ticketTable[index][3]);
   System.out.printf("%10d 원", ticketTable[index][4]);
   
   switch(ticketTable[index][5]) {
         case 1 :
            System.out.printf("%20s", "우대사항 없음\n\n");
            break;
            
         case 2 :
            System.out.printf("%20s", "장애인 우대\n\n");
            break;
            
         case 3 :
            System.out.printf("%20s", "국가유공자\n\n");
            break;
            
         case 4 :   
        	System.out.printf("%20s", "휴가 장병\n\n");
        	break;
          
         case 5 :
        	System.out.printf("%20s", "임산부 우대\n\n");
        	break;
          
         case 6:
        	System.out.printf("%20s", "다둥이 행복카드\n\n");
        	break;
      }
    
 }   
 }


void finalOutput() {

	do {
 	 
 	  // 함수호출
 	  input.choiceTicket();
      input.jumin_manAge();
      input.ticketOrderCount();
      input.PreferentialTreatment();
      input.additionalTicket();
      
      // 해당 함수에서 다른 클래스의 변수를 필요로 했기에 괄호안에 해당 인자를 넣어주었습니다.
      calculate.personAgeCase(input);     
      calculate.personAgePrice(input);
      calculate.preferentialTreatmentPrice(input);         	          
          
      // 최종가격
      total = calculate.specialPrice * input.ticketCount;
      System.out.printf("가격은 %d 원 입니다.\n감사합니다.\n", total);
      
      // 2차원 배열
      ticketTable[orderCount][0] = input.choice;     	// 이용권
      ticketTable[orderCount][1] = input.ticket;     	// 시간대
      ticketTable[orderCount][2] = calculate.person;    // 연령대
      ticketTable[orderCount][3] = input.ticketCount; 	// 주문한 사람이 구입한 티켓 장 수
      ticketTable[orderCount][4] = total;      			// 합산 가격
      ticketTable[orderCount][5] = input.special;      	// 우대 사항
      orderCount++;
      
      
      // 내역에 들어갈 것은 이용권, 권종, 연령, 개수, 금액, 우대사항 : 총 6 항목
      System.out.printf("================================롯데 월드==================================\n");
      System.out.printf("%-12s %-12s %-12s %-5s %10s %20s\n", "이용권", "권종", "연령", "개수", " 금액", "우대 사항");
      System.out.printf("---------------------------------------------------------------------------\n");
    
      ticketTableLoop();

      System.out.printf("\n");
      System.out.printf("---------------------------------------------------------------------------\n");
      System.out.printf("계속 발권하시겠습니까?\n1. 계속 발권\n2. 발권 종료\n");
      int continuingTicket = sc.nextInt();
        } while(input.continuingTicket == 1);  // 계속 발권 여부를 묻고 1을 입력하면 위의 내용을 반복하도록 하였습니다
        
      System.out.printf("티켓 발권을 종료합니다.\n");
    
}
}