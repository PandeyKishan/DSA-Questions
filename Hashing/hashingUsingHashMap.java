import java.util.*;

class hashingUsingHashMap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter size of array: ");
        n = sc.nextInt();
        List<Integer> array = new ArrayList<>();
        while (array.size() < n) {
            System.out.print("Enter number " + (array.size() + 1) + ": " );
            array.add(sc.nextInt());
        }   

        //precompute:
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = array.get(i);
            int freq = 0;
            if (mp.containsKey(key)) 
                freq = mp.get(key); // fetching from the map if key already present
            freq++;
            mp.put(key, freq); // inserting into the map; if key/element is already present, then we get the frequency, increment it and 
            // insert it again in the map, and if not found (new key/element), then won't satisfy if condition, frequency is incremented from 0 to 1 and inserted in map.
        }

        // Iterate over the map:
        System.out.println("Map: ");
        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            System.out.println(it.getKey() + "-> " + it.getValue());
        }

        int q;
        System.out.println("Enter size to check: ");
        q = sc.nextInt();
        while (q-- > 0) {
            int number;
            System.out.println("Enter number to check: ");
            number = sc.nextInt();
            // fetch:
            if (mp.containsKey(number)) 
                System.out.println("The number " + number + " has appeared " + mp.get(number) + " times in the array");
            else 
                System.out.println("The number " + number + " has appeared 0 times in the array");
        }
    }
}

