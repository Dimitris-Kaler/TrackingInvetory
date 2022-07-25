package inventory.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFile {

	private Path path;

	public TextFile(String filePath) {
		 path = Paths.get(filePath);
	}

	void writeText(String content) throws IOException {
		Files.write(path, content.getBytes());
	}

}
