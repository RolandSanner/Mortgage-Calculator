import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MortgageFrame extends JFrame{

    //Text Field for the total loan amount
    private JTextField loanAmtTF;
    //Text Field for the interest rate
    private JTextField interestRateTF;
    //Text Field for the loan term in years
    private JTextField termTF;


    //Button for computing the monthly payment
    private JButton computePaymentsJB;
    // Button for computing the total interest over the life of the loan
    private JButton computeTotalInterestJB;

    // The label and panel used for output
    private JLabel outputLabel; // displays output to the user
    private JPanel outputPanel;

    public MortgageFrame(){
        setTitle("Movement Mortgage, Mortgage Calculator");
        setSize(525,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Build GUI Here

//        -----------------------------------------------
//        panel that holds the components
        JPanel mainPanel = new JPanel();

        loanAmtTF = new JTextField(6);
        interestRateTF = new JTextField(6);
        termTF = new JTextField(6);
        // all 3 text fields should be the same size;

        // image icon
        ImageIcon icon = new ImageIcon("House.png");
        JLabel iconLabel = new JLabel("Mortgage Calculator", icon,SwingConstants.CENTER);
        // jalabel displays the icon and the text and the swing shows where the text is displayed

        iconLabel.setFont(new Font("SansSerif", Font.BOLD,30));
        mainPanel.add(iconLabel);

        // adding textFields to the panel
        mainPanel.add(new JLabel("Loan Amount: "));
        mainPanel.add(loanAmtTF);
        mainPanel.add(new JLabel("Interest Rate: "));
        mainPanel.add(interestRateTF);
        mainPanel.add(new JLabel("Term (Years): "));
        mainPanel.add(termTF);

        // now we add the 2 buttons

        computePaymentsJB = new JButton("Compute Monthly Payment");
        computeTotalInterestJB = new JButton("Compute Total Interest");

        mainPanel.add(computePaymentsJB);
        mainPanel.add(computeTotalInterestJB);

        // Add Label into panel on the south part of the layout

        outputPanel = new JPanel();
        outputLabel = new JLabel("Enter values above, and click a button");
        outputPanel.add(outputLabel);
        outputPanel.setBackground(Color.YELLOW);

        add(mainPanel,BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);


        setVisible(true);
    }

    // Listener for the "Compute monthly payment" button
    private class PaymentButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
        }
    }

    // Listener for the "Compute total interest" Button
    private class interestButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        }
    }

    /* Method for monthly loan payment:
    @param amount the loan amount
    @param rate the annual interest rate
    @param years the length of the loan in years
    @return the monthly payment required to pay off the loan in the given time
     */

    private double computeMonthlyPayment(double amount, double rate, int years){
        double monthlyRate = rate / 12.0;
        double months = years * 12;
        double payment;

        payment = amount * (monthlyRate * Math.pow(1 + monthlyRate, months))/(Math.pow(1+monthlyRate,months)-1);
                return payment;
    }

}
