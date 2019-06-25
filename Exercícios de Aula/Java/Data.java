class Data {
	private int dia;
  private int mes;
  private int ano;

	public Data (int dia, int mes, int ano){
    setData (dia, mes, ano);
  }


  public void setData(int dia, int mes, int ano) {
    int diasmes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if (mes > 0 && mes < 13) {
 	     this.mes = mes;
 	     // validando o dia de acordo com o mes
 	     if (dia > 0 && dia <= diasmes[mes+1]){
 		      this.dia = dia;
 	     } else {
 		      System.out.println("Dia inválido");
 		      this.dia = 1;
 	     }

    } else {
          System.out.println("Mês inválido");
 	        this.mes = 1;
    }

     if (ano > 0){
 	     this.ano = ano;

    } else {
 	     System.out.println("Ano inválido");
 	     this.ano = 1900;
    }
  }

  public String getData () {
    return this.dia + "/" + this.mes + "/" + this.ano;
  }

  public static Data somarDias (Data data, int dias) {
    if (dias + data.dia > 31) {
      data.dia = data.dia + dias - 31;

      if (data.mes + 1 > 12) {
        data.mes = 1;
        data.ano += 1;
      } else {
        data.mes += 1;
      }
    } else {
      data.dia += dias;
    }


    return new Data(data.dia, data.mes, data.ano);
  }
}
