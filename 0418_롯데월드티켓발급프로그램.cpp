#include <stdio.h>
#include <time.h>

int main() {
   //   주민등록번호를 입력 받는다. (주민번호를 활용하여 나이를 자동계산한다.)
   //   주문 개수를 입력받는다.
   //   우대사항을 입력받는다. (없음, 장애인, 국가유공자, 다자녀, 임산부)
   //   위의 입력을 반복할 것인지 종료할 것인지 물어본다.
   //   종료를 하게되면 지금까지 주문 내역이 모두 출력된다.
   //   완전 프로그램 종료를 하게 되면 현재까지의 매출 내역을 파일로 저장한다.


   // 필요한 변수들 
   int choice, ticket, juminnum_Front, juminnum_Back, 
   OrderCount, BirthYear, BirthDay, BirthMonth, 
   Generation_1900, Generation_2000, age, Person, Price, SpecialPrice, 
   Total, Continuing_Ticket;
   
   int Special = 0;
   int index = 1;
   
   
   int TicketTable[15][10] = {0};  // 2차원 배열 초기화 
   
   // 배열 선언할 때 주의 사항 ! 
   // 배열은 넉넉하게 만들어줘야 이상한 값이 나오는 에러가 나오지 않는다.
   // 따라서 배열은 넉넉하게 만들어주자  
  
   // 입장권 가격을 상수로 선언 
   const int GENERALPASS_1DAY_ADULT_PRICE = 62000, GENERALPASS_1DAY_TEENAGER_PRICE = 54000, GENERALPASS_1DAY_CHILDREN_PRICE = 47000, GENERALPASS_1DAY_BABY_PRICE = 15000;        // 종합이용권 1DAY
   const int GENERALPASS_AFTER4_ADULT_PRICE = 50000, GENERALPASS_AFTER4_TEENAGER_PRICE = 43000, GENERALPASS_AFTER4_CHILDREN_PRICE = 36000, GENERALPASS_AFTER4_BABY_PRICE = 15000;  // 종합이용권 AFTER4
   const int PARKPASS_1DAY_ADULT_PRICE = 59000, PARKPASS_1DAY_TEENAGER_PRICE = 52000, PARKPASS_1DAY_CHILDREN_PRICE = 46000, PARKPASS_1DAY_BABY_PRICE = 15000;         // 파크이용권 1DAY 
   const int PARKPASS_AFTER4_ADULT_PRICE = 47000, PARKPASS_AFTER4_TEENAGER_PRICE   = 41000, PARKPASS_AFTER4_CHILDREN_PRICE = 35000, PARKPASS_AFTER4_BABY_PRICE = 15000;  // 파크이용권 AFTER4
   

   //do while문 => while문 안에 있는 내용이 성립하면 do를 돈다. 
   do{
      printf("\n==========================================\n\n");
      printf("구매하실 이용권을 선택해주세요.\n1. 종합이용권(롯데월드 + 민속박물관)\n2. 파크이용권(롯데월드)\n");
      scanf("%d", &choice);
      printf("\n==========================================\n\n");
   } while(!(choice == 1 || choice == 2));
   
   do{
      printf("\n권종을 선택해주세요.\n1. 1DAY\n2. AFTER4(오후4시 입장)\n");
      scanf("%d", &ticket);
      printf("\n==========================================\n\n");
   } while(!(ticket == 1 || ticket == 2));
   
   do{
      printf("\n주민등록번호 앞자리 6자리와 뒷자리 1자리를 입력해주세요.\n앞자리(6자리)\n");
      scanf("%d", &juminnum_Front);
      printf("\n==========================================\n\n");
   } while(!(juminnum_Front > 000001 || juminnum_Front < 999999));
   
   do{
      printf("\n뒷자리(한 자리)\n");
      scanf("%1d", &juminnum_Back);
      printf("\n==========================================\n\n");
   } while(!(juminnum_Back == 1|| juminnum_Back ==2 || juminnum_Back == 3|| juminnum_Back == 4));
   
   do{
      printf("\n몇 개를 주문하시겠습니까? (최대 10개)\n");
      scanf("%d", &OrderCount);
      printf("\n==========================================\n\n");
   } while(!(OrderCount >= 1 || OrderCount < 11));
   
   do{
      printf("우대사항을 선택하세요.\n1. 없음(나이 우대는 자동처리)\n2. 장애인 우대\n3. 국가유공자 우대\n4. 휴가장병 우대\n5. 임산부 우대\n6. 다둥이 행복카드 우대\n");
      scanf("%d", &Special);
      printf("\n==========================================\n\n");
   } while(!(Special == 1 || Special == 2 || Special ==3 || Special == 4 || Special == 5 || Special == 6));
   
   do{
      printf("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료\n");
      scanf("%d", &Continuing_Ticket);
      printf("\n==========================================\n\n");
   }while(!(Continuing_Ticket == 1 || Continuing_Ticket == 2));
   
   
   // 해당 시간이 되면 프로그램에 적용될 수 있게 시간 함수를 적용하였다. 
   struct tm*t;                  // localtime 함수를 사용하여 tm 구조체를 활용, 원하는 형태로 변환한다.
   time_t base = time(NULL);         // 1970년 1월 1일 0시 0분 0초부터 시작하여 현재까지의 초
   t = localtime(&base);             
   
   BirthYear = juminnum_Front/10000;   // 생년월일에서 '연도' 출력
   BirthMonth = (juminnum_Front - (juminnum_Front * 10000))  * 100 / 10000;   // 생년월일에서 '월' 부분 출력 
   // 100 / 10000 = 0.01이라서 0.01을 곱해주면 되지 않냐고 생각할 수 있지만 프로그램을 돌렸을 때 문제없이 돌아가는 경우도 있지만
   // 그렇지 않은 경우도 존재하기 때문에 0.01을 바로 곱해주지 않고 100으로 곱하고 10000으로 나눈 과정을 진행해주었다.
   BirthDay = juminnum_Front - (BirthYear * 10000) - (BirthMonth * 100);      // 생년월일에서 '일' 부분 출력
   
      
   //   뒷부분 7자리 맨 앞부분은 성별을 나타내는데 1은 남자, 2는 여자이다.
   //   1: 1900 ~ 1999년에 태어난 남성
   //   2: 1900 ~ 1999년에 태어난 여성
   //   3: 2000 ~ 2099년에 태어난 남성
   //   4: 2000 ~ 2099년에 태어난 여성
   
   
   // tm_year와 tm_mon의 사용법에 주의
   // tm_year는 1900년도부터의 년이기에 출력하고 싶은 년도를 1900년도에 + 해서 사용해야 한다.
   // tm_mon은 1월부터 12월까지 출력하기 위해서는 +1을 해서 사용하여야 한다. 
   if(juminnum_Back == 1 || juminnum_Back == 2) {
      Generation_1900 = BirthYear + 1900;
   } else if(juminnum_Back == 3 || juminnum_Back == 4) {
      Generation_2000 = BirthYear + 2000;
   }
   
   if(Generation_1900 < 2000) {
      if(BirthMonth <= t->tm_mon + 1 && BirthDay <= t->tm_mday) {
         age = (t->tm_year + 1900) - Generation_1900;
      } else if(BirthMonth > t->tm_mon + 1) {
         age = (t->tm_year + 1900) - Generation_1900 - 1;
		 } else if(BirthDay > t->tm_mday){                  // 일 
         age = (t->tm_year + 1900) - Generation_1900 - 1; 
      }
   }
   
   if(Generation_2000 >= 2000) {
      if(BirthMonth <= t->tm_mon + 1 && BirthDay <= t->tm_mday) {
         age = (t->tm_year + 1900) - Generation_2000;
      } else if(BirthMonth > t->tm_mon + 1) {
         age = (t->tm_year + 1900) - Generation_2000 - 1;
      } else if(BirthDay > t->tm_mday) {
         age = (t->tm_year + 1900) - Generation_2000 - 1;
      }
   }
   
   // 연령대에 맞게 처리하기 편하도록 조건식 만들어줌 
   if(age <= 3){
   		Person = 0;
   } else if (age > 3 && age <= 12) {
   		Person = 1;
   } else if (age > 12 && age <= 18) {
   		Person = 2;
   } else if (age > 19 && age <= 65) {
   		Person = 3;
   } else if (age >= 65) {
   		Person = 4;
   }
   
   switch(choice){
      case 1:   // 종합이용권 선택했을 때 
         switch(ticket){
            case 1:   // 1DAY 선택했을 때 
               if(age <= 3) {
                  Price = GENERALPASS_1DAY_BABY_PRICE;
               } else if(age > 3 && age <= 12) {
                  Price = GENERALPASS_1DAY_CHILDREN_PRICE;
               } else if(age > 12 && age <= 18) {
                  Price = GENERALPASS_1DAY_TEENAGER_PRICE;
               } else if(age > 19 && age < 65) {
                  Price = GENERALPASS_1DAY_ADULT_PRICE;
               } else if(age >= 65) {
                  Price = GENERALPASS_1DAY_CHILDREN_PRICE;
               }
               break; 
            
            case 2:  // AFTER4 선택했을 때 
               if(age <= 3) {
                  Price = GENERALPASS_AFTER4_BABY_PRICE;
               }    else if(age > 3 && age <= 12) {
                  Price = GENERALPASS_AFTER4_CHILDREN_PRICE;
               }     else if(age > 12 && age <= 18) {
                  Price = GENERALPASS_AFTER4_TEENAGER_PRICE;
               }   else if(age > 19 && age < 65) {
                  Price = GENERALPASS_AFTER4_ADULT_PRICE;
               }   else if(age >= 65) {
                  Price = GENERALPASS_AFTER4_CHILDREN_PRICE;
               }
               break;   
         }
         break;
         
      case 2:    // 파크이용권 선택했을 때 
         switch(ticket){ 
            case 1:   // 1DAY 선택했을 때 
               if(age <= 3) {
                  Price = PARKPASS_1DAY_BABY_PRICE;
               } else if(age > 3 && age <= 12) {
                  Price = PARKPASS_1DAY_CHILDREN_PRICE;
               } else if(age > 12 && age <= 18) {
                  Price = PARKPASS_1DAY_TEENAGER_PRICE;
               } else if(age > 19 && age < 65) {
                  Price = PARKPASS_1DAY_ADULT_PRICE;
               } else if(age >= 65) {
                  Price = PARKPASS_1DAY_CHILDREN_PRICE;
               }
               break;
               
            case 2:  // AFTER4 선택했을 때 
               if(age <= 3) {
                  Price = PARKPASS_AFTER4_BABY_PRICE;
               }    else if(age > 3 && age <= 12) {
                  Price = PARKPASS_AFTER4_CHILDREN_PRICE;
               }     else if(age > 12 && age <= 18) {
                  Price = PARKPASS_AFTER4_TEENAGER_PRICE;
               }   else if(age > 19 && age < 65) {
                  Price = PARKPASS_AFTER4_ADULT_PRICE;
               }   else if(age >= 65) {
                  Price = PARKPASS_AFTER4_CHILDREN_PRICE;
               }
               break;   
         }
         break;
         
      default :
         printf("다시 입력해주세요.");
         }
      
   
   // 우대사항 가격
   switch(Special) {
      case 1:   // 우대사항 없음 
         SpecialPrice = Price; 
         break;   
      
      case 2:   // 장애인 우대 
         SpecialPrice = Price * 0.5;
         break;
      
      case 3:   // 국가 유공자 우대 
         SpecialPrice = Price * 0.5;
         break;
      
      case 4:   // 휴가장병 우대 
         if(choice == 1) {
            SpecialPrice = Price * 0.49;   // 휴가 장병의 경우 종합이용권만 49 % 우대 
         } else if(choice == 2) {
            SpecialPrice = Price;
         }
         break;
      
      case 5:  // 임산부 우대 
         if(choice == 1) {
            SpecialPrice = Price * 0.5;
         } else if(choice == 2) {
            SpecialPrice = Price;
         }
         break;
      
      case 6:   // 다둥이 행복카드 우대 
         if(choice == 1) {
            SpecialPrice = Price * 0.3;
         } else if(choice == 2) {
            SpecialPrice = Price;
         }
         break;
      } 
      
      Total = SpecialPrice * OrderCount;
      
      printf("가격은 %d 원 입니다.\n감사합니다.\n\n", Total);
      
      
	  TicketTable[1][index] = choice;  // 이용권 
      TicketTable[1][index] = ticket;  // 시간대 
      TicketTable[1][index] = Person;  // 연령대 
      TicketTable[1][index] = OrderCount; // 주문 개수 
      TicketTable[1][index] = Total;    // 합산 가격 
      TicketTable[1][index] = Special;  // 우대사항 
      index++;
      
      // = 의 개수 체크해주기
	  // 내역에 들어갈 것은 이용권, 권종, 연령, 개수, 금액, 우대사항 : 총 6항목 
	  printf("============================롯데 월드==============================\n" );   // 총 51자	  
      printf("%-12s %-10s %-6s      %-4s %5s %19s\n", "이용권", "권종", "연령", "개수", " 금액", "우대 사항");
	  printf("-------------------------------------------------------------------\n");
	  
	  
	switch(choice) {
		case 1:
			printf("종합이용권");
			break;
		case 2:
			printf("파크이용권");
			break; 
	}
	
	switch(ticket) {
		case 1 :
			printf("   1 DAY");
			break;
		case 2 :
			printf("   AFTER 4");
			break;
	}
	
	switch(Person) {
		case 0 :
			printf("    유아");
			break; 
		
		case 1 :
			printf("    어린이");
			break;
			
		case 2 :
			printf("    청소년");
			break;
			
		case 3 :
			printf("    성인");
		 	break;
			
		case 4 :
			printf("    노인");
			break;
	}
	
	switch(OrderCount) {
		case 1 :
			printf("        1");
			break;
		
		case 2 :
			printf("        2");
			break;
			
		case 3 :
			printf("        3");
			break;
			
		case 4 :
			printf("        4");
			break;
			
		case 5 :
			printf("        5");
			break;
			
		case 6 :
			printf("        6");
			break;
			
		case 7 :
			printf("        7");
			break;
		
		case 8 :
			printf("        8");
			break;
			
		case 9 :
			printf("        9");
			break;
			
		case 10 :
			printf("        10");
			break;
		
	}
	
	printf("   %d ",  Total);
	
	
	switch(Special){
		
		case 1 :
			printf("         우대사항 없음\n");
			break;
			
		case 2 :
			printf("         장애인 우대\n");
			break;
		
		case 3 :
			printf("         국가유공자\n");
			break;
			
		case 4 :
			printf("         휴가장병\n");
			break;
		
		case 5 :
			printf("         임산부 우대\n");
			break;
						 
		case 6 :
			printf("         다둥이 행복카드\n");
			break;
	}	
}
	 

// 한번만 발권이 아니라 계속 발권해서 여러 장을 출력할 수 있도록 해야한다.
