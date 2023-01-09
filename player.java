public class player{
	
	private String name;
	private String build;
	private static int maxHealth;
	private static int health;
	private static int damage;
	private static int speed;
	private static int accuracy;
	private static int gold;
	private static int specialMoveCounter;
	private static int currWeapon;
	private static int currArmor;
	private static int currAmulet;
	private static boolean doubleGold;
	
	// Set Player Stats
	public void setName(String newName) {
		name = newName;
	}
	public void setBuild(String newBuild) {
		build = newBuild;
	}
	public void setMaxHealth(int newHealth) {
		maxHealth = newHealth;
		health = maxHealth;
	}
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	public void setDamage(int newDamage) {
		damage = newDamage;
	}
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	public void setAccuracy(int newAccuracy) {
		accuracy = newAccuracy;
	}
	public void setGold(int newGold) {
		gold = newGold;
	}
	public void setSMC(int newSMC) {
		specialMoveCounter = newSMC;
	}
	public void setDG(boolean newDG) {
		doubleGold = newDG;
	}
	public void setWeapon(int weapon) {
		currWeapon = weapon;
	}
	public void setArmor(int armor) {
		currArmor = armor;
	}
	public void setAmulet(int amulet) {
		currAmulet = amulet;
	}
	public void restoreHealth() {
		health = maxHealth;
	}
	
	// Get Player Stats
	public String getName() {
		return name;
	}
	public String getBuild() {
		return build;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public int getHealth() {
		return health;
	}
	public int getDamage() {
		return damage;
	}
	public int getSpeed() {
		return speed;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public int getGold() {
		return gold;
	}
	public int getSMC() {
		return specialMoveCounter;
	}
	public boolean getDG() {
		return doubleGold;
	}
	public int getWeapon() {
		return currWeapon;
	}
	public int getArmor() {
		return currArmor;
	}
	public int getAmulet() {
		return currAmulet;
	}
}
