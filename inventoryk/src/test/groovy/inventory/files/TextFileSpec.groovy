package inventory.files

import spock.lang.Specification

class TextFileSpec extends Specification {

	def "it writes text to a file that does not exist"() {
		given:
		String filePath = "src/test/resources/new-file.txt"
		TextFile file = new TextFile(filePath)
		file.writeText("hello")

		expect:
		new File(filePath).text == "hello"

		cleanup:
		new File(filePath).delete()
	}

}
