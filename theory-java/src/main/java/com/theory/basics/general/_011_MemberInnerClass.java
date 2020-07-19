package com.theory.basics.general;

import com.theory.basics.general.Level0.LevelMinus1;

/*A non-static class that is created inside a class but outside a method is called a member inner class*/
class Level0 {
	private String level = "Level : 0";

	class LevelMinus1 {
		private String level = "Level : -1";

		class LevelMinus2 {
			private String level = "Level : -2";

			public void displayLevel() {
				System.out.println("Level-2 " + this.level);
				System.out.println("Level-1 " + LevelMinus1.this.level);
				System.out.println("Level-0 " + Level0.this.level);
			}
		}
	}
}
public class _011_MemberInnerClass {
	public static void main(String args[]) {
		Level0 level0 = new Level0();
		LevelMinus1 levelMinus1 = level0.new LevelMinus1(); //Instantiation technique of Inner Class
		LevelMinus1.LevelMinus2 levelMinus2 = levelMinus1.new LevelMinus2();
		levelMinus2.displayLevel();
	}
}
