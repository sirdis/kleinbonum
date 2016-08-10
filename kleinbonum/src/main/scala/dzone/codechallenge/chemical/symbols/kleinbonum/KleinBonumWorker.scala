package dzone.codechallenge.chemical.symbols.kleinbonum

/**
 * Does the actual work for KleinBonum
 *
 * @author j-ada
 * @see KleinBonum
 *
 */
object KleinBonumWorker {

  /**
   * See {@link KleinBonum}.
   *
   * @param element chemical element name
   * @param symbol symbol for element
   * @return true if symbol is valid
   */
  def checkSymbolFor(element: String, symbol: String) = {
    boringStuff(element, symbol) && {
      def elementPairs = toPairs(element.toLowerCase.toCharArray)
      def symbolPairs = toPairs(symbol.toLowerCase.toCharArray)
      symbolPairs.subsetOf(elementPairs)
    }
  }

  /**
   * See {@link KleinBonum}.
   *
   * @param element chemical element name
   * @return number of valid symbols for element
   */
  def countPossibleSymbols(element: String) = {
    if (!boringStuff(element, "xx")) 0
    else toPairs(element.toCharArray).size
  }

  /**
   * See {@link KleinBonum}.
   * 
   * @param element chemical element name
   * @return first symbol in alphabetical order
   */
  def firstInAlphabet(element: String) = {
    if (!boringStuff(element, "xx")) ""
    else {
      val pair = toPairs(element.toLowerCase.toCharArray).min
      new String(Array(pair._1, pair._2)).capitalize
    }
  }

  /**
   * Create all pairs of characters that are legal due to the rules described in
   * {@link KleinBonum}.
   * @param chars the element name or substring thereof
   * @return Set of valid pairs
   */
  private def toPairs(chars: Array[Char]): Set[(Char, Char)] = chars match {
    case Array(c1, c2) => Set((c1, c2))
    case Array(c1, _*) => (for {
      c <- chars.tail
    } yield (c1, c)).toSet ++ toPairs(chars.tail)
  }

  /**
   * Check for null, empty, illegal characters in element and symbol
   *
   * @param element chemical element name
   * @param symbol proposed symbol for element
   * @return true, if both are valid
   */
  private def boringStuff(element: String, symbol: String) = element != null && element.size >= 2 &&
    symbol != null && symbol.size == 2 && (symbol + element).forall { c => c.isLetter }

}
