# COMP2042_CW_hfyet3 2048

# About
Name: Tan En Xuan</br>
Student ID: 20297487

# Installation
1. Install any Java IDE.**HIGHLY RECOMMENDED IntelliJ**</br>
2. Download repository as ZIP file- https://github.com/enxuantan1030/COMP2042_CW_hfyet3 </br>
3. Build file
4. Run the program


#Javadoc documentation Path
/javadoc/com.example.demo/module-summary.html

# Features Implemented
- Game Audio
- Mouse Hover buttons effects, Theme gradient
- Menu Scene
  - **START** button
  - **QUIT** button
    - Alert Window will pop out to ask for confirmation
  - **THEMES** drop down menu as 6 themes can be chosen
  - **DIFFICULTY** drop down menu as 5 difficulties can be chosen
  - **M** button to mute/unmute game audio
  - **LEADER BOARD** button (Hish score table is sorted from highest to lowest)
  - Able to register new names with characters ONLY into file after clicking **START** 

- Game Scene
  - 2048 game works properly
  - Display player's score
  - Display time used in the game
  - **M** key (return to menu)
    - Alert Window will pop out to ask for confirmation
  - **ESC** key (terminates program)
    - Alert Window will pop out to ask for confirmation
  - **P** key to mute/unmute game audio
  
  - **Bugs Fixed**
    - Keys other than arrow keys won't be able to make any movement during the game
    - Score calculation
    
- Game Over/ Win Scene
  - **RESTART** button
  - **QUIT** button
    - Alert Window will pop out to ask for confirmation
  - Display total player's score
  - **LEADER BOARD** button
  - **M** button to mute/unmute game audio
  - **Bugs Fixed**
    - Quit button will terminate the program 

# Features Not Implemented
1. JUnit Testing</br>
Reasons: Not familiar with it and not enough time

# 2 Achievement most proud of
- Combine the usage of JavaFX and JavaFX FXML(leader board and high score list)
- Refactoring(details refers to Maintenance Performed section)

# Maintenance Performed
- Extract methods from GameScene,StartGame,EndGame into several classes named with their features
- Create Interface for GeneralComponents which stores methods' without name body
- Create several packages with a consistent pattern</br>E.g EndGame package contains Features package, EndGame
- Delete method sumCellNumbersToScore in GameScene as the score is added in method moveHorizontally and moveVertically(currently in GameMovement.java)
- Delete argument int turn in randomFillNumber(currently in GameMovement.java) as it is not used.
- More detailed information can be found in Github commits, javadoc

# New Java Classes(Group by package)and resources
- Accounts
  - Account.java
  - AddName.java
  - ChooseFile.java
  - Leaderboard.java
  - ShowScore.java
  - UpdateScore.java

- Scenes
  - EndGame
    - DisplayScore.java
    - DisplayTime.java
    - GameOverTitle.java
    - Quit_button.java
    
  - General
    - GeneralComponents.java
    - GeneralizedComponents.java
  
  - InGame
    - ArrowKeyControls.java
    - CannotMove.java
    - GameMovement.java
    - MovementEmptyCell.java
    - SameCellNumber.java
    - Stopwatch.java
    - Variables.java
  
  - MenuGame
    - StartGame.java
    - Difficulty.java
    - GameTitle.java
    - QuitMenuButton.java
    - Theme.java
  
  - Resources
    - 2048.mp3
    - Account3x3.txt
    - Account4x4.txt
    - Account5x5.txt
    - Account6x6.txt
    - Account7x7.txt
    - koroks1.gif
    - koroks3.gif
    - koroks4.gif
    - leaderboard.fxml
    - ShowScore.fxml

# Modified Java Classes
- Main.java
- EndGame.java
- GameScene.java
- Cell.java
- TextMaker.java
- Account.java

# Design Patterns Implemented
- SingletonPattern
- Abstract Factory Pattern
- Adapter Pattern

# Contact
:mailbox: Email - hfyet3@nottingham.edu.my</br>
:telephone_receiver: Phone - (+60) 17-2917935</br>

