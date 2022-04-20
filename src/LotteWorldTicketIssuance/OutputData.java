package LotteWorldTicketIssuance;

public class OutputData {
	
	// Loop
	public int [][] ticketTable = new int[15][10];
	public int orderCount;



void ticketTableLoop() {
    
//	뭔가 이상할 때는 printf문을 찍어서 잘 들어갔는지 확인해준다.
//    인자 비교를 위해 문자를 다르게 a,b,c,d로 구분해줌
//	System.out.printf("c : %d\n", ticketTable[0][0]);
//	System.out.printf("d : %d\n", ticketTable[0][1]);
	
  
  
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
}