#include <stdio.h>
#include <time.h>

int main() {
   //   �ֹε�Ϲ�ȣ�� �Է� �޴´�. (�ֹι�ȣ�� Ȱ���Ͽ� ���̸� �ڵ�����Ѵ�.)
   //   �ֹ� ������ �Է¹޴´�.
   //   �������� �Է¹޴´�. (����, �����, ����������, ���ڳ�, �ӻ��)
   //   ���� �Է��� �ݺ��� ������ ������ ������ �����.
   //   ���Ḧ �ϰԵǸ� ���ݱ��� �ֹ� ������ ��� ��µȴ�.
   //   ���� ���α׷� ���Ḧ �ϰ� �Ǹ� ��������� ���� ������ ���Ϸ� �����Ѵ�.


   // �ʿ��� ������ 
   int choice, ticket, juminnum_Front, juminnum_Back, 
   OrderCount, BirthYear, BirthDay, BirthMonth, 
   Generation_1900, Generation_2000, age, Person, Price, SpecialPrice, 
   Total, Continuing_Ticket;
   
   int Special = 0;
   int index = 1;
   
   
   int TicketTable[15][10] = {0};  // 2���� �迭 �ʱ�ȭ 
   
   // �迭 ������ �� ���� ���� ! 
   // �迭�� �˳��ϰ� �������� �̻��� ���� ������ ������ ������ �ʴ´�.
   // ���� �迭�� �˳��ϰ� ���������  
  
   // ����� ������ ����� ���� 
   const int GENERALPASS_1DAY_ADULT_PRICE = 62000, GENERALPASS_1DAY_TEENAGER_PRICE = 54000, GENERALPASS_1DAY_CHILDREN_PRICE = 47000, GENERALPASS_1DAY_BABY_PRICE = 15000;        // �����̿�� 1DAY
   const int GENERALPASS_AFTER4_ADULT_PRICE = 50000, GENERALPASS_AFTER4_TEENAGER_PRICE = 43000, GENERALPASS_AFTER4_CHILDREN_PRICE = 36000, GENERALPASS_AFTER4_BABY_PRICE = 15000;  // �����̿�� AFTER4
   const int PARKPASS_1DAY_ADULT_PRICE = 59000, PARKPASS_1DAY_TEENAGER_PRICE = 52000, PARKPASS_1DAY_CHILDREN_PRICE = 46000, PARKPASS_1DAY_BABY_PRICE = 15000;         // ��ũ�̿�� 1DAY 
   const int PARKPASS_AFTER4_ADULT_PRICE = 47000, PARKPASS_AFTER4_TEENAGER_PRICE   = 41000, PARKPASS_AFTER4_CHILDREN_PRICE = 35000, PARKPASS_AFTER4_BABY_PRICE = 15000;  // ��ũ�̿�� AFTER4
   

   //do while�� => while�� �ȿ� �ִ� ������ �����ϸ� do�� ����. 
   do{
      printf("\n==========================================\n\n");
      printf("�����Ͻ� �̿���� �������ּ���.\n1. �����̿��(�Ե����� + �μӹڹ���)\n2. ��ũ�̿��(�Ե�����)\n");
      scanf("%d", &choice);
      printf("\n==========================================\n\n");
   } while(!(choice == 1 || choice == 2));
   
   do{
      printf("\n������ �������ּ���.\n1. 1DAY\n2. AFTER4(����4�� ����)\n");
      scanf("%d", &ticket);
      printf("\n==========================================\n\n");
   } while(!(ticket == 1 || ticket == 2));
   
   do{
      printf("\n�ֹε�Ϲ�ȣ ���ڸ� 6�ڸ��� ���ڸ� 1�ڸ��� �Է����ּ���.\n���ڸ�(6�ڸ�)\n");
      scanf("%d", &juminnum_Front);
      printf("\n==========================================\n\n");
   } while(!(juminnum_Front > 000001 || juminnum_Front < 999999));
   
   do{
      printf("\n���ڸ�(�� �ڸ�)\n");
      scanf("%1d", &juminnum_Back);
      printf("\n==========================================\n\n");
   } while(!(juminnum_Back == 1|| juminnum_Back ==2 || juminnum_Back == 3|| juminnum_Back == 4));
   
   do{
      printf("\n�� ���� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)\n");
      scanf("%d", &OrderCount);
      printf("\n==========================================\n\n");
   } while(!(OrderCount >= 1 || OrderCount < 11));
   
   do{
      printf("�������� �����ϼ���.\n1. ����(���� ���� �ڵ�ó��)\n2. ����� ���\n3. ���������� ���\n4. �ް��庴 ���\n5. �ӻ�� ���\n6. �ٵ��� �ູī�� ���\n");
      scanf("%d", &Special);
      printf("\n==========================================\n\n");
   } while(!(Special == 1 || Special == 2 || Special ==3 || Special == 4 || Special == 5 || Special == 6));
   
   do{
      printf("��� �߱� �Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����\n");
      scanf("%d", &Continuing_Ticket);
      printf("\n==========================================\n\n");
   }while(!(Continuing_Ticket == 1 || Continuing_Ticket == 2));
   
   
   // �ش� �ð��� �Ǹ� ���α׷��� ����� �� �ְ� �ð� �Լ��� �����Ͽ���. 
   struct tm*t;                  // localtime �Լ��� ����Ͽ� tm ����ü�� Ȱ��, ���ϴ� ���·� ��ȯ�Ѵ�.
   time_t base = time(NULL);         // 1970�� 1�� 1�� 0�� 0�� 0�ʺ��� �����Ͽ� ��������� ��
   t = localtime(&base);             
   
   BirthYear = juminnum_Front/10000;   // ������Ͽ��� '����' ���
   BirthMonth = (juminnum_Front - (juminnum_Front * 10000))  * 100 / 10000;   // ������Ͽ��� '��' �κ� ��� 
   // 100 / 10000 = 0.01�̶� 0.01�� �����ָ� ���� �ʳİ� ������ �� ������ ���α׷��� ������ �� �������� ���ư��� ��쵵 ������
   // �׷��� ���� ��쵵 �����ϱ� ������ 0.01�� �ٷ� �������� �ʰ� 100���� ���ϰ� 10000���� ���� ������ �������־���.
   BirthDay = juminnum_Front - (BirthYear * 10000) - (BirthMonth * 100);      // ������Ͽ��� '��' �κ� ���
   
      
   //   �޺κ� 7�ڸ� �� �պκ��� ������ ��Ÿ���µ� 1�� ����, 2�� �����̴�.
   //   1: 1900 ~ 1999�⿡ �¾ ����
   //   2: 1900 ~ 1999�⿡ �¾ ����
   //   3: 2000 ~ 2099�⿡ �¾ ����
   //   4: 2000 ~ 2099�⿡ �¾ ����
   
   
   // tm_year�� tm_mon�� ������ ����
   // tm_year�� 1900�⵵������ ���̱⿡ ����ϰ� ���� �⵵�� 1900�⵵�� + �ؼ� ����ؾ� �Ѵ�.
   // tm_mon�� 1������ 12������ ����ϱ� ���ؼ��� +1�� �ؼ� ����Ͽ��� �Ѵ�. 
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
		 } else if(BirthDay > t->tm_mday){                  // �� 
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
   
   // ���ɴ뿡 �°� ó���ϱ� ���ϵ��� ���ǽ� ������� 
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
      case 1:   // �����̿�� �������� �� 
         switch(ticket){
            case 1:   // 1DAY �������� �� 
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
            
            case 2:  // AFTER4 �������� �� 
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
         
      case 2:    // ��ũ�̿�� �������� �� 
         switch(ticket){ 
            case 1:   // 1DAY �������� �� 
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
               
            case 2:  // AFTER4 �������� �� 
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
         printf("�ٽ� �Է����ּ���.");
         }
      
   
   // ������ ����
   switch(Special) {
      case 1:   // ������ ���� 
         SpecialPrice = Price; 
         break;   
      
      case 2:   // ����� ��� 
         SpecialPrice = Price * 0.5;
         break;
      
      case 3:   // ���� ������ ��� 
         SpecialPrice = Price * 0.5;
         break;
      
      case 4:   // �ް��庴 ��� 
         if(choice == 1) {
            SpecialPrice = Price * 0.49;   // �ް� �庴�� ��� �����̿�Ǹ� 49 % ��� 
         } else if(choice == 2) {
            SpecialPrice = Price;
         }
         break;
      
      case 5:  // �ӻ�� ��� 
         if(choice == 1) {
            SpecialPrice = Price * 0.5;
         } else if(choice == 2) {
            SpecialPrice = Price;
         }
         break;
      
      case 6:   // �ٵ��� �ູī�� ��� 
         if(choice == 1) {
            SpecialPrice = Price * 0.3;
         } else if(choice == 2) {
            SpecialPrice = Price;
         }
         break;
      } 
      
      Total = SpecialPrice * OrderCount;
      
      printf("������ %d �� �Դϴ�.\n�����մϴ�.\n\n", Total);
      
      
	  TicketTable[1][index] = choice;  // �̿�� 
      TicketTable[1][index] = ticket;  // �ð��� 
      TicketTable[1][index] = Person;  // ���ɴ� 
      TicketTable[1][index] = OrderCount; // �ֹ� ���� 
      TicketTable[1][index] = Total;    // �ջ� ���� 
      TicketTable[1][index] = Special;  // ������ 
      index++;
      
      // = �� ���� üũ���ֱ�
	  // ������ �� ���� �̿��, ����, ����, ����, �ݾ�, ������ : �� 6�׸� 
	  printf("============================�Ե� ����==============================\n" );   // �� 51��	  
      printf("%-12s %-10s %-6s      %-4s %5s %19s\n", "�̿��", "����", "����", "����", " �ݾ�", "��� ����");
	  printf("-------------------------------------------------------------------\n");
	  
	  
	switch(choice) {
		case 1:
			printf("�����̿��");
			break;
		case 2:
			printf("��ũ�̿��");
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
			printf("    ����");
			break; 
		
		case 1 :
			printf("    ���");
			break;
			
		case 2 :
			printf("    û�ҳ�");
			break;
			
		case 3 :
			printf("    ����");
		 	break;
			
		case 4 :
			printf("    ����");
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
			printf("         ������ ����\n");
			break;
			
		case 2 :
			printf("         ����� ���\n");
			break;
		
		case 3 :
			printf("         ����������\n");
			break;
			
		case 4 :
			printf("         �ް��庴\n");
			break;
		
		case 5 :
			printf("         �ӻ�� ���\n");
			break;
						 
		case 6 :
			printf("         �ٵ��� �ູī��\n");
			break;
	}	
}
	 

// �ѹ��� �߱��� �ƴ϶� ��� �߱��ؼ� ���� ���� ����� �� �ֵ��� �ؾ��Ѵ�.
