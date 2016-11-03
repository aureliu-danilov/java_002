public class rnd_value {
  public double[][] valori(int nr_rows, int nr_cols, double a_rnd, double b_rnd, int decimal_part) {
    double[][] matrix_ = null;
    if((nr_rows>=0)&&(nr_cols>=0)&&(decimal_part>=0)){
      matrix_ = new double[nr_rows][nr_cols];
      double d = Math.pow(10, decimal_part);
      for (int i=0; i<nr_rows; i++) {
        for (int j=0; j<nr_cols; j++) {
          matrix_[i][j]=(double)((long)Math.round((a_rnd+(b_rnd-a_rnd)*Math.random())*d)/d);
          //matrix_[i][j]=(a_rnd+(b_rnd-a_rnd)*Math.random());
        }
      }
      return matrix_;
    }
    else
    {
      return null;
    }
  }//valori
}//class rnd_value 
