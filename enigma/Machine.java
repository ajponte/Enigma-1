// This is a SUGGESTED skeleton file.  Throw it away if you don't use it.
package enigma;

/**
 * Class that represents a complete enigma machine.
 * 
 * @author
 */
class Machine {

	private Rotor leftRotor;
	private Rotor middleRotor;
	private Rotor rightRotor;
	private Reflector reflector;

	public Machine() {

	}

	/**
	 * Set my rotors to (from left to right), REFLECTOR, LEFT, MIDDLE, and
	 * RIGHT. Initially, their positions are all 'A'.
	 */
	void setRotors(Reflector reflector, Rotor left, Rotor middle, Rotor right) {
		this.reflector = reflector;
		leftRotor = left;
		middleRotor = middle;
		rightRotor = right;
	}

	/**
	 * Set the positions of my rotors according to SETTING, which must be a
	 * string of 4 upper-case letters. The first letter refers to the reflector
	 * position, and the rest to the rotor positions, left to right.
	 */
	void setPositions(String setting) {
		char[] charSettings = setting.toCharArray();
		reflector.setPosition(Rotor.toIndex(charSettings[0]));
		leftRotor.setPosition(Rotor.toIndex(charSettings[1]));
		middleRotor.setPosition(Rotor.toIndex(charSettings[2]));
		rightRotor.setPosition(Rotor.toIndex(charSettings[3]));
	}

	/**
	 * Returns the encoding/decoding of MSG, updating the state of the rotors
	 * accordingly.
	 */
	String convert(String msg) {
		msg = msg.toUpperCase();
		char[] msgChars = msg.toCharArray();
		String result = "";
		for (char c : msgChars) {
			result += convertChar(c);
		}
			return result;
	}

	char convertChar(char c) {
		advanceRotors();
		int charIndex = Rotor.toIndex(c);
		int output;
		output = rightRotor.convertForward(charIndex);
		output = middleRotor.convertForward(output);
		output = leftRotor.convertForward(output);
		output = reflector.convertForward(output);
		output = leftRotor.convertBackward(output);
		output = middleRotor.convertBackward(output);
		output = rightRotor.convertBackward(output);
		return Rotor.toLetter(output);

	}

	void advanceRotors() {
		boolean advanceLeft = false;
		boolean advanceMiddle = false;
		boolean advanceRight = true;
		if (leftRotor.atNotch()) {
		}
		if (middleRotor.atNotch()) {
			advanceMiddle = true;
			advanceLeft = true;
		}
		if (rightRotor.atNotch()) {
			advanceMiddle = true;
			advanceRight = true;
		}
		if (advanceLeft) {
			leftRotor.advance();
		}
		if (advanceRight) {
			rightRotor.advance();
		}
		if (advanceMiddle) {
			middleRotor.advance();
		}

	}

	private static boolean isAllUpperLetters(String s) {
		boolean b = true;
		for (char c : s.toCharArray()) {
			if (!(Character.isLetter(c) && Character.isUpperCase(c))) {
				return false;
			}
		}
		return true;
	}
}
