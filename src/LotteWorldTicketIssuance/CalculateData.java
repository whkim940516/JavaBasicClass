package LotteWorldTicketIssuance;

public class CalculateData {
	
	// 연령대에 맞게 처리하기 편하도록 조건식 만들어줌
	InputData input_manAge = new InputData();
	ConstantData constant = new ConstantData();
	
	public int person;
	// 연령대에 맞게 처리하기 편하도록 조건식 만들어줌
   //  personAgePrice에서 쓰인 변수는 다른 함수에서 이미 선언 했기 때문에 불러줄 필요도 없다.
	// price는 없었으니까 불러준다.
	public int price;
	
	// 우대사항 가격
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
        case 1:   // 종합이용권 선택했을 때 
           switch(input_manAge.ticket){
              case 1:   // 1DAY 선택했을 때 
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
              
              case 2:  // AFTER4 선택했을 때 
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
        
        case 2:    // 파크이용권 선택했을 때 
           switch(input_manAge.ticket){ 
              case 1:   // 1DAY 선택했을 때 
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
                 
              case 2:  // AFTER4 선택했을 때 
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
           System.out.print("다시 입력해주세요.");
        }
    }

void preferentialTreatmentPrice() {

    switch(input_manAge.special) {
       case 1:   // 우대사항 없음 
             specialPrice = price; 
             break;   
          
          case 2:   // 장애인 우대 
             specialPrice = (int)((float)price * 0.5);
             price = price - specialPrice;
             break;
          
          case 3:   // 국가 유공자 우대 
             specialPrice = (int)((float)price * 0.5);
             price = price - specialPrice;
             break;
          
          case 4:   // 휴가장병 우대 
             if(input_manAge.choice == 1) {
             specialPrice = (int)((float)price * 0.49);   // 휴가 장병의 경우 종합이용권만 49 % 우대
             price = price - specialPrice; 
             } else if(input_manAge.choice == 2) {
                specialPrice = price;
             }
             break;
          
          case 5:  // 임산부 우대 
             if(input_manAge.choice == 1) {
                specialPrice = (int)((float)price * 0.5);
                price = price - specialPrice;
             } else if(input_manAge.choice == 2) {
                specialPrice = price;
             }
             break;
          
          case 6:   // 다둥이 행복카드 우대 
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

