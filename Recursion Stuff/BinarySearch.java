public class BinarySearch {
    public static int search(int[] array, int lowIndex, int highIndex, int target) {
        // base case: if lowIndex exceeds highIndex, the target is not found
        if (lowIndex > highIndex) {
            return -1;
        }

        // calculate the middle index
        int middleIndex = (lowIndex + highIndex) / 2;

        // check if the middle element is the target
        if (array[middleIndex] == target) {
            return middleIndex;
        } else if (array[middleIndex] > target) {
            // search in the left half of the array
            return search(array, lowIndex, middleIndex - 1, target);
        } else {
            // search in the right half of the array
            return search(array, middleIndex + 1, highIndex, target);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
        
        System.out.println(search(array, 0, array.length - 1, 7)); //return 3
        System.out.println(search(array, 0, array.length - 1, 9)); //return 4
        System.out.println(search(array, 0, array.length - 1, 2)); //return -1
    }
}
