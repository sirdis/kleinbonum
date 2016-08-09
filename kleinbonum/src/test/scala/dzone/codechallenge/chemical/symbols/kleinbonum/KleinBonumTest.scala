package dzone.codechallenge.chemical.symbols.kleinbonum

import dzone.codechallenge.chemical.symbols.kleinbonum.KleinBonum._
import org.scalatest.Matchers
import org.scalatest.FlatSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.lang.reflect.InvocationTargetException

/**
 * Tests functions in {@link KleinBonum}
 * 
 * @author j-ada
 *
 */
@RunWith(classOf[JUnitRunner])
class KleinBonumTest extends FlatSpec with Matchers {
  "Function checkSymbolFor()" should "return false on null element" in {
    checkSymbolFor(null, "hg") should be(false)
  }

  it should "return false on emtpy element" in {
    checkSymbolFor("", "hg") should be(false)
  }

  it should "return false on element of length 1" in {
    checkSymbolFor("h", "hg") should be(false)
  }

  it should "return false on null symbol" in {
    checkSymbolFor("Aquarium", null) should be(false)
  }

  it should "return false on emtpy symbol" in {
    checkSymbolFor("Tullium", "") should be(false)
  }

  it should "return false on symbol of length 1" in {
    checkSymbolFor("Brimborium", "B") should be(false)
  }

  it should "work as defined by examples of code challenge description" in {
    val examples = Map(("Spenglerium", "Ee") -> true,
      ("Zeddemorium", "Zr") -> true,
      ("Venkmine", "Kn") -> true,
      ("Stantzon", "Zt") -> false,
      ("Melintzum", "Nn") -> false,
      ("Tullium", "Ty") -> false,
      ("Gozerium", "Ei") -> true,
      ("Slimyrine", "Ie") -> true)

    examples.foreach { case (k, v) => checkSymbolFor(k._1, k._2) should be(v) }
  }

  it should "return false if symbol contains non letter characters" in {
    for (c <- "01234567890-_.:,;#' 	+*".toCharArray()) {
      checkSymbolFor(s"Bri${c}mborium", s"B${c}") should be(false)
    }
  }

  "Function countPossibleSymbols()" should "return 0 on null input" in {
    countPossibleSymbols(null) should be(0)
  }

  it should "return 0 on empty input" in {
    countPossibleSymbols("") should be(0)
  }

  it should "return 0 on input of length 1" in {
    countPossibleSymbols("x") should be(0)
  }

  it should "return 0 on illegal input" in {
    countPossibleSymbols("x1") should be(0)
  }

  it should "return 1 on input of length 2" in {
    countPossibleSymbols("xy") should be(1)
  }

  it should "return 1 on input consisting of (any number of) 1 character" in {
    countPossibleSymbols("xxxxxxxxxx") should be(1)
  }

  it should "generally work correctly" in {
    countPossibleSymbols("Zuulon") should be(11)
    countPossibleSymbols("xyz") should be(3)
    countPossibleSymbols("xxxxyz") should be(4)
  }

  "Function firstSymbolInAlphabet()" should "return empty string on null input" in {
    firstSymbolInAlphabet(null) should equal("")
  }

  it should "return empty string on empty input" in {
    firstSymbolInAlphabet("") should equal("")
  }

  it should "return empty string on input of length 1" in {
    firstSymbolInAlphabet("x") should equal("")
  }

  it should "return capitalized input on input of length 2" in {
    firstSymbolInAlphabet("yx") should equal("Yx")
  }

  it should "generally work correctly" in {
    firstSymbolInAlphabet("Zuulon") should equal("Ln")
    firstSymbolInAlphabet("Brimborium") should equal("Bb")
    firstSymbolInAlphabet("aba") should equal("Aa")
  }

  "Constructor" should "throw UnsupportedOperationException" in {
    val cTor = classOf[KleinBonum].getDeclaredConstructor()
    cTor setAccessible true
    val ex = intercept[InvocationTargetException] {
      val i = cTor.newInstance()
    }
    
    ex.getCause.getClass should be (classOf[UnsupportedOperationException])
  }
}