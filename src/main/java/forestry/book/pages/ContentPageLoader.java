package forestry.book.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import forestry.api.book.BookContent;
import forestry.api.book.IBookEntry;
import forestry.api.book.IBookPageFactory;
import forestry.api.gui.IGuiElement;
import forestry.core.gui.elements.GuiElementFactory;
import forestry.core.gui.elements.layouts.VerticalLayout;

public class ContentPageLoader implements IBookPageFactory {

	public static final ContentPageLoader INSTANCE = new ContentPageLoader();

	private ContentPageLoader() {
	}

	@Override
	public Collection<IGuiElement> load(IBookEntry entry) {
		List<IGuiElement> pages = new ArrayList<>();
		BookContent previous = null;
		IGuiElement previousElement = null;

		for (BookContent[] contentArray : entry.getContent()) {
			VerticalLayout page = new VerticalLayout(108);
			pages.add(page);
			for (BookContent content : contentArray) {
				if (content.addElements(page, GuiElementFactory.INSTANCE, previous, previousElement)) {
					previous = content;
					previousElement = page.getLastElement();
					page.layout();
				} else {
					previous = null;
					previousElement = null;
				}
			}
			previous = null;
			previousElement = null;
		}
		return pages;
	}
}
