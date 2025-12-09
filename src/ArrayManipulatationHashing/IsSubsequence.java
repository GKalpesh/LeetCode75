package ArrayManipulatationHashing;

public class IsSubsequence {

    public static void main(String[] args) {
        String word1 = "abe";
        String word2 = "ahbgdc";
        System.out.println(subsequence(word1, word2));
    }

    // time complexity = O(n) space complexity = O(1)
    public static boolean subsequence(String word1, String word2){
        int pointer1 = 0, pointer2 = 0;

        while (word1.length() > pointer1 && word2.length() > pointer2){
            if (word1.charAt(pointer1) == word2.charAt(pointer2)){
                pointer1++;
                pointer2++;
            }
            else pointer2++;
        }
        return pointer1 == word1.length();
    }
}
