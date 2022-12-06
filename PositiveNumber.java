package hausaufgabe9;

/**
 * 
 * @author Gruppe 1
 * 
 * Klasse zum Speichern einer positiven Zahl
 *
 */


public class PositiveNumber {
	// Attribut
	private int value;

	/**
	 * Speichern einer Hexadezimalzahl
	 * @param s  zu speichernde Hexadezimalzahl
	 */
	public void setHexadecimal(String s) {
		this.value = 0;// löschen der aktuellen Wert von Value
		s.toLowerCase();// nehmen nur kleines Charakter nehmen
		int length = s.length() - 1, num;// Index
		for (int i = 0; i <= length; i++) {
			// überprüfen jedes Charakter in String
			char cha = s.charAt(length - i);
			if (cha == 'a') {
				num = 10;
			} else if ((int) cha > 102 || (int) cha < 48 || ((int) cha > 57 && (int) cha < 97)) {// Exception
				throw new NumberFormatException("Fehler:Das Charakter ist unmöglich");
			} else if (cha == 'b') {
				num = 11;
			} else if (cha == 'c') {
				num = 12;
			} else if (cha == 'd') {
				num = 13;
			} else if (cha == 'e') {
				num = 14;
			} else if (cha == 'f') {
				num = 15;
			} else {
				num = Integer.valueOf(i);
			}
			this.value += num * Math.pow(16, i);// value+=nummer*16^(von 0 bis Länger-1)
		}
		if (this.value < 0 || this.value > Integer.MAX_VALUE) {// Exception
			throw new ArithmeticException("Fehler:Die Zahl ist unmöglich");
		}
	}

	/**
	 * Ausagbe von value als Hexadezimalzahl
	 * @return Attribut value als String der entsprechenden Hexadezimalzahl
	 */
	public String getHexadecimal() {
		int num = value % 16;
		String res = "";
		if (num == 10) {
			res += "a";
		} else if (num == 11) {
			res += "b";
		} else if (num == 12) {
			res += "c";
		} else if (num == 13) {
			res += "d";
		} else if (num == 14) {
			res += "e";
		} else if (num == 15) {
			res += "f";
		} else {
			res += String.valueOf(num);
		}
		this.value = this.value / 16;
		if (this.value != 0) {
			return (getHexadecimal() + res).toUpperCase();
		} else {
			return res;
		}
	}

	/**
	 * Speichern einer Dezimalzahl
	 * @param s  zu speichernde Dezimalzahl
	 */
	public void setDecimal(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				continue;
			} else {
				throw new NumberFormatException("Nur Zahlen erlaubt!");
			}
		}
		this.value = Integer.parseInt(s);
		if (value < 0 || value > Integer.MAX_VALUE) {
			throw new ArithmeticException("Keine negativen Zahlen!");
		}
	}

	/**
	 * Ausagbe von value als Dezimalzahl
	 * @return Attribut value als String der entsprechenden Dezimalzahl
	 */
	public String getDecimal() {
		return String.valueOf(this.value);
	}
	
	/**
	 * Speichern einer Binaerzahl
	 * @param s  zu speichernde Binaerzahl
	 */
	public void setBinary(String s) {
		value = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '1' && s.charAt(i) != '0') {
				throw new NumberFormatException("Nur Zahlen erlaubt!");
			}
			value += (int) Math.pow(2, s.length() - i - 1) * ((int) s.charAt(i) - 48);
			if (value < 0) {
				throw new ArithmeticException("Keine negativen Zahlen!");
			}
		}
	}

	/**
	 * Ausagbe von value als Binaerzahl
	 * @return Attribut value als String der entsprechenden Binaerzahl
	 */
	public String getBinary() {
		String result = "" + (value % 2);
		for (int v = value; v != 0; v = (int) v / 2) {
			result = "" + v % 2 + result;
		}
		return result;
	}
}
