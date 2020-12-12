# Mines & Mobs
Minecraft Mod
##  Class System
* Fighter
* Wizard
* Rogue
* Cleric

## HOW TO INSTALL / USE
* All our system runs from root(Wizards-of-the-Nether)/mines_n_mobs
* Anything in this mines_n_mobs folder is our code EXCEPT for the gradle files which were provided in the blank mod template.
* To find the bulk of our code, you should check in the mines_n_mobs/src folder where all our java files are. These are the files where we actually implemented change to the Minecraft environment. In the /src folder you will also find some json scripting as well as some art that we had to create for our mod. 
* To effectively view / edit this mod, simply import the mines_n_mobs folder as a gradle project in Eclipse IDE (or any other IDE that supports gradle projects.
* To build / compile our code, in the "Gradle Tasks" tab (assuming you are using Eclipse IDE), in the "build" folder, double click "build". This will send a JAR file to the "mines_n_mobs/build/libs" folder, as of the recent release, you should see a file called "mines_n_mobs-1.0.jar". This folder can be placed in your minecraft "mods" folder wherever that may be, assuming you have the proper version of forge installed, (1.15.2-31.2.0).
* To install our project, you can place this JAR file into the "mods" folder of your Forge-Installed Minecraft. (Again, assuming you have forge downlaoded.)

####  [Project Website](https://jaymay284.github.io/CS-Project-Site/)
### v0.1
NEW:
1. Removed filler text wherever the filler text might be. No more Lorem Ipsum!
2. Daggers now exist, but are very unbalanced. (To be changed...)
   - Wooden Dagger
     - 1 stick + 1 wood plank
   - Stone Dagger
     - 1 stick + 1 cobblestone
   - Iron Dagger
     - 1 stick + 1 iron_ingot
   - Gold Dagger
     - 1 stick + 1 gold_ingot
   - Diamond Dagger
     - 1 stick + 1 diamond
3. Mod will now properly publish to whatever version we need it to. (currently v0.1)
4. Added readme.md.
### v0.2
NEW:
1. Class-Sleection GUI 
   - select between classes.
      - Fighter
      - Rogue
      - Cleric
2. Backstab
   - When Daggers used on enemies below a certain amount of health are executed.
      - Enemies below 25% health that are struck by a dagger are executed.
REMOVED:
1. Unneccesary  filler-text.
### v0.3
REMOVED / FIXED:
1. Class selection GUI no longer will open the google homepage.
CHANGED:
1. Class-selection GUI
   - Now will give the player NBT data "class" relative to the value they chose with the class selector item they were given when the game starts.
2. Backstab
   - Now will deal bonus damage to entities when struck from behind with a dagger.
      - Now will print out debug text to test backstab values.
