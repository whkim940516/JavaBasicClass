package LotteWorldTicketIssuance;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main2 {
	
	      public static void main(String[] args) {
	    	  
	    	  Scanner sc = new Scanner(System.in);
	    	  
	    	  // �Լ� ȣ���� ���� ltw��ü ����
	    	  Main2 ltw = new Main2();
	    	  InputData input = new InputData();
//	    	  input.jumin_manAge();
//	    	  System.out.println(input.manAge);
	    	  
	    	  CalculateData calculate = new CalculateData();
	    	  
	    	  OutputData output = new OutputData();
	    	  
	    	  int total;
	    	  
//	    	  int [][] ticketTable = new int[15][10];   �� �κ� ������ ���ڸ� ����� ȣ����� ������ 
//                                    => �ʵ忡�� ������ �������־��� ������ ���⼭�� �������� �ʿ䰡 ����.
	          System.out.println();
	    	  
	          do {
	        	 
	        	 // �Լ�ȣ��
	        	 input.choiceTicket();
	             input.jumin_manAge();
	             input.ticketOrderCount();
	             input.PreferentialTreatment();
	             input.additionalTicket();
	             calculate.personAgeCase();
	             calculate.personAgePrice();
	             calculate.preferentialTreatmentPrice();
            	           	          
	             System.out.printf("%d", calculate.specialPrice * input.ticketCount);
	             
	             // ��������
	             total = calculate.specialPrice * input.ticketCount;
	             System.out.printf("������ %d �� �Դϴ�.\n�����մϴ�.\n", total);
	             
	             // 2���� �迭
	             output.ticketTable[output.orderCount][0] = input.choice;     // �̿��
	             output.ticketTable[output.orderCount][1] = input.ticket;     // �ð���
//	             System.out.printf("%d", person);
	             output.ticketTable[output.orderCount][2] = calculate.person;     // ���ɴ�
	             output.ticketTable[output.orderCount][3] = input.ticketCount; // �ֹ��� ����� ������ Ƽ�� �� ��\
	             output.ticketTable[output.orderCount][4] = total;      // �ջ� ����
	             output.ticketTable[output.orderCount][5] = input.special;      // ��� ����
	             output.orderCount++;
	             
	             
	             // '='�� ���� üũ���ֱ�
	             // ������ �� ���� �̿��, ����, ����, ����, �ݾ�, ������ : �� 6 �׸�
	            System.out.printf("================================�Ե� ����==================================\n");
	            System.out.printf("%-12s %-12s %-12s %-5s %10s %20s\n", "�̿��", "����", "����", "����", " �ݾ�", "��� ����");
	            System.out.printf("---------------------------------------------------------------------------\n");

//	 	      	System.out.printf("a : %d\n", ticketTable[0][0]);
//				System.out.printf("b : %d\n", ticketTable[0][1]);
	             
	            output.ticketTableLoop();

	             System.out.printf("\n");
	             System.out.printf("---------------------------------------------------------------------------\n");
	             System.out.printf("��� �߱��Ͻðڽ��ϱ�?\n1. ��� �߱�\n2. �߱� ����\n");
	             int continuingTicket = sc.nextInt();
	               } while(input.continuingTicket == 1);
	               
	             System.out.printf("Ƽ�� �߱��� �����մϴ�.\n");
	           
	       }
	      
	    }	

// ������ �����ϴ� ���� �������� ȣ��Ǹ鼭 �ش� �Լ��� ���ѷ������� ��Ȳ => nextInt�� �Է��� �����ʾƼ� ���� ���� ���� �ذ���
// �ֹε�Ϲ�ȣ ������ ��ģ�� ������ �׷�����?  => ��� ������
// 2���� �迭�� �ùٷ� ��µ��� �ʴ� ����
// ����, �ݾ� �κп� �̻��� ����   => ���� �Լ� �ۿ� �ִ� �ʵ忡�� �������� �κа� �����Լ����� ������ �������� ���ư� �̷� ���� ���ڸ� �ùٷ� ���� ���ؼ�
//  							���� �� ��µǴ� ������ �߻��߰� �ʵ忡 manAge = 0 ;�̶�� ������ �����߱� ������ �Լ����� ���������� ���� �ʿ䰡 ������.
//                              ������ ������ ���� ������ ���� Ȯ������
	


