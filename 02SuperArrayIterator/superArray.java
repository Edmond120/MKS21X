import java.util.*;
import java.lang.*;
abstract class superArray implements Iterable<String>, Iterator{
    private int[] data;
    private int size;
    superArray(){
	data = new int[10];
	size = 0;
    }
    superArray(int x){
	data = new int[x];
	size = 0;
    }
    public Iterator<String> iterator(){
	return new IntIterator();
    }
    public int size(){
	return size;
    }
    public boolean add(int n){
	if (data.length > size){
	    data[size] = n;
	    size++;
	}
	else{
	    grow(1);
	    data[size] = n;
	    size++;
	}
	return true;
    }
    private void grow(int n){
	int[] temp = new int [size + n];
	for(int x = 0; x < size; x++){
	    temp[x] = data[x];
	}
	data = temp;
    }
    public String toString(){
	if (size > 0){
        String result = "[ " + data[0];
	for(int x = 1; x < size; x++){
	    result += ", " + data[x];
	}
	result += "]";
	return result;
	}
	else{
	    return "[]";
	}
    }
    public String toStringDebug(){
	if (size > 0){
	String result = "[ " + data[0];
	for(int x = 1; x < data.length; x++){
	    if (data[x] == 0 && x > size) {
		result += "; _";
	    }
	    else{
	    result += ", " + data[x];
	    }
	}
	result += "]";
	return result;
	}
	else{
	    return "[]";
	}
    }
    public int get(int index){
	if (index >= size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }
    public void clear(){
	size = 0;
    }
    public boolean isEmpty(){
	if (size == 0){
	    return true;
	}
	else{
	    return false;
	}
    }
    public int set(int index, int element){
	int x;
	if(index >= size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	x = data[index];
	data[index] = element;
	return x;
    }
    public void add(int index, int element){
	if (size < data.length){
	    size++;
	    for(int x = size - 1; x > index; x = x - 1){
		set(x, data[x - 1]);
	    }
	    set(index, element);
	}
	else{
	    grow(index - (data.length - 1));
	    add(index, element);
	}
    }
    public int remove(int index){
	if (index >= size() || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	size = size - 1;
	int result = data[index];
	for (int x = index; x < size; x++){
	    set(x, data[x + 1]);
	}
	return result;
    }
    public int[] toArray(){
	int[] temp = new int[size];
	for (int x = 0; x < size; x++){
	    temp[x] = data[x];
	}
	return temp;
    }
    public int indexOf(int i){
	for(int x = 0; x < size; x++){
	    if(data[x] == i){
		return x;
	    }
	}
	return -1;
    }
    public int lastIndexOf(int i){
	for(int x = size - 1; x >= 0; x = x - 1){
	    if(data[x] == i){
		return x;
	    }
	}
	return -1;
    }
    public static void main(String[]args){
	superArray abc = new superArray();
	int x = 0;
	while (x < 15){
	    abc.add(x);
	    x++;
	}
        abc.get(-1);
	System.out.println(abc.toString());
    }
}
