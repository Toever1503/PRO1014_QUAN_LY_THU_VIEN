/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author haunv
 *
 */
public class DOTENV {
    public static Dotenv getEnv(String file){ // method to get .env file return null if file not found else Dotenv object
        Dotenv dotenv = Dotenv.configure().filename(file).ignoreIfMissing().ignoreIfMalformed().load();
        if(dotenv == null) return null;
        return dotenv;
    }
}
