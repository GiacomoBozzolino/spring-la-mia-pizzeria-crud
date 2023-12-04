package org.java.spring.db.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 20)
	@Length(min = 3, max = 20, message = "Nome must be between 3 and 20 characters")
	
	private String nome;
	
	@Column(columnDefinition = "TEXT")
	@Length(min = 3, message = "Desrizone must be longer then 3 characters")
	private String descrizione;
	
	@Length(min = 3, message = "Foto must be longer then 3 characters")
	@URL()
	private String foto;
	
	@Positive(message = "value must be positive and 2 digits")
	private double prezzo;
	
	
	public Pizza() {}
	public Pizza(String nome, String descrizione, String foto, double prezzo) {
		setNome(nome);
		setDescrizione(descrizione);
		setFoto(foto);
		setPrezzo(prezzo);	
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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getPrezzoFormattato() {
		return String.format("%.2f", getPrezzo()) + "€";
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getNome() + " - " 
				+ getDescrizione() + " (" + getPrezzo() + ")";
	}
	
	
	
	
	
	
	
	
}
