package CodeGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecipeReader {

    public static String[] readFile(BufferedReader br) throws IOException {

        String[] a = new String[0];

        while (true) {
            String s = br.readLine();
            //System.out.println(s);
            //recipe separator
            if (s.contains("<minecraft:log>")) {
                break;
            }
            String[] b = ExpandableArray2.expandArray(a);
            b[b.length - 1] = s;
            a = b;
        }

        return a;
    }

    public static void print(String[] a) {
        for (String s : a) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws IOException {

        //switch based on platform
        String mac = "/Users/Joseph/Desktop/recipes.txt";
        String pc = "C:\\Users\\jaath\\Desktop\\recipes.txt";
        FileReader fr = new FileReader(pc);
        BufferedReader br = new BufferedReader(fr);

        System.out.println("import mods.modularmachinery.RecipeBuilder;\n" +
                "import mods.modularmachinery.RecipePrimer;\n" +
                "import crafttweaker.item.IItemStack;");
        System.out.println();
        System.out.println("val machine = \"gt_crafter_ev\";");
        System.out.println();

        //starting machine naming value
        int mach = 100;
        while(true) {
            //this will throw an exception, so its not technically infinite
            String[] a = readFile(br);

            String s = a[0];
            System.out.println("recipes.remove(" + s + ");");
            System.out.println("val number" + mach + " = mods.modularmachinery.RecipeBuilder.newBuilder(\"number" + mach + "\", machine, 100);");
            System.out.println("number" + mach + ".addEnergyPerTickInput(800000);");
            System.out.println("number" + mach + ".addItemOutput(" + s + ");");
            System.out.println("var number" + mach + "_item = [");

            for (int i = 0; i < a.length; i++) {
                if(i < a.length - 1) {
                    s = a[i + 1];
                    if(i != a.length - 2) {
                        System.out.println("\t" + s + ",");
                    }
                }else{
                    System.out.println("\t" + s);
                    System.out.println("] as IItemStack[];");
                    System.out.println("for item in number" + mach + "_item {");
                    System.out.println("\tnumber" + mach + ".addItemInput(item);");
                    System.out.println("}");
                    System.out.println("number" + mach + ".build();");
                    System.out.println();
                }
            }
            mach++;
        }
    }
}
