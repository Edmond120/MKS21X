import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray sA;
    private int index;
    private int bound;
    public SuperArrayIterator(SuperArray x){
	sA = x;
	index = 0;
	bound = x.size();
    }
    public SuperArrayIterator(SuperArray x, int a, int b){
	//for slicing
	sA = x;
	index = a;
	bound = b;
    }
    public boolean hasNext(){
        return (index < bound);
    }
    public String next(){
	if(hasNext()){
	    return sA.get(index++);
	}
	else{
	    throw new NoSuchElementException();
	}
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
