package com.a0.alcwithgoogle2.tictactoe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    int c[][];
    int i, j, k = 0;
    Button b[][];
    TextView textView;
    TextView player1textView;
    TextView aitextView;
    AI ai;
    int scoreCountp1;
    int scoreCountai;
    int playerTurn = 1;
    CharSequence theDraw = "Game Over, Its a Draw";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBoard();

    }


    /**
     * Set up the game board.
     */

    private void setBoard() {
        ai = new AI();
        b = new Button[6][6];
        c = new int[6][6];


        textView = (TextView) findViewById(R.id.dialogue);


        b[4][1] = (Button) findViewById(R.id.oneone1);
        b[4][2] = (Button) findViewById(R.id.one1);
        b[4][3] = (Button) findViewById(R.id.two1);
        b[4][4] = (Button) findViewById(R.id.three1);
        b[4][5] = (Button) findViewById(R.id.threethree1);

        b[1][3] = (Button) findViewById(R.id.one);
        b[1][2] = (Button) findViewById(R.id.two);
        b[1][1] = (Button) findViewById(R.id.three);
        b[1][4] = (Button) findViewById(R.id.oneone);
        b[1][5] = (Button) findViewById(R.id.threethree);


        b[2][3] = (Button) findViewById(R.id.four);
        b[2][2] = (Button) findViewById(R.id.five);
        b[2][1] = (Button) findViewById(R.id.six);
        b[2][4] = (Button) findViewById(R.id.fourfour);
        b[2][5] = (Button) findViewById(R.id.sixsix);


        b[3][3] = (Button) findViewById(R.id.seven);
        b[3][2] = (Button) findViewById(R.id.eight);
        b[3][1] = (Button) findViewById(R.id.nine);
        b[3][4] = (Button) findViewById(R.id.sevenseven);
        b[3][5] = (Button) findViewById(R.id.ninenine);

        b[5][1] = (Button) findViewById(R.id.seven1);
        b[5][4] = (Button) findViewById(R.id.sevenseven1);
        b[5][2] = (Button) findViewById(R.id.eight1);
        b[5][3] = (Button) findViewById(R.id.nine1);
        b[5][5] = (Button) findViewById(R.id.ninenine1);

        for (i = 1; i <= 5; i++) {
            for (j = 1; j <= 5; j++)
                c[i][j] = 2;
        }


        textView.setText("Click a button to start.");

/**
 *add the click listeners for each button
 */

        for (i = 1; i <= 5; i++) {
            for (j = 1; j <= 5; j++) {
                b[i][j].setOnClickListener(new MyClickListener(i, j));
                if (!b[i][j].isEnabled()) {
                    b[i][j].setText(" ");
                    b[i][j].setEnabled(true);
                }
            }
        }
    }


    class MyClickListener implements View.OnClickListener {
        int x;
        int y;


        public MyClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public void onClick(View view) {

            if (b[x][y].isEnabled()) {
                if (playerTurn % 2 != 0) {
                    b[x][y].setEnabled(false);
                    b[x][y].setText("O");
                    c[x][y] = 0;
                    playerTurn++;
                }  if (checkBoard() == 3 && playerTurn % 2 == 0 && theSwitch1() == false) {
                    ai.takeTurnSetThree();
                    playerTurn++;
                    checkBoard();

                }
                if (checkBoard() == 3 && playerTurn % 2 == 0 && theSwitch1() == true) {
                    ai.takeTurnSetFive();
                    playerTurn++;
                    checkBoard();

                }

            }

        }
    }


    private class AI {
        public void takeTurnSetThree() {
            if (c[1][1] == 2 &&
                    ((c[1][2] == 0 && c[1][3] == 0) ||
                            (c[2][2] == 0 && c[3][3] == 0) ||
                            (c[2][1] == 0 && c[3][1] == 0))) {
                markSquare(1, 1);
            } else if (c[1][2] == 2 &&
                    ((c[2][2] == 0 && c[3][2] == 0) ||
                            (c[1][1] == 0 && c[1][3] == 0))) {
                markSquare(1, 2);
            } else if (c[1][3] == 2 &&
                    ((c[1][1] == 0 && c[1][2] == 0) ||
                            (c[3][1] == 0 && c[2][2] == 0) ||
                            (c[2][3] == 0 && c[3][3] == 0))) {
                markSquare(1, 3);
            } else if (c[2][1] == 2 &&
                    ((c[2][2] == 0 && c[2][3] == 0) ||
                            (c[1][1] == 0 && c[3][1] == 0))) {
                markSquare(2, 1);
            } else if (c[2][2] == 2 &&
                    ((c[1][1] == 0 && c[3][3] == 0) ||
                            (c[1][2] == 0 && c[3][2] == 0) ||
                            (c[3][1] == 0 && c[1][3] == 0) ||
                            (c[2][1] == 0 && c[2][3] == 0))) {
                markSquare(2, 2);
            } else if (c[2][3] == 2 &&
                    ((c[2][1] == 0 && c[2][2] == 0) ||
                            (c[1][3] == 0 && c[3][3] == 0))) {
                markSquare(2, 3);
            } else if (c[3][1] == 2 &&
                    ((c[1][1] == 0 && c[2][1] == 0) ||
                            (c[3][2] == 0 && c[3][3] == 0) ||
                            (c[2][2] == 0 && c[1][3] == 0))) {
                markSquare(3, 1);
            } else if (c[3][2] == 2 &&
                    ((c[1][2] == 0 && c[2][2] == 0) ||
                            (c[3][1] == 0 && c[3][3] == 0))) {
                markSquare(3, 2);
            } else if (c[3][3] == 2 &&
                    ((c[1][1] == 0 && c[2][2] == 0) ||
                            (c[1][3] == 0 && c[2][3] == 0) ||
                            (c[3][1] == 0 && c[3][2] == 0))) {
                markSquare(3, 3);
            } else {
                Random rand = new Random();

                int a = rand.nextInt(4);
                int b = rand.nextInt(4);
                while (a == 0 || b == 0 || c[a][b] != 2) {
                    a = rand.nextInt(4);
                    b = rand.nextInt(4);
                }
                markSquare(a, b);
            }
        }

        public void takeTurnSetFive() {
            if (c[1][1] == 2 &&
                    ((c[1][2] == 0 && c[1][3] == 0) ||
                            (c[2][2] == 0 && c[3][3] == 0) ||
                            (c[2][1] == 0 && c[3][1] == 0))) {
                markSquare(1, 1);
            } else if (c[1][2] == 2 &&
                    ((c[2][2] == 0 && c[3][2] == 0) ||
                            (c[1][1] == 0 && c[1][3] == 0))) {
                markSquare(1, 2);
            } else if (c[1][3] == 2 &&
                    ((c[1][1] == 0 && c[1][2] == 0) ||
                            (c[3][1] == 0 && c[2][2] == 0) ||
                            (c[2][3] == 0 && c[3][3] == 0))) {
                markSquare(1, 3);
            } else if (c[2][1] == 2 &&
                    ((c[2][2] == 0 && c[2][3] == 0) ||
                            (c[1][1] == 0 && c[3][1] == 0))) {
                markSquare(2, 1);
            } else if (c[2][2] == 2 &&
                    ((c[1][1] == 0 && c[3][3] == 0) ||
                            (c[1][2] == 0 && c[3][2] == 0) ||
                            (c[3][1] == 0 && c[1][3] == 0) ||
                            (c[2][1] == 0 && c[2][3] == 0))) {
                markSquare(2, 2);
            } else if (c[2][3] == 2 &&
                    ((c[2][1] == 0 && c[2][2] == 0) ||
                            (c[1][3] == 0 && c[3][3] == 0))) {
                markSquare(2, 3);
            } else if (c[3][1] == 2 &&
                    ((c[1][1] == 0 && c[2][1] == 0) ||
                            (c[3][2] == 0 && c[3][3] == 0) ||
                            (c[2][2] == 0 && c[1][3] == 0))) {
                markSquare(3, 1);
            } else if (c[3][2] == 2 &&
                    ((c[1][2] == 0 && c[2][2] == 0) ||
                            (c[3][1] == 0 && c[3][3] == 0))) {
                markSquare(3, 2);
            } else if (c[3][3] == 2 &&
                    ((c[1][1] == 0 && c[2][2] == 0) ||
                            (c[1][3] == 0 && c[2][3] == 0) ||
                            (c[3][1] == 0 && c[3][2] == 0))) {
                markSquare(3, 3);
            } else if (c[4][1] == 2 &&
                    ((c[1][4] == 0 && c[2][4] == 0) ||
                            (c[4][2] == 0 && c[4][3] == 0) ||
                            (c[1][3] == 0 && c[2][2] == 0))) {
                markSquare(4, 1);
            } else if (c[4][2] == 2 &&
                    ((c[1][2] == 0 && c[2][1] == 0) ||
                            (c[1][3] == 0 && c[2][3] == 0) ||
                            (c[4][3] == 0 && c[4][4] == 0))) {
                markSquare(4, 2);
            } else if (c[4][3] == 2 &&
                    ((c[1][3] == 0 && c[2][4] == 0) ||
                            (c[1][1] == 0 && c[2][5] == 0) ||
                            (c[1][2] == 0 && c[2][2] == 0) ||
                            (c[4][4] == 0 && c[4][5] == 0) ||
                            (c[4][1] == 0 && c[4][2] == 0) ||
                            (c[4][2] == 0 && c[4][4] == 0))) {
                markSquare(4, 3);
            } else if (c[4][4] == 2 &&
                    ((c[1][2] == 0 && c[2][3] == 0) ||
                            (c[1][1] == 0 && c[2][1] == 0) ||
                            (c[4][3] == 0 && c[4][5] == 0) ||
                            (c[4][2] == 0 && c[4][3] == 0))) {
                markSquare(4, 4);
            } else if (c[4][5] == 2 &&
                    ((c[1][1] == 0 && c[2][2] == 0) ||
                            (c[1][5] == 0 && c[2][5] == 0) ||
                            (c[4][3] == 0 && c[4][4] == 0))) {
                markSquare(4, 5);
            } else if (c[1][4] == 2 &&
                    ((c[4][1] == 0 && c[2][4] == 0) ||
                            (c[2][4] == 0 && c[3][4] == 0) ||
                            (c[1][3] == 0 && c[1][2] == 0) ||
                            (c[2][3] == 0 && c[3][2] == 0))) {
                markSquare(1, 4);
            } else if (c[1][5] == 2 &&
                    ((c[2][1] == 0 && c[3][2] == 0) ||
                            (c[2][5] == 0 && c[3][5] == 0) ||
                            (c[4][5] == 0 && c[2][5] == 0) ||
                            (c[1][2] == 0 && c[1][1] == 0))) {
                markSquare(1, 5);
            } else if (c[2][4] == 2 &&
                    ((c[4][1] == 0 && c[1][4] == 0) ||
                            (c[1][4] == 0 && c[3][4] == 0) ||
                            (c[3][4] == 0 && c[5][4] == 0) ||
                            (c[2][3] == 0 && c[2][2] == 0) ||
                            (c[3][3] == 0 && c[5][2] == 0) ||
                            (c[1][3] == 0 && c[4][3] == 0))) {
                markSquare(2, 4);
            } else if (c[2][5] == 2 &&
                    ((c[1][5] == 0 && c[4][5] == 0) ||
                            (c[1][5] == 0 && c[3][5] == 0) ||
                            (c[3][5] == 0 && c[5][5] == 0) ||
                            (c[2][1] == 0 && c[2][2] == 0) ||
                            (c[3][1] == 0 && c[5][2] == 0) ||
                            (c[1][1] == 0 && c[4][3] == 0))) {
                markSquare(2, 5);
            } else if (c[3][4] == 2 &&
                    ((c[5][4] == 0 && c[2][4] == 0) ||
                            (c[2][4] == 0 && c[1][4] == 0) ||
                            (c[2][3] == 0 && c[1][2] == 0) ||
                            (c[3][3] == 0 && c[3][2] == 0))) {
                markSquare(3, 4);
            } else if (c[3][5] == 2 &&
                    ((c[5][5] == 0 && c[2][5] == 0) ||
                            (c[2][5] == 0 && c[1][5] == 0) ||
                            (c[2][1] == 0 && c[1][2] == 0) ||
                            (c[3][1] == 0 && c[3][2] == 0))) {
                markSquare(3, 5);
            } else if (c[5][4] == 2 &&
                    ((c[3][4] == 0 && c[2][4] == 0) ||
                            (c[3][3] == 0 && c[2][2] == 0) ||
                            (c[5][1] == 0 && c[5][2] == 0))) {
                markSquare(5, 4);
            } else if (c[5][1] == 2 &&
                    ((c[5][4] == 0 && c[5][2] == 0) ||
                            (c[5][2] == 0 && c[5][3] == 0) ||
                            (c[3][2] == 0 && c[2][1] == 0) ||
                            (c[2][3] == 0 && c[3][3] == 0))) {
                markSquare(5, 1);
            } else if (c[5][2] == 2 &&
                    ((c[5][4] == 0 && c[5][1] == 0) ||
                            (c[5][3] == 0 && c[5][5] == 0) ||
                            (c[5][1] == 0 && c[5][3] == 0) ||
                            (c[3][2] == 0 && c[2][2] == 0) ||
                            (c[3][1] == 0 && c[2][5] == 0) ||
                            (c[3][3] == 0 && c[2][4] == 0))) {
                markSquare(5, 2);
            } else if (c[5][3] == 2 &&
                    ((c[5][2] == 0 && c[5][5] == 0) ||
                            (c[5][1] == 0 && c[5][2] == 0) ||
                            (c[3][1] == 0 && c[2][1] == 0) ||
                            (c[2][3] == 0 && c[3][2] == 0))) {
                markSquare(5, 3);
            } else if (c[5][5] == 2 &&
                    ((c[5][2] == 0 && c[5][3] == 0) ||
                            (c[3][5] == 0 && c[2][5] == 0) ||
                            (c[3][1] == 0 && c[2][2] == 0) ||
                            (c[2][3] == 0 && c[3][2] == 0))) {
                markSquare(5, 5);
            } else {
                Random rand = new Random();

                int a = rand.nextInt(4);
                int b = rand.nextInt(4);
                while (a == 0 || b == 0 || c[a][b] != 2) {
                    a = rand.nextInt(4);
                    b = rand.nextInt(4);
                }
                markSquare(a, b);
            }
        }


        private void markSquare(int x, int y) {
            b[x][y].setEnabled(false);
            b[x][y].setText("X");
            c[x][y] = 1;
            checkBoard();
        }

    }
    /**
     * check the board to see if someone has won
     */
    private int checkBoard() {
        int gmover = 3;
        textView = (TextView) findViewById(R.id.dialogue);
        player1textView = (TextView) findViewById(R.id.player1score);
        aitextView = (TextView) findViewById(R.id.comptscore);
        if ((c[1][1] == 0 && c[2][2] == 0 && c[3][3] == 0)
                || (c[1][3] == 0 && c[2][2] == 0 && c[3][1] == 0)
                || (c[1][2] == 0 && c[2][2] == 0 && c[3][2] == 0)
                || (c[1][3] == 0 && c[2][3] == 0 && c[3][3] == 0)
                || (c[1][1] == 0 && c[1][2] == 0 && c[1][3] == 0)
                || (c[2][1] == 0 && c[2][2] == 0 && c[2][3] == 0)
                || (c[3][1] == 0 && c[3][2] == 0 && c[3][3] == 0)
                || (c[1][1] == 0 && c[2][1] == 0 && c[3][1] == 0)
                || (c[4][1] == 0 && c[1][3] == 0 && c[2][2] == 0)
                || (c[4][1] == 0 && c[4][2] == 0 && c[4][3] == 0)
                || (c[4][1] == 0 && c[1][4] == 0 && c[2][4] == 0)
                || (c[4][2] == 0 && c[4][3] == 0 && c[4][4] == 0)
                || (c[4][2] == 0 && c[1][3] == 0 && c[2][3] == 0)
                || (c[4][2] == 0 && c[1][2] == 0 && c[2][1] == 0)
                || (c[4][3] == 0 && c[1][3] == 0 && c[2][4] == 0)
                || (c[4][3] == 0 && c[1][2] == 0 && c[2][2] == 0)
                || (c[4][3] == 0 && c[1][1] == 0 && c[2][5] == 0)
                || (c[4][3] == 0 && c[4][4] == 0 && c[4][5] == 0)
                || (c[4][4] == 0 && c[1][2] == 0 && c[2][3] == 0)
                || (c[4][4] == 0 && c[1][1] == 0 && c[2][1] == 0)
                || (c[4][5] == 0 && c[1][5] == 0 && c[2][5] == 0)
                || (c[4][5] == 0 && c[1][1] == 0 && c[2][2] == 0)
                || (c[1][4] == 0 && c[2][4] == 0 && c[3][4] == 0)
                || (c[1][4] == 0 && c[1][3] == 0 && c[1][2] == 0)
                || (c[1][4] == 0 && c[2][3] == 0 && c[3][2] == 0)
                || (c[1][5] == 0 && c[2][5] == 0 && c[3][5] == 0)
                || (c[1][5] == 0 && c[2][1] == 0 && c[3][2] == 0)
                || (c[1][5] == 0 && c[1][1] == 0 && c[1][2] == 0)
                || (c[2][4] == 0 && c[2][3] == 0 && c[2][2] == 0)
                || (c[2][4] == 0 && c[3][4] == 0 && c[5][4] == 0)
                || (c[2][4] == 0 && c[3][3] == 0 && c[5][2] == 0)
                || (c[2][5] == 0 && c[3][5] == 0 && c[5][5] == 0)
                || (c[2][5] == 0 && c[5][2] == 0 && c[3][1] == 0)
                || (c[2][5] == 0 && c[2][1] == 0 && c[2][2] == 0)
                || (c[3][4] == 0 && c[2][3] == 0 && c[1][2] == 0)
                || (c[3][4] == 0 && c[3][3] == 0 && c[3][2] == 0)
                || (c[3][5] == 0 && c[2][1] == 0 && c[1][2] == 0)
                || (c[3][5] == 0 && c[3][2] == 0 && c[3][1] == 0)
                || (c[5][4] == 0 && c[3][3] == 0 && c[2][2] == 0)
                || (c[5][4] == 0 && c[5][2] == 0 && c[5][1] == 0)
                || (c[5][1] == 0 && c[5][2] == 0 && c[5][3] == 0)
                || (c[5][1] == 0 && c[3][2] == 0 && c[2][1] == 0)
                || (c[5][1] == 0 && c[3][3] == 0 && c[2][3] == 0)
                || (c[5][2] == 0 && c[5][3] == 0 && c[5][5] == 0)
                || (c[5][2] == 0 && c[3][2] == 0 && c[2][2] == 0)
                || (c[5][3] == 0 && c[3][2] == 0 && c[2][3] == 0)
                || (c[5][3] == 0 && c[2][1] == 0 && c[3][1] == 0)
                || (c[5][5] == 0 && c[2][2] == 0 && c[3][1] == 0))  {
            textView.setText("Game over. You win!");
            scoreCountp1++;
            displayForplayer1(scoreCountp1);
            gmover = 2;
            setBoard();
            return gmover;
        } else if ((c[1][1] == 1 && c[2][2] == 1 && c[3][3] == 1)
                || (c[1][3] == 1 && c[2][2] == 1 && c[3][1] == 1)
                || (c[1][2] == 1 && c[2][2] == 1 && c[3][2] == 1)
                || (c[1][3] == 1 && c[2][3] == 1 && c[3][3] == 1)
                || (c[1][1] == 1 && c[1][2] == 1 && c[1][3] == 1)
                || (c[2][1] == 1 && c[2][2] == 1 && c[2][3] == 1)
                || (c[3][1] == 1 && c[3][2] == 1 && c[3][3] == 1)
                || (c[1][1] == 1 && c[2][1] == 1 && c[3][1] == 1)
                || (c[4][1] == 1 && c[1][3] == 1 && c[2][2] == 1)
                || (c[4][1] == 1 && c[4][2] == 1 && c[4][3] == 1)
                || (c[4][1] == 1 && c[1][4] == 1 && c[2][4] == 1)
                || (c[4][2] == 1 && c[4][3] == 1 && c[4][4] == 1)
                || (c[4][2] == 1 && c[1][3] == 1 && c[2][3] == 1)
                || (c[4][2] == 1 && c[1][2] == 1 && c[2][1] == 1)
                || (c[4][3] == 1 && c[1][3] == 1 && c[2][4] == 1)
                || (c[4][3] == 1 && c[1][2] == 1 && c[2][2] == 1)
                || (c[4][3] == 1 && c[1][1] == 1 && c[2][5] == 1)
                || (c[4][3] == 1 && c[4][4] == 1 && c[4][5] == 1)
                || (c[4][4] == 1 && c[1][2] == 1 && c[2][3] == 1)
                || (c[4][4] == 1 && c[1][1] == 1 && c[2][1] == 1)
                || (c[4][5] == 1 && c[1][5] == 1 && c[2][5] == 1)
                || (c[4][5] == 1 && c[1][1] == 1 && c[2][2] == 1)
                || (c[1][4] == 1 && c[2][4] == 1 && c[3][4] == 1)
                || (c[1][4] == 1 && c[1][3] == 1 && c[1][2] == 1)
                || (c[1][4] == 1 && c[2][3] == 1 && c[3][2] == 1)
                || (c[1][5] == 1 && c[2][5] == 1 && c[3][5] == 1)
                || (c[1][5] == 1 && c[2][1] == 1 && c[3][2] == 1)
                || (c[1][5] == 1 && c[1][1] == 1 && c[1][2] == 1)
                || (c[2][4] == 1 && c[2][3] == 1 && c[2][2] == 1)
                || (c[2][4] == 1 && c[3][4] == 1 && c[5][4] == 1)
                || (c[2][4] == 1 && c[3][3] == 1 && c[5][2] == 1)
                || (c[2][5] == 1 && c[3][5] == 1 && c[5][5] == 1)
                || (c[2][5] == 1 && c[5][2] == 1 && c[3][1] == 1)
                || (c[2][5] == 1 && c[2][1] == 1 && c[2][2] == 1)
                || (c[3][4] == 1 && c[2][3] == 1 && c[1][2] == 1)
                || (c[3][4] == 1 && c[3][3] == 1 && c[3][2] == 1)
                || (c[3][5] == 1 && c[2][1] == 1 && c[1][2] == 1)
                || (c[3][5] == 1 && c[3][2] == 1 && c[3][1] == 1)
                || (c[5][4] == 1 && c[3][3] == 1 && c[2][2] == 1)
                || (c[5][4] == 1 && c[5][2] == 1 && c[5][1] == 1)
                || (c[5][1] == 1 && c[5][2] == 1 && c[5][3] == 1)
                || (c[5][1] == 1 && c[3][2] == 1 && c[2][1] == 1)
                || (c[5][1] == 1 && c[3][3] == 1 && c[2][3] == 1)
                || (c[5][2] == 1 && c[5][3] == 1 && c[5][5] == 1)
                || (c[5][2] == 1 && c[3][2] == 1 && c[2][2] == 1)
                || (c[5][3] == 1 && c[3][2] == 1 && c[2][3] == 1)
                || (c[5][3] == 1 && c[2][1] == 1 && c[3][1] == 1)
                || (c[5][5] == 1 && c[2][2] == 1 && c[3][1] == 1)) {
            textView.setText("Game over. You lost!");
            scoreCountai++;
            displayForAi(scoreCountai);
            setBoard();
            gmover = 1;
            return gmover;
        } else if (theSwitch1() == false) {
            boolean empty = false;
            for (i = 1; i <= 3; i++) {
                for (j = 1; j <= 3; j++) {
                    if (c[i][j] == 2) {
                        empty = true;
                        break;
                    }
                }
            }
            if (!empty) {
                setBoard();
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, theDraw, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                gmover = 0;
            }
        } else {
            boolean empty = false;
            for (i = 1; i <= 5; i++) {
                for (j = 1; j <= 5; j++) {
                    if (c[i][j] == 2) {
                        empty = true;
                        break;
                    }
                }
            }
            if (!empty) {
                setBoard();
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, theDraw, duration);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                gmover = 0;
            }
        }

        return gmover;
    }



    /**
     * Reset score
     */
    public void resetScore(View view) {
        scoreCountai = 0;
        scoreCountp1 = 0;
        displayForplayer1(scoreCountp1);
        displayForAi(scoreCountai);

        setBoard();

    }

    /**
     * Displays the given score for player 1.
     */
    public void displayForplayer1(int scoreCountp1) {
        TextView player1textView = (TextView) findViewById(R.id.player1score);
        player1textView.setText(String.valueOf(scoreCountp1));
    }

    /**
     * Displays the given score for AI.
     */
    public void displayForAi(int scoreCountai) {
        TextView aitextView = (TextView) findViewById(R.id.comptscore);
        aitextView.setText(String.valueOf(scoreCountai));
    }


    public void setSize3 (View view){
        Button button1 = (Button) findViewById(R.id.oneone);
        Button button2 = (Button) findViewById(R.id.threethree);
        Button button3 = (Button) findViewById(R.id.fourfour);
        Button button4 = (Button) findViewById(R.id.sixsix);
        Button button5 = (Button) findViewById(R.id.sevenseven);
        Button button6 = (Button) findViewById(R.id.ninenine);
        Button button7 = (Button) findViewById(R.id.oneone1);
        Button button8 = (Button) findViewById(R.id.one1);
        Button button9 = (Button) findViewById(R.id.two1);
        Button button10 = (Button) findViewById(R.id.three1);
        Button button11 = (Button) findViewById(R.id.threethree1);
        Button button12 = (Button) findViewById(R.id.seven1);
        Button button13 = (Button) findViewById(R.id.sevenseven1);
        Button button14 = (Button) findViewById(R.id.eight1);
        Button button15 = (Button) findViewById(R.id.nine1);
        Button button16 = (Button) findViewById(R.id.ninenine1);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
        button7.setVisibility(View.GONE);
        button8.setVisibility(View.GONE);
        button9.setVisibility(View.GONE);
        button10.setVisibility(View.GONE);
        button11.setVisibility(View.GONE);
        button12.setVisibility(View.GONE);
        button13.setVisibility(View.GONE);
        button14.setVisibility(View.GONE);
        button15.setVisibility(View.GONE);
        button16.setVisibility(View.GONE);
        setBoard();

    }
    public void setSize5 (View view){
        Button button1 = (Button) findViewById(R.id.oneone);
        Button button2 = (Button) findViewById(R.id.threethree);
        Button button3 = (Button) findViewById(R.id.fourfour);
        Button button4 = (Button) findViewById(R.id.sixsix);
        Button button5 = (Button) findViewById(R.id.sevenseven);
        Button button6 = (Button) findViewById(R.id.ninenine);
        Button button7 = (Button) findViewById(R.id.oneone1);
        Button button8 = (Button) findViewById(R.id.one1);
        Button button9 = (Button) findViewById(R.id.two1);
        Button button10 = (Button) findViewById(R.id.three1);
        Button button11 = (Button) findViewById(R.id.threethree1);
        Button button12 = (Button) findViewById(R.id.seven1);
        Button button13 = (Button) findViewById(R.id.sevenseven1);
        Button button14 = (Button) findViewById(R.id.eight1);
        Button button15 = (Button) findViewById(R.id.nine1);
        Button button16 = (Button) findViewById(R.id.ninenine1);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        button6.setVisibility(View.VISIBLE);
        button7.setVisibility(View.VISIBLE);
        button8.setVisibility(View.VISIBLE);
        button9.setVisibility(View.VISIBLE);
        button10.setVisibility(View.VISIBLE);
        button11.setVisibility(View.VISIBLE);
        button12.setVisibility(View.VISIBLE);
        button13.setVisibility(View.VISIBLE);
        button14.setVisibility(View.VISIBLE);
        button15.setVisibility(View.VISIBLE);
        button16.setVisibility(View.VISIBLE);

        setBoard();

    }
    public boolean theSwitch1() {
        boolean theSwitch = false;
        Button button1 = (Button) findViewById(R.id.oneone);
        Button button2 = (Button) findViewById(R.id.threethree);
        Button button3 = (Button) findViewById(R.id.fourfour);
        Button button4 = (Button) findViewById(R.id.sixsix);
        Button button5 = (Button) findViewById(R.id.sevenseven);
        Button button6 = (Button) findViewById(R.id.ninenine);
        Button button7 = (Button) findViewById(R.id.oneone1);
        Button button8 = (Button) findViewById(R.id.one1);
        Button button9 = (Button) findViewById(R.id.two1);
        Button button10 = (Button) findViewById(R.id.three1);
        Button button11 = (Button) findViewById(R.id.threethree1);
        Button button12 = (Button) findViewById(R.id.seven1);
        Button button13 = (Button) findViewById(R.id.sevenseven1);
        Button button14 = (Button) findViewById(R.id.eight1);
        Button button15 = (Button) findViewById(R.id.nine1);
        Button button16 = (Button) findViewById(R.id.ninenine1);
        if (button1.getVisibility() == View.VISIBLE && button2.getVisibility() == View.VISIBLE && button3.getVisibility() == View.VISIBLE
                && button4.getVisibility() == View.VISIBLE && button5.getVisibility() == View.VISIBLE
                && button6.getVisibility() == View.VISIBLE && button7.getVisibility() == View.VISIBLE
                && button8.getVisibility() == View.VISIBLE && button9.getVisibility() == View.VISIBLE
                && button10.getVisibility() == View.VISIBLE && button11.getVisibility() == View.VISIBLE
                && button12.getVisibility() == View.VISIBLE && button13.getVisibility() == View.VISIBLE
                && button14.getVisibility() == View.VISIBLE && button15.getVisibility() == View.VISIBLE
                && button16.getVisibility() == View.VISIBLE) {
            theSwitch = true;
        }


        return theSwitch;
    }
}

