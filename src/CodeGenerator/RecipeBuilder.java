package CodeGenerator;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RecipeBuilder {

    public static void main(String[] args) throws IOException {

        /*

        EX: file to be generated:

        recipes.remove(<gregtech:machine:420>);
        val polarizer_lv = mods.modularmachinery.RecipeBuilder.newBuilder("polarizer_lv", "machine", 40);
        polarizer_lv.addEnergyPerTickInput(1000);
        polarizer_lv.addItemOutput(<gregtech:machine:420>);
        var polarizer_lv_item = [
        <gregtech:meta_item_1:14033> * 4,
        <gregtech:cable:1079> * 4,
        <gregtech:meta_item_1:14297> * 2,
        <contenttweaker:material_part:4> * 2,
        <gregtech:meta_item_1:14189> * 2,
        <gregtech:cable:5071> * 2,
        <gregtech:meta_item_1:14071> * 2,
        <gregtech:machine:501>
        ] as IItemStack[];
        for item in polarizer_lv_item {
            polarizer_lv.addItemInput(item);
        }
        polarizer_lv.build();

        //process:
        //polarizer is the name of the machine being crafted
        // _lv is added for the tier, _mv, etc

        //name = NAME_VOLTAGEtIER is assigned name

        //create this code:
        val name = mods.modularmachinery.RecipeBuilder.newBuilder("name", "gt_crafter_lv", 40);
        name.addEnergyPerTickInput(2000);
        name.addItemOutput(output);
        val name_item = [
        items
        ] as IItemStack[];
        for item in name_item {
            name.addItemInput(item);
        }
        name.build()
        */

        //save as zs
        ///Users/Joseph/Desktop/recipes.txt
        System.out.println("import mods.modularmachinery.RecipeBuilder;\n" +
                "import mods.modularmachinery.RecipePrimer;\n" +
                "import crafttweaker.item.IItemStack;");
        System.out.println();
        System.out.println("val machine = \"gt_crafter_lv\";");
        System.out.println();

        FileReader fr = new FileReader("C:\\Users\\jaath\\Desktop\\recipes.txt"); //mac does not need to define the disk, uses / instead of \
        BufferedReader br = new BufferedReader(fr);

        //s1 is the actual value of the file that is used and printed
        //s2 is the next known line, but it isn't used and isn't printed

        while (true) {
            //increases after each machine recipe
            int mach = 0;
            String s1 = null;
            String s2 = null;


            //executed last
            boolean first = true;
            while(true) {
                if (first) {
                    s1 = br.readLine();
                    s2 = br.readLine();
                    //dispVars(s1, s2, "first");

                    System.out.println("recipes.remove(" + s1 + ");");
                    System.out.println("val machine" + mach + " = mods.modularmachinery.RecipeBuilder.newBuilder(\"machine" + mach + "\", \"machine\", 100);");
                    System.out.println("machine" + mach + ".addEnergyPerTickInput(2000);");
                    System.out.println("machine" + mach + ".addItemOutput(" + s1 + ");");
                    System.out.println("var machine" + mach + "_item = [");

                    first = false;
                } else {
                    s1 = s2;
                    s2 = br.readLine();
                    //dispVars(s1, s2, "all others");

                    if (!s2.contains("<minecraft:log>")) {
                        //execute recipe
                        System.out.println("\t" + s1 + ",");
                    } else {
                        System.out.println("\t" + s1);
                        System.out.println("] as IItemStack[];");
                        System.out.println("for item in machine" + mach +"_item {");
                        System.out.println("\tmachine" + mach + ".addItemInput(item);");
                        System.out.println("}");
                        System.out.println("machine" + mach + ".build();");
                        System.out.println();

                        //used for breaking the whole loop
                        s2 = br.readLine();
                        break;
                    }
                }
            }


            if (s2 == null) {
                break;
            }
        }



    }

    public static void dispVars(String s1, String s2, String s) {
        System.out.println(s);
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        //System.out.println();
    }

    public static void genMach(String s1, int mach) {
        //output the machine recipe first
        //System.out.println("===machine header===");
/*
        System.out.println("recipes.remove(" + machine + ");");
        System.out.println("val machine" + mach + " = mods.modularmachinery.RecipeBuilder.newBuilder(\"machine" + mach + "\", \"machine\", 100);");
        System.out.println("machine" + mach + ".addEnergyPerTickInput(2000);");
        System.out.println("machine" + mach + ".addItemOutput(" + machine + ");");
        System.out.println("var machine" + mach + "_item = [");
*/
/*
        while (s2 != null) {
            //dispVars(s1, s2, "item");

            //add the items
            if (!s2.contains("<minecraft:log>")) {
                //all items except last
                */
                System.out.println("\t" + s1 + ",");

            //}else {
                //last item
                System.out.println("\t" + s1);



            //}

        }



    }

