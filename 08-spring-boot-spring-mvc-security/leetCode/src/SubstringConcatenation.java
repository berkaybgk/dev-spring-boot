import java.util.ArrayList;
import java.util.List;

public class SubstringConcatenation {
    public static void main(String[] args) {
        String s = "bcabbcaabbccacacbabccacaababcbb";
        String[] words = {"c","b","a","c","a","a","a","b","c"};
        findSubstring(s,words);

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> printList = new ArrayList<>();

        findPermutations(s, words, 0, printList);
        System.out.println(printList);


        return printList;
    }



    public static void findPermutations(String s, String[] words, int index, List<Integer> printList) {
        if (index == words.length) {
            String currentPermutation = String.join("",words);
            // completed the permutation, check if it is in the string
            for (int i = 0; i<s.length()-currentPermutation.length()+1; i++) {
                String currentWord = "";
                for (int j = i; j< i+String.join("",words).length(); j++){
                    currentWord += s.charAt(j);
                }
                if (currentWord.equals(currentPermutation)) {
                    if (!printList.contains(i)){
                        printList.add(i);
                    }
                }

            }

            return;
        }

        for (int i = index; i < words.length; i++) {
            // Swap the current element with the element at index
            String temp = words[i];
            words[i] = words[index];
            words[index] = temp;

            // call recursively for the next index
            findPermutations(s, words, index + 1, printList);

            // convert it to its original
            temp = words[i];
            words[i] = words[index];
            words[index] = temp;
        }
    }
}
