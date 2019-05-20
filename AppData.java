class AppData {
  public static void main(String args[]) {
    Data dataNascimento = new Data(24, 9, 2000);

    System.out.println(dataNascimento.getData());

    Pessoa pessoa = new Pessoa("Lucas", "01568275064", "Helicoptero de Combate, X-42", 24, 2, 2000);
    pessoa.apresentarPessoa();


    Data aaa = Data.somarDias(dataNascimento, 10);
    System.out.println(aaa.getData());
  }
}
