
package escacsvalienteisabel;


public class EscacsValienteIsabel {

   
    public static void main(String[] args) {
       
        int files = Teclat.lligInt("Dis-me l'altura del tauler (5 al 9): ");
        
        while ((files <5) || (files > 9)) {
            System.out.println("Error, te que estar entre 5 i 9.");
            files = Teclat.lligInt("Dis-me l'altura del tauler: ");
        }
        
        int columnes = Teclat.lligInt("Dis-me lámple del tauler (entre 5 y 9): ");
        
       while ((columnes <5) || (columnes>9)) {
           System.out.println("Error, te que estar entre 5 i 9.");
           columnes = Teclat.lligInt("Dis-me lámple del tauler (entre 5 y 9): ");
            }
            char tauler [][]= new char [files+1][columnes+1];
            
            for (int columna = 1; columna < columnes+1; columna++) {
                for (int fila = 1; fila < files+1; fila++) {
                            tauler [fila][columna]= '-';
                }
            }
            
        boolean continuar = true;
        while (continuar){
        
            System.out.print("            ");
            for ( int columna = 1; columna <= columnes; columna++) {
                System.out.print( columna + " ");

            }
            System.out.println("");
            
            for (int fila = 1; fila <= files; fila++){
                System.out.print("          ");
                System.out.print(fila + " ");
                for (int columna = 1; columna <= columnes; columna++){
                    System.out.print(tauler [fila][columna]+ " ");
                }
                System.out.print(fila + " ");
                System.out.println("");
            }
            System.out.print("            ");
            for ( int columna = 1; columna <= columnes; columna++) {
                System.out.print( columna + " ");

            }
            System.out.println("");





            System.out.println(" ");
            System.out.println("Opcions:");
            System.out.println("1. Posar una peça.");
            System.out.println("2. Mostrar els moviments.");
            System.out.println("3. Esborrar moviments.");
            System.out.println("4. Esborrar tauler.");
            System.out.println("5. Eixir.");
            System.out.println("--------------------------------------------------------------");

            int opcio = Teclat.lligChar("Quina opció vols? ", "12345");
            
            switch (opcio){
                case '1':
                    char peça = Teclat.lligChar("Dis-me quina peça vols ficar: ", "TDARC");

                    int fil = Teclat.lligInt("En quina fila vols ficarla", 1, files);
                    int col = Teclat.lligInt("En quina columna vols ficarla", 1, columnes);
                    while (tauler [fil][col]=='T'||tauler [fil][col]=='D'||tauler [fil][col]=='A'||tauler [fil][col]=='R'||tauler [fil][col]=='C'){
                        System.out.println("En eixe puesto ja hi ha una peça, dis-me un altre puesto");
                        fil = Teclat.lligInt("En quina fila vols ficarla", 1, files);
                        col = Teclat.lligInt("En quina columna vols ficarla", 1, columnes);
                    }
                    tauler [fil][col]= peça;

                    break;
                case '2':
                    int filp = Teclat.lligInt("Dis-me la fila en la que se trova la peça", 1, files);
                    int colp = Teclat.lligInt("Dis-me la columna en la que se trova la peça", 1, columnes);
                    
                    switch (tauler [filp][colp]){
                        case 'T':
                            // fila de baix
                            for ( fil = filp+1; fil <= files; fil++) {
                                if (tauler [fil][colp]=='T'||tauler [fil][colp]=='D'||tauler [fil][colp]=='A'||tauler [fil][colp]=='R'||tauler [fil][colp]=='C'){
                                    break;
                                }else {
                                    tauler [fil][colp]= '*';
                                }
                                 
                            }
                            // fila de dalt
                            for (fil = filp-1; fil >= 1; fil--) {
                                if (tauler [fil][colp]=='T'||tauler [fil][colp]=='D'||tauler [fil][colp]=='A'||tauler [fil][colp]=='R'||tauler [fil][colp]=='C'){
                                    break;
                                }else {
                                    tauler [fil][colp]= '*';
                                } 
                            }
                            //fila de dreta
                            for ( col = colp+1; col <= columnes; col++) {
                                if (tauler [filp][col]=='T'||tauler [filp][col]=='D'||tauler [filp][col]=='A'||tauler [filp][col]=='R'||tauler [filp][col]=='C'){
                                    break;
                                }else {
                                    tauler [filp][col]= '*';
                                }
                                 
                            }
                            // fila de esquerra 
                            for (col = colp-1; col >= 1; col--) {
                                if (tauler [filp][col]=='T'||tauler [filp][col]=='D'||tauler [filp][col]=='A'||tauler [filp][col]=='R'||tauler [filp][col]=='C'){
                                    break;
                                }else {
                                    tauler [filp][col]= '*';
                                } 
                            }
                            break;
                        case 'A':
                            // diagonal de baix a la dreta
                            for (col = (colp+1),fil = (filp+1); col <= columnes&& fil <= files; col++, fil++){
                                if (tauler [fil][col]=='T'||tauler [fil][col]=='D'|| tauler [fil][col]=='A'||tauler [fil][col]=='R'||tauler [fil][col]=='C'){
                                    break;
                                }else {
                                    tauler [fil][col]='*';
                                }
                                
                            }
                            // diagonal de dalt a la esquerra
                            for (col = (colp-1),fil = (filp-1); col >= 1&& fil >= 1; col--, fil--){
                                if (tauler [fil][col]=='T'||tauler [fil][col]=='D'|| tauler [fil][col]=='A'||tauler [fil][col]=='R'||tauler [fil][col]=='C'){
                                    break;
                                }else {
                                    tauler [fil][col]='*';
                                }
                            }
                            // diagonal de dalt a la dreta
                            for (col = (colp+1),fil = (filp-1); col <= columnes&& fil >= 1; col++, fil--){
                                if (tauler [fil][col]=='T'||tauler [fil][col]=='D'|| tauler [fil][col]=='A'||tauler [fil][col]=='R'||tauler [fil][col]=='C'){
                                    break;
                                }else {
                                    tauler [fil][col]='*';
                                }
                            }
                            //diagonal de baix a la esquerra
                            for (col = (colp-1),fil = (filp+1); col >= 1 && fil <= files; col--, fil++){
                                if (tauler [fil][col]=='T'||tauler [fil][col]=='D'|| tauler [fil][col]=='A'||tauler [fil][col]=='R'||tauler [fil][col]=='C'){
                                    break;
                                }else {
                                    tauler [fil][col]='*';
                                }
                            }
                            break;
                        case 'D':
                            // fila de baix
                            for ( fil = filp+1; fil <= files; fil++) {
                                if (tauler [fil][colp]=='T'||tauler [fil][colp]=='D'||tauler [fil][colp]=='A'||tauler [fil][colp]=='R'||tauler [fil][colp]=='C'){
                                    break;
                                }else {
                                    tauler [fil][colp]= '*';
                                }
                                 
                            }
                            // fila de dalt
                            for (fil = filp-1; fil >= 1; fil--) {
                                if (tauler [fil][colp]=='T'||tauler [fil][colp]=='D'||tauler [fil][colp]=='A'||tauler [fil][colp]=='R'||tauler [fil][colp]=='C'){
                                    break;
                                }else {
                                    tauler [fil][colp]= '*';
                                } 
                            }
                            //fila de dreta
                            for ( col = colp+1; col <= columnes; col++) {
                                if (tauler [filp][col]=='T'||tauler [filp][col]=='D'||tauler [filp][col]=='A'||tauler [filp][col]=='R'||tauler [filp][col]=='C'){
                                    break;
                                }else {
                                    tauler [filp][col]= '*';
                                }
                                 
                            }
                            // fila de esquerra 
                            for (col = colp-1; col >= 1; col--) {
                                if (tauler [filp][col]=='T'||tauler [filp][col]=='D'||tauler [filp][col]=='A'||tauler [filp][col]=='R'||tauler [filp][col]=='C'){
                                    break;
                                }else {
                                    tauler [filp][col]= '*';
                                } 
                            }
                            
                            // diagonal de baix a la dreta
                            for (col = (colp+1),fil = (filp+1); col <= columnes&& fil <= files; col++, fil++){
                                if (tauler [fil][col]=='T'||tauler [fil][col]=='D'|| tauler [fil][col]=='A'||tauler [fil][col]=='R'||tauler [fil][col]=='C'){
                                    break;
                                }else {
                                    tauler [fil][col]='*';
                                }
                                
                            }
                            // diagonal de dalt a la esquerra
                            for (col = (colp-1),fil = (filp-1); col >= 1&& fil >= 1; col--, fil--){
                                if (tauler [fil][col]=='T'||tauler [fil][col]=='D'|| tauler [fil][col]=='A'||tauler [fil][col]=='R'||tauler [fil][col]=='C'){
                                    break;
                                }else {
                                    tauler [fil][col]='*';
                                }
                            }
                            // diagonal de dalt a la dreta
                            for (col = (colp+1),fil = (filp-1); col <= columnes&& fil >= 1; col++, fil--){
                                if (tauler [fil][col]=='T'||tauler [fil][col]=='D'|| tauler [fil][col]=='A'||tauler [fil][col]=='R'||tauler [fil][col]=='C'){
                                    break;
                                }else {
                                    tauler [fil][col]='*';
                                }
                            }
                            //diagonal de baix a la esquerra
                            for (col = (colp-1),fil = (filp+1); col >= 1 && fil <= files; col--, fil++){
                                if (tauler [fil][col]=='T'||tauler [fil][col]=='D'|| tauler [fil][col]=='A'||tauler [fil][col]=='R'||tauler [fil][col]=='C'){
                                    break;
                                }else {
                                    tauler [fil][col]='*';
                                }
                            }
                           
                            break;
                        case 'R':
                            //moviment a la dreta 
                            if (colp+1<=columnes){
                                if (!(tauler[filp][colp+1]== 'T' ||tauler[filp][colp+1]=='D' ||tauler[filp][colp+1]=='A' ||tauler[filp][colp+1]=='R'||tauler[filp][colp+1]=='C')){
                                    tauler[filp][colp+1]='*';
                                }
                                  
                            }
                            
                            //moviment a la esquerra
                            if (colp-1>=1){
                                if (!(tauler[filp][colp-1]== 'T' ||tauler[filp][colp-1]=='D' ||tauler[filp][colp-1]=='A' ||tauler[filp][colp-1]=='R'||tauler[filp][colp-1]=='C')){
                                    tauler[filp][colp-1]='*';
                                }
                                 
                            }
                            
                            //moviment cap a baix 
                            if (filp+1<=files){
                                if (!(tauler[filp+1][colp]=='T'||tauler[filp+1][colp]=='D'||tauler[filp+1][colp]=='A'||tauler[filp+1][colp]=='R'||tauler[filp+1][colp]=='C')){
                                    tauler[filp+1][colp]='*';
                                }
                                 
                            }
                            
                            //moviment cap a dalt
                            if (filp-1>=1){
                                if (!(tauler[filp-1][colp]=='T'||tauler[filp-1][colp]=='D'||tauler[filp-1][colp]=='A'||tauler[filp-1][colp]=='R'||tauler[filp-1][colp]=='C')){
                                    tauler[filp-1][colp]='*';
                                }
                                  
                            }
                            
                            //Diagonal de dalt a la dreta
                            if (filp-1>=1 && colp+1<=columnes){
                                if (!(tauler[filp-1][colp+1]=='T'||tauler[filp-1][colp+1]=='D'||tauler[filp-1][colp+1]=='A'||tauler[filp-1][colp+1]=='R'||tauler[filp-1][colp+1]=='C')){
                                    tauler[filp-1][colp+1]='*';
                                }
                                
                            }
                            
                            //diagonal de dalt a la esquerra
                            if (filp-1>=1 && colp-1>=1){
                                if (!(tauler[filp-1][colp-1]=='T'||tauler[filp-1][colp-1]=='D'||tauler[filp-1][colp-1]=='A'||tauler[filp-1][colp-1]=='R'||tauler[filp-1][colp-1]=='C')){
                                    tauler[filp-1][colp-1]='*';
                                }
                                
                            }
                            
                            //diagonal de baix a la dreta 
                            if (filp+1<=files && colp+1<=columnes){
                                if (!(tauler[filp+1][colp+1]=='T'||tauler[filp+1][colp+1]=='D'||tauler[filp+1][colp+1]=='A'||tauler[filp+1][colp+1]=='R'||tauler[filp+1][colp+1]=='C')){
                                    tauler[filp+1][colp+1]='*';
                                }
                                
                            }
                            
                            //diagonal de baix a la esquerra
                            if (filp+1<=files && colp-1>=1){
                                if (!(tauler[filp+1][colp-1]=='T'||tauler[filp+1][colp-1]=='D'||tauler[filp+1][colp-1]=='A'||tauler[filp+1][colp-1]=='R'||tauler[filp+1][colp-1]=='C')){
                                    tauler[filp+1][colp-1]='*';
                                }
                                
                            }
                            
                            break;
                        case 'C':
                            //moviments dalt a la dreta
                            if (filp-2>=1 && colp+1<=columnes){
                                if (!(tauler[filp-2][colp+1]=='T'||tauler[filp-2][colp+1]=='D'||tauler[filp-2][colp+1]=='A'||tauler[filp-2][colp+1]=='R'||tauler[filp-2][colp+1]=='C')){
                                    tauler[filp-2][colp+1]='*';
                                }
                                
                            }
                            if (filp-1>=1 && colp+2<=columnes){
                                if (!(tauler[filp-1][colp+2]=='T'||tauler[filp-1][colp+2]=='D'||tauler[filp-1][colp+2]=='A'||tauler[filp-1][colp+2]=='R'||tauler[filp-1][colp+2]=='C')){
                                    tauler[filp-1][colp+2]='*';
                                }
                                
                            }
                            
                            //moviments dalt a la esquerra
                            if (filp-2>=1 && colp-1>=1){
                                if (!(tauler[filp-2][colp-1]=='T'||tauler[filp-2][colp-1]=='D'||tauler[filp-2][colp-1]=='A'||tauler[filp-2][colp-1]=='R'||tauler[filp-1][colp+2]=='C')){
                                    tauler[filp-2][colp-1]='*';
                                }
                                
                            }
                            if (filp-1>=1 && colp-2>=1){
                                if (!(tauler[filp-1][colp-2]=='T'||tauler[filp-1][colp-2]=='D'||tauler[filp-1][colp-2]=='A'||tauler[filp-1][colp-2]=='R'||tauler[filp-1][colp-2]=='C')){
                                    tauler[filp-1][colp-2]='*';
                                }
                                
                            }
                            
                            //moviments baix a la dreta
                            if (filp+2<=files && colp+1<=columnes){
                                if (!(tauler[filp+2][colp+1]=='T'||tauler[filp+2][colp+1]=='D'||tauler[filp+2][colp+1]=='A'||tauler[filp+2][colp+1]=='R'||tauler[filp+2][colp+1]=='C')){
                                    tauler[filp+2][colp+1]='*';
                                }
                                
                            }
                            if (filp+1<=files && colp+2<=columnes){
                                if (!(tauler[filp+1][colp+2]=='T'||tauler[filp+1][colp+2]=='D'||tauler[filp+1][colp+2]=='A'||tauler[filp+1][colp+2]=='R'||tauler[filp+1][colp+2]=='C')){
                                    tauler[filp+1][colp+2]='*';
                                }
                                
                            }
                            
                            //moviments baix a la esuqerra
                            if (filp+2<=files && colp-1>=1){
                                if (!(tauler[filp+2][colp-1]=='T'||tauler[filp+2][colp-1]=='D'||tauler[filp+2][colp-1]=='A'||tauler[filp+2][colp-1]=='R'||tauler[filp+2][colp-1]=='C')){
                                    tauler[filp+2][colp-1]='*';
                                }
                                
                            }
                            if (filp+1<=files && colp-2>=1){
                                if (!(tauler[filp+1][colp-2]=='T'||tauler[filp+1][colp-2]=='D'||tauler[filp+1][colp-2]=='A'||tauler[filp+1][colp-2]=='R'||tauler[filp+1][colp-2]=='C')){
                                    tauler[filp+1][colp-2]='*';
                                }
                                 
                            }
                            
                            break;
                            
                    }
                    break;
                case '3':
                    int marquesBorrades = 0;
                    for (int columna = 1; columna < columnes+1; columna++) {
                        for (int fila = 1; fila < files+1; fila++) {
                            if (tauler [fila][columna]== '*'){
                                tauler[fila][columna]='-';
                                marquesBorrades += 1;
                                
                            }
                            
                        }
                    }
                    System.out.println("S'han esborrat "+marquesBorrades+" marques." );
                    System.out.println("");
                    break;
                case '4':
                    for (int columna = 1; columna < columnes+1; columna++) {
                        for (int fila = 1; fila < files+1; fila++) {
                            tauler [fila][columna]= '-';
                        }
                    }
                    break;
                case '5':
                    char pararPrograma = Teclat.lligChar("Vols eixir? (s/S per a si i un altra cosa per a no.)");
                    if (pararPrograma == 'S' || pararPrograma == 's'){
                        continuar = false;  
                    }
                    
                    break;

            }
        }
    }
    
}