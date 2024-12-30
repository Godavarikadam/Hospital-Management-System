package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient_info extends JFrame {

    Patient_info(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,560);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);


        JTable table=new JTable();
        table.setBounds(10,40,900,380);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try{
            conn c=new conn();
            String q="select*from patient_info";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel l1=new JLabel("ID");
        l1.setBounds(31,11,100,14);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l1);


        JLabel l2=new JLabel("Number");
        l2.setBounds(150,11,100,14);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l2);

        JLabel l3=new JLabel("Name");
        l3.setBounds(270,11,100,14);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l3);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(360,11,100,14);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l4);

        JLabel l5=new JLabel("Disease");
        l5.setBounds(480,11,100,14);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l5);

        JLabel l6=new JLabel("Room");
        l6.setBounds(600,11,100,14);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l6);


        JLabel l7=new JLabel("Time");
        l7.setBounds(700,11,100,14);
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l7);

        JLabel l8=new JLabel("Deposite");
        l8.setBounds(800,11,100,14);
        l8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l8);

        JButton b1=new JButton("Back");
        b1.setBounds(450,430,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


           setUndecorated(true);
           setSize(900,600);
           setLayout(null);
           setLocation(300,200);
           setVisible(true);



    }
    public static void main(String args[]){
        new Patient_info();
    }
}
