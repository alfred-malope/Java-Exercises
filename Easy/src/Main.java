public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("1. The sum of all the integers in the array is: " + sumArray(numbers));

        String[] names = {"Alfred", "Thabang", "Teboho", "Xoli", "Shoiab"};
        System.out.println("2. The length of the shortest string in the array is: "+shortestString(names));

        System.out.println("3. The string in reverse order: " + reversedString("Hello world"));

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] combined = combinedArray(array1, array2);
        System.out.print("4. The array that contains the elements of both arrays: ");
        for (int j : combined) {
            System.out.print(j + ", ");
        }
        System.out.println();

        System.out.println("5. The largest integer in the array is: "+largestInteger(numbers));

        System.out.println("6. The string is present in the array: "+checkString(names, "Alfred"));

        System.out.println("7. The string is a palindrome: "+checkPalindrome("Mom"));

        System.out.println("8. The index of the first occurrence of the smallest integer in the array: "+firstSmallestOccurrence(numbers));

        System.out.println("9. The string with the most characters: "+mostCharString(names));

        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("10. The even integers in the original array: ");
        for (int i = 0; i < evenIntArray(intArray).length; i++) {
            System.out.print(evenIntArray(intArray)[i] + ", ");
        }
        System.out.println();
    }
    //1.	Write a function that takes an array of integers and returns the sum of all the integers.
    public static int sumArray(int[] array){
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }
    //2.	Write a function that takes an array of strings and returns the length of the shortest string in the array.
    public static int shortestString(String[] strings){
        int shortString = strings[0].length();
        for (String string : strings) {
            if (shortString > string.length()) {
                shortString = string.length();
            }
        }
        return shortString;
    }
    //3.	Write a function that takes a string as input and returns the string in reverse order.
    public static String reversedString(String string){
        String reversed = "";
        for (int i = string.length()-1; i >= 0; i--) {
            reversed += string.charAt(i);
        }
        return reversed;
    }
    //4.	Write a function that takes two arrays of integers and returns a new array that contains the elements of both arrays.
    public static int[] combinedArray(int[] array1, int[] array2){
        int[] combined = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            combined[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            combined[array1.length + i] = array2[i];
        }
        return combined;
    }
    //5.	Write a function that takes an array of integers and returns the largest integer in the array.
    public static int largestInteger(int[] numbers){
        int largeInt = numbers[0];
        for (int number : numbers) {
            if (largeInt < number) {
                largeInt = number;
            }
        }
        return largeInt;
    }
    //6.	Write a function that takes an array of strings and a string as input, and returns true if the string is present in the array, and false otherwise.
    public static boolean checkString(String[] strings, String string){
        for (String s : strings) {
            if (string.equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
    //7.	Write a function that takes a string as input and returns true if the string is a palindrome, and false otherwise.
    public static boolean checkPalindrome(String string){
        String reversed = "";
        for (int i = string.length()-1; i >= 0; i--) {
            reversed += string.charAt(i);
        }
        return reversed.equalsIgnoreCase(string);
    }
    //8.	Write a function that takes an array of integers and returns the index of the first occurrence of the smallest integer in the array.
    public static int firstSmallestOccurrence(int[] numbers){
        int sortest = numbers[0];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(sortest > numbers.length){
                sortest = numbers[i];
                index = i;
            }
        }
        return index;
    }
    //9.	Write a function that takes an array of strings and returns the string with the most characters.
    public static String mostCharString(String[] strings){
        String mostChar = strings[0];
        for (String string : strings) {
            if (mostChar.length() < string.length()) {
                mostChar = string;
            }
        }
        return mostChar;
    }
    //10.	Write a function that takes an array of integers and returns a new array that contains only the even integers in the original array.
    public static int[] evenIntArray(int[] numbers){
        int[] newArray = new int[numbers.length];
        int evenCount = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                newArray[evenCount] = number;
                evenCount++;
            }
        }

        int[] evenNumbers = new int[evenCount];
        for (int i = 0; i < evenNumbers.length; i++) {
            evenNumbers[i] = newArray[i];
        }

        return evenNumbers;
    }
}
