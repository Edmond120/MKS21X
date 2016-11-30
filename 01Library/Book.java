class Book{
    private String author;
    private String title;
    private int ISBN;
    public Book(){
    }
    public Book(String a,String t,int i){
	setAuthor(a);
	setTitle(t);
	setISBN(i);
    }
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public int getISBN(){
	return ISBN;
    }
    public void setAuthor(String x){
	author = x;
    }
    public void setTitle(String x){
	title = x;
    }
    public void setISBN(int x){
	ISBN = x;
    }
    public String toString(){
	return getTitle() + ", " + getAuthor() + ", " + getISBN();
    }
}
abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private int callNumber;
    public LibraryBook(String a,String t,int i,int c){
	super(a,t,i);
	setCallNumber(c);
    }
    public int getCallNumber(){
	return callNumber;
    }
    public void setCallNumber(int c){
	callNumber = c;
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    public int compareTo(LibraryBook x){
	int a = getCallNumber();
	int b = x.getCallNumber();
	if(a == b){
	    return 0;
	}
	else if(a > b){
	    return 1;
	}
	else{
	    return -1;
	}
    }
    public String toString(){
	return super.toString() + 
	    ", " + getCallNumber() + ", " + circulationStatus();
    }
}
