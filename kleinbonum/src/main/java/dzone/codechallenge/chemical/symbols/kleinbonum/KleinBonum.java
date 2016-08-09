package dzone.codechallenge.chemical.symbols.kleinbonum;

/**
 * This utility class contains functions around two letter symbols for chemical
 * elements: a check for correctness according to certain rules, a function that
 * counts the number of possible symbols and a function that determines the
 * first possible symbol in alphabetical order.
 * 
 * @author j-ada
 *
 */
public final class KleinBonum {

	/**
	 * Forbidden!
	 */
	private KleinBonum() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Check symbol for element according to the following rules:
	 * <ol>
	 * <li>
	 * All chemical symbols must be exactly two letters, so B is not a valid
	 * symbol for Boron.</li>
	 * <li>
	 * Both letters in the symbol must appear in the element name, but the first
	 * letter of the element name does not necessarily need to appear in the
	 * symbol. So Hg is not valid for Mercury, but Cy is.</li>
	 * <li>
	 * The two letters must appear in order in the element name. So Vr is valid
	 * for Silver, but Rv is not. To be clear, both Ma and Am are valid for
	 * Magnesium, because there is both an a that appears after an m, and an m
	 * that appears after an a.@param element</li>
	 * <li>
	 * If the two letters in the symbol are the same, it must appear twice in
	 * the element name. So Nn is valid for Xenon, but Xx and Oo are not.@param
	 * symbol</li>
	 * </ol>
	 * 
	 * @param element
	 *            chemical element name
	 * @param symbol
	 *            proposed symbol for element
	 * @return true if symbol conforms to rules
	 */
	public static boolean checkSymbolFor(String element, String symbol) {
		return KleinBonumWorker.checkSymbolFor(element, symbol);
	}

	/**
	 * Count number of possible symbols for chemical elements that conform to
	 * rules specified in {@link #checkSymbolFor(String, String)}.
	 * 
	 * @param element
	 *            chemical element name
	 * @return number of possible symbols. Zero if no symbol is possible (null
	 *         or empty or too short or illegal input)
	 */
	public static int countPossibleSymbols(String element) {
		return KleinBonumWorker.countPossibleSymbols(element);
	}

	/**
	 * Returns first possible symbol for element in alphabetical order
	 * 
	 * @param element chemical element name
	 * @return first possible symbol for element in alphabetical order
	 */
	public static String firstSymbolInAlphabet(String element) {
		return KleinBonumWorker.firstInAlphabet(element);
	}

}
