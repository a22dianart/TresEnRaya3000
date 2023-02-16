import java.util.Scanner;
import motor3R.*;

public class InterfaceConsola {
    public InterfaceConsola(){
        presentacionXogo();
        Xogo();
    }
    public static void main(String[] args) {
        
        new InterfaceConsola();
        new TresEnRaya();
        
    }

    
    public void presentacionXogo(){
        System.out.println("************XOGO DE TRES EN RAYA*************");
        System.out.println("");
    }

    public void Xogo(){
        char simboloPersoa; 
        simboloPersoa=elixirNivel(); 
        xogada(simboloPersoa);
    }
    public char elixirNivel(){
        char simboloPersoa=0; //simbolo por defecto
        Scanner sc = new Scanner(System.in);

        System.out.println("Elixe un nivel:");
        System.out.println("1) Simple");
        System.out.println("2) Intermedio");
        System.out.println("3) Difícil");

        int nivel = sc.nextInt();
        if (nivel==1){simboloPersoa= elixirSimbolo();}
        else if (nivel==2){porFacer();}
        else if(nivel==3){porFacer();}
        else{outroNivel();}
        return (simboloPersoa);
    }

    public void porFacer(){
        System.out.println("Este nivel aínda non está feito, probar con outro");
        elixirNivel();
    }

    public void outroNivel(){
        System.out.println("Tes que elixir entre 1, 2 e 3");
        elixirNivel();
    }
    public char elixirSimbolo(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Elixiches xogar ao 3 en raya contra CPU version simple");

        System.out.println("Elixe ser O ou X");
        char simbolo = sc.next().charAt(0);
        if (simbolo=='O'){
            System.out.println("Elixiches ser o O");
        }
        else if(simbolo=='X'){
            System.out.println("Elixiches ser o X");
        }
        System.out.println("");
        System.out.println("Este é o tableiro que se vai a usar: ");
        System.out.println("  1  2  3");
        System.out.println("1( )( )( )");
        System.out.println("2( )( )( )");
        System.out.println("3( )( )( )");
        return (simbolo);
    }
     //********************************************************
    public void xogada(char simboloPersoa){
        char simboloCPU=' ';
        if (simboloPersoa=='X'){
            simboloCPU='O';
        }
        else if (simboloPersoa=='O'){
            simboloCPU='X';
        }
        Boolean continuar= true;
        Scanner sc =new Scanner(System.in);
        System.out.println("");
        TresEnRaya TresEnRaya= new TresEnRaya();
        while(continuar){
            System.out.println("Indica por fila e columna onde queres poñer a ficha");
            System.out.println("Por exemplo, para poñela na fila 2 e columna 3 habería que inserir:2 3");
            int fila = sc.nextInt();
            int columna= sc.nextInt();
            char[][]tableiro= TresEnRaya.setTableiro(fila-1, columna-1, simboloPersoa);

            imprimirTableiro(tableiro);

            if (TresEnRaya.haiTres(tableiro, simboloCPU, simboloPersoa)==true){break;}
            
            if(TresEnRaya.tableiroCompleto(tableiro)==true){
                System.out.println("Tableiro completo");
                break;
            }
            tableiro=TresEnRaya.xogadaCPU(tableiro, simboloCPU);
            if (TresEnRaya.haiTres(tableiro, simboloCPU, simboloPersoa)==true){break;}

            imprimirTableiro(tableiro);

            if(TresEnRaya.tableiroCompleto(tableiro)==true){
                System.out.println("Tableiro completo");
                break;
            }

        }
        


    }

    public void imprimirTableiro(char[][]tableiro){
        System.out.println("");
        System.out.println("O tableiro quedaría así: ");
        System.out.println("  1  2  3");
        System.out.println("1("+tableiro[0][0]+")("+tableiro[0][1]+")("+tableiro[0][2]+")");
        System.out.println("2("+tableiro[1][0]+")("+tableiro[1][1]+")("+tableiro[1][2]+")");
        System.out.println("3("+tableiro[2][0]+")("+tableiro[2][1]+")("+tableiro[2][2]+")");
    }
}      
