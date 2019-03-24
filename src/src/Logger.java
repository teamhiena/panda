import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A szkeletonhoz tartozó segédosztály, ennek segítségével egyszerűbben tudjuk kezelni a hívási láncot.
 */
public class Logger {
    private static Map<Object, Object_information> map = new HashMap<Object, Object_information>();
    private static int depth = 0;
    private static boolean enabled = false;

    public static void register(Object o, String type, String name){
        map.put(o, new Object_information(type, name));
    }

    public static void enter(Object o, String funcName, List<Object> parameters){
        /**
         * Ha a logolás nincsen engedélyezve, nem csinálunk semmit.
         */
        if(!enabled) return;

        /**
         * Eltolás
         */
        String tab = "";
        for(int i=0; i<depth; i++){
            tab += "  ";
        }
        depth++; //értelemszerűen növelnünk kell a mélységet amikor valaki belép

        /**
         * Paraméterlista megvalósítása.
         */
        String param = "";
        for(Object i : parameters) {
            param += ", "; //elválasztáshoz

            if (i == null)
                param += "null";
            else if (map.containsKey(i))
                param += "[" + map.get(i).getType() + "]" + map.get(i).getName();
            else
                param += i.toString();
        }
        if(param.length()>2) param = param.substring(2); //van az elején egy felesleges vessző + egy space

        /**
         * Kiírás
         */
        System.out.println(tab+"-> "+ "[" + map.get(o).getType() + "]" + map.get(o).getName() + "." + funcName +"(" + param +")");

    }
    public static void exit(Object o, String funcName, Object returnValue){
        if(!enabled) return;

        depth--; //ha valaki belép, csökkentenünk kell a mélységet
        String tab="";
        for (int i=0; i<depth; i++){
            tab+="  ";
        }

        /**
         * Visszatérési értékből String
         */
        String retVal = "";
        if(returnValue != null){
            if(map.containsKey(returnValue))
                retVal = "["+map.get(returnValue).getType()+"]"+map.get(returnValue).getName();
            else
                retVal = returnValue.toString();
        }

        /**
         * Kiírás
         */
        System.out.println(tab+"<- "+"["+map.get(o).getType()+"]"+map.get(o).getName()+"."+funcName+"("+")"+(retVal.equals("") ? "" : ("  [" + retVal + "]")));

    }

    public static void enable() {enabled = true;}
    public static void disable() {enabled = false;}
}
