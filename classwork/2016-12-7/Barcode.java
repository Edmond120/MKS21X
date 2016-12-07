class runtimeException extends Throwable{
    public String message;
    public runtimeException(String x){
	super();
	message = x;
    }
}
public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private int _checkDigit;
    private static String[] key = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    public boolean precondition(){
	if(_zip.length() != 5){
	    return false;
	}
	for(int i = 0; i < 5;i++){
	    if(!Character.isDigit(_zip.charAt(i))){
		return false;
	    }
	}
	return true;
    }
    private int checkSum(){
	int result = 0;
	for(int i = 0; i < _zip.length(); i++){
	    result += Integer.parseInt(_zip.charAt(i) +"");
	}
	return result;
    }
    public Barcode(String zip){
	_zip = zip;
	try{
	    if(!precondition()){
		throw new runtimeException("zip is not the correct length or zip contrains a non digit, but I won't tell you which");
	    }
	}
	catch (runtimeException e){
	    System.out.println(e.message);
	}
	_checkDigit = checkSum() % 10;
    }
    public String toString(){
	String result = _zip + "  |";
	for(int i = 0; i < _zip.length();i++){
	    result = result + key[_zip.charAt(i)];
	}
	result = result + key[_checkDigit] + "|";
	return result;
    }
    public int compareTo(Barcode other){
	int a = Integer.parseInt(_zip + _checkDigit);
	int b = Integer.parseInt(other._zip + other._checkDigit);
	if(a == b){
	    return 0;
	}
	else if (a > b){
	    return 1;
	}
	else{
	    return -1;
	}
    }
}
