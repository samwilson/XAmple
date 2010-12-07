package com.fg.xample;

/*
 * Copyright (c) 2002 Felix Golubov
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * "About" dialog for the XAmple application.
 *
 * @author Felix Golubov
 * @version 1.0
 */

public class DlgAbout extends JDialog implements ActionListener
{
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel insetsPanel1 = new JPanel();
  JPanel insetsPanel3 = new JPanel();
  JButton button1 = new JButton();
  JLabel label1 = new JLabel();
  JLabel label2 = new JLabel();
  JLabel label3 = new JLabel();
  JLabel label4 = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();
  String product = "XAmple XML Editor";
  String version = "Version 1.0";
  String copyright = "Copyright (c) 2002 Felix Golubov";
  String comments = "Trial edition";
  Border border1;

  public DlgAbout(Frame parent)
  {
    super(parent);
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    pack();
  }

  private void jbInit() throws Exception
  {
    border1 = BorderFactory.createCompoundBorder(
      BorderFactory.createEtchedBorder(Color.white,
      new Color(148, 145, 140)),BorderFactory.createEmptyBorder(20,20,20,20));
    this.setTitle("About");
    setResizable(false);
    panel1.setLayout(borderLayout1);
    panel2.setLayout(borderLayout2);
    gridLayout1.setRows(4);
    gridLayout1.setColumns(1);
    label1.setFont(new java.awt.Font("Dialog", 1, 18));
    label1.setText(product);
    label2.setText(version);
    label3.setText(copyright);
    label4.setText(comments);
    insetsPanel3.setLayout(gridLayout1);
    insetsPanel3.setBorder(border1);
    button1.setText("Ok");
    button1.addActionListener(this);
    this.getContentPane().add(panel1, null);
    insetsPanel3.add(label1, null);
    insetsPanel3.add(label2, null);
    insetsPanel3.add(label3, null);
    insetsPanel3.add(label4, null);
    panel2.add(insetsPanel3, BorderLayout.CENTER);
    insetsPanel1.add(button1, null);
    panel1.add(insetsPanel1, BorderLayout.SOUTH);
    panel1.add(panel2, BorderLayout.NORTH);
  }

  protected void processWindowEvent(WindowEvent e)
  {
    if (e.getID() == WindowEvent.WINDOW_CLOSING)
      dispose();
    super.processWindowEvent(e);
  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == button1)
      dispose();
  }
}
