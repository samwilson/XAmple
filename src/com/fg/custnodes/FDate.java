package com.fg.custnodes;

/*
 * Copyright (c) 2003 Felix Golubov
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import lt.monarch.swing.*;
import com.fg.ftreenodes.Params;
import com.fg.ftreenodes.ICellControl;
import com.fg.xmleditor.FXBasicView;

/**
 * FDate is a simple extension of the trial version of the
 * lt.monarch.swing.JDateField component, which can be used as a custom field
 * editor for the {@link com.fg.xmleditor.FXBasicView}.
 * The FDate component uses MonarchDate - Release 1.2 mdate.jar package.
 * The most recent version of MonarchDate can be downloaded from:
 * <a href="http://www.singleton-labs.com/downloads.php">
 * http://www.singleton-labs.com/downloads.php</a>
 *
 * @author Felix Golubov
 * @version 2.0
 */

public class FDate extends JDateField
  implements ICellControl, ActionListener, KeyListener
{
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public FDate()
  {
    super();
    setPreferredSize(new Dimension(100, 20));
    setEditable(new SimpleDateFormat("yyyy-MM-dd"));
    setEmptyChar('_');
  }

  public void initCellControl(boolean isEditor)
  {
    if (isEditor)
    {
      getPopupCalendar().addActionListener(this);
      getEditor().addKeyListener(this);
    }
  }

  public void updateCellControl(boolean isEditor, boolean enabled,
    boolean editable, Object data, Params params)
  {
    setEnabled(enabled && editable);
    Date d = null;
    try {
      d = sdf.parse(data.toString());
    } catch (Exception ex) {}
    setDate(d);
  }

  public Object getData()
  {
    Date d = null;
    try {
      d = (Date)getEditableValue().a();
    } catch (Exception ex) {}
    return (d != null) ? sdf.format(d) : "";
  }

  public void actionPerformed(ActionEvent e)
  {
    FXBasicView.stopCellEditing(this);
  }

  public void keyTyped(KeyEvent e)
  {
  }

  public void keyPressed(KeyEvent e)
  {
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_ENTER)
      FXBasicView.stopCellEditing(this);
    else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
      FXBasicView.cancelCellEditing(this);
    else
      FXBasicView.cellEditorValueChanged(this, e);
  }

}
