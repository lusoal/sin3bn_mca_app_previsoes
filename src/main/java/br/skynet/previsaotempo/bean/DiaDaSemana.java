package br.skynet.previsaotempo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dia_semana")
public class DiaDaSemana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(name = "dia_da_semana")
	private String diaDaSemana;
	@OneToOne(mappedBy="diaDaSemana")
	private Tempo previsaotempo;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tempo getPrevisaotempo() {
		return previsaotempo;
	}

	public void setPrevisaotempo(Tempo previsaotempo) {
		this.previsaotempo = previsaotempo;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

}
