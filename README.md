# **Project in OOP – Echoes of Aetheria**

*Java-Based Story-Driven RPG using Object-Oriented Programming*

---

## **2. Description / Overview**

**Echoes of Aetheria** is a **Java-based, story-driven RPG** that showcases core **Object-Oriented Programming (OOP)** concepts through a **turn-based combat** and **dialogue** system.

The player:

* Progresses through a **multi-act narrative**: *Prologue*, **Act I–III**, and *Epilogue*
* Fights different **enemy types**
* Equips **weapons, armour, shields, and accessories**
* Makes **choices** that advance and shape the story

The game uses a **Swing-based UI** to display:

* Story text
* Combat logs
* Player stats (HP/MP)
* Player choices and options

---

## **3. OOP Concepts Applied**

### **3.1 Encapsulation**

**Private fields & controlled access**

* Classes such as `Player`, `Enemy`, and item-related classes
  (`Item`, `Weapon`, `Armor`, `Accessory`, `Consumable`) use
  `private` or `protected` fields for:

  * Player stats, HP/MP
  * Damage values and resistances
  * Inventory
  * Enemy stats
* Access is done through **public getters/setters** and **domain-specific methods**, e.g.:

  * `getCurrentHP()`, `getMaxHP()`
  * Methods to apply damage, healing, and bonuses

**Singleton Player**

* `Player` is implemented as a **singleton**:

  * `private static Player instance`
  * `getInstance()` method
* This ensures a **single, centralised player state** throughout the game.

**UI & combat interaction**

* `Combat_System` and `UI` interact with `Player` and `Enemy` only through their **public methods**, preventing unauthorised changes to internal fields.

---

### **3.2 Inheritance**

**Enemy hierarchy**

* `Enemy` is a **base class** containing shared stats and behaviour:

  * HP, ATK, DEF
  * Type and skills
  * Status effects
* Multiple **specific enemies** are implemented as static subclasses inside `Enemy`, including:

  * `UmbralCreep`
  * `CorruptedWolf`
  * `Sandworm`
  * `ElderGolem`
  * `IceDragonSyntice`
  * `ShadowPhase1`, `ShadowPhase2`, `ShadowPhase3`
* Each enemy configures different stats, skills, and behaviour.

**Item hierarchy**

* `Item` is an **abstract base class** for all equippable/usable items.
* `Weapon`, `Armor`, `Shield`, and `Accessory` extend `Item`, adding:

  * Damage values
  * Defence values
  * Unique effects or bonuses
* Concrete items (e.g. `TrainingSword`, `BronzePlate`, `SpiritwoodShield`, `BlessingOfSyntice`) inherit from these abstract item types.

**Scene hierarchy**

* `Scene` (in `core.scenes`) is an **abstract class** that defines a template for combat/story scenes.
* Specific scenes (e.g. `Act1Scene1Combat`, forest encounters, boss fights in Acts II and III) **extend** `Scene` and implement their own:

  * Setup logic
  * Story flow
  * Enemy configurations

---

### **3.3 Polymorphism**

**Scene polymorphism**

* `Scene` defines abstract and overridable methods, such as:

  * `protected abstract void setup()`
  * Hooks like `onVictory()` and `onDefeat()`
* Each subclass:

  * Defines enemy line-ups and loadouts
  * Decides what happens after victory/defeat (next scene, story branch, etc.)
* The game can treat all scenes as `Scene` references, calling `start()` and relying on their **polymorphic implementations**.

**Enemy polymorphism**

* `Combat_System` interacts with enemies through the `Enemy` type.
* The actual behaviour (stats, skills, and combat feel) varies depending on the **concrete subclass**, e.g.:

  * Wolf vs golem vs dragon vs multi-phase final boss.

**Item polymorphism**

* Equipment is managed using the **abstract `Item` type**:

  * Weapons, armour, shields, and accessories are all treated as `Item` references.
* Each concrete item applies different **stat bonuses and effects** to the `Player`.

---

### **3.4 Abstraction**

**Abstract base classes**

* `Item`:

  * Abstract class encapsulating:

    * Name
    * Stat bonuses
    * Description
  * Provides a shared structure for all items.
* `Weapon`, `Armor`, `Shield`, `Accessory`:

  * Abstract subclasses of `Item`, defining additional attributes for their category.
* `Scene`:

  * Abstracts the **combat flow**:

    * Title setup
    * Battle start
    * Transition between enemies/scenes
  * Exposes a simple interface: `start()`, `setup()`, `onVictory()`.

**High-level system interfaces**

* `Combat_System`:

  * Abstracts the entire battle process.
  * Uses:

    * `Player`
    * `Enemy`
    * `EquipmentManager`
    * `Inventory`
  * Handles:

    * Turn order
    * Damage, dodge, block
    * Victory/defeat callbacks

* `SkillDefinition`:

  * Abstracts a **combat skill** with:

    * Name
    * Power
    * Type
    * Notes
  * Enables reusable skills across multiple enemies and items.

---

## **4. Program Structure**

### **4.1 Packages and Main Components**

#### `com.oopfinalproject.game`

* **`Game`**

  * Entry point (`main` method).
  * Sets up the **UI**, **player**, **equipment**, and **story** then starts the game.
* **`UI`**

  * Swing-based interface. Displays:

    * Story text
    * Combat logs
    * HP/MP
    * Player options and choices
* **`Story`**

  * Coordinates:

    * Prologue
    * Acts I–III
    * Epilogue
  * Handles **scene transitions**.
* **`VisibilityManager`** & `handlers.ChoiceHandler`

  * Manage visible panels/buttons.
  * Handle **user input** and choices.

---

#### `com.oopfinalproject.core`

* **`Player`**

  * Singleton representing the player character.
  * Stores stats, HP/MP, resistances, and inventory.
* **`Enemy`**

  * Base enemy class with static inner subclasses for specific enemies and bosses.
* **`Combat_System`**

  * Controls **turn-based combat** between `Player` and `Enemy`.
* **`EquipmentManager`**

  * Equips/unequips:

    * Weapons
    * Armour
    * Shields
    * Accessories
  * Applies their stat bonuses to `Player`.
* **`SkillDefinition`, `SkillRegistry`, `StatusEffect`**

  * Define combat skills and status effects.

---

#### `com.oopfinalproject.core.scenes`

* **`Scene`**

  * Abstract base class for all combat/story scenes.
* **Multiple Scene Subclasses**

  * Prologue fights
  * Forest encounters
  * Bosses:

    * Elder Golem
    * Ice Dragon
    * Sandstorm Guardian
    * Sandstone Knight
    * Final boss phases

---

#### `com.oopfinalproject.items`

* **Item hierarchy**

  * `Item` (abstract)
  * `Weapon`
  * `Armor`
  * `Shield`
  * `Accessory`
  * `Consumable`
* **Concrete items** (examples)

  * `TrainingSword`
  * `BronzePlate`
  * `SpiritwoodShield`
  * `CrystalMemoryRing`
* **`Inventory`**

  * Manages the player’s items.
* **`ItemsFactory`**

  * Centralised creation and retrieval of item instances used in story and scenes.

---

### **4.2 High-Level Relationships (Text Diagram)**

* `Game`

  * → creates and holds `UI`, `VisibilityManager`, `Story`.
* `Story`

  * → controls progression across various `Scene` subclasses.
* Each `Scene`:

  * Holds a reference to the **singleton** `Player`.
  * Creates one or more `Enemy` instances.
  * Uses `Combat_System` to run the fight.
* `Combat_System`:

  * Uses `Player`, an `Enemy`, `EquipmentManager`, and `Inventory`.
  * Reads skill and item data from:

    * `EquipmentManager`
    * `ItemsFactory`
    * `SkillRegistry`

---

## **5. How to Run the Program**

### **Option 1: Using an IDE (Recommended)**

1. Open your chosen IDE (VS Code, IntelliJ IDEA, Eclipse, NetBeans, etc.).
2. Create a new **Java project**.
3. Set the **source folder** to:
   `Project in OOP/com`
4. Ensure the project uses **Java 8 or higher**.
5. Locate `com.oopfinalproject.game.Game`.
6. Run the `main` method of `Game`.

---

### **Option 2: Using the Command Line (Generic Steps)**

1. Open a **terminal/command prompt**.

2. Navigate to the project root (the folder containing `com/`), e.g.:

   ```bash
   cd "Project in OOP"
   ```

3. Compile and run the Java sources (commands will depend on your folder structure and JDK setup).

---

## **6. Sample Output**

> *(Here you can insert screenshots or example console/Swing output, such as:)*
>
> * Start of the Prologue
> * Example combat log vs a basic enemy
> * Boss fight UI (HP bars, skills, and combat messages)

---

## **7. Author and Acknowledgement**

**Authors:**

* Dalangin, John Albert
* Pinero, Mark Aldrin
* Pinili, Krisdaniel

**Course / Subject:**
CS211 – Object Oriented Programming

**Instructor:**
Ms. Fatima Marie P. Agdon, MSCS

**Acknowledgements:**
I would like to thank my instructor, Ma'am Fatima, for her guidance and feedback throughout this project. I also acknowledge my groupmates/classmates for their suggestions and support during development, as well as the authors of online Java tutorials and documentation that helped me better understand OOP concepts.

---

## **8. Other Sections**

### **8.a Future Enhancements**

* Add a **save/load system** so players can continue their adventure later.
* Include more **skills and status effects** (buffs, debuffs, crowd control).
* Expand the story with additional **acts**, **side quests**, and **NPC interactions**.
* Add **sound effects and background music** for battles and scenes.
* Implement adjustable **difficulty levels** (*Easy / Normal / Hard*) that scale enemy stats.

---

### **8.b References**

* Java Swing tutorial resources (for UI components).
* ChatGPT (for guidance during planning and implementation).

---
