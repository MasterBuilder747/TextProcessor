package CodeGenerator;

/*
since hardcoding EVERY single machine is redundant, an upgrade system will instead ube put into place, similar to TE's system
since machines do not retain their contents when broken, we can get away with this
the upgrade must be applied in a machine (to appropriate leveled crafting machine)
it will cost a lot more power than base machine crafting

note that upgrades only apply to make more advanced and faster machines, and only are for optional machines
each upgrade gets much hard to make the higher it goes
multiple upgrade may be needed depending on how powerful the machine is

upgrading will also still require the external components

also note that you still need to craft the casing as well and use it in the upgrade

all machines will need at least one machine upgrade, since there are no required machines for UV level

upgrading will be with the infusion pedistal craftting, using RF, so that there is no tier needed

number of upgrades needed depends on:
tier:
MV/HV: 1
EV/IV: 2
LuV: 3
ZPM: 4
UV: 5

this is multiplied by the machine specific tier, which ranges from 1-5:
so ranges from 1-25 needed
1: polarizer, forming press, f heater, f canner, fermenter, compressor, canning, brewery, furnace, packager, unpackager
2: electm. sep, extractor, f extractor, f solidifier, forge hmr, sifting, cluster mill
3: autoclave, arc, alloy, pulver, lathe, cutting, chem bath, centrifuge, bending, mixer, washer, wiremill, extruder
4: therm. cent, laser eng, p arc, chem reactor, electolz, distillery
5: replicator, matter fabricator, assembling machine

so every upgrade needs:
*maybe a special crafting machine (or ExT pedistal infusion) maybe needs power as well
-the previous tier machine
-variable amount of upgrades (see above)
-variable amount of parts (which one: depending on each induvidual machine; amount: only based on the tier of machine: see below)

amount of circuits:
1,2,3: 2
4: 3
5: 4


*/

public class UpgradesGenerator {

    //every upgrade needs:
    //type, range, how the number changes
    //circuits, 0-5, depending on machine, stays the same for each tier
    //upgrades, 1-25, depends on multiplier * tier (see above)
    //parts, depends, take the highest manual crafted tier and double that number for each tier
    //the hull of each tier
    //the previous tier machine
    //note that any nested machines that are normally needed additionally
    //(ex: 2 furnaces for an alloy smelter) will be ignored for upgrades and will follow the same convention

    int numUpgrades;
    int numCircuits;
    int minTier; //the min tier to start upgrades (after the max manual recipe)
    int machineID; //machine ID starting with XXi where XX is the ID here, and i is the tier number in GT's metadata naming, 0-7/8

    //this function will print out the code for each machine in the format that is read by the main func,
    //but it will separate out each voltage tier crafter machine
    //so you NEED to have a separator between every machine
    //use:
    //val machine0
    //val machine1
    //val machine2
    //val machine
    //where i is the same as the machine metadata ID
    //number starts at 1000
    //energy per tick must be different and must be as high as possible for each tier



}
