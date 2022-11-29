# COMP2042_CW_hfyet3 2048

# About
Name: Tan En Xuan</br>
Student ID: 20297487

# Installation
1. Install any Java IDE. (E.g IntelliJ, Eclipse, VS Code etc.)</br>
2. Clone the repo from this link - https://github.com/enxuantan1030/COMP2042_CW_hfyet3 </br>

# Features Implemented
- Menu Scene
  - Able to start game properly after clicking **START** button
  - Able to quit game properly after clicking **QUIT** button
  - Able to change theme from **THEMES** drop down menu
    - 6 themes can be choose : Black, Blue, Yellow, Green, Pink, Purple
  - Able to change difficulty from **DIFFICULTY** drop down menu
    - 5 difficulties can be choose: 3x3, 4x4, 5x5, 6x6, 7x7
  - Music available

- Game Scene
  - Able to play the 2048 game properly
  - Display player's score on the right side
  - Able to return to menu properly after pressing **M** key
    - Alert Window will pop out to ask for confirmation
  - Able to quit game properly after pressing **ESC** key
    - Alert Window will pop out to ask for confirmation
  
  - **Bugs Fixed**
    - Keys other than arrow keys won't be able to make any movement during the game
    - Scoring calculation fixed
    
- Game Over Scene
  - Able to return to menu properly after pressing **RESTART** button
  - Able to quit game properly after clicking **QUIT** button
  - Display total player's score
  - **Bugs Fixed**
    - Quit button will terminate the program 

# New Java Classes
- EndGameAbstractMethod.java
- EndGameInterface.java
- ArrowKeyControls.java
- GameMovement.java
- InGameAbstractMethods.java
- InGameInterface.java
- MenuAbstractMethods.java
- MenuInterface.java
- StartGame.java
- SceneSimple.java
- SceneSimplified.java

# Modified Java Classes
- Main.java
- EndGame.java
- GameScene.java
- Cell.java
- TextMaker.java

# Design Patterns Implemented
- SingletonPattern
- Abstract Factory Pattern
- Adapter Pattern

# JUnit Test
-  
-

# Contact
:mailbox: Email - hfyet3@nottingham.edu.my</br>
:telephone_receiver: Phone - (+60) 17-2917935</br>

# References
- [Github Emojis](https://www.webfx.com/tools/emoji-cheat-sheet/)
- [Colour Gradient for Scenes](http://www.java2s.com/Tutorials/Java/JavaFX/0110__JavaFX_Gradient_Color.htm#:~:text=JavaFX%20provides%20two%20types%20of,as%20the%20end%20stop%20color.)
- [Stopwatch Implementation](https://gist.github.com/SatyaSnehith/167779aac353b4e79f8dfae4ed23cb85)
- [Audio Implementation](https://stackoverflow.com/questions/23498376/ahow-to-make-a-mp3-repeat-in-javafx)