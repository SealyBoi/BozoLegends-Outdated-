import java.awt.*;
import javax.swing.*;

public class window {
	windowManagement wm = new windowManagement();
	
	JFrame window;
	JPanel mainMenuPanel, characterCreationPanel, classSelectionPanel, enterNamePanel, introductionPanel, townPanel,
			townSelectPanel, dungeonPanel, dungeonOptionsPanel, dungeonEnemyDefeatedPanel, weaponShopPanel,
			currentWeaponDisplay, armorShopPanel, currentArmorDisplay, floorSelectPanel, floorSelectButtonsPanel,
			saveSelectPanel, saveSelectButtonsPanel, trainingPanel, accuracyPanel, speedPanel, amuletPanel,
			amuletDisplay, ffTrialPanel, sfTrialPanel, tfTrialPanel, fofTrialPanel, fifTrialPanel, trialsSelectPanel;
	JButton playGame, quitGame, confirmClass, confirmPlayerName, continueIntro, continueIntro2, weaponShop, armorShop,
			dungeonEntrance, dungeonLightAttack, dungeonHeavyAttack, dungeonSpecialMove, dungeonFlee, dungeonContinue,
			dungeonLeave, continueBoss1, purchaseWeapon, equipWeapon, leaveWeaponShop, nextWeapon, previousWeapon,
			purchaseArmor, equipArmor, leaveArmorShop, nextArmor, previousArmor, selectFloor, leaveFloorSelection,
			continueBoss2, continueBoss3, continueBoss4, continueBoss5, selectSave, leaveSaveSelection, leaveTown,
			accuracy1, accuracy2, accuracy3, speed1, speed2, speed3, trainingGrounds, leaveTrainingGrounds, equipAmulet,
			leaveAmuletShop, amuletShop, nextAmulet, previousAmulet, trials, selectTrial, leaveTrialSelection;
	JLabel title, classSelection, warriorBio, mercenaryBio, paladinBio, enterName, currentEnemyName, currentEnemyHealth,
			playerHealthLabel, playerNameLabel, goldCounter, currentRoom, weaponName, weaponCost, weaponDamage,
			weaponDisplayedCounter, armorName, armorCost, armorHealth, armorDisplayedCounter, townWeaponEquipped,
			townArmorEquipped, accuracy1Cost, accuracy2Cost, accuracy3Cost, speed1Cost, speed2Cost, speed3Cost,
			displayAccuracy, displaySpeed, amuletName, amuletDescription, amuletDisplayedCounter, townAmuletEquipped;
	JRadioButton warriorClass, mercenaryClass, paladinClass, firstFloor, secondFloor, thirdFloor, fourthFloor,
			fifthFloor, save1, save2, save3, save4, save5, firstTrial, secondTrial, thirdTrial, fourthTrial, fifthTrial;
	JTextField playerName;
	JTabbedPane trialsButtonsPanel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 84);
	static Font textFont = new Font("Times New Roman", Font.PLAIN, 32);
	Font shopFont = new Font("Times New Roman", Font.PLAIN, 24);
	private static JDialog intro1, intro2, boss1, boss2, boss3, boss4, boss5;
	
	public void displayDialog(String name) {
		if (name.equals("intro1")) {
			intro1.setVisible(true);
		} else if (name.equals("intro2")) {
			intro2.setVisible(true);
		} else if (name.equals("boss1")) {
			boss1.setVisible(true);
		} else if (name.equals("boss2")) {
			boss2.setVisible(true);
		} else if (name.equals("boss3")) {
			boss3.setVisible(true);
		} else if (name.equals("boss4")) {
			boss4.setVisible(true);
		} else if (name.equals("boss5")) {
			boss5.setVisible(true);
		}
	}
	
	public void hideDialog(String name) {
		if (name.equals("intro1")) {
			intro1.setVisible(false);
		} else if (name.equals("intro2")) {
			intro2.setVisible(false);
		} else if (name.equals("boss1")) {
			boss1.setVisible(false);
		} else if (name.equals("boss2")) {
			boss2.setVisible(false);
		} else if (name.equals("boss3")) {
			boss3.setVisible(false);
		} else if (name.equals("boss4")) {
			boss4.setVisible(false);
		} else if (name.equals("boss5")) {
			boss5.setVisible(false);
		}
	}
	
	public void window() {
		// Main Menu Panel
				mainMenuPanel = wm.createPanel(mainMenuPanel, 0, 0, 900, 650, Color.black);
				playGame = wm.createButton(playGame, "Play Game", 350, 280, 200, 50, Color.gray);
				quitGame = wm.createButton(quitGame, "Quit Game", 350, 350, 200, 50, Color.gray);
				title = wm.createLabel(title, "Bozo Legends", titleFont, 230, 100, 500, 100, Color.yellow);
				mainMenuPanel.add(playGame);
				mainMenuPanel.add(quitGame);
				mainMenuPanel.add(title);
				mainMenuPanel.setVisible(true);
				
				// Character Creation Panel
				characterCreationPanel = wm.createPanel(characterCreationPanel, 0, 0, 900, 650, Color.black);
				classSelectionPanel = wm.createPanel(classSelectionPanel, 45, 90, 800, 350, Color.gray);
				classSelectionPanel.setVisible(false);
				characterCreationPanel.add(classSelectionPanel);
				classSelection = wm.createLabel(classSelection, "Select a class:", textFont, 20, 30, 200, 30, Color.black);
				classSelectionPanel.add(classSelection);
				warriorClass = wm.createRB(warriorClass, "Warrior", 100, 80, 100, 30);
				mercenaryClass = wm.createRB(mercenaryClass, "Mercenary", 220, 80, 100, 30);
				paladinClass = wm.createRB(paladinClass, "Paladin", 340, 80, 100, 30);
				ButtonGroup classSelectionButtons = new ButtonGroup();
				classSelectionButtons.add(warriorClass);
				classSelectionButtons.add(mercenaryClass);
				classSelectionButtons.add(paladinClass);
				classSelectionPanel.add(warriorClass);
				classSelectionPanel.add(mercenaryClass);
				classSelectionPanel.add(paladinClass);
				warriorBio = wm.createLabel(warriorBio, "Warrior[HP: 18, Damage: 2, Speed: 4, Accuracy: 84] Special Move: Heal for 1/3 of max health.", null, 100, 120, 900, 30, null);
				mercenaryBio = wm.createLabel(mercenaryBio, "Mercenary[HP: 14, Damage: 3, Speed: 1, Accuracy: 72] Special Move: Guaranteed Heavy Attack.", null, 100, 150, 900, 30, null);
				paladinBio = wm.createLabel(paladinBio, "Paladin[HP: 22, Damage: 1, Speed: 2, Accuracy: 80] Special Move: Damage enemy and heal for 1/5 of max health.", null, 100, 180, 900, 30, null);
				classSelectionPanel.add(warriorBio);
				classSelectionPanel.add(mercenaryBio);
				classSelectionPanel.add(paladinBio);
				classSelectionPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				confirmClass = wm.createButton(confirmClass, "Confirm Class", 325, 270, 150, 50, Color.lightGray);
				classSelectionPanel.add(confirmClass);
				enterNamePanel = wm.createPanel(enterNamePanel, 45, 90, 800, 350, Color.gray);
				enterNamePanel.setVisible(false);
				enterNamePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				characterCreationPanel.add(enterNamePanel);
				enterName = wm.createLabel(enterName, "Enter your character's name: ", textFont, 230, 80, 400, 50, null);
				enterNamePanel.add(enterName);
				playerName = new JTextField("");
				playerName.setBounds(210, 150, 400, 30);
				enterNamePanel.add(playerName);
				confirmPlayerName = wm.createButton(confirmPlayerName, "Confirm Name", 325, 270, 150, 50, Color.lightGray);
				enterNamePanel.add(confirmPlayerName);
				characterCreationPanel.setVisible(false);
				
				// Introduction Panel
				introductionPanel = wm.createPanel(introductionPanel, 0, 0, 900, 650, Color.black);
				intro1 = new JDialog(window, "Introduction", true);
				intro1.setLayout(new FlowLayout());
				continueIntro = wm.createButton(continueIntro, "Continue", 0, 0, 0, 0, Color.lightGray);
				intro1.add(new JLabel("Long long ago, there was legend of a true bozo warrior."));
				intro1.add(new JLabel("He was fabled to be the strongest in the land, with weapons of mass destruction"));
				intro1.add(new JLabel("that could only be dreamt up by the imagination. After his time passed,"));
				intro1.add(new JLabel("darkness rose again to reclaim their lost kingdom. It is up to you now intrepid"));
				intro1.add(new JLabel("adventurer. Reclaim our land! Slay the four Kings of Darkness! SAVE US!"));
				intro1.setLocation(200, 200);
				intro1.add(continueIntro);
				intro1.setSize(550, 200);
				intro2 = new JDialog(window, "Introduction", false);
				intro2.setLayout(new FlowLayout());
				continueIntro2 = wm.createButton(continueIntro2, "Continue", 0, 0, 0, 0, Color.lightGray);
				intro2.add(new JLabel("'You...adventurer...what is your name? Not a speaker, eh? Hm. Peculiar."));
				intro2.add(new JLabel("You seek to save us yet from this dire situation we find ourselves in, yes?"));
				intro2.add(new JLabel("Well in that case you will need tools. Head to town down the road from here."));
				intro2.add(new JLabel("There you will find multiple shops with the things you will need. And here, take"));
				intro2.add(new JLabel("this gold to start you off. It should be enough to get yourself a weapon. Good luck.'"));
				intro2.setLocation(200, 200);
				intro2.add(continueIntro2);
				intro2.setSize(550, 200);
				introductionPanel.setVisible(false);
				
				// Boss 1
				boss1 = new JDialog(window, "Floor Boss", false);
				boss1.setLayout(new FlowLayout());
				continueBoss1 = wm.createButton(continueBoss1, "Continue", 0, 0, 0, 0, Color.lightGray);
				boss1.add(new JLabel("You walk to the end of the graveyard to find a large shadow looming over you."));
				boss1.add(new JLabel("The shadow notices you and begins to grow bigger as it approaches."));
				boss1.add(new JLabel("All of a sudden, the shadow shrinks, and a small gnome appears in the doorway"));
				boss1.add(new JLabel("wielding a tiny hammer. He yells 'GIMME THEM TOES BITCH"));
				boss1.setLocation(200, 200);
				boss1.add(continueBoss1);
				boss1.setSize(550, 200);
				
				// Boss 2
				boss2 = new JDialog(window, "Floor Boss", false);
				boss2.setLayout(new FlowLayout());
				boss2.add(new JLabel("As the forest grows darker the trees grow closer together, making it"));
				boss2.add(new JLabel("difficult to navigate the terrain. The trees suddenly part ways to reveal"));
				boss2.add(new JLabel("a small clearing, with a tree standing tall in the center. The tree begins"));
				boss2.add(new JLabel("to move, with no intention of letting you leave it's domain alive."));
				boss2.setLocation(200, 200);
				boss2.setSize(550, 200);
				continueBoss2 = wm.createButton(continueBoss2, "Continue", 0, 0, 0, 0, Color.lightGray);
				boss2.add(continueBoss2);

				// Boss 3
				boss3 = new JDialog(window, "Floor Boss", false);
				boss3.setLayout(new FlowLayout());
				boss3.add(new JLabel("The library halls converge into a main study area, with a cauldron in the"));
				boss3.add(new JLabel("middle. Smoke begins to rise from the cauldron as an entity makes its"));
				boss3.add(new JLabel("known. The being looks down upon you, ready to take you from this world."));
				boss3.setLocation(200, 200);
				boss3.setSize(550, 200);
				continueBoss3 = wm.createButton(continueBoss3, "Continue", 0, 0, 0, 0, Color.lightGray);
				boss3.add(continueBoss3);

				// Boss 4
				boss4 = new JDialog(window, "Floor Boss", false);
				boss4.setLayout(new FlowLayout());
				boss4.add(new JLabel("The shadows collect into one spot and form a man in a cloak. With dagger"));
				boss4.add(new JLabel("in hand, he stares you down with a menacing grin. He extends his hand out"));
				boss4.add(new JLabel("and beckons you forward to make the first move."));
				boss4.setLocation(200, 200);
				boss4.setSize(550, 200);
				continueBoss4 = wm.createButton(continueBoss4, "Continue", 0, 0, 0, 0, Color.lightGray);
				boss4.add(continueBoss4);

				// Boss 5
				boss5 = new JDialog(window, "Floor Boss", false);
				boss5.setLayout(new FlowLayout());
				boss5.add(new JLabel("The corridors lead you to the king's hall, where a knight in golden armor"));
				boss5.add(new JLabel("awaits. 'It has been a while since I have faced a bozo of such renown', he"));
				boss5.add(new JLabel("says. 'Come forth bozo. Prove the legends of you are as true as many make"));
				boss5.add(new JLabel("them seem to be.'"));
				boss5.setLocation(200, 200);
				boss5.setSize(550, 200);
				continueBoss5 = wm.createButton(continueBoss5, "Continue", 0, 0, 0, 0, Color.lightGray);
				boss5.add(continueBoss5);

				// Town Panel
				townPanel = wm.createPanel(townPanel, 0, 0, 900, 650, Color.black);
				townSelectPanel = wm.createPanel(townSelectPanel, 45, 220, 800, 350, Color.gray);
				townSelectPanel.setVisible(false);
				townSelectPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				townPanel.add(townSelectPanel);
				weaponShop = wm.createButton(weaponShop, "Weapon Shop", 50, 80, 200, 50, Color.lightGray);
				townSelectPanel.add(weaponShop);
				armorShop = wm.createButton(armorShop, "Armor Shop", 50, 160, 200, 50, Color.lightGray);
				townSelectPanel.add(armorShop);
				dungeonEntrance = wm.createButton(dungeonEntrance, "Dungeon Entrance", 50, 240, 200, 50, Color.lightGray);
				townSelectPanel.add(dungeonEntrance);
				trainingGrounds = wm.createButton(trainingGrounds, "Training Grounds", 300, 80, 200, 50, Color.lightGray);
				townSelectPanel.add(trainingGrounds);
				amuletShop = wm.createButton(amuletShop, "Amulets", 300, 160, 200, 50, Color.lightGray);
				townSelectPanel.add(amuletShop);
				trials = wm.createButton(trials, "Bozo Trials", 300, 240, 200, 50, Color.lightGray);
				townSelectPanel.add(trials);
				//trials.setVisible(false);
				leaveTown = wm.createButton(leaveTown, "Return to Menu", 550, 240, 200, 50, Color.lightGray);
				townSelectPanel.add(leaveTown);
				goldCounter = wm.createLabel(goldCounter, "", textFont, 550, 10, 300, 80, Color.yellow);
				goldCounter.setHorizontalAlignment(SwingConstants.RIGHT);
				townWeaponEquipped = wm.createLabel(townWeaponEquipped, "Weapon: Fists", textFont, 40, 10, 500, 80, Color.white);
				townWeaponEquipped.setHorizontalAlignment(SwingConstants.LEFT);
				townArmorEquipped = wm.createLabel(townArmorEquipped, "Armor: None", textFont, 40, 50, 500, 80, Color.white);
				townArmorEquipped.setHorizontalAlignment(SwingConstants.LEFT);
				townAmuletEquipped = wm.createLabel(townAmuletEquipped, "Amulet: None", textFont, 40, 90, 500, 80, Color.white);
				townAmuletEquipped.setHorizontalAlignment(SwingConstants.LEFT);
				townPanel.add(townWeaponEquipped);
				townPanel.add(townArmorEquipped);
				townPanel.add(townAmuletEquipped);
				townPanel.add(goldCounter);
				townPanel.setVisible(false);

				// Training Panel
				trainingPanel = wm.createPanel(trainingPanel, 0, 0, 900, 650, Color.black);
				accuracyPanel = wm.createPanel(accuracyPanel, 100, 75, 300, 400, Color.gray);
				accuracyPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				accuracyPanel.setLayout(null);
				trainingPanel.add(accuracyPanel);
				displayAccuracy = wm.createLabel(displayAccuracy, "Your Accuracy: ", shopFont, 50, 20, 200, 50, null);
				displayAccuracy.setHorizontalAlignment(SwingConstants.CENTER);
				accuracyPanel.add(displayAccuracy);
				accuracy1 = wm.createButton(accuracy1, "Accuracy +1", 50, 95, 200, 50, Color.lightGray);
				accuracy1Cost = wm.createLabel(accuracy1Cost, "100 Gold", shopFont, 50, 135, 200, 50, null);
				accuracy1Cost.setHorizontalAlignment(SwingConstants.CENTER);
				accuracyPanel.add(accuracy1);
				accuracyPanel.add(accuracy1Cost);
				accuracy2 = wm.createButton(accuracy2, "Accuracy +2", 50, 195, 200, 50, Color.lightGray);
				accuracy2Cost = wm.createLabel(accuracy2Cost, "180 Gold", shopFont, 50, 235, 200, 50, null);
				accuracy2Cost.setHorizontalAlignment(SwingConstants.CENTER);
				accuracyPanel.add(accuracy2);
				accuracyPanel.add(accuracy2Cost);
				accuracy3 = wm.createButton(accuracy3, "Accuracy +3", 50, 295, 200, 50, Color.lightGray);
				accuracy3Cost = wm.createLabel(accuracy3Cost, "240 Gold", shopFont, 50, 335, 200, 50, null);
				accuracy3Cost.setHorizontalAlignment(SwingConstants.CENTER);
				accuracyPanel.add(accuracy3);
				accuracyPanel.add(accuracy3Cost);
				speedPanel = wm.createPanel(speedPanel, 475, 75, 300, 400, Color.gray);
				speedPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				trainingPanel.add(speedPanel);
				displaySpeed = wm.createLabel(displaySpeed, "Your Speed: ", shopFont, 50, 20, 200, 50, null);
				displaySpeed.setHorizontalAlignment(SwingConstants.CENTER);
				speedPanel.add(displaySpeed);
				speed1 = wm.createButton(speed1, "Speed +1", 50, 95, 200, 50, Color.lightGray);
				speed1Cost = wm.createLabel(speed1Cost, "175 Gold", shopFont, 50, 135, 200, 50, null);
				speed1Cost.setHorizontalAlignment(SwingConstants.CENTER);
				speedPanel.add(speed1);
				speedPanel.add(speed1Cost);
				speed2 = wm.createButton(speed2, "Speed +2", 50, 195, 200, 50, Color.lightGray);
				speed2Cost = wm.createLabel(speed2Cost, "250 Gold", shopFont, 50, 235, 200, 50, null);
				speed2Cost.setHorizontalAlignment(SwingConstants.CENTER);
				speedPanel.add(speed2);
				speedPanel.add(speed2Cost);
				speed3 = wm.createButton(speed3, "Speed +3", 50, 295, 200, 50, Color.lightGray);
				speed3Cost = wm.createLabel(speed3Cost, "310 Gold", shopFont, 50, 335, 200, 50, null);
				speed3Cost.setHorizontalAlignment(SwingConstants.CENTER);
				speedPanel.add(speed3);
				speedPanel.add(speed3Cost);
				leaveTrainingGrounds = wm.createButton(leaveTrainingGrounds, "Return to Town", 363, 500, 150, 40, Color.lightGray);
				trainingPanel.add(leaveTrainingGrounds);
				trainingPanel.setVisible(false);

				// Save Select Panel
				saveSelectPanel = wm.createPanel(saveSelectPanel, 0, 0, 900, 650, Color.black);
				saveSelectButtonsPanel = wm.createPanel(saveSelectButtonsPanel, 300, 50, 300, 500, Color.gray);
				saveSelectButtonsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				saveSelectPanel.add(saveSelectButtonsPanel);
				save1 = wm.createRB(save1, "Empty Save", 25, 50, 250, 30);
				save2 = wm.createRB(save2, "Empty Save", 25, 100, 250, 30);
				save3 = wm.createRB(save3, "Empty Save", 25, 150, 250, 30);
				save4 = wm.createRB(save4, "Empty Save", 25, 200, 250, 30);
				save5 = wm.createRB(save5, "Empty Save", 25, 250, 250, 30);
				ButtonGroup saveSelection = new ButtonGroup();
				saveSelection.add(save1);
				saveSelection.add(save2);
				saveSelection.add(save3);
				saveSelection.add(save4);
				saveSelection.add(save5);
				selectSave = wm.createButton(selectSave, "Select Save", 75, 375, 150, 30, Color.lightGray);
				leaveSaveSelection = wm.createButton(leaveSaveSelection, "Return to Menu", 75, 425, 150, 30, Color.lightGray);
				saveSelectButtonsPanel.add(save1);
				saveSelectButtonsPanel.add(save2);
				saveSelectButtonsPanel.add(save3);
				saveSelectButtonsPanel.add(save4);
				saveSelectButtonsPanel.add(save5);
				saveSelectButtonsPanel.add(selectSave);
				saveSelectButtonsPanel.add(leaveSaveSelection);
				saveSelectPanel.setVisible(false);

				// Floor Select Panel
				floorSelectPanel = wm.createPanel(floorSelectPanel, 0, 0, 900, 650, Color.black);
				floorSelectButtonsPanel = wm.createPanel(floorSelectButtonsPanel, 300, 50, 300, 500, Color.gray);
				floorSelectButtonsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				floorSelectPanel.add(floorSelectButtonsPanel);
				firstFloor = wm.createRB(firstFloor, "Floor 1", 100, 50, 100, 30);
				secondFloor = wm.createRB(secondFloor, "Floor 2", 100, 100, 100, 30);
				thirdFloor = wm.createRB(thirdFloor, "Floor 3", 100, 150, 100, 30);
				fourthFloor = wm.createRB(fourthFloor, "Floor 4", 100, 200, 100, 30);
				fifthFloor = wm.createRB(fifthFloor, "Floor 5", 100, 250, 100, 30);
				ButtonGroup floorSelection = new ButtonGroup();
				floorSelection.add(firstFloor);
				floorSelection.add(secondFloor);
				floorSelection.add(thirdFloor);
				floorSelection.add(fourthFloor);
				floorSelection.add(fifthFloor);
				selectFloor = wm.createButton(selectFloor, "Enter Floor", 75, 375, 150, 30, Color.lightGray);
				leaveFloorSelection = wm.createButton(leaveFloorSelection, "Return to Town", 75, 425, 150, 30, Color.lightGray);
				floorSelectButtonsPanel.add(firstFloor);
				floorSelectButtonsPanel.add(secondFloor);
				floorSelectButtonsPanel.add(thirdFloor);
				floorSelectButtonsPanel.add(fourthFloor);
				floorSelectButtonsPanel.add(fifthFloor);
				floorSelectButtonsPanel.add(selectFloor);
				floorSelectButtonsPanel.add(leaveFloorSelection);
				floorSelectPanel.setVisible(false);

				// Dungeon Panel
				dungeonPanel = wm.createPanel(dungeonPanel, 0, 0, 900, 650, Color.black);
				dungeonOptionsPanel = wm.createPanel(dungeonOptionsPanel, 45, 270, 800, 290, Color.gray);
				dungeonOptionsPanel.setVisible(false);
				dungeonOptionsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				dungeonPanel.add(dungeonOptionsPanel);
				dungeonLightAttack = wm.createButton(dungeonLightAttack, "Light Attack", 10, 30, 380, 100, Color.lightGray);
				dungeonOptionsPanel.add(dungeonLightAttack);
				dungeonHeavyAttack = wm.createButton(dungeonHeavyAttack, "Heavy Attack", 410, 30, 380, 100, Color.lightGray);
				dungeonOptionsPanel.add(dungeonHeavyAttack);
				dungeonSpecialMove = wm.createButton(dungeonSpecialMove, "Special Move", 10, 150, 380, 100, Color.lightGray);
				dungeonOptionsPanel.add(dungeonSpecialMove);
				dungeonFlee = wm.createButton(dungeonFlee, "Flee", 410, 150, 380, 100, Color.lightGray);
				dungeonOptionsPanel.add(dungeonFlee);
				currentEnemyName = wm.createLabel(currentEnemyName, "", shopFont, 50, 30, 400, 80, Color.white);
				currentEnemyHealth = wm.createLabel(currentEnemyHealth, "", textFont, 50, 120, 300, 80, Color.white);
				dungeonPanel.add(currentEnemyName);
				dungeonPanel.add(currentEnemyHealth);
				playerNameLabel = wm.createLabel(playerNameLabel, "", textFont, 540, 30, 300, 80, Color.white);
				playerNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				playerHealthLabel = wm.createLabel(playerHealthLabel, "", textFont, 540, 120, 300, 80, Color.white);
				playerHealthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				dungeonPanel.add(playerNameLabel);
				dungeonPanel.add(playerHealthLabel);
				dungeonEnemyDefeatedPanel = wm.createPanel(dungeonEnemyDefeatedPanel, 45, 270, 800, 290, Color.gray);
				dungeonEnemyDefeatedPanel.setLayout(null);
				dungeonEnemyDefeatedPanel.setVisible(false);
				dungeonEnemyDefeatedPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				dungeonPanel.add(dungeonEnemyDefeatedPanel);
				dungeonContinue = wm.createButton(dungeonContinue, "Delve Deeper", 10, 100, 380, 100, Color.lightGray);
				dungeonLeave = wm.createButton(dungeonLeave, "Return to Town", 410, 100, 380, 100, Color.lightGray);
				dungeonEnemyDefeatedPanel.add(dungeonContinue);
				dungeonEnemyDefeatedPanel.add(dungeonLeave);
				currentRoom = wm.createLabel(currentRoom, "Room 1", textFont, 50, 0, 300, 80, Color.white);
				dungeonPanel.add(currentRoom);
				dungeonPanel.setVisible(false);

				// Weapon Shop
				weaponShopPanel = wm.createPanel(weaponShopPanel, 0, 0, 900, 650, Color.black);
				currentWeaponDisplay = wm.createPanel(currentWeaponDisplay, 245, 50, 400, 500, Color.gray);
				currentWeaponDisplay.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				weaponShopPanel.add(currentWeaponDisplay);
				weaponName = wm.createLabel(weaponName, "", textFont, 50, 30, 300, 50, Color.white);
				weaponName.setHorizontalAlignment(SwingConstants.CENTER);
				weaponCost = wm.createLabel(weaponCost, "", shopFont, 100, 75, 200, 30, Color.white);
				weaponCost.setHorizontalAlignment(SwingConstants.CENTER);
				weaponDamage = wm.createLabel(weaponDamage, "", shopFont, 100, 100, 200, 30, Color.white);
				weaponDamage.setHorizontalAlignment(SwingConstants.CENTER);
				currentWeaponDisplay.add(weaponName);
				currentWeaponDisplay.add(weaponCost);
				currentWeaponDisplay.add(weaponDamage);
				purchaseWeapon = wm.createButton(purchaseWeapon, "Purchase Weapon", 100, 320, 200, 50, Color.lightGray);
				equipWeapon = wm.createButton(equipWeapon, "Equip Weapon", 100, 320, 200, 50, Color.lightGray);
				leaveWeaponShop = wm.createButton(leaveWeaponShop, "Leave Shop", 100, 390, 200, 50, Color.lightGray);
				currentWeaponDisplay.add(purchaseWeapon);
				currentWeaponDisplay.add(equipWeapon);
				currentWeaponDisplay.add(leaveWeaponShop);
				equipWeapon.setVisible(false);
				nextWeapon = wm.createButton(nextWeapon, ">", 650, 250, 50, 80, Color.green);
				previousWeapon = wm.createButton(previousWeapon, "<", 190, 250, 50, 80, Color.darkGray);
				weaponShopPanel.add(nextWeapon);
				weaponShopPanel.add(previousWeapon);
				weaponDisplayedCounter = wm.createLabel(weaponDisplayedCounter, "", null, 150, 10, 100, 30, null);
				weaponDisplayedCounter.setHorizontalAlignment(SwingConstants.CENTER);
				currentWeaponDisplay.add(weaponDisplayedCounter);
				weaponShopPanel.setVisible(false);

				// Armor Shop
				armorShopPanel = wm.createPanel(armorShopPanel, 0, 0, 900, 650, Color.black);
				currentArmorDisplay = wm.createPanel(currentArmorDisplay, 245, 50, 400, 500, Color.gray);
				currentArmorDisplay.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				armorShopPanel.add(currentArmorDisplay);
				armorName = wm.createLabel(armorName, "", textFont, 50, 30, 300, 50, Color.white);
				armorName.setHorizontalAlignment(SwingConstants.CENTER);
				armorCost = wm.createLabel(armorCost, "", shopFont, 100, 75, 200, 30, Color.white);
				armorCost.setHorizontalAlignment(SwingConstants.CENTER);
				armorHealth = wm.createLabel(armorHealth, "", shopFont, 100, 100, 200, 30, Color.white);
				armorHealth.setHorizontalAlignment(SwingConstants.CENTER);
				currentArmorDisplay.add(armorName);
				currentArmorDisplay.add(armorCost);
				currentArmorDisplay.add(armorHealth);
				purchaseArmor = wm.createButton(purchaseArmor, "Purchase Armor", 100, 320, 200, 50, Color.lightGray);
				equipArmor = wm.createButton(equipArmor, "Equip Armor", 100, 320, 200, 50, Color.lightGray);
				leaveArmorShop = wm.createButton(leaveArmorShop, "Leave Shop", 100, 390, 200, 50, Color.lightGray);
				currentArmorDisplay.add(purchaseArmor);
				currentArmorDisplay.add(equipArmor);
				currentArmorDisplay.add(leaveArmorShop);
				equipArmor.setVisible(false);
				nextArmor = wm.createButton(nextArmor, ">", 650, 250, 50, 80, Color.green);
				previousArmor = wm.createButton(previousArmor, "<", 190, 250, 50, 80, Color.darkGray);
				armorShopPanel.add(nextArmor);
				armorShopPanel.add(previousArmor);
				armorDisplayedCounter = wm.createLabel(armorDisplayedCounter, "", null, 150, 10, 100, 30, null);
				armorDisplayedCounter.setHorizontalAlignment(SwingConstants.CENTER);
				currentArmorDisplay.add(armorDisplayedCounter);
				armorShopPanel.setVisible(false);

				// Amulet Collection
				amuletPanel = wm.createPanel(amuletPanel, 0, 0, 900, 650, Color.black);
				amuletDisplay = wm.createPanel(amuletDisplay, 245, 50, 400, 500, Color.gray);
				amuletDisplay.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				amuletPanel.add(amuletDisplay);
				amuletName = wm.createLabel(amuletName, "", textFont, 50, 30, 300, 50, Color.white);
				amuletName.setHorizontalAlignment(SwingConstants.CENTER);
				amuletDescription = wm.createLabel(amuletDescription, "", null, 90, 100, 210, 30, Color.white);
				amuletDescription.setHorizontalAlignment(SwingConstants.CENTER);
				amuletDisplay.add(amuletName);
				amuletDisplay.add(amuletDescription);
				equipAmulet = wm.createButton(equipAmulet, "Equip Amulet", 100, 320, 200, 50, Color.lightGray);
				equipAmulet.setVisible(false);
				leaveAmuletShop = wm.createButton(leaveAmuletShop, "Return to Town", 100, 390, 200, 50, Color.lightGray);
				amuletDisplay.add(equipAmulet);
				amuletDisplay.add(leaveAmuletShop);
				nextAmulet = wm.createButton(nextAmulet, ">", 650, 250, 50, 80, Color.green);
				previousAmulet = wm.createButton(previousAmulet, "<", 190, 250, 50, 80, Color.darkGray);
				amuletPanel.add(nextAmulet);
				amuletPanel.add(previousAmulet);
				amuletDisplayedCounter = wm.createLabel(amuletDisplayedCounter, "", null, 150, 10, 100, 30, null);
				amuletDisplayedCounter.setHorizontalAlignment(SwingConstants.CENTER);
				amuletDisplay.add(amuletDisplayedCounter);
				amuletPanel.setVisible(false);
				
				// Bozo Trials Selection
				trialsSelectPanel = wm.createPanel(trialsSelectPanel, 0, 0, 900, 650, Color.black);
				trialsButtonsPanel = wm.createTPane(trialsButtonsPanel, 300, 50, 300, 500);
				ffTrialPanel = wm.createPanel(ffTrialPanel, 300, 50, 300, 500, Color.gray);
				ffTrialPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				sfTrialPanel = wm.createPanel(sfTrialPanel, 300, 50, 300, 500, Color.gray);
				sfTrialPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				tfTrialPanel = wm.createPanel(tfTrialPanel, 300, 50, 300, 500, Color.gray);
				tfTrialPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				fofTrialPanel = wm.createPanel(fofTrialPanel, 300, 50, 300, 500, Color.gray);
				fofTrialPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				fifTrialPanel = wm.createPanel(fifTrialPanel, 300, 50, 300, 500, Color.gray);
				fifTrialPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				trialsButtonsPanel.add("First Floor Trials", ffTrialPanel);
				trialsButtonsPanel.add("Second Floor Trials", sfTrialPanel);
				trialsButtonsPanel.add("Third Floor Trials", tfTrialPanel);
				trialsButtonsPanel.add("Fourth Floor Trials", fofTrialPanel);
				trialsButtonsPanel.add("Fifth Floor Trials", fifTrialPanel);
				trialsSelectPanel.add(trialsButtonsPanel);
				firstTrial = wm.createRB(firstTrial, "Trial 1", 100, 50, 100, 30);
				secondTrial = wm.createRB(secondTrial, "Trial 2", 100, 100, 100, 30);
				thirdTrial = wm.createRB(thirdTrial, "Trial 3", 100, 150, 100, 30);
				fourthTrial = wm.createRB(fourthTrial, "Trial 4", 100, 200, 100, 30);
				fifthTrial = wm.createRB(fifthTrial, "Trial 5", 100, 250, 100, 30);
				ButtonGroup trialSelection = new ButtonGroup();
				trialSelection.add(firstTrial);
				trialSelection.add(secondTrial);
				trialSelection.add(thirdTrial);
				trialSelection.add(fourthTrial);
				trialSelection.add(fifthTrial);
				selectTrial = wm.createButton(selectTrial, "Enter Trial", 75, 375, 150, 30, Color.lightGray);
				leaveTrialSelection = wm.createButton(leaveTrialSelection, "Return to Town", 75, 425, 150, 30, Color.lightGray);
				ffTrialPanel.add(firstTrial);
				ffTrialPanel.add(secondTrial);
				ffTrialPanel.add(thirdTrial);
				ffTrialPanel.add(fourthTrial);
				ffTrialPanel.add(fifthTrial);
				ffTrialPanel.add(selectTrial);
				ffTrialPanel.add(leaveTrialSelection);
				trialsSelectPanel.setVisible(false);

				// JFrame Settings
				window = new JFrame("Bozo Legends");
				window.setSize(900, 650);
				window.setLayout(null);
				window.setVisible(true);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setResizable(false);

				// Adding Panels to JFrame
				window.add(mainMenuPanel);
				window.add(characterCreationPanel);
				window.add(introductionPanel);
				window.add(townPanel);
				window.add(dungeonPanel);
				window.add(weaponShopPanel);
				window.add(armorShopPanel);
				window.add(floorSelectPanel);
				window.add(saveSelectPanel);
				window.add(trainingPanel);
				window.add(amuletPanel);
				window.add(trialsSelectPanel);
	}
}
