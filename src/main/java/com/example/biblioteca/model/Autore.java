package com.example.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autore")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Autore implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idautore; 

	@OneToMany(mappedBy = "autore")
	private Set<Libro> libri=new HashSet<>();
	
	@NotBlank
	@Column(nullable = false)
	private String nomeecog;
	@Column(nullable = false)
	private String luogonascita;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@CreatedDate
	@NotBlank
	private Date datanasc;
	@Column(nullable = false)
	private String luogomorte;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date datamort;
	@JsonIgnoreProperties
	@OneToMany(mappedBy="autore")
	private Set<Libro> libro;
	public Long getIdautore() {
		return idautore;
	}
	public void setIdautore(Long idautore) {
		this.idautore = idautore;
	}
	public String getNomeecog() {
		return nomeecog;
	}
	public void setNomeecog(String nomeecog) {
		this.nomeecog = nomeecog;
	}
	public String getLuogonascita() {
		return luogonascita;
	}
	public void setLuogonascita(String luogonascita) {
		this.luogonascita = luogonascita;
	}
	public Date getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}
	public String getLuogomorte() {
		return luogomorte;
	}
	public void setLuogomorte(String luogomorte) {
		this.luogomorte = luogomorte;
	}
	public Date getDatamort() {
		return datamort;
	}
	public void setDatamort(Date datamort) {
		this.datamort = datamort;
	}
 }





