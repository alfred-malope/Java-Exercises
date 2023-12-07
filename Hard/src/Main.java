import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 2, 7};
        int[] array2 = {2, 4, 6, 8, 10, 12};
        System.out.print("1. The elements that are unique to both arrays: ");
        printIntArray(uniqueInt(array1,array2));

        String[] names = {"Tshepho", "Alfred", "Teboho", "Xoli", "Shoiab", "Thabang"};
        System.out.print("2. The strings in alphabetical order: ");
        printStringArray(sortedStrings(names));

        System.out.println("4. There are two integers in the array that add up to the target integer: "+sumTwoInt(array1, 3));

        char character = 'e';
        System.out.print("5. The strings that contain the character ("+character+"): ");
        printStringArray(charStringArray(names, character));

        int[] numbers = {1, 2, 3, 1, 5, 6, 7, 2, 8, 2, 5};
        System.out.println("6. The most frequently occurring integer: "+findMode(numbers));

        System.out.println("8. The kth smallest integer in the array: "+kthSmallInt(numbers));

        System.out.print("9. The strings sorted by length (shortest to longest): ");
        printStringArray(sortedLengthStrings(names));

        System.out.print("10. The elements that appear in both arrays in the order that they appear in the first array without duplicates: ");
        printIntArray(commonElements(array1,array2));


    }
    //1.	Write a function that takes two arrays of integers and returns a new array that contains the elements that are unique to both arrays.
    public static int[] uniqueInt(int[] array1, int[] array2){
        int[] checkUnique = new int[array2.length + array1.length];
        int index = 0;
        for (int num : array1){
            if(isUnique(num, array2)){
                checkUnique[index++] = num;
            }
        }
        for (int num : array2){
            if(isUnique(num, array1)){
                checkUnique[index++] = num;
            }
        }
        int[] unique = new int[index];
        for (int i = 0; i < unique.length; i++) {
            unique[i] = checkUnique[i];
        }
        return unique;
    }
    public static boolean isUnique(int num, int[] array){
        for (int x : array){
            if(num == x){
                return false;
            }
        }
        return true;
    }

    //2.	Write a function that takes an array of strings and returns a new array that contains the strings in alphabetical order.
    public static String[] sortedStrings(String[] strings) {
        String[] sortedArray = Arrays.copyOf(strings,strings.length);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j].compareTo(sortedArray[j + 1]) > 0) {
                    String temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return sortedArray;
    }

    //3.	Write a function that takes a string as input and returns the longest palindrome that can be formed from the characters in the string.


    //4.	Write a function that takes an array of integers and a target integer as input, and returns true if there are two integers in the array that add up to the target integer, and false otherwise.
    public static boolean sumTwoInt(int[] numbers, int number){
        for (int num : numbers) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (num + numbers[j + 1] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    //5.	Write a function that takes an array of strings and a character as input, and returns a new array that contains only the strings that contain the character.
    public static String[] charStringArray(String[] strings, char c){
        String[] newString = new String[strings.length];
        int count = 0;
        for (String string : strings){
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == c){
                    newString[count++] = string;
                }
            }
        }
        String[] hasChar = new String[count];
        for (int i = 0; i < hasChar.length; i++) {
            hasChar[i] = newString[i];
        }
        return hasChar;
    }

    //6.	Write a function that takes an array of integers and returns the mode (most frequently occurring integer) of the integers in the array.
    public static int findMode(int[] numbers){
        int mode = numbers[0];
        int count = 0;
        for (int number : numbers) {
            for (int i : numbers) {
                if (number == i) {
                    if (countMode(number, numbers) > count) {
                        mode = number;
                        count = countMode(number, numbers);
                    }
                }
            }
        }
        return mode;
    }
    public static int countMode(int num, int[] array){
        int count = 0;
        for (int x : array){
            if(num == x){
                count++;
            }
        }
        return count;
    }

    //7.	Write a function that takes a string as input and returns the number of palindromic substrings in the string.
    //8.	Write a function that takes an array of integers and returns the kth smallest integer in the array.
    public static int kthSmallInt(int[] numbers){
        int kth = 1;
        int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
        for (int i = 0; i < sortedNumbers.length - 1; i++) {
            for (int j = 0; j < sortedNumbers.length - i - 1; j++) {
                if (sortedNumbers[j] > sortedNumbers[j + 1]) {
                    int temp = sortedNumbers[j];
                    sortedNumbers[j] = sortedNumbers[j + 1];
                    sortedNumbers[j + 1] = temp;
                }
            }
        }
        return sortedNumbers[kth - 1];
    }

    //9.	Write a function that takes an array of strings and returns a new array that contains the strings sorted by length (shortest to longest).
    public static String[] sortedLengthStrings(String[] strings) {
        String[] sortedArray = Arrays.copyOf(strings,strings.length);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j].length() > sortedArray[j + 1].length()) {
                    String temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return sortedArray;
    }

    //10.	Write a function that takes two arrays of integers and returns a new array that contains the elements that appear in both arrays in the order that they appear in the first array. If there are duplicates, they should only appear once in the output.
    public static int[] commonElements(int[] array1, int[] array2){
        int[] checkCommon = new int[array1.length];
        int index = 0;
        for (int k : array1) {
            for (int i : array2) {
                if (k == i) {
                    checkCommon[index++] = k;
                }
            }
        }

        int[] removeDuplicate = new int[index];
        int count = 0;
        for (int j : checkCommon) {
            if (checkDuplicate(j, removeDuplicate)) {
                removeDuplicate[count++] = j;
            }
        }
        int[] common = new int[count];
        for (int i = 0; i < common.length; i++) {
            common[i] = removeDuplicate[i];
        }
        return common;
    }
    public static boolean checkDuplicate(int num, int[] array){
        for (int x : array){
            if(num == x){
                return false;
            }
        }
        return true;
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