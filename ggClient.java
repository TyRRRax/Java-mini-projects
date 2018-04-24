/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sieciowo;

/**
 *
 * @author student
 */
public class ggClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           
    	   TaskClassServer server = new TaskClassServer();
           TaskClassClient client = new TaskClassClient();
           Thread threadC = new Thread(client);
           Thread threadS = new Thread(server);
           threadC.start();
           threadS.start();
           
    }
    
}
