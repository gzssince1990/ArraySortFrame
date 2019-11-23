package org.ge.arraysortframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 11/11/2014.
 */
public class ArraySortPanel extends JPanel {
    int[] ar;
    ArraySort as = new ArraySort();
    JLabel[] arLabel;
    JButton bs,ss,ds;
    JPanel upper;

    boolean visible = false;

    ArraySortPanel(int size){

        this.setPreferredSize(new Dimension(250,360));

        ar = new int[size];
        as.fillArray(ar);
        arLabel= new JLabel[ar.length];

        upper = new JPanel();

        GridLayout grid = new GridLayout(10,10,10,10);
        upper.setLayout(grid);
        for (int i=0; i<arLabel.length; i++){
            arLabel[i] = new JLabel(Integer.toString(i),JLabel.CENTER);
            arLabel[i].setBackground(Color.RED);
            upper.add(arLabel[i]);
        }

        //buttons
        bs = new JButton("bubble sort");
        ss = new JButton("selection sort");
        ds = new  JButton("disorder array");

        ds.addActionListener(new dsListener());
        bs.addActionListener(new bsListener());
        ss.addActionListener(new ssListener());

        JPanel ctrl = new JPanel();
        GridLayout ctrlLabel = new GridLayout(3,1,10,10);
        ctrl.setLayout(ctrlLabel);

        ctrl.add(bs);
        ctrl.add(ss);
        ctrl.add(ds);

        this.add(upper);
        this.add(ctrl);


        setVisible(visible);
    }

    void changeVisible(){
        visible = !visible;
        this.setVisible(visible);
    }

    void setLabel(){
        for (int i=0; i<arLabel.length; i++) {
            arLabel[i].setText(Integer.toString(ar[i]));
            if (ar[i]==i)
                arLabel[i].setOpaque(false);
            else
                arLabel[i].setOpaque(true);
        }
    }

    void resetPanel(){
        as.fillArray(ar);
        setLabel();
    }

    class dsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = as.disorderArray(ar);

            arLabel[i].setText(Integer.toString(ar[i]));
            if (ar[i]==i)
                arLabel[i].setOpaque(false);
            else
                arLabel[i].setOpaque(true);

            arLabel[ar[i]].setText(Integer.toString(ar[ar[i]]));
            if (ar[ar[i]]==ar[i])
                arLabel[ar[i]].setOpaque(false);
            else
                arLabel[ar[i]].setOpaque(true);
        }
    }

    class bsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            as.bubbleSort(ar);
            setLabel();
        }
    }

    class ssListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            as.selectionSort(ar);
            setLabel();
        }
    }
}
