package com.company;

import sun.text.normalizer.NormalizerBase;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Drawer extends JFrame {
    JTable table = new JTable();

    static Connection connection = null;
    TextField portField = new TextField();
    TextField userField = new TextField();
    TextField hostField = new TextField();
    TextField passwordField = new TextField();
    TextField DBnameField = new TextField();
    TextField mail = new TextField();

    public Drawer () {
        super("Table");


        GridBagConstraints c = new GridBagConstraints();
        JPanel jcp = new JPanel(new GridBagLayout());
        jcp.setBorder(new Border() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(5, 5, 5, 5);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });
        setContentPane(jcp);

        //initial conditions
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx=1;
        c.weighty=1;


        Label port = new Label();

        Label user = new Label();
        Label host = new Label();
        Label password = new Label();
        Label DBname = new Label();
        port.setAlignment(Label.RIGHT);
        user.setAlignment(Label.RIGHT);
        host.setAlignment(Label.RIGHT);
        password.setAlignment(Label.RIGHT);
        DBname.setAlignment(Label.RIGHT);
        port.setText("port:");
        user.setText("user:");
        host.setText("host:");
        password.setText("password:");
        DBname.setText("DBname:");

        Button connect = new Button();
        connect.setLabel("Connect");
        connect.addActionListener(new RListener());
        //empty strokes
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();
        //buttons
        Button task1 = new Button();
        task1.setLabel("Show 1");
        Button task2 = new Button();
        task2.setLabel("Show 2");
        Button task3 = new Button();
        task3.setLabel("Show 3");
        Button task4 = new Button();
        task4.setLabel("Show 4");
        Button task5 = new Button();
        task5.setLabel("Show 5");
        task1.addActionListener(new RListener());
        task2.addActionListener(new RListener());
        task3.addActionListener(new RListener());
        task4.addActionListener(new RListener());
        task5.addActionListener(new RListener());



        //texts
        Label patients = new Label();
        patients.setText("Patient's");
        patients.setAlignment(Label.CENTER);
        Label p_mail = new Label();
        p_mail.setText("E-mail");
        p_mail.setAlignment(Label.CENTER);
        TextField mail = new TextField();
        mail.setText("");
        Label text1 = new Label();
        text1.setText("Task 1:");
        Label text2 = new Label();
        text2.setText("Task 2:");
        Label text3 = new Label();
        text3.setText("Task 3:");
        Label text4 = new Label();
        text4.setText("Task 4:");
        Label text5 = new Label();
        text5.setText("Task 5:");

        c.gridheight=1;
        c.gridwidth=1;
        c.gridy=0;
        c.gridx=0;
        jcp.add(host, c);
        c.gridx=1;
        jcp.add(hostField, c);
        c.gridx=2;
        jcp.add(port, c);
        c.gridx=3;
        jcp.add(portField, c);
        c.gridx=4;
        jcp.add(DBname, c);
        c.gridx=5;
        jcp.add(DBnameField, c);
        c.gridx=6;
        jcp.add(user, c);
        c.gridx=7;
        jcp.add(userField, c);
        c.gridx=8;
        jcp.add(password, c);
        c.gridx=9;
        jcp.add(passwordField, c);
        c.gridx=10;
        jcp.add(connect, c);
        //task1
        c.gridheight=1;
        //label
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=2;
        jcp.add(text1, c);
        //patient's
        c.gridy=2;
        c.gridx=0;
        c.gridwidth=2;
        jcp.add(patients, c);
        //name label
        c.gridy=3;
        c.gridwidth=1;
        jcp.add(p_mail, c);
        //name field
        c.gridx=1;
        c.gridwidth=1;
        jcp.add(mail, c);

        //button
        c.gridy=4;
        c.gridx=0;
        c.gridwidth=2;
        jcp.add(task1, c);
        //empty
        c.gridy=5;
        c.gridx=0;
        c.gridheight=3;
        c.gridwidth=2;
        jcp.add(l1, c);
        c.gridheight=1;

        //task2

        //label
        c.gridwidth=2;
        c.gridx=0;
        c.gridy=8;
        jcp.add(text2, c);
        //button
        c.gridy=9;
        jcp.add(task2, c);

        //task3

        //label
        c.gridwidth=2;
        c.gridx=0;
        c.gridy=10;
        jcp.add(text3, c);
        //button
        c.gridy=11;
        jcp.add(task3, c);
        //empty
        c.gridy=12;
        c.gridheight=3;
        c.gridwidth=2;
        jcp.add(l3, c);
        c.gridheight=1;
        //task4

        //label
        c.gridwidth=2;
        c.gridx=0;
        c.gridy=15;
        jcp.add(text4, c);
        //button
        c.gridy=16;
        jcp.add(task4, c);
        //empty
        c.gridy=17;
        c.gridheight=3;
        c.gridwidth=2;
        jcp.add(l4, c);
        c.gridheight=1;

        //task5

        //label
        c.gridwidth=2;
        c.gridx=0;
        c.gridy=20;
        jcp.add(text5, c);
        //button
        c.gridy=21;
        jcp.add(task5, c);


        table = new JTable(new Object[][]{}, new String[]{});
        table.setBorder(new Border() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(0, 5, 0, 0);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });
        JScrollPane pane = new JScrollPane(table);
        pane.setBorder(new Border() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(0, 5, 0, 0);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });
        c.gridx=2;
        c.gridy=1;
        c.gridheight=21;
        c.gridwidth=11;
        c.weightx=1;
        jcp.add(pane, c);




        jcp.setBackground(Color.LIGHT_GRAY);
        setSize(1250, 680);
        setMinimumSize(new Dimension(1250, 680));
        setMaximumSize(new Dimension(1250, 680));
        setPreferredSize(new Dimension(1250, 680));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    private class RListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Vector<Vector<String>> vect = new Vector<Vector<String>>();
            if(((Button)e.getSource()).getLabel().equals("Show 1")&&connection!=null){
                Statement stmt = null;
                String query = "create function xor(boolean, boolean)\n" +
                        "    returns boolean as\n" +
                        "$$ select ($1 and not $2) or (not $1 and $2) $$ language 'sql';\n" +
                        "\n" +
                        "with Patient_Appointments as (\n" +
                        "    select *\n" +
                        "    from Appointment\n" +
                        "    where Patient_Id = (\n" +
                        "        select Patient.Pt_Id\n" +
                        "        from Patient\n" +
                        "        where Email = '"+mail.getText()+"'\n" +
                        "    ))\n" +
                        "select distinct Found_Doctors.*\n" +
                        "from (\n" +
                        "         select Doctor.*\n" +
                        "         from Patient_Appointments\n" +
                        "                join Doctor on (\n" +
                        "                 Doctor_Id = Doctor.Dc_Id\n" +
                        "                 and xor(\n" +
                        "                         Doctor.Name similar to '(M|L)%',\n" +
                        "                         Doctor.Surname similar to '(M|L)%'\n" +
                        "                     )\n" +
                        "             )\n" +
                        "         where Date = (\n" +
                        "             select max(Date)\n" +
                        "             from Patient_Appointments\n" +
                        "         )\n" +
                        "     ) as Found_Doctors;\n" +
                        "\n" +
                        "drop function xor;";
                try {
                    stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String surname = rs.getString("surname");
                        Vector<String> vectAdd = new Vector<String>();
                        vectAdd.add(String.valueOf(name));
                        vectAdd.add(String.valueOf(surname));
                        vect.add(vectAdd);
                    }
                    table.setModel(new DefaultTableModel());
                    TableModel model = table.getModel();
                    Vector<String> ident = new Vector<String>();
                    ident.add("Name");
                    ident.add("Surname");
                    ((DefaultTableModel)model).setDataVector(vect, ident);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }else if(((Button)e.getSource()).getLabel().equals("Show 2")&&connection!=null){
                Statement stmt = null;
                String query = "with Dates as (\n" +
                        "    select *\n" +
                        "    from generate_series(\n" +
                        "                 CURRENT_DATE - '1 year'::Interval,\n" +
                        "                 CURRENT_DATE,\n" +
                        "                 '1 day'::Interval\n" +
                        "             )\n" +
                        ")\n" +
                        "select Doctor_Id, Day_Of_Week, count(Day_Of_Week)\n" +
                        "from (\n" +
                        "         select Doctor_Id, to_char(Date, 'dy') as Day_Of_Week\n" +
                        "         from Appointment\n" +
                        "         where Date in (select * from Dates)\n" +
                        "     ) as With_Weekdays\n" +
                        "group by Day_Of_Week, Doctor_Id;";
                try {
                    stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    System.out.println(0);
                    while (rs.next()) {
                        System.out.println(1);
                        int id = rs.getInt("doctor_id");
                        String day_of_week = rs.getString("day_of_week");
                        int count = rs.getInt("count");
                        Vector<String> vectAdd = new Vector<String>();
                        vectAdd.add(String.valueOf(id));
                        vectAdd.add(String.valueOf(day_of_week));
                        vectAdd.add(String.valueOf(count));
                        vect.add(vectAdd);
                    }
                    table.setModel(new DefaultTableModel());
                    TableModel model = table.getModel();
                    Vector<String> ident = new Vector<String>();
                    ident.add("doctor_id");
                    ident.add("day_of_week");
                    ident.add("count");
                    ((DefaultTableModel)model).setDataVector(vect, ident);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }else if(((Button)e.getSource()).getLabel().equals("Show 3")&&connection!=null){
                Statement stmt = null;
                String query = "-- drop function previous_month();\n" +
                        "\n" +
                        "with Patients_Last_Month as (\n" +
                        "    select patient_id, extract(week from Date) as week, count(ap_id) as count\n" +
                        "    from (\n" +
                        "             select *, extract(month from date) as month, extract(year from date) as year\n" +
                        "             from Appointment\n" +
                        "         ) as Apointments\n" +
                        "    where (\n" +
                        "              case\n" +
                        "                  when extract(month from CURRENT_DATE) = 1\n" +
                        "                      then (month = 12 and year = extract(YEAR from CURRENT_DATE) - 1)\n" +
                        "                  else (month = extract(month from CURRENT_DATE) - 1 and year = extract(YEAR from CURRENT_DATE))\n" +
                        "                  end\n" +
                        "              )\n" +
                        "    group by patient_id, Date\n" +
                        ")\n" +
                        "select patient_id, count\n" +
                        "from (\n" +
                        "         select patient_id, count(week) as count_weeks, sum(count) as count\n" +
                        "         from Patients_Last_Month\n" +
                        "         where count >= 1\n" +
                        "         group by patient_id) as Patient_Counted_Weeks\n" +
                        "where count_weeks >= (\n" +
                        "    select count(date)\n" +
                        "    from (\n" +
                        "             select *\n" +
                        "             from (\n" +
                        "                      select Date as Date\n" +
                        "                      from generate_series(\n" +
                        "                                   CURRENT_DATE - '2 month'::Interval,\n" +
                        "                                   CURRENT_DATE,\n" +
                        "                                   '1 day'::Interval) as Date\n" +
                        "                  ) as FEW\n" +
                        "             where (\n" +
                        "                       case\n" +
                        "                           when extract(month from CURRENT_DATE) = 1\n" +
                        "                               then (extract(month from date) = 12 and\n" +
                        "                                     extract(year from date) = extract(YEAR from CURRENT_DATE) - 1)\n" +
                        "                           else (extract(month from date) = extract(month from CURRENT_DATE) - 1 and\n" +
                        "                                 extract(year from date) = extract(YEAR from CURRENT_DATE))\n" +
                        "                           end\n" +
                        "                       )\n" +
                        "         ) as EW\n" +
                        ");\n";
                try {
                    stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        System.out.println(1);
                        int id = rs.getInt("patient_id");
                        int count = rs.getInt("count");
                        Vector<String> vectAdd = new Vector<String>();
                        vectAdd.add(String.valueOf(id));
                        vectAdd.add(String.valueOf(count));
                        vect.add(vectAdd);
                    }
                    table.setModel(new DefaultTableModel());
                    TableModel model = table.getModel();
                    Vector<String> ident = new Vector<String>();
                    ident.add("patient_id");
                    ident.add("count");
                    ((DefaultTableModel)model).setDataVector(vect, ident);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }else if(((Button)e.getSource()).getLabel().equals("Show 4")&&connection!=null){
                Statement stmt = null;
                String query = "with Last_Month_Appointments as (\n" +
                        "    select Patient_Id,\n" +
                        "           Birth_Date,\n" +
                        "           count(Ap_Id)                                                        as Count,\n" +
                        "           (extract(year from CURRENT_DATE) - extract(year from P.Birth_Date)) as Age\n" +
                        "    from Appointment\n" +
                        "             join Patient P on Appointment.Patient_Id = P.Pt_Id\n" +
                        "    where (\n" +
                        "              case\n" +
                        "                  when extract(month from CURRENT_DATE) = 1\n" +
                        "                      then (extract(month from Date) = 12 and\n" +
                        "                            extract(year from Date) = extract(year from CURRENT_DATE) - 1)\n" +
                        "                  else (extract(month from Date ) = extract(month from CURRENT_DATE) - 1 and\n" +
                        "                        extract(year from Date) = extract(year from CURRENT_DATE))\n" +
                        "                  end\n" +
                        "              )\n" +
                        "    group by Patient_Id, Birth_Date\n" +
                        ")\n" +
                        "select Patient_Id,\n" +
                        "       Age,\n" +
                        "       Birth_Date,\n" +
                        "       (\n" +
                        "           case\n" +
                        "               when (Count < 3 and Age < 50) then 200\n" +
                        "               when (Count >= 3 and Age < 50) then 250\n" +
                        "               when (Count < 3 and Age >= 50) then 400\n" +
                        "               when (Count >= 3 and Age >= 50) then 500\n" +
                        "               end\n" +
                        "           ) as Fee\n" +
                        "from Last_Month_Appointments";
                try {
                    stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        System.out.println(1);
                        int id = rs.getInt("patient_id");
                        double age = rs.getDouble("age");
                        Date date = rs.getDate("birth_date");
                        int count = rs.getInt("fee");
                        Vector<String> vectAdd = new Vector<String>();
                        vectAdd.add(String.valueOf(id));
                        vectAdd.add(String.valueOf(age));
                        vectAdd.add(String.valueOf(date));
                        vectAdd.add(String.valueOf(count));
                        vect.add(vectAdd);
                    }
                    table.setModel(new DefaultTableModel());
                    TableModel model = table.getModel();
                    Vector<String> ident = new Vector<String>();
                    ident.add("patient_id");
                    ident.add("age");
                    ident.add("birth_date");
                    ident.add("count");
                    ((DefaultTableModel)model).setDataVector(vect, ident);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }else if(((Button)e.getSource()).getLabel().equals("Show 5")&&connection!=null){
                Statement stmt = null;
                String query = "with Doctors_Attendance as (\n" +
                        "    select d.dc_id,\n" +
                        "           count(ap_id)                       as count,\n" +
                        "           extract(year from appointment.date) as year\n" +
                        "    from appointment\n" +
                        "             join doctor d on appointment.doctor_id = d.dc_id\n" +
                        "    where extract(year from appointment.date) + 10 >= extract(year from CURRENT_DATE)\n" +
                        "    group by d.dc_id, year\n" +
                        ")\n" +
                        "select *\n" +
                        "from (\n" +
                        "         select dc_id, count(year) as count, sum(count) as sum, year\n" +
                        "         from Doctors_Attendance\n" +
                        "         group by dc_id, year\n" +
                        "     ) as Doctors_Att_Grouped\n" +
                        "where count >= 10 and sum >= 100\n" +
                        ";";
                try {
                    stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        System.out.println(1);
                        int id = rs.getInt("dc_id");
                        int count = rs.getInt("count");
                        int sum = rs.getInt("sum");
                        int year = rs.getInt("year");
                        Vector<String> vectAdd = new Vector<String>();
                        vectAdd.add(String.valueOf(id));
                        vectAdd.add(String.valueOf(count));
                        vectAdd.add(String.valueOf(sum));
                        vectAdd.add(String.valueOf(year));
                        vect.add(vectAdd);
                    }
                    table.setModel(new DefaultTableModel());
                    TableModel model = table.getModel();
                    Vector<String> ident = new Vector<String>();
                    ident.add("dc_id");
                    ident.add("count");
                    ident.add("sum");
                    ident.add("year");
                    ((DefaultTableModel)model).setDataVector(vect, ident);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }else if(((Button)e.getSource()).getLabel().equals("Connect")){
                System.out.println("Testing connection to PostgreSQL JDBC");

                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException exx) {
                    System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
                    exx.printStackTrace();
                    return;
                }

                System.out.println("PostgreSQL JDBC Driver successfully connected");
                Connection connection = null;

                try {
                    connection = DriverManager
                            .getConnection("jdbc:postgresql://"+hostField.getText()+":"
                                    +portField.getText()+"/"+DBnameField.getText(),
                                    userField.getText(), passwordField.getText());

                } catch (SQLException exc) {
                    System.out.println("Connection Failed");
                    exc.printStackTrace();
                    return;
                }

                if (connection != null) {
                    Drawer.connection=connection;
                    System.out.println("You successfully connected to database now");
                } else {
                    System.out.println("Failed to make connection to database");
                }


            }
        }
    }
}