/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package pl.polsl.adam.fudala.tvprog.view;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import pl.polsl.adam.fudala.tvprog.controller.MainFrame;
import pl.polsl.adam.fudala.tvprog.model.Channel;
import pl.polsl.adam.fudala.tvprog.model.Program;
import pl.polsl.adam.fudala.tvprog.model.Time;

/**
 * Class displays data about programs in a form of table
 *
 * @author Adam Fudala
 * @version 3.0
 */
public class TableView extends javax.swing.JInternalFrame {

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
     * Creates new form TableView
     *
     * @param channel channel with program list
     * @param mainFrame main frame
     */
    public TableView(Channel channel, MainFrame mainFrame) {
        super("Channel view",
                true, //changable size
                true, //can be closed
                true, //can be maximized 
                true);//can be minimized
        setChannel(channel);
        setMainFrame(mainFrame);
        programList = channel.getProgramList();
        Vector<Vector<String>> rowData = new Vector<Vector<String>>();
        Time time;
        for (Program program : programList) {
            Vector<String> row = new Vector();
            row.add(program.getName());
            time = program.getTime();
            row.add(time.getDayOfWeek());
            row.add(Integer.toString(time.getHour()));
            row.add(Integer.toString(time.getMinute()));
            row.add(program.getRating().toString());
            rowData.add(row);
        }
        Vector columnNames = new Vector<>();
        columnNames.addAll(Arrays.asList("Name", "Day", "Hour", "Minute", "Rating"));

        jScrollPane1 = new javax.swing.JScrollPane();
        programTable = new javax.swing.JTable();

        jScrollPane1 = new javax.swing.JScrollPane();
        programTable = new javax.swing.JTable();

        programTable.setModel(new javax.swing.table.DefaultTableModel(
                rowData,
                columnNames
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        jScrollPane1.setViewportView(programTable);
        if (programTable.getColumnModel().getColumnCount() > 0) {
            programTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            programTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jScrollPane1 = new javax.swing.JScrollPane();
        programTable = new javax.swing.JTable();

        programTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Day", "Hour", "Minute", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(programTable);
        if (programTable.getColumnModel().getColumnCount() > 0) {
            programTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable programTable;
    // End of variables declaration//GEN-END:variables
}
