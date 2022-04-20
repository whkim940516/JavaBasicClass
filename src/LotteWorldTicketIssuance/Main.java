package LotteWorldTicketIssuance;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {
		  
		  // �� ������ �����Լ��� �ƴϰ� �Լ��� �ƴ� �ʵ� �����̴�.
		  // ���� �� ���� ������ �����ϸ� �Լ� �������� �ٽ� �������� �ʿ䰡 ����.
		  // �Ǽ��� �Լ������� ���������� ���־��� ��� �������� ������ �Ķ����� ��������� ���е� ���̸�
		  // �̴� � ���ڸ� �޴����� ����Ǳ� ������ �̸� �ݵ�� ������ �� �־�� �Ѵ�.
		  // ������ ��ƴٸ� sysout�� ���� �ش� ���ڸ� ����غ���.
		  // ������ �� �κ� ������ ������ ���ڸ� �޾Ƽ�(���� �ٸ� ����) ���� ������ �����Ͽ���.
			
	
	      // ���� ����
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
	      
	      
	      
	      // 2���� �迭 �ʱ�ȭ
	      public static int [][] ticketTable = new int[15][10];
	      
	      
	      // ����� ������ ����� ����
	   
	      // �����̿�� 1DAY
	      static final int GENERALPASS_1DAY_ADULT_PRICE = 62000;
	      static final int GENERALPASS_1DAY_TEENAGER_PRICE = 54000;
	      static final int GENERALPASS_1DAY_CHILDREN_PRICE = 47000;
	      static final int GENERALPASS_1DAY_BABY_PRICE = 15000;
	      
	      // �����̿�� AFTER 4
	      static final int GENERALPASS_AFTER4_ADULT_PRICE = 50000;
	      static final int GENERALPASS_AFTER4_TEENAGER_PRICE = 43000;
	      static final int GENERALPASS_AFTER4_CHILDREN_PRICE = 36000;
	      static final int GENERALPASS_AFTER4_BABY_PRICE = 15000;
	      
	      // ��ũ�̿�� 1DAY
	      static final int PARKPASS_1DAY_ADULT_PRICE = 59000;
	      static final int PARKPASS_1DAY_TEENAGER_PRICE = 52000;
	      static final int PARKPASS_1DAY_CHILDREN_PRICE = 46000;
	      static final int PARKPASS_1DAY_BABY_PRICE = 15000;
	      
	      // ��ũ�̿�� AFTER 4
	      static final int PARKPASS_AFTER4_ADULT_PRICE = 47000;
	      static final int PARKPASS_AFTER4_TEENAGER_PRICE = 41000;
	      static final int PARKPASS_AFTER4_CHILDREN_PRICE = 35000;
	      static final int PARKPASS_AFTER4_BABY_PRICE = 15000;
	      
	      
	      // �̿�� �� ���� ����
	      public void choiceTicket() {
	            
	         do{
	            System.out.print("\n==========================================\n\n");
	            System.out.print("�����Ͻ� �̿���� �������ּ���.\n1. �����̿��(�Ե����� + �μӹڹ���)\n2. ��ũ�̿��(�Ե�����)\n");
	            Scanner sc = new Scanner(System.in);
	            choice = sc.nextInt();
	            System.out.print("\n==========================================\n\n");
	         } while(!(choice == 1 || choice == 2));
	   
	         do{
	              System.out.print("\n������ �������ּ���.\n1. 1DAY\n2. AFTER4(����4�� ����)\n");
	              Scanner sc = new Scanner(System.in);
	              ticket = sc.nextInt();
	              System.out.print("\n==========================================\n\n");         
	            } while(!(ticket == 1 || ticket == 2));
	         
	         }
	      
	      // �ֹε�Ϲ�ȣ�� ������ ���
	      public static void jumin_manAge() {
	          
	        /*��¥ �ð� �޾ƿ��� => ��ǻ�� �ý����� ��¥�� �ý����� ��� ���� Date�� ���

	              SimpleDateFormat? => ��¥ �� �ð��� ��� ������ ������ �� ���.

	              SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	              2019�� 8�� 28�Ϸ� ��µǴ� ���� �ƴ� 20190828�� ����ϱ� ���� yyyyMMdd�� �Է��ؾ���.

	              String today = format.format(new Date());�� �Է��� �� Sysout���� today�� ����ϸ�


	              ���� ��¥�� 20190828�� ��µ�.*/

	    	System.out.println("'-'�� ������ �ֹε�Ϲ�ȣ�� �Է��ϼ���.");
	        Scanner sc = new Scanner(System.in);
	        String jumin = sc.next(); 
//	        int manAge = 0;  �ʵ忡 ������ �����ϱ� ���⼭�� ������ ���ָ� ������ ������ �� �� ����
	        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        String today = format.format(new Date());
	        System.out.println("���� ��¥ Ȯ�� : " + today);
	        
	        // substring�� Ȱ���� ���� �������� ����
	        // String => int�� ����ȯ
	        int thisYear = Integer.parseInt(today.substring(0, 4));
	        int thisMonth = Integer.parseInt(today.substring(4, 6));
	        int thisDay = Integer.parseInt(today.substring(6, 8));

	        
	        // �ֹε�ϻ��� ������ ����
	        // String => int�� ����ȯ
	        // ���� ����� ���� int�� ����ȯ �Ѵ�.
	        int juminYear = Integer.parseInt(jumin.substring(0,2));
	        int juminMonth = Integer.parseInt(jumin.substring(2,4));
	        int juminDay = Integer.parseInt(jumin.substring(4,6));

	 
	        /*8��° �ڸ��� 0�Ǵ� 9�� ���, 1800���� ���
	          1�Ǵ� 2�� ��� 1900���� ���
	          3�Ǵ� 4�� ��� 2000���� ���*/
	        
	        // ex) �ֹε�Ϲ�ȣ 111111-1111111 
	        //                     1        ��ġ�� ��ȯ�ϱ����� charAt(7)�� ���
	        if(jumin.charAt(7) == '0' || jumin.charAt(7) == '9') {
	           juminYear = 1800 + juminYear;
	        } else if(jumin.charAt(7) == '1' || jumin.charAt(7) == '2') {
	           juminYear = 1900 + juminYear;
	        } else if(jumin.charAt(7) == '3' || jumin.charAt(7) == '4') {
	           juminYear = 2000 + juminYear;
	        }
	        
	        /* �� ����
	         * ���� ���� - �¾ ��
	         */
	        manAge = thisYear - juminYear;
	        
	        /* ��������� "��"�� �����°�?
	         * ��������� "��"�� �����°�?
	         */
	        
	        if(juminMonth > thisMonth) {   // �ֹι�ȣ�� ���� ���� ��¥�� ������ ������
	           manAge = manAge-1;         // �� ���� ���� ����
	           System.out.println("�� ���� ��� ��� : " + manAge);
	        }else if(juminMonth == thisMonth) {   // �ֹι�ȣ;�� ���� ���糯¥�� ���� ���� ���
	           if(juminDay > thisDay) {          // �ֹι�ȣ�� ���ڰ� �� ������ 
	              manAge = manAge-1;           // �� ���� ���� ����
	              System.out.println("�� ���� ��� ��� : " + manAge--);
	        }else {
	           System.out.println("�� ���� ��� ��� : " + manAge);
	        }
	        
	     }else {
	        System.out.println("�� ���� ��� ��� : " + manAge);
	     }
	      
	    }
	       

	      // Ƽ�� ����
	      public static void ticketOrderCount() {
	         
	         do {
	            System.out.print("\n�� ���� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)\n");
	            Scanner sc = new Scanner(System.in);
	            ticketCount = sc.nextInt();
	            System.out.print("\n==========================================\n\n");
	         } while(!(ticketCount >= 1 || ticketCount < 11));
	      }
	      
	      
	      // ��� ����
	      public static void PreferentialTreatment() {
	         
	         do {
	            System.out.print("�������� �����ϼ���.\n1. ����(���� ���� �ڵ�ó��)\n2. ����� ���\n3. ���������� ���\n4. �ް��庴 ���\n5. �ӻ�� ���\n6. �ٵ��� �ູī�� ���\n");
	            Scanner sc = new Scanner(System.in);
	            special = sc.nextInt();
	            System.out.print("\n==========================================\n\n");
	         } while(!(special == 1 || special == 2 || special ==3 || special == 4 || special == 5 || special == 6));      
	      }
	         
	      
	      // �߰� �߱� ����
	      public static int additionalTicket() {

	         do {
	            System.out.print("��� �߱� �Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����\n");
	            Scanner sc = new Scanner(System.in);
	            continuingTicket = sc.nextInt();
	            System.out.print("\n==========================================\n\n");
	         } while(!(continuingTicket == 1|| continuingTicket == 2));
	         
	         return continuingTicket;
	      }                          
	      
	      // ���ɴ뿡 �°� ó���ϱ� ���ϵ��� ���ǽ� �������
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
	      

	      // ���ɴ뿡 ���� ����
	      public static void personAgePrice() {
	         
	         switch(choice){
	             case 1:   // �����̿�� �������� �� 
	                switch(ticket){
	                   case 1:   // 1DAY �������� �� 
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
	                   
	                   case 2:  // AFTER4 �������� �� 
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
	             
	             case 2:    // ��ũ�̿�� �������� �� 
	                switch(ticket){ 
	                   case 1:   // 1DAY �������� �� 
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
	                      
	                   case 2:  // AFTER4 �������� �� 
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
	                System.out.print("�ٽ� �Է����ּ���.");
	             }
	         }
	      
	      
	      // ������ ����
	      public static void preferentialTreatmentPrice() {

	         switch(special) {
	            case 1:   // ������ ���� 
	                  specialPrice = price; 
	                  break;   
	               
	               case 2:   // ����� ��� 
	                  specialPrice = (int)((float)price * 0.5);
	                  price = price - specialPrice;
	                  break;
	               
	               case 3:   // ���� ������ ��� 
	                  specialPrice = (int)((float)price * 0.5);
	                  price = price - specialPrice;
	                  break;
	               
	               case 4:   // �ް��庴 ��� 
	                  if(choice == 1) {
	                  specialPrice = (int)((float)price * 0.49);   // �ް� �庴�� ��� �����̿�Ǹ� 49 % ���
	                  price = price - specialPrice; 
	                  } else if(choice == 2) {
	                     specialPrice = price;
	                  }
	                  break;
	               
	               case 5:  // �ӻ�� ��� 
	                  if(choice == 1) {
	                     specialPrice = (int)((float)price * 0.5);
	                     price = price - specialPrice;
	                  } else if(choice == 2) {
	                     specialPrice = price;
	                  }
	                  break;
	               
	               case 6:   // �ٵ��� �ູī�� ��� 
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
	         
//				���� �̻��� ���� printf���� �� �� ������ Ȯ�����ش�.
//	    	    ���� �񱳸� ���� ���ڸ� �ٸ��� a,b,c,d�� ��������
//				System.out.printf("c : %d\n", ticketTable[0][0]);
//				System.out.printf("d : %d\n", ticketTable[0][1]);
				
	    	  
	    	  
	         for(int index = 0; index < orderCount; index++) {
	            switch(ticketTable[index][0]) {
	            
	               case 1 :
	                  System.out.printf("%-12s", "�����̿��");
	                  break;
	                  
	               case 2 :
	                  System.out.printf("%-12s", "��ũ�̿��");
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
	                    System.out.printf("%-12s", "  ����");
	                    break;
	               case 1 :
	                    System.out.printf("%-12s", "  ���");
	                    break;
	               case 2 :
	                    System.out.printf("%-12s", "  û�ҳ�");
	                    break;
	               case 3 :
	                    System.out.printf("%-12s", "  �");
	                    break;
	               case 4 :
	                    System.out.printf("%-12s", "  ����");
	                    break;
	              }
	           
	           System.out.printf("%5d ��", ticketTable[index][3]);
	           System.out.printf("%10d ��", ticketTable[index][4]);
	           
	           switch(ticketTable[index][5]) {
	                 case 1 :
	                    System.out.printf("%20s", "������ ����\n\n");
	                    break;
	                    
	                 case 2 :
	                    System.out.printf("%20s", "����� ���\n\n");
	                    break;
	                    
	                 case 3 :
	                    System.out.printf("%20s", "����������\n\n");
	                    break;
	                    
	                 case 4 :   
	                	System.out.printf("%20s", "�ް� �庴\n\n");
	                	break;
	                  
	                 case 5 :
	                	System.out.printf("%20s", "�ӻ�� ���\n\n");
	                	break;
	                  
	                 case 6:
	                	System.out.printf("%20s", "�ٵ��� �ູī��\n\n");
	                	break;
	              }
	            
	            
	         }
	      }
	       
	      
	      public static void main(String[] args) {
	    	  
	    	  // �Լ� ȣ���� ���� ltw��ü ����
	    	  Main ltw = new Main();
	    	  InputData input = new InputData();
	    	  input.jumin_manAge();
	    	  System.out.println(input.manAge);
//	    	  int [][] ticketTable = new int[15][10];   �� �κ� ������ ���ڸ� ����� ȣ����� ������ 
//                                    => �ʵ忡�� ������ �������־��� ������ ���⼭�� �������� �ʿ䰡 ����.
	          System.out.println();
	    	  
	          do {
	        	 
	        	 // �Լ�ȣ��
	        	 ltw.choiceTicket();
	             ltw.jumin_manAge();
	             ltw.ticketOrderCount();
	             ltw.PreferentialTreatment();
	             ltw.additionalTicket();
	             ltw.personAgeCase();
	             ltw.personAgePrice();
	             ltw.preferentialTreatmentPrice();
            	           	          
	             System.out.printf("%d", specialPrice * ticketCount);
	             
	             // ��������
	             total = specialPrice * ticketCount;
	             System.out.printf("������ %d �� �Դϴ�.\n�����մϴ�.\n", total);
	             
	             // 2���� �迭
	             ticketTable[orderCount][0] = choice;     // �̿��
	             ticketTable[orderCount][1] = ticket;     // �ð���
//	             System.out.printf("%d", person);
	             ticketTable[orderCount][2] = person;     // ���ɴ�
	             ticketTable[orderCount][3] = ticketCount; // �ֹ��� ����� ������ Ƽ�� �� ��\
	             ticketTable[orderCount][4] = total;      // �ջ� ����
	             ticketTable[orderCount][5] = special;      // ��� ����
	             orderCount++;
	             
	             
	             // '='�� ���� üũ���ֱ�
	             // ������ �� ���� �̿��, ����, ����, ����, �ݾ�, ������ : �� 6 �׸�
	            System.out.printf("================================�Ե� ����==================================\n");
	            System.out.printf("%-12s %-12s %-12s %-5s %10s %20s\n", "�̿��", "����", "����", "����", " �ݾ�", "��� ����");
	            System.out.printf("---------------------------------------------------------------------------\n");

//	 	      	System.out.printf("a : %d\n", ticketTable[0][0]);
//				System.out.printf("b : %d\n", ticketTable[0][1]);
	             
	             ltw.ticketTableLoop();

	             System.out.printf("\n");
	             System.out.printf("---------------------------------------------------------------------------\n");
	             System.out.printf("��� �߱��Ͻðڽ��ϱ�?\n1. ��� �߱�\n2. �߱� ����\n");
	             Scanner sc = new Scanner(System.in);
	             int continuingTicket = sc.nextInt();
	               } while(continuingTicket == 1);
	               
	             System.out.printf("Ƽ�� �߱��� �����մϴ�.\n");
	           
	       }
	      
	    }	

// ������ �����ϴ� ���� �������� ȣ��Ǹ鼭 �ش� �Լ��� ���ѷ������� ��Ȳ => nextInt�� �Է��� �����ʾƼ� ���� ���� ���� �ذ���
// �ֹε�Ϲ�ȣ ������ ��ģ�� ������ �׷�����?  => ��� ������
// 2���� �迭�� �ùٷ� ��µ��� �ʴ� ����
// ����, �ݾ� �κп� �̻��� ����   => ���� �Լ� �ۿ� �ִ� �ʵ忡�� �������� �κа� �����Լ����� ������ �������� ���ư� �̷� ���� ���ڸ� �ùٷ� ���� ���ؼ�
//  							���� �� ��µǴ� ������ �߻��߰� �ʵ忡 manAge = 0 ;�̶�� ������ �����߱� ������ �Լ����� ���������� ���� �ʿ䰡 ������.
//                              ������ ������ ���� ������ ���� Ȯ������
	


