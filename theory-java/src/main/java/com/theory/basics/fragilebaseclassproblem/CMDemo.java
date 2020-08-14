package com.theory.basics.fragilebaseclassproblem;

import com.theory.support.Contact;

class CMDemo
{
   public static void main(String[] args)
   {
      Contact[] contacts = { new Contact(), new Contact(), new Contact() };
      LoggingCM lcm = new LoggingCM();
      lcm.addContacts(contacts);
   }
}