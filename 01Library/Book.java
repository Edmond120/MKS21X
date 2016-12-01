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
class ReferenceBook extends LibraryBook{
    private String collection;
    public String getCollection(){
	return collection;
    }
    public void setCollection(String x){
	collection = x;
    }
    public ReferenceBook(String author,String title,int ISBN,int callNum,
			 String collection){
	super(author,title,ISBN,callNum);
	setCollection(collection);
    }
    public void checkout(String patron, String due){
	System.out.println("you can't checkout a reference book, loser");
    }
    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus(){
	return "non-circulating reference book";
    }
    public String toString(){
	return super.toString() + ", " + getCollection();
    }
}
class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;
    public String getCurrentHolder(){
	return currentHolder;
    }
    public String getDueDate(){
	return dueDate;
    }
    public void setCurrentHolder(String x){
        currentHolder = x;
    }
    public void setDueDate(String x){
	dueDate = x;
    }
    public CirculatingBook(String author,String title,int ISBN,int callNum){
	super(author,title,ISBN,callNum);
	setCurrentHolder(null);
	setDueDate(null);
    }
    public void checkout(String name, String date){
	setCurrentHolder(name);
	setDueDate(date);
    }
    public void returned(){
	setCurrentHolder(null);
	setDueDate(null);
    }
    public String circulationStatus(){
	if (currentHolder.equals(null)){
	    return "book available on shelves";
	}
	else{
	    return getCurrentHolder() + ", " + getDueDate();
	}
    }
	
}
