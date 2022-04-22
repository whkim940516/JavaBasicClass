package LotteWorldTicketIssuance;

public class CalculateData {
	
	// InputData, ConstantData에 있는 변수를 사용하기 위해서 객체를 생성하였습니다.
	InputData input_manAge = new InputData();
	ConstantData constant = new ConstantData();
	
	// 연령대에 따른 가격에 대한 코드에 필요한 변수
	public int person;
	public int price;
	
	// 우대사항 가격
	public int specialPrice;
	
	// 함수 내에서 생성한 객체에 대한 변수를 호출하였습니다.
	

	
void personAgeCase(InputData input_manAge) { 
        
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

void personAgePrice(InputData input_manAge) {
    
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

void preferentialTreatmentPrice(InputData input_manAge) {

    switch(input_manAge.special) {
       case 1:   // 우대사항 없음 
             specialPrice = price; 
             break;   
          
          case 2:   // 장애인 우대(종합이용권/파크이용권 50% 우대) 
             specialPrice = (int)((float)price * 0.5);
             price = price - specialPrice;
             break;
          
          case 3:   // 국가 유공자 우대(종합이용권/파크이용권 50% 우대)  
             specialPrice = (int)((float)price * 0.5);
             price = price - specialPrice;
             break;
          
          case 4:   // 휴가장병 우대 
             if(input_manAge.choice == 1) {
             specialPrice = (int)((float)price * 0.49);   // 휴가 장병의 경우 종합이용권만 49% 우대
             price = price - specialPrice; 
             } else if(input_manAge.choice == 2) {
                specialPrice = price;
             }
             break;
          
          case 5:  // 임산부 우대 
             if(input_manAge.choice == 1) {
                specialPrice = (int)((float)price * 0.5); // 임산부의 경우 종합이용권만 50% 우대
                price = price - specialPrice;
             } else if(input_manAge.choice == 2) {
                specialPrice = price;
             }
             break;
          
          case 6:   // 다둥이 행복카드 우대 
             if(input_manAge.choice == 1) {
                specialPrice = (int)((float)price * 0.3);  // 행복카드 소지자는 종합이용권만 30% 우대
                price = price - specialPrice;
             } else if(input_manAge.choice == 2) {
                specialPrice = price;
             }
             break;
    }
 }





}