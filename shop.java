import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;

public class shop {
	player player = listener.player;
	window window = main.window;

	private int currItemDisplayed = 0;

	public void enterShop(String shopName, JLabel itemName, JLabel itemCost, JLabel itemMod, String[] itemNames,
			int[] itemPrices, int[] itemMods, JLabel itemDisplayedCounter, JButton previousItem, JButton nextItem,
			int numberOfItems, boolean[] itemsPurchased, JButton equipItem, JButton purchaseItem) {
		itemName.setText(itemNames[0]);
		itemCost.setText(itemPrices[0] + " Gold");
		switch (shopName) {
		case "weapon":
			itemMod.setText((itemMods[0] - 2) + "-" + (itemMods[0] + 1) + " Damage");
			break;
		case "armor":
			itemMod.setText((itemMods[0] + " Extra Health"));
			break;
		}
		currItemDisplayed = 0;
		itemDisplayedCounter.setText((currItemDisplayed + 1) + "/" + numberOfItems);
		previousItem.setBackground(Color.darkGray);
		nextItem.setBackground(Color.green);
		if (itemsPurchased[0]) {
			equipItem.setVisible(true);
			purchaseItem.setVisible(false);
			if (currItemDisplayed == player.getWeapon() && shopName.equals("weapon")
					|| currItemDisplayed == player.getArmor() && shopName.equals("armor")) {
				equipItem.setText("Equipped");
			} else {
				equipItem.setText("Equip");
			}
		} else {
			purchaseItem.setVisible(true);
			equipItem.setVisible(false);
		}
	}

	public void enterDrops(JLabel itemName, JLabel itemDesc, String[] itemNames, String[] itemDescs,
			JLabel itemDisplayedCounter, JButton previousItem, JButton nextItem, int numberOfItems,
			boolean[] itemsUnlocked, JButton equipItem) {
		itemName.setText(itemNames[0]);
		itemDesc.setText(itemDescs[0]);
		currItemDisplayed = 0;
		itemDisplayedCounter.setText((currItemDisplayed + 1) + "/" + numberOfItems);
		previousItem.setBackground(Color.darkGray);
		nextItem.setBackground(Color.green);
		if (itemsUnlocked[0]) {
			equipItem.setVisible(true);
			if (currItemDisplayed == player.getAmulet()) {
				equipItem.setText("Equipped");
			} else {
				equipItem.setText("Equip");
			}
		} else {
			equipItem.setVisible(false);
		}
	}

	public boolean purchaseItem(int[] itemPrices, boolean[] itemsPurchased, JButton purchaseItem, JButton equipItem) {
		if (itemPrices[currItemDisplayed] <= player.getGold()) {
			player.setGold(player.getGold() - itemPrices[currItemDisplayed]);
			itemsPurchased[currItemDisplayed] = true;
			purchaseItem.setVisible(false);
			equipItem.setVisible(true);
			equipItem.setText("Equip");
			return true;
		} else {
			return false;
		}
	}

	public void equipItem(String shopName, String[] equippedItem, JButton equipItem, JLabel townItemEquipped,
			String[] itemNames, int[] itemPrices, int[] itemMods) {
		equippedItem[0] = itemNames[currItemDisplayed];
		equippedItem[1] = "" + itemPrices[currItemDisplayed];
		equippedItem[2] = "" + itemMods[currItemDisplayed];
		equipItem.setText("Equipped");
		player.setDamage(itemMods[currItemDisplayed]);
		switch (shopName) {
		case "weapon":
			townItemEquipped.setText("Weapon: " + equippedItem[0]);
			player.setWeapon(currItemDisplayed);
			break;
		case "armor":
			townItemEquipped.setText("Armor: " + equippedItem[0]);
			player.setArmor(currItemDisplayed);
			break;
		}
	}

	public void equipAmulet(String[] equippedAmulet, String[] amuletNames, int[] amuletMods, JButton equipAmulet,
			JLabel townAmuletEquipped) {
		switch (player.getAmulet()) {
		case 0:
			player.setAccuracy(player.getAccuracy() - Integer.parseInt(equippedAmulet[1]));
			break;
		case 1:
			player.setSpeed(player.getSpeed() - Integer.parseInt(equippedAmulet[1]));
			break;
		case 2:
			player.setMaxHealth(player.getMaxHealth() - Integer.parseInt(equippedAmulet[1]));
			break;
		case 3:
			player.setDamage(player.getMaxHealth() - Integer.parseInt(equippedAmulet[1]));
			break;
		case 4:
			player.setDG(false);
			break;
		}
		equippedAmulet[0] = amuletNames[currItemDisplayed];
		equippedAmulet[1] = "" + amuletMods[currItemDisplayed];
		equipAmulet.setText("Equipped");
		player.setAmulet(currItemDisplayed);
		switch (player.getAmulet()) {
		case 0:
			player.setAccuracy(player.getAccuracy() + Integer.parseInt(equippedAmulet[1]));
			break;
		case 1:
			player.setSpeed(player.getSpeed() + Integer.parseInt(equippedAmulet[1]));
			break;
		case 2:
			player.setMaxHealth(player.getMaxHealth() + Integer.parseInt(equippedAmulet[1]));
			break;
		case 3:
			player.setDamage(player.getDamage() + Integer.parseInt(equippedAmulet[1]));
			break;
		case 4:
			player.setDG(true);
			break;
		}
		townAmuletEquipped.setText("Amulet: " + equippedAmulet[0]);
	}

	public void nextItem(String shopName, int numberOfItems, JLabel itemDisplayedCounter, JLabel itemName,
			JLabel itemCost, JLabel itemMod, String[] itemNames, int[] itemPrices, int[] itemMods, JButton nextItem,
			JButton previousItem, boolean[] itemsPurchased, JButton equipItem, JButton purchaseItem) {
		if (currItemDisplayed < numberOfItems - 1) {
			currItemDisplayed++;
			itemDisplayedCounter.setText((currItemDisplayed + 1) + "/" + numberOfItems);
			itemName.setText(itemNames[currItemDisplayed]);
			itemCost.setText(itemPrices[currItemDisplayed] + " Gold");
			switch (shopName) {
			case "weapon":
				itemMod.setText(
						(itemMods[currItemDisplayed] - 2) + "-" + (itemMods[currItemDisplayed] + 1) + " Damage");
				break;
			case "armor":
				itemMod.setText(itemMods[currItemDisplayed] + " Extra Health");
				break;
			}
			if (currItemDisplayed >= numberOfItems - 1) {
				nextItem.setBackground(Color.darkGray);
			}
			previousItem.setBackground(Color.green);
			if (itemsPurchased[currItemDisplayed]) {
				equipItem.setVisible(true);
				purchaseItem.setVisible(false);
				if (currItemDisplayed == player.getWeapon() && shopName.equals("weapon")
						|| currItemDisplayed == player.getArmor() && shopName.equals("armor")) {
					equipItem.setText("Equipped");
				} else {
					equipItem.setText("Equip");
				}
			} else {
				purchaseItem.setVisible(true);
				equipItem.setVisible(false);
			}
		}
	}

	public void nextDrop(JLabel dropDisplayedCounter, JLabel dropName, JLabel dropDesc, String[] dropNames,
			String[] dropDescs, int numberOfDrops, JButton nextDrop, JButton previousDrop, boolean dropsUnlocked[],
			JButton equipDrop) {
		if (currItemDisplayed < numberOfDrops - 1) {
			currItemDisplayed++;
			dropDisplayedCounter.setText((currItemDisplayed + 1) + "/" + numberOfDrops);
			dropName.setText(dropNames[currItemDisplayed]);
			dropDesc.setText(dropDescs[currItemDisplayed]);
			if (currItemDisplayed >= numberOfDrops - 1) {
				nextDrop.setBackground(Color.darkGray);
			}
			previousDrop.setBackground(Color.green);
			if (dropsUnlocked[currItemDisplayed]) {
				if (player.getAmulet() == currItemDisplayed) {
					equipDrop.setText("Equipped");
				} else {
					equipDrop.setText("Equip");
				}
			} else {
				equipDrop.setVisible(false);
			}
		}
	}

	public void previousItem(String shopName, int numberOfItems, JLabel itemDisplayedCounter, JLabel itemName,
			JLabel itemCost, JLabel itemMod, String[] itemNames, int[] itemPrices, int[] itemMods, JButton nextItem,
			JButton previousItem, boolean[] itemsPurchased, JButton equipItem, JButton purchaseItem) {
		if (currItemDisplayed > 0) {
			currItemDisplayed--;
			itemDisplayedCounter.setText((currItemDisplayed + 1) + "/" + numberOfItems);
			itemName.setText(itemNames[currItemDisplayed]);
			itemCost.setText(itemPrices[currItemDisplayed] + " Gold");
			switch (shopName) {
			case "weapon":
				itemMod.setText(
						(itemMods[currItemDisplayed] - 2) + "-" + (itemMods[currItemDisplayed] + 1) + " Damage");
				break;
			case "armor":
				itemMod.setText(itemMods[currItemDisplayed] + " Extra Health");
				break;
			}
			if (currItemDisplayed <= 0) {
				previousItem.setBackground(Color.darkGray);
			}
			nextItem.setBackground(Color.green);
			if (itemsPurchased[currItemDisplayed]) {
				equipItem.setVisible(true);
				purchaseItem.setVisible(false);
				if (currItemDisplayed == player.getWeapon() && shopName.equals("weapon")
						|| currItemDisplayed == player.getArmor() && shopName.equals("armor")) {
					equipItem.setText("Equipped");
				} else {
					equipItem.setText("Equip");
				}
			} else {
				purchaseItem.setVisible(true);
				equipItem.setVisible(false);
			}
		}
	}

	public void previousDrop(JLabel dropDisplayedCounter, JLabel dropName, JLabel dropDesc, String[] dropNames,
			String[] dropDescs, int numberOfDrops, JButton nextDrop, JButton previousDrop, boolean dropsUnlocked[],
			JButton equipDrop) {
		if (currItemDisplayed > 0) {
			currItemDisplayed--;
			dropDisplayedCounter.setText((currItemDisplayed + 1) + "/" + numberOfDrops);
			dropName.setText(dropNames[currItemDisplayed]);
			dropDesc.setText(dropDescs[currItemDisplayed]);
			if (currItemDisplayed <= 0) {
				previousDrop.setBackground(Color.darkGray);
			}
			nextDrop.setBackground(Color.green);
			if (dropsUnlocked[currItemDisplayed]) {
				equipDrop.setVisible(true);
				if (player.getAmulet() == currItemDisplayed) {
					equipDrop.setText("Equipped");
				} else {
					equipDrop.setText("Equip");
				}
			} else {
				equipDrop.setVisible(false);
			}
		}
	}

	public void increaseAccuracy(int cost, int increase) {
		if (player.getGold() >= cost && player.getAccuracy() != 100) {
			player.setGold(player.getGold() - cost);
			player.setAccuracy(player.getAccuracy() + increase);
			window.displayAccuracy.setText("Your Accuracy: " + player.getAccuracy());
		} else if (player.getAccuracy() == 100) {
			JOptionPane.showMessageDialog(window.window, "I LIKE PENNIES! (You can't increase this any more stoopid)");
		} else {
			JOptionPane.showMessageDialog(window.window, "I LIKE PENNIES! (You don't have enough money dummy)");
		}
	}

	public void increaseSpeed(int cost, int increase) {
		if (player.getGold() >= cost && player.getSpeed() != 10) {
			player.setGold(player.getGold() - cost);
			player.setSpeed(player.getSpeed() + increase);
			window.displaySpeed.setText("Your Speed: " + player.getSpeed());
		} else if (player.getSpeed() == 10) {
			JOptionPane.showMessageDialog(window.window, "I LIKE QUARTERS! (You can't increase this any more stoopid)");
		} else {
			JOptionPane.showMessageDialog(window.window, "I LIKE QUARTERS! (You don't have enough money dummy)");
		}
	}
}
