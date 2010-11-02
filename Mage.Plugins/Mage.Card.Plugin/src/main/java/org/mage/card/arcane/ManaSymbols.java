package org.mage.card.arcane;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.mage.card.constants.Constants;

public class ManaSymbols {
	private static final Logger log = Logger.getLogger(ManaSymbols.class);
	static private final Map<String, Image> manaImages = new HashMap<String, Image>();
	static private Pattern replaceSymbolsPattern = Pattern.compile("\\{([^}/]*)/?([^}]*)\\}");

	static public void loadImages () {
		String[] symbols = new String[] {"0", "1", "10", "11", "12", "15", "16", "2", "3", "4", "5", "6", "7", "8", "9", "B", "BG",
			"BR", "G", "GU", "GW", "R", "RG", "RW", "S", "T", "U", "UB", "UR", "W", "WB", "WU", "X", "Y", "Z", "slash"};
		//TODO: replace by downloading
		for (String symbol : symbols)
			manaImages.put(symbol, UI.getImageIcon(Constants.RESOURCE_PATH_MANA + "/" + symbol + ".png").getImage());
	}

	static public void draw (Graphics g, String manaCost, int x, int y) {
		if (manaCost.length() == 0) return;
		manaCost = manaCost.replace("\\", "");
		manaCost = UI.getDisplayManaCost(manaCost);
		StringTokenizer tok = new StringTokenizer(manaCost, " ");
		while (tok.hasMoreTokens()) {
			String symbol = tok.nextToken().substring(0);
			Image image = manaImages.get(symbol);
			if (image == null) {
				log.error("Symbol not recognized \"" + symbol + "\" in mana cost: " + manaCost);
				continue;
			}
			g.drawImage(image, x, y, null);
			x += symbol.length() > 2 ? 10 : 12; // slash.png is only 10 pixels wide.
		}
	}

	static public int getWidth (String manaCost) {
		int width = 0;
		manaCost = manaCost.replace("\\", "");
		StringTokenizer tok = new StringTokenizer(manaCost, " ");
		while (tok.hasMoreTokens()) {
			String symbol = tok.nextToken().substring(0);
			width += symbol.length() > 2 ? 10 : 12; // slash.png is only 10 pixels wide.
		}
		return width;
	}

	static public synchronized String replaceSymbolsWithHTML (String value, boolean small) {
		if (small)
			return replaceSymbolsPattern.matcher(value).replaceAll("<img src='file:images/symbols-11/$1$2.png' width=11 height=11>");
		else {
			value = value.replace("{slash}", "<img src='file:images/symbols-13/slash.png' width=10 height=13>");
			return replaceSymbolsPattern.matcher(value).replaceAll("<img src='file:images/symbols-13/$1$2.png' width=13 height=13>");
		}
	}
}
