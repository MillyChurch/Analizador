
package analisador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Millychurch
 */
public class Analisador {

    public static String lerCodigo(String path) throws FileNotFoundException{
        
        String codigo="";

            File file = new File(path);
            Scanner scanner = new Scanner(file);      
            while(scanner.hasNextLine()){
                codigo += scanner.nextLine()+"\n";
            }
        
        return codigo;
    }
    
    public static int ifor(String[] codigoCortado, int inicio){
        
            for(int i=inicio; i < codigoCortado.length; i++){
                
                if (codigoCortado[i].equals("for")){
                    return 1 + ifor(codigoCortado,i+1);
                }
                
                else if (codigoCortado[i].equals("//")){
                }
                
                else if (codigoCortado[i].equals("}")){
                    return 0;
                }

            } 
            
        return 0;
    }
    
    public static int ifor(String[] codigoCortado){
        
        int contNTemp=0;
        int contN=0;
        
        for(int i=0; i < codigoCortado.length; i++){
                
                if (codigoCortado[i].equals("for")){
                    contNTemp = ifor(codigoCortado, i);
                }
                
                if(contNTemp>contN){
                    contN=contNTemp;
                }
                
        }  
        return contN;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        
        String codigo = lerCodigo("Codigo.txt");
        codigo = codigo.trim().replaceAll("\\s+", " ");
        String[] codigoCortado = codigo.split(" ");
        int contN = 0 ;
        
        if(ifor(codigoCortado)==1){
            System.out.println("N");
        }
        else if(ifor(codigoCortado)>1){
            System.out.println("N^"+ifor(codigoCortado));
        }
        else{
            System.out.println("Não depende das entradas");
        }
        
        
        	long inicio = System.nanoTime();
                Thread.sleep(3000);
                long duracao = (System.nanoTime() - inicio)/1000000;
                System.out.println("tempo de exeucução do programa: " + duracao + "ms");
        
    }
}
