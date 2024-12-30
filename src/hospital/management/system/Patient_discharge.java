package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_discharge  extends JFrame {
    Patient_discharge(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel l1=new JLabel("CHECK-OUT");
        l1.setBounds(100,20,150,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setForeground(Color.WHITE);
        panel.add(l1);


        JLabel l2=new JLabel("Customer Id");
        l2.setBounds(30,80,150,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(Color.WHITE);
        panel.add(l2);

        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select *from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));

            }


        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(30,130,150,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(Color.WHITE);
        panel.add(l3);

        JLabel rn=new JLabel();
        rn.setBounds(200,130,150,20);
        rn.setFont(new Font("Tahoma",Font.BOLD,14));
        rn.setForeground(Color.WHITE);
        panel.add(rn);

        JLabel l4=new JLabel("In Time");
        l4.setBounds(30,180,150,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setForeground(Color.WHITE);
        panel.add(l4);

        JLabel inTime=new JLabel();
        inTime.setBounds(200,180,250,20);
        inTime.setFont(new Font("Tahoma",Font.BOLD,14));
        inTime.setForeground(Color.WHITE);
        panel.add(inTime);



        JLabel l5=new JLabel("Out Time");
        l5.setBounds(30,230,150,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setForeground(Color.WHITE);
        panel.add(l5);

        Date date=new Date();

        JLabel outTime=new JLabel(""+date);
        outTime.setBounds(200,230,250,20);
        outTime.setFont(new Font("Tahoma",Font.BOLD,14));
        outTime.setForeground(Color.WHITE);
        panel.add(outTime);

//buttons
        JButton discharge=new JButton ("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                try{
                    c.statement.executeUpdate("delete from patient_info where number='"+choice.getSelectedItem()+"'");
//                    room validation
                    c.statement.executeUpdate("update room set availability='Available' where room_number='"+rn.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton check=new JButton ("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                try{
                    ResultSet resultSet=c.statement.executeQuery("select * from patient_info where number='"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        rn.setText(resultSet.getString("room_number"));
                        inTime.setText(resultSet.getString("time"));
                    }

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton Back=new JButton ("Back");
        Back.setBounds(300,300,120,30);
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
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);



    }
    public static void main(String []args){
        new Patient_discharge();

    }
}
