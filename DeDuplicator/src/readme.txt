* Main function's in the Dedup class

* SDK version: 1.8, same as what's set in the IntelliJ tutorial

* Right click on the Deduplicator on right bar -> Open Module Settings -> Language Level and change it to level 8
 (not quite sure why it's not a default setting but that's what I figured out using lab computer)

* Passing args in intellij in Run -> Edit Configurations -> Program Arguments
  By now only support two kinds of operation which are -addFile and -retrieveFile

* Args example & attentions:

    "-addFile filename -locker lockername"
    "-retrieveFile filename -locker lockername"

  ** Capital sensitive!
  ** For filename and lockername only names are supported. Filling paths in these area may cause interruption in program
  ** Blank args will cause an interruption, which will be fixed in the next version.

* Program's already been tested in lab's computer, while if there's any problem running the prototype,
    contact with chesterw@bu.edu or 8577638804 (Zifan Wang), who's being available 24/7 literally :)

* Have fun deduplicating!