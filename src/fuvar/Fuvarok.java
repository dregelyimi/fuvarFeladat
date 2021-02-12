
package fuvar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fuvarok {

    
    public static void main(String[] args) throws IOException, ParseException {
        List<String> sorok = Files.readAllLines(Paths.get("fuvar.csv"));
        ArrayList<Fuvar> fuvarok = new ArrayList<>();
        for (int i = 1; i < sorok.size(); i++) {
            String sor = sorok.get(i);
            fuvarok.add(new Fuvar(sor));
        }
        
        //3. feladat
        System.out.printf("3. feladat: %s fuvar\n", fuvarok.size());
        
        //4. feladat
        int db = 0;
        double osszeg = 0.0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getId() == 6185) {
                db++;
                osszeg += fuvarok.get(i).getDij();
            }
        }
        System.out.printf("4. feladat: %d fuvar alatt %.2f$\n", db, osszeg);
        
        //5.feladat
        HashMap<String, Integer> fizMod = new HashMap<>();
        for (Fuvar fuvar : fuvarok) {
            String kulcs = fuvar.getFizMod();
            if (!fizMod.containsKey(kulcs)) {
                fizMod.put(kulcs, 1);
            }else {
                int ertek = fizMod.get(kulcs);
                fizMod.put(kulcs, ++ertek);
            }
        }
        
        for (Map.Entry<String, Integer> entry : fizMod.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("\t%s: %d fuvar\n", key, value);
        }
        
        //6. feladat
        double osszTav = 0.0;
        for (Fuvar fuvar : fuvarok) {
            osszTav += fuvar.getTavolsag();
        }
        osszTav = osszTav*1.6;
        System.out.printf("6. feladat: %.2fkm\n", osszTav);
        
        //7.feladat
        int max = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getIdotartam() > fuvarok.get(max).getIdotartam()) {
                max = i;
            }
        }
        System.out.println(fuvarok.get(max));
        
        //8. feladat
        System.out.println("A hibak.txt elkészült");
        StringBuilder sb = new StringBuilder();
        for (Fuvar fuvar : fuvarok) {
            if (fuvar.getIdotartam() != 0 && fuvar.getDij() != 0.0 && fuvar.getTavolsag() == 0 ) {
                sb.append(fuvar.getId()+";");
                sb.append(fuvar.getIndulas()+";");
                sb.append(fuvar.getIdotartam()+";");
                sb.append(fuvar.getTavolsag()+";");
                sb.append(fuvar.getDij()+";");
                sb.append(fuvar.getBorra()+";");
                sb.append(fuvar.getFizMod()+"\n");
            }
        }
        Files.write(Paths.get("hibak.txt"), sb.toString().getBytes());



        
    }
    
}
