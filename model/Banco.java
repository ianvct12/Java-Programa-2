package model;

public class Banco {
	private String cnpj;
	private String nome;
	private String codigo;

	public Banco(String cnpj, String nome, String codigo) throws ModelException {
		this.setCnpj(cnpj);
		this.setNome(nome);
		this.setCodigo(codigo);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) throws ModelException {
		validarCnpj(cnpj);
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException {
		validarNome(nome);
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws ModelException {
		validarCodigo(codigo);
		this.codigo = codigo;
	}

	public static void validarCnpj(String cnpj) throws ModelException {
		if (cnpj == null || cnpj.length() == 0)
			throw new ModelException("O Cnpj não pode ser nulo.");
		if (cnpj.length() != 18)
			throw new ModelException("O Cnpj do banco não pode ser diferente de 18 caracteres");
		for (int i = 0; i < 2; i++) { //### Podia usar switch
			char c = cnpj.charAt(i);
			if (!Character.isDigit(c))
				throw new ModelException("É necessário ter dígitos no caracter " + (i + 1));
		}
		if (cnpj.charAt(2) != '.')
			throw new ModelException("Deve conter '.' após o segundo caracter digitado. ");
		for (int i = 3; i < 6; i++) {
			char c = cnpj.charAt(i);
			if (!Character.isDigit(c))
				throw new ModelException("É necessário ter dígitos no caracter " + (i + 1));
		}
		if (cnpj.charAt(6) != '.')
			throw new ModelException("Deve conter '.' após o sexto caracter digitado.");
		for (int i = 7; i < 10; i++) {
			char c = cnpj.charAt(i);
			if (!Character.isDigit(c))
				throw new ModelException("É necessário ter dígitos no caracter " + (i + 1));
		}
		if (cnpj.charAt(10) != '/')
			throw new ModelException("Deve conter '/' após o décimo caracter digitado.");
		String mafil = cnpj.substring(11, 15);
		if (!mafil.equals("0001") && !mafil.equals("0002"))
			throw new ModelException("Após a '/' é necessário digitar 0001(matriz) ou 0002(filial)");
		if (cnpj.charAt(15) != '-')
			throw new ModelException("É necessário colocar - após o décimo quinto caracter digitado");
		for (int i = 16; i < 18; i++) {
			char c = cnpj.charAt(i);
			if (!Character.isDigit(c))
				throw new ModelException("É necessário ter dígitos no caracter " + (i + 1));
		}
	}

	public static void validarNome(String nome) throws ModelException {
		if (nome == null || nome.length() == 0)
			throw new ModelException("O nome não pode ser nulo");
		if (nome.length() > 20)
			throw new ModelException("O nome não pode ultrapassar 20 caracteres");
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("Os nomes não podem conter números.");
		}
	}

	public static void validarCodigo(String codigo) throws ModelException {
		if (codigo == null || codigo.length() == 0)
			throw new ModelException("O código não pode ser nulo");
		if (codigo.length() != 3)
			throw new ModelException("O código deve conter 3 dígitos.");
		for (int i = 0; i < 3; i++) {
			char c = codigo.charAt(i);
			if (!Character.isDigit(c))
				throw new ModelException("O código deve conter apenas dígitos");
		}
	}

	@Override
	public String toString() {
		return "Eu sou um Banco de cnpj " + cnpj + ", com o nome " + nome + ", e código " + codigo;
	}

}
