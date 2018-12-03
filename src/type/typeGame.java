package type;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import java.math.*;

public class typeGame extends JFrame {

	JPanel contentPane;
	JPanel jpanel1 = new JPanel();
	JLabel jbl;
	String jstr;

	public typeGame() {
		gameInit();
	}

	private void gameInit() {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setSize(new Dimension(800, 800));
		setTitle("徐斌的打字游戏");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jpanel1.setBounds(new Rectangle(4, 4, 400, 400));
		jpanel1.setLayout(null);

		contentPane.add(jpanel1);
		this.addKeyListener(new mylistener());
	}

	public void run() {
		Thread t = new Thread(new myThread());
		t.start();
	}

	public static void main(String[] args) {
		typeGame tg = new typeGame();
		tg.run();
	}

	public class mylistener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			String keychar = e.getKeyChar() + "";

			if (keychar.equalsIgnoreCase(jstr)) {
				jbl.setVisible(false);
			}
		}
	}

	class myThread implements Runnable {

		JLabel show = new JLabel();
		String chars;

		public myThread() {
			jbl = show;
			show.setFont(new java.awt.Font("宋体", Font.PLAIN, 33));
			String pst = "A";
			jstr=pst;
			jpanel1.add(show);
			show.setText(pst);
		}
		public void run(){
			int x = 200;
			int y = 0;
			boolean fo = true;

			while (fo) {
				if (y >= 350) { // 落到一定高度，停止；
					show.setVisible(false);
					break;
				}
				show.setBounds(new Rectangle(x, y, 33,32)); // 可见JLabel每次移动的距离为2；
				try {
					Thread.sleep((int) (Math.random() * 400)); // 随机生成时间；
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				y += 4;
			}
		}
	}
}
