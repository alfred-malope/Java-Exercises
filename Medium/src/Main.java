import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2 = {2, 4, 6, 8, 10, 12};
        System.out.print("1. The elements that are common to both arrays: ");
        printIntArray(commonElements(array1,array2));

        String[] names =  {"Alfred", "Thabang", "Teboho", "Xoli"};
        System.out.println("2. The average length of the strings in the array is: " + averageLength(names));

        String name = "Alfred";
        System.out.println("3. The number of words in the string ("+name+") is: "+numOfWords(name));

        int[] numbers = {10, 20, 15, 16, 19, 25, 22, 25};
        System.out.println("4. The first occurrence of the largest integer in the array: "+firstLargeInt(numbers));

        System.out.print("5. The strings that start with a vowel: ");
        printStringArray(vowelString(names));

        System.out.print("6. New array that contains the integers in sorted order: ");
        printIntArray(sortedIntegers(numbers));

        System.out.println("7. The number of vowels in the string: "+numOfVowels("Alfred"));

        int[] integersArray = {3, 1, 7, 4, 2, 6, 5};
        System.out.println("8. The median of the integers in the array: "+calculateMedian(integersArray));

        String[] fruits = {"apple", "banana", "cherry", "date"};
        System.out.print("9. Array that contains the strings in reverse order: ");
        printStringArray(reverseStringsArray(fruits));

        System.out.println("10. The product of all the integers in the array: "+productArray(integersArray));
    }
    //1.	Write a function that takes two arrays of integers and returns a new array that contains the elements that are common to both arrays.
    public static int[] commonElements(int[] array1, int[] array2){
        int[] common = new int[array1.length];
        int index = 0;
        for (int j : array1) {
            if (isCommon(j, array2)) {
                common[index++] = j;
            }
        }
        int[]  commonElement = new int[index];
        for (int i = 0; i < commonElement.length; i++) {
            commonElement[i] = common[i];
        }
        return commonElement;
    }
    public static boolean isCommon(int element, int[] array){
        for (int j : array) {
            if (element == j) {
                return true;
            }
        }
        return false;
    }
    //2.	Write a function that takes an array of strings and returns the average length of the strings in the array.
    public static int averageLength(String[] strings){
        int sumLength = 0;
        for (String string : strings) {
            sumLength += string.length();
        }
        return sumLength/strings.length;
    }
    //3.	Write a function that takes a string as input and returns the number of words in the string.
    public static int numOfWords(String string){
//        return string.length();
        int count = 0;
        for(char ignored : string.toCharArray()){
            count++;
        }
        return count;
    }
    //4.	Write a function that takes an array of integers and returns the index of the first occurrence of the largest integer in the array.
    public static int firstLargeInt(int[] numbers){
        int large = numbers[0];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(large < numbers[i]){
                large = numbers[i];
                index = i;
            }
        }
        return index;
    }
    //5.	Write a function that takes an array of strings and returns a new array that contains only the strings that start with a vowel.
    public static String[] vowelString(String[] strings){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        String[] checkVowels = new String[strings.length];
        int index = 0;
        for (String string : strings) {
            for (char vowel : vowels) {
                if (string.charAt(0) == vowel) {
                    checkVowels[index++] = string;
                }
            }
        }
        String[] vowelStrings = new String[index];
        for (int i = 0; i < vowelStrings.length; i++) {
            vowelStrings[i] = checkVowels[i];
        }
        return vowelStrings;
    }
    //6.	Write a function that takes an array of integers and returns a new array that contains the integers in sorted order.
    public static int[] sortedIntegers(int[] numbers){
        int[] sortedArray = Arrays.copyOf(numbers,numbers.length);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return sortedArray;
    }
    //7.	Write a function that takes a string as input and returns the number of vowels in the string.
    public static int numOfVowels(String string){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            for (char vowel : vowels) {
                if (string.charAt(i) == vowel) {
                    count++;
                }
            }
        }
        return count;
    }
    //8.	Write a function that takes an array of integers and returns the median of the integers in the array.
    public static double calculateMedian(int[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = 0; j < integers.length - i - 1; j++) {
                if (integers[j] > integers[j + 1]) {
                    int temp = integers[j];
                    integers[j] = integers[j + 1];
                    integers[j + 1] = temp;
                }
            }
        }
        int length = integers.length;
        int mid = length / 2;
        if (length % 2 == 0) {
            return (integers[mid - 1] + integers[mid]) / 2.0;
        } else {
            return integers[mid];
        }
    }
    //9.	Write a function that takes an array of strings and returns a new array that contains the strings in reverse order.
    public static String[] reverseStringsArray(String[] strings) {
        String[] reversedStrings = new String[strings.length];
        int index = 0;
        for (int i = strings.length - 1; i >= 0; i--) {
            reversedStrings[index++] = strings[i];
        }
        return reversedStrings;
    }
    //10.	Write a function that takes an array of integers and returns the product of all the integers in the array.
    public static int productArray(int[]  integers){
        int product = 1;
        for (int num : integers){
            product *= num;
        }
        if(integers.length == 0){
            return 0;
        }
        return product;
    }


    //Print Array
    public static void printStringArray(String[] strings) {
        for (String string: strings){
            System.out.print(string + ", ");
        }
        System.out.println();
    }
    public static void printIntArray(int[] numbers) {
        for (int number: numbers){
            System.out.print(number + " ");
        }
        System.out.println();
    }
}