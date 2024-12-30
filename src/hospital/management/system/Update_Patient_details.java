package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Update_Patient_details extends JFrame {
    Update_Patient_details(){

        JPanel panel=new JPanel();
        panel.setBounds(5,3,940,460);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);



        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(image);
        JLabel label=new JLabel(i2);
        label.setBounds(500,50,300,300);
        panel.add(label);


        JLabel l1=new JLabel("Update Patient Details");
        l1.setBounds(124,11,250,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        JLabel l2=new JLabel("Name");
        l2.setBounds(25,88,80,15);
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        l2.setForeground(Color.WHITE);
        panel.add(l2);

        Choice choice=new Choice();
        choice.setBounds(248,85,152,25);
        panel.add(choice);

        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select*from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("name"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(25,129,100,15);
        l3.setFont(new Font("Tahoma",Font.PLAIN,14));
        l3.setForeground(Color.WHITE);
        panel.add(l3);


        JTextField tfr=new JTextField();
        tfr.setBounds(248,129,145,20);
        panel.add(tfr);

        JLabel l4=new JLabel("In Time");
        l4.setBounds(25,174,100,15);
        l4.setFont(new Font("Tahoma",Font.PLAIN,14));
        l4.setForeground(Color.WHITE);
        panel.add(l4);

        JTextField tfInTime=new JTextField();
        tfInTime.setBounds(248,174,145,20);
        panel.add(tfInTime);


        JLabel l5=new JLabel("Amount Paid (Rs):");
        l5.setBounds(25,216,150,15);
        l5.setFont(new Font("Tahoma",Font.PLAIN,14));
        l5.setForeground(Color.WHITE);
        panel.add(l5);

        JTextField tfAmount=new JTextField();
        tfAmount.setBounds(248,216,145,20);
        panel.add(tfAmount);

        JLabel l6=new JLabel("Pending Amount (Rs):");
        l6.setBounds(25,261,150,15);
        l6.setFont(new Font("Tahoma",Font.PLAIN,14));
        l6.setForeground(Color.WHITE);
        panel.add(l6);

        JTextField tfPending=new JTextField();
        tfPending.setBounds(248,261,145,20);
        panel.add(tfPending);

        JButton check=new JButton ("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="select * from patient_info where name='"+id+"'";
                try{
                    conn c1=new conn();
                    ResultSet resultSet= c1.statement.executeQuery(q);
                    while(resultSet.next()){
                        tfr.setText(resultSet.getString("room_number"));
                        tfInTime.setText(resultSet.getString("time"));
                        tfAmount.setText(resultSet.getString("deposite"));

                    }
                    ResultSet resultSet1= c1.statement.executeQuery("select*from room where room_number='"+tfr.getText()+"'");
                    while(resultSet1.next()){
                        String price=resultSet1.getString("price");
                        int amountPaid=Integer.parseInt(price)-Integer.parseInt(tfAmount.getText());
                        tfPending.setText(""+amountPaid);


                    }
                }catch(Exception E){
                    E.printStackTrace();
                }

            }
        });


        JButton Update=new JButton ("Update");
        Update.setBounds(56,378,89,23);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        panel.add(Update);

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = tfr.getText();
                    String time = tfInTime.getText();
                    String amount = tfAmount.getText();
                    c.statement.executeUpdate("update patient_info set room_number='" + room + "',time='" + time + "',deposite='" + amount + "' where name='" + q + "'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully!!");
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton Back=new JButton ("Back");
        Back.setBounds(168,378,89,23);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950,480);
        setLayout(null);
        setLocation(190,220);
        setVisible(true);

    }


    public static void main(String[] args) {
        new Update_Patient_details();
    }
}
