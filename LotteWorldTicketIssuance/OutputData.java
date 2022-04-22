package LotteWorldTicketIssuance;

import java.util.Scanner;

public class OutputData {
	
	Scanner sc = new Scanner(System.in);
	
	// Loop
	public int [][] ticketTable = new int[15][10];
	public int orderCount;
	
	// �Ʒ� �Լ��鿡 ���Ǵ� �������� �������� ���� ��ü�� �����Ͽ����ϴ�.
	InputData input = new InputData();
	CalculateData calculate = new CalculateData();

	public int total;
	
	
	
	
	


void ticketTableLoop() {
   
// 2���� �迭�� �ݺ����� Ȱ���Ͽ� index�� �����ϸ鼭 ��쿡 ���� �ʿ��� ������ �������� �Ͽ����ϴ�.
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


void finalOutput() {

	do {
 	 
 	  // �Լ�ȣ��
 	  input.choiceTicket();
      input.jumin_manAge();
      input.ticketOrderCount();
      input.PreferentialTreatment();
      input.additionalTicket();
      
      // �ش� �Լ����� �ٸ� Ŭ������ ������ �ʿ�� �߱⿡ ��ȣ�ȿ� �ش� ���ڸ� �־��־����ϴ�.
      calculate.personAgeCase(input);     
      calculate.personAgePrice(input);
      calculate.preferentialTreatmentPrice(input);         	          
          
      // ��������
      total = calculate.specialPrice * input.ticketCount;
      System.out.printf("������ %d �� �Դϴ�.\n�����մϴ�.\n", total);
      
      // 2���� �迭
      ticketTable[orderCount][0] = input.choice;     	// �̿��
      ticketTable[orderCount][1] = input.ticket;     	// �ð���
      ticketTable[orderCount][2] = calculate.person;    // ���ɴ�
      ticketTable[orderCount][3] = input.ticketCount; 	// �ֹ��� ����� ������ Ƽ�� �� ��
      ticketTable[orderCount][4] = total;      			// �ջ� ����
      ticketTable[orderCount][5] = input.special;      	// ��� ����
      orderCount++;
      
      
      // ������ �� ���� �̿��, ����, ����, ����, �ݾ�, ������ : �� 6 �׸�
      System.out.printf("================================�Ե� ����==================================\n");
      System.out.printf("%-12s %-12s %-12s %-5s %10s %20s\n", "�̿��", "����", "����", "����", " �ݾ�", "��� ����");
      System.out.printf("---------------------------------------------------------------------------\n");
    
      ticketTableLoop();

      System.out.printf("\n");
      System.out.printf("---------------------------------------------------------------------------\n");
      System.out.printf("��� �߱��Ͻðڽ��ϱ�?\n1. ��� �߱�\n2. �߱� ����\n");
      int continuingTicket = sc.nextInt();
        } while(input.continuingTicket == 1);  // ��� �߱� ���θ� ���� 1�� �Է��ϸ� ���� ������ �ݺ��ϵ��� �Ͽ����ϴ�
        
      System.out.printf("Ƽ�� �߱��� �����մϴ�.\n");
    
}
}