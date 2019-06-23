class Pessoa {
  private String nome;
  private String cpf;
  private String sexo;
  private Data nascimento;

  public Pessoa (String nome, String cpf, String sexo, int dia, int mes, int ano) {
    this.nascimento = new Data(dia, mes, ano);
    setNome(nome);
    setCpf(cpf);
    setSexo(sexo);

  }

  public void setNome (String nome) {
    this.nome = nome;
  }

  public void setCpf (String cpf) {
    this.cpf = cpf;
  }

  public void setSexo (String sexo) {
    this.sexo = sexo;
  }

  public String getNome () {
    return nome;
  }

  public String getCpf () {
    return cpf;
  }

  public String getSexo () {
    return sexo;
  }

  public String getNascimento () {
    return nascimento.getData();
  }

  public void apresentarPessoa () {
    System.out.println(this.getNome());
    System.out.println(this.getCpf());
    System.out.println(this.getNascimento());
    System.out.println(this.getSexo());
  }

}
