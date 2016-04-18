import java.util.*;

public class Solution {

	private static String[] dictionary = { "achievement", "acid", "action", "adventure", "allspark", "ammo", "arpg",
			"assassin", "asteroid", "autosave", "avatar", "avenger", "beta", "blade", "blast", "block", "blood", "boss",
			"buff", "bullet", "buster", "checkpoint", "cheese", "chrono", "claptrap", "class", "closed", "console",
			"controller", "cooldown", "corruption", "counter", "cover", "cpu", "crafting", "creed", "crouch", "crpg",
			"cutscene", "cutting", "damage", "difficulty", "dig", "dlc", "dodge", "doublejump", "drm", "dungeon",
			"dweller", "early", "edge", "emergent", "endings", "episodic", "escort", "esports", "event", "exclusive",
			"exploit", "explosion", "fall", "farm", "farming", "fasttravel", "field", "fight", "finished", "fireball",
			"fog", "free", "game", "ganon", "gauntlet", "gem", "generation", "ghost", "god", "gpu", "grenade",
			"griefer", "grinding", "gun", "halo", "hardmode", "healer", "health", "horror", "ifrit", "indie",
			"infinity", "instance", "invader", "joystick", "jrpg", "jump", "keyblade", "keyboard", "kill", "lag",
			"lane", "leroy", "level", "lightning", "link", "live", "ludology", "mage", "magus", "mana", "mario",
			"masamune", "master", "matchmaking", "materia", "megaman", "microtransactions", "middleware", "midgar",
			"mission", "mmorpg", "mob", "moba", "mode", "monster", "mouse", "mouselook", "multiple", "myst", "nerf",
			"nintendo", "noob", "npc", "nvidia", "openworld", "optimus", "overpowered", "overshield", "pacman", "pass",
			"pellet", "permadeath", "persistent", "pickaxe", "pierce", "pixel", "plasma", "play", "poison", "port",
			"potion", "procedural", "puzzle", "pve", "pvp", "quest", "quick", "raid", "realtime", "replay",
			"retrogaming", "rig", "rocket", "roguelike", "romance", "rpg", "season", "shield", "shoot", "shovel",
			"simulator", "sli", "sliding", "smash", "souls", "spawn", "speedrun", "spread", "sprint", "stealth",
			"strategy", "streak", "summon", "super", "survival", "sword", "system", "tactics", "tank", "tesseract",
			"theory", "time", "touchscreen", "triforce", "uppercut", "vault", "walljump", "war", "warrior", "wasd",
			"wasteland", "world", "zelda", "zombie" };

	private static int[] scores = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
	private static Map<String, int[]> map;
	
	public Solution(){
		process();
	}



	/**
	 * get count array for given set of letters
	 */
	public int[] lCount(String s) {
		char[] letters = s.toCharArray();
		int[] letterCount = new int[26];
		for (char c : letters) {
			letterCount[c - 'a'] += 1;
		}
		return letterCount;
	}

	/**
	 * get the word that can be made by given letters and has the highest score.
	 */
	public String getWords(int[] letterCount) {

		String result = "";
		int max = 0;
		for (String s : map.keySet()) {
			int count = 0;
			int[] x = map.get(s);
			for (int i = 0; i < 26; i++) {
				if (x[i] > letterCount[i]) {
					break;
				} else {
					count += x[i] * scores[i];
				}
				if (i + 1 == 26) {
					if (count > max) {
						result = s;
						max = count;
					}
				}
			}
		}
		System.out.println("Score: " + max);
		return result;
	}

	/**
	 * Pre-process the map to generate count arrays for each word.
	 */
	public void process() {
		map = new HashMap<String, int[]>();
		for (String s : dictionary) {
			int[] a = new int[26];
			char[] chars = s.toCharArray();
			for (char c : chars) {
				a[c - 'a'] += 1;
			}
			map.put(s, a);
		}
	}
	
	/**
	 * Test
	 * @param args
	 */
	public static void main(String args[]) {
		Solution sol = new Solution();
		Scanner rdr = new Scanner(System.in);
		String rack = rdr.next();
		rdr.close();
		
		int[] letterCount = sol.lCount(rack);
		String result = sol.getWords(letterCount);
		if (result.isEmpty()) System.out.println("No possible word");
		else System.out.println(result);
	}
}
