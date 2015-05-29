package SudokuSolver;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class gui {

	private JFrame frmSudokuSolverSwag;
	private JTextField A1;
	private JTextField A2;
	private JTextField A3;
	private JTextField B1;
	private JTextField B2;
	private JTextField B3;
	private JTextField C1;
	private JTextField C2;
	private JTextField C3;
	private JSeparator separator;
	private JTextField A4;
	private JTextField A5;
	private JTextField A6;
	private JTextField B4;
	private JTextField B5;
	private JTextField B6;
	private JTextField C4;
	private JTextField C5;
	private JTextField C6;
	private JSeparator separator_1;
	private JTextField A7;
	private JTextField A8;
	private JTextField A9;
	private JTextField B7;
	private JTextField B8;
	private JTextField B9;
	private JTextField C7;
	private JTextField C8;
	private JTextField C9;
	private JSeparator separator_2;
	private JTextField D1;
	private JTextField D2;
	private JTextField D3;
	private JTextField E1;
	private JTextField E2;
	private JTextField E3;
	private JTextField F1;
	private JTextField F2;
	private JTextField F3;
	private JTextField D4;
	private JTextField D5;
	private JTextField D6;
	private JTextField E4;
	private JTextField E5;
	private JTextField E6;
	private JTextField F4;
	private JTextField F5;
	private JTextField F6;
	private JTextField D7;
	private JTextField D8;
	private JTextField D9;
	private JTextField E7;
	private JTextField E8;
	private JTextField E9;
	private JTextField F7;
	private JTextField F8;
	private JTextField F9;
	private JSeparator separator_3;
	private JTextField G1;
	private JTextField G2;
	private JTextField G3;
	private JTextField H1;
	private JTextField H2;
	private JTextField H3;
	private JTextField I1;
	private JTextField I2;
	private JTextField I3;
	private JTextField G4;
	private JTextField G5;
	private JTextField G6;
	private JTextField H4;
	private JTextField H5;
	private JTextField H6;
	private JTextField I4;
	private JTextField I5;
	private JTextField I6;
	private JTextField G7;
	private JTextField G8;
	private JTextField G9;
	private JTextField H7;
	private JTextField H8;
	private JTextField H9;
	private JTextField I7;
	private JTextField I8;
	private JTextField I9;
	private JSeparator separator_5;
	private JLabel lblTextConsole;
	private JTextArea console;
	private JTextField txtPasteRowBy;
	private JButton bClearBoard;
	private JButton bSolve;
	private JButton bTakeStep = new JButton("Take Step");
	private JButton bPreviousStep = new JButton("<<");
	private JButton bNextStep = new JButton(">>");

	//TODO variables
	boolean enterByRow = true, enterByCol = false, enterByCube = false;
	boolean showSteps = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frmSudokuSolverSwag.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSudokuSolverSwag = new JFrame();
		frmSudokuSolverSwag.setTitle("Sudoku Solver");
		frmSudokuSolverSwag.setResizable(false);
		frmSudokuSolverSwag.setBounds(100, 100, 650, 522);
		frmSudokuSolverSwag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSudokuSolverSwag.getContentPane().setLayout(null);

		A1 = new JTextField();
		A1.setFont(new Font("Tahoma", Font.BOLD, 18));
		A1.setHorizontalAlignment(SwingConstants.CENTER);
		A1.setBounds(10, 11, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(A1);
		A1.setColumns(10);
		A1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("A1");
			}
		});

		A2 = new JTextField();
		A2.setFont(new Font("Tahoma", Font.BOLD, 18));
		A2.setHorizontalAlignment(SwingConstants.CENTER);
		A2.setColumns(10);
		A2.setBounds(60, 11, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(A2);
		A2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("A2");
			}
		});

		A3 = new JTextField();
		A3.setFont(new Font("Tahoma", Font.BOLD, 18));
		A3.setHorizontalAlignment(SwingConstants.CENTER);
		A3.setColumns(10);
		A3.setBounds(110, 11, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(A3);
		A3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("A3");
			}
		});

		A4 = new JTextField();
		A4.setFont(new Font("Tahoma", Font.BOLD, 18));
		A4.setHorizontalAlignment(SwingConstants.CENTER);
		A4.setColumns(10);
		A4.setBounds(171, 11, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(A4);
		A4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("A4");
			}
		});

		A5 = new JTextField();
		A5.setFont(new Font("Tahoma", Font.BOLD, 18));
		A5.setHorizontalAlignment(SwingConstants.CENTER);
		A5.setColumns(10);
		A5.setBounds(221, 11, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(A5);
		A5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("A5");
			}
		});

		A6 = new JTextField();
		A6.setFont(new Font("Tahoma", Font.BOLD, 18));
		A6.setHorizontalAlignment(SwingConstants.CENTER);
		A6.setColumns(10);
		A6.setBounds(271, 11, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(A6);
		A6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("A6");
			}
		});

		A7 = new JTextField();
		A7.setFont(new Font("Tahoma", Font.BOLD, 18));
		A7.setHorizontalAlignment(SwingConstants.CENTER);
		A7.setColumns(10);
		A7.setBounds(332, 11, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(A7);
		A7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("A7");
			}
		});

		A8 = new JTextField();
		A8.setFont(new Font("Tahoma", Font.BOLD, 18));
		A8.setHorizontalAlignment(SwingConstants.CENTER);
		A8.setColumns(10);
		A8.setBounds(382, 11, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(A8);
		A8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("A8");
			}
		});

		A9 = new JTextField();
		A9.setFont(new Font("Tahoma", Font.BOLD, 18));
		A9.setHorizontalAlignment(SwingConstants.CENTER);
		A9.setColumns(10);
		A9.setBounds(432, 11, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(A9);
		A9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("A9");
			}
		});

		B1 = new JTextField();
		B1.setFont(new Font("Tahoma", Font.BOLD, 18));
		B1.setHorizontalAlignment(SwingConstants.CENTER);
		B1.setColumns(10);
		B1.setBounds(10, 62, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(B1);
		B1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("B1");
			}
		});

		B2 = new JTextField();
		B2.setFont(new Font("Tahoma", Font.BOLD, 18));
		B2.setHorizontalAlignment(SwingConstants.CENTER);
		B2.setColumns(10);
		B2.setBounds(60, 62, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(B2);
		B2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("B2");
			}
		});

		B3 = new JTextField();
		B3.setFont(new Font("Tahoma", Font.BOLD, 18));
		B3.setHorizontalAlignment(SwingConstants.CENTER);
		B3.setColumns(10);
		B3.setBounds(110, 62, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(B3);
		B3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("B3");
			}
		});

		B4 = new JTextField();
		B4.setFont(new Font("Tahoma", Font.BOLD, 18));
		B4.setHorizontalAlignment(SwingConstants.CENTER);
		B4.setColumns(10);
		B4.setBounds(171, 62, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(B4);
		B4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("B4");
			}
		});

		B5 = new JTextField();
		B5.setFont(new Font("Tahoma", Font.BOLD, 18));
		B5.setHorizontalAlignment(SwingConstants.CENTER);
		B5.setColumns(10);
		B5.setBounds(221, 62, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(B5);
		B5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("B5");
			}
		});

		B6 = new JTextField();
		B6.setFont(new Font("Tahoma", Font.BOLD, 18));
		B6.setHorizontalAlignment(SwingConstants.CENTER);
		B6.setColumns(10);
		B6.setBounds(271, 62, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(B6);
		B6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("B6");
			}
		});

		B7 = new JTextField();
		B7.setFont(new Font("Tahoma", Font.BOLD, 18));
		B7.setHorizontalAlignment(SwingConstants.CENTER);
		B7.setColumns(10);
		B7.setBounds(332, 62, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(B7);
		B7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("B7");
			}
		});

		B8 = new JTextField();
		B8.setFont(new Font("Tahoma", Font.BOLD, 18));
		B8.setHorizontalAlignment(SwingConstants.CENTER);
		B8.setColumns(10);
		B8.setBounds(382, 62, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(B8);
		B8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("B8");
			}
		});

		B9 = new JTextField();
		B9.setFont(new Font("Tahoma", Font.BOLD, 18));
		B9.setHorizontalAlignment(SwingConstants.CENTER);
		B9.setColumns(10);
		B9.setBounds(432, 62, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(B9);
		B9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("B9");
			}
		});

		C1 = new JTextField();
		C1.setFont(new Font("Tahoma", Font.BOLD, 18));
		C1.setHorizontalAlignment(SwingConstants.CENTER);
		C1.setColumns(10);
		C1.setBounds(10, 113, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(C1);
		C1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("C1");
			}
		});

		C2 = new JTextField();
		C2.setFont(new Font("Tahoma", Font.BOLD, 18));
		C2.setHorizontalAlignment(SwingConstants.CENTER);
		C2.setColumns(10);
		C2.setBounds(60, 113, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(C2);
		C2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("C2");
			}
		});

		C3 = new JTextField();
		C3.setFont(new Font("Tahoma", Font.BOLD, 18));
		C3.setHorizontalAlignment(SwingConstants.CENTER);
		C3.setColumns(10);
		C3.setBounds(110, 113, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(C3);
		C3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("C3");
			}
		});

		C4 = new JTextField();
		C4.setFont(new Font("Tahoma", Font.BOLD, 18));
		C4.setHorizontalAlignment(SwingConstants.CENTER);
		C4.setColumns(10);
		C4.setBounds(171, 113, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(C4);
		C4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("C4");
			}
		});

		C5 = new JTextField();
		C5.setFont(new Font("Tahoma", Font.BOLD, 18));
		C5.setHorizontalAlignment(SwingConstants.CENTER);
		C5.setColumns(10);
		C5.setBounds(221, 113, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(C5);
		C5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("C5");
			}
		});

		C6 = new JTextField();
		C6.setFont(new Font("Tahoma", Font.BOLD, 18));
		C6.setHorizontalAlignment(SwingConstants.CENTER);
		C6.setColumns(10);
		C6.setBounds(271, 113, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(C6);
		C6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("C6");
			}
		});

		C7 = new JTextField();
		C7.setFont(new Font("Tahoma", Font.BOLD, 18));
		C7.setHorizontalAlignment(SwingConstants.CENTER);
		C7.setColumns(10);
		C7.setBounds(332, 113, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(C7);
		C7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("C7");
			}
		});

		C8 = new JTextField();
		C8.setFont(new Font("Tahoma", Font.BOLD, 18));
		C8.setHorizontalAlignment(SwingConstants.CENTER);
		C8.setColumns(10);
		C8.setBounds(382, 113, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(C8);
		C8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("C8");
			}
		});

		C9 = new JTextField();
		C9.setFont(new Font("Tahoma", Font.BOLD, 18));
		C9.setHorizontalAlignment(SwingConstants.CENTER);
		C9.setColumns(10);
		C9.setBounds(432, 113, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(C9);
		C9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("C9");
			}
		});

		D1 = new JTextField();
		D1.setFont(new Font("Tahoma", Font.BOLD, 18));
		D1.setHorizontalAlignment(SwingConstants.CENTER);
		D1.setColumns(10);
		D1.setBounds(10, 177, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(D1);
		D1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("D1");
			}
		});

		D2 = new JTextField();
		D2.setFont(new Font("Tahoma", Font.BOLD, 18));
		D2.setHorizontalAlignment(SwingConstants.CENTER);
		D2.setColumns(10);
		D2.setBounds(60, 177, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(D2);
		D2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("D2");
			}
		});

		D3 = new JTextField();
		D3.setFont(new Font("Tahoma", Font.BOLD, 18));
		D3.setHorizontalAlignment(SwingConstants.CENTER);
		D3.setColumns(10);
		D3.setBounds(110, 177, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(D3);
		D3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("D3");
			}
		});

		D4 = new JTextField();
		D4.setFont(new Font("Tahoma", Font.BOLD, 18));
		D4.setHorizontalAlignment(SwingConstants.CENTER);
		D4.setColumns(10);
		D4.setBounds(171, 177, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(D4);
		D4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("D4");
			}
		});

		D5 = new JTextField();
		D5.setFont(new Font("Tahoma", Font.BOLD, 18));
		D5.setHorizontalAlignment(SwingConstants.CENTER);
		D5.setColumns(10);
		D5.setBounds(221, 177, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(D5);
		D5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("D5");
			}
		});

		D6 = new JTextField();
		D6.setFont(new Font("Tahoma", Font.BOLD, 18));
		D6.setHorizontalAlignment(SwingConstants.CENTER);
		D6.setColumns(10);
		D6.setBounds(271, 177, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(D6);
		D6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("D6");
			}
		});

		D7 = new JTextField();
		D7.setFont(new Font("Tahoma", Font.BOLD, 18));
		D7.setHorizontalAlignment(SwingConstants.CENTER);
		D7.setColumns(10);
		D7.setBounds(332, 177, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(D7);
		D7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("D7");
			}
		});

		D8 = new JTextField();
		D8.setFont(new Font("Tahoma", Font.BOLD, 18));
		D8.setHorizontalAlignment(SwingConstants.CENTER);
		D8.setColumns(10);
		D8.setBounds(382, 177, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(D8);
		D8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("D8");
			}
		});

		D9 = new JTextField();
		D9.setFont(new Font("Tahoma", Font.BOLD, 18));
		D9.setHorizontalAlignment(SwingConstants.CENTER);
		D9.setColumns(10);
		D9.setBounds(432, 177, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(D9);
		D9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("D9");
			}
		});

		E1 = new JTextField();
		E1.setFont(new Font("Tahoma", Font.BOLD, 18));
		E1.setHorizontalAlignment(SwingConstants.CENTER);
		E1.setColumns(10);
		E1.setBounds(10, 228, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(E1);
		E1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("E1");
			}
		});

		E2 = new JTextField();
		E2.setFont(new Font("Tahoma", Font.BOLD, 18));
		E2.setHorizontalAlignment(SwingConstants.CENTER);
		E2.setColumns(10);
		E2.setBounds(60, 228, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(E2);
		E2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("E2");
			}
		});

		E3 = new JTextField();
		E3.setFont(new Font("Tahoma", Font.BOLD, 18));
		E3.setHorizontalAlignment(SwingConstants.CENTER);
		E3.setColumns(10);
		E3.setBounds(110, 228, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(E3);
		E3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("E3");
			}
		});

		E4 = new JTextField();
		E4.setFont(new Font("Tahoma", Font.BOLD, 18));
		E4.setHorizontalAlignment(SwingConstants.CENTER);
		E4.setColumns(10);
		E4.setBounds(171, 228, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(E4);
		E4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("E4");
			}
		});

		E5 = new JTextField();
		E5.setFont(new Font("Tahoma", Font.BOLD, 18));
		E5.setHorizontalAlignment(SwingConstants.CENTER);
		E5.setColumns(10);
		E5.setBounds(221, 228, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(E5);
		E5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("E5");
			}
		});

		E6 = new JTextField();
		E6.setFont(new Font("Tahoma", Font.BOLD, 18));
		E6.setHorizontalAlignment(SwingConstants.CENTER);
		E6.setColumns(10);
		E6.setBounds(271, 228, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(E6);
		E6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("E6");
			}
		});

		E7 = new JTextField();
		E7.setFont(new Font("Tahoma", Font.BOLD, 18));
		E7.setHorizontalAlignment(SwingConstants.CENTER);
		E7.setColumns(10);
		E7.setBounds(332, 228, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(E7);
		E7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("E7");
			}
		});

		E8 = new JTextField();
		E8.setFont(new Font("Tahoma", Font.BOLD, 18));
		E8.setHorizontalAlignment(SwingConstants.CENTER);
		E8.setColumns(10);
		E8.setBounds(382, 228, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(E8);
		E8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("E8");
			}
		});

		E9 = new JTextField();
		E9.setFont(new Font("Tahoma", Font.BOLD, 18));
		E9.setHorizontalAlignment(SwingConstants.CENTER);
		E9.setColumns(10);
		E9.setBounds(432, 228, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(E9);
		E9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("E9");
			}
		});

		F1 = new JTextField();
		F1.setFont(new Font("Tahoma", Font.BOLD, 18));
		F1.setHorizontalAlignment(SwingConstants.CENTER);
		F1.setColumns(10);
		F1.setBounds(10, 279, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(F1);
		F1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("F1");
			}
		});

		F2 = new JTextField();
		F2.setFont(new Font("Tahoma", Font.BOLD, 18));
		F2.setHorizontalAlignment(SwingConstants.CENTER);
		F2.setColumns(10);
		F2.setBounds(60, 279, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(F2);
		F2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("F2");
			}
		});

		F3 = new JTextField();
		F3.setFont(new Font("Tahoma", Font.BOLD, 18));
		F3.setHorizontalAlignment(SwingConstants.CENTER);
		F3.setColumns(10);
		F3.setBounds(110, 279, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(F3);
		F3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("F3");
			}
		});

		F4 = new JTextField();
		F4.setFont(new Font("Tahoma", Font.BOLD, 18));
		F4.setHorizontalAlignment(SwingConstants.CENTER);
		F4.setColumns(10);
		F4.setBounds(171, 279, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(F4);
		F4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("F4");
			}
		});

		F5 = new JTextField();
		F5.setFont(new Font("Tahoma", Font.BOLD, 18));
		F5.setHorizontalAlignment(SwingConstants.CENTER);
		F5.setColumns(10);
		F5.setBounds(221, 279, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(F5);
		F5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("F5");
			}
		});

		F6 = new JTextField();
		F6.setFont(new Font("Tahoma", Font.BOLD, 18));
		F6.setHorizontalAlignment(SwingConstants.CENTER);
		F6.setColumns(10);
		F6.setBounds(271, 279, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(F6);
		F6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("F6");
			}
		});

		F7 = new JTextField();
		F7.setFont(new Font("Tahoma", Font.BOLD, 18));
		F7.setHorizontalAlignment(SwingConstants.CENTER);
		F7.setColumns(10);
		F7.setBounds(332, 279, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(F7);
		F7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("F7");
			}
		});

		F8 = new JTextField();
		F8.setFont(new Font("Tahoma", Font.BOLD, 18));
		F8.setHorizontalAlignment(SwingConstants.CENTER);
		F8.setColumns(10);
		F8.setBounds(382, 279, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(F8);
		F8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("F8");
			}
		});

		F9 = new JTextField();
		F9.setFont(new Font("Tahoma", Font.BOLD, 18));
		F9.setHorizontalAlignment(SwingConstants.CENTER);
		F9.setColumns(10);
		F9.setBounds(432, 279, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(F9);
		F9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("F9");
			}
		});

		G1 = new JTextField();
		G1.setFont(new Font("Tahoma", Font.BOLD, 18));
		G1.setHorizontalAlignment(SwingConstants.CENTER);
		G1.setColumns(10);
		G1.setBounds(10, 343, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(G1);
		G1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("G1");
			}
		});

		G2 = new JTextField();
		G2.setFont(new Font("Tahoma", Font.BOLD, 18));
		G2.setHorizontalAlignment(SwingConstants.CENTER);
		G2.setColumns(10);
		G2.setBounds(60, 343, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(G2);
		G2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("G2");
			}
		});

		G3 = new JTextField();
		G3.setFont(new Font("Tahoma", Font.BOLD, 18));
		G3.setHorizontalAlignment(SwingConstants.CENTER);
		G3.setColumns(10);
		G3.setBounds(110, 343, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(G3);
		G3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("G3");
			}
		});

		G4 = new JTextField();
		G4.setFont(new Font("Tahoma", Font.BOLD, 18));
		G4.setHorizontalAlignment(SwingConstants.CENTER);
		G4.setColumns(10);
		G4.setBounds(171, 343, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(G4);
		G4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("G4");
			}
		});

		G5 = new JTextField();
		G5.setFont(new Font("Tahoma", Font.BOLD, 18));
		G5.setHorizontalAlignment(SwingConstants.CENTER);
		G5.setColumns(10);
		G5.setBounds(221, 343, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(G5);
		G5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("G5");
			}
		});

		G6 = new JTextField();
		G6.setFont(new Font("Tahoma", Font.BOLD, 18));
		G6.setHorizontalAlignment(SwingConstants.CENTER);
		G6.setColumns(10);
		G6.setBounds(271, 343, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(G6);
		G6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("G6");
			}
		});

		G7 = new JTextField();
		G7.setFont(new Font("Tahoma", Font.BOLD, 18));
		G7.setHorizontalAlignment(SwingConstants.CENTER);
		G7.setColumns(10);
		G7.setBounds(332, 343, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(G7);
		G7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("G7");
			}
		});

		G8 = new JTextField();
		G8.setFont(new Font("Tahoma", Font.BOLD, 18));
		G8.setHorizontalAlignment(SwingConstants.CENTER);
		G8.setColumns(10);
		G8.setBounds(382, 343, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(G8);
		G8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("G8");
			}
		});

		G9 = new JTextField();
		G9.setFont(new Font("Tahoma", Font.BOLD, 18));
		G9.setHorizontalAlignment(SwingConstants.CENTER);
		G9.setColumns(10);
		G9.setBounds(432, 343, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(G9);
		G9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("G9");
			}
		});

		H1 = new JTextField();
		H1.setFont(new Font("Tahoma", Font.BOLD, 18));
		H1.setHorizontalAlignment(SwingConstants.CENTER);
		H1.setColumns(10);
		H1.setBounds(10, 394, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(H1);
		H1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("H1");
			}
		});

		H2 = new JTextField();
		H2.setFont(new Font("Tahoma", Font.BOLD, 18));
		H2.setHorizontalAlignment(SwingConstants.CENTER);
		H2.setColumns(10);
		H2.setBounds(60, 394, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(H2);
		H2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("H2");
			}
		});

		H3 = new JTextField();
		H3.setFont(new Font("Tahoma", Font.BOLD, 18));
		H3.setHorizontalAlignment(SwingConstants.CENTER);
		H3.setColumns(10);
		H3.setBounds(110, 394, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(H3);
		H3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("H3");
			}
		});

		H4 = new JTextField();
		H4.setFont(new Font("Tahoma", Font.BOLD, 18));
		H4.setHorizontalAlignment(SwingConstants.CENTER);
		H4.setColumns(10);
		H4.setBounds(171, 394, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(H4);
		H4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("H4");
			}
		});

		H5 = new JTextField();
		H5.setFont(new Font("Tahoma", Font.BOLD, 18));
		H5.setHorizontalAlignment(SwingConstants.CENTER);
		H5.setColumns(10);
		H5.setBounds(221, 394, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(H5);
		H5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("H5");
			}
		});

		H6 = new JTextField();
		H6.setFont(new Font("Tahoma", Font.BOLD, 18));
		H6.setHorizontalAlignment(SwingConstants.CENTER);
		H6.setColumns(10);
		H6.setBounds(271, 394, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(H6);
		H6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("H6");
			}
		});

		H7 = new JTextField();
		H7.setFont(new Font("Tahoma", Font.BOLD, 18));
		H7.setHorizontalAlignment(SwingConstants.CENTER);
		H7.setColumns(10);
		H7.setBounds(332, 394, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(H7);
		H7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("H7");
			}
		});

		H8 = new JTextField();
		H8.setFont(new Font("Tahoma", Font.BOLD, 18));
		H8.setHorizontalAlignment(SwingConstants.CENTER);
		H8.setColumns(10);
		H8.setBounds(382, 394, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(H8);
		H8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("H8");
			}
		});

		H9 = new JTextField();
		H9.setFont(new Font("Tahoma", Font.BOLD, 18));
		H9.setHorizontalAlignment(SwingConstants.CENTER);
		H9.setColumns(10);
		H9.setBounds(432, 394, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(H9);
		H9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("H9");
			}
		});

		I1 = new JTextField();
		I1.setFont(new Font("Tahoma", Font.BOLD, 18));
		I1.setHorizontalAlignment(SwingConstants.CENTER);
		I1.setColumns(10);
		I1.setBounds(10, 445, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(I1);
		I1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("I1");
			}
		});

		I2 = new JTextField();
		I2.setFont(new Font("Tahoma", Font.BOLD, 18));
		I2.setHorizontalAlignment(SwingConstants.CENTER);
		I2.setColumns(10);
		I2.setBounds(60, 445, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(I2);
		I2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("I2");
			}
		});

		I3 = new JTextField();
		I3.setFont(new Font("Tahoma", Font.BOLD, 18));
		I3.setHorizontalAlignment(SwingConstants.CENTER);
		I3.setColumns(10);
		I3.setBounds(110, 445, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(I3);
		I3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("I3");
			}
		});

		I4 = new JTextField();
		I4.setFont(new Font("Tahoma", Font.BOLD, 18));
		I4.setHorizontalAlignment(SwingConstants.CENTER);
		I4.setColumns(10);
		I4.setBounds(171, 445, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(I4);
		I4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("I4");
			}
		});

		I5 = new JTextField();
		I5.setFont(new Font("Tahoma", Font.BOLD, 18));
		I5.setHorizontalAlignment(SwingConstants.CENTER);
		I5.setColumns(10);
		I5.setBounds(221, 445, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(I5);
		I5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("I5");
			}
		});

		I6 = new JTextField();
		I6.setFont(new Font("Tahoma", Font.BOLD, 18));
		I6.setHorizontalAlignment(SwingConstants.CENTER);
		I6.setColumns(10);
		I6.setBounds(271, 445, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(I6);
		I6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("I6");
			}
		});

		I7 = new JTextField();
		I7.setFont(new Font("Tahoma", Font.BOLD, 18));
		I7.setHorizontalAlignment(SwingConstants.CENTER);
		I7.setColumns(10);
		I7.setBounds(332, 445, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(I7);
		I7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("I7");
			}
		});

		I8 = new JTextField();
		I8.setFont(new Font("Tahoma", Font.BOLD, 18));
		I8.setHorizontalAlignment(SwingConstants.CENTER);
		I8.setColumns(10);
		I8.setBounds(382, 445, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(I8);
		I8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("I8");
			}
		});

		I9 = new JTextField();
		I9.setFont(new Font("Tahoma", Font.BOLD, 18));
		I9.setHorizontalAlignment(SwingConstants.CENTER);
		I9.setColumns(10);
		I9.setBounds(432, 445, 40, 40);
		frmSudokuSolverSwag.getContentPane().add(I9);
		I9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				nextFocus("I9");
			}
		});

		separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(160, 11, 1, 474);
		frmSudokuSolverSwag.getContentPane().add(separator);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(321, 11, 1, 474);
		frmSudokuSolverSwag.getContentPane().add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setForeground(Color.DARK_GRAY);
		separator_2.setBounds(10, 164, 462, 2);
		frmSudokuSolverSwag.getContentPane().add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setForeground(Color.DARK_GRAY);
		separator_3.setBounds(10, 330, 462, 2);
		frmSudokuSolverSwag.getContentPane().add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.DARK_GRAY);
		separator_4.setBounds(482, 164, 152, 2);
		frmSudokuSolverSwag.getContentPane().add(separator_4);

		separator_5 = new JSeparator();
		separator_5.setForeground(Color.DARK_GRAY);
		separator_5.setBounds(482, 338, 152, 2);
		frmSudokuSolverSwag.getContentPane().add(separator_5);

		JLabel lblEnteringTheSudoku = new JLabel("Entering the Sudoku");
		lblEnteringTheSudoku.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnteringTheSudoku.setBounds(482, 11, 152, 16);
		frmSudokuSolverSwag.getContentPane().add(lblEnteringTheSudoku);

		JLabel lblUsingTheSolver = new JLabel("Using the Solver");
		lblUsingTheSolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsingTheSolver.setBounds(482, 175, 152, 16);
		frmSudokuSolverSwag.getContentPane().add(lblUsingTheSolver);

		lblTextConsole = new JLabel("Text Console");
		lblTextConsole.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTextConsole.setBounds(482, 346, 152, 16);
		frmSudokuSolverSwag.getContentPane().add(lblTextConsole);

		JCheckBox cbEnterByRow = new JCheckBox("Enter by row");
		JCheckBox cbEnterByCol = new JCheckBox("Enter by column");
		JCheckBox cbEnterByCube = new JCheckBox("Enter by cube");
		cbEnterByRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (enterByRow)
					enterByRow = false;
				else {
					enterByRow = true;
					enterByCol = false;
					enterByCube = false;
				}
				cbEnterByCol.setSelected(false);
				cbEnterByCube.setSelected(false);
			}
		});
		cbEnterByRow.setFocusable(false);
		cbEnterByRow.setSelected(true);
		cbEnterByRow.setBounds(478, 34, 156, 23);
		frmSudokuSolverSwag.getContentPane().add(cbEnterByRow);

		cbEnterByCol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (enterByCol)
					enterByCol = false;
				else {
					enterByRow = false;
					enterByCol = true;
					enterByCube = false;
				}
				cbEnterByRow.setSelected(false);
				cbEnterByCube.setSelected(false);
			}
		});
		cbEnterByCol.setFocusable(false);
		cbEnterByCol.setBounds(478, 58, 156, 23);
		frmSudokuSolverSwag.getContentPane().add(cbEnterByCol);

		cbEnterByCube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (enterByCube)
					enterByCube = false;
				else {
					enterByRow = false;
					enterByCol = false;
					enterByCube = true;
				}
				cbEnterByCol.setSelected(false);
				cbEnterByRow.setSelected(false);
			}
		});
		cbEnterByCube.setFocusable(false);
		cbEnterByCube.setBounds(478, 82, 156, 23);
		frmSudokuSolverSwag.getContentPane().add(cbEnterByCube);

		JCheckBox cbSolve = new JCheckBox("Just solve it already!");
		JCheckBox cbTakeSteps = new JCheckBox("Show me the steps!");
		cbSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSteps = false;
				cbTakeSteps.setSelected(false);
				bSolve.setEnabled(true);
				bTakeStep.setEnabled(false);
				bPreviousStep.setEnabled(false);
				bNextStep.setEnabled(false);
			}
		});
		cbSolve.setFocusable(false);
		cbSolve.setBounds(478, 198, 156, 23);
		frmSudokuSolverSwag.getContentPane().add(cbSolve);

		cbTakeSteps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSteps = true;
				cbSolve.setSelected(false);
				bSolve.setEnabled(false);
				bTakeStep.setEnabled(true);
				bPreviousStep.setEnabled(true);
				bNextStep.setEnabled(true);
			}
		});
		cbTakeSteps.setSelected(true);
		cbTakeSteps.setFocusable(false);
		cbTakeSteps.setBounds(478, 247, 156, 23);
		frmSudokuSolverSwag.getContentPane().add(cbTakeSteps);

		bTakeStep.setBounds(488, 277, 136, 23);
		bTakeStep.setFocusable(false);
		frmSudokuSolverSwag.getContentPane().add(bTakeStep);

		bPreviousStep.setBounds(488, 304, 65, 23);
		bPreviousStep.setFocusable(false);
		frmSudokuSolverSwag.getContentPane().add(bPreviousStep);

		bNextStep.setBounds(559, 304, 65, 23);
		bNextStep.setFocusable(false);
		frmSudokuSolverSwag.getContentPane().add(bNextStep);
		
		bClearBoard = new JButton("Clear Board");
		bClearBoard.setBounds(488, 134, 132, 20);
		bClearBoard.setFocusable(false);
		frmSudokuSolverSwag.getContentPane().add(bClearBoard);
		
		bSolve = new JButton("Solve");
		bSolve.setBounds(488, 224, 136, 20);
		bSolve.setEnabled(false);
		bSolve.setFocusable(false);
		frmSudokuSolverSwag.getContentPane().add(bSolve);

		console = new JTextArea();
		console.setEditable(false);
		console.setBounds(482, 367, 152, 118);
		frmSudokuSolverSwag.getContentPane().add(console);

		String txtText = "Paste row by row here";
		txtPasteRowBy = new JTextField();
		txtPasteRowBy.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtPasteRowBy.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPasteRowBy.getText().equals(""))txtPasteRowBy.setText(txtText);
			}
		});
		txtPasteRowBy.setText(txtText);
		txtPasteRowBy.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtPasteRowBy.setBounds(482, 110, 152, 16);
		frmSudokuSolverSwag.getContentPane().add(txtPasteRowBy);
		txtPasteRowBy.setColumns(10);
	}

	private void nextFocus(String token){
		char letter = token.charAt(0);
		char number = token.charAt(1);
		//System.out.println(token+"   "+letter+"   "+number);

		if(enterByRow){
			switch(letter){
			case 'A':
				switch(number){
				case '1':A2.requestFocus(true);break;
				case '2':A3.requestFocus(true);break;
				case '3':A4.requestFocus(true);break;
				case '4':A5.requestFocus(true);break;
				case '5':A6.requestFocus(true);break;
				case '6':A7.requestFocus(true);break;
				case '7':A8.requestFocus(true);break;
				case '8':A9.requestFocus(true);break;
				case '9':B1.requestFocus(true);break;
				}
				break;
			case 'B':
				switch(number){
				case '1':B2.requestFocus(true);break;
				case '2':B3.requestFocus(true);break;
				case '3':B4.requestFocus(true);break;
				case '4':B5.requestFocus(true);break;
				case '5':B6.requestFocus(true);break;
				case '6':B7.requestFocus(true);break;
				case '7':B8.requestFocus(true);break;
				case '8':B9.requestFocus(true);break;
				case '9':C1.requestFocus(true);break;
				}
				break;
			case 'C':
				switch(number){
				case '1':C2.requestFocus(true);break;
				case '2':C3.requestFocus(true);break;
				case '3':C4.requestFocus(true);break;
				case '4':C5.requestFocus(true);break;
				case '5':C6.requestFocus(true);break;
				case '6':C7.requestFocus(true);break;
				case '7':C8.requestFocus(true);break;
				case '8':C9.requestFocus(true);break;
				case '9':D1.requestFocus(true);break;
				}
				break;
			case 'D':
				switch(number){
				case '1':D2.requestFocus(true);break;
				case '2':D3.requestFocus(true);break;
				case '3':D4.requestFocus(true);break;
				case '4':D5.requestFocus(true);break;
				case '5':D6.requestFocus(true);break;
				case '6':D7.requestFocus(true);break;
				case '7':D8.requestFocus(true);break;
				case '8':D9.requestFocus(true);break;
				case '9':E1.requestFocus(true);break;
				}
				break;
			case 'E':
				switch(number){
				case '1':E2.requestFocus(true);break;
				case '2':E3.requestFocus(true);break;
				case '3':E4.requestFocus(true);break;
				case '4':E5.requestFocus(true);break;
				case '5':E6.requestFocus(true);break;
				case '6':E7.requestFocus(true);break;
				case '7':E8.requestFocus(true);break;
				case '8':E9.requestFocus(true);break;
				case '9':F1.requestFocus(true);break;
				}
				break;
			case 'F':
				switch(number){
				case '1':F2.requestFocus(true);break;
				case '2':F3.requestFocus(true);break;
				case '3':F4.requestFocus(true);break;
				case '4':F5.requestFocus(true);break;
				case '5':F6.requestFocus(true);break;
				case '6':F7.requestFocus(true);break;
				case '7':F8.requestFocus(true);break;
				case '8':F9.requestFocus(true);break;
				case '9':G1.requestFocus(true);break;
				}
				break;
			case 'G':
				switch(number){
				case '1':G2.requestFocus(true);break;
				case '2':G3.requestFocus(true);break;
				case '3':G4.requestFocus(true);break;
				case '4':G5.requestFocus(true);break;
				case '5':G6.requestFocus(true);break;
				case '6':G7.requestFocus(true);break;
				case '7':G8.requestFocus(true);break;
				case '8':G9.requestFocus(true);break;
				case '9':H1.requestFocus(true);break;
				}
				break;
			case 'H':
				switch(number){
				case '1':H2.requestFocus(true);break;
				case '2':H3.requestFocus(true);break;
				case '3':H4.requestFocus(true);break;
				case '4':H5.requestFocus(true);break;
				case '5':H6.requestFocus(true);break;
				case '6':H7.requestFocus(true);break;
				case '7':H8.requestFocus(true);break;
				case '8':H9.requestFocus(true);break;
				case '9':I1.requestFocus(true);break;
				}
				break;
			case 'I':
				switch(number){
				case '1':I2.requestFocus(true);break;
				case '2':I3.requestFocus(true);break;
				case '3':I4.requestFocus(true);break;
				case '4':I5.requestFocus(true);break;
				case '5':I6.requestFocus(true);break;
				case '6':I7.requestFocus(true);break;
				case '7':I8.requestFocus(true);break;
				case '8':I9.requestFocus(true);break;
				case '9':A1.requestFocus(true);break;
				}
				break;
			}
		}
		else if(enterByCol){
			switch(number){
			case '1':
				switch(letter){
				case 'A':B1.requestFocus(true);break;
				case 'B':C1.requestFocus(true);break;
				case 'C':D1.requestFocus(true);break;
				case 'D':E1.requestFocus(true);break;
				case 'E':F1.requestFocus(true);break;
				case 'F':G1.requestFocus(true);break;
				case 'G':H1.requestFocus(true);break;
				case 'H':I1.requestFocus(true);break;
				case 'I':A2.requestFocus(true);break;
				}
				break;
			case '2':
				switch(letter){
				case 'A':B2.requestFocus(true);break;
				case 'B':C2.requestFocus(true);break;
				case 'C':D2.requestFocus(true);break;
				case 'D':E2.requestFocus(true);break;
				case 'E':F2.requestFocus(true);break;
				case 'F':G2.requestFocus(true);break;
				case 'G':H2.requestFocus(true);break;
				case 'H':I2.requestFocus(true);break;
				case 'I':A3.requestFocus(true);break;
				}
				break;
			case '3':
				switch(letter){
				case 'A':B3.requestFocus(true);break;
				case 'B':C3.requestFocus(true);break;
				case 'C':D3.requestFocus(true);break;
				case 'D':E3.requestFocus(true);break;
				case 'E':F3.requestFocus(true);break;
				case 'F':G3.requestFocus(true);break;
				case 'G':H3.requestFocus(true);break;
				case 'H':I3.requestFocus(true);break;
				case 'I':A4.requestFocus(true);break;
				}
				break;
			case '4':
				switch(letter){
				case 'A':B4.requestFocus(true);break;
				case 'B':C4.requestFocus(true);break;
				case 'C':D4.requestFocus(true);break;
				case 'D':E4.requestFocus(true);break;
				case 'E':F4.requestFocus(true);break;
				case 'F':G4.requestFocus(true);break;
				case 'G':H4.requestFocus(true);break;
				case 'H':I4.requestFocus(true);break;
				case 'I':A5.requestFocus(true);break;
				}
				break;
			case '5':
				switch(letter){
				case 'A':B5.requestFocus(true);break;
				case 'B':C5.requestFocus(true);break;
				case 'C':D5.requestFocus(true);break;
				case 'D':E5.requestFocus(true);break;
				case 'E':F5.requestFocus(true);break;
				case 'F':G5.requestFocus(true);break;
				case 'G':H5.requestFocus(true);break;
				case 'H':I5.requestFocus(true);break;
				case 'I':A6.requestFocus(true);break;
				}
				break;
			case '6':
				switch(letter){
				case 'A':B6.requestFocus(true);break;
				case 'B':C6.requestFocus(true);break;
				case 'C':D6.requestFocus(true);break;
				case 'D':E6.requestFocus(true);break;
				case 'E':F6.requestFocus(true);break;
				case 'F':G6.requestFocus(true);break;
				case 'G':H6.requestFocus(true);break;
				case 'H':I6.requestFocus(true);break;
				case 'I':A7.requestFocus(true);break;
				}
				break;
			case '7':
				switch(letter){
				case 'A':B7.requestFocus(true);break;
				case 'B':C7.requestFocus(true);break;
				case 'C':D7.requestFocus(true);break;
				case 'D':E7.requestFocus(true);break;
				case 'E':F7.requestFocus(true);break;
				case 'F':G7.requestFocus(true);break;
				case 'G':H7.requestFocus(true);break;
				case 'H':I7.requestFocus(true);break;
				case 'I':A8.requestFocus(true);break;
				}
				break;
			case '8':
				switch(letter){
				case 'A':B8.requestFocus(true);break;
				case 'B':C8.requestFocus(true);break;
				case 'C':D8.requestFocus(true);break;
				case 'D':E8.requestFocus(true);break;
				case 'E':F8.requestFocus(true);break;
				case 'F':G8.requestFocus(true);break;
				case 'G':H8.requestFocus(true);break;
				case 'H':I8.requestFocus(true);break;
				case 'I':A9.requestFocus(true);break;
				}
				break;
			case '9':
				switch(letter){
				case 'A':B9.requestFocus(true);break;
				case 'B':C9.requestFocus(true);break;
				case 'C':D9.requestFocus(true);break;
				case 'D':E9.requestFocus(true);break;
				case 'E':F9.requestFocus(true);break;
				case 'F':G9.requestFocus(true);break;
				case 'G':H9.requestFocus(true);break;
				case 'H':I9.requestFocus(true);break;
				case 'I':A1.requestFocus(true);break;
				}
				break;
			}
		}
		else if(enterByCube){
			switch(letter){
			case 'A':
				switch(number){
				case '1':A2.requestFocus(true);break;
				case '2':A3.requestFocus(true);break;
				case '3':B1.requestFocus(true);break;
				case '4':A5.requestFocus(true);break;
				case '5':A6.requestFocus(true);break;
				case '6':B4.requestFocus(true);break;
				case '7':A8.requestFocus(true);break;
				case '8':A9.requestFocus(true);break;
				case '9':B7.requestFocus(true);break;
				}
				break;
			case 'B':
				switch(number){
				case '1':B2.requestFocus(true);break;
				case '2':B3.requestFocus(true);break;
				case '3':C1.requestFocus(true);break;
				case '4':B5.requestFocus(true);break;
				case '5':B6.requestFocus(true);break;
				case '6':C4.requestFocus(true);break;
				case '7':B8.requestFocus(true);break;
				case '8':B9.requestFocus(true);break;
				case '9':C7.requestFocus(true);break;
				}
				break;
			case 'C':
				switch(number){
				case '1':C2.requestFocus(true);break;
				case '2':C3.requestFocus(true);break;
				case '3':A4.requestFocus(true);break;
				case '4':C5.requestFocus(true);break;
				case '5':C6.requestFocus(true);break;
				case '6':A7.requestFocus(true);break;
				case '7':C8.requestFocus(true);break;
				case '8':C9.requestFocus(true);break;
				case '9':D1.requestFocus(true);break;
				}
				break;
			case 'D':
				switch(number){
				case '1':D2.requestFocus(true);break;
				case '2':D3.requestFocus(true);break;
				case '3':E1.requestFocus(true);break;
				case '4':D5.requestFocus(true);break;
				case '5':D6.requestFocus(true);break;
				case '6':E4.requestFocus(true);break;
				case '7':D8.requestFocus(true);break;
				case '8':D9.requestFocus(true);break;
				case '9':E7.requestFocus(true);break;
				}
				break;
			case 'E':
				switch(number){
				case '1':E2.requestFocus(true);break;
				case '2':E3.requestFocus(true);break;
				case '3':F1.requestFocus(true);break;
				case '4':E5.requestFocus(true);break;
				case '5':E6.requestFocus(true);break;
				case '6':F4.requestFocus(true);break;
				case '7':E8.requestFocus(true);break;
				case '8':E9.requestFocus(true);break;
				case '9':F7.requestFocus(true);break;
				}
				break;
			case 'F':
				switch(number){
				case '1':F2.requestFocus(true);break;
				case '2':F3.requestFocus(true);break;
				case '3':D4.requestFocus(true);break;
				case '4':F5.requestFocus(true);break;
				case '5':F6.requestFocus(true);break;
				case '6':D7.requestFocus(true);break;
				case '7':F8.requestFocus(true);break;
				case '8':F9.requestFocus(true);break;
				case '9':G1.requestFocus(true);break;
				}
				break;
			case 'G':
				switch(number){
				case '1':G2.requestFocus(true);break;
				case '2':G3.requestFocus(true);break;
				case '3':H1.requestFocus(true);break;
				case '4':G5.requestFocus(true);break;
				case '5':G6.requestFocus(true);break;
				case '6':H4.requestFocus(true);break;
				case '7':G8.requestFocus(true);break;
				case '8':G9.requestFocus(true);break;
				case '9':H7.requestFocus(true);break;
				}
				break;
			case 'H':
				switch(number){
				case '1':H2.requestFocus(true);break;
				case '2':H3.requestFocus(true);break;
				case '3':I1.requestFocus(true);break;
				case '4':H5.requestFocus(true);break;
				case '5':H6.requestFocus(true);break;
				case '6':I4.requestFocus(true);break;
				case '7':H8.requestFocus(true);break;
				case '8':H9.requestFocus(true);break;
				case '9':I7.requestFocus(true);break;
				}
				break;
			case 'I':
				switch(number){
				case '1':I2.requestFocus(true);break;
				case '2':I3.requestFocus(true);break;
				case '3':G4.requestFocus(true);break;
				case '4':I5.requestFocus(true);break;
				case '5':I6.requestFocus(true);break;
				case '6':G7.requestFocus(true);break;
				case '7':I8.requestFocus(true);break;
				case '8':I9.requestFocus(true);break;
				case '9':A1.requestFocus(true);break;
				}
				break;
			}
		}
		else console.append("Enter a valid input method!\n");
	}
}
