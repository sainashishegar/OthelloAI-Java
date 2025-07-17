# ♟️ OthelloAI-Java

A console-based Java implementation of the classic Othello (Reversi) game, featuring multiple controller types including human players, random AI, and greedy AI. Designed with object-oriented principles and extensible controllers for various game strategies.

---

## 🧠 Features

- 8x8 Othello board with standard rules  
- Multiple controller modes:
  - Human vs Human
  - Human vs Random AI
  - Human vs Greedy AI (chooses the first move with the highest gain)
  - Random vs Greedy, etc.
- Game state tracking with a rich model-view separation  
- Modular architecture using abstract `OthelloController`  
- Easy to extend for new strategies (e.g., Minimax)

---

## 🛠️ Tech Stack

- Java  
- Object-Oriented Programming (OOP)  
- Command-line interface  

---

## 🚀 How to Run

1. Make sure Java (JDK) is installed on your system.
2. Clone the repo and navigate to the project folder:
   ```bash
   git clone https://github.com/sainashishegar/OthelloAI-Java.git
   cd OthelloAI-Java
   ```
3. Compile the project:
   ```bash
   javac -d bin src/**/*.java
   ```
4. Run a game mode, for example Human vs Greedy AI:
   ```bash
   java -cp bin ca.yorku.eecs3311.othello.model.OthelloControllerHumanVSGreedy
   ```

---

## 📸 Sample Output

```
makes move (4,5)
  0 1 2 3 4 5 6 7 
 +----------------+
0| | | | | | | | |0
1| | | | | | | | |1
2| | | | | | | | |2
3| | | |X|O| | | |3
4| | | |O|X| | | |4
5| | | | | | | | |5
6| | | | | | | | |6
7| | | | | | | | |7
 +----------------+
  0 1 2 3 4 5 6 7 
O moves next
```

---

## 🧩 Architecture

- `OthelloBoard`: Handles board logic and state  
- `Othello`: Game logic and player turns  
- `OthelloController*`: Different game modes (e.g. Human vs AI)  
- `Player*`: Player strategies (Human, Random, Greedy)

---

## 🙋‍♀️ Author

**Saina Shishegar**  
📍 Toronto, Canada  
📫 [saina.shishegar@gmail.com](mailto:saina.shishegar@gmail.com)

---

## 🏁 Status

✅ Complete – may be extended with advanced AI strategies in the future!
