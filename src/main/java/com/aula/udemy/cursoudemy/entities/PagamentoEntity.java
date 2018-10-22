package com.aula.udemy.cursoudemy.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.aula.udemy.cursoudemy.constants.enums.EstadoPagamentoEnum;

@Entity(name="TBL_PAGAMENTO")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PagamentoEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PAGAMENTO")
	private Integer idPagamento;
	
	private Integer estado;
	
	@OneToOne
	@JoinColumn(name="id_pedido")
	@MapsId
	private PedidoEntity pedido;

	public PagamentoEntity() {}
	
	public PagamentoEntity(Integer idPagamento, EstadoPagamentoEnum estado, PedidoEntity pedido) {
		this.idPagamento = idPagamento;
		this.estado = estado.getCodigoEstadoPagamento();
		this.pedido = pedido;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idProduto) {
		this.idPagamento = idProduto;
	}

	public EstadoPagamentoEnum getEstado() {
		return EstadoPagamentoEnum.toEnum(estado);
	}

	public void setEstado(EstadoPagamentoEnum estado) {
		this.estado = estado.getCodigoEstadoPagamento();
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((idPagamento == null) ? 0 : idPagamento.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		PagamentoEntity other = (PagamentoEntity) obj;
		
		if (idPagamento == null) {
			
			if (other.idPagamento != null)
				return false;
			
		} else if (!idPagamento.equals(other.idPagamento)) {
			
			return false;
			
		}
		
		return true;
	}
	
}
