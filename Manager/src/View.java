import javax.swing.*;
import java.awt.*;

class View {


    public static void main(String args[]) {
    //public void createDisplay() {
        String[] foodArr = {"Burger", "Pancakes", "bla bla", "neki food"};
        //Creating the Frame
        JFrame frame = new JFrame("Diet Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);

      //Creating the MenuBar and adding components
//        JMenuBar mb = new JMenuBar();
//        JMenu m1 = new JMenu("FILE");
//        JMenu m2 = new JMenu("Help");
//        mb.add(m1);
//        mb.add(m2);
//        JMenuItem m11 = new JMenuItem("Open");
//        JMenuItem m22 = new JMenuItem("Save as");
//        m1.add(m11);
//        m1.add(m22);

        JPanel foodPanel = new JPanel(); // the panel is not visible in output
        JLabel namejl = new JLabel("Food name");
        JTextField nametf = new JTextField(10);
        JLabel caljl = new JLabel("Calories");
        JTextField caltf = new JTextField(10);
        JLabel fatjl = new JLabel("Fat");
        JTextField fattf = new JTextField(10);
        JLabel carbjl = new JLabel("Carbs");
        JTextField carbtf = new JTextField(10);
        JLabel proteinjl = new JLabel("Proteins");
        JTextField proteintf = new JTextField(10);
        JButton addFoodBtn = new JButton("Add Food");

        foodPanel.add(namejl);
        foodPanel.add(nametf);
        foodPanel.add(caljl);
        foodPanel.add(caltf);
        foodPanel.add(fatjl);
        foodPanel.add(fattf);
        foodPanel.add(carbjl);
        foodPanel.add(carbtf);
        foodPanel.add(proteinjl);
        foodPanel.add(proteintf);
        foodPanel.add(addFoodBtn);

        JPanel calPanel = new JPanel();
        JLabel calGoaljl = new JLabel("Set desired caloric intake");
        JTextField calGoaltf = new JTextField(10);
        JButton calBtn = new JButton("Set");
        calPanel.add(calGoaljl);
        calPanel.add(calGoaltf);
        calPanel.add(calBtn);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label1 = new JLabel("Add meal 1");
        JComboBox jcb1 = new JComboBox(foodArr);
        JLabel label2 = new JLabel("Add meal 2");
        JComboBox jcb2 = new JComboBox(foodArr);
        JLabel label3 = new JLabel("Add meal 3");
        JComboBox jcb3 = new JComboBox(foodArr);
        JButton reset = new JButton("Calculate intake");

        panel.add(label1); // Components Added using Flow Layout
        panel.add(jcb1);
        panel.add(label2);
        panel.add(jcb2);
        panel.add(label3);
        panel.add(jcb3);
        panel.add(reset);


        JPanel infoPanel = new JPanel();
        JLabel jlCal = new JLabel("Cal intake");
        JTextField tfCal = new JTextField(10);
        tfCal.setEditable(false);
        JLabel jlFat = new JLabel("Fat intake");
        JTextField tfFat = new JTextField(10);
        tfFat.setEditable(false);
        JLabel jlCarb = new JLabel("Carb intake");
        JTextField tfCarb = new JTextField(10);
        tfCarb.setEditable(false);
        JLabel jlProtein = new JLabel("Protein intake");
        JTextField tfProtein = new JTextField(10);
        tfProtein.setEditable(false);

        JLabel jlNeeded = new JLabel("To desired cal intake");
        JTextField tfNeeded = new JTextField(10);
        tfNeeded.setEditable(false);

        infoPanel.add(jlCal);
        infoPanel.add(tfCal);
        infoPanel.add(jlFat);
        infoPanel.add(tfFat);
        infoPanel.add(jlCarb);
        infoPanel.add(tfCarb);
        infoPanel.add(jlProtein);
        infoPanel.add(tfProtein);
        infoPanel.add(jlNeeded);
        infoPanel.add(tfNeeded);



        JComboBox jcb = new JComboBox(foodArr);


        JPanel weightPanel = new JPanel(); // the panel is not visible in output
        JLabel labelWeight = new JLabel("Current weight");
        JTextField weightf = new JTextField(5);

        JLabel weightChangejl = new JLabel("Your weight changed");
        JTextField weightChangejtf = new JTextField(5);
        weightChangejtf.setEditable(false);
        JButton jbWeight = new JButton("Set");

        weightPanel.add(labelWeight);
        weightPanel.add(weightf);
        weightPanel.add(jbWeight);
        weightPanel.add(weightChangejl);
        weightPanel.add(weightChangejtf);

        GridLayout grid = new GridLayout(8, 1, 50, 50);
        frame.setLayout(grid);
        frame.add(foodPanel);
        frame.add(jcb);
        frame.add(calPanel);
        frame.add(panel);
        frame.add(infoPanel);
        frame.add(weightPanel);

        frame.setVisible(true);
    }

    public void addFood() {
        //add food to the view
    }
}
