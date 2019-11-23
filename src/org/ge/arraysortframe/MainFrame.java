package org.ge.arraysortframe;

import javafx.geometry.VerticalDirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 11/11/2014.
 */
public class MainFrame extends JFrame{

    ArraySortPanel aArray,bArray;
    JButton comButton, aArryButton,bArryButton,resetButton,copyButton;
    JLabel result;

    MainFrame(){
        super("ArraySort");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300,300,300,300);

        JPanel controlPanel = new JPanel();
        GridLayout controlGrid = new GridLayout(1,6,10,10);
        controlPanel.setLayout(controlGrid);
        comButton = new JButton("compare");
        aArryButton = new JButton("A");
        bArryButton = new JButton("B");
        resetButton = new JButton("reset");
        copyButton = new JButton("copy");
        result = new JLabel("     ",SwingConstants.CENTER);
        controlPanel.add(comButton);
        controlPanel.add(result);
        controlPanel.add(copyButton);
        controlPanel.add(aArryButton);
        controlPanel.add(bArryButton);
        controlPanel.add(resetButton);

        aArryButton.addActionListener(new AListener());
        bArryButton.addActionListener(new BListener());
        resetButton.addActionListener(new resetListener());
        comButton.addActionListener(new comListener());
        copyButton.addActionListener(new copyListener());

        aArray = new ArraySortPanel(100);
        bArray = new ArraySortPanel(100);

        JPanel arrayPanel = new JPanel();

        GridLayout mainGrid = new GridLayout(1,2,10,10);
        arrayPanel.setLayout(mainGrid);
        arrayPanel.add(aArray);
        arrayPanel.add(bArray);

        JPanel pane = new JPanel();
        BoxLayout box = new BoxLayout(pane,BoxLayout.Y_AXIS);
        pane.setLayout(box);
        pane.add(controlPanel);
        pane.add(arrayPanel);

        getContentPane().add(pane);

        pack();
        setVisible(true);
    }

    class AListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            aArray.changeVisible();

        }
    }

    class BListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            bArray.changeVisible();

        }
    }

    class resetListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            aArray.resetPanel();
            bArray.resetPanel();
            result.setText("     ");

            aArray.setVisible(aArray.visible = false);
            bArray.setVisible(bArray.visible = false);
        }
    }

    class comListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ArraySort com = new ArraySort();
            if (com.compareArrays(aArray.ar,bArray.ar))
                result.setText("same");
            else
                result.setText("different");
        }
    }

    class copyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ArraySort copy = new ArraySort();
            copy.copyArray(aArray.ar,bArray.ar);
            bArray.setLabel();
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
