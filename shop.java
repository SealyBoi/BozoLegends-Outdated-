import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;

public class shop {
	player player = listener.player;
	window window = main.window;

	static int currItemDisplayed;

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
		} // check if player is in weapon or armor shop
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
			} // if item is already equipped, change button to equipped
		} else {
			purchaseItem.setVisible(true);
			equipItem.setVisible(false);
		} // if item is already purchased, change button to equip
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
			} // if item is already equipped, change button to equipped
		} else {
			equipItem.setVisible(false);
		} // if item is already found, change button to equip
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
		} // if player has enough gold, purchase item
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
		} // check if in weapon or armor shop
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
		} // check which amulet player has currently equipped
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
		} // apply amulet stats that player is selecting
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
			} // check if player is in armor shop or item shop
			if (currItemDisplayed >= numberOfItems - 1) {
				nextItem.setBackground(Color.darkGray);
			} // if there is no item after this one, show player they are at the end of the list
			previousItem.setBackground(Color.green);
			if (itemsPurchased[currItemDisplayed]) {
				equipItem.setVisible(true);
				purchaseItem.setVisible(false);
				if (currItemDisplayed == player.getWeapon() && shopName.equals("weapon")
						|| currItemDisplayed == player.getArmor() && shopName.equals("armor")) {
					equipItem.setText("Equipped");
				} else {
					equipItem.setText("Equip");
				} // if weapon/armor is already equipped, show player they already have it equipped
			} else {
				purchaseItem.setVisible(true);
				equipItem.setVisible(false);
			} // if current item has been purchased, display an equip or equipped button instead
		} // if the current item displayed is not the final item, show the next item
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
			} // if there is no item after this one, show player they are at the end of the list
			previousDrop.setBackground(Color.green);
			if (dropsUnlocked[currItemDisplayed]) {
				if (player.getAmulet() == currItemDisplayed) {
					equipDrop.setText("Equipped");
				} else {
					equipDrop.setText("Equip");
				} // if amulet is already equipped, display equipped button
			} else {
				equipDrop.setVisible(false);
			} // if current item has been found, display an equip or equipped button instead
		} // if the current item displayed is not the final item, show the next item
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
			} // check if in weapon or armor shop
			if (currItemDisplayed <= 0) {
				previousItem.setBackground(Color.darkGray);
			} // if item before this one does not exist, show player they are at the beginning of the list
			nextItem.setBackground(Color.green);
			if (itemsPurchased[currItemDisplayed]) {
				equipItem.setVisible(true);
				purchaseItem.setVisible(false);
				if (currItemDisplayed == player.getWeapon() && shopName.equals("weapon")
						|| currItemDisplayed == player.getArmor() && shopName.equals("armor")) {
					equipItem.setText("Equipped");
				} else {
					equipItem.setText("Equip");
				} // if item is already equipped, display equipped button
			} else {
				purchaseItem.setVisible(true);
				equipItem.setVisible(false);
			} // if item is already purchased, display equip button
		} // if item displayed is not the first item in the list, move to previous item
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
			} // if item before this one does not exist, show player they are at the beginning of the list
			nextDrop.setBackground(Color.green);
			if (dropsUnlocked[currItemDisplayed]) {
				equipDrop.setVisible(true);
				if (player.getAmulet() == currItemDisplayed) {
					equipDrop.setText("Equipped");
				} else {
					equipDrop.setText("Equip");
				} // if item is already equipped, display equipped button
			} else {
				equipDrop.setVisible(false);
			} // if item is already found, display equip button
		} // if item displayed is not the first item in the list, move to previous item
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
		} // if player has enough gold and not max accuracy, increase stat
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
		} // if player has enough gold and not max speed, increase stat
	}
}