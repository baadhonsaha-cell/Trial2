
package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import Entity.Service;
import EntityList.ServiceList;
import Files.ServiceIO;

public class ServiceManagement extends JFrame implements ActionListener, KeyListener {

    private Container c;
    private DefaultTableModel model;
    private JLabel PatientName, Age, Weight, Sex, PatientID, ServiceName, Cost, ServiceType, DoctorName, Title, Search, image;
    private JButton Add, Update, Delete, Clear, ShowPass;
    private JTextField tPatientName, tServiceName, tCost, tSearch, tDoctorName, tAge, tWeight;
    private JTable jtb;
    private JScrollPane scl;
    private JRadioButton Test, Operation;
    private ButtonGroup grp;
    private JPanel panel1;
    private JComboBox Type, Service, Doctor, comboSex;
    private JPasswordField passPatientID;
    private boolean isPasswordVisible = false;
    private ImageIcon img;

    private ServiceList serviceList;

    private String[] cols = {"Patient Name", "Age", "Weight", "Sex", "ID", "Service Name", "Cost", "Type", "Doctor Name"};
    private String[] rows = new String[9];

    private String[] TEST = {"BLOOD TEST", "URINE TEST", "TSH TEST"};
    private String[] OPERATION = {"APENDIS OPERATION", "EYE OPERATION", "LEG OPERATION","HEART OPERATION"};

    private String[] blood ={" List","Dr. Jony","Dr. Shihab","Dr. Akash"};
    private String[] urine ={" List","Dr. Mahfuz","Dr. Radia","Dr. Tamim","Dr. Nashia"};
    private String[] tsh = {" List","Dr.Arnab","Dr. Sonali","Dr. Mazharul"};
    private String[] apendis ={" List","Dr. Turjo","Dr. Ali","Dr. Rifat"};
    private String[] eye ={" List","Dr. Ayon","Dr. Sifat","Dr. Ratul"};
    private String[] leg={" List","Dr. Nashia","Dr. Hiya","Dr. Bijoy"};
    private String[] heart={" List","Dr. Roxy","Dr. Toushin","Dr. Vaskor"};

    public ServiceManagement() {

        this.setSize(1350, 768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clinic Management");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(135, 206, 235));

        img=new ImageIcon("./Image/image.png");
        image=new JLabel();
        image.setBounds(0,0, 1350, 768);
        Image pic=img.getImage();
        Image scaledImage=pic.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        image.setIcon(new ImageIcon(scaledImage));
        c.add(image);

        panel1=new JPanel();
        panel1.setBounds(0, 0, 1350, 768);
        panel1.setOpaque(false);   
        panel1.setLayout(null);
        image.add(panel1);  

        Font f = new Font("Cambria", Font.BOLD, 17);
        Font f2=new  Font("Arial", Font.BOLD, 20);

       
        PatientName = new JLabel("Patient Name:");
        PatientName.setBounds(50, 100, 150, 30);
        PatientName.setFont(f);
        panel1.add(PatientName);

        Age = new JLabel("Age:");
        Age.setBounds(50, 350, 150, 40);
        Age.setFont(f);
        panel1.add(Age);

        Weight = new JLabel("Weight:");
        Weight.setBounds(50, 150, 150, 30);
        Weight.setFont(f);
        panel1.add(Weight);

        Sex = new JLabel("Sex:");
        Sex.setBounds(50, 200, 150, 30);
        Sex.setFont(f);
        panel1.add(Sex);

        PatientID = new JLabel("ID: ");
        PatientID.setBounds(50, 250, 150, 30);
        PatientID.setFont(f);
        panel1.add(PatientID);

        ServiceName = new JLabel("Service Name: ");
        ServiceName.setBounds(50, 300, 150, 30);
        ServiceName.setFont(f);
        panel1.add(ServiceName);

        Cost = new JLabel("Cost: ");
        Cost.setBounds(615, 100, 150, 40);
        Cost.setFont(f);
        panel1.add(Cost);

        ServiceType = new JLabel("Service Type:");
        ServiceType.setBounds(615, 160, 200, 40);
        ServiceType.setFont(f);
        panel1.add(ServiceType);

        DoctorName = new JLabel("Dr name:");
        DoctorName.setBounds(615, 220, 200, 40);
        DoctorName.setFont(f);
        panel1.add(DoctorName);

        Title = new JLabel("Clinic Management");
        Title.setBounds(550, 20, 300, 50);
        Title.setFont(new Font("Arial", Font.BOLD, 30));
        panel1.add(Title);

        Search = new JLabel("Search");
        Search.setBounds(1200, 60, 150, 30);
        Search.setFont(f);
        panel1.add(Search);

       
        Test = new JRadioButton("Test");
        Test.setBounds(730, 155, 100, 50);
        Test.setFont(f2);
        Test.setForeground(Color.BLACK);
        Test.setSelected(true);
        Test.setOpaque(false);  
        panel1.add(Test);

        Operation = new JRadioButton("Operation");
        Operation.setBounds(815, 155, 180, 50);
        Operation.setFont(f2);
        Operation.setForeground(Color.BLACK); 
        Operation.setOpaque(false); 
        panel1.add(Operation);

        grp = new ButtonGroup();
        grp.add(Test);
        grp.add(Operation);

       
        tPatientName = new JTextField();
        tPatientName.setBounds(200, 100, 250, 30);
        tPatientName.setFont(f);
        panel1.add(tPatientName);

        tAge = new JTextField();
        tAge.setBounds(200, 350, 250, 30);
        tAge.setFont(f);
        panel1.add(tAge);

        tWeight = new JTextField();
        tWeight.setBounds(200, 150, 250, 30);
        tWeight.setFont(f);
        panel1.add(tWeight);
        
        String [] sex={"Male", "Female", "Other"};
        comboSex = new JComboBox(sex);
        comboSex.setBounds(200, 200, 250, 30);
        comboSex.setFont(f);
        panel1.add(comboSex);

        passPatientID = new JPasswordField();
        passPatientID.setBounds(200, 250, 250, 30);
        passPatientID.setFont(f);
        passPatientID.setEchoChar('$');
        panel1.add(passPatientID);

        tServiceName = new JTextField();
        tServiceName.setBounds(200, 300, 250, 30);
        tServiceName.setFont(f);
        panel1.add(tServiceName);

        tCost = new JTextField();
        tCost.setBounds(708, 102, 200, 30);
        tCost.setFont(f);
        panel1.add(tCost);

        tDoctorName = new JTextField();
        tDoctorName.setBounds(708, 228, 200, 30);
        tDoctorName.setFont(f);
        panel1.add(tDoctorName);

        tSearch = new JTextField();
        tSearch.setBounds(1150, 103, 150, 30);
        tSearch.setFont(f);
        tSearch.addKeyListener(this);
        panel1.add(tSearch);

        
        String[] option = {"Test", "Operation", "All"};
        Type = new JComboBox(option);
        Type.setBounds(760, 320, 150, 50);
        Type.setFont(f);
        panel1.add(Type);

        Service = new JComboBox();
        Service.setBounds(920, 320, 200, 50);
        Service.setFont(f);
        panel1.add(Service);

        Doctor = new JComboBox();
        Doctor.setBounds(1150, 320, 150, 50);
        Doctor.setFont(f);
        panel1.add(Doctor);

       
        Add = new JButton("Add");
        Add.setBounds(500, 100, 87, 40);
        Add.setFont(f);
        panel1.add(Add);

        Update = new JButton("Update");
        Update.setBounds(500, 160, 90, 40);
        Update.setFont(f);
        panel1.add(Update);

        Delete = new JButton("Delete");
        Delete.setBounds(500, 220, 90, 40);
        Delete.setFont(f);
        panel1.add(Delete);

        Clear = new JButton("Clear");
        Clear.setBounds(500, 280, 90, 40);
        Clear.setFont(f);
        panel1.add(Clear);

        ShowPass = new JButton("👁");
        ShowPass.setBounds(450, 240, 40, 40);
        ShowPass.setFocusable(false);
        ShowPass.setMargin(new Insets(0, 0, 0, 0));
        ShowPass.setBorder(null);
        ShowPass.setContentAreaFilled(false);
        panel1.add(ShowPass);

       
        jtb = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(cols);
        jtb.setModel(model);
        jtb.setFont(f);
        jtb.setSelectionBackground(Color.GREEN);
        jtb.setBackground(Color.WHITE);
        jtb.setRowHeight(20);
        jtb.getColumnModel().getColumn(5).setPreferredWidth(170);
        jtb.getColumnModel().getColumn(0).setPreferredWidth(150);
        jtb.getColumnModel().getColumn(8).setPreferredWidth(100);

        scl = new JScrollPane(jtb);
        scl.setBounds(100, 500, 1150, 200);
        panel1.add(scl);

       
        Add.addActionListener(this);
        Update.addActionListener(this);
        Delete.addActionListener(this);
        Clear.addActionListener(this);
        Type.addActionListener(this);
        ShowPass.addActionListener(this);
        Service.addActionListener(this);
        Doctor.addActionListener(this);

        jtb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int n = jtb.getSelectedRow();
                if (n >= 0) {
                    tPatientName.setText(model.getValueAt(n, 0).toString());
                    tAge.setText(model.getValueAt(n, 1).toString());
                    tWeight.setText(model.getValueAt(n, 2).toString());
                    comboSex.setSelectedItem(model.getValueAt(n, 3).toString());
                    passPatientID.setText(model.getValueAt(n, 4).toString());
                    tServiceName.setText(model.getValueAt(n, 5).toString());
                    tCost.setText(model.getValueAt(n, 6).toString());
                    if ("Test".equals(model.getValueAt(n, 7))){
                        Test.setSelected(true);
                    }
                    else{
                        Operation.setSelected(true);
                    }
                    tDoctorName.setText(model.getValueAt(n, 8).toString());
                }
            }
        });

        reload();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Add) {
            write();
            reload();
        } 
        else if (ae.getSource() == Update) {
            int n = jtb.getSelectedRow();
            if (n >= 0) {
                
                String type="Test";
                String patientName = tPatientName.getText();
                float age = Float.parseFloat(tAge.getText());
                float weight = Float.parseFloat(tWeight.getText());
                String sex = (String) comboSex.getSelectedItem();
                String patientId = passPatientID.getText(); 
                String serviceName = tServiceName.getText();
                float cost = Float.parseFloat(tCost.getText());
                if(Operation.isSelected()){
                    type="Operation";
                }
                String doctorName = tDoctorName.getText();

                Service s = serviceList.update(patientId); 
                if (s != null) {
                    s.setPatientName(patientName);
                    s.setAge(age);
                    s.setWeight(weight);
                    s.setSex(sex);
                    s.setServiceName(serviceName);
                    s.setCost(cost);
                    s.setServiceType(type);
                    s.setDoctorName(doctorName);
                }

                ServiceIO.updateServiceIO(serviceList); 

                model.setValueAt(patientName, n, 0);
                model.setValueAt(age, n, 1);
                model.setValueAt(weight, n, 2);
                model.setValueAt(sex, n, 3);
                model.setValueAt(patientId, n, 4);
                model.setValueAt(serviceName, n, 5);
                model.setValueAt(cost, n, 6);
                model.setValueAt(type, n, 7);
                model.setValueAt(doctorName, n, 8);

            } else {
                JOptionPane.showMessageDialog(null, "Please select a row to update.");
            }
           // jtb.setSelectionBackground(null);
        }
        else if (ae.getSource() == Delete) {
            int n = jtb.getSelectedRow();
            if (n >= 0) {
                serviceList.delete(model.getValueAt(n, 4).toString()); 
                model.removeRow(n);
                ServiceIO.updateServiceIO(serviceList); 
            } 
            else {
                JOptionPane.showMessageDialog(null, "Please select a row to delete.");
            }
        }
        else if (ae.getSource() == Clear) {

            tPatientName.setText("");
            tAge.setText("");
            tWeight.setText("");
            comboSex.setSelectedIndex(0);
            passPatientID.setText("");
            tServiceName.setText("");
            tCost.setText("");
            tDoctorName.setText("");

        }
        else if (ae.getSource() == Type) {

            String selected = (String) Type.getSelectedItem();
            Service.removeAllItems();
            if ("Test".equals(selected)) {
                for (String t : TEST){ 
                Service.addItem(t);
                }
            } 
            else if ("Operation".equals(selected)) {
                for (String o : OPERATION){
                 Service.addItem(o);
                }
            } 
            else if ("All".equals(selected)) {
                for (String t : TEST){
                 Service.addItem(t);
                }
                for (String o : OPERATION){
                 Service.addItem(o);
                }
            }
        } 
        else if (ae.getSource() == ShowPass) {
            if (isPasswordVisible) {
                passPatientID.setEchoChar('$');
                isPasswordVisible = false;
            } 
            else
             {
                passPatientID.setEchoChar((char) 0);
                isPasswordVisible = true;
            }
        } 
        else if (ae.getSource() == Service) {
            String selected = (String) Service.getSelectedItem();
            if (selected != null) {
                tServiceName.setText(selected);
                Doctor.removeAllItems();

                if ("BLOOD TEST".equals(selected)) {
                            tCost.setText("2000 ");
                            for (String b : blood) {
                                Doctor.addItem(b);
                            }
                        } 
                        else if ("URINE TEST".equals(selected)) {
                            tCost.setText("1500 ");
                            for (String u : urine) {
                                Doctor.addItem(u);
                            }
                        } 
                        else if ("TSH TEST".equals(selected)) {
                            tCost.setText("4500 ");
                            for (String t : tsh) {
                                Doctor.addItem(t);
                            }
                        } 
                        else if ("APENDIS OPERATION".equals(selected)) {
                            tCost.setText("40000 ");
                            for (String a : apendis) {
                                Doctor.addItem(a);
                            }
                        } 
                        else if ("EYE OPERATION".equals(selected)) {
                            tCost.setText("80000 ");
                            for (String e : eye) {
                                Doctor.addItem(e);
                            }
                        } 
                        else if ("LEG OPERATION".equals(selected)) {
                            tCost.setText("55000 ");
                            for (String l : leg) {
                                Doctor.addItem(l);
                            }
                        } 
                        else if ("HEART OPERATION".equals(selected)) {
                            tCost.setText("150000 ");
                            for (String h : heart) {
                                Doctor.addItem(h);
                            }
}
            }
        } 
        else if(ae.getSource()==Doctor){
            String selected=(String) Doctor.getSelectedItem();
            if(selected!=null){
                tDoctorName.setText(selected); 
            }
        }
    }

    private void write() {
        try {
            String type="Test";
            if(Operation.isSelected()){
                type="Operation";
            }
            Service s = new Service(
                tDoctorName.getText(),                     
                passPatientID.getText(),                      
                tPatientName.getText(),                 
                Float.parseFloat(tAge.getText()),
                Float.parseFloat(tWeight.getText()), 
                (String) comboSex.getSelectedItem(),  
                tServiceName.getText(),                     
                Float.parseFloat(tCost.getText()),
                type
            );
            ServiceIO.writeServiceIO(s);
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid! Some Information Is Missing");
        }
    }

    private void reload() {
        model.setRowCount(0);
        serviceList = new ServiceList(100);
        ServiceIO.readServiceIO(serviceList);
        int i = 0;
        while (serviceList.get(i) != null) {
            rows[0] = serviceList.get(i).getPatientName();
            rows[1] = String.valueOf(serviceList.get(i).getAge());
            rows[2] = String.valueOf(serviceList.get(i).getWeight());
            rows[3] = serviceList.get(i).getSex();
            rows[4] = serviceList.get(i).getPatientId();
            rows[5] = serviceList.get(i).getServiceName();
            rows[6] = String.valueOf(serviceList.get(i).getCost());
            rows[7] = serviceList.get(i).getServiceType();
            rows[8] = serviceList.get(i).getDoctorName();
            model.addRow(rows);
            i++;
        }
    }

 @Override
public void keyTyped(KeyEvent e){

}

@Override
public void keyPressed(KeyEvent e){

}

@Override
public void keyReleased(KeyEvent e) {
    if (e.getSource() == tSearch) {
        String searchText = tSearch.getText().toLowerCase();
        model.setRowCount(0);
        int i = 0;
        while (serviceList.get(i) != null) {
            if (serviceList.get(i).getServiceDetails().toLowerCase().contains(searchText)) {
                rows[0] = serviceList.get(i).getPatientName();
                rows[1] = String.valueOf(serviceList.get(i).getAge());
                rows[2] = String.valueOf(serviceList.get(i).getWeight());
                rows[3] = serviceList.get(i).getSex();
                rows[4] = serviceList.get(i).getPatientId();
                rows[5] = serviceList.get(i).getServiceName();
                rows[6] = String.valueOf(serviceList.get(i).getCost());
                rows[7] = serviceList.get(i).getServiceType();
                rows[8] = serviceList.get(i).getDoctorName();
                model.addRow(rows);
            }
            i++;
        }
    }
}

}

