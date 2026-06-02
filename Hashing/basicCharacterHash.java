// for strings with only lowercase / uppercase

// import java.util.*;

// class basicCharacterHash {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         String s;
//         System.out.println("Enter string: ");
//         s = sc.next();
//         System.out.println("String: " + s);

//         //precompute:
//         int[] hash = new int[26];
//         for (int i = 0; i < s.length(); i++) {
            // hash[s.charAt(i) - 'a']++; // for lowercase
            // hash[s.charAt(i) - 'A']++; // for uppercase
//         }

//         int q;
//         System.out.println("Enter size to check: ");
//         q = sc.nextInt();
//         while (q-- > 0) {
//             char c;
//             System.out.println("Enter character to check: ");
//             c = sc.next().charAt(0);
//             // fetch:
//             System.out.println("The character " + c + " has appeared " + hash[c - 'a'] + " times in the array"); // for lowercase
//             System.out.println("The character " + c + " has appeared " + hash[c - 'A'] + " times in the array"); // for uppercase
//         }
//     }
// }


// for strings with both lowercase && uppercase
import java.util.*;

class basicCharacterHash {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s;
        System.out.println("Enter string: ");
        s = sc.next();
        System.out.println("String: " + s);

        //precompute:
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        int q;
        System.out.println("Enter size to check: ");
        q = sc.nextInt();
        while (q-- > 0) {
            char c;
            System.out.println("Enter character to check: ");
            c = sc.next().charAt(0);
            // fetch:
            System.out.println("The character " + c + " has appeared " + hash[c] + " times in the array");
        }
    }
}

// NOTE: Until now, we have used the method of number hashing but using this method we cannot hash large numbers like 10^9 or 
// higher. We can solve this problem using the STL map and unordered_map in C++ or the HashMap in Java collection.
