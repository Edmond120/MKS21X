import java.util.Random;
public class driver{
    public static void main(String[]args){
	Random x = new Random();
	int len = Integer.parseInt(args[0]);
	int[]a = new int[len];
	for(int i = 0; i < a.length; i++){
	    a[i] = x.nextInt(100);
	}
	int[]b = Sorts.copy(a);
	int[]c = Sorts.copy(a);
	Sorts timer = new Sorts();
	System.out.println("array");
	//System.out.println(Sorts.toString(a));
	System.out.println("insertion sort");
	timer.time(true);
	Sorts.insertionSort(a);
	timer.time(false);
	//System.out.println(Sorts.toString(a));
	System.out.println("selection sort");
	timer.time(true);
	Sorts.selectionSort(b);
	timer.time(false);
	//System.out.println(Sorts.toString(b));
	System.out.println("bubble sort");
	timer.time(true);
	Sorts.bubbleSort(c);
	timer.time(false);
	//System.out.println(Sorts.toString(c));
    }
}
