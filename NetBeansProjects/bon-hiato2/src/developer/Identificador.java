/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developer;

/**
 *
 * @author yonay
 */
public class Identificador {
    private int id;
    public Identificador(int id){
        this.id=id;
    }
    public int getId(){
        id++;
        return id;
    }
}
