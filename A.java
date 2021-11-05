/*
 *    Copyright (C) 2021 Guglielmo De Angelis (a.k.a. Gulyx)
 *    
 *    This file is part of the contents developed for the course
 * 	  ISPW (A.Y. 2021-2022) at Università di Tor Vergata in Rome. 
 *
 *    This is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as 
 *    published by the Free Software Foundation, either version 3 of the 
 *    License, or (at your option) any later version.
 *
 *    This software is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with this source.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package it.uniroma2.dicii.ispw.overrideOverloadExamples;

public class A {
  private C c;
  private static int a=0;
  
  public A(){
	  int i = A.a; 
	  A.a++;
	  i++;
	  System.out.println("A : "+A.a);
	  c = new C();
	  System.out.println("... done A : "+i);
  }

//  Try to combine the change of visibility for both this method and for B.test(int p) 
//  private int test (int p){
//  protected int test (int p){
  public int test (int p){
	  return p;
  }
  
  public static void main (String args[]){
	  System.out.println("instantiating `a` as A");
	  A a = new A();
	  System.out.println( "This is the result form the invocation to `test`: " + a.test(3) );
//   The following statement rises an error
//	  System.out.println( "This is the result form the invocation to `test`: " + a.test(3.0f) );
	  System.out.println("instantiatin `a` as B -- only override");
	  a = new B();
	  System.out.println( "This is the result form the invocation to `test`: " + a.test(3) );
//   The following statement rises an error
//		  System.out.println( "This is the result form the invocation to `test`: " + a.test(3.0f) );
	  System.out.println("instantiatin `b` as B -- both override and overload");
	  B b = new B();
	  System.out.println( "This is the result form the invocation to `test` (override): " + b.test(3) );
//   The following statement DOES NOT rise any error
	  System.out.println( "This is the result form the invocation to `test` (overload): " + b.test(3.0f) );
  }
  
  
}
