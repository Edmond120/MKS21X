import javax.swing.*;
import java.awt.*;
public class tempConverstion{
    private Container pane;
    
    private JButton cToF,fToC;
    private Jlabel label,label2;
    private JTextField input,output;
    public static double cToF(double x){
	return x * 9/5 + 32;
    }
    public static double fToC(double x){
	return (x - 32) * 5/9;
    }
    public void actionPerformed(ActionEvent e) { 
	if(e.getActionCommand() == "cToF"){
	
	}
	else if(e.getActionCommand() == "fToC"){
	
	}
    }
    public tempConverstion(){
	this.setTitle("c and f converstion");
	this.setSize(600,200);
	this.setLocation(0,0);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	
	label = new JLable("input");
	input = new JTextField(12);
	cToF = new JButton("cToF");
	cToF.addActionListener(self);
	fToC = new JButton("fToc");
	fToC.addActionListener(self);
	label2 = new JLable("output");
	output = new JTextField(12);
	pane.add(label);
	pane.add(input);
	pane.add(cToF);
	pane.add(fToC);
	pane.add(label2);
	pane.add(output);
}
