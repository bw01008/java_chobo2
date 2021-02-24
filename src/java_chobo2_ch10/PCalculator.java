package java_chobo2_ch10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PCalculator extends JPanel implements ActionListener{

	private JButton[] btns;
	private String[] btnTitles={"1","2","3","+","4","5","6","-","7","8","9","*","clear","0","=","/"};
	private JPanel pMain;
	private JTextField tfValue;
	private StringBuilder sb = new StringBuilder();
	
	public PCalculator() {
		setLayout(new BorderLayout());
		tfValue = new JTextField();
		tfValue.setHorizontalAlignment(SwingConstants.RIGHT);
		add(tfValue, BorderLayout.NORTH);
		
		pMain = new JPanel(new GridLayout(0, 4, 5, 5));
		btns = new JButton[16];
		for(int i=0; i<btnTitles.length;i++){
			btns[i] = new JButton(btnTitles[i]);
			btns[i].addActionListener(this);
			pMain.add(btns[i]);
		}
		
		add(pMain, BorderLayout.CENTER);
	}  

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		if(str.equals("=")){
			try {
				String res = String.format("%s", engine.eval(sb.toString()));
				tfValue.setText(res);
			} catch (ScriptException e1) {
				System.out.println("연산자만 존재");
			}
		}else if (str.equals("clear")){
			sb.delete(0, sb.length());
			tfValue.setText("");
		}else{
			sb.append(str);
			tfValue.setText(sb.toString());
		}
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("계산기");
		f.setBounds(100, 100, 300, 300);
		f.add(new PCalculator());
		f.setVisible(true);
	}
}
