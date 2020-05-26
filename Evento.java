package qintess.com.Desafio.Entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import qintess.com.Desafio.Entidades.CasaDeShow;
import qintess.com.Desafio.Entidades.CompraEvento;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int qtdIngressos;

	private String nome;

	private BigDecimal valorUnitario;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtEvento;

	private String descricao;

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CompraEvento> compras = new ArrayList<CompraEvento>();

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("casaDeShowId")
	private CasaDeShow casaDeShow;

	public List<CompraEvento> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraEvento> compras) {
		this.compras = compras;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdIngressos() {
		return qtdIngressos;
	}

	public void setQtdIngressos(int qtdIngressos) {
		this.qtdIngressos = qtdIngressos;
	}

	public LocalDate getDtEvento() {
		return dtEvento;
	}

	public void setDtEvento(LocalDate dtEvento) {
		this.dtEvento = dtEvento;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", qtdIngressos=" + qtdIngressos + ", nome=" + nome + ", valorUnitario="
				+ valorUnitario + ", imagemProd=" + ", imagemEncoded=" + ", dtEvento=" + dtEvento + ", descricao="
				+ descricao + "]";
	}

}
