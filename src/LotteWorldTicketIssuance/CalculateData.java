package LotteWorldTicketIssuance;

public class CalculateData {
	
	// ���ɴ뿡 �°� ó���ϱ� ���ϵ��� ���ǽ� �������
	InputData input_manAge = new InputData();
	ConstantData constant = new ConstantData();
	
	public int person;
	// ���ɴ뿡 �°� ó���ϱ� ���ϵ��� ���ǽ� �������
   //  personAgePrice���� ���� ������ �ٸ� �Լ����� �̹� ���� �߱� ������ �ҷ��� �ʿ䵵 ����.
	// price�� �������ϱ� �ҷ��ش�.
	public int price;
	
	// ������ ����
	public int specialPrice;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
void personAgeCase() {
        
  	  System.out.printf("%d", input_manAge.manAge);
  	  
       if(input_manAge.manAge <= 3){
             person = 0;
       } else if (input_manAge.manAge > 3 && input_manAge.manAge <= 12) {
             person = 1;
       } else if (input_manAge.manAge > 12 && input_manAge.manAge <= 18) {
             person = 2;
       } else if (input_manAge.manAge > 19 && input_manAge.manAge <= 65) {
             person = 3;
       } else if (input_manAge.manAge >= 65) {
             person = 4;
       }
    }

void personAgePrice() {
    
    switch(input_manAge.choice){
        case 1:   // �����̿�� �������� �� 
           switch(input_manAge.ticket){
              case 1:   // 1DAY �������� �� 
                 if(input_manAge.manAge <= 3) {
                    price = constant.GENERALPASS_1DAY_BABY_PRICE;
                 } else if(input_manAge.manAge > 3 && input_manAge.manAge <= 12) {
                    price = constant.GENERALPASS_1DAY_CHILDREN_PRICE;
                 } else if(input_manAge.manAge > 12 && input_manAge.manAge <= 18) {
                    price = constant.GENERALPASS_1DAY_TEENAGER_PRICE;
                 } else if(input_manAge.manAge > 19 && input_manAge.manAge < 65) {
                    price = constant.GENERALPASS_1DAY_ADULT_PRICE;
                 } else if(input_manAge.manAge >= 65) {
                    price = constant.GENERALPASS_1DAY_CHILDREN_PRICE;
                 }
                 break; 
              
              case 2:  // AFTER4 �������� �� 
                 if(input_manAge.manAge <= 3) {
                    price = constant.GENERALPASS_AFTER4_BABY_PRICE;
                 }    else if(input_manAge.manAge > 3 && input_manAge.manAge <= 12) {
                    price = constant.GENERALPASS_AFTER4_CHILDREN_PRICE;
                 }     else if(input_manAge.manAge > 12 && input_manAge.manAge <= 18) {
                    price = constant.GENERALPASS_AFTER4_TEENAGER_PRICE;
                 }   else if(input_manAge.manAge > 19 && input_manAge.manAge < 65) {
                    price = constant.GENERALPASS_AFTER4_ADULT_PRICE;
                 }   else if(input_manAge.manAge >= 65) {
                    price = constant.GENERALPASS_AFTER4_CHILDREN_PRICE;
                 }
                 break;   
           }
           break;
        
        case 2:    // ��ũ�̿�� �������� �� 
           switch(input_manAge.ticket){ 
              case 1:   // 1DAY �������� �� 
                 if(input_manAge.manAge <= 3) {
                    price = constant.PARKPASS_1DAY_BABY_PRICE;
                 } else if(input_manAge.manAge > 3 && input_manAge.manAge <= 12) {
                    price = constant.PARKPASS_1DAY_CHILDREN_PRICE;
                 } else if(input_manAge.manAge > 12 && input_manAge.manAge <= 18) {
                    price = constant.PARKPASS_1DAY_TEENAGER_PRICE;
                 } else if(input_manAge.manAge > 19 && input_manAge.manAge < 65) {
                    price = constant.PARKPASS_1DAY_ADULT_PRICE;
                 } else if(input_manAge.manAge >= 65) {
                    price = constant.PARKPASS_1DAY_CHILDREN_PRICE;
                 }
                 break;
                 
              case 2:  // AFTER4 �������� �� 
                 if(input_manAge.manAge <= 3) {
                    price = constant.PARKPASS_AFTER4_BABY_PRICE;
                 }    else if(input_manAge.manAge > 3 && input_manAge.manAge <= 12) {
                    price = constant.PARKPASS_AFTER4_CHILDREN_PRICE;
                 }     else if(input_manAge.manAge > 12 && input_manAge.manAge <= 18) {
                    price = constant.PARKPASS_AFTER4_TEENAGER_PRICE;
                 }   else if(input_manAge.manAge > 19 && input_manAge.manAge < 65) {
                    price = constant.PARKPASS_AFTER4_ADULT_PRICE;
                 }   else if(input_manAge.manAge >= 65) {
                    price = constant.PARKPASS_AFTER4_CHILDREN_PRICE;
                 }
                 break;   
           }
           break;
        
        default :
           System.out.print("�ٽ� �Է����ּ���.");
        }
    }

void preferentialTreatmentPrice() {

    switch(input_manAge.special) {
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
             if(input_manAge.choice == 1) {
             specialPrice = (int)((float)price * 0.49);   // �ް� �庴�� ��� �����̿�Ǹ� 49 % ���
             price = price - specialPrice; 
             } else if(input_manAge.choice == 2) {
                specialPrice = price;
             }
             break;
          
          case 5:  // �ӻ�� ��� 
             if(input_manAge.choice == 1) {
                specialPrice = (int)((float)price * 0.5);
                price = price - specialPrice;
             } else if(input_manAge.choice == 2) {
                specialPrice = price;
             }
             break;
          
          case 6:   // �ٵ��� �ູī�� ��� 
             if(input_manAge.choice == 1) {
                specialPrice = (int)((float)price * 0.3);
                price = price - specialPrice;
             } else if(input_manAge.choice == 2) {
                specialPrice = price;
             }
             break;
    }
 }





}

