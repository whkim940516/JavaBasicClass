package LotteWorldTicketIssuance;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {
		  
		  // 이 공간은 메인함수도 아니고 함수도 아닌 필드 공간이다.
		  // 만약 이 곳에 변수를 선언하면 함수 내에서는 다시 선언해줄 필요가 없다.
		  // 실수로 함수내에서 변수선언을 해주었을 경우 변수명의 색깔이 파랑색과 노랑색으로 구분될 것이며
		  // 이는 어떤 인자를 받는지와 연결되기 때문에 이를 반드시 구분할 수 있어야 한다.
		  // 구분이 어렵다면 sysout을 통해 해당 인자를 출력해보자.
		  // 본인은 이 부분 때문에 엉뚱한 인자를 받아서(색깔 다른 변수) 많은 에러를 경험하였다.
			
	
	      // 변수 선언
	      public static int choice = 0;        			
	      public static int ticket = 0;					
	      public static int ticketCount = 0;			 
	      public static int special = 0;
	      public static int continuingTicket = 0;
	      public static int person = 0;
	      public static int age = 0;
	      public static int price = 0;
	      public static int specialPrice = 0;
	      public static int orderCount = 0;
	      public static int manAge = 0;
	      public static int today = 0;
	      public static int thisYear = 0;
	      public static int thisMonth = 0;
	      public static int thisDay = 0;
	      public static int juminYear = 0;
	      public static int juminMonth = 0;
	      public static int juminDay = 0;
	      public static int total = 0;
//	      public static int index = 0;
	      
	      
	      
	      // 2차원 배열 초기화
	      public static int [][] ticketTable = new int[15][10];
	      
	      
	      // 입장권 가격을 상수로 선언
	   
	      // 종합이용권 1DAY
	      static final int GENERALPASS_1DAY_ADULT_PRICE = 62000;
	      static final int GENERALPASS_1DAY_TEENAGER_PRICE = 54000;
	      static final int GENERALPASS_1DAY_CHILDREN_PRICE = 47000;
	      static final int GENERALPASS_1DAY_BABY_PRICE = 15000;
	      
	      // 종합이용권 AFTER 4
	      static final int GENERALPASS_AFTER4_ADULT_PRICE = 50000;
	      static final int GENERALPASS_AFTER4_TEENAGER_PRICE = 43000;
	      static final int GENERALPASS_AFTER4_CHILDREN_PRICE = 36000;
	      static final int GENERALPASS_AFTER4_BABY_PRICE = 15000;
	      
	      // 파크이용권 1DAY
	      static final int PARKPASS_1DAY_ADULT_PRICE = 59000;
	      static final int PARKPASS_1DAY_TEENAGER_PRICE = 52000;
	      static final int PARKPASS_1DAY_CHILDREN_PRICE = 46000;
	      static final int PARKPASS_1DAY_BABY_PRICE = 15000;
	      
	      // 파크이용권 AFTER 4
	      static final int PARKPASS_AFTER4_ADULT_PRICE = 47000;
	      static final int PARKPASS_AFTER4_TEENAGER_PRICE = 41000;
	      static final int PARKPASS_AFTER4_CHILDREN_PRICE = 35000;
	      static final int PARKPASS_AFTER4_BABY_PRICE = 15000;
	      
	      
	      // 이용권 및 권종 선택
	      public void choiceTicket() {
	            
	         do{
	            System.out.print("\n==========================================\n\n");
	            System.out.print("구매하실 이용권을 선택해주세요.\n1. 종합이용권(롯데월드 + 민속박물관)\n2. 파크이용권(롯데월드)\n");
	            Scanner sc = new Scanner(System.in);
	            choice = sc.nextInt();
	            System.out.print("\n==========================================\n\n");
	         } while(!(choice == 1 || choice == 2));
	   
	         do{
	              System.out.print("\n권종을 선택해주세요.\n1. 1DAY\n2. AFTER4(오후4시 입장)\n");
	              Scanner sc = new Scanner(System.in);
	              ticket = sc.nextInt();
	              System.out.print("\n==========================================\n\n");         
	            } while(!(ticket == 1 || ticket == 2));
	         
	         }
	      
	      // 주민등록번호와 만나이 계산
	      public static void jumin_manAge() {
	          
	        /*날짜 시간 받아오기 => 컴퓨터 시스템의 날짜와 시스템을 얻기 위해 Date를 사용

	              SimpleDateFormat? => 날짜 및 시간의 출력 서식을 지정할 때 사용.

	              SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	              2019년 8월 28일로 출력되는 것이 아닌 20190828로 출력하기 위해 yyyyMMdd로 입력해야함.

	              String today = format.format(new Date());을 입력한 뒤 Sysout으로 today를 출력하면


	              오늘 날짜가 20190828로 출력됨.*/

	    	System.out.println("'-'를 포함한 주민등록번호를 입력하세요.");
	        Scanner sc = new Scanner(System.in);
	        String jumin = sc.next(); 
//	        int manAge = 0;  필드에 선언을 했으니까 여기서는 선언을 해주면 오히려 오류가 날 수 있음
	        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        String today = format.format(new Date());
	        System.out.println("오늘 날짜 확인 : " + today);
	        
	        // substring을 활용해 현재 연월일을 구분
	        // String => int로 형변환
	        int thisYear = Integer.parseInt(today.substring(0, 4));
	        int thisMonth = Integer.parseInt(today.substring(4, 6));
	        int thisDay = Integer.parseInt(today.substring(6, 8));

	        
	        // 주민등록상의 연월일 구분
	        // String => int로 형변환
	        // 숫자 계산을 위해 int로 형변환 한다.
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
	        
	        if(juminMonth > thisMonth) {   // 주민번호의 월이 현재 날짜의 월보다 높으면
	           manAge = manAge-1;         // 만 나이 계산법 적용
	           System.out.println("만 나이 계산 결과 : " + manAge);
	        }else if(juminMonth == thisMonth) {   // 주민번호;의 월과 현재날짜의 월이 같을 경우
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
	       

	      // 티켓 개수
	      public static void ticketOrderCount() {
	         
	         do {
	            System.out.print("\n몇 개를 주문하시겠습니까? (최대 10개)\n");
	            Scanner sc = new Scanner(System.in);
	            ticketCount = sc.nextInt();
	            System.out.print("\n==========================================\n\n");
	         } while(!(ticketCount >= 1 || ticketCount < 11));
	      }
	      
	      
	      // 우대 사항
	      public static void PreferentialTreatment() {
	         
	         do {
	            System.out.print("우대사항을 선택하세요.\n1. 없음(나이 우대는 자동처리)\n2. 장애인 우대\n3. 국가유공자 우대\n4. 휴가장병 우대\n5. 임산부 우대\n6. 다둥이 행복카드 우대\n");
	            Scanner sc = new Scanner(System.in);
	            special = sc.nextInt();
	            System.out.print("\n==========================================\n\n");
	         } while(!(special == 1 || special == 2 || special ==3 || special == 4 || special == 5 || special == 6));      
	      }
	         
	      
	      // 추가 발권 여부
	      public static int additionalTicket() {

	         do {
	            System.out.print("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료\n");
	            Scanner sc = new Scanner(System.in);
	            continuingTicket = sc.nextInt();
	            System.out.print("\n==========================================\n\n");
	         } while(!(continuingTicket == 1|| continuingTicket == 2));
	         
	         return continuingTicket;
	      }                          
	      
	      // 연령대에 맞게 처리하기 편하도록 조건식 만들어줌
	      public static void personAgeCase() {
	         
	    	  System.out.printf("%d", manAge);
	    	  
	         if(manAge <= 3){
	               person = 0;
	         } else if (manAge > 3 && manAge <= 12) {
	               person = 1;
	         } else if (manAge > 12 && manAge <= 18) {
	               person = 2;
	         } else if (manAge > 19 && manAge <= 65) {
	               person = 3;
	         } else if (manAge >= 65) {
	               person = 4;
	         }
	      }
	      

	      // 연령대에 따른 가격
	      public static void personAgePrice() {
	         
	         switch(choice){
	             case 1:   // 종합이용권 선택했을 때 
	                switch(ticket){
	                   case 1:   // 1DAY 선택했을 때 
	                      if(manAge <= 3) {
	                         price = GENERALPASS_1DAY_BABY_PRICE;
	                      } else if(manAge > 3 && manAge <= 12) {
	                         price = GENERALPASS_1DAY_CHILDREN_PRICE;
	                      } else if(manAge > 12 && manAge <= 18) {
	                         price = GENERALPASS_1DAY_TEENAGER_PRICE;
	                      } else if(manAge > 19 && manAge < 65) {
	                         price = GENERALPASS_1DAY_ADULT_PRICE;
	                      } else if(manAge >= 65) {
	                         price = GENERALPASS_1DAY_CHILDREN_PRICE;
	                      }
	                      break; 
	                   
	                   case 2:  // AFTER4 선택했을 때 
	                      if(manAge <= 3) {
	                         price = GENERALPASS_AFTER4_BABY_PRICE;
	                      }    else if(manAge > 3 && manAge <= 12) {
	                         price = GENERALPASS_AFTER4_CHILDREN_PRICE;
	                      }     else if(manAge > 12 && manAge <= 18) {
	                         price = GENERALPASS_AFTER4_TEENAGER_PRICE;
	                      }   else if(manAge > 19 && manAge < 65) {
	                         price = GENERALPASS_AFTER4_ADULT_PRICE;
	                      }   else if(manAge >= 65) {
	                         price = GENERALPASS_AFTER4_CHILDREN_PRICE;
	                      }
	                      break;   
	                }
	                break;
	             
	             case 2:    // 파크이용권 선택했을 때 
	                switch(ticket){ 
	                   case 1:   // 1DAY 선택했을 때 
	                      if(manAge <= 3) {
	                         price = PARKPASS_1DAY_BABY_PRICE;
	                      } else if(manAge > 3 && manAge <= 12) {
	                         price = PARKPASS_1DAY_CHILDREN_PRICE;
	                      } else if(manAge > 12 && manAge <= 18) {
	                         price = PARKPASS_1DAY_TEENAGER_PRICE;
	                      } else if(manAge > 19 && manAge < 65) {
	                         price = PARKPASS_1DAY_ADULT_PRICE;
	                      } else if(manAge >= 65) {
	                         price = PARKPASS_1DAY_CHILDREN_PRICE;
	                      }
	                      break;
	                      
	                   case 2:  // AFTER4 선택했을 때 
	                      if(manAge <= 3) {
	                         price = PARKPASS_AFTER4_BABY_PRICE;
	                      }    else if(manAge > 3 && manAge <= 12) {
	                         price = PARKPASS_AFTER4_CHILDREN_PRICE;
	                      }     else if(manAge > 12 && manAge <= 18) {
	                         price = PARKPASS_AFTER4_TEENAGER_PRICE;
	                      }   else if(manAge > 19 && manAge < 65) {
	                         price = PARKPASS_AFTER4_ADULT_PRICE;
	                      }   else if(manAge >= 65) {
	                         price = PARKPASS_AFTER4_CHILDREN_PRICE;
	                      }
	                      break;   
	                }
	                break;
	             
	             default :
	                System.out.print("다시 입력해주세요.");
	             }
	         }
	      
	      
	      // 우대사항 가격
	      public static void preferentialTreatmentPrice() {

	         switch(special) {
	            case 1:   // 우대사항 없음 
	                  specialPrice = price; 
	                  break;   
	               
	               case 2:   // 장애인 우대 
	                  specialPrice = (int)((float)price * 0.5);
	                  price = price - specialPrice;
	                  break;
	               
	               case 3:   // 국가 유공자 우대 
	                  specialPrice = (int)((float)price * 0.5);
	                  price = price - specialPrice;
	                  break;
	               
	               case 4:   // 휴가장병 우대 
	                  if(choice == 1) {
	                  specialPrice = (int)((float)price * 0.49);   // 휴가 장병의 경우 종합이용권만 49 % 우대
	                  price = price - specialPrice; 
	                  } else if(choice == 2) {
	                     specialPrice = price;
	                  }
	                  break;
	               
	               case 5:  // 임산부 우대 
	                  if(choice == 1) {
	                     specialPrice = (int)((float)price * 0.5);
	                     price = price - specialPrice;
	                  } else if(choice == 2) {
	                     specialPrice = price;
	                  }
	                  break;
	               
	               case 6:   // 다둥이 행복카드 우대 
	                  if(choice == 1) {
	                     specialPrice = (int)((float)price * 0.3);
	                     price = price - specialPrice;
	                  } else if(choice == 2) {
	                     specialPrice = price;
	                  }
	                  break;
	         }
	      }
	      
	      
	      // ticketTableLoop
	       void ticketTableLoop() {
	         
//				뭔가 이상할 때는 printf문을 찍어서 잘 들어갔는지 확인해준다.
//	    	    인자 비교를 위해 문자를 다르게 a,b,c,d로 구분해줌
//				System.out.printf("c : %d\n", ticketTable[0][0]);
//				System.out.printf("d : %d\n", ticketTable[0][1]);
				
	    	  
	    	  
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
	       
	      
	      public static void main(String[] args) {
	    	  
	    	  // 함수 호출을 위한 ltw객체 생성
	    	  Main ltw = new Main();
	    	  InputData input = new InputData();
	    	  input.jumin_manAge();
	    	  System.out.println(input.manAge);
//	    	  int [][] ticketTable = new int[15][10];   이 부분 때문에 인자를 제대로 호출받지 못했음 
//                                    => 필드에서 변수를 선언해주었기 때문에 여기서는 선언해줄 필요가 없다.
	          System.out.println();
	    	  
	          do {
	        	 
	        	 // 함수호출
	        	 ltw.choiceTicket();
	             ltw.jumin_manAge();
	             ltw.ticketOrderCount();
	             ltw.PreferentialTreatment();
	             ltw.additionalTicket();
	             ltw.personAgeCase();
	             ltw.personAgePrice();
	             ltw.preferentialTreatmentPrice();
            	           	          
	             System.out.printf("%d", specialPrice * ticketCount);
	             
	             // 최종가격
	             total = specialPrice * ticketCount;
	             System.out.printf("가격은 %d 원 입니다.\n감사합니다.\n", total);
	             
	             // 2차원 배열
	             ticketTable[orderCount][0] = choice;     // 이용권
	             ticketTable[orderCount][1] = ticket;     // 시간대
//	             System.out.printf("%d", person);
	             ticketTable[orderCount][2] = person;     // 연령대
	             ticketTable[orderCount][3] = ticketCount; // 주문한 사람이 구입한 티켓 장 수\
	             ticketTable[orderCount][4] = total;      // 합산 가격
	             ticketTable[orderCount][5] = special;      // 우대 사항
	             orderCount++;
	             
	             
	             // '='의 개수 체크해주기
	             // 내역에 들어갈 것은 이용권, 권종, 연령, 개수, 금액, 우대사항 : 총 6 항목
	            System.out.printf("================================롯데 월드==================================\n");
	            System.out.printf("%-12s %-12s %-12s %-5s %10s %20s\n", "이용권", "권종", "연령", "개수", " 금액", "우대 사항");
	            System.out.printf("---------------------------------------------------------------------------\n");

//	 	      	System.out.printf("a : %d\n", ticketTable[0][0]);
//				System.out.printf("b : %d\n", ticketTable[0][1]);
	             
	             ltw.ticketTableLoop();

	             System.out.printf("\n");
	             System.out.printf("---------------------------------------------------------------------------\n");
	             System.out.printf("계속 발권하시겠습니까?\n1. 계속 발권\n2. 발권 종료\n");
	             Scanner sc = new Scanner(System.in);
	             int continuingTicket = sc.nextInt();
	               } while(continuingTicket == 1);
	               
	             System.out.printf("티켓 발권을 종료합니다.\n");
	           
	       }
	      
	    }	

// 개수를 선택하는 순간 우대사항이 호출되면서 해당 함수가 무한루프도는 상황 => nextInt로 입력을 받지않아서 생긴 문제 였고 해결함
// 주민등록번호 만나이 합친거 때문에 그런건지?  => 상관 없었음
// 2차원 배열이 올바로 출력되지 않는 상태
// 연령, 금액 부분에 이상이 있음   => 메인 함수 밖에 있는 필드에서 선언해준 부분과 메인함수에서 선언한 변수명이 겹쳤고 이로 인해 인자를 올바로 받지 못해서
//  							유아 만 출력되는 에러가 발생했고 필드에 manAge = 0 ;이라는 변수를 선언했기 때문에 함수에는 변수선언을 해줄 필요가 없었다.
//                              변수를 구분할 때는 색깔을 통해 확인하자
	


