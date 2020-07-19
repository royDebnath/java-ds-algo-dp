package com.theory.basics.general;

/* The rule that all the methods of interface are public still applies. A class that implements interface must define that method
 * as public. The interface itself does not have to be public, though. Just like any inner class, an inner interface can be private.
 * This means that the interface can only be referred to within the current outer class*/

public class _015_PrivateInterface {

	private interface Secret {
		void shhh();
	}

	class DontTell implements Secret {
		@Override
		public void shhh() {
			System.out.println("Implementation of Secret");

		}
	}
}
