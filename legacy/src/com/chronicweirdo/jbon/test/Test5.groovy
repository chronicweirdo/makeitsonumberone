package com.chronicweirdo.jbon.test

import com.chronicweirdo.jbon.reader.JBONReader
import com.chronicweirdo.jbon.writer.JBONWriter;

class Test5 {

	static main(args) {
		String text1 = """\
		{
			"node": com.chronicweirdo.graph.element.Node {
				value: {
					"type": "line",
					"path": ["bbp", "slimsgate.txt"],
					"line": 74
				}
			},
			"list": ["val1", 2, 44.4],
			"set": java.util.HashSet ["val1", "val2", "val1"],
			"string": "a simple string",
			"double": 33.4,
			"boolean": true,
			"falseBoolean": false,
			"hashMap": java.util.HashMap {}
		}
		"""
		Object object1 = JBONReader.read(text1);
		String text2 = JBONWriter.write(object1, true);
		println text2
		Object object2 = JBONReader.read(text2);
		String text3 = JBONWriter.write(object2)
		println text3
		Object object3 = JBONReader.read(text3)
		String text4 = JBONWriter.write(object3, true)
		println text4
	}
}
