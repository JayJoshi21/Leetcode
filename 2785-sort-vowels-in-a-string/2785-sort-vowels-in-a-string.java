class Solution {
    Character[] vows = {'a','e','i','o','u','A','E','I','O','U'};
    
    private boolean isVowel(char c){
        return Arrays.asList(vows).contains(c);
    }
    public String sortVowels(String s) {
        StringBuilder ans = new StringBuilder();
        List<Character> vowels = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                vowels.add(s.charAt(i));
            }
        }
        
        Collections.sort(vowels);
        int j = 0;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                ans.append(vowels.get(j++));
            }else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}