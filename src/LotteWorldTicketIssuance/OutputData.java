package LotteWorldTicketIssuance;

public class OutputData {
	
	// Loop
	public int [][] ticketTable = new int[15][10];
	public int orderCount;



void ticketTableLoop() {
    
//	���� �̻��� ���� printf���� �� �� ������ Ȯ�����ش�.
//    ���� �񱳸� ���� ���ڸ� �ٸ��� a,b,c,d�� ��������
//	System.out.printf("c : %d\n", ticketTable[0][0]);
//	System.out.printf("d : %d\n", ticketTable[0][1]);
	
  
  
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
}