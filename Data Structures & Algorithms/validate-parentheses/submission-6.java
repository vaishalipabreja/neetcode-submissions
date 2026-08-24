class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        boolean res= true;

        for(int k =0; k<s.length();k++){
            char i = s.charAt(k);
            if(i=='['|| i=='{' || i=='('){
                st.push(i);
            }

            if(i=='}'){
                if (st.isEmpty()) return false;
                char x = st.pop();
                
                if(x!='{'){
                    return false;
                }
            }
            if(i==']'){
                if (st.isEmpty()) return false;
                char x = st.pop();
                
                if(x!='['){
                    return false;
                }
            }
            if(i==')'){
                if (st.isEmpty()) return false;
                char x = st.pop();
            
                if(x!='('){
                    return false;
                }
            }

        }

        return res&& st.isEmpty();
    }
}
