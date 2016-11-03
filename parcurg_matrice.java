public class parcurg_matrice {
  public double[] MatriceInVector(double[][] a) {
    int nr_rows = a.length;
    int nr_cols = a[0].length;
    int n= nr_rows*nr_cols;
    double[] vector = null;
    vector = new double[n];
    int k=0;
    for (int i=0; i<nr_rows; i++) {
      for (int j=0; j<nr_cols; j++) {
        vector[k]=a[i][j];
        k++;
      }
    }
    return vector;
  }//matrice in vector
  public double[] DiagonalaPrincipala(double[][] a) {//diagonala principala
    int nr_rows = a.length;
    int nr_cols = a[0].length;
    double[] vector = null;
    if((nr_rows>0) && (nr_rows==nr_cols)){
      vector = new double[nr_cols];
      int k=0;
      for (int i=0; i<nr_cols; i++) {
        vector[k]=a[i][i];
        k++;
      }
    }
    return vector;
  }//diagonala principala
  public double[] DiagonalaSecundara(double[][] a) {//diagonala secundara
    int nr_rows = a.length;
    int nr_cols = a[0].length;
    double[] vector = null;
    if((nr_rows>0) && (nr_rows==nr_cols)){
      vector = new double[nr_cols];
      int k=0;
      for (int i=0; i<nr_cols; i++) {
        vector[k]=a[(nr_cols-1)-i][i];
        k++;
      }
    }
    return vector;
  }//diagonala secundara
  public double[] SarpeSubDiagPrAsc(double[][] a){//Sarpe Sub Diagonala Principala, ascendent
    int nr_rows = a.length;
    int nr_cols = a[0].length;
    double[] vector = null;
    if((nr_rows>0) && (nr_rows==nr_cols)){
      //numar elemente sub diagonala principala (inclusiv diagonala)
      int vector_nr_cols= nr_rows*(nr_rows-1)/2+nr_rows;
      vector = new double[vector_nr_cols];
      int k=0;
      for (int j=0; j<nr_cols; j++) {
        for (int i=0; i<nr_cols-j; i++) {
          if(j%2==0){
            vector[k]=a[i+j][i];
          }else{
            vector[k]=a[(nr_cols-1)-i][(nr_cols-1)-(i+j)];
          }
          k++;
        }
      } // sub matrici patrate
      System.out.print("\n ");
    }
    return vector;
  }//Sarpe Sub Diagonala Principala, ascendent
  public double[] SarpeSubDiagPrDes(double[][] a){//Sarpe Sub Diagonala Principala, descendent
    int nr_rows = a.length;
    int nr_cols = a[0].length;
    double[] vector = null;
    if((nr_rows>0) && (nr_rows==nr_cols)){
      //numar elemente sub diagonala principala (inclusiv diagonala)
      int vector_nr_cols= nr_rows*(nr_rows-1)/2+nr_rows;
      vector = new double[vector_nr_cols];
      int k=0;
      for (int j=nr_cols-1; j>=0; j--) {
        for (int i=(nr_cols-1)-j; i>=0; i--) {
          if(j%2==0){
            vector[k]=a[i+j][i];
          }else{
            vector[k]=a[(nr_cols-1)-i][(nr_cols-1)-(i+j)];
          }
          k++;
        }
      } // sub matrici patrate
      System.out.print("\n ");
    }
    return vector;
  }//Sarpe Sub Diagonala Principala, descendent
  public double[] SarpeSubDiagSeAsc(double[][] a){//Sarpe Sub Diagonala Secundara, ascendent
    int nr_rows = a.length;
    int nr_cols = a[0].length;
    double[] vector = null;
    if((nr_rows>0) && (nr_rows==nr_cols)){
      //numar elemente sub diagonala principala (inclusiv diagonala)
      int vector_nr_cols= nr_rows*(nr_rows-1)/2+nr_rows;
      vector = new double[vector_nr_cols];
      int k=0;
      for (int j=0; j<nr_cols; j++) {
        for (int i=0; i<nr_cols-j; i++) {
          if(j%2==0){
            vector[k]=a[((nr_cols-1)-i)][i+j]; 
          }else{
            vector[k]=a[i+j][((nr_cols-1)-i)]; 
          }
          k++;
        }
      } // sub matrici patrate
      System.out.print("\n ");
    }
    return vector;
  }//Sarpe Sub Diagonala Secundara, ascendent
}//class rnd_value 
