# COMP2042_CW_hfyet3 2048

# About
Name: Tan En Xuan</br>
Student ID: 20297487

# Installation
1. Install any Java IDE.**HIGHLY RECOMMENDED IntelliJ**</br>
2. Clone reopository - https://github.com/enxuantan1030/COMP2042_CW_hfyet3 </br>
3. Run file with Javafx, follow the steps below:</br> for [Eclipse](https://www.javatpoint.com/javafx-with-eclipse#:~:text=We%20need%20to%20export%20the,to%20execute%20our%20java%20project.)
</br>for [IntelliJ](https://www.jetbrains.com/help/idea/javafx.html#troubleshoot)
#Javadoc documentation Path
/javadoc/com.example.demo/module-summary.html

# Features Implemented
- Game Audio (Able to unmute/mute)
- Mouse Hover buttons effects, Theme gradient
- Menu Scene
  - **START** button
  - **QUIT** button
  - **THEMES** drop down menu as 6 themes can be chosen
  - **DIFFICULTY** drop down menu as 5 difficulties can be chosen
  - **LEADER BOARD** button
  - Able to register new names with characters ONLY into file after clicking **START** 

- Game Scene
  - 2048 game works properly
  - Display player's score on the right side
  - **M** key (return to menu)
    - Alert Window will pop out to ask for confirmation
  - **ESC** key (terminates program)
    - Alert Window will pop out to ask for confirmation
    - 
  
  - **Bugs Fixed**
    - Keys other than arrow keys won't be able to make any movement during the game
    - Score calculation
    
- Game Over/ Win Scene
  - **RESTART** button
  - **QUIT** button
  - Display total player's score
  - **LEADER BOARD** button
  - **Bugs Fixed**
    - Quit button will terminate the program 

# Features Not Implemented
1. JUnit Testing
2. Build files</br>
Reasons: Not familiar with it and not enough time

#Bug Introduced
- Error appears after restarting the game with choosing higher difficulty than the first time.
  </br>E.g First choose 3x3 difficulty, after finish game/return to menu, Choose any Difficulty higher than 3x3 will cause this error
  </br>However, if we choose 7x7 first, and after restarting the game, it does not have this error

#Maintenance Performed
- Extract methods from GameScene,StartGame,EndGame into several classes named with their functions
- Create Interface for GameScene,StartGame,EndGame as it supports multiple inheritance from multiple class</br> E.g abstract class extends GeneralComponents implements Interface
- Create several packages with a consistent pattern</br>E.g EndGame package contains Features package, EndGameInterface, EndGame
- Delete unnecessary class, Account.java and method sumCellNumbersToScore in GameScene as the score is added in method moveHorizontally and moveVertically(currently in GameMovement.java)

# New Java Classes, Packages, Resources
- Accounts
  - AddName.java
  - ChooseFile.java
  - Leaderboard.java
  - ShowScore.java
  - UpdateScore.java

- Scenes
  - EndGame
    - EndGameInterface.java
    - DisplayAllScore.java
    - DisplayScore.java
    - DisplayTime.java
    - GameOverTitle.java
    - Quit_button.java
    
  - General
    - GeneralComponents.java
    - GeneralizedComponents.java
  
  - InGame
    - InGameInterface.java
    - ArrowKeyControls.java
    - CannotMove.java
    - GameMovement.java
    - MovementEmptyCell.java
    - SameCellNumber.java
    - Stopwatch.java
    - Variables.java
    - GenerateGameCells
  
  - MenuGame
    - MenuInterface.java
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
- (Deleted) Account.java

# Design Patterns Implemented
- SingletonPattern
- Abstract Factory Pattern
- Adapter Pattern

# Contact
:mailbox: Email - hfyet3@nottingham.edu.my</br>
:telephone_receiver: Phone - (+60) 17-2917935</br>
