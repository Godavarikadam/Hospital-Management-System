package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_Room  extends JFrame {

    Choice choice;
    JTable table;

    Search_Room(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel  For=new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.WHITE);
        For.setFont(new Font("Tamoha",Font.BOLD,20));
        panel.add( For);


        JLabel status=new JLabel("Status");
        status.setBounds(50,73,120,20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tamoha",Font.BOLD,14));
        panel.add(status);


        choice=new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,158,700,200);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conn c=new conn();
            String q="select *from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel Roomno=new JLabel("Room Number");
        Roomno.setBounds(10,132,150,20);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        Roomno.setForeground(Color.WHITE);
        panel.add(Roomno);

        JLabel available=new JLabel("Availability");
        available.setBounds(175,132,150,20);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel price=new JLabel("Price");
        price.setBounds(370,132,150,20);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.WHITE);
        panel.add(price);


        JLabel bed=new JLabel("Bed Type");
        bed.setBounds(530,132,150,20);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        bed.setForeground(Color.WHITE);
        panel.add(bed);


        JButton search=new JButton ("Search");
        search.setBounds(200,370,120,25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select*from room where availability='"+choice.getSelectedItem()+"'";
                try{

                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back=new JButton ("Back");
        Back.setBounds(380,370,120,25);
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
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Search_Room();
    }
}
