class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] num1Arr = num1.split("\\+");
        String[] num2Arr = num2.split("\\+");
        
        String num01 = calc(num1Arr[0],num2Arr[0]);
        String num02 = calc(num1Arr[0],num2Arr[1]);
        String num03 = calc(num1Arr[1],num2Arr[0]);
        String num04 = calc(num1Arr[1],num2Arr[1]);
        
        int intSum = 0;
        int iSum = 0;
        if(num01.charAt(num01.length()-1) == 'i'){
            iSum += Integer.parseInt(num01.substring(0,num01.length()-1));
        }else{
            intSum += Integer.parseInt(num01);
        }
        
        if(num02.charAt(num02.length()-1) == 'i'){
            iSum += Integer.parseInt(num02.substring(0,num02.length()-1));
        }else{
            intSum += Integer.parseInt(num02);
        }
        
        if(num03.charAt(num03.length()-1) == 'i'){
            iSum += Integer.parseInt(num03.substring(0,num03.length()-1));
        }else{
            intSum += Integer.parseInt(num03);
        }
        
        if(num04.charAt(num04.length()-1) == 'i'){
            iSum += Integer.parseInt(num04.substring(0,num04.length()-1));
        }else{
            intSum += Integer.parseInt(num04);
        }        
        
        StringBuilder sb = new StringBuilder();
        sb.append(intSum);
        sb.append("+");
        sb.append(iSum);
        sb.append("i");     
        
        return sb.toString();

    }
    
    public String calc(String num1, String num2){
        int iCnt = 0;
        boolean posi = true;
        
        int num1Start = 0;
        int num1End = num1.length() -1;
        
        int num2Start = 0;
        int num2End = num2.length() -1;
        
        if(num1.charAt(num1Start) == '-'){
            posi = !posi;
            num1Start++;
        }
        
        if(num1.charAt(num1End) == 'i'){
            iCnt++;
            num1End--;
        }      
        
        if(num2.charAt(num2Start) == '-'){
            posi = !posi;
            num2Start++;
        }
        
        if(num2.charAt(num2End) == 'i'){
            iCnt++;
            num2End--;
        }                
        
        int mult = Integer.parseInt(num1.substring(num1Start, num1End+1))
            * Integer.parseInt(num2.substring(num2Start, num2End+1));
        
        if(iCnt == 2){
            posi = !posi;
        }
        
        StringBuilder sb = new StringBuilder();
        if(!posi){
            sb.append("-");
        }
        sb.append(mult+"");
        if(iCnt == 1){
            sb.append("i");
        }
        return sb.toString();
        
    }
}

