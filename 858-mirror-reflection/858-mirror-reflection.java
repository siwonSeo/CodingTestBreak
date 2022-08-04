class Solution {
    int currP;
    int currQ;
    public int mirrorReflection(int p, int q) {
        int gcd = getGcd(p,q);
        currP = p / gcd;
        currQ = q / gcd;
        return right(currQ,true);
    }
    
    public int left(int q, boolean upper){
        if(upper){
            int toVal = q + currQ;
            if(q == currP){
                return 2;
            }
            
            if(toVal<=currP){
                return right(toVal,true);
            }else{
                return right(currP + currP - toVal,false);
            }       
        }else{
            int toVal = q - currQ;
            /*
            if(q == currP){
                return 2;
            }
            */
            
            if(toVal >= 0){
                return right(toVal,false);
            }else{
                return right(-1*toVal,true);
            }              
        }      
       
    }
    public int right(int q, boolean upper){
        if(upper){
            int toVal = q + currQ;
            if(q == currP){
                return 1;
            }
            
            if(toVal<=currP){
                return left(toVal,true);
            }else{                
                return left(currP + currP - toVal,false);
            }
                
          
        }else{
            int toVal = q - currQ;
            if(q == 0){
                return 0;
            }
            
            if(toVal >= 0){
                return left(toVal,false);
            }else{
                return left(-1*toVal,true);
            }                 
        }        
        
    }
    
    public int getGcd(int p, int q){      
        int k = p / q;
        int remainder = p % q;
        if(remainder == 0){
            return q;
        }
        return getGcd(q, p-(k*q));
    }   
}