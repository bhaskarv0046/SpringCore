package com.nt.test;

import java.io.Serializable;
import java.util.Arrays;

import com.nt.comps.Test;

public class Property_classTest implements Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c1=Test.class;
		System.out.println("c1 obj class name:: "+c1.getClass()+"    c1 obj data::  "+c1.toString());
		System.out.println("_______________________________________________");
		System.out.println("c1 class name::  "+c1.getName());
		System.out.println("c1 super class name::  "+c1.getSuperclass());
		System.out.println("implemented interface names::  "+Arrays.toString(c1.getInterfaces()));
		

	}

}
