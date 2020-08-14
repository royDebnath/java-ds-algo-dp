package com.theory.basics.fragilebaseclassproblem;

import com.theory.support.Contact;

public class CM
{
   private final static int MAX_CONTACTS = 1000;
   private Contact[] contacts;
   private int size;

   public CM()
   {
      contacts = new Contact[MAX_CONTACTS];
      size = 0; // redundant because size is automatically initialized to 0
                // adds clarity, however
   }

   public void addContact(Contact contact)
   {
      if (size == contacts.length)
         return; // array is full
      contacts[size++] = contact;
   }

   public void addContacts(Contact[] contacts)
   {
      for (int i = 0; i < contacts.length; i++)
      addContact(contacts[i]);
   }
}