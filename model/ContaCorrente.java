package model;

public class ContaCorrente {
	private String numero;
	private String diaAbertura;
	private String nomeCorrentista;
	private int saldoInicial;

	public ContaCorrente(String numero, String diaAbetura, String nomeCorrentista, int saldoInicial)
			throws ModelException {
		this.setNumero(numero);
		this.setDiaAbertura(diaAbetura);
		this.setNomeCorrentista(nomeCorrentista);
		this.setSaldoInicial(saldoInicial);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) throws ModelException {
		validarNumero(numero);
		this.numero = numero;
	}

	public String getDiaAbertura() {
		return diaAbertura;
	}

	public void setDiaAbertura(String diaAbertura) throws ModelException {
		validarDiaAbertura(diaAbertura);
		this.diaAbertura = diaAbertura;
	}

	public String getNomeCorrentista() {
		return nomeCorrentista;
	}

	public void setNomeCorrentista(String nomeCorrentista) throws ModelException {
		validarNomeCorrentista(nomeCorrentista);
		this.nomeCorrentista = nomeCorrentista;
	}

	public int getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(int saldoInicial) throws ModelException {
		validarSaldoInicial(saldoInicial);
		this.saldoInicial = saldoInicial;
	}

	public static void validarNumero(String numero) throws ModelException {
		if (numero == null || numero.length() == 0)
			throw new ModelException("O número não pode ser nulo.");
		if (numero.length() != 7)
			throw new ModelException("O número deve conter sete caracteres.");
		for (int i = 0; i < 5; i++) {
			char c = numero.charAt(i);
			if (!Character.isDigit(c))
				throw new ModelException("O cinco primeiros caracteres do número devem ser dígitos.");
		}
		if (numero.charAt(5) != '-')
			throw new ModelException("O sexto caracter do número deve conter '-' ");
		if (!Character.isDigit(numero.charAt(6)))
			throw new ModelException("O último caracter do número  deve ser número.");
	}

	public static void validarDiaAbertura(String diaAbertura) throws ModelException {
		if (diaAbertura == null || diaAbertura.length() == 0)
			throw new ModelException("O dia de abertura não pode ser nulo.");
		if (diaAbertura.length() != 10)
			throw new ModelException("O dia de abertura deve conter 10 caracteres no formato 99/99/9999");
		String strDia = diaAbertura.substring(0, 2);
		int dia;
		try {
			dia = Integer.parseInt(strDia);
		} catch (NumberFormatException nfe) {
			throw new ModelException("O dia tem que estar em números.");
		}
		if (dia < 1 || dia > 31)
			throw new ModelException("O dia tem que estar entre 01 e 31.");
		if (diaAbertura.charAt(2) != '/')
			throw new ModelException("É necessário separar o dia do mês com / ");
		String strMes = diaAbertura.substring(3, 5);
		int mes;
		try {
			mes = Integer.parseInt(strMes);
		} catch (NumberFormatException nfe) {
			throw new ModelException("O mês tem que estar em números.");
		}
		if (mes < 1 || mes > 12)
			throw new ModelException("O mês deve estar entre 01 e 12");
		if (diaAbertura.charAt(5) != '/')
			throw new ModelException("É necessário separar o mês e o ano com /.");
		String strAno = diaAbertura.substring(6, 10);
		int ano;
		try {
			ano = Integer.parseInt(strAno);
		} catch (NumberFormatException nfe) {
			throw new ModelException("O ano deve estar em números");
		}
		if (ano < 2020 || ano > 3000)
			throw new ModelException("O ano deve estar entre 2020 e 3000.");
	}

	public static void validarNomeCorrentista(String nome) throws ModelException {
		if (nome == null || nome.length() == 0)
			throw new ModelException("O nome não pode ser nulo.");
		if (nome.length() > 40)
			throw new ModelException("O nome não pode ultrapassar 40 caracteres.");
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("O nome do correntista não pode conter números.");
		}
	}

	public static void validarSaldoInicial(int saldo) throws ModelException {
		if (saldo < 0)
			throw new ModelException("O saldo não pode ser menor do que 0.");
	}

	@Override
	public String toString() {
		return "Minha Conta Corrente é de numero " + numero + ", com a data de abertura em " + diaAbertura
				+ ", meu nome é " + nomeCorrentista + ", o saldo inicial é de R$" + saldoInicial;
	}

}
