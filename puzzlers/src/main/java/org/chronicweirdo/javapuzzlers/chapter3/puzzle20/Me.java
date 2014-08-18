package org.chronicweirdo.javapuzzlers.chapter3.puzzle20;

public class Me {
   public static void main(String[] args) {
      System.out.println(
         //Me.class.getName().replaceAll(".", "/") + ".class");
         Me.class.getName().replaceAll("\\.", "/") + ".class");
   }
}
