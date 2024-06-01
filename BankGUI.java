//package hii_hii;
/*
 * Write a description of class card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.Color;
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class BankGUI
{


    private ArrayList<Bankcard>bankcard;

    private JFrame frame;
    private JFrame frame1;
    private JFrame frame2;
    private JFrame withdrawframe;
    
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel withdrawpanel;
    
    private JLabel label;
    private JTextField CardIDField;
    private JTextField debitCardIDField;
    private JTextField creditCardIDField;
    private JTextField withdrawCardIDField;
    
    private JTextField ClientNameField;
    private JTextField IssuerBankField;
    private JTextField BankAccountField;
    private JTextField BalanceAmountField;
    private JTextField debitBalanceAmountField;
    private JTextField totalBalanceAmountField;
    
    private JTextField PINNumberField;
    private JTextField debitPINNumberField;
    
    private JTextField WithdrawalAmountField;
    private JTextField CVCNumberField;
    private JTextField bankCVCNumberField;
    
    private JTextField CreditLimitField;
    private JTextField InterestRateField;
     
    private JTextField bankInterestRateField;
    
    private JTextField GracePeriodField;
    
    
    private JComboBox<String> year;
    private JComboBox<String> month;
    private JComboBox<String> day;
    

    
    private JButton addDebitCard;
    private JButton addCreditCard;
    private JButton withdraw;
    private JButton finalwithdraw;
    private JButton display;
    private JButton back;
    private JButton setcredit;
    private JButton creditdisplay;
    private JButton cancelcredit;
    private JButton creditback;
    private JButton debitback;
    private JButton bankdisplay;
    private JButton bankclear;
    private JButton debitclear;
    private JButton creditclear;
  
  
    final static int INVALID=-1;
    

  



                public BankGUI()
                {



                    //years
                    String years[]={"2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","Year"};

                    //months
                    String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec","Month"};

                    //days
                    String days[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","Day"};



                    bankcard = new ArrayList<Bankcard> ();


        // frame creation
        frame = new JFrame("BANKGUI");                           //creating a frame
        frame.setSize(800,550);                                 //setting the size of frame       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //exit from frame
        frame.setLocationRelativeTo(null);                      //frame location is null
        frame.setResizable(false);                               //resize the frame 
        frame.setLayout(null);                                   // setlayout is null
        frame.setFont(new Font("Arial",Font.BOLD,50));          //set the font of frame

       
        //set the background color in frame
        Container c = frame.getContentPane();
        c.setBackground(Color.red);


        //set the title of frame
        label=new JLabel("Welcome To Bank");
        label.setSize(100,50);
        label.setBounds(200,0,400,40);
        label.setFont(new Font("Arial",Font.BOLD,40));
        frame.add(label);


        //creation of JPanel for bank card
        panel=new JPanel();
        panel.setSize(700,400);
        panel.setLocation(40,50);
        panel.setBackground(Color.pink);
        panel.setLayout(null);
       
        TitledBorder titledBorder = BorderFactory.createTitledBorder("BANK CARD");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(titledBorder);

        
        panel.setFont(new Font("Arial",Font.BOLD,50));
        frame.add(panel);
        
         
        //creation of JLabel
        label = new JLabel("Card ID");
        label.setSize(100,30);
        label.setBounds(20,40,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(label);



        //creation of textfield
        CardIDField = new JTextField();
        CardIDField.setBounds(150,40,200,30);
        panel.add(CardIDField);
        

        
        //creation of JLabel1
        label = new JLabel("Client Name");
        label.setSize(100,30);
        label.setBounds(20,90,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(label);


        //creation of textfield1
        ClientNameField = new JTextField();
        ClientNameField.setBounds(150,90,200,30);
        panel.add(ClientNameField);



        //creation of JLabel2
        label = new JLabel("Issuer Bank");
        label.setSize(100,30);
        label.setBounds(20,140,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(label);



         //creation of textfield2
         IssuerBankField = new JTextField();
         IssuerBankField.setBounds(150,140,200,30);
         panel.add(IssuerBankField);


         
         //creation of JLabel8
         label = new JLabel("CVC Number");
         label.setSize(100,30);
         label.setBounds(370,90,200,30);
         label.setFont(new Font("Arial",Font.BOLD,15));
         panel.add(label);

 
         //creation of textfield8
         bankCVCNumberField = new JTextField();
         bankCVCNumberField.setBounds(470,90,200,30);
         panel.add(bankCVCNumberField);
         
         //creation of JLabel10
         label = new JLabel("Interest Rate");
         label.setSize(100,30);
         label.setBounds(370,140,200,30);
         label.setFont(new Font("Arial",Font.BOLD,15));
         panel.add(label);
 
 
         //creation of textfield10
         bankInterestRateField = new JTextField();
         bankInterestRateField.setBounds(470,140,200,30);
         panel.add(bankInterestRateField);
         
         
            //creation of label12 for expiration date
        label = new JLabel("Expiration Date");
        label.setSize(100,30);
        label.setBounds(370,190,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(label);




        //creation of jcombobox for expiration date
         year=new JComboBox <String>(years);
         year.setBounds(485,190,60,30);
          year.addItem("Year");
         panel.add(year);


         month=new JComboBox <String>(months);
         month.setBounds(555,190,65,30);  
         month.addItem("Month");
         panel.add(month);


         day=new JComboBox <String>(days);
         day.setBounds(630,190,50,30);
         day.addItem("Day");
         panel.add(day);
         
         

         //creation of JLabel3
        label = new JLabel("Bank Account");
        label.setSize(100,30);
        label.setBounds(20,190,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(label);



        //creation of textfield3
        BankAccountField = new JTextField();
        BankAccountField.setBounds(150,190,200,30);
        panel.add(BankAccountField);


        //creation of JLabel4
        label = new JLabel("Balance Amount");
        label.setSize(100,30);
        label.setBounds(20,240,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(label);


        

        //creation of textfield4
        BalanceAmountField = new JTextField();
        BalanceAmountField.setBounds(150,240,200,30);
        panel.add(BalanceAmountField);




        // frame1 creation
        frame1 = new JFrame("BANKGUI");                           //creating a frame
        frame1.setSize(800,550);                                 //setting the size of frame       
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //exit from frame
        frame1.setLocationRelativeTo(null);                      //frame location is null
        frame1.setResizable(true);                               //resize the frame 
        frame1.setLayout(null);                                   // setlayout is null
        frame1.setFont(new Font("Arial",Font.BOLD,50));          //set the font of frame


        //creation of JPanel1 for debit card
        panel1=new JPanel();
        panel1.setSize(700,400);
        panel1.setLocation(40,50);
        panel1.setBackground(Color.pink);
        panel1.setLayout(null);
       
   
        TitledBorder debittitledBorder = BorderFactory.createTitledBorder("DEBIT CARD");
        debittitledBorder.setTitleJustification(TitledBorder.CENTER);
        panel1.setBorder(debittitledBorder);



        panel1.setFont(new Font("Arial",Font.BOLD,50));
        frame1.add(panel1);

        //set the background color in frame
        Container d = frame1.getContentPane();
        d.setBackground(Color.red);

 

        //creation of JLabel5
        label = new JLabel("Pin Number");
        label.setSize(100,30);
        label.setBounds(370,40,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(label);
        
        
        //creation of JLabel for debitcard
        label = new JLabel("Pin Number");
        label.setSize(100,30);
        label.setBounds(20,40,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel1.add(label);



        //creation of textfield5
        PINNumberField = new JTextField();
        PINNumberField.setBounds(470,40,200,30);
        panel.add(PINNumberField);
        
        
         //creation of JLabel4
        label = new JLabel("Balance Amount");
        label.setSize(100,30);
        label.setBounds(375,40,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel1.add(label);
         



        //creation of textfield4
        debitBalanceAmountField = new JTextField();
        debitBalanceAmountField.setBounds(500,40,200,30);
        panel1.add(debitBalanceAmountField);

        
        
         //creation of textfield for debit card
         debitPINNumberField = new JTextField();
        debitPINNumberField.setBounds(170,40,200,30);
        panel1.add(debitPINNumberField);



        //creation of JLabel for debit card
        label = new JLabel("Card ID");
        label.setSize(100,30);
        label.setBounds(20,90,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel1.add(label);
        
        
         
        //creation of textfield for debitcard
        debitCardIDField = new JTextField();
        debitCardIDField.setBounds(170,90,200,30);
        panel1.add(debitCardIDField);
        


        //creation of JLabel6
        label = new JLabel("Withdrawal Amount");
        label.setSize(100,30);
        label.setBounds(20,140,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel1.add(label);


        //creation of textfield6
        WithdrawalAmountField = new JTextField();
        WithdrawalAmountField.setBounds(170,140,200,30);
        panel1.add(WithdrawalAmountField);


        //creation of JLabel for total balance amount
        label = new JLabel("Remaining Amount");
        label.setSize(100,30);
        label.setBounds(20,240,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel1.add(label);



        //creation of textfield4
        totalBalanceAmountField = new JTextField();
        totalBalanceAmountField.setBounds(170,240,200,30);
        panel1.add(totalBalanceAmountField);



        //creation of label7 for withdrawal date
        label = new JLabel("Withdrawal Date");
        label.setSize(100,30);
        label.setBounds(20,190,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel1.add(label);




        //creation of jcombobox for withdrawal date
         year=new JComboBox <String>(years);
         year.setBounds(170,190,100,30);
         panel1.add(year);


         month=new JComboBox <String>(months);
         month.setBounds(280,190,100,30);
         panel1.add(month);


         day=new JComboBox <String>(days);
         day.setBounds(390,190,100,30);
         panel1.add(day);

         

   
          // frame creation
        frame2 = new JFrame("BANKGUI");                           //creating a frame
        frame2.setSize(800,550);                                 //setting the size of frame       
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //exit from frame
        frame2.setLocationRelativeTo(null);                      //frame location is null
        frame2.setResizable(true);                               //resize the frame 
        frame2.setLayout(null);                                   // setlayout is null
        frame2.setFont(new Font("Arial",Font.BOLD,50));          //set the font of frame

       
        //set the background color in frame
        Container e = frame2.getContentPane();
        e.setBackground(Color.red);



         //creation of JPanel2 for credit card
        panel2=new JPanel();
        panel2.setSize(700,400);
        panel2.setLocation(40,50);
        panel2.setBackground(Color.pink);
        panel2.setLayout(null);
        panel2.setBorder(BorderFactory.createTitledBorder("CREDIT CARD"));
        panel2.setFont(new Font("Arial",Font.BOLD,50));
        frame2.add(panel2);


         TitledBorder credittitledBorder = BorderFactory.createTitledBorder("CREDIT CARD");
        credittitledBorder.setTitleJustification(TitledBorder.CENTER);
        panel2.setBorder(credittitledBorder);

        


         //creation of JLabel8
         label = new JLabel("CVC Number");
         label.setSize(100,30);
         label.setBounds(20,40,200,30);
         label.setFont(new Font("Arial",Font.BOLD,15));
         panel2.add(label);

 
         //creation of textfield8
         CVCNumberField = new JTextField();
         CVCNumberField.setBounds(150,40,200,30);
         panel2.add(CVCNumberField);

        
         //creation of JLabel9
         label = new JLabel("Credit Limit");
         label.setSize(100,30);
         label.setBounds(20,90,200,30);
         label.setFont(new Font("Arial",Font.BOLD,15));
         panel2.add(label);
 
 
         //creation of textfield9
         CreditLimitField = new JTextField();
         CreditLimitField.setBounds(150,90,200,30);
         panel2.add(CreditLimitField);



         //creation of JLabel10
         label = new JLabel("Interest Rate");
         label.setSize(100,30);
         label.setBounds(20,140,200,30);
         label.setFont(new Font("Arial",Font.BOLD,15));
         panel2.add(label);
 
 
         //creation of textfield10
         InterestRateField = new JTextField();
         InterestRateField.setBounds(150,140,200,30);
         panel2.add(InterestRateField);



          //creation of JLabel11
          label = new JLabel("Grace Period");
          label.setSize(100,30);
          label.setBounds(20,190,200,30);
          label.setFont(new Font("Arial",Font.BOLD,15));
          panel2.add(label);
  
  
          //creation of textfield11
          GracePeriodField = new JTextField();
          GracePeriodField.setBounds(150,190,200,30);
          panel2.add(GracePeriodField);
 

            //creation of JLabel for credit card
        label = new JLabel("Card ID");
        label.setSize(100,30);
        label.setBounds(400,40,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel2.add(label);
        
        
         
        //creation of textfield for creditcard
        creditCardIDField = new JTextField();
        creditCardIDField.setBounds(470,40,200,30);
        panel2.add(creditCardIDField);



          //creation of label12 for expiration date
        label = new JLabel("Expiration Date");
        label.setSize(100,30);
        label.setBounds(20,240,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        panel2.add(label);




        //creation of jcombobox for expiration date
         year=new JComboBox <String>(years);
         year.setBounds(150,240,100,30);
         panel2.add(year);


         month=new JComboBox <String>(months);
         month.setBounds(260,240,100,30);  
         panel2.add(month);


         day=new JComboBox <String>(days);
         day.setBounds(370,240,100,30);
         panel2.add(day);
         
         
         
         //creation of withdraw frame
        withdrawframe = new JFrame("BANKGUI");                           //creating a frame
        withdrawframe.setSize(500,300);                                 //setting the size of frame       
        withdrawframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //exit from frame
        withdrawframe.setLocationRelativeTo(null);                      //frame location is null
        withdrawframe.setResizable(false);                               //resize the frame 
        withdrawframe.setLayout(null);                                   // setlayout is null
        withdrawframe.setFont(new Font("Arial",Font.BOLD,50));          //set the font of frame

        
         
        //set the background color in frame
        Container f = withdrawframe.getContentPane();
        f.setBackground(Color.red);

                //creation of JPanel for bank card
        withdrawpanel=new JPanel();
        withdrawpanel.setSize(400,200);
        withdrawpanel.setLocation(40,30);
        withdrawpanel.setBackground(Color.pink);
        withdrawpanel.setLayout(null);
       
        
        
        TitledBorder withdrawtitledBorder = BorderFactory.createTitledBorder("WITHDRAW");
        withdrawtitledBorder.setTitleJustification(TitledBorder.CENTER);
        withdrawpanel.setBorder(withdrawtitledBorder);

        panel.setFont(new Font("Arial",Font.BOLD,50));
        withdrawframe.add(withdrawpanel);
        
        
         //creation of JLabel
        label = new JLabel("Card ID");
        label.setSize(100,30);
        label.setBounds(20,50,200,30);
        label.setFont(new Font("Arial",Font.BOLD,15));
        withdrawpanel.add(label);



        //creation of textfield
        withdrawCardIDField = new JTextField();
        withdrawCardIDField.setBounds(150,50,200,30);
        withdrawpanel.add(withdrawCardIDField);


        
                //back button button in debitcard
                    back=new JButton("BACK");
                    back.setBounds(40,150,120,30);
                    withdrawpanel.add(back);
                    
                    
                    
                    // Add an event listener to the button that listens for when the button is pressed
                     back.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent d){
                                            
                            
                            // Switch back to Bank Card frame
                            withdrawframe.setVisible(false);
                            frame1.setVisible(true);
                            
                                                       



                        }
                     });
    

        
                     
                     //back button button in creditcard
                    creditback=new JButton("BACK");
                    creditback.setBounds(450,300,120,30);
                    panel2.add(creditback);
                    
                     
                     
                     // Add an event listener to the button that listens for when the button is pressed
                     creditback.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent d){
                                            
                            
                            // Switch back to Bank Card frame
                            frame2.setVisible(false);
                            frame.setVisible(true);
                            
                                                       



                        }
                     });
    
                     
                     
                       //back button button in creditcard
                    debitback=new JButton("BACK");
                    debitback.setBounds(400,290,120,30);
                    panel1.add(debitback);
                    
                     
                    

                     // Add an event listener to the button that listens for when the button is pressed
                     debitback.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent d){
                                            
                            
                            // Switch back to Bank Card frame
                            frame1.setVisible(false);
                            frame.setVisible(true);
                            
                                                       



                        }
                     });
                     
                     
                     

        
        
                    //withdraw button in debitcard
                    withdraw=new JButton("WITHDRAW");
                    withdraw.setBounds(220,290,150,30);
                    panel1.add(withdraw);


                    

                        // Add an event listener to the button that listens for when the button is pressed
                     withdraw.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent d){
                                            
                             withdraw();
    
                             
                             


                        }
                     });
    
        
        
                     
                    //withdraw button in withdraw frame
                    finalwithdraw=new JButton("PROCEED");
                    finalwithdraw.setBounds(100,100,120,30);
                    withdrawpanel.add(finalwithdraw);
        
                    
                    // Add an event listener to the button that listens for when the button is pressed
                     finalwithdraw.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent d){
                                            
                             finalwithdraw();
                             
                             
                        
                                                       



                            }   
                     });
        
        
        
                      //create gui button for labeled add credit card
                        bankdisplay=new JButton("DISPLAY");
                        bankdisplay.setBounds(380,290,150,30);
                        panel.add(bankdisplay);
                
                
                          // Add an event listener to the button that listens for when the button is pressed
                             bankdisplay.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent d){
                                            
                                        bankdisplay(); 
                             
                             
                        
                                                       



                                        }
                             });

        
                     
                     
                      //create gui button for labeled add credit card
                          bankclear=new JButton("CLEAR");
                          bankclear.setBounds(230,340,150,30);
                          panel.add(bankclear);
                
                
                         // Add an event listener to the button that listens for when the button is pressed
                        bankclear.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent d){
                                            
                            CardIDField.setText("");
                            ClientNameField.setText("");
                            IssuerBankField.setText("");
                            BankAccountField.setText("");
                            BalanceAmountField.setText("");
                            PINNumberField.setText("");
                            bankCVCNumberField.setText("");
                            bankInterestRateField.setText("");
                            year.setSelectedIndex(0);
                            month.setSelectedIndex(0);
                            day.setSelectedIndex(0);
                             

                        }
                    });

                     
                           
                      //create gui button for labeled add credit card
                        debitclear=new JButton("CLEAR");
                        debitclear.setBounds(230,340,150,30);
                        panel1.add(debitclear);
                
                
                 // Add an event listener to the button that listens for when the button is pressed
                     debitclear.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent d){
                                
                            debitPINNumberField.setText("");
                            debitCardIDField.setText("");
                            WithdrawalAmountField.setText("");
                            totalBalanceAmountField.setText("");
                            debitBalanceAmountField.setText("");
                            year.setSelectedIndex(0);
                            month.setSelectedIndex(0);
                            day.setSelectedIndex(0);
                           

                         }
                     });
                     
                
                     
                           
                      //create gui button for labeled add credit card
                creditclear=new JButton("CLEAR");
                creditclear.setBounds(230,340,150,30);
                panel2.add(creditclear);
                
                
                 // Add an event listener to the button that listens for when the button is pressed
                     creditclear.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent d){
                                
                            CreditLimitField.setText("");
                            GracePeriodField.setText("");
                            creditCardIDField.setText("");
                            CVCNumberField.setText("");
                            InterestRateField.setText("");
                            year.setSelectedIndex(0);
                            month.setSelectedIndex(0);
                            day.setSelectedIndex(0);
                            

                        }
                     });
                     
                     
                     
                     


                         //create gui button for labeled add debit card
                         addDebitCard=new JButton("ADD DEBIT CARD");
                         addDebitCard.setBounds(30,290,150,30);
                         panel.add(addDebitCard);







                            // Add an event listener to the button that listens for when the button is pressed
                        addDebitCard.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

            
                            adddebitcard();
            
            



                        }
                    });
    

                 // Add an event listener to the button that listens for when the button is pressed
                addDebitCard.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

            
                        debitBalanceAmountField.setText(BalanceAmountField.getText());
                        debitBalanceAmountField.setEditable(false);
            
                        totalBalanceAmountField.setEditable(false);
            

                      }
                });
    

                         //display button in debitcard
                        display=new JButton("DISPLAY");
                        display.setBounds(50,290,150,30);
                        panel1.add(display);
                    
                   
                        // Add an event listener to the button that listens for when the button is pressed
                        display.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
            
         
                                        display();      
            
            
            
            



                                }
                            });




                        //create gui button for labeled add credit card
                        addCreditCard=new JButton("ADD CREDIT CARD");
                        addCreditCard.setBounds(200,290,150,30);
                        panel.add(addCreditCard);

                

                        // Add an event listener to the button that listens for when the button is pressed
                            addCreditCard.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent c){

                
                                        addcreditcard();
                
        
                                        CVCNumberField.setText(bankCVCNumberField.getText());
                                        CVCNumberField.setEditable(false);
            
                                        InterestRateField.setText(bankInterestRateField.getText());
                                        InterestRateField.setEditable(false);
            
                
                                        year.setSelectedIndex(year.getSelectedIndex());
                                        year.setEditable(false);
                                        month.setSelectedIndex(month.getSelectedIndex());
                                        month.setEditable(false);
                                        day.setSelectedIndex(day.getSelectedIndex());
                                        day.setEditable(false);




                                }
                        });


                

        
                                //create gui button for labeled add set credit
                                 setcredit=new JButton("SET CREDIT");
                                 setcredit.setBounds(30,300,120,30);
                                 panel2.add(setcredit);
        
        
        
                                 setcredit.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent c){
                                    
                                         setcreditlimit();
        

                                    }
                                });
                

 
                            //create gui button for labeled add credit display
                                 creditdisplay=new JButton("DISPLAY");
                                 creditdisplay.setBounds(170,300,100,30);
                                 panel2.add(creditdisplay);
        
        
                                 creditdisplay.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
            
         
                                         creditdisplay();


                                    }
                            });



    
                                 //create gui button for labeled add cancel credit
                                     cancelcredit=new JButton("CANCEL CREDIT");
                                     cancelcredit.setBounds(290,300,150,30);
                                     panel2.add(cancelcredit);
        

    
                             cancelcredit.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
            
                                cancelcredit();
                

                            }
                        });





                              frame.setVisible(true);
                            // frame1.setVisible(true);
                            // frame2.setVisible(true);
                             // withdrawframe.setVisible(true);
         




    }


                public int getCardID()
            {
        
                int Cardid=INVALID;
    
            try{
                // convert string value into integers
                Cardid= Integer.parseInt(CardIDField.getText().trim());   //trim method is used to cut space when string is take also space in quotation

                if(Cardid<=0)
                  {
                        Cardid=INVALID;
                  }
              }
            catch(Exception d){
                    System.out.println("your cardid is invalid");
            }
            return Cardid;
    
    
         }

                public int getDebitCardID()
            {
        
                    int debitCardid=INVALID;
    
                try{
                    // convert string value into integers
                    debitCardid= Integer.parseInt(debitCardIDField.getText().trim());   //trim method is used to cut space when string is take also space in quotation

                    if(debitCardid<=0)
                {
                        debitCardid=INVALID;
                }
            }
                catch(Exception d){
                            System.out.println("your cardid is invalid");
                }
            return debitCardid;
    
    
        }

            public int getCreditCardID()
        {
        
            int creditCardid=INVALID;
    
            try{
            // convert string value into integers
            creditCardid= Integer.parseInt(creditCardIDField.getText().trim());   //trim method is used to cut space when string is take also space in quotation

                if(creditCardid<=0)
            {
                creditCardid=INVALID;
            }
            
            }
            catch(Exception d){
                System.out.println("your cardid is invalid");
            }
            return creditCardid;
    
    
        }   

            public int getWithdrawCardID()
        {
        
                int withdrawCardid=INVALID;
    
                try{
                // convert string value into integers
                withdrawCardid= Integer.parseInt(withdrawCardIDField.getText().trim());   //trim method is used to cut space when string is take also space in quotation

                if(withdrawCardid<=0)
                {
                    withdrawCardid=INVALID;
                }
            }
            catch(Exception d)
            {
                System.out.println("your cardid is invalid");
            }
            return withdrawCardid;
    
    
        }

            public int getBalanceAmount()
        {
    
            int Balanceamount=INVALID;

            try{
            Balanceamount=Integer.parseInt(BalanceAmountField.getText().trim());   //trim method is used to cut space when string is take also space in quotation
        
            if(Balanceamount<0)
            {
                Balanceamount=INVALID;
            }
            }
            catch(Exception f)
            {
            System.out.println("your balance amount is invalid");
            }
            return Balanceamount;
       
        }

            public String getBankAccount()
        {
                return BankAccountField.getText().trim();   //trim method is used to cut space when string is take also space in quotation

        }       


 
            public String getIssuerBank()
        {
                return IssuerBankField.getText().trim();   //trim method is used to cut space when string is take also space in quotation

        }

            public String getClientName()
        {
                return ClientNameField.getText().trim();   //trim method is used to cut space when string is take also space in quotation

        }




            public int getPinNumber()
        {
    
                int Pinnumber=INVALID;
            try{
                Pinnumber=Integer.parseInt(PINNumberField.getText().trim());   //trim method is used to cut space when string is take also space in quotation
        
                if(Pinnumber<=0)
            {
                Pinnumber=INVALID;
            }
            }
            catch(Exception g)
            {
                System.out.println("your pin number is invalid");
            }
            return Pinnumber;
        }  

            public int getDebitPinNumber()
        {
    
                int debitPinnumber=INVALID;
            try{
                    debitPinnumber=Integer.parseInt(debitPINNumberField.getText().trim());   //trim method is used to cut space when string is take also space in quotation
        
                if(debitPinnumber<=0)
                {
                    debitPinnumber=INVALID;
                }
            }
            catch(Exception g)
            {
                System.out.println("your pin number is invalid");
            }
            return debitPinnumber;
        }          


            public int getWithdrawalAmount()
        {
    
                int Withdrawalamount = INVALID;
            try{
                Withdrawalamount=Integer.parseInt(WithdrawalAmountField.getText().trim());
        
                    if(Withdrawalamount<=0)
                {
                    Withdrawalamount =INVALID;
                }
            }
            catch(Exception h)
            {
                JOptionPane.showMessageDialog(frame1,"withdrawal amount should be greater than 0","withdrawal details",JOptionPane.INFORMATION_MESSAGE);
            }
            return Withdrawalamount;
        }

            public int getCVCNumber()
        {
    
                int cvcnumber = INVALID;
            try{
                cvcnumber=Integer.parseInt(bankCVCNumberField.getText().trim());
        
                if(cvcnumber<=0)
                {
                    cvcnumber =INVALID;
                }
            }
            catch(Exception h)
            {
                JOptionPane.showMessageDialog(frame1,"cvc number should be greater than 0","cvc details",JOptionPane.INFORMATION_MESSAGE);
            }
            return cvcnumber;
        }

            public double getInterestRate()
        {
    
            double interestrate = INVALID;
            try{
                interestrate=Double.parseDouble(bankInterestRateField.getText().trim());
        
                if(interestrate<=0)
                {
                    interestrate =INVALID;
                }
            }
            catch(Exception h)
            {
                JOptionPane.showMessageDialog(frame1,"interest rate should be greater than 0","interest details",JOptionPane.INFORMATION_MESSAGE);
            }
            return interestrate;
        }


            public double getCreditLimit()
        {
    
                double creditlimit = INVALID;
            try{
                creditlimit=Double.parseDouble(CreditLimitField.getText().trim());
        
                if(creditlimit<=0)
                {
                    creditlimit =INVALID;
                }
            }
            catch(Exception h)
            {
                JOptionPane.showMessageDialog(frame1,"credit limit should be greater than 0","interest details",JOptionPane.INFORMATION_MESSAGE);
            }
            return creditlimit;
        }

            public int getGracePeriod()
        {
    
                int graceperiod = INVALID;
            try{
                graceperiod=Integer.parseInt(GracePeriodField.getText().trim());
        
                if(graceperiod<=0)
                {
                    graceperiod =INVALID;
                }
            }
            catch(Exception h)
            {
                JOptionPane.showMessageDialog(frame1,"grace period should be greater than 0","cvc details",JOptionPane.INFORMATION_MESSAGE);
            }
            return graceperiod;
        }



            public String getDateOfWithdrawal()
        {
            String date=" ";
            String Year=year.getSelectedItem().toString();
            String Month=month.getSelectedItem().toString();
            String Day=day.getSelectedItem().toString();
            if(Year.equals("Year") || Month.equals("Month") || Day.equals("Day"))
            {
                date=null;
         
            }
            else{
                date=(Year+" "+Month+" "+Day);
            }
            return date;
        }

            public String getExpirationDate()
        {
            String date=" ";
            String Year=year.getSelectedItem().toString();
            String Month=month.getSelectedItem().toString();
            String Day=day.getSelectedItem().toString();
            if(Year.equals("Year") || Month.equals("Month") || Day.equals("Day"))
            {
                date=null;
         
            }
            else{
                date=(Year+" "+Month+" "+Day);
            }
            return date;
        }


        public String getYear(){
            return (String) year.getSelectedItem().toString();
        }

        public String getMonth(){
            return (String) month.getSelectedItem().toString();
        }

        public String getDay(){
            return (String) day.getSelectedItem().toString();
        }




            public void adddebitcard()
        {
             if (CardIDField.getText().trim().isEmpty() || BalanceAmountField.getText().trim().isEmpty() || BankAccountField.getText().trim().isEmpty() || IssuerBankField.getText().trim().isEmpty() || ClientNameField.getText().trim().isEmpty() || PINNumberField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
                }
    
            else{
    
            int Cardid = getCardID();
            if(Cardid == INVALID){
        
                JOptionPane.showMessageDialog(frame,"please enter positive value for card id \n greater than 0","Error Box",JOptionPane.ERROR_MESSAGE);
                return;        
            }
    
            String ClientName = getClientName();
            if(ClientName.isEmpty()){
        
                JOptionPane.showMessageDialog(frame,"client name is empty \n please enter client name","Error Box",JOptionPane.ERROR_MESSAGE);
                return; 
            }
    
            String IssuerBank = getIssuerBank();
            if(IssuerBank.isEmpty()){
        
                JOptionPane.showMessageDialog(frame," issuer bank is empty \n please enter client name","Error Box",JOptionPane.ERROR_MESSAGE);
                return; 
            }
    
            String BankAccount = getBankAccount();
            if(BankAccount.isEmpty()){
        
                JOptionPane.showMessageDialog(frame,"bank account is empty \n please enter bank account","Error Box",JOptionPane.ERROR_MESSAGE);
                return; 
            }
    
            int BalanceAmount = getBalanceAmount();
            if(BalanceAmount == INVALID){
        
                JOptionPane.showMessageDialog(frame,"please enter positive value for balance amount \n greater than 0","Error Box",JOptionPane.ERROR_MESSAGE);
                return; 
            }
    
            int Pinnumber = getPinNumber();
            if(Pinnumber == INVALID){
        
                JOptionPane.showMessageDialog(frame,"please enter positive value for pin number \n greater than 0","Error Box",JOptionPane.ERROR_MESSAGE);
                return; 
            }
    
    
            if(checkdebitCardIdUnique(getCardID()))
            {
    
            Bankcard obj=new Debitcard(BalanceAmount,  Cardid,  BankAccount,  IssuerBank,  ClientName,  Pinnumber);
            bankcard.add(obj);
    
            JOptionPane.showMessageDialog(null,"your debit card object of bankcard  created successfully","SUCCESS MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    
            if(bankcard.add(obj)==true)
                {
    
                    frame1.setVisible(true);
                    frame.dispose();
                    frame2.dispose();
                }
            
            }
    
            else
            {
        
                    JOptionPane.showMessageDialog(frame, "card id should be unique",
                    "Error box", JOptionPane.ERROR_MESSAGE);
        
        
            }
            
    
        }

    }






                public void addcreditcard()
                {
    
                    //check if card id and balance amount fields are empty
                    if (CardIDField.getText().trim().isEmpty() || BalanceAmountField.getText().trim().isEmpty() || BankAccountField.getText().trim().isEmpty() || IssuerBankField.getText().trim().isEmpty() || ClientNameField.getText().trim().isEmpty() || bankCVCNumberField.getText().trim().isEmpty() || bankInterestRateField.getText().trim().isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, " please fill all credit card fields.");
                    }
        
                    else
                    {
            
            
                int Cardid = getCardID();
                if(Cardid == INVALID){
        
                    JOptionPane.showMessageDialog(frame,"please enter positive value for card id \n greater than 0","Error Box",JOptionPane.ERROR_MESSAGE);
                    return;        
                }
    
                String ClientName = getClientName();
                if(ClientName.isEmpty()){
        
                    JOptionPane.showMessageDialog(frame,"client name is empty \n please enter client name","Error Box",JOptionPane.ERROR_MESSAGE);
                    return; 
                }
    
                String IssuerBank = getIssuerBank();
                if(IssuerBank.isEmpty()){
        
                    JOptionPane.showMessageDialog(frame," issuer bank is empty \n please enter client name","Error Box",JOptionPane.ERROR_MESSAGE);
                    return; 
                }
    
                String BankAccount = getBankAccount();
                if(BankAccount.isEmpty()){
        
                    JOptionPane.showMessageDialog(frame,"bank account is empty \n please enter bank account","Error Box",JOptionPane.ERROR_MESSAGE);
                    return; 
                }
    
                int BalanceAmount = getBalanceAmount();
                if(BalanceAmount == INVALID){
        
                    JOptionPane.showMessageDialog(frame,"please enter positive value for balance amount \n greater than 0","Error Box",JOptionPane.ERROR_MESSAGE);
                    return; 
                }
    
                int cvcnumber = getCVCNumber();
                if(cvcnumber == INVALID){
        
                    JOptionPane.showMessageDialog(frame,"please enter positive value for cvc number \n greater than 0","Error Box",JOptionPane.ERROR_MESSAGE);
                    return; 
                }
    
                double interestrate = getInterestRate();
                if(interestrate == INVALID){
        
                    JOptionPane.showMessageDialog(frame,"please enter positive value for interest rate \n greater than 0","Error Box",JOptionPane.ERROR_MESSAGE);
                    return; 
                }
    
                String expirationdate = getExpirationDate();
                if(expirationdate == null){
        
                    JOptionPane.showMessageDialog(frame,"please enter valid date value \n for date","Error Box",JOptionPane.ERROR_MESSAGE);
                    return; 
                }
    
    
                if(checkcreditCardIdUnique(getCardID()))
                {
    
                    Bankcard obj1=new Creditcard(BalanceAmount,  ClientName,  BankAccount,  IssuerBank,  Cardid,  cvcnumber, interestrate, expirationdate);
                    bankcard.add(obj1);
    
                    JOptionPane.showMessageDialog(null,"your credit card object of bankcard created successfully","SUCCESS MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    
    
                if(bankcard.add(obj1)==true)
                        {
    
                          frame2.setVisible(true);
                          frame.dispose();
                          frame1.dispose();
                        }
            
            
                }
    
                else
                    {
        
                        JOptionPane.showMessageDialog(frame, "card id should be unique",
                        "Error box", JOptionPane.ERROR_MESSAGE);
        
                    }
            
            
            }


    
    
        }


 

            public boolean checkcreditCardIdUnique(int CardId)
            {
                boolean result = true;
                for(Bankcard obj : bankcard)
                {
            
                    if(obj instanceof Creditcard)
                    {
                         Creditcard cc = (Creditcard) obj;
                         if(cc.getCardId() == CardId)
                        { 
                            result = false;
                            break;
                        }
                    }
                }
                return result;
            }


    
    
            public boolean checkdebitCardIdUnique(int CardId)
            {
                boolean result = true;
                for(Bankcard obj : bankcard)
                {
            
                    if(obj instanceof Debitcard)
                    {
                         Debitcard dc = (Debitcard) obj;
                         if(dc.getCardId() == CardId)
                        { 
                            result = false;
                            break;
                        }
                    }
                }
                return result;
            }
    
    
    


            public void setcreditlimit()
            {
    
                if (CreditLimitField.getText().trim().isEmpty()) 
                {
                    JOptionPane.showMessageDialog(frame2, " please fill credit limit.");
                }
        
                if(GracePeriodField.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame2, " please fill grace period.");
     
                }
    
                if(creditCardIDField.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame2, " please fill card id.");
     
                }
    
                else
                {

                    if( getCreditCardID() == getCardID())
                    {
                
                        String cardId = creditCardIDField.getText();
                        double newCreditLimit = Double.parseDouble(CreditLimitField.getText());
                        int Graceperiod=Integer.parseInt(GracePeriodField.getText().trim());
 
                        // Search for the CreditCard object with matching card ID
                        for (Bankcard card : bankcard) 
                        {
                            if (card.getCardId()==(getCreditCardID())) 
                            {
                                if (card instanceof Creditcard) 
                                {
                                    Creditcard creditCard = (Creditcard) card; // Cast BankCard to CreditCard
                                    creditCard.setCreditlimit(newCreditLimit, Graceperiod); // Set the credit limit
                                    JOptionPane.showMessageDialog(frame2, "Credit limit updated to " + newCreditLimit);
                                    
                                } else 
                                {
                                        JOptionPane.showMessageDialog(frame2, "Error: Card is not a credit card");
                                }
                                return;
                            }
                        }

                        
                    }
                    else
                    {
                            // If no matching card ID is found
                            JOptionPane.showMessageDialog(frame2, "Error: Invalid card ID");
                
                    }
            
                }
    
    
            }


                    public void creditdisplay()
                    {
    
    
                        if(CreditLimitField.getText().trim().isEmpty())
                        {
                            JOptionPane.showMessageDialog(frame2, " please fill credit limit.");
                            
                        }
    
                        if(GracePeriodField.getText().trim().isEmpty())
                        {
                            JOptionPane.showMessageDialog(frame2, " please fill grace period.");
     
                        }
    
                        if(creditCardIDField.getText().trim().isEmpty())
                        {
                            JOptionPane.showMessageDialog(frame2, " please fill card id.");
     
                        }
    
                        else
                        {
                            if( getCreditCardID() == getCardID())
                            {
        
                                 JOptionPane.showMessageDialog(frame2,"your card id is:"+getCardID()+"\n your credit limit is:"+getCreditLimit()+"\n your grace period is:"+getGracePeriod()+"\n your cvcnumber is:"+getCVCNumber()+"\n your interest rate is:"+getInterestRate()+"\n your expiration date is:"+getExpirationDate(),"credit card details",JOptionPane.INFORMATION_MESSAGE);
         
                                         for(Bankcard obj : bankcard)
                                        {
                    
                                                if( obj instanceof Creditcard)
                                                {
                                                    Creditcard cc = (Creditcard) obj;
                                                    cc.display();
                                                    break;
                                                }
                                        }
        
        
                            }
    
                            else
                            {
                                JOptionPane.showMessageDialog(frame2, "Error: Invalid card ID");
           
                            }
    
                        }


                    }



                            public void cancelcredit()
                            {
    
                                if(CreditLimitField.getText().trim().isEmpty())
                                {
                                    JOptionPane.showMessageDialog(frame2, " please fill credit limit.");
     
                                }
    
                                if(GracePeriodField.getText().trim().isEmpty())
                                {
                                    JOptionPane.showMessageDialog(frame2, " please fill grace period.");
     
                                }
    
    
                                if(creditCardIDField.getText().trim().isEmpty())
                                {
                                    JOptionPane.showMessageDialog(frame2, " please fill card id.");
     
                                }
    
                                else
                                {
        
                                    if( getCreditCardID() == getCardID())
                                    {
            
                                        CVCNumberField.setText("");
                                        bankCVCNumberField.setText("");
            
                                        CreditLimitField.setText("");
                                        GracePeriodField.setText("");
            
                                        InterestRateField.setText("");
                                        bankInterestRateField.setText("");
            
                                        year.setSelectedIndex(0);
                                        month.setSelectedIndex(0);
                                        day.setSelectedIndex(0);
            
            
                                        JOptionPane.showMessageDialog(frame2," your credit limit is: 0"+"\n your grace period is: 0"+"\n your cvcnumber is: 0"+"\n your interest rate is: 0","credit card details",JOptionPane.INFORMATION_MESSAGE);
         
            
                                        for(Bankcard obj : bankcard)
                                        {
                    
                                            if( obj instanceof Creditcard)
                                            {
                                                Creditcard cc = (Creditcard) obj;
                                                cc.Cancelcreditcard();
                                                break;
                                            }
                                        }
        
            
            
                                    }
        
                                    else
                                    {
                                         JOptionPane.showMessageDialog(frame2," invalid card id","credit card details",JOptionPane.INFORMATION_MESSAGE);
         
             
                                    }
        
        
                                }
    

                            }










                            public void withdraw()
                            {
    
                                //check if card id and balance amount fields are empty
                                if ( WithdrawalAmountField.getText().trim().isEmpty()) 
                                {
                                    JOptionPane.showMessageDialog(null, "Please fill withdrawal amount.");
                                }
            
          
                                else
                                {
                                    if(getDebitPinNumber() == getPinNumber() && getDebitCardID() == getCardID() && totalBalanceAmountField.getText().trim().isEmpty()==true )
            
                                {
            
                                    int Withdrawalamount=getWithdrawalAmount();
                                    if(Withdrawalamount == INVALID)
                                    {
                
                                        JOptionPane.showMessageDialog(frame1,"please enter positive value for withdrawal amount \n greater than 0","withdrawal amount Box",JOptionPane.ERROR_MESSAGE);
                                        return; 
                                    }
            
                                    String dateofwithdrawal=getDateOfWithdrawal();
                                    if(dateofwithdrawal == null)
                                    {
                
                                        JOptionPane.showMessageDialog(frame1,"please enter valid date of withdrawal","withdrawal amount Box",JOptionPane.ERROR_MESSAGE);
                                         return; 
                                    }
            
            
                                    if(getWithdrawalAmount() <= getBalanceAmount())
                                    {
                                        JOptionPane.showMessageDialog(frame1,"you have sufficient balance for withdraw","balance details",JOptionPane.INFORMATION_MESSAGE);
                
                                        withdrawframe.setVisible(true);
                                        frame.dispose();
                                        frame1.dispose();
                                        frame2.dispose();
        
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame1,"you have Insufficient balance for withdraw","balance details",JOptionPane.INFORMATION_MESSAGE);
                
                                    }
               
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(frame1," your cardid or pinnumber not matched"+"\n total balance must be empty","details",JOptionPane.INFORMATION_MESSAGE);
                
                                }
               
               
                            }
            
    
    
                        }


                        public void finalwithdraw()
                        {
                            if ( debitCardIDField.getText().trim().isEmpty()) 
                            {
                                JOptionPane.showMessageDialog(withdrawframe, "Please fill card id.","Error message",JOptionPane.ERROR_MESSAGE);
                            }
    
                            else
                            {
           
    
                                if(getWithdrawCardID() == getCardID())
                                {
        
                    
                                    int balanceamount=getBalanceAmount();
                                    balanceamount -= getWithdrawalAmount();
                                    totalBalanceAmountField.setText(Integer.toString(balanceamount));
                                    totalBalanceAmountField.setEditable(false);
                    
                                    JOptionPane.showMessageDialog(withdrawframe,"successfully withdrawal amount is:"+getWithdrawalAmount(),"withdrawal details",JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    
                                     for(Bankcard obj : bankcard)
                                    {
                    
                                        if( obj instanceof Debitcard)
                                        {
                                            Debitcard dc = (Debitcard) obj;
                                            dc.withdraw(getWithdrawalAmount(), getDateOfWithdrawal(), getPinNumber());
                                            break;
                                        }
                                    }
                                    
        
                    
                             
                             

                               }
    
                                else
                                {
        
                                    JOptionPane.showMessageDialog(withdrawframe,"cardid not matched:","withdrawal details",JOptionPane.ERROR_MESSAGE);
                
                                }
    

                            }
    
                        }

                                public void display()
                                {
                                   if (WithdrawalAmountField.getText().trim().isEmpty()) 
                                   {
                                        JOptionPane.showMessageDialog(frame1, "Please fill withdrawal amount");
                                    }
                                    if(debitCardIDField.getText().trim().isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(frame1, "Please fill card id");
                 
                                    }
        
                                    if(debitPINNumberField.getText().trim().isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(frame1, "Please fill pin number");
                 
                                    }
                
         
           
            
                                    else
                                    {
            
                                        if(getDebitPinNumber() == getPinNumber() && getDebitCardID() == getCardID())
            
                                        {
                        
                                            String dateofwithdrawal=getDateOfWithdrawal();
                                            if(dateofwithdrawal == null)
                                            {
                
                                                JOptionPane.showMessageDialog(frame1,"please enter valid date of withdrawal","withdrawal amount Box",JOptionPane.ERROR_MESSAGE);
                                                return; 
                                            }
            
                                            int Withdrawalamount=getWithdrawalAmount();
                                            if(Withdrawalamount == INVALID)
                                            {
                
                                                JOptionPane.showMessageDialog(frame1,"please enter positive value for withdrawal amount \n greater than 0","Error Box",JOptionPane.ERROR_MESSAGE);
             
                                            }
            
                                            else if(Withdrawalamount>getBalanceAmount())
                                            {
                                                JOptionPane.showMessageDialog(frame1," withdrawal amount is   \n greater than balance amount","Error Box",JOptionPane.ERROR_MESSAGE);
             
                                            }
            
                                            //String DateOfWithdrawal=getDateOfWithdrawal();
                                            else if(Withdrawalamount<=getBalanceAmount())
                                            {
            
                                                JOptionPane.showMessageDialog(frame1, "the given pinnumber is:"+" "+getPinNumber()+ "\n the card id is:"+" "+getCardID()+ "\n the withdrawal amount is:"+" "+getWithdrawalAmount() +"\n the date of withdrawal is:"+" "+getDateOfWithdrawal(),"Information of debit card",JOptionPane.INFORMATION_MESSAGE);
                
                
                                                     for(Bankcard obj : bankcard)
                                                    {
                    
                                                            if( obj instanceof Debitcard)
                                                            {
                                                                Debitcard dc = (Debitcard) obj;
                                                                dc.display();
                                                                break;
                                                            }
                                                    }
                                            }
        
        
                                    }else
                                    {
                                        JOptionPane.showMessageDialog(frame1," your cardid or pinnumber not matched","details",JOptionPane.INFORMATION_MESSAGE);
                
                                    }
        
        
        
                                }
        
                            }
    
  
    
                                public void bankdisplay()
                                {
                                    if (CardIDField.getText().trim().isEmpty()) 
                                    {
                                        JOptionPane.showMessageDialog(frame1, "Please fill card id");
                                    }
                    
                                    if(ClientNameField.getText().trim().isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(frame1, "Please fill client name");
                 
                                    }
        
                                    if(IssuerBankField.getText().trim().isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(frame1, "Please fill issuer bank");
                 
                                    }
        
                                    if(BankAccountField.getText().trim().isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(frame1, "Please fill bank account");
                 
                                    }
        
                                    if(BalanceAmountField.getText().trim().isEmpty()){
                                        JOptionPane.showMessageDialog(frame1, "Please fill balance amount");
                 
                                    }
        
                                    if(PINNumberField.getText().trim().isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(frame1, "Please fill pin number");
                 
                                    }
        
                                    else
                                    {
            
        
                                        JOptionPane.showMessageDialog(frame,"the card id is:"+getCardID()+"\n the client name is:"+getClientName()+"\n the issuer bank is:"+getIssuerBank()+"\n the bank account is:"+getBankAccount()+"\n the balance amount is:"+getBalanceAmount()+"\n the pinnumber is:"+getPinNumber(),"bank card details",JOptionPane.INFORMATION_MESSAGE);
    
    
                                            for(Bankcard obj : bankcard)
                                            {
                    
                                                if( obj instanceof Bankcard)
                                                {
                                                    Bankcard bb = (Bankcard) obj;
                                                    bb.display();
                                                    break;
                                                }
                                            }
        
    
                                    }
    
    
                                }
        
        
        
    

            



                public static void main(String[] args) 
                 {
                    BankGUI obj=new BankGUI();


                 }




}   



