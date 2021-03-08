package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;
import com.sun.javafx.css.parser.Token;

public class AlternativeScanner extends Scanner<String,String> {


    public boolean scan(String input) {
        if(input == null || input.length() == 0){
            return false;
        } // Wenn es keinen Input gibt bzw. der Input eine Länge von Null hat dann wird false zurückgegeben
        this.tokenList = new List(); // Liste für Tokens wird initialisiert
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == 'b'){
                this.tokenList.append(new Token(input.charAt(i),"FARBE"));
            }else if(input.charAt(i) == 'g'){
                this.tokenList.append(new Token(input.charAt(i),"FARBE"));
            }else if(input.charAt(i) == 'o'){
                this.tokenList.append(new Token(input.charAt(i),"FARBE"));
            }else if(input.charAt(i) == 'r'){
                this.tokenList.append(new Token(input.charAt(i),"FARBE"));
            }else if(input.charAt(i) == 's'){
                this.tokenList.append(new Token(input.charAt(i),"FARBE"));
            }else if(input.charAt(i) == 'y'){
                this.tokenList.append(new Token(input.charAt(i),"ENTSCHEIDUNGY"));
            }else if(input.charAt(i) == 'n'){
                this.tokenList.append(new Token(input.charAt(i),"ENTSCHEIDUNGN"));
            }else if(input.charAt(i) == 'k'){
                this.tokenList.append(new Token(input.charAt(i),"KAUFEN"));
            }else if(input.charAt(i) == 'z'){
                this.tokenList.append(new Token(input.charAt(i),"NICHTKAUFEN"));
            }else return false;
        }
        this.tokenList.append(new Token("#","NODATA"));
        tokenList.toFirst(); // WICHTIG!
        return true;
    }

    // Token: Außenwand(a) Wand(w) WandmitFenster(wf) Tür(t)
    public boolean contextFreeScan(String input){
        if(input == null || input.length() == 0){
            return false;
        }
        this.tokenList = new List();
        for(int i = 0; i<input.length();i++){
            if(input.charAt(i) == 'a'){
                this.tokenList.append(new Token(input.charAt(i),"AUßENWAND"));
            }else if(input.charAt(i) == 'w'){
                if(i<input.length()-1){
                    if(input.charAt(i+1) == 'f'){
                        this.tokenList.append(new Token(input.substring(i,i+2),"WAND"));
                    }
                }else{
                    this.tokenList.append(new Token(input.charAt(i),"WAND"));
                }
            }else if(input.charAt(i) == 't'){
                this.tokenList.append(new Token(input.charAt(i),"TUER"));
            }
        }
        this.tokenList.append(new Token("#","NODATA"));
        tokenList.toFirst(); // WICHTIG!
        return true;
    }
}
