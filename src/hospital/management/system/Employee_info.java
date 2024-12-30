package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);


        JTable table=new JTable();
        table.setBounds(10,34,980,300);
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        table.setBackground(new Color(109,164,170));
        panel.add(table);


//        to display database on table
        try{
            conn c=new conn();
            String q="select * from employee_info";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

//        For labels on table
        JLabel l1=new JLabel("Name");
        l1.setBounds(41,9,70,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l1);



        JLabel l2=new JLabel("Age");
        l2.setBounds(180,9,70,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l2);


        JLabel l3=new JLabel("Phone No.");
        l3.setBounds(350,9,150,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l3);


        JLabel l4=new JLabel("Salary");
        l4.setBounds(550,9,150,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l4);


        JLabel l5=new JLabel("Gmail ID");
        l5.setBounds(700,9,150,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l5);


        JLabel l6=new JLabel("Aadhar No.");
        l6.setBounds(830,9,150,20);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l6);


        JButton b1=new JButton("Back");
        b1.setBounds(350,400,120,30);
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
        setSize(1000,500);
        setLocation(220,205);
        setLayout(null);
        setVisible(true);


    }


    public static void main(String args[]){
        new Employee_info();

    }
}
