package com.chronicweirdo.makeitso.groovy.tutorial

class GroovyTest {

	static prime() {
		def myList = [1, 2, "cw", "4"]
		myList.each { println it }
	}
	static loops() {
		def l1 = ["Bender", "Fry", "Leela"]
		l1.each {name->
			println name
		}
		5.times {
			println "this is it $it"
		}
		for (i in 5..7) {
			println "fornum $i"
		}
		// this does not work as expected
		5..8.each {j->
			println "number $j"
		}
	}
	static types() {
		def v1 = 1.0f
		println v1.getClass().getName()
		v1 = "a string"
		println v1.getClass().getName()
	}
	static strings() {
		def name = "Finn"
		def s1 = 'hello $name'
		def s2 = "hello $name" // GString - or groovy string, vars evaluated
		println s1
		println s2
	}
	static listsAndMaps() {
		def l1 = []
		l1[1] = 5
		println l1
		
		def m1 = [:]
		m1["credentials"] = ["facebook":["username":"test","password":"pass"]]
		println m1
		m1["credentials"]["facebook"]["security_question"] = [:] // this is required to prevent NPE
		m1["credentials"]["facebook"]["security_question"]["what is your pets name"] = "chibi"
		println m1
		m1.each {k,v->
			println ":: $k"
			println ":::: $v"
		}
		
		def m2 = [:]
		m2.age = "child"
		println m2
	}
	
	static regex() {
		def text = "the rain in spain stays mainly on the plane"
		// match!
		println text==~/(\w*\W+)*/ // because it does not end with non-word character
		println text==~"(\\w*\\W+)*"
		// find
		println text=~/(\w*\W+)*/
		if (text=~/(\w*\W+)*/) {
			println "matches"
		}
		// turn string into regex
		def rx = ~"s.*"
		println rx
		println rx.getClass().getName()
		println text=~rx
	}
	
	static closures() {
		def func = {
			println "cool $it"
		}
		def list = [1, 2, 3]
		list.each(func)
	}
	
	static metaobject() {
		Person p = new Person()
		p.firstName = "Marceline"
		p.title = "The Vampire Queen"
		println "$p.firstName $p.title"
		p.whatsUp()
		p.helloToAll("Finn", "and", "Jake")
	}
	
	static fileRead() {
		def file = new File("test.xml")
		file.eachLine { println it }
	}
	
	static xml() {
		def file = new File("test.xml")
		def xmlf = ""
		file.eachLine { xmlf += it }
		println xmlf
		
		def xml = new XmlParser().parse(file)
		println "number of people: " + xml.person.size()
		println xml.person[0].firstName
		for (p in xml.person) {
			println "${p.firstName.text()} ${p.lastName.text()}"
		}
	}
	
	static void main(def args) {
		//prime()
		//loops()
		//types()
		//strings()
		//listsAndMaps()
		//regex()
		//closures()
		//metaobject()
		//fileRead()
		xml()
	}
}
