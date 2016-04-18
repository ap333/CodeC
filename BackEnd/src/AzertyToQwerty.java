import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AzertyToQwerty {
	private Map<Character, Character> map;

	/**
	 * Constructor to generate map.
	 */
	public AzertyToQwerty() {
		map = new HashMap<Character, Character>();
		map.put('A', 'Q');
		map.put('a', 'q');
		map.put('Z', 'W');
		map.put('z', 'w');
		map.put('Q', 'A');
		map.put('q', 'a');
		map.put('W', 'Z');
		map.put('w', 'z');
		map.put('₂', '`');
		map.put('&', '1');
		map.put('é', '2');
		map.put('"', '3');
		map.put('\'', '4');
		map.put('(', '5');
		map.put('-', '6');
		map.put('è', '7');
		map.put('_', '8');
		map.put('ç', '9');
		map.put('à', '0');
		map.put(')', '-');
		map.put('1', '!');
		map.put('2', '@');
		map.put('3', '#');
		map.put('4', '$');
		map.put('5', '%');
		map.put('6', '^');
		map.put('7', '&');
		map.put('8', '*');
		map.put('9', '(');
		map.put('0', ')');
		map.put('º', '_');
		map.put('^', '[');
		map.put('$', ']');
		map.put('M', ';');
		map.put('ù', '\'');
		map.put('*', '\\');
		map.put(',', 'M');
		map.put(';', ',');
		map.put(':', '.');
		map.put('!', '/');
		map.put('¨', '{');
		map.put('£', '}');
		map.put('%', '"');
		map.put('µ', '|');
		map.put('.', '<');
		map.put('/', '>');
		map.put('§', '?');
		map.put('~', '™');
		map.put('#', '£');
		map.put('{', '¢');
		map.put('[', '∞');
		map.put('|', '§');
		map.put('`', '¶');
		map.put('\\', '•');
		map.put('^', 'ª');
		map.put('@', 'º');
		map.put(']', '–');
		map.put('}', '≠');
	}

	/**
	 * Process a word in AZERTY to QWERTY
	 * 
	 * @param input
	 * @return
	 */
	public String process(String input) {
		char[] letters = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : letters) {
			if (map.containsKey(c))
				sb.append(map.get(c));
			else
				sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * Test
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		AzertyToQwerty q = new AzertyToQwerty();
		Scanner rdr = new Scanner(System.in);
		String word = rdr.next();
		rdr.close();
		String result = q.process(word);
		System.out.println(result);
	}

}
