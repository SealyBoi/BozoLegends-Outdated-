
public class enemy {
	
	private String name;
	private static int maxHealth;
	private static int health;
	private static int damage;
	private static int speed;
	private static int accuracy;
	
	// Set Enemy Stats
	public void setName(String newName) {
		name = newName;
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
	
	// Get Enemy Stats
	public String getName() {
		return name;
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
}
