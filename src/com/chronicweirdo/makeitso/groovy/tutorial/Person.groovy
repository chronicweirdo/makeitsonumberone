package com.chronicweirdo.makeitso.groovy.tutorial

class Person {

	String firstName;
	String lastName;
	int age;
	def address;
	def tags = [:]

	void setProperty (String property, Object o){
		tags[property] = o
	}

	Object getProperty (String property){
		return tags[property]
	}

	def methodMissing (String name, args){
		def s = name.toUpperCase();
		if (s.startsWith("HELLO")) {
			println "This method stats with Hello. Full name $name"
			println args
		} else {
			println "This method is missing"
		}
	}

	static main(args) {
		Person p = new Person();
		p.firstName = "chronic";
		p.lastName = "weirdo";
		p.address = ("acasa");
		p.age = 13;

		Person p2 = new Person(firstName: "Aloof", address: ("copoi"));
		println(p.firstName + " " + p.address);
	}
}
