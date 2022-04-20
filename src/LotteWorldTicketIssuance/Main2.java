package LotteWorldTicketIssuance;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main2 {
	
	      public static void main(String[] args) {
	    	  
	    	  Scanner sc = new Scanner(System.in);
	    	  
	    	  // 함수 호출을 위한 ltw객체 생성
	    	  Main2 ltw = new Main2();
	    	  InputData input = new InputData();
//	    	  input.jumin_manAge();
//	    	  System.out.println(input.manAge);
	    	  
	    	  CalculateData calculate = new CalculateData();
	    	  
	    	  OutputData output = new OutputData();
	    	  
	    	  int total;
	    	  
//	    	  int [][] ticketTable = new int[15][10];   이 부분 때문에 인자를 제대로 호출받지 못했음 
//                                    => 필드에서 변수를 선언해주었기 때문에 여기서는 선언해줄 필요가 없다.
	          System.out.println();
	    	  
	          do {
	        	 
	        	 // 함수호출
	        	 input.choiceTicket();
	             input.jumin_manAge();
	             input.ticketOrderCount();
	             input.PreferentialTreatment();
	             input.additionalTicket();
	             calculate.personAgeCase();
	             calculate.personAgePrice();
	             calculate.preferentialTreatmentPrice();
            	           	          
	             System.out.printf("%d", calculate.specialPrice * input.ticketCount);
	             
	             // 최종가격
	             total = calculate.specialPrice * input.ticketCount;
	             System.out.printf("가격은 %d 원 입니다.\n감사합니다.\n", total);
	             
	             // 2차원 배열
	             output.ticketTable[output.orderCount][0] = input.choice;     // 이용권
	             output.ticketTable[output.orderCount][1] = input.ticket;     // 시간대
//	             System.out.printf("%d", person);
	             output.ticketTable[output.orderCount][2] = calculate.person;     // 연령대
	             output.ticketTable[output.orderCount][3] = input.ticketCount; // 주문한 사람이 구입한 티켓 장 수\
	             output.ticketTable[output.orderCount][4] = total;      // 합산 가격
	             output.ticketTable[output.orderCount][5] = input.special;      // 우대 사항
	             output.orderCount++;
	             
	             
	             // '='의 개수 체크해주기
	             // 내역에 들어갈 것은 이용권, 권종, 연령, 개수, 금액, 우대사항 : 총 6 항목
	            System.out.printf("================================롯데 월드==================================\n");
	            System.out.printf("%-12s %-12s %-12s %-5s %10s %20s\n", "이용권", "권종", "연령", "개수", " 금액", "우대 사항");
	            System.out.printf("---------------------------------------------------------------------------\n");

//	 	      	System.out.printf("a : %d\n", ticketTable[0][0]);
//				System.out.printf("b : %d\n", ticketTable[0][1]);
	             
	            output.ticketTableLoop();

	             System.out.printf("\n");
	             System.out.printf("---------------------------------------------------------------------------\n");
	             System.out.printf("계속 발권하시겠습니까?\n1. 계속 발권\n2. 발권 종료\n");
	             int continuingTicket = sc.nextInt();
	               } while(input.continuingTicket == 1);
	               
	             System.out.printf("티켓 발권을 종료합니다.\n");
	           
	       }
	      
	    }	

// 개수를 선택하는 순간 우대사항이 호출되면서 해당 함수가 무한루프도는 상황 => nextInt로 입력을 받지않아서 생긴 문제 였고 해결함
// 주민등록번호 만나이 합친거 때문에 그런건지?  => 상관 없었음
// 2차원 배열이 올바로 출력되지 않는 상태
// 연령, 금액 부분에 이상이 있음   => 메인 함수 밖에 있는 필드에서 선언해준 부분과 메인함수에서 선언한 변수명이 겹쳤고 이로 인해 인자를 올바로 받지 못해서
//  							유아 만 출력되는 에러가 발생했고 필드에 manAge = 0 ;이라는 변수를 선언했기 때문에 함수에는 변수선언을 해줄 필요가 없었다.
//                              변수를 구분할 때는 색깔을 통해 확인하자
	


