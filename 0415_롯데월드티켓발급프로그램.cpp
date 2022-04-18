#include <stdio.h>
#include <time.h>

int main() {
	//	주민등록번호를 입력 받는다. (주민번호를 활용하여 나이를 자동계산한다.)
	//	주문 개수를 입력받는다.
	//	우대사항을 입력받는다. (없음, 장애인, 국가유공자, 다자녀, 임산부)
	//	위의 입력을 반복할 것인지 종료할 것인지 물어본다.
	//	종료를 하게되면 지금까지 주문 내역이 모두 출력된다.
	//	완전 프로그램 종료를 하게 되면 현재까지의 매출 내역을 파일로 저장한다.


	// 필요한 변수들 
	int choice, ticket, juminnum_Front, juminnum_Back, OrderCount, Special, BirthYear, BirthDay, BirthMonth, Generation_1900, Generation_2000, age, Price, SpecialPrice, Total, Continuing_Ticket;
	
	
	// 입장권 가격을 상수로 선언 
	const int GENERALPASS_1DAY_ADULT_PRICE = 62000, GENERALPASS_1DAY_TEENAGER_PRICE = 54000, GENERALPASS_1DAY_CHILDREN_PRICE = 47000, GENERALPASS_1DAY_BABY_PRICE = 15000;  		// 종합이용권 1DAY
	const int GENERALPASS_AFTER4_ADULT_PRICE = 50000, GENERALPASS_AFTER4_TEENAGER_PRICE = 43000, GENERALPASS_AFTER4_CHILDREN_PRICE = 36000, GENERALPASS_AFTER4_BABY_PRICE = 15000;  // 종합이용권 AFTER4
	const int PARKPASS_1DAY_ADULT_PRICE = 59000, PARKPASS_1DAY_TEENAGER_PRICE = 52000, PARKPASS_1DAY_CHILDREN_PRICE = 46000, PARKPASS_1DAY_BABY_PRICE = 15000;			// 파크이용권 1DAY 
	const int PARKPASS_AFTER4_ADULT_PRICE = 47000, PARKPASS_AFTER4_TEENAGER_PRICE	= 41000, PARKPASS_AFTER4_CHILDREN_PRICE = 35000, PARKPASS_AFTER4_BABY_PRICE = 15000;  // 파크이용권 AFTER4
	
	
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
	
	do{
		printf("\n=================롯데월드=================\n\n");
		scanf 
	}
	
	// 해당 시간이 되면 프로그램에 적용될 수 있게 시간 함수를 적용하였다. 
	struct tm*t;						// localtime 함수를 사용하여 tm 구조체를 활용, 원하는 형태로 변환한다.
	time_t base = time(NULL);   		// 1970년 1월 1일 0시 0분 0초부터 시작하여 현재까지의 초
	t = localtime(&base); 				
	
	BirthYear = juminnum_Front/10000;   // 생년월일에서 '연도' 출력
	BirthMonth = (juminnum_Front - (juminnum_Front * 10000))  * 100 / 10000;   // 생년월일에서 '월' 부분 출력 
	// 100 / 10000 = 0.01이라서 0.01을 곱해주면 되지 않냐고 생각할 수 있지만 프로그램을 돌렸을 때 문제없이 돌아가는 경우도 있지만
	// 그렇지 않은 경우도 존재하기 때문에 0.01을 바로 곱해주지 않고 100으로 곱하고 10000으로 나눈 과정을 진행해주었다.
	BirthDay = juminnum_Front - (BirthYear * 10000) - (BirthMonth * 100);      // 생년월일에서 '일' 부분 출력
	
		
	//	뒷부분 7자리 맨 앞부분은 성별을 나타내는데 1은 남자, 2는 여자이다.
	//	1: 1900 ~ 1999년에 태어난 남성
	//	2: 1900 ~ 1999년에 태어난 여성
	//	3: 2000 ~ 2099년에 태어난 남성
	//	4: 2000 ~ 2099년에 태어난 여성
	
	
	// tm_year와 tm_mon의 사용법에 주의
	// tm_year는 1900년도부터의 년이기에 출력하고 싶은 년도를 1900년도에 + 해서 사용해야 한다.
	// tm_mon은 1월부터 12월까지 출력하기 위해서는 +1을 해서 사용하여야 한다. 
	if(juminnum_Back == 1 || juminnum_Back == 2)
	{
		Generation_1900 = BirthYear + 1900;
	} else if(juminnum_Back == 3 || juminnum_Back == 4)
	{
		Generation_2000 = BirthYear + 2000;
	}
	
	if(Generation_1900 < 2000) {
		if(BirthMonth <= t->tm_mon + 1 && BirthDay <= t->tm_mday)
		{
			age = (t->tm_year + 1900) - Generation_1900;
		} else if(BirthMonth > t->tm_mon + 1)					// 월 
		{
			age = (t->tm_year + 1900) - Generation_1900 - 1;
		} else if(BirthDay > t->tm_mday){						// 일 
			age = (t->tm_year + 1900) - Generation_1900 - 1; 
		}
	}
	
	if(Generation_2000 >= 2000) {
		if(BirthMonth <= t->tm_mon + 1 && BirthDay <= t->tm_mday)
		{
			age = (t->tm_year + 1900) - Generation_2000;
		} else if(BirthMonth > t->tm_mon + 1)
		{
			age = (t->tm_year + 1900) - Generation_2000 - 1;
		} else if(BirthDay > t->tm_mday)
		{
			age = (t->tm_year + 1900) - Generation_2000 - 1;
		}
	}
	
	switch(choice){
		case 1:   // 종합이용권 선택했을 때 
			switch(ticket){
				case 1:   // 1DAY 선택했을 때 
					if(age <= 3)
					{
						Price = GENERALPASS_1DAY_BABY_PRICE;
					} else if(age > 3 && age <= 12)
					{
						Price = GENERALPASS_1DAY_CHILDREN_PRICE;
					} else if(age > 12 && age <= 18)
					{
						Price = GENERALPASS_1DAY_TEENAGER_PRICE;
					} else if(age > 19 && age < 65)
					{
						Price = GENERALPASS_1DAY_ADULT_PRICE;
					} else if(age >= 65)
					{
						Price = GENERALPASS_1DAY_CHILDREN_PRICE;
					}
					break; 
				
				case 2:  // AFTER4 선택했을 때 
					if(age <= 3)
					{
						Price = GENERALPASS_AFTER4_BABY_PRICE;
					} 	else if(age > 3 && age <= 12)
					{
						Price = GENERALPASS_AFTER4_CHILDREN_PRICE;
					}  	else if(age > 12 && age <= 18)
					{
						Price = GENERALPASS_AFTER4_TEENAGER_PRICE;
					}	else if(age > 19 && age < 65)
					{
						Price = GENERALPASS_AFTER4_ADULT_PRICE;
					}	else if(age >= 65)
					{
						Price = GENERALPASS_AFTER4_CHILDREN_PRICE;
					}
					break;	
			}
			break;
			
		case 2:    // 파크이용권 선택했을 때 
			switch(ticket){ 
				case 1:   // 1DAY 선택했을 때 
					if(age <= 3)
					{
						Price = PARKPASS_1DAY_BABY_PRICE;
					} else if(age > 3 && age <= 12)
					{
						Price = PARKPASS_1DAY_CHILDREN_PRICE;
					} else if(age > 12 && age <= 18)
					{
						Price = PARKPASS_1DAY_TEENAGER_PRICE;
					} else if(age > 19 && age < 65)
					{
						Price = PARKPASS_1DAY_ADULT_PRICE;
					} else if(age >= 65)
					{
						Price = PARKPASS_1DAY_CHILDREN_PRICE;
					}
					break;
					
				case 2:  // AFTER4 선택했을 때 
					if(age <= 3)
					{
						Price = PARKPASS_AFTER4_BABY_PRICE;
					} 	else if(age > 3 && age <= 12)
					{
						Price = PARKPASS_AFTER4_CHILDREN_PRICE;
					}  	else if(age > 12 && age <= 18)
					{
						Price = PARKPASS_AFTER4_TEENAGER_PRICE;
					}	else if(age > 19 && age < 65)
					{
						Price = PARKPASS_AFTER4_ADULT_PRICE;
					}	else if(age >= 65)
					{
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
		case 1:
			SpecialPrice = Price;
			break;	
		
		case 2:
			SpecialPrice = Price * 0.5;
			break;
		
		case 3:
			SpecialPrice = Price * 0.5;
			break;
		
		case 4:  
			if(choice == 1)
			{
				SpecialPrice = Price * 0.49;   // 휴가 장병의 경우 종합이용권만 49 % 우대 
			} else if(choice == 2)
			{
				SpecialPrice = Price;
			}
			break;
		
		case 5:
			if(choice == 1)
			{
				SpecialPrice = Price * 0.5;
			} else if(choice == 2)
			{
				SpecialPrice = Price;
			}
			break;
		
		case 6:
			if(choice == 1)
			{
				SpecialPrice = Price * 0.3;
			} else if(choice == 2)
			{
				SpecialPrice = Price;
			}
			break;
		} 
		
		Total = SpecialPrice * OrderCount;
		printf("가격은 %d 원 입니다.\n감사합니다.", Total);
		
		return 0;
		
}


// 처음부터 모든 수치를 2차원 배열로 저장해라
 
