
public class database {
	int specialMoveCounter, currentFloor;
	private String selectedSave = "none";
	boolean beatBoss1 = false;
	boolean beatBoss2 = false;
	boolean beatBoss3 = false;
	boolean beatBoss4 = false;
	boolean beatBoss5 = false;

	// Floor 1
	String[] floor1Enemies = { "Skeleton", "Undead Soldier", "Cursed Tombstone", "Graverobber", "Banshee" };
	int[] floor1Stats = { 23, 4, 2, 67 };

	// Floor 2
	String[] floor2Enemies = { "Wolf", "Bear", "Deer", "Cougar", "Eagle" };
	int[] floor2Stats = { 36, 9, 3, 70 };

	// Floor 3
	String[] floor3Enemies = { "Sorcerer", "Apprentice", "Mage", "Alchemist", "Thaumaturge" };
	int[] floor3Stats = { 44, 12, 5, 76 };

	// Floor 4
	String[] floor4Enemies = { "Assassin", "Bandit", "Mercenary", "Poison Master", "Thief" };
	int[] floor4Stats = { 52, 16, 7, 82 };

	// Floor 5
	String[] floor5Enemies = { "Shieldbearer", "Knight", "Squire", "Crusader", "Spearman" };
	int[] floor5Stats = { 60, 20, 9, 86 };

	// Weapon List
	String[] weaponNames = { "Rock", "Wooden Club", "Hatchet", "Mace", "Sword", "Halberd", "Great Hammer",
			"Great Sword" };
	int[] weaponPrices = { 50, 125, 400, 675, 975, 1200, 1500, 1800 };
	int[] weaponDamages = { 5, 10, 14, 20, 28, 32, 36, 38 };
	int currWeaponDisplayed = 0;
	boolean[] weaponsPurchased = { false, false, false, false, false, false, false, false };
	String[] equippedWeapon = { "None", "0", "0" };
	int currEquippedWeapon = -1;

	// Armor List
	String[] armorNames = { "Leather Armor", "Scale Armor", "Plated Mail Armor", "Chainmail Armor", "Plated Iron Armor",
			"Plated Steel Armor" };
	int[] armorPrices = { 150, 300, 500, 800, 1000, 1500 };
	int[] armorHealths = { 6, 12, 18, 24, 30, 36 };
	int currArmorDisplayed = 0;
	boolean[] armorsPurchased = { false, false, false, false, false, false };
	String[] equippedArmor = { "None", "0", "0" };
	int currEquippedArmor = -1;

	// Amulet List
	String[] amuletNames = { "???", "???", "???", "???", "???" };
	int[] amuletModifiers = { 15, 3, 10, 12, 2 };
	String[] amuletDesc = { "???", "???", "???", "???", "???" };
	int currAmuletDisplayed = 0;
	boolean[] amuletsUnlocked = { false, false, false, false, false };
	String[] equippedAmulet = { "None", "0" };
	int currEquippedAmulet = -1;
	boolean doubleGold = false;

	// Amulet data storage
	String[] hiddenAmuletNames = { "Amulet of Precision", "Amulet of Speed", "Amulet of Defense", "Amulet of Power",
			"Amulet of Wealth" };
	int[] hiddenAmuletModifiers = { 15, 3, 10, 12, 2 };
	String[] hiddenAmuletDesc = { "Amulet grants user +15 Accuracy", "Amulet grants user +3 Speed",
			"Amulet grants user +10 Health", "Amulet grants user +12 Damage", "Amulet doubles user's gold rewards" };

	public void setSave(String file) {
		selectedSave = file;
	}
	public String getSave() {
		return selectedSave;
	}
}
