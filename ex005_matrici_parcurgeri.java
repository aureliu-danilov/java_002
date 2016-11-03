//29.10.1016
// matrice parcurgeri
import java.util.Scanner;
public class ex005_matrici_parcurgeri{
  private static void matrice_afisare(double[][] a, int DecPart){
    if(a!=null){
      int nr_rows = a.length;
      int nr_cols = a[0].length;
      for (int i=0;i<nr_rows ;i++ ) {
        for (int j=0;j<nr_cols ;j++ ) {
          System.out.format("% 8."+DecPart+"f", a[i][j]);  
        }
        System.out.println();
      }
    }
    else{
      System.out.println("\nMatrice nula. Nu pot afisa!!!\n");
    }
  }
  private static void vector_afisare(double[] a, int DecPart){
    if(a!=null){
      int nr_cols = a.length;
      for (int i=0;i<nr_cols ;i++ ) {
        System.out.format("% 8."+DecPart+"f", a[i]);  
      }
    }  
    else{
      System.out.println("\nVector null. Nu pot afisa!!!\n");
    }
  }
  private static int afisare_meniu(int nr_rows, int nr_cols){
    int[] index_meniu_1 = {0, 1};
    int[] index_meniu_2 = {10, 11, 12, 13,14};
    int nr_select_menu =-1;
    Scanner vInput = new Scanner(System.in);
    System.out.println("\nMeniu");
    System.out.println("==================================");
    if(nr_rows>0 && nr_cols>0){//Orice matrice
      System.out.println(" 0. Iesire.");
      System.out.println(" 1. Matrice in vector.");
      
    }  
    if(nr_rows>0 && nr_rows==nr_cols){//matrice patrata
      System.out.println("10. Vectorul diagonala principala a unei matrici patrate.");
      System.out.println("11. Vectorul sarpe sub diagonala principala (asc).");
      System.out.println("12. Vectorul sarpe sub diagonala principala (des).");
      System.out.println("13. Vectorul diagonala secundara a unei matrici patrate.");
      System.out.println("14. Vectorul sarpe sub diagonala secundara (asc).");
    }
    System.out.println("----------------------------------");
    if(nr_rows>0 && nr_cols>0){//introduce valoare meniu
      System.out.print("Introdu numarul parcurgerii: ");
      int exist_meniu=0;
      int i=-1;
      while(exist_meniu==0){
        nr_select_menu=vInput.nextInt();//asteptare numar meniu
        for(i=0; i<index_meniu_1.length;i++){
          if(index_meniu_1[i]==nr_select_menu){ exist_meniu=1;break;}
        }
        if(exist_meniu==0 && nr_rows==nr_cols){//se verifica doar pentru matrici patrate
          for(i=0; i<index_meniu_2.length;i++){
            if(index_meniu_2[i]==nr_select_menu){ exist_meniu=1;break;}
          }
        }  
      }
    }  
    System.out.println("==================================");
    return nr_select_menu;
  }
  public static void main (String [] args){
    //scaner
    Scanner input = new Scanner(System.in);
    rnd_value obj_val = new rnd_value();
    System.out.print("Introdu numar de linii (0<n<10) = ");
    int n = input.nextInt();//numar rinduri matrice
    System.out.print("Introdu numar de coloane (0<n<10) = ");
    int m=input.nextInt();//numar coloane matrice
    int a=0;//segment valori aliatorii inceput
    int b=99;//segment valori aliatorii final
    int dec_part=0;//partea zecimala
    double[][] a_matrix = new double[n][m];
    a_matrix =  obj_val.valori(n,m,a,b,dec_part);
    int rnd=-1;
    int dPart=0;//partea zecimala la afisare
    if((n<10)&&(n>0)&&(m<10)&&(m>0)){
      System.out.println("=========Matricea initiala=========\n");
      matrice_afisare(a_matrix,dPart);
      int nrMeniu=afisare_meniu(n,m);
      parcurg_matrice obj_p = new parcurg_matrice();
      switch (nrMeniu) {
        case 0:{
          System.out.println("\nParcurgerea nu a fost selectata!!!\n");
        break;}
        case 1:{
          System.out.println("\nMatrice in vector.\n");
          double[] mVector = obj_p.MatriceInVector(a_matrix);
          vector_afisare(mVector,dPart);
        break;}
        case 10:{
          System.out.println("\nVectorul diagonala principala pentru o matrice patrata.\n");
          double[] mDiag = obj_p.DiagonalaPrincipala(a_matrix);
          vector_afisare(mDiag,dPart);
        break;}
        case 11:{
          System.out.println("\nVectorul sarpe sub diagonala principala (asc).\n");
          double[] mDiag = obj_p.SarpeSubDiagPrAsc(a_matrix);
          vector_afisare(mDiag,dPart);
        break;}
        case 12:{
          System.out.println("\nVectorul sarpe sub diagonala principala (des).\n");
          double[] mDiag = obj_p.SarpeSubDiagPrDes(a_matrix);
          vector_afisare(mDiag,dPart);
        break;}
        case 13:{
          System.out.println("\nVectorul diagonala secundara pentru o matrice patrata.\n");
          double[] mDiag = obj_p.DiagonalaSecundara(a_matrix);
          vector_afisare(mDiag,dPart);
        break;}
        case 14:{
          System.out.println("\nVectorul sarpe sub diagonala secundara (asc).\n");
          double[] mDiag = obj_p.SarpeSubDiagSeAsc(a_matrix);
          vector_afisare(mDiag,dPart);
        break;}
        default:{
          System.out.println("\nValoare nedeterminata!!!\n");
          break;
        }
      }
      obj_p=null;//zerografiem obiectul parcurgeri
    }
    else
    {
      System.out.println("Introdu dimensiune matricei CORECT (n<10) !!!");
    } 
    //destrugere obiect
    input=null;//zerografiem obiectul input
    obj_val=null;//zerografiem obiectul valori alatorii
  }
  
}