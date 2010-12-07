package com.fg.xample;

/*
 * Copyright (c) 2002 Felix Golubov
 */

import java.util.*;

/**
 * A helper class for the XAmple application which holds pathes of accessed
 * XSD and XML files.
 *
 * @author Felix Golubov
 * @version 1.0
 */

public class History
{
  public static final int MAX_ITEM_COUNT = 20;
  public static final int MAX_LABEL_LENGTH = 70;

  ArrayList items = null;
  String path;
  String label;

  public History(String path)
  {
    this.path = path.replace('\\', '/');
    label = abbreviatePath(this.path, MAX_LABEL_LENGTH);
  }

  public static String abbreviatePath(String path, int limitLength)
  {
    if (path.length() <= limitLength)
      return path;
    int k = path.indexOf("/", 1);
    if (k < 0)
      return "..." + path.substring(path.length() - limitLength + 3);
    k = path.indexOf("/", k + 1);
    if (k < 0)
      return "..." + path.substring(path.length() - limitLength + 3);
    String prefix = path.substring(0, k + 1);
    String suffix = path.substring(k + 1);
    k = suffix.indexOf('/', 1);
    if (k < 0)
      return "..." + path.substring(path.length() - limitLength + 3);
    int limit = MAX_LABEL_LENGTH - prefix.length() - 3;
    while (k >= 0 && suffix.length() > limit)
    {
      suffix = suffix.substring(k);
      k = suffix.indexOf('/', 1);
    }
    if (suffix.length() <= limit)
      return prefix + "..." + suffix;
    else
      return "..." + path.substring(path.length() - limitLength + 3);
  }

  public boolean equals(Object obj)
  {
    if (obj == null || !(obj instanceof History))
      return false;
    History history = (History)obj;
    if (path == null)
      return (history.path == null);
    return path.equals(history.path);
  }

  public String toString()
  {
    return label;
  }

  public History put(String childPath)
  {
    if (items == null)
      items = new ArrayList();
    History child = new History(childPath);
    int index = items.indexOf(child);
    if (index >= 0)
      child = (History)items.remove(index);
    items.add(0, child);
    if (items.size() > MAX_ITEM_COUNT)
      items.remove(items.size()-1);
    return child;
  }

  public History getFirstChild()
  {
    if (items == null && items.size() == 0)
      return null;
    return (History)items.get(0);
  }

  public void remove(String childPath)
  {
    if (items == null)
      items = new ArrayList();
    History child = new History(childPath);
    int index = items.indexOf(child);
    if (index >= 0)
      items.remove(index);
  }

}

