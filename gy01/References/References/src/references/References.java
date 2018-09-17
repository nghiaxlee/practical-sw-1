/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package references;

/**
 *
 * @author pinter
 */
public class References {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Szemely sz1 = new Szemely("Peter", 12);
        System.out.println("sz1 neve: " + sz1.getNev());
        Szemely sz2 = new Szemely("Adam", 34); // sz1 es sz2 referenciak, amik objektumokra mutatnak
        System.out.println("sz2 neve: " + sz2.getNev());
        valtoztat(sz2);
        System.out.println("sz2 neve a valtoztat fuggveny hivasa utan megvaltozott: " + sz2.getNev());
        int i = 2; // i primitiv egesz tipusu
        System.out.println("i erteke: " + i);
        vint(i);
        System.out.println("i erteke a vint fuggveny hivasa utan nem valtozott meg: " + i);
        i = vint2(i);
        System.out.println("i erteket visszateresi ertek segitsegevel lehet megvaltoztatni, most i = " + i);
        sz1 = sz2; // sz1 referencia most mar az sz2 objektumara mutat
        sz2 = null; // sz2 nem mutat sehova
        System.out.println("sz1 mar sz2 objektumara mutat, igy sz1.getNev() = " + sz1.getNev());
    }
    
    public static void valtoztat(Szemely sz) {
        sz.setNev("Marcell");
    }
    
    public static void vint(int i) {
        i = i + 6;
    }
    
    public static int vint2(int i) {
        return i + 6;
    }
    
}
