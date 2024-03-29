import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JRadioButton;

public class playerData {
	
	player player = listener.player;
	database database = new database();
	
	public void Save(String file) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(player.getName());
			bw.newLine();
			bw.write(player.getBuild());
			bw.newLine();
			bw.write("" + player.getMaxHealth());
			bw.newLine();
			bw.write("" + player.getDamage());
			bw.newLine();
			bw.write("" + player.getSpeed());
			bw.newLine();
			bw.write("" + player.getAccuracy());
			bw.newLine();
			bw.write("" + player.getGold());
			bw.newLine();
			bw.write("" + database.getBoss1());
			bw.newLine();
			bw.write("" + database.getBoss2());
			bw.newLine();
			bw.write("" + database.getBoss3());
			bw.newLine();
			bw.write("" + database.getBoss4());
			bw.newLine();
			bw.write("" + database.getBoss5());
			bw.newLine();
			bw.write(database.equippedWeapon[0]);
			bw.newLine();
			bw.write(database.equippedWeapon[1]);
			bw.newLine();
			bw.write(database.equippedWeapon[2]);
			bw.newLine();
			bw.write("" + database.weaponsPurchased[0]);
			bw.newLine();
			bw.write("" + database.weaponsPurchased[1]);
			bw.newLine();
			bw.write("" + database.weaponsPurchased[2]);
			bw.newLine();
			bw.write("" + database.weaponsPurchased[3]);
			bw.newLine();
			bw.write("" + database.weaponsPurchased[4]);
			bw.newLine();
			bw.write("" + database.weaponsPurchased[5]);
			bw.newLine();
			bw.write("" + database.weaponsPurchased[6]);
			bw.newLine();
			bw.write("" + database.weaponsPurchased[7]);
			bw.newLine();
			bw.write("" + database.currEquippedWeapon);
			bw.newLine();
			bw.write(database.equippedArmor[0]);
			bw.newLine();
			bw.write(database.equippedArmor[1]);
			bw.newLine();
			bw.write(database.equippedArmor[2]);
			bw.newLine();
			bw.write("" + database.armorsPurchased[0]);
			bw.newLine();
			bw.write("" + database.armorsPurchased[1]);
			bw.newLine();
			bw.write("" + database.armorsPurchased[2]);
			bw.newLine();
			bw.write("" + database.armorsPurchased[3]);
			bw.newLine();
			bw.write("" + database.armorsPurchased[4]);
			bw.newLine();
			bw.write("" + database.armorsPurchased[5]);
			bw.newLine();
			bw.write("" + database.currEquippedArmor);
			bw.newLine();
			bw.write("" + database.amuletNames[0]);
			bw.newLine();
			bw.write("" + database.amuletNames[1]);
			bw.newLine();
			bw.write("" + database.amuletNames[2]);
			bw.newLine();
			bw.write("" + database.amuletNames[3]);
			bw.newLine();
			bw.write("" + database.amuletNames[4]);
			bw.newLine();
			bw.write("" + database.amuletDesc[0]);
			bw.newLine();
			bw.write("" + database.amuletDesc[1]);
			bw.newLine();
			bw.write("" + database.amuletDesc[2]);
			bw.newLine();
			bw.write("" + database.amuletDesc[3]);
			bw.newLine();
			bw.write("" + database.amuletDesc[4]);
			bw.newLine();
			bw.write("" + database.amuletsUnlocked[0]);
			bw.newLine();
			bw.write("" + database.amuletsUnlocked[1]);
			bw.newLine();
			bw.write("" + database.amuletsUnlocked[2]);
			bw.newLine();
			bw.write("" + database.amuletsUnlocked[3]);
			bw.newLine();
			bw.write("" + database.amuletsUnlocked[4]);
			bw.newLine();
			bw.write("" + database.equippedAmulet[0]);
			bw.newLine();
			bw.write("" + database.equippedAmulet[1]);
			bw.newLine();
			bw.write("" + database.currEquippedAmulet);
			bw.newLine();
			bw.write("" + player.getWeapon());
			bw.newLine();
			bw.write("" + player.getArmor());
			bw.newLine();
			bw.write("" + player.getAmulet());
			bw.close();
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
	
	private void Load(String file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			player.setName(line);
			line = br.readLine();
			player.setBuild(line);
			line = br.readLine();
			player.setMaxHealth(Integer.parseInt(line));
			line = br.readLine();
			player.setDamage(Integer.parseInt(line));
			line = br.readLine();
			player.setSpeed(Integer.parseInt(line));
			line = br.readLine();
			player.setAccuracy(Integer.parseInt(line));
			line = br.readLine();
			player.setGold(Integer.parseInt(line));
			line = br.readLine();
			database.setBoss1(Boolean.parseBoolean(line));
			line = br.readLine();
			database.setBoss2(Boolean.parseBoolean(line));
			line = br.readLine();
			database.setBoss3(Boolean.parseBoolean(line));
			line = br.readLine();
			database.setBoss4(Boolean.parseBoolean(line));
			line = br.readLine();
			database.setBoss5(Boolean.parseBoolean(line));
			line = br.readLine();
			database.equippedWeapon[0] = line;
			line = br.readLine();
			database.equippedWeapon[1] = line;
			line = br.readLine();
			database.equippedWeapon[2] = line;
			line = br.readLine();
			database.weaponsPurchased[0] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.weaponsPurchased[1] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.weaponsPurchased[2] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.weaponsPurchased[3] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.weaponsPurchased[4] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.weaponsPurchased[5] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.weaponsPurchased[6] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.weaponsPurchased[7] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.currEquippedWeapon = Integer.parseInt(line);
			line = br.readLine();
			database.equippedArmor[0] = line;
			line = br.readLine();
			database.equippedArmor[1] = line;
			line = br.readLine();
			database.equippedArmor[2] = line;
			line = br.readLine();
			database.armorsPurchased[0] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.armorsPurchased[1] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.armorsPurchased[2] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.armorsPurchased[3] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.armorsPurchased[4] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.armorsPurchased[5] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.currEquippedArmor = Integer.parseInt(line);
			line = br.readLine();
			database.amuletNames[0] = line;
			line = br.readLine();
			database.amuletNames[1] = line;
			line = br.readLine();
			database.amuletNames[2] = line;
			line = br.readLine();
			database.amuletNames[3] = line;
			line = br.readLine();
			database.amuletNames[4] = line;
			line = br.readLine();
			database.amuletDesc[0] = line;
			line = br.readLine();
			database.amuletDesc[1] = line;
			line = br.readLine();
			database.amuletDesc[2] = line;
			line = br.readLine();
			database.amuletDesc[3] = line;
			line = br.readLine();
			database.amuletDesc[4] = line;
			line = br.readLine();
			database.amuletsUnlocked[0] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.amuletsUnlocked[1] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.amuletsUnlocked[2] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.amuletsUnlocked[3] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.amuletsUnlocked[4] = Boolean.parseBoolean(line);
			line = br.readLine();
			database.equippedAmulet[0] = line;
			line = br.readLine();
			database.equippedAmulet[1] = line;
			line = br.readLine();
			database.currEquippedAmulet = Integer.parseInt(line);
			line = br.readLine();
			player.setWeapon(Integer.parseInt(line));
			line = br.readLine();
			player.setArmor(Integer.parseInt(line));
			line = br.readLine();
			player.setAmulet(Integer.parseInt(line));
			br.close();
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
	
	public void displayFile(String file, JRadioButton save) {
		if(new File(file).isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = br.readLine();
				String playerSave = line;
				line = br.readLine();
				playerSave += " (" + line + ")";
				save.setText(playerSave);
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean selectFile(String file) {
		if (new File(file).isFile()) {
			Load(file);
			database.setSave(file);
			return true;
		} else {
			File newFile = new File(file);
			database.setSave(file);
			return false;
		}
	}
	
	public void resetTown() {
		player.setName("na");
		player.setBuild("na");
		player.setMaxHealth(-1);
		player.setDamage(-1);
		player.setSpeed(-1);
		player.setAccuracy(-1);
		player.setGold(-1);
		database.setBoss1(false);
		database.setBoss2(false);
		database.setBoss3(false);
		database.setBoss4(false);
		database.setBoss5(false);
		database.equippedWeapon[0] = "None";
		database.equippedWeapon[1] = "0";
		database.equippedWeapon[2] = "0";
		database.weaponsPurchased[0] = false;
		database.weaponsPurchased[1] = false;
		database.weaponsPurchased[2] = false;
		database.weaponsPurchased[3] = false;
		database.weaponsPurchased[4] = false;
		database.weaponsPurchased[5] = false;
		database.weaponsPurchased[6] = false;
		database.weaponsPurchased[7] = false;
		database.currEquippedWeapon = -1;
		database.equippedArmor[0] = "None";
		database.equippedArmor[1] = "0";
		database.equippedArmor[2] = "0";
		database.armorsPurchased[0] = false;
		database.armorsPurchased[1] = false;
		database.armorsPurchased[2] = false;
		database.armorsPurchased[3] = false;
		database.armorsPurchased[4] = false;
		database.armorsPurchased[5] = false;
		database.currEquippedArmor = -1;
		database.amuletNames[0] = "???";
		database.amuletNames[1] = "???";
		database.amuletNames[2] = "???";
		database.amuletNames[3] = "???";
		database.amuletNames[4] = "???";
		database.amuletDesc[0] = "???";
		database.amuletDesc[1] = "???";
		database.amuletDesc[2] = "???";
		database.amuletDesc[3] = "???";
		database.amuletDesc[4] = "???";
		database.amuletsUnlocked[0] = false;
		database.amuletsUnlocked[1] = false;
		database.amuletsUnlocked[2] = false;
		database.amuletsUnlocked[3] = false;
		database.amuletsUnlocked[4] = false;
		database.equippedAmulet[0] = "None";
		database.equippedAmulet[1] = "0";
		database.currEquippedAmulet = -1;
	}
}
