// This is a SUGGESTED skeleton file.  Throw it away if you don't use it.
package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
class Reflector extends Rotor {
	int[] reflection;
	
	public static Reflector make(String str){
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}
	
	public Reflector(int[] r){
		reflection = r;
	}
        
    int convertForward(int p) {
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }

    /** Returns a useless value; should never be called. */
    @Override
    int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

    /** Reflectors do not advance. */
    @Override
    void advance() {
    }

}
