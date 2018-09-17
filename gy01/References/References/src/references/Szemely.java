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
public class Szemely {

    private String nev;
    private int eletkor;
    
    public Szemely(String nev, int eletkor) {
        this.nev = nev;
        this.eletkor = eletkor;
    }
    
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }
}
