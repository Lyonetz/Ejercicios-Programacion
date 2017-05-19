/*
 * Created by JFormDesigner on Thu May 18 12:08:53 CEST 2017
 */

package QuinielaGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Carlos Javier LeÃ³n
 */
public class Quiniela extends JFrame {
    public Quiniela() {

        initComponents();
        generarEncuentros(generarEquipos());
        generarResultados();
    }

    private void btnGenerarActionPerformed(ActionEvent e) {
        generarEncuentros(generarEquipos());
        generarResultados();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Carlos Javier LeÃ³n
        P1 = new JLabel();
        R1 = new JLabel();
        S1 = new JLabel();
        P2 = new JLabel();
        R2 = new JLabel();
        S2 = new JLabel();
        P3 = new JLabel();
        R3 = new JLabel();
        S3 = new JLabel();
        P4 = new JLabel();
        R4 = new JLabel();
        S4 = new JLabel();
        P5 = new JLabel();
        R5 = new JLabel();
        S5 = new JLabel();
        P6 = new JLabel();
        R6 = new JLabel();
        S6 = new JLabel();
        P7 = new JLabel();
        R7 = new JLabel();
        S7 = new JLabel();
        P8 = new JLabel();
        R8 = new JLabel();
        S8 = new JLabel();
        P9 = new JLabel();
        R9 = new JLabel();
        S9 = new JLabel();
        P10 = new JLabel();
        R10 = new JLabel();
        S10a = new JLabel();
        label1 = new JLabel();
        S10b = new JLabel();
        btnGenerar = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[40,fill]" +
            "[fill]" +
            "[40,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- P1 ----
        P1.setText("text");
        P1.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(P1, "cell 0 0");

        //---- R1 ----
        R1.setText("text");
        R1.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(R1, "cell 2 0");

        //---- S1 ----
        S1.setText("text");
        contentPane.add(S1, "cell 4 0");

        //---- P2 ----
        P2.setText("text");
        P2.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(P2, "cell 0 1");

        //---- R2 ----
        R2.setText("text");
        R2.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(R2, "cell 2 1");

        //---- S2 ----
        S2.setText("text");
        contentPane.add(S2, "cell 4 1");

        //---- P3 ----
        P3.setText("text");
        P3.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(P3, "cell 0 2");

        //---- R3 ----
        R3.setText("text");
        R3.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(R3, "cell 2 2");

        //---- S3 ----
        S3.setText("text");
        contentPane.add(S3, "cell 4 2");

        //---- P4 ----
        P4.setText("text");
        P4.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(P4, "cell 0 3");

        //---- R4 ----
        R4.setText("text");
        R4.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(R4, "cell 2 3");

        //---- S4 ----
        S4.setText("text");
        contentPane.add(S4, "cell 4 3");

        //---- P5 ----
        P5.setText("text");
        P5.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(P5, "cell 0 4");

        //---- R5 ----
        R5.setText("text");
        R5.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(R5, "cell 2 4");

        //---- S5 ----
        S5.setText("text");
        contentPane.add(S5, "cell 4 4");

        //---- P6 ----
        P6.setText("text");
        P6.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(P6, "cell 0 5");

        //---- R6 ----
        R6.setText("text");
        R6.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(R6, "cell 2 5");

        //---- S6 ----
        S6.setText("text");
        contentPane.add(S6, "cell 4 5");

        //---- P7 ----
        P7.setText("text");
        P7.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(P7, "cell 0 6");

        //---- R7 ----
        R7.setText("text");
        R7.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(R7, "cell 2 6");

        //---- S7 ----
        S7.setText("text");
        contentPane.add(S7, "cell 4 6");

        //---- P8 ----
        P8.setText("text");
        P8.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(P8, "cell 0 7");

        //---- R8 ----
        R8.setText("text");
        R8.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(R8, "cell 2 7");

        //---- S8 ----
        S8.setText("text");
        contentPane.add(S8, "cell 4 7");

        //---- P9 ----
        P9.setText("text");
        P9.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(P9, "cell 0 8");

        //---- R9 ----
        R9.setText("text");
        R9.setHorizontalTextPosition(SwingConstants.CENTER);
        contentPane.add(R9, "cell 2 8");

        //---- S9 ----
        S9.setText("text");
        contentPane.add(S9, "cell 4 8");

        //---- P10 ----
        P10.setText("text");
        contentPane.add(P10, "cell 0 11");

        //---- R10 ----
        R10.setText("text");
        contentPane.add(R10, "cell 2 11");

        //---- S10a ----
        S10a.setText("text");
        contentPane.add(S10a, "cell 4 11");

        //---- label1 ----
        label1.setText("-");
        contentPane.add(label1, "cell 5 11");

        //---- S10b ----
        S10b.setText("text");
        contentPane.add(S10b, "cell 6 11");

        //---- btnGenerar ----
        btnGenerar.setText("Generar nueva");
        btnGenerar.addActionListener(e -> btnGenerarActionPerformed(e));
        contentPane.add(btnGenerar, "cell 8 14");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private ArrayList<String> generarEquipos() {
        ArrayList<String> arrayEquipos = new ArrayList<>();
        String[] vectorEquipos;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("/home/carlos/IdeaProjects/Ejercicios-Programacion/src/QuinielaGUI/equipos.txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        try{
            vectorEquipos = br.readLine().split(";");

            for(int i = 0; i < vectorEquipos.length; i++) {
                arrayEquipos.add(vectorEquipos[i]);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        return arrayEquipos;
    }

    private void generarEncuentros(ArrayList<String> arrayList) {
        Random rnd = new Random();
        int tmp;

        while(!arrayList.isEmpty()) {
            for(int i = 1; i <= 20; i++) {
                switch(i) {
                    case 1:
                        tmp = rnd.nextInt(arrayList.size());
                        P1.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 2:
                        tmp = rnd.nextInt(arrayList.size());
                        P2.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 3:
                        tmp = rnd.nextInt(arrayList.size());
                        P3.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 4:
                        tmp = rnd.nextInt(arrayList.size());
                        P4.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 5:
                        tmp = rnd.nextInt(arrayList.size());
                        P5.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 6:
                        tmp = rnd.nextInt(arrayList.size());
                        P6.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 7:
                        tmp = rnd.nextInt(arrayList.size());
                        P7.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 8:
                        tmp = rnd.nextInt(arrayList.size());
                        P8.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 9:
                        tmp = rnd.nextInt(arrayList.size());
                        P9.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 10:
                        tmp = rnd.nextInt(arrayList.size());
                        P10.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 11:
                        tmp = rnd.nextInt(arrayList.size());
                        R1.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 12:
                        tmp = rnd.nextInt(arrayList.size());
                        R2.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 13:
                        tmp = rnd.nextInt(arrayList.size());
                        R3.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 14:
                        tmp = rnd.nextInt(arrayList.size());
                        R4.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 15:
                        tmp = rnd.nextInt(arrayList.size());
                        R5.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 16:
                        tmp = rnd.nextInt(arrayList.size());
                        R6.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 17:
                        tmp = rnd.nextInt(arrayList.size());
                        R7.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 18:
                        tmp = rnd.nextInt(arrayList.size());
                        R8.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 19:
                        tmp = rnd.nextInt(arrayList.size());
                        R9.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                    case 20:
                        tmp = rnd.nextInt(arrayList.size());
                        R10.setText(arrayList.get(tmp));
                        arrayList.remove(tmp);
                        break;
                }
            }
        }
    }
    private void generarResultados() {
        Random rnd = new Random();
        int tmp;

        for(int i = 1; i <= 10; i++) {
            switch(i) {
                case 1:
                    tmp = rnd.nextInt(3);
                    if(tmp == 0) {
                        S1.setText("X");
                    } else {
                        S1.setText(String.valueOf(tmp));
                    }
                    break;
                case 2:
                    tmp = rnd.nextInt(3);
                    if(tmp == 0) {
                        S2.setText("X");
                    } else {
                        S2.setText(String.valueOf(tmp));
                    }
                    break;
                case 3:
                    tmp = rnd.nextInt(3);
                    if(tmp == 0) {
                        S3.setText("X");
                    } else {
                        S3.setText(String.valueOf(tmp));
                    }
                    break;
                case 4:
                    tmp = rnd.nextInt(3);
                    if(tmp == 0) {
                        S4.setText("X");
                    } else {
                        S4.setText(String.valueOf(tmp));
                    }
                    break;
                case 5:
                    tmp = rnd.nextInt(3);
                    if(tmp == 0) {
                        S5.setText("X");
                    } else {
                        S5.setText(String.valueOf(tmp));
                    }
                    break;
                case 6:
                    tmp = rnd.nextInt(3);
                    if(tmp == 0) {
                        S6.setText("X");
                    } else {
                        S6.setText(String.valueOf(tmp));
                    }
                    break;
                case 7:
                    tmp = rnd.nextInt(3);
                    if(tmp == 0) {
                        S7.setText("X");
                    } else {
                        S7.setText(String.valueOf(tmp));
                    }
                    break;
                case 8:
                    tmp = rnd.nextInt(3);
                    if(tmp == 0) {
                        S8.setText("X");
                    } else {
                        S8.setText(String.valueOf(tmp));
                    }
                    break;
                case 9:
                    tmp = rnd.nextInt(3);
                    if(tmp == 0) {
                        S9.setText("X");
                    } else {
                        S9.setText(String.valueOf(tmp));
                    }
                    break;
                case 10:
                    tmp = rnd.nextInt(4);
                    if(tmp == 3) {
                        S10a.setText("M");
                    } else {
                        S10a.setText(String.valueOf(tmp));
                    }

                    tmp = rnd.nextInt(4);
                    if(tmp == 3) {
                        S10b.setText("M");
                    } else {
                        S10b.setText(String.valueOf(tmp));
                    }

            }
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Carlos Javier LeÃ³n
    private JLabel P1;
    private JLabel R1;
    private JLabel S1;
    private JLabel P2;
    private JLabel R2;
    private JLabel S2;
    private JLabel P3;
    private JLabel R3;
    private JLabel S3;
    private JLabel P4;
    private JLabel R4;
    private JLabel S4;
    private JLabel P5;
    private JLabel R5;
    private JLabel S5;
    private JLabel P6;
    private JLabel R6;
    private JLabel S6;
    private JLabel P7;
    private JLabel R7;
    private JLabel S7;
    private JLabel P8;
    private JLabel R8;
    private JLabel S8;
    private JLabel P9;
    private JLabel R9;
    private JLabel S9;
    private JLabel P10;
    private JLabel R10;
    private JLabel S10a;
    private JLabel label1;
    private JLabel S10b;
    private JButton btnGenerar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
