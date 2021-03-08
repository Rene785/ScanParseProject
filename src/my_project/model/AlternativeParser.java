package my_project.model;

public class AlternativeParser implements Parser {

    private AlternativeScanner alternativeScanner;

    public AlternativeParser() {
        alternativeScanner = new AlternativeScanner();
    }

    @Override
    public boolean parse(String input) {
        int farbenDings = 0;
        if (alternativeScanner.scan(input)) {
            while(alternativeScanner.getType().equals("FARBE")) {
                alternativeScanner.nextToken();
                farbenDings++;
            }
            if(farbenDings>0 && farbenDings<6) {
                if (alternativeScanner.getType().equals("ENTSCHEIDUNGY")) {
                    alternativeScanner.nextToken();
                    if (alternativeScanner.getType().equals("KAUFEN")) {
                        alternativeScanner.nextToken();
                        if (alternativeScanner.getType().equals("NODATA")) return true;
                    }
                } else if (alternativeScanner.getType().equals("ENTSCHEIDUNGN")) {
                    alternativeScanner.nextToken();
                    if (alternativeScanner.getType().equals("NICHTKAUFEN")) {
                        alternativeScanner.nextToken();
                        if (alternativeScanner.getType().equals("NODATA")) return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean contextFreeParse(String input){
        int keller = 0;
        if(alternativeScanner.contextFreeScan(input)){
            if(alternativeScanner.getType().equals("AUßENWAND")){
                alternativeScanner.nextToken();
                while(alternativeScanner.getType().equals("WAND")){
                    alternativeScanner.nextToken();
                    keller++;
                    System.out.println(keller);
                }
                if(alternativeScanner.getType().equals("TUER")){
                    alternativeScanner.nextToken();
                    for(int i = 0; i<=keller;i++){
                        if(alternativeScanner.getType().equals("WAND")){
                            alternativeScanner.nextToken();
                            keller--;
                        }
                    }
                    System.out.println(keller);
                    if(alternativeScanner.getType().equals("AUßENWAND") && keller == 0){
                        alternativeScanner.nextToken();
                        if(alternativeScanner.getType().equals("NODATA")) return true;
                    }
                }
            }


        }
        return false;
    }

    public boolean getScannerResult(String input) {
        return alternativeScanner.scan(input);
    }

    public boolean getContextFreeScannerResult(String input){
        return alternativeScanner.contextFreeScan(input);
    }
}