package Project5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Screen extends JFrame implements MouseListener, ActionListener {

    Board board = new Board();
    Container contentPane = getContentPane();

    //JPanel scorePanel = new JPanel();
    JLabel greenScoreLabel;
    JLabel apricotScoreLabel;
    JLabel score;
    JButton Exit = new JButton("Exit");
    JButton Restart = new JButton("Restart");

    Font f1;

    Graphics g;



    Screen() {
        setSize(775,600);
        setLayout(null);
        setLocationRelativeTo(null); //화면의 가운데 띄움
        setResizable(false); //사이즈 조절 불가능
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫을 때 실행 중인 프로그램도 같이 종료되도록 함
        contentPane.setBackground(new Color(253, 244, 238));

        board.setLocation(100,100);
        add(board);
        board.addMouseListener(this);



        f1 = new Font("Park Lane",Font.PLAIN,20);
        greenScoreLabel = new JLabel(String.valueOf(board.greenCount));
        greenScoreLabel.setBounds(660,350,50,50);
        greenScoreLabel.setBackground(new Color(253, 244, 238));
        greenScoreLabel.setFont(f1);

        apricotScoreLabel = new JLabel(String.valueOf(board.apricotCount));
        apricotScoreLabel.setBounds(660,432,50,50);
        apricotScoreLabel.setBackground(new Color(253, 244, 238));
        apricotScoreLabel.setFont(f1);

        add(greenScoreLabel);
        add(apricotScoreLabel);
        //add(scorePanel);



        Exit.setBorderPainted(false); //외곽선을 만들어줌
        Exit.setFocusPainted(false); //선택이 되었을때 테두리 사용 안함
        Exit.setFont(f1);
        //Exit.setContentAreaFilled(false); //내용 채우기를 하지 않음
        Exit.setBounds(570,100,100,50);
        Exit.addActionListener(this);
        add(Exit);

        Restart.setBorderPainted(false); //외곽선을 만들어줌
        Restart.setFocusPainted(false); //선택이 되었을때 테두리 사용 안함
        Restart.setFont(f1);
        //Exit.setContentAreaFilled(false); //내용 채우기를 하지 않음
        Restart.setBounds(570,150,100,50);
        Restart.addActionListener(this);
        add(Restart);

        score = new JLabel("Score");
        score.setBounds(600,280,100,50);
        score.setBackground(new Color(253, 244, 238));
        score.setFont(f1);
        add(score);

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (board.turn == 1){
            g.setColor(new Color(61, 101, 96));
            g.fillOval(570, 380, 50, 50);
            g.setColor(new Color(207, 170, 147, 77));
            g.fillOval(570, 458, 50, 50);
        }else if(board.turn == 2) {
            g.setColor(new Color(61, 101, 96, 77));
            g.fillOval(570, 380, 50, 50);
            g.setColor(new Color(207, 170, 147));
            g.fillOval(570, 458, 50, 50);
        }else if(board.turn == 0){
            g.setColor(new Color(61, 101, 96));
            g.fillOval(570, 380, 50, 50);
            g.setColor(new Color(207, 170, 147));
            g.fillOval(570, 458, 50, 50);

        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        greenScoreLabel.setText(String.valueOf(board.greenCount));
        apricotScoreLabel.setText(String.valueOf(board.apricotCount));

        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Restart){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board.pointHistory[i][j] = 0;
                }
            }
            board.pointHistory[3][3] = 1;
            board.pointHistory[3][4] = 2;
            board.pointHistory[4][3] = 2;
            board.pointHistory[4][4] = 1;

            board.repaint();

            greenScoreLabel.setText(String.valueOf(2));
            apricotScoreLabel.setText(String.valueOf(2));
        }
        else if(e.getSource() == Exit){
            System.exit(0);
        }
    }
}
