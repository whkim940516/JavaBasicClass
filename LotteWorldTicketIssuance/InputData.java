package LotteWorldTicketIssuance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputData {
	
	// Scanner & SimpleDateFormat
	// ���������� ���Ǳ� ������ �ʵ忡 �����ϰ� �Լ� �������� �����־����ϴ�.
	Scanner sc = new Scanner(System.in);
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	// �̿�� �� ���� ����
	public int choice;
	public int ticket;
	
	// �ֹε�Ϲ�ȣ�� ������ ���
	public String jumin;   
	public String today;  
	public int thisYear;
	public int thisMonth;
	public int thisDay;
	public int juminYear;
	public int juminMonth;
	public int juminDay;
	public int manAge;
	
	// Ƽ�� ����
	public int ticketCount;
	
	// ��� ����
	public int special;
	
	// �߰� �߱� ����
	public int continuingTicket;
	
	 

	
	
	
	
void choiceTicket() {
		
		// while�� �ȿ� �ִ� ������ �����ϸ� do�� �����մϴ�.
		// 1,2�� �ƴϸ� ��� do �ȿ� �ִ� �ڵ尡 ������ �Ͽ� ����ó���� �Ͽ����ϴ�.
		do {
			System.out.print("\n==========================================\n\n");
			System.out.print("�����Ͻ� �̿���� �������ּ���.\n1. �����̿��(�Ե����� + �μӹڹ���)\n2. ��ũ�̿��(�Ե�����)\n");
			choice = sc.nextInt();
			System.out.print("\n==========================================\n\n");
		} while (!(choice == 1 || choice == 2));

		do {
			System.out.print("\n������ �������ּ���.\n1. 1DAY\n2. AFTER4(����4�� ����)\n");
			ticket = sc.nextInt();
			System.out.print("\n==========================================\n\n");
		} while (!(ticket == 1 || ticket == 2));

	}


void jumin_manAge() {
    
    
    // SimpleDateForma�� ��¥ �� �ð��� ��� ������ ������ �� ����մϴ�.
    System.out.println("'-'�� ������ �ֹε�Ϲ�ȣ�� �Է��ϼ���.");
    String jumin = sc.next(); 
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    String today = format.format(new Date());
    System.out.println("���� ��¥ Ȯ�� : " + today);
    
    // substring�� Ȱ���� ���� �������� �����Ͽ����ϴ�.
    // String => int�� ����ȯ
    int thisYear = Integer.parseInt(today.substring(0, 4));
    int thisMonth = Integer.parseInt(today.substring(4, 6));
    int thisDay = Integer.parseInt(today.substring(6, 8));

    // �ֹε�ϻ��� ������ ����
    // String => int�� ����ȯ
    // ���� ����� ���� int�� ����ȯ �Ͽ����ϴ�.
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
    
    if(juminMonth > thisMonth) {   // �ֹι�ȣ�� ���� ���� ��¥�� ������ ������ ������ ������ ������
       manAge = manAge-1;         // �� ���� ���� ���� 
       System.out.println("�� ���� ��� ��� : " + manAge);
    }else if(juminMonth == thisMonth) {   // �ֹι�ȣ�� ���� ���糯¥�� ���� ���� ���
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


void ticketOrderCount() {
    
    do {
       System.out.print("\n�� ���� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)\n");
       ticketCount = sc.nextInt();
       System.out.print("\n==========================================\n\n");
    } while(!(ticketCount >= 1 || ticketCount < 11));
 }

void PreferentialTreatment() {
    
    do {
       System.out.print("�������� �����ϼ���.\n1. ����(���� ���� �ڵ�ó��)\n2. ����� ���\n3. ���������� ���\n4. �ް��庴 ���\n5. �ӻ�� ���\n6. �ٵ��� �ູī�� ���\n");
       special = sc.nextInt();
       System.out.print("\n==========================================\n\n");
    } while(!(special == 1 || special == 2 || special ==3 || special == 4 || special == 5 || special == 6));      
 }


void additionalTicket() {

    do {
       System.out.print("��� �߱� �Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����\n");
       continuingTicket = sc.nextInt();
       System.out.print("\n==========================================\n\n");
    } while(!(continuingTicket == 1|| continuingTicket == 2));

 }
}


