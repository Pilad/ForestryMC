/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.book;

import java.util.Collection;

import forestry.api.gui.IGuiElement;

public interface IBookPageFactory {
	Collection<IGuiElement> load(IBookEntry entry);
}
