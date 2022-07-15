package intentory.kalerantes;

import formats.JsonFormat;

public class SaveJSONFileMenuItem extends MenuItem {

	public SaveJSONFileMenuItem(String code, String description) {
		super(code, description);
	}

	@Override
	public void execute(ItemList list) {
		JsonFormat jFormat = new JsonFormat(list);
		//TODO this one fails
		jFormat.createFileWithJsonFormat();
	}

}
