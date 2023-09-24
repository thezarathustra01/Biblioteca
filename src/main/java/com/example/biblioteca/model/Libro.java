package com.example.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "libro")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Libro implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idlibro;
	@NotBlank
	@Column(nullable = false, updatable = false)
	private String titolo;
	@Column(nullable = false, updatable = false)
	private String autore;
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	@CreatedDate
	@NotBlank
	private Date datapubli;
	@Column(nullable = false, updatable = false)
	private double prezzo;
	@Column(nullable = false, updatable = false)
	private int ncopie;
	@NotBlank
	private Long idAut;
	@JoinColumn(name = "idAut", referencedColumnName="autore",nullable = false)
	private Autore autor; 
	public Long getIdlibro() {
		return idlibro;
	}
	public void setIdlibro(Long idlibro) {
		this.idlibro = idlibro;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public Date getDatapubli() {
		return datapubli;
	}
	public void setDatapubli(Date datapubli) {
		this.datapubli = datapubli;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getNcopie() {
		return ncopie;
	}
	public void setNcopie(int ncopie) {
		this.ncopie = ncopie;
	}
 }

