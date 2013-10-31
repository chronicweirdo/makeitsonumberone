package com.chronicweirdo.jbon.test

import com.chronicweirdo.jbon.reader.JBONReader
import com.chronicweirdo.jbon.writer.JBONWriter;

class Test6 {

	static main(args) {
		String text = """\
		com.chronicweirdo.jbon.test.PrimitiveBean {
			vBoolean: true,
			"vByte": 2
		}
		"""
		Object object = JBONReader.read(text);
		String text2 = JBONWriter.write(object, true);
		println text2;
		Object object2 = JBONReader.read(text2);
		String text3 = JBONWriter.write(object2, true);
		println text3
	}
}
