package Team.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Team.Controller.FrontController;
import Team.Domain.MemDAO;
import Team.Domain.MemDTO;
import Team.Domain.ProdDTO;

public class GUIView extends JFrame implements ActionListener {
	
	private FrontController controller = new FrontController();
	int loginstatus = 0;
	int perm = 0;
	
	
	//액션 처리 관련 멤버
	JButton btn1;JButton btn2;JButton btn3;JButton btn4;JButton btn5;JButton btn6;JButton btn7;
	JLabel lbprodname;
	JTextField txprodname;
	JTextArea area;JScrollPane scroll;
	
	//인증 관련 처리 프레임 멤버
	JFrame Loginview = new JFrame("Login View");
	JButton Loginbtn;JButton exitbtn;JButton joinbtn;
	JTextField txid;JTextField txpw;
	
	//상품 관리 관련 처리
	JFrame Prodview = new JFrame("Prod View");
	JButton Insert;JButton Update;JButton Select;JButton EXIT;
	JLabel lbprodname2;JLabel lbprodamount;JLabel lbprodprice;
	JTextField txprodname2;JTextField txprodamount;JTextField txprodprice;
	
	//회원 가입 관련 처리
	JFrame Joinview = new JFrame("회원 가입");
	JButton okbtn;JButton nobtn;
	JTextField txjoinID;JTextField txjoinPW;
	JTextField txjoinName;JTextField txjoinAddr;JTextField txjoinPhone;
	JLabel lbjoinID;JLabel lbjoinPW;
	JLabel lbjoinName;JLabel lbjoinAddr;JLabel lbjoinPhone;

	GUIView() {
		super("쇼핑몰 프로그램 ver 0.0");
		
		JPanel pannel = new JPanel();
		pannel.setLayout(null);
		
		
		btn1 = new JButton("상품 검색");
		btn1.setBounds(340,20,130,35);
		btn1.addActionListener(this);
		
		btn2 = new JButton("장바구니 담기");
		btn2.setBounds(340,65,130,35);
		btn2.addActionListener(this);
		
		btn3 = new JButton("상품 관리");
		btn3.setBounds(340,110,130,35);
		btn3.addActionListener(this);
		
		btn4 = new JButton("결제하기");
		btn4.setBounds(340,155,130,35);
		btn4.addActionListener(this);
		
		btn5 = new JButton("로그인");
		btn5.setBounds(200,200,130,35);
		btn5.addActionListener(this);
		
		btn6 = new JButton("로그아웃");
		btn6.setBounds(340,200,130,35);
		btn6.addActionListener(this);
		
		btn7 = new JButton("회원열람");
		btn7.setBounds(340,245,130,35);
		btn7.addActionListener(this);
		
		//TextArea + ScrollPane
		area = new JTextArea();
		scroll = new JScrollPane(area);
		scroll.setBounds(10,300,465,150);
		
		txprodname = new JTextField();
		txprodname.setBounds(70,20,250,35);
		
		lbprodname = new JLabel("상품명");
		lbprodname.setBounds(10,20,130,35);
		
		pannel.add(btn1);pannel.add(btn2);pannel.add(btn3);pannel.add(btn4);pannel.add(btn5);pannel.add(btn6);pannel.add(btn7);
		pannel.add(txprodname);pannel.add(lbprodname);
		pannel.add(scroll);
		add(pannel);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pannel.setBackground(new Color(255,200,230));
		setVisible(true);
		setResizable(false);
		
		
		
		Loginview.setBounds(100,100,500,200);
		JPanel loginpanel = new JPanel();
		loginpanel.setLayout(null);
		
		Loginbtn = new JButton("로그인");
		exitbtn = new JButton("종료");
		joinbtn = new JButton("회원가입");
		txid = new JTextField();
		txpw = new JTextField();
		
		txid.setBounds(10,10,350,40);
		txpw.setBounds(10,60,350,40);
		Loginbtn.setBounds(370,10,100,40);
		exitbtn.setBounds(370,60,100,40);
		joinbtn.setBounds(370,110,100,40);
		Loginbtn.addActionListener(this);
		exitbtn.addActionListener(this);
		joinbtn.addActionListener(this);
		
		loginpanel.add(Loginbtn);loginpanel.add(exitbtn);loginpanel.add(joinbtn);
		loginpanel.add(txid);loginpanel.add(txpw);
		
		Loginview.add(loginpanel);
		Loginview.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Loginview.setVisible(false);
		Loginview.setResizable(false);
		loginpanel.setBackground(new Color(180,250,230));
		
		
		
		
		Prodview.setBounds(100,100,500,500);
		JPanel prodpanel = new JPanel();
		prodpanel.setLayout(null);
		
		Insert = new JButton("상품 등록");
		Insert.setBounds(340,20,130,35);
		Insert.addActionListener(this);
		Select = new JButton("상품 조회");
		Select.setBounds(340,65,130,35);
		Select.addActionListener(this);
		Update = new JButton("상품 수정");
		Update.setBounds(340,110,130,35);
		Update.addActionListener(this);
		EXIT = new JButton("나가기");
		EXIT.setBounds(340,155,130,35);
		EXIT.addActionListener(this);
		
		//JLabel
		lbprodname2 = new JLabel("상품명");
		lbprodname2.setBounds(10,20,130,35);
		lbprodamount = new JLabel("상품 수량");
		lbprodamount.setBounds(10,65,130,35);
		lbprodprice = new JLabel("상품 가격");
		lbprodprice.setBounds(10,110,130,35);
		
		//TextField
		txprodname2 = new JTextField();
		txprodname2.setBounds(120,20,170,35);
		txprodamount = new JTextField();
		txprodamount.setBounds(120,65,170,35);
		txprodprice = new JTextField();
		txprodprice.setBounds(120,110,170,35);
		
		prodpanel.add(Insert);prodpanel.add(Select);prodpanel.add(Update);prodpanel.add(EXIT);
		prodpanel.add(txprodname2);prodpanel.add(txprodamount);prodpanel.add(txprodprice);
		prodpanel.add(lbprodname2);prodpanel.add(lbprodamount);prodpanel.add(lbprodprice);
		
		Prodview.add(prodpanel);
		Prodview.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Prodview.setVisible(false);
		Prodview.setResizable(false);
		prodpanel.setBackground(new Color(140,240,250));
		
		
		
		
		Joinview.setBounds(100,100,300,350);
		JPanel joinpanel = new JPanel();
		joinpanel.setLayout(null);
		joinpanel.setBackground(new Color(250,110,100));
		
		
		okbtn = new JButton("확인");
		okbtn.setBounds(10,250,100,35);
		okbtn.addActionListener(this);;
		nobtn = new JButton("취소");
		nobtn.setBounds(170,250,100,35);
		nobtn.addActionListener(this);
		
		txjoinID = new JTextField();
		txjoinID.setBounds(100,20,170,35);
		txjoinPW = new JTextField();
		txjoinPW.setBounds(100,65,170,35);
		txjoinName = new JTextField();
		txjoinName.setBounds(100,110,170,35);
		txjoinAddr = new JTextField();
		txjoinAddr.setBounds(100,155,170,35);
		txjoinPhone = new JTextField();
		txjoinPhone.setBounds(100,200,170,35);
		
		
		lbjoinID = new JLabel("아이디(이메일)");
		lbjoinID.setBounds(10,20,130,35);
		lbjoinPW = new JLabel("비밀번호");
		lbjoinPW.setBounds(10,65,130,35);
		lbjoinName = new JLabel("성명");
		lbjoinName.setBounds(10,110,130,35);
		lbjoinAddr = new JLabel("주소");
		lbjoinAddr.setBounds(10,155,130,35);
		lbjoinPhone = new JLabel("연락처");
		lbjoinPhone.setBounds(10,200,130,35);
		
		joinpanel.add(txjoinID);joinpanel.add(txjoinPW);
		joinpanel.add(txjoinName);joinpanel.add(txjoinAddr);joinpanel.add(txjoinPhone);
		joinpanel.add(lbjoinID);joinpanel.add(lbjoinPW);
		joinpanel.add(lbjoinName);joinpanel.add(lbjoinAddr);joinpanel.add(lbjoinPhone);
		joinpanel.add(okbtn);joinpanel.add(nobtn);
		
		Joinview.add(joinpanel);
		Joinview.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Joinview.setVisible(false);
		Joinview.setResizable(false);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		MemDAO dao = new MemDAO();
		MemDTO dto = new MemDTO();
		
		if(e.getSource() == btn1)
		{
			area.setText("");
			area.append("상품을 검색합니다\n");
		}
		
		if(e.getSource() == btn2)
		{
			area.setText("");
			if(perm < 1)
			{
				JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스 입니다.");
				Loginview.setVisible(true);
			}
			else
			{
				area.append("장바구니에 담습니다\n");
			}
		}
		
		if(e.getSource() == btn3)
		{
			if(perm < 2)
			{
				if(loginstatus == 0)
				{
					JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스 입니다.");
					Loginview.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "권한이 부족합니다");
			}
			
			else
			{
				Prodview.setVisible(true);
			}
		}
		
		if(e.getSource() == btn4)
		{
			area.setText("");
			if(perm < 1)
			{
				JOptionPane.showMessageDialog(null, "로그인이 필요한 서비스 입니다.");
			}
			else
			{
				area.append("결제를 진행합니다\n");
			}
		}
		
		if(e.getSource() == btn5)
		{
			if(loginstatus == 1)
			{
				JOptionPane.showMessageDialog(null, "이미 로그인 상태입니다.");
			}
			else
			{
				Loginview.setVisible(true);
			}
		}
		
		if(e.getSource() == btn6)
		{
			if(loginstatus == 0)
			{
				JOptionPane.showMessageDialog(null, "로그인 상태가 아닙니다");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "로그아웃 합니다");
				loginstatus = 0;
				perm = 0;
			}
		}
		
		if(e.getSource() == btn7)
		{
			if(perm < 2)
			{
				JOptionPane.showMessageDialog(null, "권한이 부족합니다");
			}
			else
			{
				area.setText("");
				area.append(dao.SelectAll().toString());
			}
		}
		
		
		if(e.getSource() == Loginbtn)
		{
			String id = txid.getText();
			String pw = txpw.getText();
			if(id.equals("") || pw.equals(""))
			{
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력해주세요");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "로그인 했습니다.");
				loginstatus = 1;
				perm = 2;
				Loginview.setVisible(false);
			}
			txid.setText("");
			txpw.setText("");
		}
		
		if(e.getSource() == exitbtn)
			Loginview.setVisible(false);
		
		if(e.getSource() == joinbtn)
		{
			JOptionPane.showMessageDialog(null, "회원가입을 진행합니다");
			Joinview.setVisible(true);
		}
		
		if(e.getSource() == okbtn)
		{
			String ID = txjoinID.getText();
			String PW = txjoinPW.getText();
			String Name = txjoinName.getText();
			String Addr = txjoinAddr.getText();
			String Phone = txjoinPhone.getText();
			if(ID.equals("") || PW.equals("") || Name.equals("") || Addr.equals("") || Phone.equals(""))
			{
				JOptionPane.showMessageDialog(null, "입력란이 공백일 수 없습니다.");
			}
			else
			{
				controller.ExSubController("/mem", 1, new MemDTO(ID, PW, Name, Addr, Phone));
				JOptionPane.showMessageDialog(null, Name + "님 회원 가입을 환영합니다");
				Joinview.setVisible(false);
			}
		}
		
		if(e.getSource() == nobtn)
		{
			Joinview.setVisible(false);
		}
		
		
		
		if(e.getSource() == Insert)
		{
			String pname = txprodname2.getText();
			Integer pamount = Integer.parseInt(txprodamount.getText());
			Integer price = Integer.parseInt(txprodprice.getText());
			if(pname.equals("") || pamount.equals("") || price.equals(""))
			{
				JOptionPane.showMessageDialog(null, "입력란이 공백일 수 없습니다.");
			}
			else
			{
				controller.ExSubController("/prod", 1, new ProdDTO(pname, pamount, price));
				JOptionPane.showMessageDialog(null, price + "원의 " + pname + " 상품을 " + pamount + "개 등록하여" + price*pamount + "원 입니다");
				Prodview.setVisible(false);
				area.setText(price + "원의 " + pname + " 상품을 " + pamount + "개 등록하여 " + price*pamount + "원 입니다");
			}
		}
		
		if(e.getSource() == EXIT)
			Prodview.setVisible(false);
	}
		

		
		
	
	public static void main(String[] args) {
		new GUIView();
		//허참
	}


	
}
