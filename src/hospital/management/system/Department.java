package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));

        add(panel);

        JTable table=new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(table);


        try{
            conn c=new conn();
            String q="select * from department";
            ResultSet resultset=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));


        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel l1=new JLabel("Department");
       l1.setBounds(145,11,105,20);

       l1.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(l1);

        JLabel l2=new JLabel("Phone Number");
        l2.setBounds(430,11,150,20);
        l2.setFont(new Font("tahoma",Font.BOLD,14));
        panel.add(l2);



        JButton back=new JButton("Back");
        back.setBounds(400,390,130,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);



    }
    public static void main(String[]args){
        new Department();
    }
}
