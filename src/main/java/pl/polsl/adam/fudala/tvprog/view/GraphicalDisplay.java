/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package pl.polsl.adam.fudala.tvprog.view;

import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import pl.polsl.adam.fudala.tvprog.controller.MainFrame;
import pl.polsl.adam.fudala.tvprog.model.Channel;
import pl.polsl.adam.fudala.tvprog.model.Program;
import pl.polsl.adam.fudala.tvprog.model.Time;

/**
 * Class displays programs in combo box form and lets user rate a program
 *
 * @author Adam Fudala
 * @version 3.0
 */
public class GraphicalDisplay extends javax.swing.JInternalFrame {

    /**
     * channel where list of programs is stored
     */
    Channel channel;
    /**
     * main frame where data are passed
     */
    MainFrame mainFrame;
    /**
     * list of programs
     */
    List<Program> programList;
    /**
     * selected program on list
     */
    Program foundProgram;

    /**
     * vector of program names
     */
    /**
     * channel getter
     *
     * @return channel
     */
    public Channel getChannel() {
        return channel;
    }

    /**
     * channel setter
     *
     * @param channel channel with program list
     */
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    /**
     * main frame getter
     *
     * @return main frame
     */
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * main frame setter
     *
     * @param mainFrame main frame
     */
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * creates new form GraphicalDisplay
     *
     * @param channel channel with program list
     * @param mainFrame main frame
     */
    public GraphicalDisplay(Channel channel, MainFrame mainFrame) {
        super("Channel view",
                true, //changable size
                true, //can be closed
                true, //can be maximized 
                true);//can be minimized
        setChannel(channel);
        setMainFrame(mainFrame);
        programList = channel.getProgramList();
        Vector<String> programs = new Vector();
        for (Program program : programList) {
            String name = program.getName();
            programs.add(name);
        }
        programBox = new JComboBox(programs);
        programBox.setSelectedIndex(0);
        programBox = new javax.swing.JComboBox<>();
        timeInfo = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rateButton = new javax.swing.JButton();
        rate = new javax.swing.JLabel();

        programBox.setModel(new javax.swing.DefaultComboBoxModel<>(programs));
        programBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programBoxActionPerformed(evt);
            }
        });
        foundProgram = channel.findProgramByName(programBox.getItemAt(0));
        Time time = foundProgram.getTime();
        String info;
        if (time.getMinute() > 10) {
                info = "Watch on " + time.getDayOfWeek() + " at " + time.getHour() + ":" + time.getMinute();
            } else {
                info = "Watch on " + time.getDayOfWeek() + " at " + time.getHour() + ":0" + time.getMinute();
            }
            timeInfo.setText(info);

        timeInfo.setText(info);

        jLabel1.setText(":(");

        jLabel2.setText(":)");

        rateButton.setText("rate");

        rateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateButtonActionPerformed(evt);
            }
        });

        rate.setText(foundProgram.getRating().toString());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(160, 160, 160)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(programBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(rate)
                                                                .addComponent(timeInfo))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel1)
                                                .addGap(35, 35, 35)
                                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(156, 156, 156)
                                                .addComponent(rateButton)))
                                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(programBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(rate)
                                .addGap(18, 18, 18)
                                .addComponent(timeInfo)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rateButton)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        programList = channel.getProgramList();
        Vector<String> programs = new Vector();
        for (Program program : programList) {
            String name = program.getName();
            programs.add(name);
        }
        programBox = new JComboBox(programs);
        ;
        timeInfo = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rateButton = new javax.swing.JButton();
        rate = new javax.swing.JLabel();

        programBox.setSelectedIndex(0);
        programBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        programBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programBoxActionPerformed(evt);
            }
        });

        timeInfo.setText("jLabel1");

        jLabel1.setText(":(");

        jLabel2.setText(":)");

        rateButton.setText("rate");
        rateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateButtonActionPerformed(evt);
            }
        });

        rate.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(programBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rate)
                                .addComponent(timeInfo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(rateButton)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(programBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(rate)
                .addGap(18, 18, 18)
                .addComponent(timeInfo)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rateButton)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method called when combo box changes state, it updates foundProgram and
     * info label
     *
     * @param evt event of choosing in combo box
     */
    private void programBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String programName = (String) cb.getSelectedItem();
        foundProgram = new Program();
        for (Program program : programList) {
            if (program.getName().equals(programName)) {
                foundProgram = program;
                break;
            }
        }
        Time time = foundProgram.getTime();
        String info;
        if (time.getMinute() > 10) {
            info = "Watch on " + time.getDayOfWeek() + " at " + time.getHour() + ":" + time.getMinute();
        } else {
            info = "Watch on " + time.getDayOfWeek() + " at " + time.getHour() + ":0" + time.getMinute();
        }

        timeInfo.setText(info);
        rate.setText(foundProgram.getRating().toString());
    }//GEN-LAST:event_programBoxActionPerformed

    /**
     * Method called when rate button is clicke, it changes selected programs's
     * rating based on slider value
     *
     * @param evt event of clicking button
     */
    private void rateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateButtonActionPerformed

        String programName = foundProgram.getName();
        String rating;
        if (jSlider1.getValue() < 30) {
            rating = "BAD";
        } else if (jSlider1.getValue() > 70) {
            rating = "GOOD";
        } else {
            rating = "NEUTRAL";
        }
        mainFrame.updateRating(programName, rating);
        rate.setText(rating);
        //mainFrame.setVisible(true);
        //dispose();


    }//GEN-LAST:event_rateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JComboBox<String> programBox;
    private javax.swing.JLabel rate;
    private javax.swing.JButton rateButton;
    private javax.swing.JLabel timeInfo;
    // End of variables declaration//GEN-END:variables

}
