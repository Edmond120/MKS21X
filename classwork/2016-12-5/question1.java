//cedits: Edmond, Haoyu, Kerry
//question 1
//method 2
public boolean isDone(){
    int num = 1;
    for(int r = 0;r < side;r++){
	for(int c = 0;c < side;c++){
	    if (value[r][c] != 0){
		if (value[r][c] != num){
		    return false;
		}
		else{
		    num++;
		}
	    }
	}
    }
    return true;
}
//method 3
public boolean isDone(){
    int r,c = 0;
    int num = 1;
    while(r < side){
	if(value[r][c] == num){
	    num++;
	    c++;
	    if(c == side){
		c = 0;
		r++;
	    }
	}
	else if(value[r][c] == 0){
	    c++;
	    if(c == side){
		c = 0;
		r++;
	    }
	}
	else{
	    return false;
	}
    }
    return true;
}
//method 1
public boolean isDone(){
    int r,c = 0;
    while(r + c != 2 * side){
	if (r > 0 && c == 0){
	    if ((value[r - 1][side - 1] + 1 != value[r][c]) && value[r - 1]
		[side - 1] != 0){
		return false;
	    }
	}
	if (value[r][c] + 1 == value[r][c + 1]){
	    if(c == side - 1){
		c = 0;
		r++;
	    }
	    else{
		c++;
	    }
	}
	else{
	    return false;
	}
    }
    return true;
}
