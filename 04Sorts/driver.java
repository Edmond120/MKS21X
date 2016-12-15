public class driver{
    public static void main(String[]args){
	int[]a = {5,1,7,89,3,21,8,5,1,58,52,14,8,54,1,5,4,8,4};
	int[]b = Sorts.copy(a);
	Sorts.insertionSort(a);
	Sorts.selectionSort(b);
	System.out.println("insertion sort");
	System.out.println(Sorts.toString(a));
	System.out.println("selection sort");
	System.out.println(Sorts.toString(b));
    }
}
