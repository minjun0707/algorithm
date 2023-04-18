class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        
        int map[][] = new int[n][n];
        
    
        
        for(int i=0; i < n; i++) {
            //10진수 입력
            int num1 = arr1[i];
            int num2 = arr2[i];
            
            String num1Str = Integer.toString(num1,2);
            String num2Str = Integer.toString(num2,2);
            
            for(int j=0; j<num1Str.length(); j++){
                map[i][n-num1Str.length() + j] = num1Str.charAt(j) -'0';
            }
           
            for(int j=0; j<num2Str.length(); j++){
                map[i][n-num2Str.length() + j] += num2Str.charAt(j) -'0';
            }
        
            
            StringBuilder sb = new StringBuilder();
            for(int j=0; j< n; j++){
                if(map[i][j] == 0) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            
            
            
            answer[i] = sb.toString();
          
                     
        }
        
    
        
     
        
        
        return answer;
    }
}