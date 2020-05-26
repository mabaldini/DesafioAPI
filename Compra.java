package qintess.com.Desafio.Entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setCliente(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<CompraEvento> getEventos() {
		return eventos;
	}

	public void setEventos(List<CompraEvento> eventos) {
		this.eventos = eventos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Column(nullable = false, scale = 2)
	private BigDecimal valor = new BigDecimal(0);

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CompraEvento> eventos = new ArrayList<CompraEvento>();

	public void adcEv(Evento evento, int quantidade) {
		CompraEvento compraEvento = new CompraEvento(this, evento, quantidade);
		eventos.add(compraEvento);
		evento.getCompras().add(compraEvento);
		double valorCompra = this.valor.doubleValue();
		double valorEvUnit = evento.getValorUnitario().doubleValue();
		valorCompra += (valorEvUnit * quantidade);

		this.valor = new BigDecimal(valorCompra);

	}

}
