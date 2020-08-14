package com.theory.basics.fragilebaseclassproblem;

import com.theory.support.Contact;
import com.theory.support.Logger;

public class LoggingCM extends CM
{
   // A constructor is not necessary because the Java compiler will add a
   // no-argument constructor that calls the superclass's no-argument
   // constructor by default.

   @Override
   public void addContact(Contact contact)
   {
      Logger.log(contact.toString());
      super.addContact(contact);
   }

   @Override
   public void addContacts(Contact[] contacts)
   {
      for (int i = 0; i < contacts.length; i++)
         Logger.log(contacts[i].toString());
      super.addContacts(contacts);
   }







}