import java.util.Random;

import javax.swing.JOptionPane;

public class dungeon {
	enemy enemy = listener.enemy;
	player player = listener.player;
	window window = main.window;

	Random generator = new Random(System.currentTimeMillis());
	int rand;

	public void createRoom(String[] enemyNames, int[] enemyStats, boolean firstRoom) {
		rand = generator.nextInt(4);
		enemy.setName(enemyNames[rand]);
		enemy.setHealth((enemyStats[0] / 2) + generator.nextInt(enemyStats[0] / 2) + 1);
		enemy.setDamage(generator.nextInt(enemyStats[1]) + 1);
		enemy.setSpeed(generator.nextInt(enemyStats[2]));
		enemy.setAccuracy(enemyStats[3] + 2);
		window.currentEnemyName.setText(enemy.getName());
		window.currentEnemyHealth.setText("Enemy HP: " + enemy.getHealth());
		window.playerNameLabel.setText(player.getName());
		window.playerHealthLabel.setText("Your HP: " + player.getHealth());
		if (firstRoom) {
			player.setSMC(2);
			window.currentRoom.setText("Room 1");
		} else {
			if (player.getSMC() < 2) {
				player.setSMC(player.getSMC() + 1);
			}
		}
		if (player.getSpeed() < enemy.getSpeed()) {
			player.setHealth(player.getHealth() - enemy.getDamage());
			window.playerHealthLabel.setText("Your HP: " + player.getHealth());
			JOptionPane.showMessageDialog(window.window, "The enemy was faster than you and struck first!");
		}
	}

	public void createBoss(String name, int health, int damage, int speed, int accuracy) {
		enemy.setName(name);
		enemy.setHealth(health);
		enemy.setDamage(damage);
		enemy.setSpeed(speed);
		enemy.setAccuracy(accuracy);
		window.currentRoom.setText("Boss Room");
		window.currentEnemyName.setText(enemy.getName());
		window.currentEnemyHealth.setText("Enemy HP: " + enemy.getHealth());
		window.playerNameLabel.setText(player.getName());
		window.playerHealthLabel.setText("Your HP: " + player.getHealth());
		if (player.getSMC() < 2) {
			player.setSMC(player.getSMC() + 1);
		}
		if (player.getSpeed() < enemy.getSpeed()) {
			player.setHealth(player.getHealth() - enemy.getDamage());
			window.playerHealthLabel.setText("Your HP: " + player.getHealth());
			JOptionPane.showMessageDialog(window.window, "The enemy was faster than you and struck first!");
			if (player.getHealth() <= 0) {
				window.dungeonPanel.setVisible(false);
				window.townPanel.setVisible(true);
				JOptionPane.showMessageDialog(window.window,
						"You passed out from all of your injuries and were brought back to town! The doctor took some of your gold as expenses!");
				player.setGold(player.getGold() - player.getGold() / 20);
				window.goldCounter.setText("Gold: " + player.getGold());
			}
		}
	}

	public boolean playerDead() {
		if (player.getHealth() <= 0) {
			JOptionPane.showMessageDialog(window.window,
					"You passed out from all of your injuries and were brought back to town! The doctor took some of your gold as expenses!");
			player.setGold(player.getGold() - player.getGold() / 20);
			window.goldCounter.setText("Gold: " + player.getGold());
			return true;
		} else {
			return false;
		}
	}

	public boolean[] enemyDead(int room, int floor, boolean boss1, boolean boss2, boolean boss3, boolean boss4,
			boolean boss5) {
		boolean[] deadAndBoss = {false, false, false};
		if (enemy.getHealth() <= 0) {
			deadAndBoss[0] = true;
			int tempGold = 0;
			int dropAmulet = generator.nextInt();
			switch (floor) {
			case 1:
				if (boss1 || room < 10) {
					tempGold = generator.nextInt(10) + 5;
				} else {
					deadAndBoss[1] = true;
					tempGold = 50;
				}
				break;
			case 2:
				if (boss2 || room < 10) {
					tempGold = generator.nextInt(20) + 15;
				} else {
					deadAndBoss[1] = true;
					tempGold = 150;
				}
				break;
			case 3:
				if (boss3 || room < 10) {
					tempGold = generator.nextInt(30) + 25;
				} else {
					deadAndBoss[1] = true;
					tempGold = 250;
				}
				break;
			case 4:
				if (boss4 || room < 10) {
					tempGold = generator.nextInt(40) + 35;
				} else {
					deadAndBoss[1] = true;
					tempGold = 350;
				}
				break;
			case 5:
				if (boss5 || room < 10) {
					tempGold = generator.nextInt(50) + 45;
				} else {
					deadAndBoss[1] = true;
					tempGold = 450;
				}
				break;
			}
			if (dropAmulet == 0) {
				deadAndBoss[2] = true;
			}
			if (deadAndBoss[1]) {
				JOptionPane.showMessageDialog(window.window,
						"You have defeated the boss and completed this floor!  You gained " + tempGold + " gold!");
				player.setGold(player.getGold() + tempGold);
			} else {
				JOptionPane.showMessageDialog(window.window,
						"You defeated the enemy and gained " + tempGold + " gold!");
				player.setGold(player.getGold() + tempGold);
			}
		}
		return deadAndBoss;
	}
}
