public class Sorts{
    public static String name(){
	return "09.Wong.Edmond";
    }
    public static void selectionSort(int[]data){
	int temp;
	int minIndex;
	for(int i = 0; i < data.length - 1; i++){
	    temp = data[i];
	    minIndex = i;
	    for(int i2 = i + 1; i2 < data.length; i2++){
		if(data[i2] < data[minIndex]){
		    minIndex = i2;
		}
	    }
	    data[i] = data[minIndex];
	    data[minIndex] = temp;
	}
    }
    public static String toString(int[]x){
	String result = "[";
	for(int i = 0;i < x.length;i++){
	    result +=x[i] + ", ";
	}
	return result.substring(0,result.length() - 2) + "]";
    }
}
