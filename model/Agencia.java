package model;

public class Agencia {
	private String codigo;
	private String bairro;
	private String cidade;
	private String uf;

	public Agencia(String codigo, String bairro, String cidade, String uf) throws ModelException {
		this.setCodigo(codigo);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setUf(uf);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws ModelException {
		validarCodigoAg(codigo); //### Seguir o padrão do nome do atributo
		this.codigo = codigo;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) throws ModelException {
		validarBairro(bairro);
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) throws ModelException {
		validarCidade(cidade);
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) throws ModelException {
		validarUf(uf);
		this.uf = uf;
	}

	public static void validarCodigoAg(String codigo) throws ModelException {
		if (codigo == null || codigo.length() == 0)
			throw new ModelException("O código não pode ser nulo");
		if (codigo.length() != 6)
			throw new ModelException("O código deve conter 6 caracteres");
		for (int i = 0; i < 4; i++) {
			char c = codigo.charAt(i);
			if (!Character.isDigit(c) && !Character.isSpaceChar(c))
				throw new ModelException("Os 4 primeiros caracteres do código devem ser dígitos!");
		}
		if (codigo.charAt(4) != '-')
			throw new ModelException("O quinto caracter do código deve conter '-' ");
		if (!Character.isDigit(codigo.charAt(5)))
			throw new ModelException("O sexto caracter do código deve conter apenas dígito. ");
	}

	public static void validarBairro(String bairro) throws ModelException {
		if (bairro == null || bairro.length() == 0)
			throw new ModelException("O bairro não pode ser nulo.");
		if (bairro.length() > 15)
			throw new ModelException("O bairro não pode ultrapassar 15 caracteres");
		for (int i = 0; i < bairro.length(); i++) {
			char c = bairro.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("O bairro não pode ter números.");
		}
	}

	public static void validarCidade(String cidade) throws ModelException {
		if (cidade == null || cidade.length() == 0)
			throw new ModelException("A cidade não pode ser nula.");
		if (cidade.length() > 20)
			throw new ModelException("A cidade não pode ultrapassar 15 caracteres");
		for (int i = 0; i < cidade.length(); i++) {
			char c = cidade.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("A cidade não pode ter números.");
		}
	}

	public static void validarUf(String uf) throws ModelException {
		if (uf == null || uf.length() == 0)
			throw new ModelException("A UF não pode ser nulo.");
		if (uf.length() != 2)
			throw new ModelException("A UF deve conter 2 caracteres");
		for (int i = 0; i < 2; i++) {
			char c = uf.charAt(i);
			if (!Character.isUpperCase(c))
				throw new ModelException("A UF deve conter 2 letras maiúsculas.");
		}
	}

	@Override
	public String toString() {
		return "Eu sou uma Agência de Código: " + codigo + ", localizada no bairro " + bairro + ", e cidade " + cidade + ", e UF " + uf;
	}
}
